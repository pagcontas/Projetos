package br.com.jsoft.centralfinanceira.bo.central;

import com.xpert.core.crud.AbstractBusinessObject;
import br.com.jsoft.centralfinanceira.dao.central.FatosbbDAO;
import com.xpert.core.validation.UniqueField;
import com.xpert.core.exception.BusinessException;
import java.util.List;
import javax.ejb.EJB;
import javax.ejb.Stateless;
import br.com.jsoft.centralfinanceira.modelo.central.Fatosbb;
import br.com.jsoft.centralfinanceira.vo.ComissaoConvenioVO;
import br.com.jsoft.centralfinanceira.vo.ComissaoLojaVO;

/**
 *
 * @author ti05
 */
@Stateless
public class FatosbbBO extends AbstractBusinessObject<Fatosbb> {

    @EJB
    private FatosbbDAO fatosbbDAO;
    
    @Override
    public FatosbbDAO getDAO() {
        return fatosbbDAO;
    }

    @Override
    public List<UniqueField> getUniqueFields() {
        return null;
    }

    @Override
    public void validate(Fatosbb fatosbb) throws BusinessException {
    }

    @Override
    public boolean isAudit() {
        return true;
    }

    public void updateUniConvenio(ComissaoConvenioVO comissaoConvenio) {
        fatosbbDAO.updateUnitarioConvenio(comissaoConvenio.getId(), comissaoConvenio.getUnitarioconvenio(), comissaoConvenio.getPeriodo());
    }

    public void updateUniLoja(ComissaoLojaVO comissaoLoja) {
        fatosbbDAO.updateUnitarioLoja(comissaoLoja.getId(), comissaoLoja.getUnitarioloja(), comissaoLoja.getPeriodo());
    }
    
}
