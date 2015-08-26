package br.com.jsoft.centralfinanceira.dao.central;

import com.xpert.persistence.dao.BaseDAO;
import br.com.jsoft.centralfinanceira.modelo.central.ConvenioBoleto;
import java.util.List;
import javax.ejb.Local;

/**
 *
 * @author Juniel
 */
@Local
public interface ConvenioBoletoDAO extends BaseDAO<ConvenioBoleto> {
    public List<ConvenioBoleto> getConvenioPorNome(String nome);
}
