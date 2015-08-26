package br.com.jsoft.centralfinanceira.bo.contrato;

import com.xpert.core.crud.AbstractBusinessObject;
import br.com.jsoft.centralfinanceira.dao.contrato.PagContasDAO;
import com.xpert.core.validation.UniqueField;
import com.xpert.core.exception.BusinessException;
import java.util.List;
import javax.ejb.EJB;
import javax.ejb.Stateless;
import br.com.jsoft.centralfinanceira.modelo.contrato.PagContas;

/**
 *
 * @author ti05
 */
@Stateless
public class PagContasBO extends AbstractBusinessObject<PagContas> {

    @EJB
    private PagContasDAO pagContasDAO;
    
    @Override
    public PagContasDAO getDAO() {
        return pagContasDAO;
    }

    @Override
    public List<UniqueField> getUniqueFields() {
        return null;
    }

    @Override
    public void validate(PagContas pagContas) throws BusinessException {
    }

    @Override
    public boolean isAudit() {
        return true;
    }

}
