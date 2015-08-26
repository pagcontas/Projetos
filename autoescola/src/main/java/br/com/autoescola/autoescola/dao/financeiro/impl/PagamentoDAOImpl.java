package br.com.autoescola.autoescola.dao.financeiro.impl;

import br.com.autoescola.autoescola.application.BaseDAOImpl;
import br.com.autoescola.autoescola.dao.financeiro.PagamentoDAO;
import br.com.autoescola.autoescola.modelo.financeiro.Pagamento;
import br.com.autoescola.autoescola.modelo.financeiro.enums.Bandeira;
import br.com.autoescola.autoescola.vos.RelatorioPagamentoVO;
import java.math.BigDecimal;
import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.util.ArrayList;
import java.util.Date;
import java.util.List;
import java.util.logging.Level;
import java.util.logging.Logger;
import javax.ejb.Stateless;
import javax.persistence.Query;

/**
 *
 * @author killerbee
 */
@Stateless
public class PagamentoDAOImpl extends BaseDAOImpl<Pagamento> implements PagamentoDAO {

    @Override
    public List<RelatorioPagamentoVO> listPagamento(String cpf, String nome, Bandeira tipo, Date dataInicial, Date dataFinal) {
        List<RelatorioPagamentoVO> listaPagamento = new ArrayList<RelatorioPagamentoVO>();

        String queryString = "select pe.cpf, pe.nome, tipopagamento, (pa.parcela || '/' || qtdparcelas) as parcela, "
                + "pa.datapagamento, pa.valor from pagamento p inner join pessoa pe on (pe.id=p.aluno_id)"
                + "inner join parcelas pa on (pa.pagamento_id=p.id) where situacao=true";

        if (!cpf.equals("")) {
            queryString = queryString.concat(" and pe.cpf like '%" + cpf + "'");
        }

        if (!nome.equals("")) {
            queryString = queryString.concat(" and upper (pe.nome) like upper ('%" + nome + "%')");
        }

        if (tipo != null) {
            queryString = queryString.concat(" and tipopagamento=" + tipo.getNumero());
        }

        if (dataInicial != null) {
            try {
                queryString = queryString.concat(" and pa.datapagamento>='" + convertDataString(dataInicial)+"'");
            } catch (ParseException ex) {
                Logger.getLogger(PagamentoDAOImpl.class.getName()).log(Level.SEVERE, null, ex);
            }
        }

        if (dataFinal != null) {
            try {
                queryString = queryString.concat(" and pa.datapagamento<='" + convertDataString(dataFinal)+"'");
            } catch (ParseException ex) {
                Logger.getLogger(PagamentoDAOImpl.class.getName()).log(Level.SEVERE, null, ex);
            }
        }

        Query query;

        query = getEntityManager().createNativeQuery(queryString + " order by pa.datapagamento ASC");

        List<Object[]> resultado = query.getResultList();

        for (Object[] tupla : resultado) {
            RelatorioPagamentoVO pagamento = new RelatorioPagamentoVO();
            pagamento.setCpf((String) tupla[0]);
            pagamento.setAluno((String) tupla[1]);
            Bandeira valor = Bandeira.values()[(Integer) tupla[2]];
            pagamento.setTipoPagamento(valor);
            pagamento.setParcela((String) tupla[3]);
            pagamento.setPagamento((Date) tupla[4]);
            pagamento.setValor((BigDecimal) tupla[5]);

            listaPagamento.add(pagamento);
        }

        return listaPagamento;
    }

    private String convertDataString(Date date) throws ParseException {
        SimpleDateFormat in = new SimpleDateFormat("yyyy-MM-dd");
        return in.format(date);
    }

}
