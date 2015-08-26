package com.mycompany.controleestoque.dao.cadastro;

import com.xpert.persistence.dao.BaseDAO;
import com.mycompany.controleestoque.modelo.cadastro.Produto;
import javax.ejb.Local;

/**
 *
 * @author juniel
 */
@Local
public interface ProdutoDAO extends BaseDAO<Produto> {
    
}
