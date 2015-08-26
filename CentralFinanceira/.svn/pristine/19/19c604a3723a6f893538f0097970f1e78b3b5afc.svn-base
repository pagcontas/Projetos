package br.com.jsoft.centralfinanceira.mb.central;

import br.com.jsoft.centralfinanceira.bo.central.FatosBanPopBO;
import java.io.Serializable;
import com.xpert.core.crud.AbstractBaseBean;
import javax.ejb.EJB;
import javax.faces.bean.ManagedBean;
import javax.faces.bean.ViewScoped;
import br.com.jsoft.centralfinanceira.bo.central.FatosBoletosBO;
import br.com.jsoft.centralfinanceira.dao.central.FatosBanPopDAO;
import br.com.jsoft.centralfinanceira.dao.central.FatosBoletosDAO;
import br.com.jsoft.centralfinanceira.modelo.central.FatosBanPop;
import br.com.jsoft.centralfinanceira.modelo.central.FatosBoletos;
import br.com.jsoft.centralfinanceira.vo.ComissaoLojaVO;
import java.math.BigDecimal;
import java.math.RoundingMode;
import java.util.List;

/**
 *
 * @author Juniel
 */
@ManagedBean
@ViewScoped
public class BoletosLojaBanPopMB extends AbstractBaseBean<FatosBanPop> implements Serializable {

    @EJB
    private FatosBanPopBO fatosBoletosBO;

    @EJB
    private FatosBanPopDAO fatosBoletosDAO;

    private List<FatosBanPop> fatos;

    private List<ComissaoLojaVO> comissaoBoletos;

    private ComissaoLojaVO comissaoLoja;

    List<ComissaoLojaVO> fatosBoletosFiltrados;

    public List<ComissaoLojaVO> getFatosBoletosFiltrados() {
        return fatosBoletosFiltrados;
    }

    public void setFatosBoletosFiltrados(List<ComissaoLojaVO> fatosBoletosFiltrados) {
        this.fatosBoletosFiltrados = fatosBoletosFiltrados;
    }

    public ComissaoLojaVO getComissaoLoja() {
        return comissaoLoja;
    }

    public void setComissaoLoja(ComissaoLojaVO comissaoLoja) {
        this.comissaoLoja = comissaoLoja;
    }

    @Override
    public FatosBanPopBO getBO() {
        return fatosBoletosBO;
    }

    public void updateUnitarioLoja() {
        fatosBoletosBO.updateUniLoja(comissaoLoja);
    }

    @Override
    public String getDataModelOrder() {
        return "id";
    }

    public void setFatos(List<FatosBanPop> fatos) {
        this.fatos = fatos;
    }

    public List<ComissaoLojaVO> getComissaoBoletos() {
        return comissaoBoletos;
    }

    public void setComissaoBoletos(List<ComissaoLojaVO> comissaoBoletos) {
        this.comissaoBoletos = comissaoBoletos;
    }

    public FatosBanPopBO getFatosBoletosBO() {
        return fatosBoletosBO;
    }

    public void setFatosBoletosBO(FatosBanPopBO fatosBoletosBO) {
        this.fatosBoletosBO = fatosBoletosBO;
    }

    public FatosBanPopDAO getFatosBoletosDAO() {
        return fatosBoletosDAO;
    }

    public void setFatosBoletosDAO(FatosBanPopDAO fatosBoletosDAO) {
        this.fatosBoletosDAO = fatosBoletosDAO;
    }

    @Override
    public void init() {
        comissaoBoletos = fatosBoletosDAO.listBoletoLoja();
    }

    public BigDecimal totalArrecadadoPaginaAtual() {

        BigDecimal valor = BigDecimal.ZERO;
        List<ComissaoLojaVO> fatosBoletos;
        if (fatosBoletosFiltrados != null) {
            fatosBoletos = (List<ComissaoLojaVO>) fatosBoletosFiltrados;
        } else {
            fatosBoletos = (List<ComissaoLojaVO>) comissaoBoletos;
        }
        for (ComissaoLojaVO fb : fatosBoletos) {
            if (fb.getArrecadado() != null) {
                valor = valor.add(fb.getArrecadado());

            }
        }
        return valor;
    }

    public BigDecimal totalUniLojaPaginaAtual() {

        BigDecimal valor = BigDecimal.ZERO;
        List<ComissaoLojaVO> fatosBoletos;
        if (fatosBoletosFiltrados != null) {
            fatosBoletos = (List<ComissaoLojaVO>) fatosBoletosFiltrados;
        } else {
            fatosBoletos = (List<ComissaoLojaVO>) comissaoBoletos;
        }
        for (ComissaoLojaVO fb : fatosBoletos) {
            if (fb.getUnitarioloja() != null) {
                valor = valor.add(fb.getUnitarioloja());

            }
        }
        return valor.divide(new BigDecimal(fatosBoletos.size()), 2, RoundingMode.HALF_UP);
    }

    public Integer totalQtdPaginaAtual() {
        Integer total = 0;
        List<ComissaoLojaVO> fatosBoletos;
        if (fatosBoletosFiltrados != null) {
            fatosBoletos = (List<ComissaoLojaVO>) fatosBoletosFiltrados;
        } else {
            fatosBoletos = (List<ComissaoLojaVO>) comissaoBoletos;
        }
        for (ComissaoLojaVO fb : fatosBoletos) {
            if (fb.getQtd() != null) {
                total += fb.getQtd();

            }
        }
        return total;
    }

    public BigDecimal totalComLojaPaginaAtual() {

        BigDecimal valor = BigDecimal.ZERO;
        List<ComissaoLojaVO> fatosBoletos;
        if (fatosBoletosFiltrados != null) {
            fatosBoletos = (List<ComissaoLojaVO>) fatosBoletosFiltrados;
        } else {
            fatosBoletos = (List<ComissaoLojaVO>) comissaoBoletos;
        }
        for (ComissaoLojaVO fb : fatosBoletos) {
            if (fb.getComissaoloja() != null) {
                valor = valor.add(fb.getComissaoloja());

            }
        }
        return valor;
    }

    public BigDecimal totalComConvenioPaginaAtual() {

        BigDecimal valor = BigDecimal.ZERO;
        List<ComissaoLojaVO> fatosBoletos;
        if (fatosBoletosFiltrados != null) {
            fatosBoletos = (List<ComissaoLojaVO>) fatosBoletosFiltrados;
        } else {
            fatosBoletos = (List<ComissaoLojaVO>) comissaoBoletos;
        }
        for (ComissaoLojaVO fb : fatosBoletos) {
            if (fb.getComissaoconvenio() != null) {
                valor = valor.add(fb.getComissaoconvenio());

            }
        }
        return valor;
    }

    public BigDecimal totalComLiquidaPaginaAtual() {

        BigDecimal valor = BigDecimal.ZERO;
        List<ComissaoLojaVO> fatosBoletos;
        if (fatosBoletosFiltrados != null) {
            fatosBoletos = (List<ComissaoLojaVO>) fatosBoletosFiltrados;
        } else {
            fatosBoletos = (List<ComissaoLojaVO>) comissaoBoletos;
        }
        for (ComissaoLojaVO fb : fatosBoletos) {
            if (fb.getComissaoliquida() != null) {
                valor = valor.add(fb.getComissaoliquida());

            }
        }
        return valor;
    }

}
