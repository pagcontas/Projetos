package br.com.autoescola.autoescola.dao.controleacesso.impl;

import br.com.autoescola.autoescola.application.BaseDAOImpl;
import br.com.autoescola.autoescola.dao.controleacesso.PerfilDAO;
import br.com.autoescola.autoescola.modelo.controleacesso.Perfil;
import br.com.autoescola.autoescola.modelo.controleacesso.Usuario;
import java.util.List;
import javax.ejb.Stateless;
import javax.persistence.Query;

/**
 *
 * @author #Author
 */
@Stateless
public class PerfilDAOImpl extends BaseDAOImpl<Perfil> implements PerfilDAO {
    
     @Override
    public List<Perfil> getPerfis(Usuario usuario) {

        String queryString = "SELECT perfis FROM " + Usuario.class.getName() + " u WHERE u =?1 ";
        Query query = getEntityManager().createQuery(queryString);
        query.setParameter(1, usuario);

        return query.getResultList();

    }
}
