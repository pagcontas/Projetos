package com.mycompany.controleestoque.mb.cadastro;


import java.io.Serializable;
import com.xpert.core.crud.AbstractBaseBean;
import javax.ejb.EJB;
import javax.faces.bean.ManagedBean;
import javax.faces.bean.ViewScoped;
import com.mycompany.controleestoque.bo.cadastro.SituacaoTributariaBO;
import com.mycompany.controleestoque.modelo.cadastro.SituacaoTributaria;
import com.xpert.faces.utils.FacesUtils;

/**
 *
 * @author juniel
 */
@ManagedBean
@ViewScoped
public class SituacaoTributariaMB extends AbstractBaseBean<SituacaoTributaria> implements Serializable {

    @EJB
    private SituacaoTributariaBO situacaoTributariaBO;

    @Override
    public SituacaoTributariaBO getBO() {
        return situacaoTributariaBO;
    }

    @Override
    public String getDataModelOrder() {
        return "id";
    }
    
    @Override
    public void postSave() {
        if (getId() != null) {
            FacesUtils.redirect("/view/cadastro/situacaoTributaria/listSituacaoTributaria.jsf");
        } else {
            setEntity(new SituacaoTributaria());
        }
    }
}
