package br.com.jsoft.centralfinanceira.mb.central;

import java.io.Serializable;
import com.xpert.core.crud.AbstractBaseBean;
import javax.ejb.EJB;
import javax.faces.bean.ManagedBean;
import javax.faces.bean.ViewScoped;
import br.com.jsoft.centralfinanceira.bo.central.FatosBoletosBO;
import br.com.jsoft.centralfinanceira.modelo.central.FatosBoletos;
import br.com.jsoft.centralfinanceira.modelo.enums.TipoBoletos;
import br.com.jsoft.centralfinanceira.vo.ConvenioCampConsultVO;
import br.com.jsoft.centralfinanceira.vo.RentabilidadeVO;
import com.xpert.core.exception.BusinessException;
import com.xpert.faces.utils.FacesMessageUtils;
import java.math.BigDecimal;
import java.math.RoundingMode;
import java.util.ArrayList;
import java.util.Calendar;
import java.util.Date;
import java.util.List;

/**
 *
 * @author Juniel
 */
@ManagedBean
@ViewScoped
public class RentabilidadeConvenioMB extends AbstractBaseBean<FatosBoletos> implements Serializable {

    @EJB
    private FatosBoletosBO fatosBoletosBO;

    private List<RentabilidadeVO> boletos; //1

    private List<RentabilidadeVO> boletosFiltrados;

    private ConvenioCampConsultVO camposConsulta;

    @Override
    public void init() {
        camposConsulta = new ConvenioCampConsultVO();
        boletos = new ArrayList<RentabilidadeVO>();
    }

    public void getListasConvenioConvenio() throws BusinessException {

        if (validarDataFinalMenorInicial(convertPeriodDate(camposConsulta.getDataInicial()), convertPeriodDate(camposConsulta.getDataFinal()))
                && validarDataInicialMaiorAtual(convertPeriodDate(camposConsulta.getDataInicial()))) {
            boletos = new ArrayList<RentabilidadeVO>();
            if (isBoleto()) {
                boletos = fatosBoletosBO.listRentabilidadeConvenio(camposConsulta.getConvenioBoleto() != null ? camposConsulta.getConvenioBoleto().getId() : null, convertPeriodDate(camposConsulta.getDataInicial()), convertPeriodDate(camposConsulta.getDataFinal()), 1);
            }
            if (isBoletoSite()) {
                boletos = fatosBoletosBO.listRentabilidadeConvenio(camposConsulta.getConvenioSite() != null ? camposConsulta.getConvenioSite().getId() : null, convertPeriodDate(camposConsulta.getDataInicial()), convertPeriodDate(camposConsulta.getDataFinal()), 2);
            }
            if (isCredito()) {
                boletos = fatosBoletosBO.listRentabilidadeConvenio(camposConsulta.getConvenioCredito() != null ? camposConsulta.getConvenioCredito().getId() : null, convertPeriodDate(camposConsulta.getDataInicial()), convertPeriodDate(camposConsulta.getDataFinal()), 3);
            }
            if (isRecarga()) {
                boletos = fatosBoletosBO.listRentabilidadeConvenio(camposConsulta.getConvenioRecarga() != null ? camposConsulta.getConvenioRecarga().getId() : null, convertPeriodDate(camposConsulta.getDataInicial()), convertPeriodDate(camposConsulta.getDataFinal()), 4);
            }
            if (isValeGas()) {
                boletos = fatosBoletosBO.listRentabilidadeConvenio(camposConsulta.getConvenioValeGas() != null ? camposConsulta.getConvenioValeGas().getId() : null, convertPeriodDate(camposConsulta.getDataInicial()), convertPeriodDate(camposConsulta.getDataFinal()), 5);
            }
            if (isOP()) {
                boletos = fatosBoletosBO.listRentabilidadeConvenio(camposConsulta.getConvenioOp() != null ? camposConsulta.getConvenioOp().getId() : null, convertPeriodDate(camposConsulta.getDataInicial()), convertPeriodDate(camposConsulta.getDataFinal()), 6);
            }
            if (isBB()) {
                boletos = fatosBoletosBO.listRentabilidadeConvenio(camposConsulta.getConvenioBB() != null ? camposConsulta.getConvenioBB().getId() : null, convertPeriodDate(camposConsulta.getDataInicial()), convertPeriodDate(camposConsulta.getDataFinal()), 7);
            }
            if (isBP()) {
                boletos = fatosBoletosBO.listRentabilidadeConvenio(camposConsulta.getConvenioBP() != null ? camposConsulta.getConvenioBP().getId() : null, convertPeriodDate(camposConsulta.getDataInicial()), convertPeriodDate(camposConsulta.getDataFinal()), 8);
            }
        }
        
        

    }

