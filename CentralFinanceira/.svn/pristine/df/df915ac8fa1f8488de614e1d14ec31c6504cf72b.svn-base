package br.com.jsoft.centralfinanceira.mb.central;


import java.io.Serializable;
import com.xpert.core.crud.AbstractBaseBean;
import javax.ejb.EJB;
import javax.faces.bean.ManagedBean;
import javax.faces.bean.ViewScoped;
import br.com.jsoft.centralfinanceira.bo.central.ConveniopBO;
import br.com.jsoft.centralfinanceira.modelo.central.Conveniop;

/**
 *
 * @author Juniel
 */
@ManagedBean
@ViewScoped
public class ConveniopMB extends AbstractBaseBean<Conveniop> implements Serializable {

    @EJB
    private ConveniopBO conveniopBO;

    @Override
    public ConveniopBO getBO() {
        return conveniopBO;
    }

    @Override
    public String getDataModelOrder() {
        return "id";
    }
}
