package br.com.jsoft.centralfinanceira.bo.central;

import com.xpert.core.crud.AbstractBusinessObject;
import br.com.jsoft.centralfinanceira.dao.central.FatosBanPopDAO;
import com.xpert.core.validation.UniqueField;
import com.xpert.core.exception.BusinessException;
import java.util.List;
import javax.ejb.EJB;
import javax.ejb.Stateless;
import br.com.jsoft.centralfinanceira.modelo.central.FatosBanPop;
import br.com.jsoft.centralfinanceira.vo.ComissaoConvenioVO;
import br.com.jsoft.centralfinanceira.vo.ComissaoLojaVO;

/**
 *
 * @author ti05
 */
@Stateless
public class FatosBanPopBO extends AbstractBusinessObject<FatosBanPop> {

    @EJB
    private FatosBanPopDAO fatosBanPopDAO;
    
    @Override
    public FatosBanPopDAO getDAO() {
        return fatosBanPopDAO;
    }

    @Override
    public List<UniqueField> getUniqueFields() {
        return null;
    }

    @Override
    public void validate(FatosBanPop fatosBanPop) throws BusinessException {
    }

    @Override
    public boolean isAudit() {
        return true;
    }
    
    public void updateUniConvenio(ComissaoConvenioVO comissaoConvenio) {
        fatosBanPopDAO.updateUnitarioConvenio(comissaoConvenio.getId(), comissaoConvenio.getUnitarioconvenio(), comissaoConvenio.getPeriodo());
    }

    public void updateUniLoja(ComissaoLojaVO comissaoLoja) {
        fatosBanPopDAO.updateUnitarioLoja(comissaoLoja.getId(), comissaoLoja.getUnitarioloja(), comissaoLoja.getPeriodo());
    }

}
