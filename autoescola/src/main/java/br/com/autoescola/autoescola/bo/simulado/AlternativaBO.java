package br.com.autoescola.autoescola.bo.simulado;

import com.xpert.core.crud.AbstractBusinessObject;
import br.com.autoescola.autoescola.dao.simulado.AlternativaDAO;
import com.xpert.core.validation.UniqueField;
import com.xpert.core.exception.BusinessException;
import java.util.List;
import javax.ejb.EJB;
import javax.ejb.Stateless;
import br.com.autoescola.autoescola.modelo.simulado.Alternativa;

/**
 *
 * @author killerbee
 */
@Stateless
public class AlternativaBO extends AbstractBusinessObject<Alternativa> {

    @EJB
    private AlternativaDAO alternativaDAO;
    
    @Override
    public AlternativaDAO getDAO() {
        return alternativaDAO;
    }

    @Override
    public List<UniqueField> getUniqueFields() {
        return null;
    }

    @Override
    public void validate(Alternativa alternativa) throws BusinessException {
    }

    @Override
    public boolean isAudit() {
        return true;
    }

}
