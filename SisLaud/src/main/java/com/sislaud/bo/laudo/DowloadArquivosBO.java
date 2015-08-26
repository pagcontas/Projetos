package com.sislaud.bo.laudo;

import com.xpert.core.crud.AbstractBusinessObject;
import com.sislaud.dao.laudo.DowloadArquivosDAO;
import com.xpert.core.validation.UniqueField;
import com.xpert.core.exception.BusinessException;
import java.util.List;
import javax.ejb.EJB;
import javax.ejb.Stateless;
import com.sislaud.modelo.laudo.DowloadArquivos;

/**
 *
 * @author KillerBeeTwo
 */
@Stateless
public class DowloadArquivosBO extends AbstractBusinessObject<DowloadArquivos> {

    @EJB
    private DowloadArquivosDAO dowloadArquivosDAO;
    
    @Override
    public DowloadArquivosDAO getDAO() {
        return dowloadArquivosDAO;
    }

    @Override
    public List<UniqueField> getUniqueFields() {
        return null;
    }

    @Override
    public void validate(DowloadArquivos dowloadArquivos) throws BusinessException {
    }

    @Override
    public boolean isAudit() {
        return true;
    }

}
