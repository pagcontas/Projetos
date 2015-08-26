package com.uparquivos.bo.arquivos;

import com.xpert.core.crud.AbstractBusinessObject;
import com.uparquivos.dao.arquivos.BaseLegalDAO;
import com.xpert.core.validation.UniqueField;
import com.xpert.core.exception.BusinessException;
import java.util.List;
import javax.ejb.EJB;
import javax.ejb.Stateless;
import com.uparquivos.modelo.upArquivos.BaseLegal;

/**
 *
 * @author KillerBeeTwo
 */
@Stateless
public class BaseLegalBO extends AbstractBusinessObject<BaseLegal> {

    @EJB
    private BaseLegalDAO baseLegalDAO;
    
    @Override
    public BaseLegalDAO getDAO() {
        return baseLegalDAO;
    }

    @Override
    public List<UniqueField> getUniqueFields() {
        return null;
    }

    @Override
    public void validate(BaseLegal baseLegal) throws BusinessException {
    }

    @Override
    public boolean isAudit() {
        return true;
    }

}
