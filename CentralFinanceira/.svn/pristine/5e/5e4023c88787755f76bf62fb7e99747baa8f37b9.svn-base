package br.com.jsoft.centralfinanceira.mb.central;

import java.io.Serializable;
import com.xpert.core.crud.AbstractBaseBean;
import javax.ejb.EJB;
import javax.faces.bean.ManagedBean;
import javax.faces.bean.ViewScoped;
import br.com.jsoft.centralfinanceira.bo.central.FatosRecargaBO;
import br.com.jsoft.centralfinanceira.dao.central.FatosRecargaDAO;
import br.com.jsoft.centralfinanceira.modelo.central.FatosRecarga;
import br.com.jsoft.centralfinanceira.vo.ComissaoConvenioRecargaVO;
import java.math.BigDecimal;
import java.math.RoundingMode;
import java.util.List;

/**
 *
 * @author Juniel
 */
@ManagedBean
@ViewScoped
public class BoletosConvenioRecargaMB extends AbstractBaseBean<FatosRecarga> implements Serializable {

    @EJB
    private FatosRecargaBO fatosBoletosBO;

    @EJB
    private FatosRecargaDAO fatosBoletosDAO;

    private List<FatosRecarga> fatos;

    private List<ComissaoConvenioRecargaVO> comissaoBoletos;

    private ComissaoConvenioRecargaVO comissaoConvenio;

    List<ComissaoConvenioRecargaVO> fatosBoletosFiltrados;

    public FatosRecargaBO getFatosBoletosBO() {
        return fatosBoletosBO;
    }

    public void setFatosBoletosBO(FatosRecargaBO fatosBoletosBO) {
        this.fatosBoletosBO = fatosBoletosBO;
    }

    public FatosRecargaDAO getFatosBoletosDAO() {
        return fatosBoletosDAO;
    }

    public void setFatosBoletosDAO(FatosRecargaDAO fatosBoletosDAO) {
        this.fatosBoletosDAO = fatosBoletosDAO;
    }

    public List<ComissaoConvenioRecargaVO> getFatosBoletosFiltrados() {
        return fatosBoletosFiltrados;
    }

    public void setFatosBoletosFiltrados(List<ComissaoConvenioRecargaVO> fatosBoletosFiltrados) {
        this.fatosBoletosFiltrados = fatosBoletosFiltrados;
    }  

    public ComissaoConvenioRecargaVO getComissaoConvenio() {
        return comissaoConvenio;
    }

    public void setComissaoConvenio(ComissaoConvenioRecargaVO comissaoConvenio) {
        this.comissaoConvenio = comissaoConvenio;
    }

    @Override
    public FatosRecargaBO getBO() {
        return fatosBoletosBO;
    }

    public void updateUnitarioConvenio() {
        fatosBoletosBO.updateUniConvenio(comissaoConvenio);
    }

    @Override
    public String getDataModelOrder() {
        return "id";
    }

    public void setFatos(List<FatosRecarga> fatos) {
        this.fatos = fatos;
    }

    public List<ComissaoConvenioRecargaVO> getComissaoBoletos() {
        return comissaoBoletos;
    }

    public void setComissaoBoletos(List<ComissaoConvenioRecargaVO> comissaoBoletos) {
        this.comissaoBoletos = comissaoBoletos;
    }

    public FatosRecargaBO getFatosRecargaBO() {
        return fatosBoletosBO;
    }

    public void setFatosRecargaBO(FatosRecargaBO fatosBoletosBO) {
        this.fatosBoletosBO = fatosBoletosBO;
    }

    public FatosRecargaDAO getFatosRecargaDAO() {
        return fatosBoletosDAO;
    }

    public void setFatosRecargaDAO(FatosRecargaDAO fatosBoletosDAO) {
        this.fatosBoletosDAO = fatosBoletosDAO;
    }

    @Override
    public void init() {
        comissaoBoletos = fatosBoletosDAO.listBoletoConvenio();
    }

