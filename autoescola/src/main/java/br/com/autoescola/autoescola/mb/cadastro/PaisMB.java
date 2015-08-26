package br.com.autoescola.autoescola.mb.cadastro;


import java.io.Serializable;
import com.xpert.core.crud.AbstractBaseBean;
import javax.ejb.EJB;
import javax.faces.bean.ManagedBean;
import javax.faces.bean.ViewScoped;
import br.com.autoescola.autoescola.bo.cadastro.PaisBO;
import br.com.autoescola.autoescola.modelo.cadastro.Pais;

/**
 *
 * @author killerbee
 */
@ManagedBean
@ViewScoped
public class PaisMB extends AbstractBaseBean<Pais> implements Serializable {

    @EJB
    private PaisBO paisBO;

    @Override
    public PaisBO getBO() {
        return paisBO;
    }

    @Override
    public String getDataModelOrder() {
        return "id";
    }
}
