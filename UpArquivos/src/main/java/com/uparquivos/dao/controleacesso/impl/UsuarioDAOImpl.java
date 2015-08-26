package com.uparquivos.dao.controleacesso.impl;

import com.uparquivos.application.BaseDAOImpl;
import com.uparquivos.dao.controleacesso.UsuarioDAO;
import com.uparquivos.modelo.controleacesso.SituacaoUsuario;
import com.uparquivos.modelo.controleacesso.Usuario;
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
