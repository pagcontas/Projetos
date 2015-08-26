package br.com.jsoft.centralfinanceira.mb.contrato;


import java.io.Serializable;
import com.xpert.core.crud.AbstractBaseBean;
import javax.ejb.EJB;
import javax.faces.bean.ManagedBean;
import javax.faces.bean.ViewScoped;
import br.com.jsoft.centralfinanceira.bo.contrato.FilhoBO;
import br.com.jsoft.centralfinanceira.modelo.contrato.Filho;

/**
 *
 * @author KillerBeeTwo
 */
@ManagedBean
@ViewScoped
public class FilhoMB extends AbstractBaseBean<Filho> implements Serializable {

    @EJB
    private FilhoBO filhoBO;

    @Override
    public FilhoBO getBO() {
        return filhoBO;
    }

    @Override
    public String getDataModelOrder() {
        return "id";
    }

    @Override
    public void postSave() {
        setEntity(new Filho());
    }
    
    
}
