package br.com.autoescola.autoescola.dao.controleacesso;

import com.xpert.persistence.dao.BaseDAO;
import br.com.autoescola.autoescola.modelo.controleacesso.AcessoSistema;
import javax.ejb.Local;

/**
 *
 * @author ayslan
 */
@Local
public interface AcessoSistemaDAO extends BaseDAO<AcessoSistema> {
    
}
