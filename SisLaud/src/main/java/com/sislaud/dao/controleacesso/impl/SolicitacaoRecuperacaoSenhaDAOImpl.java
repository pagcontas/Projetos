package com.sislaud.dao.controleacesso.impl;

import com.sislaud.application.BaseDAOImpl;
import com.sislaud.dao.controleacesso.SolicitacaoRecuperacaoSenhaDAO;
import com.sislaud.modelo.controleacesso.SolicitacaoRecuperacaoSenha;
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
