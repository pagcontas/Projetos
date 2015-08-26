package com.mycompany.controleestoque.mb.controleacesso;

import com.mycompany.controleestoque.bo.controleacesso.PermissaoBO;
import com.mycompany.controleestoque.modelo.controleacesso.Permissao;
import java.io.Serializable;
import com.xpert.core.crud.AbstractBaseBean;
import com.xpert.core.crud.AbstractBusinessObject;
import com.xpert.faces.utils.FacesMessageUtils;
import com.xpert.faces.utils.FacesUtils;
import com.xpert.i18n.XpertResourceBundle;
import com.xpert.persistence.exception.DeleteException;
import com.xpert.persistence.query.Restriction;
import java.util.List;
import javax.ejb.EJB;
import javax.faces.bean.ManagedBean;
import javax.faces.bean.ViewScoped;

/**
 *
 * @author Ayslan
 */
@ManagedBean
@ViewScoped
public class PermissaoMB extends AbstractBaseBean<Permissao> implements Serializable {

    @EJB
    private PermissaoBO permissaoBO;

    @Override
    public AbstractBusinessObject getBO() {
        return permissaoBO;
    }
    
    @Override
    public void postSave() {
        if (getEntity().getId() != null) {
            FacesUtils.redirect("/view/controleAcesso/permissao/listPermissao.jsf");
        } else {
            setEntity(new Permissao());
        }
    }

    @Override
    public String getDataModelOrder() {
        return "descricao";
    }

    @Override
    public List<Restriction> getDataModelRestrictions() {
        return null;
    }

    public void deleteArvore() {
        try {
            Object id = getId();
            if (getId() != null) {
                getBO().delete(id);
                FacesMessageUtils.sucess();
                id = null;
                //recarregar tree
                PerfilMB perfilMB = FacesUtils.getBeanByEl("#{perfilMB}");
                perfilMB.carregarTree();
            }
        } catch (DeleteException ex) {
            FacesMessageUtils.error(XpertResourceBundle.get("objectCannotBeDeleted"));
        }
    }
}
