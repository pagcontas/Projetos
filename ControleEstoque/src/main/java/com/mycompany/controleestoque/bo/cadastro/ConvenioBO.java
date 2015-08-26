package com.mycompany.controleestoque.bo.cadastro;

import com.xpert.core.crud.AbstractBusinessObject;
import com.mycompany.controleestoque.dao.cadastro.ConvenioDAO;
import com.xpert.core.validation.UniqueField;
import com.xpert.core.exception.BusinessException;
import java.util.List;
import javax.ejb.EJB;
import javax.ejb.Stateless;
import com.mycompany.controleestoque.modelo.cadastro.Convenio;

/**
 *
 * @author juniel
 */
@Stateless
public class ConvenioBO extends AbstractBusinessObject<Convenio> {

    @EJB
    private ConvenioDAO convenioDAO;
    
    @Override
    public ConvenioDAO getDAO() {
        return convenioDAO;
    }

    @Override
    public List<UniqueField> getUniqueFields() {
        return null;
    }

    @Override
    public void validate(Convenio convenio) throws BusinessException {
    }

    @Override
    public boolean isAudit() {
        return true;
    }

}
