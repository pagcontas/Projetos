package br.com.jsoft.centralfinanceira.mb.central;


import java.io.Serializable;
import com.xpert.core.crud.AbstractBaseBean;
import javax.ejb.EJB;
import javax.faces.bean.ManagedBean;
import javax.faces.bean.ViewScoped;
import br.com.jsoft.centralfinanceira.bo.central.UfBO;
import br.com.jsoft.centralfinanceira.modelo.central.Uf;

/**
 *
 * @author ti05
 */
@ManagedBean
@ViewScoped
public class UfMB extends AbstractBaseBean<Uf> implements Serializable {

    @EJB
    private UfBO BO;

    @Override
    public UfBO getBO() {
        return BO;
    }

    @Override
    public String getDataModelOrder() {
        return "id";
    }
}
