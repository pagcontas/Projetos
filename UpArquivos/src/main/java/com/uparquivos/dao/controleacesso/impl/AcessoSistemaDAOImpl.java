package com.uparquivos.dao.controleacesso.impl;

import com.uparquivos.application.BaseDAOImpl;
import com.uparquivos.dao.controleacesso.AcessoSistemaDAO;
import com.uparquivos.modelo.controleacesso.AcessoSistema;
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