    private boolean validarDataFinalMenorInicial(Date data1, Date data2) throws BusinessException {
        if (data1 != null && data2 != null) {
            if (data1.after(data2)) {
                FacesMessageUtils.error("O Periodo Inicial não pode ser maior que o Periodo Final!");
                return false;
            }
        }

        return true;
    }

    private boolean validarDataInicialMaiorAtual(Date data1) throws BusinessException {
        if (data1 != null) {
            if (data1.after(new Date())) {
                FacesMessageUtils.error("O Periodo Inicial não pode ser maior que o Periodo Atual!");
                return false;
            }
        }

        return true;
    }

    private Date convertPeriodDate(String data) {
        Calendar agora = Calendar.getInstance();
        if (!"".equals(data)) {
            String[] temp = data.split("/");
            Integer periodoTemp = Integer.valueOf(temp[1] + temp[0]);
            agora.set(Integer.valueOf(temp[1]), Integer.valueOf(temp[0]) - 1, 1);

            return agora.getTime();
        }
        return null;
    }

    public Integer totalGuiasBoletos() {

        Integer valor = 0;

        List<RentabilidadeVO> boletosTemp;

        if (boletosFiltrados != null) {
            boletosTemp = (List<RentabilidadeVO>) boletosFiltrados;
        } else {
            boletosTemp = (List<RentabilidadeVO>) boletos;
        }

        for (RentabilidadeVO boleto : boletosTemp) {
            if (boleto.getGuias() != null) {
                valor += boleto.getGuias();
            }
        }
        return valor;
    }

    public BigDecimal totalValorBoletos() {

        BigDecimal valor = BigDecimal.ZERO;

        List<RentabilidadeVO> boletosTemp;

        if (boletosFiltrados != null) {
            boletosTemp = (List<RentabilidadeVO>) boletosFiltrados;
        } else {
            boletosTemp = (List<RentabilidadeVO>) boletos;
        }

        for (RentabilidadeVO boleto : boletosTemp) {
            if (boleto.getValor() != null) {
                valor = valor.add(boleto.getValor());
            }
        }
        return valor;
    }

    public BigDecimal totalComissaoConvenioBoletos() {
        BigDecimal valor = BigDecimal.ZERO;

        List<RentabilidadeVO> boletosTemp;

        if (boletosFiltrados != null) {
            boletosTemp = (List<RentabilidadeVO>) boletosFiltrados;
        } else {
            boletosTemp = (List<RentabilidadeVO>) boletos;
        }
        for (RentabilidadeVO boleto : boletosTemp) {
            if (boleto.getComissaoConvenio() != null) {
                valor = valor.add(boleto.getComissaoConvenio());
            }
        }
        return valor;
    }

    public BigDecimal totalTarifaLojaBoletos() {
        BigDecimal valor = BigDecimal.ZERO;

        List<RentabilidadeVO> boletosTemp;

        if (boletosFiltrados != null) {
            boletosTemp = (List<RentabilidadeVO>) boletosFiltrados;
        } else {
            boletosTemp = (List<RentabilidadeVO>) boletos;
        }
        for (RentabilidadeVO boleto : boletosTemp) {
            if (boleto.getTarifaLoja() != null) {
                valor = valor.add(boleto.getTarifaLoja());
            }
        }
        return valor;
    }

    public BigDecimal totalComissaoLojaBoletos() {
        BigDecimal valor = BigDecimal.ZERO;

        List<RentabilidadeVO> boletosTemp;

        if (boletosFiltrados != null) {
            boletosTemp = (List<RentabilidadeVO>) boletosFiltrados;
        } else {
            boletosTemp = (List<RentabilidadeVO>) boletos;
        }
        for (RentabilidadeVO boleto : boletosTemp) {
            if (boleto.getComissaoLoja() != null) {
                valor = valor.add(boleto.getComissaoLoja());
            }
        }
        return valor;
    }

    public BigDecimal totalComissaoW7Boletos() {
        BigDecimal valor = BigDecimal.ZERO;

        List<RentabilidadeVO> boletosTemp;

        if (boletosFiltrados != null) {
            boletosTemp = (List<RentabilidadeVO>) boletosFiltrados;
        } else {
            boletosTemp = (List<RentabilidadeVO>) boletos;
        }
        for (RentabilidadeVO boleto : boletosTemp) {
            if (boleto.getComissaoW7() != null) {
                valor = valor.add(boleto.getComissaoW7());
            }
        }
        return valor;
    }

    public BigDecimal totalComissaoSistemaBoletos() {
        BigDecimal valor = BigDecimal.ZERO;

        List<RentabilidadeVO> boletosTemp;

        if (boletosFiltrados != null) {
            boletosTemp = (List<RentabilidadeVO>) boletosFiltrados;
        } else {
            boletosTemp = (List<RentabilidadeVO>) boletos;
        }
        for (RentabilidadeVO boleto : boletosTemp) {
            if (boleto.getComissao() != null) {
                valor = valor.add(boleto.getComissao());
            }
        }
        return valor;
    }

