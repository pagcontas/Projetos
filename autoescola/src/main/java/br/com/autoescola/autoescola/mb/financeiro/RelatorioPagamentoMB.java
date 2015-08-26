package br.com.autoescola.autoescola.mb.financeiro;

import java.io.Serializable;
import com.xpert.core.crud.AbstractBaseBean;
import javax.ejb.EJB;
import javax.faces.bean.ManagedBean;
import javax.faces.bean.ViewScoped;
import br.com.autoescola.autoescola.bo.financeiro.PagamentoBO;
import br.com.autoescola.autoescola.dao.financeiro.PagamentoDAO;
import br.com.autoescola.autoescola.modelo.financeiro.Pagamento;
import br.com.autoescola.autoescola.vos.RelatorioPagamentoVO;
import java.math.BigDecimal;
import java.util.List;

/**
 *
 * @author killerbee
 */
@ManagedBean
@ViewScoped
public class RelatorioPagamentoMB extends AbstractBaseBean<Pagamento> implements Serializable {

    @EJB
    private PagamentoBO pagamentoBO;

    @EJB
    private PagamentoDAO pagamentoDAO;

    private List<RelatorioPagamentoVO> pagamentos;

    private List<RelatorioPagamentoVO> pagamentosFiltrados;

    private RelatorioPagamentoVO camposConsulta;

    @Override
    public PagamentoBO getBO() {
        return pagamentoBO;
    }

    @Override
    public String getDataModelOrder() {
        return "id";
    }
 
    @Override
    public void init() {
        pagamentos = pagamentoDAO.listPagamento("", "", null, null, null);
        camposConsulta = new RelatorioPagamentoVO();
    }

    public void consultarPorCampos() {
        pagamentos = pagamentoDAO.listPagamento(camposConsulta.getCpf(), camposConsulta.getAluno(), camposConsulta.getTipoPagamento(), camposConsulta.getDataInicial(), camposConsulta.getDataFinal());
    }

    public List<RelatorioPagamentoVO> getPagamentos() {
        return pagamentos;
    }

    public void setPagamentos(List<RelatorioPagamentoVO> pagamentos) {
        this.pagamentos = pagamentos;
    }

    public RelatorioPagamentoVO getCamposConsulta() {
        return camposConsulta;
    }

    public void setCamposConsulta(RelatorioPagamentoVO camposConsulta) {
        this.camposConsulta = camposConsulta;
    }

    public List<RelatorioPagamentoVO> getPagamentosFiltrados() {
        return pagamentosFiltrados;
    }

    public void setPagamentosFiltrados(List<RelatorioPagamentoVO> pagamentosFiltrados) {
        this.pagamentosFiltrados = pagamentosFiltrados;
    }

    public BigDecimal pegarTotal() {
        BigDecimal totalTemp = BigDecimal.ZERO;
        for (RelatorioPagamentoVO pagamento : getPagamentos()) {
            totalTemp = totalTemp.add(pagamento.getValor());
        }
        return totalTemp;
    }
    
    public int qtdTotal(){
        return getPagamentos().size();
    }

}
