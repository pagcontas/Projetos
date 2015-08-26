package br.com.jsoft.centralfinanceira.mb.central;

import java.io.Serializable;
import com.xpert.core.crud.AbstractBaseBean;
import javax.ejb.EJB;
import javax.faces.bean.ManagedBean;
import javax.faces.bean.ViewScoped;
import br.com.jsoft.centralfinanceira.bo.central.FatosCreditosBO;
import br.com.jsoft.centralfinanceira.dao.central.FatosCreditosDAO;
import br.com.jsoft.centralfinanceira.modelo.central.FatosCreditos;
import br.com.jsoft.centralfinanceira.vo.ComissaoConvenioCredVO;
import java.math.BigDecimal;
import java.math.RoundingMode;
import java.util.List;

/**
 *
 * @author Juniel
 */
@ManagedBean
@ViewScoped
public class BoletosConvenioCredMB extends AbstractBaseBean<FatosCreditos> implements Serializable {

    @EJB
    private FatosCreditosBO fatosBoletosBO;

    @EJB
    private FatosCreditosDAO fatosBoletosDAO;

    private List<FatosCreditos> fatos;

    private List<ComissaoConvenioCredVO> comissaoBoletos;

    private ComissaoConvenioCredVO comissaoConvenio;

    List<ComissaoConvenioCredVO> fatosBoletosFiltrados;

    public List<ComissaoConvenioCredVO> getFatosBoletosFiltrados() {
        return fatosBoletosFiltrados;
    }

    public void setFatosBoletosFiltrados(List<ComissaoConvenioCredVO> fatosBoletosFiltrados) {
        this.fatosBoletosFiltrados = fatosBoletosFiltrados;
    }

    public ComissaoConvenioCredVO getComissaoConvenio() {
        return comissaoConvenio;
    }

    public void setComissaoConvenio(ComissaoConvenioCredVO comissaoConvenio) {
        this.comissaoConvenio = comissaoConvenio;
    }

    @Override
    public FatosCreditosBO getBO() {
        return fatosBoletosBO;
    }

    public void updateUnitarioConvenio() {
        fatosBoletosBO.updateUniConvenio(comissaoConvenio);
    }

    @Override
    public String getDataModelOrder() {
        return "id";
    }

    public void setFatos(List<FatosCreditos> fatos) {
        this.fatos = fatos;
    }

    public List<ComissaoConvenioCredVO> getComissaoBoletos() {
        return comissaoBoletos;
    }

    public void setComissaoBoletos(List<ComissaoConvenioCredVO> comissaoBoletos) {
        this.comissaoBoletos = comissaoBoletos;
    }

    public FatosCreditosBO getFatosCreditosBO() {
        return fatosBoletosBO;
    }

    public void setFatosCreditosBO(FatosCreditosBO fatosBoletosBO) {
        this.fatosBoletosBO = fatosBoletosBO;
    }

    public FatosCreditosDAO getFatosCreditosDAO() {
        return fatosBoletosDAO;
    }

    public void setFatosCreditosDAO(FatosCreditosDAO fatosBoletosDAO) {
        this.fatosBoletosDAO = fatosBoletosDAO;
    }

    @Override
    public void init() {
        comissaoBoletos = fatosBoletosDAO.listBoletoConvenio();
    }

    public BigDecimal totalArrecadadoPaginaAtual() {

        BigDecimal valor = BigDecimal.ZERO;
        List<ComissaoConvenioCredVO> fatosBoletos;
        if (fatosBoletosFiltrados != null) {
            fatosBoletos = (List<ComissaoConvenioCredVO>) fatosBoletosFiltrados;
        } else {
            fatosBoletos = (List<ComissaoConvenioCredVO>) comissaoBoletos;
        }
        for (ComissaoConvenioCredVO fb : fatosBoletos) {
            if (fb.getArrecadado() != null) {
                valor = valor.add(fb.getArrecadado());

            }
        }
        return valor;
    }

    public BigDecimal totalUniConvenioPaginaAtual() {

        BigDecimal valor = BigDecimal.ZERO;
        List<ComissaoConvenioCredVO> fatosBoletos;
        if (fatosBoletosFiltrados != null) {
            fatosBoletos = (List<ComissaoConvenioCredVO>) fatosBoletosFiltrados;
        } else {
            fatosBoletos = (List<ComissaoConvenioCredVO>) comissaoBoletos;
        }
        for (ComissaoConvenioCredVO fb : fatosBoletos) {
            if (fb.getUnitarioconvenio() != null) {
                valor = valor.add(fb.getUnitarioconvenio());

            }
        }
        return valor.divide(new BigDecimal(fatosBoletos.size()), 2, RoundingMode.HALF_UP);
    }

    public Integer totalQtdPaginaAtual() {
        Integer total = 0;
        List<ComissaoConvenioCredVO> fatosBoletos;
        if (fatosBoletosFiltrados != null) {
            fatosBoletos = (List<ComissaoConvenioCredVO>) fatosBoletosFiltrados;
        } else {
            fatosBoletos = (List<ComissaoConvenioCredVO>) comissaoBoletos;
        }
        for (ComissaoConvenioCredVO fb : fatosBoletos) {
            if (fb.getQtd() != null) {
                total += fb.getQtd();

            }
        }
        return total;
    }

    public BigDecimal totalComLojaPaginaAtual() {

        BigDecimal valor = BigDecimal.ZERO;
        List<ComissaoConvenioCredVO> fatosBoletos;
        if (fatosBoletosFiltrados != null) {
            fatosBoletos = (List<ComissaoConvenioCredVO>) fatosBoletosFiltrados;
        } else {
            fatosBoletos = (List<ComissaoConvenioCredVO>) comissaoBoletos;
        }
        for (ComissaoConvenioCredVO fb : fatosBoletos) {
            if (fb.getComissaoloja() != null) {
                valor = valor.add(fb.getComissaoloja());

            }
        }
        return valor;
    }

    public BigDecimal totalComConvenioPaginaAtual() {

        BigDecimal valor = BigDecimal.ZERO;
        List<ComissaoConvenioCredVO> fatosBoletos;
        if (fatosBoletosFiltrados != null) {
            fatosBoletos = (List<ComissaoConvenioCredVO>) fatosBoletosFiltrados;
        } else {
            fatosBoletos = (List<ComissaoConvenioCredVO>) comissaoBoletos;
        }
        for (ComissaoConvenioCredVO fb : fatosBoletos) {
            if (fb.getComissaoconvenio() != null) {
                valor = valor.add(fb.getComissaoconvenio());

            }
        }
        return valor;
    }

    public BigDecimal totalComLiquidaPaginaAtual() {

        BigDecimal valor = BigDecimal.ZERO;
        List<ComissaoConvenioCredVO> fatosBoletos;
        if (fatosBoletosFiltrados != null) {
            fatosBoletos = (List<ComissaoConvenioCredVO>) fatosBoletosFiltrados;
        } else {
            fatosBoletos = (List<ComissaoConvenioCredVO>) comissaoBoletos;
        }
        for (ComissaoConvenioCredVO fb : fatosBoletos) {
            if (fb.getComissaoliquida() != null) {
                valor = valor.add(fb.getComissaoliquida());

            }
        }
        return valor;
    }

}
