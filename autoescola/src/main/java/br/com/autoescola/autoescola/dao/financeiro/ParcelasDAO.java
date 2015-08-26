package br.com.autoescola.autoescola.dao.financeiro;

import com.xpert.persistence.dao.BaseDAO;
import br.com.autoescola.autoescola.modelo.financeiro.Parcelas;
import javax.ejb.Local;

/**
 *
 * @author killerbee
 */
@Local
public interface ParcelasDAO extends BaseDAO<Parcelas> {
    
}
