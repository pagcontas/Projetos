package br.com.jsoft.centralfinanceira.vo;


import br.com.jsoft.centralfinanceira.modelo.central.FatosBoletos;
import java.math.BigDecimal;
import java.math.RoundingMode;
import java.text.DecimalFormat;
import java.util.Formatter;

/**
 *
 * @author Juniel
 */
public class RelatorioRemunecaoVO {

    private final String loja;
    private final String periodo;
    private final String qtd;
    private final String convenioBoleto;
    private final String arrecadado;
    private final String unitarioConvenio;
    private final String unitarioLoja;
    private final String comissaoLoja; // qtd * unitarioLoja
    private final String comissaoConvenio; //qtd * unitarioConvenio
    private final String unitarioLiquido; // unitarioConvenio - unitarioLoja
    private final String comissaoLiquida; //comissaoConvenio - comissaoLoja 

    public RelatorioRemunecaoVO(FatosBoletos entity) {
        Formatter formatter = new Formatter();
        this.loja = entity.getLoja().getId() + " - " + entity.getLoja().getNome();
        this.periodo = convertMes(Integer.valueOf(getMes(entity.getPeriodo()))) + "/" + getAno(entity.getPeriodo());
        this.qtd = formatter.format("%,d", entity.getQtd()).toString();
        this.convenioBoleto = entity.getConvenioboleto().getId().toString() + " - " + entity.getConvenioboleto().getNome();
        this.arrecadado = converterDoubleString(entity.getArrecadado());
        this.unitarioConvenio = converterDoubleString(entity.getUnitarioconvenio());
        this.unitarioLoja = converterDoubleString(entity.getUnitarioloja());
        this.comissaoLoja = converterDoubleString(entity.getComissaoLoja());
        this.comissaoConvenio = converterDoubleString(arredondaMaisEmString(entity.getComissaoConvenio().doubleValue()));
        this.unitarioLiquido = converterDoubleString(arredondaMaisEmString(entity.getUnitarioLiquido().doubleValue()));
        this.comissaoLiquida = converterDoubleString(arredondaMaisEmString(entity.getComissaoLiquida().doubleValue()));
    }

    private String converterDoubleString(BigDecimal num) {
        /*Transformando um double em 2 casas decimais*/
        if (num != null) {
            DecimalFormat fmt = new DecimalFormat("#,###,##0.00");   //limita o número de casas decimais      
            String string = fmt.format(num);
            return string;
        }
        return BigDecimal.ZERO.toString();
    }

    private BigDecimal arredondaMaisEmString(Double valor) {
        if (valor != null) {
            BigDecimal bd = new BigDecimal(valor).setScale(2, RoundingMode.HALF_EVEN);
            return bd;
        }
        return BigDecimal.ZERO;

    }

    private String convertMes(int mes) {
        String mesRetorno;
        switch (mes) {
            case 1:
                mesRetorno = "Jan";
                break;
            case 2:
                mesRetorno = "Fev";
                break;
            case 3:
                mesRetorno = "Mar";
                break;
            case 4:
                mesRetorno = "Abr";
                break;
            case 5:
                mesRetorno = "Mai";
                break;
            case 6:
                mesRetorno = "Jun";
                break;
            case 7:
                mesRetorno = "Jul";
                break;
            case 8:
                mesRetorno = "Ago";
                break;
            case 9:
                mesRetorno = "Set";
                break;
            case 10:
                mesRetorno = "Out";
                break;
            case 11:
                mesRetorno = "Nov";
                break;
            case 12:
                mesRetorno = "Dez";
                break;
            default:
                mesRetorno = "";
        }
        return mesRetorno;
    }

    public String getLoja() {
        return loja;
    }

    private String getMes(Integer periodo) {
        String str = periodo.toString();
        return str.substring(4, 6);
    }

    private String getAno(Integer periodo) {
        String str = periodo.toString();
        return str.substring(0, 4);
    }

    public String getPeriodo() {
        return periodo;
    }

    public String getQtd() {
        return qtd;
    }

    public String getConvenioBoleto() {
        return convenioBoleto;
    }

    public String getArrecadado() {
        return arrecadado;
    }

    public String getUnitarioConvenio() {
        return unitarioConvenio;
    }

    public String getUnitarioLoja() {
        return unitarioLoja;
    }

    public String getComissaoLoja() {
        return comissaoLoja;
    }

    public String getComissaoConvenio() {
        return comissaoConvenio;
    }

    public String getUnitarioLiquido() {
        return unitarioLiquido;
    }

    public String getComissaoLiquida() {
        return comissaoLiquida;
    }
}
