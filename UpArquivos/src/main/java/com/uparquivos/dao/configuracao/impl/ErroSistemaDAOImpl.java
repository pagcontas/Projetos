package com.uparquivos.dao.configuracao.impl;

import com.uparquivos.application.BaseDAOImpl;
import com.uparquivos.dao.configuracao.ErroSistemaDAO;
import com.uparquivos.modelo.configuracao.ErroSistema;
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
