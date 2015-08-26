package com.sislaud.dao.controleacesso.impl;

import com.sislaud.application.BaseDAOImpl;
import com.sislaud.dao.controleacesso.HistoricoSituacaoUsuarioDAO;
import com.sislaud.modelo.controleacesso.HistoricoSituacaoUsuario;
import javax.ejb.Stateless;

/**
 *
 * @author ayslan
 */
@Stateless
public class HistoricoSituacaoUsuarioDAOImpl extends BaseDAOImpl<HistoricoSituacaoUsuario> implements HistoricoSituacaoUsuarioDAO {

    @Override
    public Class getEntityClass() {
        return HistoricoSituacaoUsuario.class;
    }
}
