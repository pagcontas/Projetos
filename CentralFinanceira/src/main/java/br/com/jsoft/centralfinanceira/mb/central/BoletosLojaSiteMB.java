package br.com.jsoft.centralfinanceira.mb.central;

import br.com.jsoft.centralfinanceira.bo.central.FatosBoletoSiteBO;
import java.io.Serializable;
import com.xpert.core.crud.AbstractBaseBean;
import javax.ejb.EJB;
import javax.faces.bean.ManagedBean;
import javax.faces.bean.ViewScoped;
import br.com.jsoft.centralfinanceira.dao.central.FatosBoletoSiteDAO;
import br.com.jsoft.centralfinanceira.modelo.central.FatosBoletoSite;
import br.com.jsoft.centralfinanceira.vo.ComissaoLojaSiteVO;
import java.math.BigDecimal;
import java.math.RoundingMode;
import java.util.List;

/**
 *
 * @author Juniel
 */
@ManagedBean
@ViewScoped
public class BoletosLojaSiteMB extends AbstractBaseBean<FatosBoletoSite> implements Serializable {

    @EJB
    private FatosBoletoSiteBO fatosBoletosBO;

    @EJB
    private FatosBoletoSiteDAO fatosBoletosDAO;

    private List<FatosBoletoSite> fatos;

    private List<ComissaoLojaSiteVO> comissaoBoletos;

    private ComissaoLojaSiteVO comissaoLoja;

    List<ComissaoLojaSiteVO> fatosBoletosFiltrados;

    public List<ComissaoLojaSiteVO> getFatosBoletosFiltrados() {
        return fatosBoletosFiltrados;
    }

    public void setFatosBoletosFiltrados(List<ComissaoLojaSiteVO> fatosBoletosFiltrados) {
        this.fatosBoletosFiltrados = fatosBoletosFiltrados;
    }

    public ComissaoLojaSiteVO getComissaoLoja() {
        return comissaoLoja;
    }

    public void setComissaoLoja(ComissaoLojaSiteVO comissaoLoja) {
        this.comissaoLoja = comissaoLoja;
    }

    @Override
    public FatosBoletoSiteBO getBO() {
        return fatosBoletosBO;
    }

    public void updateUnitarioLoja() {
        fatosBoletosBO.updateUniLoja(comissaoLoja);
    }

    @Override
    public String getDataModelOrder() {
        return "id";
    }

    public void setFatos(List<FatosBoletoSite> fatos) {
        this.fatos = fatos;
    }

    public List<ComissaoLojaSiteVO> getComissaoBoletos() {
        return comissaoBoletos;
    }

    public void setComissaoBoletos(List<ComissaoLojaSiteVO> comissaoBoletos) {
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
        comissaoBoletos = fatosBoletosDAO.listBoletoLoja();
    }

    public BigDecimal totalArrecadadoPaginaAtual() {

        BigDecimal valor = BigDecimal.ZERO;
        List<ComissaoLojaSiteVO> fatosBoletos;
        if (fatosBoletosFiltrados != null) {
            fatosBoletos = (List<ComissaoLojaSiteVO>) fatosBoletosFiltrados;
        } else {
            fatosBoletos = (List<ComissaoLojaSiteVO>) comissaoBoletos;
        }
        for (ComissaoLojaSiteVO fb : fatosBoletos) {
            if (fb.getArrecadado() != null) {
                valor = valor.add(fb.getArrecadado());

            }
        }
        return valor;
    }

    public BigDecimal totalUniLojaPaginaAtual() {

        BigDecimal valor = BigDecimal.ZERO;
        List<ComissaoLojaSiteVO> fatosBoletos;
        if (fatosBoletosFiltrados != null) {
            fatosBoletos = (List<ComissaoLojaSiteVO>) fatosBoletosFiltrados;
        } else {
            fatosBoletos = (List<ComissaoLojaSiteVO>) comissaoBoletos;
        }
        for (ComissaoLojaSiteVO fb : fatosBoletos) {
            if (fb.getUnitarioloja() != null) {
                valor = valor.add(fb.getUnitarioloja());

            }
        }
        return valor.divide(new BigDecimal(fatosBoletos.size()), 2, RoundingMode.HALF_UP);
    }

    public Integer totalQtdPaginaAtual() {
        Integer total = 0;
        List<ComissaoLojaSiteVO> fatosBoletos;
        if (fatosBoletosFiltrados != null) {
            fatosBoletos = (List<ComissaoLojaSiteVO>) fatosBoletosFiltrados;
        } else {
            fatosBoletos = (List<ComissaoLojaSiteVO>) comissaoBoletos;
        }
        for (ComissaoLojaSiteVO fb : fatosBoletos) {
            if (fb.getQtd() != null) {
                total += fb.getQtd();

            }
        }
        return total;
    }

    public BigDecimal totalComLojaPaginaAtual() {

        BigDecimal valor = BigDecimal.ZERO;
        List<ComissaoLojaSiteVO> fatosBoletos;
        if (fatosBoletosFiltrados != null) {
            fatosBoletos = (List<ComissaoLojaSiteVO>) fatosBoletosFiltrados;
        } else {
            fatosBoletos = (List<ComissaoLojaSiteVO>) comissaoBoletos;
        }
        for (ComissaoLojaSiteVO fb : fatosBoletos) {
            if (fb.getComissaoloja() != null) {
                valor = valor.add(fb.getComissaoloja());

            }
        }
        return valor;
    }

    public BigDecimal totalComConvenioPaginaAtual() {

        BigDecimal valor = BigDecimal.ZERO;
        List<ComissaoLojaSiteVO> fatosBoletos;
        if (fatosBoletosFiltrados != null) {
            fatosBoletos = (List<ComissaoLojaSiteVO>) fatosBoletosFiltrados;
        } else {
            fatosBoletos = (List<ComissaoLojaSiteVO>) comissaoBoletos;
        }
        for (ComissaoLojaSiteVO fb : fatosBoletos) {
            if (fb.getComissaoconvenio() != null) {
                valor = valor.add(fb.getComissaoconvenio());

            }
        }
        return valor;
    }

    public BigDecimal totalComLiquidaPaginaAtual() {

        BigDecimal valor = BigDecimal.ZERO;
        List<ComissaoLojaSiteVO> fatosBoletos;
        if (fatosBoletosFiltrados != null) {
            fatosBoletos = (List<ComissaoLojaSiteVO>) fatosBoletosFiltrados;
        } else {
            fatosBoletos = (List<ComissaoLojaSiteVO>) comissaoBoletos;
        }
        for (ComissaoLojaSiteVO fb : fatosBoletos) {
            if (fb.getComissaoliquida() != null) {
                valor = valor.add(fb.getComissaoliquida());

            }
        }
        return valor;
    }

}
