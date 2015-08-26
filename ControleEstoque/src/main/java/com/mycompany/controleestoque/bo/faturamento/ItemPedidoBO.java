package com.mycompany.controleestoque.bo.faturamento;

import com.xpert.core.crud.AbstractBusinessObject;
import com.mycompany.controleestoque.dao.faturamento.ItemPedidoDAO;
import com.xpert.core.validation.UniqueField;
import com.xpert.core.exception.BusinessException;
import java.util.List;
import javax.ejb.EJB;
import javax.ejb.Stateless;
import com.mycompany.controleestoque.modelo.faturamento.ItemPedido;

/**
 *
 * @author juniel
 */
@Stateless
public class ItemPedidoBO extends AbstractBusinessObject<ItemPedido> {

    @EJB
    private ItemPedidoDAO itemPedidoDAO;
    
    @Override
    public ItemPedidoDAO getDAO() {
        return itemPedidoDAO;
    }

    @Override
    public List<UniqueField> getUniqueFields() {
        return null;
    }

    @Override
    public void validate(ItemPedido itemPedido) throws BusinessException {
    }

    @Override
    public boolean isAudit() {
        return true;
    }

}
