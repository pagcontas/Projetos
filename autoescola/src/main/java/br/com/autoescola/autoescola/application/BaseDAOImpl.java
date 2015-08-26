package br.com.autoescola.autoescola.application;

import br.com.autoescola.autoescola.constante.Constantes;
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
