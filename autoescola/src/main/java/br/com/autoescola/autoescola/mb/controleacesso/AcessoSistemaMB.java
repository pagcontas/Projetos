package br.com.autoescola.autoescola.mb.controleacesso;


import java.io.Serializable;
import com.xpert.core.crud.AbstractBaseBean;
import com.xpert.core.crud.AbstractBusinessObject;
import javax.ejb.EJB;
import javax.faces.bean.ManagedBean;
import javax.faces.bean.ViewScoped;
import br.com.autoescola.autoescola.bo.controleacesso.AcessoSistemaBO;
import br.com.autoescola.autoescola.modelo.controleacesso.AcessoSistema;

/**
 *
 * @author ayslan
 */
@ManagedBean
@ViewScoped
public class AcessoSistemaMB extends AbstractBaseBean<AcessoSistema> implements Serializable {

    @EJB
    private AcessoSistemaBO acessoSistemaBO;

    @Override
    public AbstractBusinessObject getBO() {
        return acessoSistemaBO;
    }

    @Override
    public String getDataModelOrder() {
        return "id DESC";
    }
}
