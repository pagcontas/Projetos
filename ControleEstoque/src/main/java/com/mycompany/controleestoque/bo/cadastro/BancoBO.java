package com.mycompany.controleestoque.bo.cadastro;

import com.xpert.core.crud.AbstractBusinessObject;
import com.mycompany.controleestoque.dao.cadastro.BancoDAO;
import com.xpert.core.validation.UniqueField;
import com.xpert.core.exception.BusinessException;
import java.util.List;
import javax.ejb.EJB;
import javax.ejb.Stateless;
import com.mycompany.controleestoque.modelo.cadastro.Banco;

/**
 *
 * @author juniel
 */
@Stateless
public class BancoBO extends AbstractBusinessObject<Banco> {

    @EJB
    private BancoDAO bancoDAO;
    
    @Override
    public BancoDAO getDAO() {
        return bancoDAO;
    }

    @Override
    public List<UniqueField> getUniqueFields() {
        return null;
    }

    @Override
    public void validate(Banco banco) throws BusinessException {
    }

    @Override
    public boolean isAudit() {
        return true;
    }

}
