package br.com.jsoft.centralfinanceira.dao.central.impl;

import br.com.jsoft.centralfinanceira.application.BaseDAOImpl;
import br.com.jsoft.centralfinanceira.dao.central.LojaDAO;
import br.com.jsoft.centralfinanceira.modelo.central.Loja;
import java.util.List;
import javax.ejb.Stateless;
import javax.persistence.Query;

/**
 *
 * @author Juniel
 */
@Stateless
public class LojaDAOImpl extends BaseDAOImpl<Loja> implements LojaDAO {

    @Override
    public List<Loja> getLojaPorNome(String nome) {
        String queryString = " SELECT p FROM " + Loja.class.getName();
        Query query = null;
        if (ehInteiro(nome)) {
            Long id = Long.parseLong(nome);
            queryString += " p WHERE p.id = ?1 ORDER BY p.id ";
            query = getEntityManager().createQuery(queryString);

            query.setParameter(1, id);
        } else {
            queryString += " p WHERE UPPER(p.nome) LIKE UPPER(?1) ORDER BY p.nome ";
            query = getEntityManager().createQuery(queryString);

            query.setParameter(1, "%" + nome + "%");
        }

        return query.getResultList();
    }

    private boolean ehInteiro(String s) {

        // cria um array de char  
        char[] c = s.toCharArray();
        boolean d = true;

        for (int i = 0; i < c.length; i++) // verifica se o char não é um dígito  
        {
            if (!Character.isDigit(c[i])) {
                d = false;
                break;
            }
        }

        return d;

    }

}
