package com.mycompany.controleestoque.mb.cadastro;


import java.io.Serializable;
import com.xpert.core.crud.AbstractBaseBean;
import javax.ejb.EJB;
import javax.faces.bean.ManagedBean;
import javax.faces.bean.ViewScoped;
import com.mycompany.controleestoque.bo.cadastro.CidadeBO;
import com.mycompany.controleestoque.modelo.cadastro.Cidade;
import com.xpert.faces.utils.FacesUtils;

/**
 *
 * @author juniel
 */
@ManagedBean
@ViewScoped
public class CidadeMB extends AbstractBaseBean<Cidade> implements Serializable {

    @EJB
    private CidadeBO cidadeBO;

    @Override
    public CidadeBO getBO() {
        return cidadeBO;
    }

    @Override
    public String getDataModelOrder() {
        return "nome";
    }

    @Override
    public void postSave() {
        if(getId()!=null){
            FacesUtils.redirect("/view/cadastro/cidade/listCidade.jsf");
        }else{
            setEntity(new Cidade());
        }
    }
  
}
