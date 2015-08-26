package com.uparquivos.dao.controleacesso.impl;

import com.uparquivos.application.BaseDAOImpl;
import com.uparquivos.dao.controleacesso.HistoricoSituacaoUsuarioDAO;
import com.uparquivos.modelo.controleacesso.HistoricoSituacaoUsuario;
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
