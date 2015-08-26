package com.mycompany.controleestoque.bo.cadastro;

import com.xpert.core.crud.AbstractBusinessObject;
import com.mycompany.controleestoque.dao.cadastro.SituacaoTributariaDAO;
import com.xpert.core.validation.UniqueField;
import com.xpert.core.exception.BusinessException;
import java.util.List;
import javax.ejb.EJB;
import javax.ejb.Stateless;
import com.mycompany.controleestoque.modelo.cadastro.SituacaoTributaria;
import com.xpert.core.validation.UniqueFields;

/**
 *
 * @author juniel
 */
@Stateless
public class SituacaoTributariaBO extends AbstractBusinessObject<SituacaoTributaria> {

    @EJB
    private SituacaoTributariaDAO situacaoTributariaDAO;
    
    @Override
    public SituacaoTributariaDAO getDAO() {
        return situacaoTributariaDAO;
    }

    @Override
    public List<UniqueField> getUniqueFields() {
        return new UniqueFields().add("codigo");
    }

    @Override
    public void validate(SituacaoTributaria situacaoTributaria) throws BusinessException {
    }

    @Override
    public boolean isAudit() {
        return true;
    }

}
