package br.com.jsoft.centralfinanceira.bo.central;

import com.xpert.core.crud.AbstractBusinessObject;
import br.com.jsoft.centralfinanceira.dao.central.ConveniopDAO;
import com.xpert.core.validation.UniqueField;
import com.xpert.core.exception.BusinessException;
import java.util.List;
import javax.ejb.EJB;
import javax.ejb.Stateless;
import br.com.jsoft.centralfinanceira.modelo.central.Conveniop;

/**
 *
 * @author Juniel
 */
@Stateless
public class ConveniopBO extends AbstractBusinessObject<Conveniop> {

    @EJB
    private ConveniopDAO conveniopDAO;
    
    @Override
    public ConveniopDAO getDAO() {
        return conveniopDAO;
    }

    @Override
    public List<UniqueField> getUniqueFields() {
        return null;
    }

    @Override
    public void validate(Conveniop conveniop) throws BusinessException {
    }

    @Override
    public boolean isAudit() {
        return true;
    }

}