    public BigDecimal totalArrecadadoPaginaAtual() {

        BigDecimal valor = BigDecimal.ZERO;
        List<ComissaoConvenioRecargaVO> fatosBoletos;
        if (fatosBoletosFiltrados != null) {
            fatosBoletos = (List<ComissaoConvenioRecargaVO>) fatosBoletosFiltrados;
        } else {
            fatosBoletos = (List<ComissaoConvenioRecargaVO>) comissaoBoletos;
        }
        for (ComissaoConvenioRecargaVO fb : fatosBoletos) {
            if (fb.getArrecadado() != null) {
                valor = valor.add(fb.getArrecadado());

            }
        }
        return valor;
    }

    public BigDecimal totalUniConvenioPaginaAtual() {

        BigDecimal valor = BigDecimal.ZERO;
        List<ComissaoConvenioRecargaVO> fatosBoletos;
        if (fatosBoletosFiltrados != null) {
            fatosBoletos = (List<ComissaoConvenioRecargaVO>) fatosBoletosFiltrados;
        } else {
            fatosBoletos = (List<ComissaoConvenioRecargaVO>) comissaoBoletos;
        }
        for (ComissaoConvenioRecargaVO fb : fatosBoletos) {
            if (fb.getUnitarioconvenio() != null) {
                valor = valor.add(fb.getUnitarioconvenio());

            }
        }
        return valor.divide(new BigDecimal(fatosBoletos.size()), 2, RoundingMode.HALF_UP);
    }

    public Integer totalQtdPaginaAtual() {
        Integer total = 0;
        List<ComissaoConvenioRecargaVO> fatosBoletos;
        if (fatosBoletosFiltrados != null) {
            fatosBoletos = (List<ComissaoConvenioRecargaVO>) fatosBoletosFiltrados;
        } else {
            fatosBoletos = (List<ComissaoConvenioRecargaVO>) comissaoBoletos;
        }
        for (ComissaoConvenioRecargaVO fb : fatosBoletos) {
            if (fb.getQtd() != null) {
                total += fb.getQtd();

            }
        }
        return total;
    }

    public BigDecimal totalComLojaPaginaAtual() {

        BigDecimal valor = BigDecimal.ZERO;
        List<ComissaoConvenioRecargaVO> fatosBoletos;
        if (fatosBoletosFiltrados != null) {
            fatosBoletos = (List<ComissaoConvenioRecargaVO>) fatosBoletosFiltrados;
        } else {
            fatosBoletos = (List<ComissaoConvenioRecargaVO>) comissaoBoletos;
        }
        for (ComissaoConvenioRecargaVO fb : fatosBoletos) {
            if (fb.getComissaoloja() != null) {
                valor = valor.add(fb.getComissaoloja());

            }
        }
        return valor;
    }

    public BigDecimal totalComConvenioPaginaAtual() {

        BigDecimal valor = BigDecimal.ZERO;
        List<ComissaoConvenioRecargaVO> fatosBoletos;
        if (fatosBoletosFiltrados != null) {
            fatosBoletos = (List<ComissaoConvenioRecargaVO>) fatosBoletosFiltrados;
        } else {
            fatosBoletos = (List<ComissaoConvenioRecargaVO>) comissaoBoletos;
        }
        for (ComissaoConvenioRecargaVO fb : fatosBoletos) {
            if (fb.getComissaoconvenio() != null) {
                valor = valor.add(fb.getComissaoconvenio());

            }
        }
        return valor;
    }

    public BigDecimal totalComLiquidaPaginaAtual() {

        BigDecimal valor = BigDecimal.ZERO;
        List<ComissaoConvenioRecargaVO> fatosBoletos;
        if (fatosBoletosFiltrados != null) {
            fatosBoletos = (List<ComissaoConvenioRecargaVO>) fatosBoletosFiltrados;
        } else {
            fatosBoletos = (List<ComissaoConvenioRecargaVO>) comissaoBoletos;
        }
        for (ComissaoConvenioRecargaVO fb : fatosBoletos) {
            if (fb.getComissaoliquida() != null) {
                valor = valor.add(fb.getComissaoliquida());

            }
        }
        return valor;
    }

}
