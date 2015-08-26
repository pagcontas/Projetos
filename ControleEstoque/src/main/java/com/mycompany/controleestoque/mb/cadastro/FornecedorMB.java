package com.mycompany.controleestoque.mb.cadastro;

import java.io.Serializable;
import com.xpert.core.crud.AbstractBaseBean;
import javax.ejb.EJB;
import javax.faces.bean.ManagedBean;
import javax.faces.bean.ViewScoped;
import com.mycompany.controleestoque.bo.cadastro.FornecedorBO;
import com.mycompany.controleestoque.modelo.cadastro.Fornecedor;
import com.xpert.faces.utils.FacesUtils;

/**
 *
 * @author juniel
 */
@ManagedBean
@ViewScoped
public class FornecedorMB extends AbstractBaseBean<Fornecedor> implements Serializable {

    @EJB
    private FornecedorBO fornecedorBO;

    @Override
    public FornecedorBO getBO() {
        return fornecedorBO;
    }

    @Override
    public String getDataModelOrder() {
        return "id";
    }

    @Override
    public void postSave() {
        if (getId() != null) {
            FacesUtils.redirect("/view/cadastro/fornecedor/listFornecedor.jsf");
        } else {
            setEntity(new Fornecedor());
        }
    }
}
