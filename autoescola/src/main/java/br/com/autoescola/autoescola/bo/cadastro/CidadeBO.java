package br.com.autoescola.autoescola.bo.cadastro;

import com.xpert.core.crud.AbstractBusinessObject;
import br.com.autoescola.autoescola.dao.cadastro.CidadeDAO;
import com.xpert.core.validation.UniqueField;
import com.xpert.core.exception.BusinessException;
import java.util.List;
import javax.ejb.EJB;
import javax.ejb.Stateless;
import br.com.autoescola.autoescola.modelo.cadastro.Cidade;
import com.xpert.core.validation.UniqueFields;

/**
 *
 * @author killerbee
 */
@Stateless
public class CidadeBO extends AbstractBusinessObject<Cidade> {

    @EJB
    private CidadeDAO cidadeDAO;
    
    @Override
    public CidadeDAO getDAO() {
        return cidadeDAO;
    }

    @Override
    public List<UniqueField> getUniqueFields() {
        return new UniqueFields().add("nome","estado");
    }

    @Override
    public void validate(Cidade cidade) throws BusinessException {
    }

    @Override
    public boolean isAudit() {
        return true;
    }

}
