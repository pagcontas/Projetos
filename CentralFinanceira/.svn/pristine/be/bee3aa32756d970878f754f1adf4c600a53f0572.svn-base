package br.com.jsoft.centralfinanceira.bo.central;

import com.xpert.core.crud.AbstractBusinessObject;
import br.com.jsoft.centralfinanceira.dao.central.UfDAO;
import com.xpert.core.validation.UniqueField;
import com.xpert.core.exception.BusinessException;
import java.util.List;
import javax.ejb.EJB;
import javax.ejb.Stateless;
import br.com.jsoft.centralfinanceira.modelo.central.Uf;

/**
 *
 * @author ti05
 */
@Stateless
public class UfBO extends AbstractBusinessObject<Uf> {

    @EJB
    private UfDAO DAO;
    
    @Override
    public UfDAO getDAO() {
        return DAO;
    }

    @Override
    public List<UniqueField> getUniqueFields() {
        return null;
    }


    @Override
    public boolean isAudit() {
        return true;
    }

    @Override
    public void validate(Uf object) throws BusinessException {
        throw new UnsupportedOperationException("Not supported yet."); //To change body of generated methods, choose Tools | Templates.
    }

}
