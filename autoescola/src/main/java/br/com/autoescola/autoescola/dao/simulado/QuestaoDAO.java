package br.com.autoescola.autoescola.dao.simulado;

import com.xpert.persistence.dao.BaseDAO;
import br.com.autoescola.autoescola.modelo.simulado.Questao;
import javax.ejb.Local;

/**
 *
 * @author killerbee
 */
@Local
public interface QuestaoDAO extends BaseDAO<Questao> {
    
}
