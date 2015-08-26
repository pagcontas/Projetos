package com.mycompany.controleestoque.bo.cadastro;

import com.xpert.core.crud.AbstractBusinessObject;
import com.mycompany.controleestoque.dao.cadastro.ClienteDAO;
import com.xpert.core.validation.UniqueField;
import com.xpert.core.exception.BusinessException;
import java.util.List;
import javax.ejb.EJB;
import javax.ejb.Stateless;
import com.mycompany.controleestoque.modelo.cadastro.Cliente;
import com.xpert.core.validation.UniqueFields;

/**
 *
 * @author juniel
 */
@Stateless
public class ClienteBO extends AbstractBusinessObject<Cliente> {

    @EJB
    private ClienteDAO clienteDAO;

    @Override
    public ClienteDAO getDAO() {
        return clienteDAO;
    }

    @Override
    public List<UniqueField> getUniqueFields() {
       
        return  new UniqueFields().add("cpf").add("cnpj");
        
    }

    @Override
    public void validate(Cliente cliente) throws BusinessException {
    }

    @Override
    public boolean isAudit() {
        return true;
    }

}
