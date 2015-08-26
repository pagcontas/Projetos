package com.uparquivos.dao.controleacesso;

import com.uparquivos.modelo.controleacesso.Perfil;
import com.uparquivos.modelo.controleacesso.Usuario;
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
