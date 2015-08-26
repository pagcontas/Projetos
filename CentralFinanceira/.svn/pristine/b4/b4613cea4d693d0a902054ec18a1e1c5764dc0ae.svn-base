package br.com.jsoft.centralfinanceira.bo.central;

import com.xpert.core.crud.AbstractBusinessObject;
import br.com.jsoft.centralfinanceira.dao.central.TipoDespesaDAO;
import com.xpert.core.validation.UniqueField;
import com.xpert.core.exception.BusinessException;
import java.util.List;
import javax.ejb.EJB;
import javax.ejb.Stateless;
import br.com.jsoft.centralfinanceira.modelo.central.TipoDespesa;

/**
 *
 * @author Juniel
 */
@Stateless
public class TipoDespesaBO extends AbstractBusinessObject<TipoDespesa> {

    @EJB
    private TipoDespesaDAO tipoDespesaDAO;
    
    @Override
    public TipoDespesaDAO getDAO() {
        return tipoDespesaDAO;
    }

    @Override
    public List<UniqueField> getUniqueFields() {
        return null;
    }

    @Override
    public void validate(TipoDespesa tipoDespesa) throws BusinessException {
    }

    @Override
    public boolean isAudit() {
        return true;
    }

}
