package br.com.jsoft.centralfinanceira.mb.central;

import java.io.Serializable;
import com.xpert.core.crud.AbstractBaseBean;
import javax.ejb.EJB;
import javax.faces.bean.ManagedBean;
import javax.faces.bean.ViewScoped;
import br.com.jsoft.centralfinanceira.bo.central.FatosValeGasBO;
import br.com.jsoft.centralfinanceira.dao.central.FatosValeGasDAO;
import br.com.jsoft.centralfinanceira.modelo.central.FatosValeGas;
import br.com.jsoft.centralfinanceira.vo.ComissaoLojaGasVO;
import java.math.BigDecimal;
import java.math.RoundingMode;
import java.util.List;

/**
 *
 * @author Juniel
 */
@ManagedBean
@ViewScoped
public class BoletosLojaGasMB extends AbstractBaseBean<FatosValeGas> implements Serializable {

    @EJB
    private FatosValeGasBO fatosBoletosBO;

    @EJB
    private FatosValeGasDAO fatosBoletosDAO;

    private List<FatosValeGas> fatos;

    private List<ComissaoLojaGasVO> comissaoBoletos;

    private ComissaoLojaGasVO comissaoLoja;

    List<ComissaoLojaGasVO> fatosBoletosFiltrados;

    public FatosValeGasBO getFatosBoletosBO() {
        return fatosBoletosBO;
    }

    public void setFatosBoletosBO(FatosValeGasBO fatosBoletosBO) {
        this.fatosBoletosBO = fatosBoletosBO;
    }

    public FatosValeGasDAO getFatosBoletosDAO() {
        return fatosBoletosDAO;
    }

    public void setFatosBoletosDAO(FatosValeGasDAO fatosBoletosDAO) {
        this.fatosBoletosDAO = fatosBoletosDAO;
    }

    public List<ComissaoLojaGasVO> getFatosBoletosFiltrados() {
        return fatosBoletosFiltrados;
    }

    public void setFatosBoletosFiltrados(List<ComissaoLojaGasVO> fatosBoletosFiltrados) {
        this.fatosBoletosFiltrados = fatosBoletosFiltrados;
    }  

    public ComissaoLojaGasVO getComissaoLoja() {
        return comissaoLoja;
    }

    public void setComissaoLoja(ComissaoLojaGasVO comissaoLoja) {
        this.comissaoLoja = comissaoLoja;
    }

    @Override
    public FatosValeGasBO getBO() {
        return fatosBoletosBO;
    }

    public void updateUnitarioLoja() {
        fatosBoletosBO.updateUniLoja(comissaoLoja);
    }

    @Override
    public String getDataModelOrder() {
        return "id";
    }

    public void setFatos(List<FatosValeGas> fatos) {
        this.fatos = fatos;
    }

    public List<ComissaoLojaGasVO> getComissaoBoletos() {
        return comissaoBoletos;
    }

    public void setComissaoBoletos(List<ComissaoLojaGasVO> comissaoBoletos) {
        this.comissaoBoletos = comissaoBoletos;
    }

    public FatosValeGasBO getFatosValeGasBO() {
        return fatosBoletosBO;
    }

    public void setFatosValeGasBO(FatosValeGasBO fatosBoletosBO) {
        this.fatosBoletosBO = fatosBoletosBO;
    }

    public FatosValeGasDAO getFatosValeGasDAO() {
        return fatosBoletosDAO;
    }

    public void setFatosValeGasDAO(FatosValeGasDAO fatosBoletosDAO) {
        this.fatosBoletosDAO = fatosBoletosDAO;
    }

    @Override
    public void init() {
        comissaoBoletos = fatosBoletosDAO.listBoletoLoja();
    }

    public BigDecimal totalArrecadadoPaginaAtual() {

        BigDecimal valor = BigDecimal.ZERO;
        List<ComissaoLojaGasVO> fatosBoletos;
        if (fatosBoletosFiltrados != null) {
            fatosBoletos = (List<ComissaoLojaGasVO>) fatosBoletosFiltrados;
        } else {
            fatosBoletos = (List<ComissaoLojaGasVO>) comissaoBoletos;
        }
        for (ComissaoLojaGasVO fb : fatosBoletos) {
            if (fb.getArrecadado() != null) {
                valor = valor.add(fb.getArrecadado());

            }
        }
        return valor;
    }

    public BigDecimal totalUniLojaPaginaAtual() {

        BigDecimal valor = BigDecimal.ZERO;
        List<ComissaoLojaGasVO> fatosBoletos;
        if (fatosBoletosFiltrados != null) {
            fatosBoletos = (List<ComissaoLojaGasVO>) fatosBoletosFiltrados;
        } else {
            fatosBoletos = (List<ComissaoLojaGasVO>) comissaoBoletos;
        }
        for (ComissaoLojaGasVO fb : fatosBoletos) {
            if (fb.getUnitarioloja() != null) {
                valor = valor.add(fb.getUnitarioloja());

            }
        }
        return valor.divide(new BigDecimal(fatosBoletos.size()), 2, RoundingMode.HALF_UP);
    }

    public Integer totalQtdPaginaAtual() {
        Integer total = 0;
        List<ComissaoLojaGasVO> fatosBoletos;
        if (fatosBoletosFiltrados != null) {
            fatosBoletos = (List<ComissaoLojaGasVO>) fatosBoletosFiltrados;
        } else {
            fatosBoletos = (List<ComissaoLojaGasVO>) comissaoBoletos;
        }
        for (ComissaoLojaGasVO fb : fatosBoletos) {
            if (fb.getQtd() != null) {
                total += fb.getQtd();

            }
        }
        return total;
    }

    public BigDecimal totalComLojaPaginaAtual() {

        BigDecimal valor = BigDecimal.ZERO;
        List<ComissaoLojaGasVO> fatosBoletos;
        if (fatosBoletosFiltrados != null) {
            fatosBoletos = (List<ComissaoLojaGasVO>) fatosBoletosFiltrados;
        } else {
            fatosBoletos = (List<ComissaoLojaGasVO>) comissaoBoletos;
        }
        for (ComissaoLojaGasVO fb : fatosBoletos) {
            if (fb.getComissaoloja() != null) {
                valor = valor.add(fb.getComissaoloja());

            }
        }
        return valor;
    }

    public BigDecimal totalComConvenioPaginaAtual() {

        BigDecimal valor = BigDecimal.ZERO;
        List<ComissaoLojaGasVO> fatosBoletos;
        if (fatosBoletosFiltrados != null) {
            fatosBoletos = (List<ComissaoLojaGasVO>) fatosBoletosFiltrados;
        } else {
            fatosBoletos = (List<ComissaoLojaGasVO>) comissaoBoletos;
        }
        for (ComissaoLojaGasVO fb : fatosBoletos) {
            if (fb.getComissaoconvenio() != null) {
                valor = valor.add(fb.getComissaoconvenio());

            }
        }
        return valor;
    }

    public BigDecimal totalComLiquidaPaginaAtual() {

        BigDecimal valor = BigDecimal.ZERO;
        List<ComissaoLojaGasVO> fatosBoletos;
        if (fatosBoletosFiltrados != null) {
            fatosBoletos = (List<ComissaoLojaGasVO>) fatosBoletosFiltrados;
        } else {
            fatosBoletos = (List<ComissaoLojaGasVO>) comissaoBoletos;
        }
        for (ComissaoLojaGasVO fb : fatosBoletos) {
            if (fb.getComissaoliquida() != null) {
                valor = valor.add(fb.getComissaoliquida());

            }
        }
        return valor;
    }

}
