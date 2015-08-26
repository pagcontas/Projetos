package com.mycompany.controleestoque.mb.cadastro;


import java.io.Serializable;
import com.xpert.core.crud.AbstractBaseBean;
import javax.ejb.EJB;
import javax.faces.bean.ManagedBean;
import javax.faces.bean.ViewScoped;
import com.mycompany.controleestoque.bo.cadastro.PaisBO;
import com.mycompany.controleestoque.modelo.cadastro.Pais;
import com.xpert.faces.utils.FacesUtils;

/**
 *
 * @author juniel
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
        return "nome";
    }
    
    @Override
    public void postSave() {
        if (getId() != null) {
            FacesUtils.redirect("/view/cadastro/pais/listPais.jsf");
        } else {
            setEntity(new Pais());
        }
    }
}
