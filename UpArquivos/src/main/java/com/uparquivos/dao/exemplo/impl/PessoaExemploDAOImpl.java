package com.uparquivos.dao.exemplo.impl;

import com.uparquivos.application.BaseDAOImpl;
import com.uparquivos.dao.exemplo.PessoaExemploDAO;
import com.uparquivos.modelo.exemplo.PessoaExemplo;
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
