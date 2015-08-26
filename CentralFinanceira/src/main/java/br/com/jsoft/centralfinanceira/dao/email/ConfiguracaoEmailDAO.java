package br.com.jsoft.centralfinanceira.dao.email;

import com.xpert.persistence.dao.BaseDAO;
import br.com.jsoft.centralfinanceira.modelo.email.ConfiguracaoEmail;
import javax.ejb.Local;

/**
 *
 * @author ayslan
 */
@Local
public interface ConfiguracaoEmailDAO extends BaseDAO<ConfiguracaoEmail> {
    
}
