package br.com.jsoft.centralfinanceira.bo.central;

import com.xpert.core.crud.AbstractBusinessObject;
import br.com.jsoft.centralfinanceira.dao.central.LojaDAO;
import com.xpert.core.validation.UniqueField;
import com.xpert.core.exception.BusinessException;
import java.util.List;
import javax.ejb.EJB;
import javax.ejb.Stateless;
import br.com.jsoft.centralfinanceira.modelo.central.Loja;

/**
 *
 * @author Juniel
 */
@Stateless
public class LojaBO extends AbstractBusinessObject<Loja> {

    @EJB
    private LojaDAO lojaDAO;
    
    @Override
    public LojaDAO getDAO() {
        return lojaDAO;
    }

    @Override
    public List<UniqueField> getUniqueFields() {
        return null;
    }

    @Override
    public void validate(Loja loja) throws BusinessException {
    }

    @Override
    public boolean isAudit() {
        return true;
    }

}
