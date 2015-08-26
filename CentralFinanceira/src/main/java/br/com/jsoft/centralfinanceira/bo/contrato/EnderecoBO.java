package br.com.jsoft.centralfinanceira.bo.contrato;

import com.xpert.core.crud.AbstractBusinessObject;
import br.com.jsoft.centralfinanceira.dao.contrato.EnderecoDAO;
import com.xpert.core.validation.UniqueField;
import com.xpert.core.exception.BusinessException;
import java.util.List;
import javax.ejb.EJB;
import javax.ejb.Stateless;
import br.com.jsoft.centralfinanceira.modelo.contrato.Endereco;

/**
 *
 * @author KillerBeeTwo
 */
@Stateless
public class EnderecoBO extends AbstractBusinessObject<Endereco> {

    @EJB
    private EnderecoDAO enderecoDAO;
    
    @Override
    public EnderecoDAO getDAO() {
        return enderecoDAO;
    }

    @Override
    public List<UniqueField> getUniqueFields() {
        return null;
    }

    @Override
    public void validate(Endereco endereco) throws BusinessException {
    }

    @Override
    public boolean isAudit() {
        return true;
    }

}
