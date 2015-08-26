package br.com.jsoft.centralfinanceira.bo.central;

import com.xpert.core.crud.AbstractBusinessObject;
import br.com.jsoft.centralfinanceira.dao.central.FatosBoletoSiteDAO;
import com.xpert.core.validation.UniqueField;
import com.xpert.core.exception.BusinessException;
import java.util.List;
import javax.ejb.EJB;
import javax.ejb.Stateless;
import br.com.jsoft.centralfinanceira.modelo.central.FatosBoletoSite;
import br.com.jsoft.centralfinanceira.vo.ComissaoConvenioSiteVO;
import br.com.jsoft.centralfinanceira.vo.ComissaoLojaSiteVO;

/**
 *
 * @author Juniel
 */
@Stateless
public class FatosBoletoSiteBO extends AbstractBusinessObject<FatosBoletoSite> {

    @EJB
    private FatosBoletoSiteDAO fatosBoletoSiteDAO;
    
    @Override
    public FatosBoletoSiteDAO getDAO() {
        return fatosBoletoSiteDAO;
    }

    @Override
    public List<UniqueField> getUniqueFields() {
        return null;
    }

    @Override
    public void validate(FatosBoletoSite fatosBoletoSite) throws BusinessException {
    }

    @Override
    public boolean isAudit() {
        return true;
    }   
      
    public void updateUniConvenio(ComissaoConvenioSiteVO comissaoConvenio){
        fatosBoletoSiteDAO.updateUnitarioConvenio(comissaoConvenio.getId(), comissaoConvenio.getUnitarioconvenio(), comissaoConvenio.getPeriodo());
    }
    
    public void updateUniLoja(ComissaoLojaSiteVO comissaoLoja){
        fatosBoletoSiteDAO.updateUnitarioLoja(comissaoLoja.getId(), comissaoLoja.getUnitarioloja(), comissaoLoja.getPeriodo());
    }


}
