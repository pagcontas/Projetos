package com.mycompany.controleestoque.mb.cadastro;


import java.io.Serializable;
import com.xpert.core.crud.AbstractBaseBean;
import javax.ejb.EJB;
import javax.faces.bean.ManagedBean;
import javax.faces.bean.ViewScoped;
import com.mycompany.controleestoque.bo.cadastro.Loja_FilialBO;
import com.mycompany.controleestoque.modelo.cadastro.Loja_Filial;
import com.xpert.faces.utils.FacesUtils;

/**
 *
 * @author juniel
 */
@ManagedBean
@ViewScoped
public class Loja_FilialMB extends AbstractBaseBean<Loja_Filial> implements Serializable {

    @EJB
    private Loja_FilialBO loja_FilialBO;

    @Override
    public Loja_FilialBO getBO() {
        return loja_FilialBO;
    }

    @Override
    public String getDataModelOrder() {
        return "id";
    }
    
    @Override
    public void postSave() {
        if (getId() != null) {
            FacesUtils.redirect("/view/cadastro/loja_Filial/listLoja_Filial.jsf");
        } else {
            setEntity(new Loja_Filial());
        }
    }
}
