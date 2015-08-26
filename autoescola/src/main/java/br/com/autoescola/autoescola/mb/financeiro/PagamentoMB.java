package br.com.autoescola.autoescola.mb.financeiro;

import java.io.Serializable;
import com.xpert.core.crud.AbstractBaseBean;
import javax.ejb.EJB;
import javax.faces.bean.ManagedBean;
import javax.faces.bean.ViewScoped;
import br.com.autoescola.autoescola.bo.financeiro.PagamentoBO;
import br.com.autoescola.autoescola.modelo.financeiro.Pagamento;
import br.com.autoescola.autoescola.modelo.financeiro.Parcelas;
import java.util.Date;

/**
 *
 * @author killerbee
 */
@ManagedBean
@ViewScoped
public class PagamentoMB extends AbstractBaseBean<Pagamento> implements Serializable {
    
    @EJB
    private PagamentoBO pagamentoBO;
    
    private Parcelas parcela;
    
    private Date dataAtual=new Date();
            
    @Override
    public PagamentoBO getBO() {
        return pagamentoBO;
    }
    
    @Override
    public String getDataModelOrder() {
        return "id";
    }
    
    public Parcelas getParcela() {
        return parcela;
    }
    
    public void setParcela(Parcelas parcela) {
        this.parcela = parcela;
    }
   
   public Date getDataAtual() {
        return dataAtual;
    }

    public void setDataAtual(Date dataAtual) {
        this.dataAtual = dataAtual;
    }  
    
    @Override
    public void init() {
        parcela = new Parcelas();
    }
    
    public void editarParcela() {
        
        if (parcela.getDataPagamento() != null) {
            parcela.setSituacao(true);
        } else if (parcela.getDataPagamento() == null && parcela.getSituacao()) {
            parcela.setDataPagamento(new Date());
        }
        
        pagamentoBO.alterarParcela(parcela.getId(), parcela.getDataPagamento(), parcela.getSituacao());
        
        parcela = new Parcelas();
    }  
    
    public void testePrint(){
        System.out.println("Teste se entrou");
    }
    
}