    public BigDecimal totalDescontosBoletos() {
        BigDecimal valor = BigDecimal.ZERO;

        List<RentabilidadeVO> boletosTemp;

        if (boletosFiltrados != null) {
            boletosTemp = (List<RentabilidadeVO>) boletosFiltrados;
        } else {
            boletosTemp = (List<RentabilidadeVO>) boletos;
        }
        for (RentabilidadeVO boleto : boletosTemp) {
            if (boleto.getComissao() != null) {
                valor = valor.add(boleto.getComissao());
            }
            if (boleto.getComissaoLoja() != null) {
                valor = valor.add(boleto.getComissaoLoja());
            }
            if (boleto.getTarifaLoja() != null) {
                valor = valor.add(boleto.getTarifaLoja());
            }

            if (boleto.getComissaoW7() != null) {
                valor = valor.add(boleto.getComissaoW7());
            }
        }
        return valor;
    }

    public BigDecimal totalImpostoBoletos() {
        BigDecimal valor = BigDecimal.ZERO;

        List<RentabilidadeVO> boletosTemp;

        if (boletosFiltrados != null) {
            boletosTemp = (List<RentabilidadeVO>) boletosFiltrados;
        } else {
            boletosTemp = (List<RentabilidadeVO>) boletos;
        }
        for (RentabilidadeVO boleto : boletosTemp) {
            if (boleto.getImposto() != null) {
                valor = valor.add(boleto.getImposto());
            }
        }
        return valor;
    }

    public BigDecimal totalLiquidoBoletos() {
        BigDecimal valor = BigDecimal.ZERO;

        List<RentabilidadeVO> boletosTemp;

        if (boletosFiltrados != null) {
            boletosTemp = (List<RentabilidadeVO>) boletosFiltrados;
        } else {
            boletosTemp = (List<RentabilidadeVO>) boletos;
        }
        for (RentabilidadeVO boleto : boletosTemp) {
            if (boleto.getLiquido() != null) {
                valor = valor.add(boleto.getLiquido());
            }
        }
        return valor;
    }

    @Override
    public FatosBoletosBO getBO() {
        return fatosBoletosBO;
    }

    @Override
    public String getDataModelOrder() {
        return "id";
    }

    public List<RentabilidadeVO> getBoletos() {
        return boletos;
    }

    public ConvenioCampConsultVO getCamposConsulta() {
        return camposConsulta;
    }

    public void setCamposConsulta(ConvenioCampConsultVO camposConsulta) {
        this.camposConsulta = camposConsulta;
    }

    public List<RentabilidadeVO> getBoletosFiltrados() {
        return boletosFiltrados;
    }

    public void setBoletosFiltrados(List<RentabilidadeVO> boletosFiltrados) {
        this.boletosFiltrados = boletosFiltrados;
    }

    public BigDecimal porcentagemComissao(BigDecimal total, BigDecimal totalPorcentagem) {
        if (total != null && totalPorcentagem != null && total.compareTo(BigDecimal.ZERO) > 0 && totalPorcentagem.compareTo(BigDecimal.ZERO) > 0) {
            return totalPorcentagem.multiply(BigDecimal.valueOf(100)).divide(total, 2, RoundingMode.HALF_UP);
        }
        return BigDecimal.ZERO;
    }

    public BigDecimal porcentagemLiquida(BigDecimal total, BigDecimal totalPorcentagem) {
        if (total != null && totalPorcentagem != null && total.compareTo(BigDecimal.ZERO) > 0 && totalPorcentagem.compareTo(BigDecimal.ZERO) > 0) {
            return totalPorcentagem.multiply(BigDecimal.valueOf(100)).divide(total, 2, RoundingMode.HALF_UP);
        }
        return BigDecimal.ZERO;
    }

    public boolean isBoleto() {
        return camposConsulta.getTipoBoleto() == TipoBoletos.BOLETOS;
    }

    public boolean isBoletoSite() {
        return camposConsulta.getTipoBoleto() == TipoBoletos.BOLETOSITE;
    }

    public boolean isCredito() {
        return camposConsulta.getTipoBoleto() == TipoBoletos.CREDIDOS;
    }

    public boolean isRecarga() {
        return camposConsulta.getTipoBoleto() == TipoBoletos.RECARGA;
    }

    public boolean isValeGas() {
        return camposConsulta.getTipoBoleto() == TipoBoletos.VALEGAS;
    }

    public boolean isOP() {
        return camposConsulta.getTipoBoleto() == TipoBoletos.OPS;
    }

    public boolean isBB() {
        return camposConsulta.getTipoBoleto() == TipoBoletos.BB;
    }

    public boolean isBP() {
        return camposConsulta.getTipoBoleto() == TipoBoletos.BP;
    }
}
