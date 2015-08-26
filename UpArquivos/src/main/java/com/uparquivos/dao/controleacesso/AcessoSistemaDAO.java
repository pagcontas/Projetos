package com.uparquivos.dao.controleacesso;

import com.xpert.persistence.dao.BaseDAO;
import com.uparquivos.modelo.controleacesso.AcessoSistema;
import javax.ejb.Local;

/**
 *
 * @author ayslan
 */
@Local
public interface AcessoSistemaDAO extends BaseDAO<AcessoSistema> {
    
}
