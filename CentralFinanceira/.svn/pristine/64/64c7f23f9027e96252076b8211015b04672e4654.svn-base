package br.com.jsoft.centralfinanceira.mb.central;


import java.io.Serializable;
import com.xpert.core.crud.AbstractBaseBean;
import javax.ejb.EJB;
import javax.faces.bean.ManagedBean;
import javax.faces.bean.ViewScoped;
import br.com.jsoft.centralfinanceira.bo.central.ConvenioBanPopBO;
import br.com.jsoft.centralfinanceira.modelo.central.ConvenioBanPop;

/**
 *
 * @author ti05
 */
@ManagedBean
@ViewScoped
public class ConvenioBanPopMB extends AbstractBaseBean<ConvenioBanPop> implements Serializable {

    @EJB
    private ConvenioBanPopBO convenioBanPopBO;

    @Override
    public ConvenioBanPopBO getBO() {
        return convenioBanPopBO;
    }

    @Override
    public String getDataModelOrder() {
        return "id";
    }
}
