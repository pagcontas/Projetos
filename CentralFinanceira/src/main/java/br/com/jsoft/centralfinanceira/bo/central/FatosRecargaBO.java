package br.com.jsoft.centralfinanceira.bo.central;

import com.xpert.core.crud.AbstractBusinessObject;
import br.com.jsoft.centralfinanceira.dao.central.FatosRecargaDAO;
import com.xpert.core.validation.UniqueField;
import com.xpert.core.exception.BusinessException;
import java.util.List;
import javax.ejb.EJB;
import javax.ejb.Stateless;
import br.com.jsoft.centralfinanceira.modelo.central.FatosRecarga;
import br.com.jsoft.centralfinanceira.vo.ComissaoConvenioGasVO;
import br.com.jsoft.centralfinanceira.vo.ComissaoConvenioRecargaVO;
import br.com.jsoft.centralfinanceira.vo.ComissaoLojaGasVO;
import br.com.jsoft.centralfinanceira.vo.ComissaoLojaRecargaVO;

/**
 *
 * @author Juniel
 */
@Stateless
public class FatosRecargaBO extends AbstractBusinessObject<FatosRecarga> {

    @EJB
    private FatosRecargaDAO fatosRecargaDAO;
    
    @Override
    public FatosRecargaDAO getDAO() {
        return fatosRecargaDAO;
    }

    @Override
    public List<UniqueField> getUniqueFields() {
        return null;
    }

    @Override
    public void validate(FatosRecarga fatosRecarga) throws BusinessException {
    }

    @Override
    public boolean isAudit() {
        return true;
    }

     public void updateUniConvenio(ComissaoConvenioRecargaVO comissaoConvenio){
        fatosRecargaDAO.updateUnitarioConvenio(comissaoConvenio.getId(), comissaoConvenio.getUnitarioconvenio(), comissaoConvenio.getPeriodo());
    }
    
    public void updateUniLoja(ComissaoLojaRecargaVO comissaoLoja){
        fatosRecargaDAO.updateUnitarioLoja(comissaoLoja.getId(), comissaoLoja.getUnitarioloja(), comissaoLoja.getPeriodo());
    }
}
