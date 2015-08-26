package br.com.jsoft.centralfinanceira.mb.central;


import java.io.Serializable;
import com.xpert.core.crud.AbstractBaseBean;
import javax.ejb.EJB;
import javax.faces.bean.ManagedBean;
import javax.faces.bean.ViewScoped;
import br.com.jsoft.centralfinanceira.bo.central.ConveniobbBO;
import br.com.jsoft.centralfinanceira.modelo.central.Conveniobb;

/**
 *
 * @author ti05
 */
@ManagedBean
@ViewScoped
public class ConveniobbMB extends AbstractBaseBean<Conveniobb> implements Serializable {

    @EJB
    private ConveniobbBO conveniobbBO;

    @Override
    public ConveniobbBO getBO() {
        return conveniobbBO;
    }

    @Override
    public String getDataModelOrder() {
        return "id";
    }
}
