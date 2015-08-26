package com.mycompany.controleestoque.bo.faturamento;

import com.xpert.core.crud.AbstractBusinessObject;
import com.mycompany.controleestoque.dao.faturamento.ItemVendaDAO;
import com.xpert.core.validation.UniqueField;
import com.xpert.core.exception.BusinessException;
import java.util.List;
import javax.ejb.EJB;
import javax.ejb.Stateless;
import com.mycompany.controleestoque.modelo.faturamento.ItemVenda;

/**
 *
 * @author juniel
 */
@Stateless
public class ItemVendaBO extends AbstractBusinessObject<ItemVenda> {

    @EJB
    private ItemVendaDAO itemVendaDAO;
    
    @Override
    public ItemVendaDAO getDAO() {
        return itemVendaDAO;
    }

    @Override
    public List<UniqueField> getUniqueFields() {
        return null;
    }

    @Override
    public void validate(ItemVenda itemVenda) throws BusinessException {
    }

    @Override
    public boolean isAudit() {
        return true;
    }

}
