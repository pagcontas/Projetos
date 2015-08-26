package br.com.jsoft.centralfinanceira.bo.central;

import com.xpert.core.crud.AbstractBusinessObject;
import br.com.jsoft.centralfinanceira.dao.central.TipoReceitaDAO;
import com.xpert.core.validation.UniqueField;
import com.xpert.core.exception.BusinessException;
import java.util.List;
import javax.ejb.EJB;
import javax.ejb.Stateless;
import br.com.jsoft.centralfinanceira.modelo.central.TipoReceita;

/**
 *
 * @author Juniel
 */
@Stateless
public class TipoReceitaBO extends AbstractBusinessObject<TipoReceita> {

    @EJB
    private TipoReceitaDAO tipoReceitaDAO;
    
    @Override
    public TipoReceitaDAO getDAO() {
        return tipoReceitaDAO;
    }

    @Override
    public List<UniqueField> getUniqueFields() {
        return null;
    }

    @Override
    public void validate(TipoReceita tipoReceita) throws BusinessException {
    }

    @Override
    public boolean isAudit() {
        return true;
    }

}
