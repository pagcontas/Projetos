package br.com.jsoft.centralfinanceira.bo.central;

import com.xpert.core.crud.AbstractBusinessObject;
import br.com.jsoft.centralfinanceira.dao.central.ReceitaLojaDAO;
import com.xpert.core.validation.UniqueField;
import com.xpert.core.exception.BusinessException;
import java.util.List;
import javax.ejb.EJB;
import javax.ejb.Stateless;
import br.com.jsoft.centralfinanceira.modelo.central.ReceitaLoja;

/**
 *
 * @author Juniel
 */
@Stateless
public class ReceitaLojaBO extends AbstractBusinessObject<ReceitaLoja> {

    @EJB
    private ReceitaLojaDAO receitaLojaDAO;
    
    @Override
    public ReceitaLojaDAO getDAO() {
        return receitaLojaDAO;
    }

    @Override
    public List<UniqueField> getUniqueFields() {
        return null;
    }

    @Override
    public void validate(ReceitaLoja receitaLoja) throws BusinessException {
    }

    @Override
    public boolean isAudit() {
        return true;
    }

}
