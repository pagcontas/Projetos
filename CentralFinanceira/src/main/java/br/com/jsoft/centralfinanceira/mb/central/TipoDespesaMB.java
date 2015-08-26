package br.com.jsoft.centralfinanceira.mb.central;


import java.io.Serializable;
import com.xpert.core.crud.AbstractBaseBean;
import javax.ejb.EJB;
import javax.faces.bean.ManagedBean;
import javax.faces.bean.ViewScoped;
import br.com.jsoft.centralfinanceira.bo.central.TipoDespesaBO;
import br.com.jsoft.centralfinanceira.modelo.central.TipoDespesa;

/**
 *
 * @author Juniel
 */
@ManagedBean
@ViewScoped
public class TipoDespesaMB extends AbstractBaseBean<TipoDespesa> implements Serializable {

    @EJB
    private TipoDespesaBO tipoDespesaBO;

    @Override
    public TipoDespesaBO getBO() {
        return tipoDespesaBO;
    }

    @Override
    public String getDataModelOrder() {
        return "id";
    }

    @Override
    public void postSave() {
        setEntity(new TipoDespesa());
    }
    
}
