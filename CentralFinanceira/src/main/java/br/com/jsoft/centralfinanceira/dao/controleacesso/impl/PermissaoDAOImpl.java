package br.com.jsoft.centralfinanceira.dao.controleacesso.impl;

import br.com.jsoft.centralfinanceira.application.BaseDAOImpl;
import br.com.jsoft.centralfinanceira.dao.controleacesso.PermissaoDAO;
import br.com.jsoft.centralfinanceira.modelo.controleacesso.Perfil;
import br.com.jsoft.centralfinanceira.modelo.controleacesso.Permissao;
import br.com.jsoft.centralfinanceira.modelo.controleacesso.Usuario;
import java.util.List;
import javax.ejb.Stateless;
import javax.persistence.Query;

/**
 *
 * @author #Author
 */
@Stateless
public class PermissaoDAOImpl extends BaseDAOImpl<Permissao> implements PermissaoDAO {

    @Override
    public List<Permissao> getTodasPermissoesComFilhos() {
        StringBuilder builder = new StringBuilder();
        //trazer todas permissoes
        builder.append("SELECT DISTINCT p FROM ").append(Permissao.class.getName()).append(" p ");
        builder.append("LEFT JOIN FETCH p.permissaoPai LEFT JOIN FETCH p.permissoesFilhas ");
        builder.append("ORDER BY p.descricao ");
        Query query = getEntityManager().createQuery(builder.toString());

        return query.getResultList();
    }

    @Override
    public List<Permissao> getPermissoesComFilhos(Usuario usuario) {
        StringBuilder builder = new StringBuilder();

        builder.append("SELECT DISTINCT p FROM ").append(Usuario.class.getName()).append(" u ");
        builder.append("LEFT JOIN u.perfis pe INNER JOIN pe.permissoes p ");
        builder.append("LEFT JOIN FETCH p.permissaoPai LEFT JOIN FETCH p.permissoesFilhas ");
        builder.append("WHERE u = :usuario or p.global = true ");
        builder.append("ORDER BY p.descricao ");

        Query query = getEntityManager().createQuery(builder.toString());
        query.setParameter("usuario", usuario);

        return query.getResultList();
    }

    @Override
    public List<Permissao> getPermissoesComFilhos(Perfil perfil) {
        StringBuilder builder = new StringBuilder();

        if (perfil == null) {
            builder.append("SELECT DISTINCT p FROM ").append(Permissao.class.getName()).append(" p ");
            builder.append("LEFT JOIN FETCH p.permissaoPai LEFT JOIN FETCH p.permissoesFilhas ORDER BY p.descricao ");
        } else {
            builder.append("SELECT DISTINCT p FROM ").append(Perfil.class.getName()).append(" pu ");
            builder.append("JOIN pu.permissoes p LEFT JOIN FETCH p.permissaoPai LEFT JOIN FETCH p.permissoesFilhas WHERE pu = :perfil ORDER BY p.descricao ");
        }

        Query query = getEntityManager().createQuery(builder.toString());
        if (perfil != null) {
            query.setParameter("perfil", perfil);
        }

        return query.getResultList();
    }
    
     @Override
    public List<Permissao> getPermissoesMenuComFilhos(Perfil perfil) {
       
        StringBuilder builder = new StringBuilder();
        builder.append("SELECT DISTINCT p FROM ").append(Perfil.class.getName()).append(" pu ");
        builder.append("JOIN pu.permissoesAtalho p LEFT JOIN FETCH p.permissaoPai LEFT JOIN FETCH p.permissoesFilhas WHERE pu = :perfil ORDER BY p.descricao ");

        Query query = getEntityManager().createQuery(builder.toString());
        if (perfil != null) {
            query.setParameter("perfil", perfil);
        }

        return query.getResultList();
    }
    
    @Override
    public List<Permissao> getPermissoesAtalhos(Usuario usuario) {
        StringBuilder builder = new StringBuilder();

        builder.append("SELECT DISTINCT p FROM ").append(Usuario.class.getName()).append(" u ");
        builder.append("LEFT JOIN u.perfis pe INNER JOIN pe.permissoesAtalho p ");
        builder.append("WHERE u = :usuario AND p.url IS NOT NULL ");
        builder.append("ORDER BY p.descricao ");

        Query query = getEntityManager().createQuery(builder.toString());
        query.setParameter("usuario", usuario);

        return query.getResultList();
    }
}
