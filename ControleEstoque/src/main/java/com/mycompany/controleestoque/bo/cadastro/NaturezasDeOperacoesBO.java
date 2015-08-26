package com.mycompany.controleestoque.bo.cadastro;

import com.xpert.core.crud.AbstractBusinessObject;
import com.mycompany.controleestoque.dao.cadastro.NaturezasDeOperacoesDAO;
import com.xpert.core.validation.UniqueField;
import com.xpert.core.exception.BusinessException;
import java.util.List;
import javax.ejb.EJB;
import javax.ejb.Stateless;
import com.mycompany.controleestoque.modelo.cadastro.NaturezasDeOperacoes;

/**
 *
 * @author juniel
 */
@Stateless
public class NaturezasDeOperacoesBO extends AbstractBusinessObject<NaturezasDeOperacoes> {

    @EJB
    private NaturezasDeOperacoesDAO naturezasDeOperacoesDAO;
    
    @Override
    public NaturezasDeOperacoesDAO getDAO() {
        return naturezasDeOperacoesDAO;
    }

    @Override
    public List<UniqueField> getUniqueFields() {
        return null;
    }

    @Override
    public void validate(NaturezasDeOperacoes naturezasDeOperacoes) throws BusinessException {
    }

    @Override
    public boolean isAudit() {
        return true;
    }

}
