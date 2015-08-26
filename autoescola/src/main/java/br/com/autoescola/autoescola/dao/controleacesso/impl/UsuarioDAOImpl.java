package br.com.autoescola.autoescola.dao.controleacesso.impl;

import br.com.autoescola.autoescola.application.BaseDAOImpl;
import br.com.autoescola.autoescola.dao.controleacesso.UsuarioDAO;
import br.com.autoescola.autoescola.modelo.controleacesso.SituacaoUsuario;
import br.com.autoescola.autoescola.modelo.controleacesso.Usuario;
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
