package com.mycompany.controleestoque.mb.cadastro;


import java.io.Serializable;
import com.xpert.core.crud.AbstractBaseBean;
import javax.ejb.EJB;
import javax.faces.bean.ManagedBean;
import javax.faces.bean.ViewScoped;
import com.mycompany.controleestoque.bo.cadastro.GrupoLojaBO;
import com.mycompany.controleestoque.modelo.cadastro.GrupoLoja;
import com.xpert.faces.utils.FacesUtils;

/**
 *
 * @author juniel
 */
@ManagedBean
@ViewScoped
public class GrupoLojaMB extends AbstractBaseBean<GrupoLoja> implements Serializable {

    @EJB
    private GrupoLojaBO grupoLojaBO;

    @Override
    public GrupoLojaBO getBO() {
        return grupoLojaBO;
    }

    @Override
    public String getDataModelOrder() {
        return "id";
    }
    
    @Override
    public void postSave() {
        if (getId() != null) {
            FacesUtils.redirect("/view/cadastro/grupoLoja/listGrupoLoja.jsf");
        } else {
            setEntity(new GrupoLoja());
        }
    }
}
