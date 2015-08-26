package br.com.autoescola.autoescola.bo.financeiro;

import com.xpert.core.crud.AbstractBusinessObject;
import br.com.autoescola.autoescola.dao.financeiro.ParcelasDAO;
import com.xpert.core.validation.UniqueField;
import com.xpert.core.exception.BusinessException;
import java.util.List;
import javax.ejb.EJB;
import javax.ejb.Stateless;
import br.com.autoescola.autoescola.modelo.financeiro.Parcelas;
import com.xpert.persistence.exception.DeleteException;

/**
 *
 * @author killerbee
 */
@Stateless
public class ParcelasBO extends AbstractBusinessObject<Parcelas> {

    @EJB
    private ParcelasDAO parcelasDAO;

    @Override
    public ParcelasDAO getDAO() {
        return parcelasDAO;
    }

    @Override
    public List<UniqueField> getUniqueFields() {
        return null;
    }

    @Override
    public void validate(Parcelas parcelas) throws BusinessException {
    }

    @Override
    public boolean isAudit() {
        return true;
    }

    @Override
    public void save(Parcelas object) throws BusinessException {
        super.save(object);
    }

    @Override
    public void delete(Object id) throws DeleteException {
        super.delete(id); 
    }        
    
}
