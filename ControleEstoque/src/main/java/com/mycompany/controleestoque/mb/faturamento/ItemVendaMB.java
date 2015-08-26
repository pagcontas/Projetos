package com.mycompany.controleestoque.mb.faturamento;


import java.io.Serializable;
import com.xpert.core.crud.AbstractBaseBean;
import javax.ejb.EJB;
import javax.faces.bean.ManagedBean;
import javax.faces.bean.ViewScoped;
import com.mycompany.controleestoque.bo.faturamento.ItemVendaBO;
import com.mycompany.controleestoque.modelo.faturamento.ItemVenda;

/**
 *
 * @author juniel
 */
@ManagedBean
@ViewScoped
public class ItemVendaMB extends AbstractBaseBean<ItemVenda> implements Serializable {

    @EJB
    private ItemVendaBO itemVendaBO;

    @Override
    public ItemVendaBO getBO() {
        return itemVendaBO;
    }

    @Override
    public String getDataModelOrder() {
        return "id";
    }
}
