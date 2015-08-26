package com.mycompany.controleestoque.mb.cadastro;


import java.io.Serializable;
import com.xpert.core.crud.AbstractBaseBean;
import javax.ejb.EJB;
import javax.faces.bean.ManagedBean;
import javax.faces.bean.ViewScoped;
import com.mycompany.controleestoque.bo.cadastro.GruposDeSecoesBO;
import com.mycompany.controleestoque.modelo.cadastro.GruposDeSecoes;
import com.xpert.faces.utils.FacesUtils;

/**
 *
 * @author juniel
 */
@ManagedBean
@ViewScoped
public class GruposDeSecoesMB extends AbstractBaseBean<GruposDeSecoes> implements Serializable {

    @EJB
    private GruposDeSecoesBO gruposDeSecoesBO;

    @Override
    public GruposDeSecoesBO getBO() {
        return gruposDeSecoesBO;
    }

    @Override
    public String getDataModelOrder() {
        return "id";
    }
    
    @Override
    public void postSave() {
        if (getId() != null) {
            FacesUtils.redirect("/view/cadastro/gruposDeSecoes/listGruposDeSecoes.jsf");
        } else {
            setEntity(new GruposDeSecoes());
        }
    }
}
