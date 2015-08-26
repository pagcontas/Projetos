package com.sislaud.dao.configuracao.impl;

import com.sislaud.application.BaseDAOImpl;
import com.sislaud.dao.configuracao.ErroSistemaDAO;
import com.sislaud.modelo.configuracao.ErroSistema;
import javax.ejb.Stateless;

/**
 *
 * @author
 */
@Stateless
public class ErroSistemaDAOImpl extends BaseDAOImpl<ErroSistema> implements ErroSistemaDAO {

    @Override
    public Class getEntityClass() {
        return ErroSistema.class;
    }
    
    
    
}
