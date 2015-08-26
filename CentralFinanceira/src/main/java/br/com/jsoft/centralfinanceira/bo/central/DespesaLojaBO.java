package br.com.jsoft.centralfinanceira.bo.central;

import com.xpert.core.crud.AbstractBusinessObject;
import br.com.jsoft.centralfinanceira.dao.central.DespesaLojaDAO;
import com.xpert.core.validation.UniqueField;
import com.xpert.core.exception.BusinessException;
import java.util.List;
import javax.ejb.EJB;
import javax.ejb.Stateless;
import br.com.jsoft.centralfinanceira.modelo.central.DespesaLoja;

/**
 *
 * @author Juniel
 */
@Stateless
public class DespesaLojaBO extends AbstractBusinessObject<DespesaLoja> {

    @EJB
    private DespesaLojaDAO despesaLojaDAO;
    
    @Override
    public DespesaLojaDAO getDAO() {
        return despesaLojaDAO;
    }

    @Override
    public List<UniqueField> getUniqueFields() {
        return null;
    }

    @Override
    public void validate(DespesaLoja despesaLoja) throws BusinessException {
    }

    @Override
    public boolean isAudit() {
        return true;
    }

}
