package br.com.autoescola.autoescola.mb.financeiro;


import java.io.Serializable;
import com.xpert.core.crud.AbstractBaseBean;
import javax.ejb.EJB;
import javax.faces.bean.ManagedBean;
import javax.faces.bean.ViewScoped;
import br.com.autoescola.autoescola.bo.financeiro.ParcelasBO;
import br.com.autoescola.autoescola.modelo.financeiro.Parcelas;

/**
 *
 * @author killerbee
 */
@ManagedBean
@ViewScoped
public class ParcelasMB extends AbstractBaseBean<Parcelas> implements Serializable {

    @EJB
    private ParcelasBO parcelasBO;

    @Override
    public ParcelasBO getBO() {
        return parcelasBO;
    }

    @Override
    public String getDataModelOrder() {
        return "id";
    }
}
