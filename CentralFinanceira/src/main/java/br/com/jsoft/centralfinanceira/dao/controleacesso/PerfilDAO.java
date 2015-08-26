package br.com.jsoft.centralfinanceira.dao.controleacesso;

import br.com.jsoft.centralfinanceira.modelo.controleacesso.Perfil;
import br.com.jsoft.centralfinanceira.modelo.controleacesso.Usuario;
import com.xpert.persistence.dao.BaseDAO;
import java.util.List;
import javax.ejb.Local;

/**
 *
 * @author #Author
 */
@Local
public interface PerfilDAO extends BaseDAO<Perfil> {
    
     public List<Perfil> getPerfis(Usuario usuario);
}
