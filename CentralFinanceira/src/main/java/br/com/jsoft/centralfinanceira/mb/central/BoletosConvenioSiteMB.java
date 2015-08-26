package br.com.jsoft.centralfinanceira.mb.central;

import br.com.jsoft.centralfinanceira.bo.central.FatosBoletoSiteBO;
import java.io.Serializable;
import com.xpert.core.crud.AbstractBaseBean;
import javax.ejb.EJB;
import javax.faces.bean.ManagedBean;
import javax.faces.bean.ViewScoped;
import br.com.jsoft.centralfinanceira.dao.central.FatosBoletoSiteDAO;
import br.com.jsoft.centralfinanceira.modelo.central.FatosBoletoSite;
import br.com.jsoft.centralfinanceira.vo.ComissaoConvenioSiteVO;
import java.math.BigDecimal;
import java.math.RoundingMode;
import java.util.List;

/**
 *
 * @author Juniel
 */
@ManagedBean
@ViewScoped
public class BoletosConvenioSiteMB extends AbstractBaseBean<FatosBoletoSite> implements Serializable {

    @EJB
    private FatosBoletoSiteBO fatosBoletosBO;

    @EJB
    private FatosBoletoSiteDAO fatosBoletosDAO;

    private List<FatosBoletoSite> fatos;

    private List<ComissaoConvenioSiteVO> comissaoBoletos;

    private ComissaoConvenioSiteVO comissaoConvenio;

    List<ComissaoConvenioSiteVO> fatosBoletosFiltrados;

    public List<ComissaoConvenioSiteVO> getFatosBoletosFiltrados() {
        return fatosBoletosFiltrados;
    }

    public void setFatosBoletosFiltrados(List<ComissaoConvenioSiteVO> fatosBoletosFiltrados) {
        this.fatosBoletosFiltrados = fatosBoletosFiltrados;
    }

    public ComissaoConvenioSiteVO getComissaoConvenio() {
        return comissaoConvenio;
    }

    public void setComissaoConvenio(ComissaoConvenioSiteVO comissaoConvenio) {
        this.comissaoConvenio = comissaoConvenio;
    }

    @Override
    public FatosBoletoSiteBO getBO() {
        return fatosBoletosBO;
    }

    public void updateUnitarioConvenio() {
        fatosBoletosBO.updateUniConvenio(comissaoConvenio);
    }

    @Override
    public String getDataModelOrder() {
        return "id";
    }

    public void setFatos(List<FatosBoletoSite> fatos) {
        this.fatos = fatos;
    }

    public List<ComissaoConvenioSiteVO> getComissaoBoletos() {
        return comissaoBoletos;
    }

    public void setComissaoBoletos(List<ComissaoConvenioSiteVO> comissaoBoletos) {
        this.comissaoBoletos = comissaoBoletos;
    }

    public FatosBoletoSiteBO getFatosBoletosBO() {
        return fatosBoletosBO;
    }

    public void setFatosBoletosBO(FatosBoletoSiteBO fatosBoletosBO) {
        this.fatosBoletosBO = fatosBoletosBO;
    }

    public FatosBoletoSiteDAO getFatosBoletosDAO() {
        return fatosBoletosDAO;
    }

    public void setFatosBoletosDAO(FatosBoletoSiteDAO fatosBoletosDAO) {
        this.fatosBoletosDAO = fatosBoletosDAO;
    }

    @Override
    public void init() {
        comissaoBoletos = fatosBoletosDAO.listBoletoConvenio();
    }

    public BigDecimal totalArrecadadoPaginaAtual() {

        BigDecimal valor = BigDecimal.ZERO;
        List<ComissaoConvenioSiteVO> fatosBoletos;
        if (fatosBoletosFiltrados != null) {
            fatosBoletos = (List<ComissaoConvenioSiteVO>) fatosBoletosFiltrados;
        } else {
            fatosBoletos = (List<ComissaoConvenioSiteVO>) comissaoBoletos;
        }
        for (ComissaoConvenioSiteVO fb : fatosBoletos) {
            if (fb.getArrecadado() != null) {
                valor = valor.add(fb.getArrecadado());

            }
        }
        return valor;
    }

    public BigDecimal totalUniConvenioPaginaAtual() {

        BigDecimal valor = BigDecimal.ZERO;
        List<ComissaoConvenioSiteVO> fatosBoletos;
        if (fatosBoletosFiltrados != null) {
            fatosBoletos = (List<ComissaoConvenioSiteVO>) fatosBoletosFiltrados;
        } else {
            fatosBoletos = (List<ComissaoConvenioSiteVO>) comissaoBoletos;
        }
        for (ComissaoConvenioSiteVO fb : fatosBoletos) {
            if (fb.getUnitarioconvenio() != null) {
                valor = valor.add(fb.getUnitarioconvenio());

            }
        }
        return valor.divide(new BigDecimal(fatosBoletos.size()), 2, RoundingMode.HALF_UP);
    }

    public Integer totalQtdPaginaAtual() {
        Integer total = 0;
        List<ComissaoConvenioSiteVO> fatosBoletos;
        if (fatosBoletosFiltrados != null) {
            fatosBoletos = (List<ComissaoConvenioSiteVO>) fatosBoletosFiltrados;
        } else {
            fatosBoletos = (List<ComissaoConvenioSiteVO>) comissaoBoletos;
        }
        for (ComissaoConvenioSiteVO fb : fatosBoletos) {
            if (fb.getQtd() != null) {
                total += fb.getQtd();

            }
        }
        return total;
    }

    public BigDecimal totalComLojaPaginaAtual() {

        BigDecimal valor = BigDecimal.ZERO;
        List<ComissaoConvenioSiteVO> fatosBoletos;
        if (fatosBoletosFiltrados != null) {
            fatosBoletos = (List<ComissaoConvenioSiteVO>) fatosBoletosFiltrados;
        } else {
            fatosBoletos = (List<ComissaoConvenioSiteVO>) comissaoBoletos;
        }
        for (ComissaoConvenioSiteVO fb : fatosBoletos) {
            if (fb.getComissaoloja() != null) {
                valor = valor.add(fb.getComissaoloja());

            }
        }
        return valor;
    }

    public BigDecimal totalComConvenioPaginaAtual() {

        BigDecimal valor = BigDecimal.ZERO;
        List<ComissaoConvenioSiteVO> fatosBoletos;
        if (fatosBoletosFiltrados != null) {
            fatosBoletos = (List<ComissaoConvenioSiteVO>) fatosBoletosFiltrados;
        } else {
            fatosBoletos = (List<ComissaoConvenioSiteVO>) comissaoBoletos;
        }
        for (ComissaoConvenioSiteVO fb : fatosBoletos) {
            if (fb.getComissaoconvenio() != null) {
                valor = valor.add(fb.getComissaoconvenio());

            }
        }
        return valor;
    }

    public BigDecimal totalComLiquidaPaginaAtual() {

        BigDecimal valor = BigDecimal.ZERO;
        List<ComissaoConvenioSiteVO> fatosBoletos;
        if (fatosBoletosFiltrados != null) {
            fatosBoletos = (List<ComissaoConvenioSiteVO>) fatosBoletosFiltrados;
        } else {
            fatosBoletos = (List<ComissaoConvenioSiteVO>) comissaoBoletos;
        }
        for (ComissaoConvenioSiteVO fb : fatosBoletos) {
            if (fb.getComissaoliquida() != null) {
                valor = valor.add(fb.getComissaoliquida());

            }
        }
        return valor;
    }

}
