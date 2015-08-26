package br.com.jsoft.centralfinanceira.bo.central;

import com.xpert.core.crud.AbstractBusinessObject;
import br.com.jsoft.centralfinanceira.dao.central.ConvenioSiteDAO;
import com.xpert.core.validation.UniqueField;
import com.xpert.core.exception.BusinessException;
import java.util.List;
import javax.ejb.EJB;
import javax.ejb.Stateless;
import br.com.jsoft.centralfinanceira.modelo.central.ConvenioSite;

/**
 *
 * @author Juniel
 */
@Stateless
public class ConvenioSiteBO extends AbstractBusinessObject<ConvenioSite> {

    @EJB
    private ConvenioSiteDAO convenioSiteDAO;
    
    @Override
    public ConvenioSiteDAO getDAO() {
        return convenioSiteDAO;
    }

    @Override
    public List<UniqueField> getUniqueFields() {
        return null;
    }

    @Override
    public void validate(ConvenioSite convenioSite) throws BusinessException {
    }

    @Override
    public boolean isAudit() {
        return true;
    }

}
