/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */
package br.com.autoescola.autoescola.dao.impl;

import br.com.autoescola.autoescola.application.BaseDAOImpl;
import br.com.autoescola.autoescola.dao.DAO;
import com.xpert.persistence.dao.BaseDAO;
import javax.ejb.Stateless;

/**
 *
 * @author ayslan
 */
@Stateless
public class DAOImpl extends BaseDAOImpl implements DAO {

    @Override
    public <T> BaseDAO<T> getDAO(Class<T> entity) {
        this.setEntityClass(entity);
        return (BaseDAO<T>) this;
    }
}
