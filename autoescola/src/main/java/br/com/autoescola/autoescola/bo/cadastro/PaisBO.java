package br.com.autoescola.autoescola.bo.cadastro;

import com.xpert.core.crud.AbstractBusinessObject;
import br.com.autoescola.autoescola.dao.cadastro.PaisDAO;
import com.xpert.core.validation.UniqueField;
import com.xpert.core.exception.BusinessException;
import java.util.List;
import javax.ejb.EJB;
import javax.ejb.Stateless;
import br.com.autoescola.autoescola.modelo.cadastro.Pais;
import com.xpert.core.validation.UniqueFields;

/**
 *
 * @author killerbee
 */
@Stateless
public class PaisBO extends AbstractBusinessObject<Pais> {

    @EJB
    private PaisDAO paisDAO;
    
    @Override
    public PaisDAO getDAO() {
        return paisDAO;
    }

    @Override
    public List<UniqueField> getUniqueFields() {
        return new UniqueFields().add("codigo");
    }

    @Override
    public void validate(Pais pais) throws BusinessException {
    }

    @Override
    public boolean isAudit() {
        return true;
    }

}
