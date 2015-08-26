package br.com.jsoft.centralfinanceira.bo.central;

import com.xpert.core.crud.AbstractBusinessObject;
import br.com.jsoft.centralfinanceira.dao.central.TipoLojaDAO;
import com.xpert.core.validation.UniqueField;
import com.xpert.core.exception.BusinessException;
import java.util.List;
import javax.ejb.EJB;
import javax.ejb.Stateless;
import br.com.jsoft.centralfinanceira.modelo.central.TipoLoja;

/**
 *
 * @author KillerBeeTwo
 */
@Stateless
public class TipoLojaBO extends AbstractBusinessObject<TipoLoja> {

    @EJB
    private TipoLojaDAO tipoLojaDAO;
    
    @Override
    public TipoLojaDAO getDAO() {
        return tipoLojaDAO;
    }

    @Override
    public List<UniqueField> getUniqueFields() {
        return null;
    }

    @Override
    public void validate(TipoLoja tipoLoja) throws BusinessException {
    }

    @Override
    public boolean isAudit() {
        return true;
    }

}
