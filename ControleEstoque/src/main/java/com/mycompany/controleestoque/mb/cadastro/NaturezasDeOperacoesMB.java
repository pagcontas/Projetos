package com.mycompany.controleestoque.mb.cadastro;


import java.io.Serializable;
import com.xpert.core.crud.AbstractBaseBean;
import javax.ejb.EJB;
import javax.faces.bean.ManagedBean;
import javax.faces.bean.ViewScoped;
import com.mycompany.controleestoque.bo.cadastro.NaturezasDeOperacoesBO;
import com.mycompany.controleestoque.modelo.cadastro.NaturezasDeOperacoes;
import com.xpert.faces.utils.FacesUtils;

/**
 *
 * @author juniel
 */
@ManagedBean
@ViewScoped
public class NaturezasDeOperacoesMB extends AbstractBaseBean<NaturezasDeOperacoes> implements Serializable {

    @EJB
    private NaturezasDeOperacoesBO naturezasDeOperacoesBO;

    @Override
    public NaturezasDeOperacoesBO getBO() {
        return naturezasDeOperacoesBO;
    }

    @Override
    public String getDataModelOrder() {
        return "id";
    }
    
    @Override
    public void postSave() {
        if (getId() != null) {
            FacesUtils.redirect("/view/cadastro/naturezasDeOperacoes/listNaturezasDeOperacoes.jsf");
        } else {
            setEntity(new NaturezasDeOperacoes());
        }
    }
}
