package br.com.jsoft.centralfinanceira.bo.central;

import com.xpert.core.crud.AbstractBusinessObject;
import br.com.jsoft.centralfinanceira.dao.central.ConveniocredigiDAO;
import com.xpert.core.validation.UniqueField;
import com.xpert.core.exception.BusinessException;
import java.util.List;
import javax.ejb.EJB;
import javax.ejb.Stateless;
import br.com.jsoft.centralfinanceira.modelo.central.Conveniocredigi;

/**
 *
 * @author Juniel
 */
@Stateless
public class ConveniocredigiBO extends AbstractBusinessObject<Conveniocredigi> {

    @EJB
    private ConveniocredigiDAO conveniocredigiDAO;
    
    @Override
    public ConveniocredigiDAO getDAO() {
        return conveniocredigiDAO;
    }

    @Override
    public List<UniqueField> getUniqueFields() {
        return null;
    }

    @Override
    public void validate(Conveniocredigi conveniocredigi) throws BusinessException {
    }

    @Override
    public boolean isAudit() {
        return true;
    }

}
