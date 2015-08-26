package br.com.autoescola.autoescola.bo.cadastro;

import com.xpert.core.crud.AbstractBusinessObject;
import br.com.autoescola.autoescola.dao.cadastro.AlunoDAO;
import com.xpert.core.validation.UniqueField;
import com.xpert.core.exception.BusinessException;
import java.util.List;
import javax.ejb.EJB;
import javax.ejb.Stateless;
import br.com.autoescola.autoescola.modelo.cadastro.Aluno;
import com.xpert.core.validation.UniqueFields;
import java.util.Calendar;
import java.util.Date;

/**
 *
 * @author killerbee
 */
@Stateless
public class AlunoBO extends AbstractBusinessObject<Aluno> {

    @EJB
    private AlunoDAO alunoDAO;

    @Override
    public AlunoDAO getDAO() {
        return alunoDAO;
    }

    @Override
    public List<UniqueField> getUniqueFields() {
        return new UniqueFields().add("cpf").add("numeroRenach").add("numeroCNH");
    }

    @Override
    public void validate(Aluno aluno) throws BusinessException {
    }

    @Override
    public boolean isAudit() {
        return true;
    }

    @Override
    public void save(Aluno object) throws BusinessException {
        if (object.getDataDoProcesso() != null) {
            object.setDataValidadeProcesso(somaDataUmAno(object.getDataDoProcesso()));
        }
        super.save(object); //To change body of generated methods, choose Tools | Templates.
    }

    private Date somaDataUmAno(Date data) {

        Calendar a = Calendar.getInstance();

        a.setTime(data);

        a.set(Calendar.YEAR, a.get(Calendar.YEAR) + 1);

        return a.getTime();
    }

}
