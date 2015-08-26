package com.mycompany.controleestoque.bo.cadastro;

import com.xpert.core.crud.AbstractBusinessObject;
import com.mycompany.controleestoque.dao.cadastro.PaisDAO;
import com.xpert.core.validation.UniqueField;
import com.xpert.core.exception.BusinessException;
import java.util.List;
import javax.ejb.EJB;
import javax.ejb.Stateless;
import com.mycompany.controleestoque.modelo.cadastro.Pais;
import com.xpert.core.validation.UniqueFields;

/**
 *
 * @author juniel
 */
@Stateless
public class PaisBO extends AbstractBusinessObject<Pais> {

    @EJB
    private PaisDAO paisDAO;

    @Override
    public PaisDAO getDAO() {
        return paisDAO;
    }

    @Override
    public List<UniqueField> getUniqueFields() {
        return new UniqueFields().add("codigo");
    }

    @Override
    public void validate(Pais pais) throws BusinessException {
    }

    @Override
    public boolean isAudit() {
        return true;
    }

}
