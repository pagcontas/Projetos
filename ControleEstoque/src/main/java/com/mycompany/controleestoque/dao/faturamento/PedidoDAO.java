package com.mycompany.controleestoque.dao.faturamento;

import com.xpert.persistence.dao.BaseDAO;
import com.mycompany.controleestoque.modelo.faturamento.Pedido;
import javax.ejb.Local;

/**
 *
 * @author juniel
 */
@Local
public interface PedidoDAO extends BaseDAO<Pedido> {
    
}
