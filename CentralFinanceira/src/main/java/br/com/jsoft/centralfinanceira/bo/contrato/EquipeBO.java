package br.com.jsoft.centralfinanceira.bo.contrato;

import com.xpert.core.crud.AbstractBusinessObject;
import br.com.jsoft.centralfinanceira.dao.contrato.EquipeDAO;
import com.xpert.core.validation.UniqueField;
import com.xpert.core.exception.BusinessException;
import java.util.List;
import javax.ejb.EJB;
import javax.ejb.Stateless;
import br.com.jsoft.centralfinanceira.modelo.contrato.Equipe;
import com.xpert.core.validation.UniqueFields;

/**
 *
 * @author Juniel
 */
@Stateless
public class EquipeBO extends AbstractBusinessObject<Equipe> {

    @EJB
    private EquipeDAO equipeDAO;
    
    @Override
    public EquipeDAO getDAO() {
        return equipeDAO;
    }

    @Override
    public List<UniqueField> getUniqueFields() {
        return new UniqueFields().add("nome","telefone");
    }

    @Override
    public void validate(Equipe equipe) throws BusinessException {
    }

    @Override
    public boolean isAudit() {
        return true;
    }

}
