package com.mycompany.controleestoque.mb.cadastro;


import java.io.Serializable;
import com.xpert.core.crud.AbstractBaseBean;
import javax.ejb.EJB;
import javax.faces.bean.ManagedBean;
import javax.faces.bean.ViewScoped;
import com.mycompany.controleestoque.bo.cadastro.ContaBancariaBO;
import com.mycompany.controleestoque.modelo.cadastro.ContaBancaria;
import com.xpert.faces.utils.FacesUtils;

/**
 *
 * @author KillerBeeTwo
 */
@ManagedBean
@ViewScoped
public class ContaBancariaMB extends AbstractBaseBean<ContaBancaria> implements Serializable {

    @EJB
    private ContaBancariaBO contaBancariaBO;

    @Override
    public ContaBancariaBO getBO() {
        return contaBancariaBO;
    }

    @Override
    public String getDataModelOrder() {
        return "id";
    }
    
    @Override
    public void postSave() {
        if(getId()!=null){
            FacesUtils.redirect("/view/cadastro/contaBancaria/listContaBancaria.jsf");
        }else{
            setEntity(new ContaBancaria());
        }
    }
}
