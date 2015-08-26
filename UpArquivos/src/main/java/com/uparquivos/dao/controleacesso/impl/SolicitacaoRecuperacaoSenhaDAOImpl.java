package com.uparquivos.dao.controleacesso.impl;

import com.uparquivos.application.BaseDAOImpl;
import com.uparquivos.dao.controleacesso.SolicitacaoRecuperacaoSenhaDAO;
import com.uparquivos.modelo.controleacesso.SolicitacaoRecuperacaoSenha;
import javax.ejb.Stateless;

/**
 *
 * @author ayslan
 */
@Stateless
public class SolicitacaoRecuperacaoSenhaDAOImpl extends BaseDAOImpl<SolicitacaoRecuperacaoSenha> implements SolicitacaoRecuperacaoSenhaDAO {

    @Override
    public Class getEntityClass() {
        return SolicitacaoRecuperacaoSenha.class;
    }
}
