package com.sislaud.dao.controleacesso.impl;

import com.sislaud.application.BaseDAOImpl;
import com.sislaud.dao.controleacesso.UsuarioDAO;
import com.sislaud.modelo.controleacesso.SituacaoUsuario;
import com.sislaud.modelo.controleacesso.Usuario;
import java.util.List;
import javax.ejb.Stateless;

/**
 *
 * @author #Author
 */
@Stateless
public class UsuarioDAOImpl extends BaseDAOImpl<Usuario> implements UsuarioDAO {

    @Override
    public Class getEntityClass() {
        return Usuario.class;
    }

    @Override
    public List<Usuario> getUsuariosAtivos() {
        return list("situacaoUsuario", SituacaoUsuario.ATIVO, "nome");
    }
    
    
}
