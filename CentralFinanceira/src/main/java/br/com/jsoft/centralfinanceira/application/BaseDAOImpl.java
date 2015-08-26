package br.com.jsoft.centralfinanceira.application;

import br.com.jsoft.centralfinanceira.constante.Constantes;
import javax.persistence.EntityManager;
import javax.persistence.PersistenceContext;

/**
 *
 * @author
 */
public class BaseDAOImpl<T> extends com.xpert.persistence.dao.BaseDAOImpl<T> {

    @PersistenceContext(unitName=Constantes.PERSISTENCE_UNIT_NAME)
    private EntityManager entityManager;

    public BaseDAOImpl() {
    }

    @Override
    public EntityManager getEntityManager() {
        return entityManager;
    }
}
