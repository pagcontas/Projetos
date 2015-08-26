package com.mycompany.controleestoque.bo.cadastro;

import com.xpert.core.crud.AbstractBusinessObject;
import com.mycompany.controleestoque.dao.cadastro.SecoesProdutoDAO;
import com.xpert.core.validation.UniqueField;
import com.xpert.core.exception.BusinessException;
import java.util.List;
import javax.ejb.EJB;
import javax.ejb.Stateless;
import com.mycompany.controleestoque.modelo.cadastro.SecoesProduto;
import com.xpert.core.validation.UniqueFields;

/**
 *
 * @author juniel
 */
@Stateless
public class SecoesProdutoBO extends AbstractBusinessObject<SecoesProduto> {

    @EJB
    private SecoesProdutoDAO secoesProdutoDAO;
    
    @Override
    public SecoesProdutoDAO getDAO() {
        return secoesProdutoDAO;
    }

    @Override
    public List<UniqueField> getUniqueFields() {
        return new UniqueFields().add("codigo");
    }

    @Override
    public void validate(SecoesProduto secoesProduto) throws BusinessException {
    }

    @Override
    public boolean isAudit() {
        return true;
    }

}
