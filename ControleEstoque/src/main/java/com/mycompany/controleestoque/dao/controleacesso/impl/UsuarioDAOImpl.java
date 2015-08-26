package com.mycompany.controleestoque.dao.controleacesso.impl;

import com.mycompany.controleestoque.application.BaseDAOImpl;
import com.mycompany.controleestoque.dao.controleacesso.UsuarioDAO;
import com.mycompany.controleestoque.modelo.controleacesso.SituacaoUsuario;
import com.mycompany.controleestoque.modelo.controleacesso.Usuario;
import java.util.List;
import javax.ejb.Stateless;

/**
 *
 * @author #Author
 */
@Stateless
public class UsuarioDAOImpl extends BaseDAOImpl<Usuario> implements UsuarioDAO {

    @Override
    public List<Usuario> getUsuariosAtivos() {
        return list("situacaoUsuario", SituacaoUsuario.ATIVO, "nome");
    }
}
