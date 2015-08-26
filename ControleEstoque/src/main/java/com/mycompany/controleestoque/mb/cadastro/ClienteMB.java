package com.mycompany.controleestoque.mb.cadastro;


import java.io.Serializable;
import com.xpert.core.crud.AbstractBaseBean;
import javax.ejb.EJB;
import javax.faces.bean.ManagedBean;
import javax.faces.bean.ViewScoped;
import com.mycompany.controleestoque.bo.cadastro.ClienteBO;
import com.mycompany.controleestoque.modelo.cadastro.Cliente;
import com.xpert.faces.utils.FacesUtils;

/**
 *
 * @author juniel
 */
@ManagedBean
@ViewScoped
public class ClienteMB extends AbstractBaseBean<Cliente> implements Serializable {

    @EJB
    private ClienteBO clienteBO;

    @Override
    public ClienteBO getBO() {
        return clienteBO;
    }

    @Override
    public String getDataModelOrder() {
        return "id";
    }
    
    @Override
    public void postSave() {
        if(getId()!=null){
            FacesUtils.redirect("/view/cadastro/cliente/listCliente.jsf");
        }else{
            setEntity(new Cliente());
        }
    }
}
