package br.com.jsoft.centralfinanceira.mb.central;


import java.io.Serializable;
import com.xpert.core.crud.AbstractBaseBean;
import javax.ejb.EJB;
import javax.faces.bean.ManagedBean;
import javax.faces.bean.ViewScoped;
import br.com.jsoft.centralfinanceira.bo.central.TipoLojaBO;
import br.com.jsoft.centralfinanceira.modelo.central.TipoLoja;

/**
 *
 * @author KillerBeeTwo
 */
@ManagedBean
@ViewScoped
public class TipoLojaMB extends AbstractBaseBean<TipoLoja> implements Serializable {

    @EJB
    private TipoLojaBO tipoLojaBO;

    @Override
    public TipoLojaBO getBO() {
        return tipoLojaBO;
    }

    @Override
    public String getDataModelOrder() {
        return "id";
    }
}
