package br.com.jsoft.centralfinanceira.bo.central;

import com.xpert.core.crud.AbstractBusinessObject;
import br.com.jsoft.centralfinanceira.dao.central.FatosValeGasDAO;
import com.xpert.core.validation.UniqueField;
import com.xpert.core.exception.BusinessException;
import java.util.List;
import javax.ejb.EJB;
import javax.ejb.Stateless;
import br.com.jsoft.centralfinanceira.modelo.central.FatosValeGas;
import br.com.jsoft.centralfinanceira.vo.ComissaoConvenioGasVO;
import br.com.jsoft.centralfinanceira.vo.ComissaoLojaGasVO;

/**
 *
 * @author Juniel
 */
@Stateless
public class FatosValeGasBO extends AbstractBusinessObject<FatosValeGas> {

    @EJB
    private FatosValeGasDAO fatosValeGasDAO;
    
    @Override
    public FatosValeGasDAO getDAO() {
        return fatosValeGasDAO;
    }

    @Override
    public List<UniqueField> getUniqueFields() {
        return null;
    }

    @Override
    public void validate(FatosValeGas fatosValeGas) throws BusinessException {
    }

    @Override
    public boolean isAudit() {
        return true;
    }
    
    public void updateUniConvenio(ComissaoConvenioGasVO comissaoConvenio){
        fatosValeGasDAO.updateUnitarioConvenio(comissaoConvenio.getId(), comissaoConvenio.getUnitarioconvenio(), comissaoConvenio.getPeriodo());
    }
    
    public void updateUniLoja(ComissaoLojaGasVO comissaoLoja){
        fatosValeGasDAO.updateUnitarioLoja(comissaoLoja.getId(), comissaoLoja.getUnitarioloja(), comissaoLoja.getPeriodo());
    }

}
