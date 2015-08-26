package com.sislaud.dao.exemplo.impl;

import com.sislaud.application.BaseDAOImpl;
import com.sislaud.dao.exemplo.PessoaExemploDAO;
import com.sislaud.modelo.exemplo.PessoaExemplo;
import javax.ejb.Stateless;

/**
 *
 * @author ayslan
 */
@Stateless
public class PessoaExemploDAOImpl extends BaseDAOImpl<PessoaExemplo> implements PessoaExemploDAO {

    @Override
    public Class getEntityClass() {
        return PessoaExemplo.class;
    }

}
