package br.com.autoescola.autoescola.dao.cadastro;

import com.xpert.persistence.dao.BaseDAO;
import br.com.autoescola.autoescola.modelo.cadastro.Aluno;
import javax.ejb.Local;

/**
 *
 * @author killerbee
 */
@Local
public interface AlunoDAO extends BaseDAO<Aluno> {
    
}
