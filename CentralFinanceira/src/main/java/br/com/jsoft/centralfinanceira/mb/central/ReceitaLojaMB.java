package br.com.jsoft.centralfinanceira.mb.central;


import java.io.Serializable;
import com.xpert.core.crud.AbstractBaseBean;
import javax.ejb.EJB;
import javax.faces.bean.ManagedBean;
import javax.faces.bean.ViewScoped;
import br.com.jsoft.centralfinanceira.bo.central.ReceitaLojaBO;
import br.com.jsoft.centralfinanceira.modelo.central.ReceitaLoja;

/**
 *
 * @author Juniel
 */
@ManagedBean
@ViewScoped
public class ReceitaLojaMB extends AbstractBaseBean<ReceitaLoja> implements Serializable {

    @EJB
    private ReceitaLojaBO receitaLojaBO;

    @Override
    public ReceitaLojaBO getBO() {
        return receitaLojaBO;
    }

    @Override
    public String getDataModelOrder() {
        return "id";
    }

    @Override
    public void postSave() {
        setEntity(new ReceitaLoja());
    }
    
    
}
