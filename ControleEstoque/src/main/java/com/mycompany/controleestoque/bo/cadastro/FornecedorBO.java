package com.mycompany.controleestoque.bo.cadastro;

import com.xpert.core.crud.AbstractBusinessObject;
import com.mycompany.controleestoque.dao.cadastro.FornecedorDAO;
import com.xpert.core.validation.UniqueField;
import com.xpert.core.exception.BusinessException;
import java.util.List;
import javax.ejb.EJB;
import javax.ejb.Stateless;
import com.mycompany.controleestoque.modelo.cadastro.Fornecedor;
import com.xpert.core.validation.UniqueFields;

/**
 *
 * @author juniel
 */
@Stateless
public class FornecedorBO extends AbstractBusinessObject<Fornecedor> {

    @EJB
    private FornecedorDAO fornecedorDAO;
    
    @Override
    public FornecedorDAO getDAO() {
        return fornecedorDAO;
    }

    @Override
    public List<UniqueField> getUniqueFields() {
        return new UniqueFields().add("cnpj");
    }

    @Override
    public void validate(Fornecedor fornecedor) throws BusinessException {
    }

    @Override
    public boolean isAudit() {
        return true;
    }

}
