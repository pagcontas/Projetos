package br.com.jsoft.centralfinanceira.mb.central;


import java.io.Serializable;
import com.xpert.core.crud.AbstractBaseBean;
import javax.ejb.EJB;
import javax.faces.bean.ManagedBean;
import javax.faces.bean.ViewScoped;
import br.com.jsoft.centralfinanceira.bo.central.TipoFloatBO;
import br.com.jsoft.centralfinanceira.modelo.central.TipoFloat;

/**
 *
 * @author Juniel
 */
@ManagedBean
@ViewScoped
public class TipoFloatMB extends AbstractBaseBean<TipoFloat> implements Serializable {

    @EJB
    private TipoFloatBO tipoFloatBO;

    @Override
    public TipoFloatBO getBO() {
        return tipoFloatBO;
    }

    @Override
    public String getDataModelOrder() {
        return "id";
    }
}
