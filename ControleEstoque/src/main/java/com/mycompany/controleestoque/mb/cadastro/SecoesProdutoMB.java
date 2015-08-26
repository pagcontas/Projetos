package com.mycompany.controleestoque.mb.cadastro;


import java.io.Serializable;
import com.xpert.core.crud.AbstractBaseBean;
import javax.ejb.EJB;
import javax.faces.bean.ManagedBean;
import javax.faces.bean.ViewScoped;
import com.mycompany.controleestoque.bo.cadastro.SecoesProdutoBO;
import com.mycompany.controleestoque.modelo.cadastro.SecoesProduto;
import com.xpert.faces.utils.FacesUtils;

/**
 *
 * @author juniel
 */
@ManagedBean
@ViewScoped
public class SecoesProdutoMB extends AbstractBaseBean<SecoesProduto> implements Serializable {

    @EJB
    private SecoesProdutoBO secoesProdutoBO;

    @Override
    public SecoesProdutoBO getBO() {
        return secoesProdutoBO;
    }

    @Override
    public String getDataModelOrder() {
        return "id";
    }
    
    @Override
    public void postSave() {
        if (getId() != null) {
            FacesUtils.redirect("/view/cadastro/secoesProduto/listSecoesProduto.jsf");
        } else {
            setEntity(new SecoesProduto());
        }
    }
}
