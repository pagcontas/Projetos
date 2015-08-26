package br.com.jsoft.centralfinanceira.mb.central;

import java.io.Serializable;
import com.xpert.core.crud.AbstractBaseBean;
import javax.ejb.EJB;
import javax.faces.bean.ManagedBean;
import javax.faces.bean.ViewScoped;
import br.com.jsoft.centralfinanceira.bo.central.FatosBoletosBO;
import br.com.jsoft.centralfinanceira.dao.central.FatosBoletosDAO;
import br.com.jsoft.centralfinanceira.modelo.central.FatosBoletos;
import br.com.jsoft.centralfinanceira.vo.ComissaoConvenioVO;
import java.math.BigDecimal;
import java.math.RoundingMode;
import java.util.List;

/**
 *
 * @author Juniel
 */
@ManagedBean
@ViewScoped
public class BoletosConvenioMB extends AbstractBaseBean<FatosBoletos> implements Serializable {

    @EJB
    private FatosBoletosBO fatosBoletosBO;

    @EJB
    private FatosBoletosDAO fatosBoletosDAO;

    private List<FatosBoletos> fatos;

    private List<ComissaoConvenioVO> comissaoBoletos;

    private ComissaoConvenioVO comissaoConvenio;

    List<ComissaoConvenioVO> fatosBoletosFiltrados;

    public List<ComissaoConvenioVO> getFatosBoletosFiltrados() {
        return fatosBoletosFiltrados;
    }

    public void setFatosBoletosFiltrados(List<ComissaoConvenioVO> fatosBoletosFiltrados) {
        this.fatosBoletosFiltrados = fatosBoletosFiltrados;
    }

    public ComissaoConvenioVO getComissaoConvenio() {
        return comissaoConvenio;
    }

    public void setComissaoConvenio(ComissaoConvenioVO comissaoConvenio) {
        this.comissaoConvenio = comissaoConvenio;
    }

    @Override
    public FatosBoletosBO getBO() {
        return fatosBoletosBO;
    }

    public void updateUnitarioConvenio() {
        fatosBoletosBO.updateUniConvenio(comissaoConvenio);
    }

    @Override
    public String getDataModelOrder() {
        return "id";
    }

    public void setFatos(List<FatosBoletos> fatos) {
        this.fatos = fatos;
    }

    public List<ComissaoConvenioVO> getComissaoBoletos() {
        return comissaoBoletos;
    }

    public void setComissaoBoletos(List<ComissaoConvenioVO> comissaoBoletos) {
        this.comissaoBoletos = comissaoBoletos;
    }

    public FatosBoletosBO getFatosBoletosBO() {
        return fatosBoletosBO;
    }

    public void setFatosBoletosBO(FatosBoletosBO fatosBoletosBO) {
        this.fatosBoletosBO = fatosBoletosBO;
    }

    public FatosBoletosDAO getFatosBoletosDAO() {
        return fatosBoletosDAO;
    }

    public void setFatosBoletosDAO(FatosBoletosDAO fatosBoletosDAO) {
        this.fatosBoletosDAO = fatosBoletosDAO;
    }

    @Override
    public void init() {
        comissaoBoletos = fatosBoletosDAO.listBoletoConvenio();
    }

    public BigDecimal totalArrecadadoPaginaAtual() {

        BigDecimal valor = BigDecimal.ZERO;
        List<ComissaoConvenioVO> fatosBoletos;
        if (fatosBoletosFiltrados != null) {
            fatosBoletos = (List<ComissaoConvenioVO>) fatosBoletosFiltrados;
        } else {
            fatosBoletos = (List<ComissaoConvenioVO>) comissaoBoletos;
        }
        for (ComissaoConvenioVO fb : fatosBoletos) {
            if (fb.getArrecadado() != null) {
                valor = valor.add(fb.getArrecadado());

            }
        }
        return valor;
    }

    public BigDecimal totalUniConvenioPaginaAtual() {

        BigDecimal valor = BigDecimal.ZERO;
        List<ComissaoConvenioVO> fatosBoletos;
        if (fatosBoletosFiltrados != null) {
            fatosBoletos = (List<ComissaoConvenioVO>) fatosBoletosFiltrados;
        } else {
            fatosBoletos = (List<ComissaoConvenioVO>) comissaoBoletos;
        }
        for (ComissaoConvenioVO fb : fatosBoletos) {
            if (fb.getUnitarioconvenio() != null) {
                valor = valor.add(fb.getUnitarioconvenio());

            }
        }
        return valor.divide(new BigDecimal(fatosBoletos.size()), 2, RoundingMode.HALF_UP);
    }

    public Integer totalQtdPaginaAtual() {
        Integer total = 0;
        List<ComissaoConvenioVO> fatosBoletos;
        if (fatosBoletosFiltrados != null) {
            fatosBoletos = (List<ComissaoConvenioVO>) fatosBoletosFiltrados;
        } else {
            fatosBoletos = (List<ComissaoConvenioVO>) comissaoBoletos;
        }
        for (ComissaoConvenioVO fb : fatosBoletos) {
            if (fb.getQtd() != null) {
                total += fb.getQtd();

            }
        }
        return total;
    }

    public BigDecimal totalComLojaPaginaAtual() {

        BigDecimal valor = BigDecimal.ZERO;
        List<ComissaoConvenioVO> fatosBoletos;
        if (fatosBoletosFiltrados != null) {
            fatosBoletos = (List<ComissaoConvenioVO>) fatosBoletosFiltrados;
        } else {
            fatosBoletos = (List<ComissaoConvenioVO>) comissaoBoletos;
        }
        for (ComissaoConvenioVO fb : fatosBoletos) {
            if (fb.getComissaoloja() != null) {
                valor = valor.add(fb.getComissaoloja());

            }
        }
        return valor;
    }

    public BigDecimal totalComConvenioPaginaAtual() {

        BigDecimal valor = BigDecimal.ZERO;
        List<ComissaoConvenioVO> fatosBoletos;
        if (fatosBoletosFiltrados != null) {
            fatosBoletos = (List<ComissaoConvenioVO>) fatosBoletosFiltrados;
        } else {
            fatosBoletos = (List<ComissaoConvenioVO>) comissaoBoletos;
        }
        for (ComissaoConvenioVO fb : fatosBoletos) {
            if (fb.getComissaoconvenio() != null) {
                valor = valor.add(fb.getComissaoconvenio());

            }
        }
        return valor;
    }

    public BigDecimal totalComLiquidaPaginaAtual() {

        BigDecimal valor = BigDecimal.ZERO;
        List<ComissaoConvenioVO> fatosBoletos;
        if (fatosBoletosFiltrados != null) {
            fatosBoletos = (List<ComissaoConvenioVO>) fatosBoletosFiltrados;
        } else {
            fatosBoletos = (List<ComissaoConvenioVO>) comissaoBoletos;
        }
        for (ComissaoConvenioVO fb : fatosBoletos) {
            if (fb.getComissaoliquida() != null) {
                valor = valor.add(fb.getComissaoliquida());

            }
        }
        return valor;
    }

}
