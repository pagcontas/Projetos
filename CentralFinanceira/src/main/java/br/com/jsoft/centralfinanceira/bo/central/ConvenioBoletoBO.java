package br.com.jsoft.centralfinanceira.bo.central;

import com.xpert.core.crud.AbstractBusinessObject;
import br.com.jsoft.centralfinanceira.dao.central.ConvenioBoletoDAO;
import com.xpert.core.validation.UniqueField;
import com.xpert.core.exception.BusinessException;
import java.util.List;
import javax.ejb.EJB;
import javax.ejb.Stateless;
import br.com.jsoft.centralfinanceira.modelo.central.ConvenioBoleto;

/**
 *
 * @author Juniel
 */
@Stateless
public class ConvenioBoletoBO extends AbstractBusinessObject<ConvenioBoleto> {

    @EJB
    private ConvenioBoletoDAO convenioBoletoDAO;
    
    @Override
    public ConvenioBoletoDAO getDAO() {
        return convenioBoletoDAO;
    }

    @Override
    public List<UniqueField> getUniqueFields() {
        return null;
    }

    @Override
    public void validate(ConvenioBoleto convenioBoleto) throws BusinessException {
    }

    @Override
    public boolean isAudit() {
        return true;
    }

}
