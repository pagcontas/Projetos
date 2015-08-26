package com.mycompany.controleestoque.mb.cadastro;


import java.io.Serializable;
import com.xpert.core.crud.AbstractBaseBean;
import javax.ejb.EJB;
import javax.faces.bean.ManagedBean;
import javax.faces.bean.ViewScoped;
import com.mycompany.controleestoque.bo.cadastro.EstadoBO;
import com.mycompany.controleestoque.modelo.cadastro.Estado;
import com.xpert.faces.utils.FacesUtils;

/**
 *
 * @author juniel
 */
@ManagedBean
@ViewScoped
public class EstadoMB extends AbstractBaseBean<Estado> implements Serializable {

    @EJB
    private EstadoBO estadoBO;

    @Override
    public EstadoBO getBO() {
        return estadoBO;
    }

    @Override
    public String getDataModelOrder() {
        return "nome";
    }
    
    @Override
    public void postSave() {
        if(getId()!=null){
            FacesUtils.redirect("/view/cadastro/estado/listEstado.jsf");
        }else{
            setEntity(new Estado());
        }
    }
}
