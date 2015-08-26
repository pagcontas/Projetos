package br.com.autoescola.autoescola.bo.financeiro;

import com.xpert.core.crud.AbstractBusinessObject;
import br.com.autoescola.autoescola.dao.financeiro.PagamentoDAO;
import br.com.autoescola.autoescola.dao.financeiro.ParcelasDAO;
import com.xpert.core.validation.UniqueField;
import com.xpert.core.exception.BusinessException;
import java.util.List;
import javax.ejb.EJB;
import javax.ejb.Stateless;
import br.com.autoescola.autoescola.modelo.financeiro.Pagamento;
import br.com.autoescola.autoescola.modelo.financeiro.Parcelas;
import br.com.autoescola.autoescola.modelo.financeiro.enums.Bandeira;
import static com.xpert.Configuration.getEntityManager;
import java.math.BigDecimal;
import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.util.ArrayList;
import java.util.Calendar;
import java.util.Date;
import java.util.GregorianCalendar;
import javax.persistence.Query;

/**
 *
 * @author killerbee
 */
@Stateless
public class PagamentoBO extends AbstractBusinessObject<Pagamento> {

    @EJB
    private PagamentoDAO pagamentoDAO;

    @EJB
    private ParcelasDAO parcelas;

    @Override
    public PagamentoDAO getDAO() {
        return pagamentoDAO;
    }

    @Override
    public List<UniqueField> getUniqueFields() {
        return null;
    }

    @Override
    public void validate(Pagamento pagamento) throws BusinessException {
    }

    @Override
    public boolean isAudit() {
        return true;
    }

    @Override
    public void save(Pagamento object) throws BusinessException {
        if (object.getId() < 1) {

            if (object.getTipoPagamento() == Bandeira.AVISTA) {
                object.setQtdParcelas(1);
            }

            if (object.getDesconto() != null || object.getDesconto() == BigDecimal.ZERO) {
                object.setValor(object.getValor().subtract(object.getDesconto()));
            } else if (object.getDesconto() == null) {
                object.setDesconto(BigDecimal.ZERO);
            }
            if (object.getEntrada() != null || object.getEntrada() == BigDecimal.ZERO) {
                object.setValor(object.getValor().subtract(object.getEntrada()));
            } else if (object.getEntrada() == null) {
                object.setEntrada(BigDecimal.ZERO);
            }

            if (object.getTipoPagamento() == Bandeira.CARNE || object.getTipoPagamento() == Bandeira.AVISTA) {
                List<Parcelas> parcelas = new ArrayList<Parcelas>();
                BigDecimal valorParcela = object.getValor().divide(new BigDecimal(object.getQtdParcelas()), 2, BigDecimal.ROUND_UP);
                int cont = 1;
                Date dataTemp = new Date();
                for (int i = 1; i <= object.getQtdParcelas(); i++) {
                    Parcelas parcela = new Parcelas();
                    parcela.setParcela(cont);
                    parcela.setValor(valorParcela);
                    if (cont < 2) {
                        dataTemp = object.getDataPrimeiraParcela();
                        parcela.setDataVencimento(dataTemp);
                    } else {
                        dataTemp = somaDataUm(dataTemp);
                        parcela.setDataVencimento(dataTemp);
                    }
                    parcela.setCodigoIdenficacao(geraCodigo(object.getDataPrimeiraParcela()));
                    parcela.setPagamento(object);

                    parcelas.add(parcela);
                    cont = cont + 1;
                }
                if (object.getTipoPagamento() == Bandeira.AVISTA) {
                    parcelas.get(0).setSituacao(true);
                    parcelas.get(0).setDataPagamento(new Date());
                }
                object.setParcelas(parcelas);
            }
        }
        if (verificarQuitacao(object.getParcelas())) {
            object.setPago(true);
        } else {
            object.setPago(false);
        }

        super.save(object);
    }

    private String geraCodigo(Date date) {
        SimpleDateFormat formatter = new SimpleDateFormat("yyyyMMdd");
        Date d = date;
        String value = formatter.format(d);

        return value;
    }

    private Date somaDataUm(Date data) {

        Calendar c = Calendar.getInstance();
        c.setTime(data);

        c.set(Calendar.MONTH, c.get(Calendar.MONTH) + 1);

        return c.getTime();
    }

    public void alterarParcela(Long id, Date dataPagamento, boolean situacao) {
        String queryString = "UPDATE " + Parcelas.class.getName() + " SET situacao=?1, ";
        
        if(dataPagamento!=null){
            queryString += "datapagamento=?2";
        }else{
            queryString += "datapagamento=null";
        }
        
        Query query = null;
        queryString += " WHERE id = ?3";
        query = getEntityManager().createQuery(queryString);
        query.setParameter(1, situacao);
       
        if(dataPagamento!=null){
            query.setParameter(2, dataPagamento);
        }
        
        query.setParameter(3, id);
        query.executeUpdate();
    }

    private boolean verificarQuitacao(List<Parcelas> parcelas) {
        int cont = 0;
        for (Parcelas parcela : parcelas) {
            if (parcela.getSituacao()) {
                cont++;
            }
        }
        if (parcelas.size() != cont) {
            return false;
        } else {
            return true;
        }
    }
        
}
