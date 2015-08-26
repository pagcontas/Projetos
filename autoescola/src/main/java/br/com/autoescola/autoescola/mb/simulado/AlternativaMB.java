package br.com.autoescola.autoescola.mb.simulado;


import java.io.Serializable;
import com.xpert.core.crud.AbstractBaseBean;
import javax.ejb.EJB;
import javax.faces.bean.ManagedBean;
import javax.faces.bean.ViewScoped;
import br.com.autoescola.autoescola.bo.simulado.AlternativaBO;
import br.com.autoescola.autoescola.modelo.simulado.Alternativa;

/**
 *
 * @author killerbee
 */
@ManagedBean
@ViewScoped
public class AlternativaMB extends AbstractBaseBean<Alternativa> implements Serializable {

    @EJB
    private AlternativaBO alternativaBO;

    @Override
    public AlternativaBO getBO() {
        return alternativaBO;
    }

    @Override
    public String getDataModelOrder() {
        return "id";
    }
}
