package br.com.jsoft.centralfinanceira.bo.central;

import com.xpert.core.crud.AbstractBusinessObject;
import br.com.jsoft.centralfinanceira.dao.central.ConveniobbDAO;
import com.xpert.core.validation.UniqueField;
import com.xpert.core.exception.BusinessException;
import java.util.List;
import javax.ejb.EJB;
import javax.ejb.Stateless;
import br.com.jsoft.centralfinanceira.modelo.central.Conveniobb;

/**
 *
 * @author ti05
 */
@Stateless
public class ConveniobbBO extends AbstractBusinessObject<Conveniobb> {

    @EJB
    private ConveniobbDAO conveniobbDAO;
    
    @Override
    public ConveniobbDAO getDAO() {
        return conveniobbDAO;
    }

    @Override
    public List<UniqueField> getUniqueFields() {
        return null;
    }

    @Override
    public void validate(Conveniobb conveniobb) throws BusinessException {
    }

    @Override
    public boolean isAudit() {
        return true;
    }

}
