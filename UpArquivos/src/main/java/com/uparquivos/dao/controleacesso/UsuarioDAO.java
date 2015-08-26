package com.uparquivos.dao.controleacesso;

import com.uparquivos.modelo.controleacesso.Usuario;
import com.xpert.persistence.dao.BaseDAO;
import java.util.List;
import javax.ejb.Local;

/**
 *
 * @author #Author
 */
@Local
public interface UsuarioDAO extends BaseDAO<Usuario> {
    
    public List<Usuario> getUsuariosAtivos();
    
}
