package br.com.jsoft.centralfinanceira.bo.central;

import com.xpert.core.crud.AbstractBusinessObject;
import br.com.jsoft.centralfinanceira.dao.central.FatosopsDAO;
import com.xpert.core.validation.UniqueField;
import com.xpert.core.exception.BusinessException;
import java.util.List;
import javax.ejb.EJB;
import javax.ejb.Stateless;
import br.com.jsoft.centralfinanceira.modelo.central.Fatosops;
import br.com.jsoft.centralfinanceira.vo.ComissaoConvenioOPVO;
import br.com.jsoft.centralfinanceira.vo.ComissaoLojaOPVO;

/**
 *
 * @author Juniel
 */
@Stateless
public class FatosopsBO extends AbstractBusinessObject<Fatosops> {

    @EJB
    private FatosopsDAO fatosopsDAO;
    
    @Override
    public FatosopsDAO getDAO() {
        return fatosopsDAO;
    }

    @Override
    public List<UniqueField> getUniqueFields() {
        return null;
    }

    @Override
    public void validate(Fatosops fatosops) throws BusinessException {
    }

    @Override
    public boolean isAudit() {
        return true;
    }
    
    public void updateUniConvenio(ComissaoConvenioOPVO comissaoConvenio){
        fatosopsDAO.updateUnitarioConvenio(comissaoConvenio.getId(), comissaoConvenio.getUnitarioconvenio(), comissaoConvenio.getPeriodo());
    }
    
    public void updateUniLoja(ComissaoLojaOPVO comissaoLoja){
        fatosopsDAO.updateUnitarioLoja(comissaoLoja.getId(), comissaoLoja.getUnitarioloja(), comissaoLoja.getPeriodo());
    }

}
