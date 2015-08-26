package br.com.jsoft.centralfinanceira.dao.controleacesso.impl;

import br.com.jsoft.centralfinanceira.application.BaseDAOImpl;
import br.com.jsoft.centralfinanceira.dao.controleacesso.UsuarioDAO;
import br.com.jsoft.centralfinanceira.modelo.controleacesso.SituacaoUsuario;
import br.com.jsoft.centralfinanceira.modelo.controleacesso.Usuario;
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
