package br.com.jsoft.centralfinanceira.dao.central;

import com.xpert.persistence.dao.BaseDAO;
import br.com.jsoft.centralfinanceira.modelo.central.FatosBoletoSite;
import br.com.jsoft.centralfinanceira.vo.ComissaoConvenioSiteVO;
import br.com.jsoft.centralfinanceira.vo.ComissaoLojaSiteVO;
import java.math.BigDecimal;
import java.util.List;
import javax.ejb.Local;

/**
 *
 * @author Juniel
 */
@Local
public interface FatosBoletoSiteDAO extends BaseDAO<FatosBoletoSite> {
    public void updateUnitarioConvenio(Long id, BigDecimal valor, Integer periodo);
    public void updateUnitarioLoja(Long id, BigDecimal valor, Integer periodo);
    public List<ComissaoConvenioSiteVO> listBoletoConvenio();
    public List<ComissaoLojaSiteVO> listBoletoLoja();
}
