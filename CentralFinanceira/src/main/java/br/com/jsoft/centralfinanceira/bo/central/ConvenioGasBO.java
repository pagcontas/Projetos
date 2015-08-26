package br.com.jsoft.centralfinanceira.bo.central;

import com.xpert.core.crud.AbstractBusinessObject;
import br.com.jsoft.centralfinanceira.dao.central.ConvenioGasDAO;
import com.xpert.core.validation.UniqueField;
import com.xpert.core.exception.BusinessException;
import java.util.List;
import javax.ejb.EJB;
import javax.ejb.Stateless;
import br.com.jsoft.centralfinanceira.modelo.central.ConvenioGas;

/**
 *
 * @author Juniel
 */
@Stateless
public class ConvenioGasBO extends AbstractBusinessObject<ConvenioGas> {

    @EJB
    private ConvenioGasDAO convenioGasDAO;
    
    @Override
    public ConvenioGasDAO getDAO() {
        return convenioGasDAO;
    }

    @Override
    public List<UniqueField> getUniqueFields() {
        return null;
    }

    @Override
    public void validate(ConvenioGas convenioGas) throws BusinessException {
    }

    @Override
    public boolean isAudit() {
        return true;
    }

}
