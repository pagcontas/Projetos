package br.com.autoescola.autoescola.dao.controleacesso;

import br.com.autoescola.autoescola.modelo.controleacesso.Perfil;
import br.com.autoescola.autoescola.modelo.controleacesso.Usuario;
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
