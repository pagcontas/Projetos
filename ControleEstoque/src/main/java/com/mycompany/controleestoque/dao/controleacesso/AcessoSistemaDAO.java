package com.mycompany.controleestoque.dao.controleacesso;

import com.xpert.persistence.dao.BaseDAO;
import com.mycompany.controleestoque.modelo.controleacesso.AcessoSistema;
import javax.ejb.Local;

/**
 *
 * @author ayslan
 */
@Local
public interface AcessoSistemaDAO extends BaseDAO<AcessoSistema> {
    
}
