package br.com.jsoft.centralfinanceira.mb.central;

import java.io.Serializable;
import com.xpert.core.crud.AbstractBaseBean;
import javax.ejb.EJB;
import javax.faces.bean.ManagedBean;
import javax.faces.bean.ViewScoped;
import br.com.jsoft.centralfinanceira.bo.central.FatosValeGasBO;
import br.com.jsoft.centralfinanceira.dao.central.FatosValeGasDAO;
import br.com.jsoft.centralfinanceira.modelo.central.FatosValeGas;
import br.com.jsoft.centralfinanceira.vo.ComissaoConvenioGasVO;
import java.math.BigDecimal;
import java.math.RoundingMode;
import java.util.List;

/**
 *
 * @author Juniel
 */
@ManagedBean
@ViewScoped
public class BoletosConvenioGasMB extends AbstractBaseBean<FatosValeGas> implements Serializable {

    @EJB
    private FatosValeGasBO fatosBoletosBO;

    @EJB
    private FatosValeGasDAO fatosBoletosDAO;

    private List<FatosValeGas> fatos;

    private List<ComissaoConvenioGasVO> comissaoBoletos;

    private ComissaoConvenioGasVO comissaoConvenio;

    List<ComissaoConvenioGasVO> fatosBoletosFiltrados;

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

    public List<ComissaoConvenioGasVO> getFatosBoletosFiltrados() {
        return fatosBoletosFiltrados;
    }

    public void setFatosBoletosFiltrados(List<ComissaoConvenioGasVO> fatosBoletosFiltrados) {
        this.fatosBoletosFiltrados = fatosBoletosFiltrados;
    }  

    public ComissaoConvenioGasVO getComissaoConvenio() {
        return comissaoConvenio;
    }

    public void setComissaoConvenio(ComissaoConvenioGasVO comissaoConvenio) {
        this.comissaoConvenio = comissaoConvenio;
    }

    @Override
    public FatosValeGasBO getBO() {
        return fatosBoletosBO;
    }

    public void updateUnitarioConvenio() {
        fatosBoletosBO.updateUniConvenio(comissaoConvenio);
    }

    @Override
    public String getDataModelOrder() {
        return "id";
    }

    public void setFatos(List<FatosValeGas> fatos) {
        this.fatos = fatos;
    }

    public List<ComissaoConvenioGasVO> getComissaoBoletos() {
        return comissaoBoletos;
    }

    public void setComissaoBoletos(List<ComissaoConvenioGasVO> comissaoBoletos) {
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
        comissaoBoletos = fatosBoletosDAO.listBoletoConvenio();
    }

    public BigDecimal totalArrecadadoPaginaAtual() {

        BigDecimal valor = BigDecimal.ZERO;
        List<ComissaoConvenioGasVO> fatosBoletos;
        if (fatosBoletosFiltrados != null) {
            fatosBoletos = (List<ComissaoConvenioGasVO>) fatosBoletosFiltrados;
        } else {
            fatosBoletos = (List<ComissaoConvenioGasVO>) comissaoBoletos;
        }
        for (ComissaoConvenioGasVO fb : fatosBoletos) {
            if (fb.getArrecadado() != null) {
                valor = valor.add(fb.getArrecadado());

            }
        }
        return valor;
    }

    public BigDecimal totalUniConvenioPaginaAtual() {

        BigDecimal valor = BigDecimal.ZERO;
        List<ComissaoConvenioGasVO> fatosBoletos;
        if (fatosBoletosFiltrados != null) {
            fatosBoletos = (List<ComissaoConvenioGasVO>) fatosBoletosFiltrados;
        } else {
            fatosBoletos = (List<ComissaoConvenioGasVO>) comissaoBoletos;
        }
        for (ComissaoConvenioGasVO fb : fatosBoletos) {
            if (fb.getUnitarioconvenio() != null) {
                valor = valor.add(fb.getUnitarioconvenio());

            }
        }
        return valor.divide(new BigDecimal(fatosBoletos.size()), 2, RoundingMode.HALF_UP);
    }

    public Integer totalQtdPaginaAtual() {
        Integer total = 0;
        List<ComissaoConvenioGasVO> fatosBoletos;
        if (fatosBoletosFiltrados != null) {
            fatosBoletos = (List<ComissaoConvenioGasVO>) fatosBoletosFiltrados;
        } else {
            fatosBoletos = (List<ComissaoConvenioGasVO>) comissaoBoletos;
        }
        for (ComissaoConvenioGasVO fb : fatosBoletos) {
            if (fb.getQtd() != null) {
                total += fb.getQtd();

            }
        }
        return total;
    }

    public BigDecimal totalComLojaPaginaAtual() {

        BigDecimal valor = BigDecimal.ZERO;
        List<ComissaoConvenioGasVO> fatosBoletos;
        if (fatosBoletosFiltrados != null) {
            fatosBoletos = (List<ComissaoConvenioGasVO>) fatosBoletosFiltrados;
        } else {
            fatosBoletos = (List<ComissaoConvenioGasVO>) comissaoBoletos;
        }
        for (ComissaoConvenioGasVO fb : fatosBoletos) {
            if (fb.getComissaoloja() != null) {
                valor = valor.add(fb.getComissaoloja());

            }
        }
        return valor;
    }

    public BigDecimal totalComConvenioPaginaAtual() {

        BigDecimal valor = BigDecimal.ZERO;
        List<ComissaoConvenioGasVO> fatosBoletos;
        if (fatosBoletosFiltrados != null) {
            fatosBoletos = (List<ComissaoConvenioGasVO>) fatosBoletosFiltrados;
        } else {
            fatosBoletos = (List<ComissaoConvenioGasVO>) comissaoBoletos;
        }
        for (ComissaoConvenioGasVO fb : fatosBoletos) {
            if (fb.getComissaoconvenio() != null) {
                valor = valor.add(fb.getComissaoconvenio());

            }
        }
        return valor;
    }

    public BigDecimal totalComLiquidaPaginaAtual() {

        BigDecimal valor = BigDecimal.ZERO;
        List<ComissaoConvenioGasVO> fatosBoletos;
        if (fatosBoletosFiltrados != null) {
            fatosBoletos = (List<ComissaoConvenioGasVO>) fatosBoletosFiltrados;
        } else {
            fatosBoletos = (List<ComissaoConvenioGasVO>) comissaoBoletos;
        }
        for (ComissaoConvenioGasVO fb : fatosBoletos) {
            if (fb.getComissaoliquida() != null) {
                valor = valor.add(fb.getComissaoliquida());

            }
        }
        return valor;
    }

}
