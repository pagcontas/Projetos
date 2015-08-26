package br.com.jsoft.centralfinanceira.dao.central;

import com.xpert.persistence.dao.BaseDAO;
import br.com.jsoft.centralfinanceira.modelo.central.FatosRecarga;
import br.com.jsoft.centralfinanceira.vo.ComissaoConvenioRecargaVO;
import br.com.jsoft.centralfinanceira.vo.ComissaoLojaRecargaVO;
import java.math.BigDecimal;
import java.util.List;
import javax.ejb.Local;

/**
 *
 * @author Juniel
 */
@Local
public interface FatosRecargaDAO extends BaseDAO<FatosRecarga> {
    public void updateUnitarioConvenio(Long id, BigDecimal valor, Integer periodo);
    public void updateUnitarioLoja(Long id, BigDecimal valor, Integer periodo);
    public List<ComissaoConvenioRecargaVO> listBoletoConvenio();
    public List<ComissaoLojaRecargaVO> listBoletoLoja();
}
