package br.com.jsoft.centralfinanceira.dao.central;

import com.xpert.persistence.dao.BaseDAO;
import br.com.jsoft.centralfinanceira.modelo.central.Fatosops;
import br.com.jsoft.centralfinanceira.vo.ComissaoConvenioOPVO;
import br.com.jsoft.centralfinanceira.vo.ComissaoLojaOPVO;
import java.math.BigDecimal;
import java.util.List;
import javax.ejb.Local;

/**
 *
 * @author Juniel
 */
@Local
public interface FatosopsDAO extends BaseDAO<Fatosops> {
    public void updateUnitarioConvenio(Long id, BigDecimal valor, Integer periodo);
    public void updateUnitarioLoja(Long id, BigDecimal valor, Integer periodo);
    public List<ComissaoConvenioOPVO> listBoletoConvenio();
    public List<ComissaoLojaOPVO> listBoletoLoja();
}
