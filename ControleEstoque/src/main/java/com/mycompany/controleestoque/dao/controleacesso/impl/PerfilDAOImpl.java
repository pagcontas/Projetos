package com.mycompany.controleestoque.dao.controleacesso.impl;

import com.mycompany.controleestoque.application.BaseDAOImpl;
import com.mycompany.controleestoque.dao.controleacesso.PerfilDAO;
import com.mycompany.controleestoque.modelo.controleacesso.Perfil;
import com.mycompany.controleestoque.modelo.controleacesso.Usuario;
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
