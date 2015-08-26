package br.com.jsoft.centralfinanceira.bo.central;

import com.xpert.core.crud.AbstractBusinessObject;
import br.com.jsoft.centralfinanceira.dao.central.FatosCreditosDAO;
import com.xpert.core.validation.UniqueField;
import com.xpert.core.exception.BusinessException;
import java.util.List;
import javax.ejb.EJB;
import javax.ejb.Stateless;
import br.com.jsoft.centralfinanceira.modelo.central.FatosCreditos;
import br.com.jsoft.centralfinanceira.vo.ComissaoConvenioCredVO;
import br.com.jsoft.centralfinanceira.vo.ComissaoLojaCredVO;

/**
 *
 * @author Juniel
 */
@Stateless
public class FatosCreditosBO extends AbstractBusinessObject<FatosCreditos> {

    @EJB
    private FatosCreditosDAO fatosCreditosDAO;
    
    @Override
    public FatosCreditosDAO getDAO() {
        return fatosCreditosDAO;
    }

    @Override
    public List<UniqueField> getUniqueFields() {
        return null;
    }

    @Override
    public void validate(FatosCreditos fatosCreditos) throws BusinessException {
    }

    @Override
    public boolean isAudit() {
        return true;
    }
    
    public void updateUniConvenio(ComissaoConvenioCredVO comissaoConvenio){
        fatosCreditosDAO.updateUnitarioConvenio(comissaoConvenio.getId(), comissaoConvenio.getUnitarioconvenio(), comissaoConvenio.getPeriodo());
    }
    
    public void updateUniLoja(ComissaoLojaCredVO comissaoLoja){
        fatosCreditosDAO.updateUnitarioLoja(comissaoLoja.getId(), comissaoLoja.getUnitarioloja(), comissaoLoja.getPeriodo());
    }

}
