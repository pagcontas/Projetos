package br.com.jsoft.centralfinanceira.mb.central;


import java.io.Serializable;
import com.xpert.core.crud.AbstractBaseBean;
import javax.ejb.EJB;
import javax.faces.bean.ManagedBean;
import javax.faces.bean.ViewScoped;
import br.com.jsoft.centralfinanceira.bo.central.FatosopsBO;
import br.com.jsoft.centralfinanceira.dao.central.FatosopsDAO;
import br.com.jsoft.centralfinanceira.modelo.central.Fatosops;
import br.com.jsoft.centralfinanceira.vo.ComissaoConvenioOPVO;
import java.math.BigDecimal;
import java.math.RoundingMode;
import java.util.List;

/**
 *
 * @author Juniel
 */
@ManagedBean
@ViewScoped
public class BoletosConvenioOpsMB extends AbstractBaseBean<Fatosops> implements Serializable {

    @EJB
    private FatosopsBO fatosopsBO;
    
    @EJB
    private FatosopsDAO fatosBoletosDAO;
    
    private List<Fatosops> fatos;
    
    private List<ComissaoConvenioOPVO> comissaoBoletos;
    
    private ComissaoConvenioOPVO comissaoConvenio;
    
    private List<ComissaoConvenioOPVO> fatosBoletosFiltrados;

    public FatosopsBO getFatosopsBO() {
        return fatosopsBO;
    }

    public void setFatosopsBO(FatosopsBO fatosopsBO) {
        this.fatosopsBO = fatosopsBO;
    }

    public FatosopsDAO getFatosBoletosDAO() {
        return fatosBoletosDAO;
    }

    public void setFatosBoletosDAO(FatosopsDAO fatosBoletosDAO) {
        this.fatosBoletosDAO = fatosBoletosDAO;
    }

    public List<Fatosops> getFatos() {
        return fatos;
    }

    public void setFatos(List<Fatosops> fatos) {
        this.fatos = fatos;
    }

    public List<ComissaoConvenioOPVO> getComissaoBoletos() {
        return comissaoBoletos;
    }

    public void setComissaoBoletos(List<ComissaoConvenioOPVO> comissaoBoletos) {
        this.comissaoBoletos = comissaoBoletos;
    }

    public ComissaoConvenioOPVO getComissaoConvenio() {
        return comissaoConvenio;
    }

    public void setComissaoConvenio(ComissaoConvenioOPVO comissaoConvenio) {
        this.comissaoConvenio = comissaoConvenio;
    }

    public List<ComissaoConvenioOPVO> getFatosBoletosFiltrados() {
        return fatosBoletosFiltrados;
    }

    public void setFatosBoletosFiltrados(List<ComissaoConvenioOPVO> fatosBoletosFiltrados) {
        this.fatosBoletosFiltrados = fatosBoletosFiltrados;
    }

    @Override
    public FatosopsBO getBO() {
        return fatosopsBO;
    }

    @Override
    public String getDataModelOrder() {
        return "id";
    }
    
    public void updateUnitarioConvenio() {
        fatosopsBO.updateUniConvenio(comissaoConvenio);
    }
    
    @Override
    public void init() {
        comissaoBoletos = fatosBoletosDAO.listBoletoConvenio();
    }
    
    public BigDecimal totalArrecadadoPaginaAtual() {

        BigDecimal valor = BigDecimal.ZERO;
        List<ComissaoConvenioOPVO> fatosBoletos;
        if (fatosBoletosFiltrados != null) {
            fatosBoletos = (List<ComissaoConvenioOPVO>) fatosBoletosFiltrados;
        } else {
            fatosBoletos = (List<ComissaoConvenioOPVO>) comissaoBoletos;
        }
        for (ComissaoConvenioOPVO fb : fatosBoletos) {
            if (fb.getArrecadado() != null) {
                valor = valor.add(fb.getArrecadado());

            }
        }
        return valor;
    }

    public BigDecimal totalUniConvenioPaginaAtual() {

        BigDecimal valor = BigDecimal.ZERO;
        List<ComissaoConvenioOPVO> fatosBoletos;
        if (fatosBoletosFiltrados != null) {
            fatosBoletos = (List<ComissaoConvenioOPVO>) fatosBoletosFiltrados;
        } else {
            fatosBoletos = (List<ComissaoConvenioOPVO>) comissaoBoletos;
        }
        for (ComissaoConvenioOPVO fb : fatosBoletos) {
            if (fb.getUnitarioconvenio() != null) {
                valor = valor.add(fb.getUnitarioconvenio());

            }
        }
        return valor.divide(new BigDecimal(fatosBoletos.size()), 2, RoundingMode.HALF_UP);
    }

    public Integer totalQtdPaginaAtual() {
        Integer total = 0;
        List<ComissaoConvenioOPVO> fatosBoletos;
        if (fatosBoletosFiltrados != null) {
            fatosBoletos = (List<ComissaoConvenioOPVO>) fatosBoletosFiltrados;
        } else {
            fatosBoletos = (List<ComissaoConvenioOPVO>) comissaoBoletos;
        }
        for (ComissaoConvenioOPVO fb : fatosBoletos) {
            if (fb.getQtd() != null) {
                total += fb.getQtd();

            }
        }
        return total;
    }

    public BigDecimal totalComLojaPaginaAtual() {

        BigDecimal valor = BigDecimal.ZERO;
        List<ComissaoConvenioOPVO> fatosBoletos;
        if (fatosBoletosFiltrados != null) {
            fatosBoletos = (List<ComissaoConvenioOPVO>) fatosBoletosFiltrados;
        } else {
            fatosBoletos = (List<ComissaoConvenioOPVO>) comissaoBoletos;
        }
        for (ComissaoConvenioOPVO fb : fatosBoletos) {
            if (fb.getComissaoloja() != null) {
                valor = valor.add(fb.getComissaoloja());

            }
        }
        return valor;
    }

    public BigDecimal totalComConvenioPaginaAtual() {

        BigDecimal valor = BigDecimal.ZERO;
        List<ComissaoConvenioOPVO> fatosBoletos;
        if (fatosBoletosFiltrados != null) {
            fatosBoletos = (List<ComissaoConvenioOPVO>) fatosBoletosFiltrados;
        } else {
            fatosBoletos = (List<ComissaoConvenioOPVO>) comissaoBoletos;
        }
        for (ComissaoConvenioOPVO fb : fatosBoletos) {
            if (fb.getComissaoconvenio() != null) {
                valor = valor.add(fb.getComissaoconvenio());

            }
        }
        return valor;
    }

    public BigDecimal totalComLiquidaPaginaAtual() {

        BigDecimal valor = BigDecimal.ZERO;
        List<ComissaoConvenioOPVO> fatosBoletos;
        if (fatosBoletosFiltrados != null) {
            fatosBoletos = (List<ComissaoConvenioOPVO>) fatosBoletosFiltrados;
        } else {
            fatosBoletos = (List<ComissaoConvenioOPVO>) comissaoBoletos;
        }
        for (ComissaoConvenioOPVO fb : fatosBoletos) {
            if (fb.getComissaoliquida() != null) {
                valor = valor.add(fb.getComissaoliquida());

            }
        }
        return valor;
    }

}
