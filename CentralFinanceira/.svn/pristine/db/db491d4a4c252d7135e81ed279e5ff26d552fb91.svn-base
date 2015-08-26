package br.com.jsoft.centralfinanceira.bo.contrato;

import com.xpert.core.crud.AbstractBusinessObject;
import br.com.jsoft.centralfinanceira.dao.contrato.FilhoDAO;
import com.xpert.core.validation.UniqueField;
import com.xpert.core.exception.BusinessException;
import java.util.List;
import javax.ejb.EJB;
import javax.ejb.Stateless;
import br.com.jsoft.centralfinanceira.modelo.contrato.Filho;

/**
 *
 * @author KillerBeeTwo
 */
@Stateless
public class FilhoBO extends AbstractBusinessObject<Filho> {

    @EJB
    private FilhoDAO filhoDAO;
    
    @Override
    public FilhoDAO getDAO() {
        return filhoDAO;
    }

    @Override
    public List<UniqueField> getUniqueFields() {
        return null;
    }

    @Override
    public void validate(Filho filho) throws BusinessException {
    }

    @Override
    public boolean isAudit() {
        return true;
    }

}
