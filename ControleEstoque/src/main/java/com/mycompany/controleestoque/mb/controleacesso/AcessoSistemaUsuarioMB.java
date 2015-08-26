package com.mycompany.controleestoque.mb.controleacesso;


import com.mycompany.controleestoque.bo.controleacesso.AcessoSistemaBO;
import com.mycompany.controleestoque.modelo.controleacesso.AcessoSistema;
import com.mycompany.controleestoque.util.SessaoUtils;
import java.io.Serializable;
import com.xpert.core.crud.AbstractBaseBean;
import com.xpert.core.crud.AbstractBusinessObject;
import javax.ejb.EJB;
import javax.faces.bean.ManagedBean;
import javax.faces.bean.ViewScoped;
import com.xpert.persistence.query.Restriction;
import com.xpert.persistence.query.Restrictions;
import java.util.List;

/**
 *
 * @author ayslan
 */
@ManagedBean
@ViewScoped
public class AcessoSistemaUsuarioMB extends AbstractBaseBean<AcessoSistema> implements Serializable {

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

    @Override
    public List<Restriction> getDataModelRestrictions() {
        return new Restrictions().add("usuario", SessaoUtils.getUser());
    }
    
    
}
