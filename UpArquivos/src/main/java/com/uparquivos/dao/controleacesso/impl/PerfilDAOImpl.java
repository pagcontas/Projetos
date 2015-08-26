package com.uparquivos.dao.controleacesso.impl;

import com.uparquivos.application.BaseDAOImpl;
import com.uparquivos.dao.controleacesso.PerfilDAO;
import com.uparquivos.modelo.controleacesso.Perfil;
import com.uparquivos.modelo.controleacesso.Usuario;
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
    public Class getEntityClass() {
        return Perfil.class;
    }

    @Override
    public List<Perfil> getPerfis(Usuario usuario) {

        String queryString = "SELECT perfis FROM " + Usuario.class.getName() + " u WHERE u =?1 ";
        Query query = getEntityManager().createQuery(queryString);
        query.setParameter(1, usuario);

        return query.getResultList();

    }
}
