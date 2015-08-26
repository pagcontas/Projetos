package com.mycompany.controleestoque.bo.cadastro;

import com.xpert.core.crud.AbstractBusinessObject;
import com.mycompany.controleestoque.dao.cadastro.Loja_FilialDAO;
import com.xpert.core.validation.UniqueField;
import com.xpert.core.exception.BusinessException;
import java.util.List;
import javax.ejb.EJB;
import javax.ejb.Stateless;
import com.mycompany.controleestoque.modelo.cadastro.Loja_Filial;
import com.xpert.core.validation.UniqueFields;

/**
 *
 * @author juniel
 */
@Stateless
public class Loja_FilialBO extends AbstractBusinessObject<Loja_Filial> {

    @EJB
    private Loja_FilialDAO loja_FilialDAO;
    
    @Override
    public Loja_FilialDAO getDAO() {
        return loja_FilialDAO;
    }

    @Override
    public List<UniqueField> getUniqueFields() {
        return new UniqueFields().add("cnpj");
    }

    @Override
    public void validate(Loja_Filial loja_Filial) throws BusinessException {
    }

    @Override
    public boolean isAudit() {
        return true;
    }

}
