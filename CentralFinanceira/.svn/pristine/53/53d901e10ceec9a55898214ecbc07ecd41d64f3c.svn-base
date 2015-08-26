package br.com.jsoft.centralfinanceira.dao.central;

import com.xpert.persistence.dao.BaseDAO;
import br.com.jsoft.centralfinanceira.modelo.central.FatosBanPop;
import br.com.jsoft.centralfinanceira.vo.ComissaoConvenioVO;
import br.com.jsoft.centralfinanceira.vo.ComissaoLojaVO;
import java.math.BigDecimal;
import java.util.List;
import javax.ejb.Local;

/**
 *
 * @author ti05
 */
@Local
public interface FatosBanPopDAO extends BaseDAO<FatosBanPop> {
    public void updateUnitarioConvenio(Long id, BigDecimal valor, Integer periodo);
    public void updateUnitarioLoja(Long id, BigDecimal valor, Integer periodo);
    public List<ComissaoConvenioVO> listBoletoConvenio();
    public List<ComissaoLojaVO> listBoletoLoja();  
}
