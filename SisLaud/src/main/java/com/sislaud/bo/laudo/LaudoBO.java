package com.sislaud.bo.laudo;

import com.xpert.core.crud.AbstractBusinessObject;
import com.sislaud.dao.laudo.LaudoDAO;
import com.xpert.core.validation.UniqueField;
import com.xpert.core.exception.BusinessException;
import java.util.List;
import javax.ejb.EJB;
import javax.ejb.Stateless;
import com.sislaud.modelo.laudo.Laudo;

/**
 *
 * @author KillerBeeTwo
 */
@Stateless
public class LaudoBO extends AbstractBusinessObject<Laudo> {

    @EJB
    private LaudoDAO laudoDAO;
    
    @Override
    public LaudoDAO getDAO() {
        return laudoDAO;
    }

    @Override
    public List<UniqueField> getUniqueFields() {
        return null;
    }

    @Override
    public void validate(Laudo laudo) throws BusinessException {
    }

    @Override
    public boolean isAudit() {
        return true;
    }

}
