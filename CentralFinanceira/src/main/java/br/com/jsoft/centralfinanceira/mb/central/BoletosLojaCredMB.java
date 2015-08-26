package br.com.jsoft.centralfinanceira.mb.central;

import java.io.Serializable;
import com.xpert.core.crud.AbstractBaseBean;
import javax.ejb.EJB;
import javax.faces.bean.ManagedBean;
import javax.faces.bean.ViewScoped;
import br.com.jsoft.centralfinanceira.bo.central.FatosCreditosBO;
import br.com.jsoft.centralfinanceira.dao.central.FatosCreditosDAO;
import br.com.jsoft.centralfinanceira.modelo.central.FatosCreditos;
import br.com.jsoft.centralfinanceira.vo.ComissaoLojaCredVO;
import java.math.BigDecimal;
import java.math.RoundingMode;
import java.util.List;

/**
 *
 * @author Juniel
 */
@ManagedBean
@ViewScoped
public class BoletosLojaCredMB extends AbstractBaseBean<FatosCreditos> implements Serializable {

    @EJB
    private FatosCreditosBO fatosBoletosBO;

    @EJB
    private FatosCreditosDAO fatosBoletosDAO;

    private List<FatosCreditos> fatos;

    private List<ComissaoLojaCredVO> comissaoBoletos;

    private ComissaoLojaCredVO comissaoLoja;

    List<ComissaoLojaCredVO> fatosBoletosFiltrados;

    public List<ComissaoLojaCredVO> getFatosBoletosFiltrados() {
        return fatosBoletosFiltrados;
    }

    public void setFatosBoletosFiltrados(List<ComissaoLojaCredVO> fatosBoletosFiltrados) {
        this.fatosBoletosFiltrados = fatosBoletosFiltrados;
    }

    public ComissaoLojaCredVO getComissaoLoja() {
        return comissaoLoja;
    }

    public void setComissaoLoja(ComissaoLojaCredVO comissaoLoja) {
        this.comissaoLoja = comissaoLoja;
    }

    @Override
    public FatosCreditosBO getBO() {
        return fatosBoletosBO;
    }

    public void updateUnitarioLoja() {
        fatosBoletosBO.updateUniLoja(comissaoLoja);
    }

    @Override
    public String getDataModelOrder() {
        return "id";
    }

    public void setFatos(List<FatosCreditos> fatos) {
        this.fatos = fatos;
    }

    public List<ComissaoLojaCredVO> getComissaoBoletos() {
        return comissaoBoletos;
    }

    public void setComissaoBoletos(List<ComissaoLojaCredVO> comissaoBoletos) {
        this.comissaoBoletos = comissaoBoletos;
    }

    public FatosCreditosBO getFatosBoletosBO() {
        return fatosBoletosBO;
    }

    public void setFatosBoletosBO(FatosCreditosBO fatosBoletosBO) {
        this.fatosBoletosBO = fatosBoletosBO;
    }

    public FatosCreditosDAO getFatosBoletosDAO() {
        return fatosBoletosDAO;
    }

    public void setFatosBoletosDAO(FatosCreditosDAO fatosBoletosDAO) {
        this.fatosBoletosDAO = fatosBoletosDAO;
    }

    @Override
    public void init() {
        comissaoBoletos = fatosBoletosDAO.listBoletoLoja();
    }

    public BigDecimal totalArrecadadoPaginaAtual() {

        BigDecimal valor = BigDecimal.ZERO;
        List<ComissaoLojaCredVO> fatosBoletos;
        if (fatosBoletosFiltrados != null) {
            fatosBoletos = (List<ComissaoLojaCredVO>) fatosBoletosFiltrados;
        } else {
            fatosBoletos = (List<ComissaoLojaCredVO>) comissaoBoletos;
        }
        for (ComissaoLojaCredVO fb : fatosBoletos) {
            if (fb.getArrecadado() != null) {
                valor = valor.add(fb.getArrecadado());

            }
        }
        return valor;
    }

    public BigDecimal totalUniLojaPaginaAtual() {

        BigDecimal valor = BigDecimal.ZERO;
        List<ComissaoLojaCredVO> fatosBoletos;
        if (fatosBoletosFiltrados != null) {
            fatosBoletos = (List<ComissaoLojaCredVO>) fatosBoletosFiltrados;
        } else {
            fatosBoletos = (List<ComissaoLojaCredVO>) comissaoBoletos;
        }
        for (ComissaoLojaCredVO fb : fatosBoletos) {
            if (fb.getUnitarioloja() != null) {
                valor = valor.add(fb.getUnitarioloja());

            }
        }
        return valor.divide(new BigDecimal(fatosBoletos.size()), 2, RoundingMode.HALF_UP);
    }

    public Integer totalQtdPaginaAtual() {
        Integer total = 0;
        List<ComissaoLojaCredVO> fatosBoletos;
        if (fatosBoletosFiltrados != null) {
            fatosBoletos = (List<ComissaoLojaCredVO>) fatosBoletosFiltrados;
        } else {
            fatosBoletos = (List<ComissaoLojaCredVO>) comissaoBoletos;
        }
        for (ComissaoLojaCredVO fb : fatosBoletos) {
            if (fb.getQtd() != null) {
                total += fb.getQtd();

            }
        }
        return total;
    }

    public BigDecimal totalComLojaPaginaAtual() {

        BigDecimal valor = BigDecimal.ZERO;
        List<ComissaoLojaCredVO> fatosBoletos;
        if (fatosBoletosFiltrados != null) {
            fatosBoletos = (List<ComissaoLojaCredVO>) fatosBoletosFiltrados;
        } else {
            fatosBoletos = (List<ComissaoLojaCredVO>) comissaoBoletos;
        }
        for (ComissaoLojaCredVO fb : fatosBoletos) {
            if (fb.getComissaoloja() != null) {
                valor = valor.add(fb.getComissaoloja());

            }
        }
        return valor;
    }

    public BigDecimal totalComConvenioPaginaAtual() {

        BigDecimal valor = BigDecimal.ZERO;
        List<ComissaoLojaCredVO> fatosBoletos;
        if (fatosBoletosFiltrados != null) {
            fatosBoletos = (List<ComissaoLojaCredVO>) fatosBoletosFiltrados;
        } else {
            fatosBoletos = (List<ComissaoLojaCredVO>) comissaoBoletos;
        }
        for (ComissaoLojaCredVO fb : fatosBoletos) {
            if (fb.getComissaoconvenio() != null) {
                valor = valor.add(fb.getComissaoconvenio());

            }
        }
        return valor;
    }

    public BigDecimal totalComLiquidaPaginaAtual() {

        BigDecimal valor = BigDecimal.ZERO;
        List<ComissaoLojaCredVO> fatosBoletos;
        if (fatosBoletosFiltrados != null) {
            fatosBoletos = (List<ComissaoLojaCredVO>) fatosBoletosFiltrados;
        } else {
            fatosBoletos = (List<ComissaoLojaCredVO>) comissaoBoletos;
        }
        for (ComissaoLojaCredVO fb : fatosBoletos) {
            if (fb.getComissaoliquida() != null) {
                valor = valor.add(fb.getComissaoliquida());

            }
        }
        return valor;
    }

}
