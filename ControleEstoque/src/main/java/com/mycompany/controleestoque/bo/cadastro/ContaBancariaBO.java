package com.mycompany.controleestoque.bo.cadastro;

import com.xpert.core.crud.AbstractBusinessObject;
import com.mycompany.controleestoque.dao.cadastro.ContaBancariaDAO;
import com.xpert.core.validation.UniqueField;
import com.xpert.core.exception.BusinessException;
import java.util.List;
import javax.ejb.EJB;
import javax.ejb.Stateless;
import com.mycompany.controleestoque.modelo.cadastro.ContaBancaria;

/**
 *
 * @author KillerBeeTwo
 */
@Stateless
public class ContaBancariaBO extends AbstractBusinessObject<ContaBancaria> {

    @EJB
    private ContaBancariaDAO contaBancariaDAO;
    
    @Override
    public ContaBancariaDAO getDAO() {
        return contaBancariaDAO;
    }

    @Override
    public List<UniqueField> getUniqueFields() {
        return null;
    }

    @Override
    public void validate(ContaBancaria contaBancaria) throws BusinessException {
    }

    @Override
    public boolean isAudit() {
        return true;
    }

}
