package br.com.jsoft.centralfinanceira.dao.controleacesso;

import br.com.jsoft.centralfinanceira.modelo.controleacesso.Perfil;
import br.com.jsoft.centralfinanceira.modelo.controleacesso.Permissao;
import br.com.jsoft.centralfinanceira.modelo.controleacesso.Usuario;
import com.xpert.persistence.dao.BaseDAO;
import java.util.List;
import javax.ejb.Local;
import javax.persistence.Query;

/**
 *
 * @author #Author
 */
@Local
public interface PermissaoDAO extends BaseDAO<Permissao> {

    public List<Permissao> getTodasPermissoesComFilhos();

    public List<Permissao> getPermissoesComFilhos(Perfil perfil);

    public List<Permissao> getPermissoesComFilhos(Usuario usuario);

    public List<Permissao> getPermissoesMenuComFilhos(Perfil perfil);

    public List<Permissao> getPermissoesAtalhos(Usuario usuario);
}
