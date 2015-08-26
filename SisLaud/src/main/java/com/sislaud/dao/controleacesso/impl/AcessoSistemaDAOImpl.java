package com.sislaud.dao.controleacesso.impl;

import com.sislaud.application.BaseDAOImpl;
import com.sislaud.dao.controleacesso.AcessoSistemaDAO;
import com.sislaud.modelo.controleacesso.AcessoSistema;
import javax.ejb.Stateless;

/**
 *
 * @author ayslan
 */
@Stateless
public class AcessoSistemaDAOImpl extends BaseDAOImpl<AcessoSistema> implements AcessoSistemaDAO {

    @Override
    public Class getEntityClass() {
        return AcessoSistema.class;
    }
    
    
}
