package br.com.autoescola.autoescola.bo.simulado;

import com.xpert.core.crud.AbstractBusinessObject;
import br.com.autoescola.autoescola.dao.simulado.QuestaoDAO;
import com.xpert.core.validation.UniqueField;
import com.xpert.core.exception.BusinessException;
import java.util.List;
import javax.ejb.EJB;
import javax.ejb.Stateless;
import br.com.autoescola.autoescola.modelo.simulado.Questao;

/**
 *
 * @author killerbee
 */
@Stateless
public class QuestaoBO extends AbstractBusinessObject<Questao> {

    @EJB
    private QuestaoDAO questaoDAO;
    
    @Override
    public QuestaoDAO getDAO() {
        return questaoDAO;
    }

    @Override
    public List<UniqueField> getUniqueFields() {
        return null;
    }

    @Override
    public void validate(Questao questao) throws BusinessException {
    }

    @Override
    public boolean isAudit() {
        return true;
    }

}
