package br.com.jsoft.centralfinanceira.mb.central;


import java.io.Serializable;
import com.xpert.core.crud.AbstractBaseBean;
import javax.ejb.EJB;
import javax.faces.bean.ManagedBean;
import javax.faces.bean.ViewScoped;
import br.com.jsoft.centralfinanceira.bo.central.FatosBanPopBO;
import br.com.jsoft.centralfinanceira.modelo.central.FatosBanPop;
import java.math.BigDecimal;
import java.math.RoundingMode;
import java.util.List;

/**
 *
 * @author ti05
 */
@ManagedBean
@ViewScoped
public class FatosBanPopMB extends AbstractBaseBean<FatosBanPop> implements Serializable {

    @EJB
    private FatosBanPopBO fatosBanPopBO;

    @Override
    public FatosBanPopBO getBO() {
        return fatosBanPopBO;
    }

    @Override
    public String getDataModelOrder() {
        return "id";
    }
    
    public BigDecimal totalArrecadadoPaginaAtual() {

        BigDecimal valor = BigDecimal.ZERO;
        //o getDataModel retorna a lista paginada
        //o getWrappedData retorna os itens da pagina atual
        List<FatosBanPop> fatosBoletos = (List<FatosBanPop>) getDataModel().getWrappedData();
        for (FatosBanPop fb : fatosBoletos) {
            if (fb.getArrecadado() != null) {
                valor = valor.add(fb.getArrecadado());

            }
        }
        return valor;
    }

    public BigDecimal totalUniConvenioPaginaAtual() {

        BigDecimal valor = BigDecimal.ZERO;
        //o getDataModel retorna a lista paginada
        //o getWrappedData retorna os itens da pagina atual
        List<FatosBanPop> fatosBoletos = (List<FatosBanPop>) getDataModel().getWrappedData();
        for (FatosBanPop fb : fatosBoletos) {
            if (fb.getUnitarioconvenio() != null) {
                valor = valor.add(fb.getUnitarioconvenio());

            }
        }
        return valor.divide(new BigDecimal (fatosBoletos.size()),2, RoundingMode.HALF_UP);
    }
    
    public BigDecimal totalUniLojaPaginaAtual() {

        BigDecimal valor = BigDecimal.ZERO;
        //o getDataModel retorna a lista paginada
        //o getWrappedData retorna os itens da pagina atual
        List<FatosBanPop> fatosBoletos = (List<FatosBanPop>) getDataModel().getWrappedData();
        for (FatosBanPop fb : fatosBoletos) {
            if (fb.getUnitarioloja() != null) {
                valor = valor.add(fb.getUnitarioloja());

            }
        }
        return valor.divide(new BigDecimal (fatosBoletos.size()),2, RoundingMode.HALF_UP);
    }
    
    public BigDecimal totalUniLiquidoPaginaAtual() {

        BigDecimal valor = BigDecimal.ZERO;
        //o getDataModel retorna a lista paginada
        //o getWrappedData retorna os itens da pagina atual
        List<FatosBanPop> fatosBoletos = (List<FatosBanPop>) getDataModel().getWrappedData();
        for (FatosBanPop fb : fatosBoletos) {
            if (fb.getUnitarioLiquido() != null) {
                valor = valor.add(fb.getUnitarioLiquido());

            }
        }
        return valor;
    }
    
    public Integer totalQtdPaginaAtual() {
        Integer total = 0;
        List<FatosBanPop> fatosBoletos = (List<FatosBanPop>) getDataModel().getWrappedData();
        for (FatosBanPop fb : fatosBoletos) {
            if (fb.getQtd() != null) {
                total += fb.getQtd();

            }
        }
        return total;
    }
    
    public BigDecimal totalComLojaPaginaAtual() {

        BigDecimal valor = BigDecimal.ZERO;
        //o getDataModel retorna a lista paginada
        //o getWrappedData retorna os itens da pagina atual
        List<FatosBanPop> fatosBoletos = (List<FatosBanPop>) getDataModel().getWrappedData();
        for (FatosBanPop fb : fatosBoletos) {
            if (fb.getComissaoLoja() != null) {
                valor = valor.add(fb.getComissaoLoja());

            }
        }
        return valor;
    }
    
    
    public BigDecimal totalComConvenioPaginaAtual() {

        BigDecimal valor = BigDecimal.ZERO;
        //o getDataModel retorna a lista paginada
        //o getWrappedData retorna os itens da pagina atual
        List<FatosBanPop> fatosBoletos = (List<FatosBanPop>) getDataModel().getWrappedData();
        for (FatosBanPop fb : fatosBoletos) {
            if (fb.getComissaoConvenio() != null) {
                valor = valor.add(fb.getComissaoConvenio());

            }
        }
        return valor;
    }
    
    public BigDecimal totalComLiquidaPaginaAtual() {

        BigDecimal valor = BigDecimal.ZERO;
        //o getDataModel retorna a lista paginada
        //o getWrappedData retorna os itens da pagina atual
        List<FatosBanPop> fatosBoletos = (List<FatosBanPop>) getDataModel().getWrappedData();
        for (FatosBanPop fb : fatosBoletos) {
            if (fb.getComissaoLiquida()!= null) {
                valor = valor.add(fb.getComissaoLiquida());

            }
        }
        return valor;
    }
}
