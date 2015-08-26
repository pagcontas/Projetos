package br.com.autoescola.autoescola.dao.email;

import com.xpert.persistence.dao.BaseDAO;
import br.com.autoescola.autoescola.modelo.email.ConfiguracaoEmail;
import javax.ejb.Local;

/**
 *
 * @author ayslan
 */
@Local
public interface ConfiguracaoEmailDAO extends BaseDAO<ConfiguracaoEmail> {
    
}
