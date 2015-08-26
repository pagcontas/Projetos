package br.com.autoescola.autoescola.dao.financeiro;

import com.xpert.persistence.dao.BaseDAO;
import br.com.autoescola.autoescola.modelo.financeiro.Pagamento;
import br.com.autoescola.autoescola.modelo.financeiro.enums.Bandeira;
import br.com.autoescola.autoescola.vos.RelatorioPagamentoVO;
import java.util.Date;
import java.util.List;
import javax.ejb.Local;

/**
 *
 * @author killerbee
 */
@Local
public interface PagamentoDAO extends BaseDAO<Pagamento> {
    
    public List<RelatorioPagamentoVO> listPagamento(String cpf, String nome, Bandeira tipo, Date dataInicial, Date dataFinal);
    
}
