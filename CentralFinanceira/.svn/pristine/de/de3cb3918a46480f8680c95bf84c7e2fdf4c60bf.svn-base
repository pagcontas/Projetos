package br.com.jsoft.centralfinanceira.mb.central;


import java.io.Serializable;
import com.xpert.core.crud.AbstractBaseBean;
import javax.ejb.EJB;
import javax.faces.bean.ManagedBean;
import javax.faces.bean.ViewScoped;
import br.com.jsoft.centralfinanceira.bo.central.FatosCreditosBO;
import br.com.jsoft.centralfinanceira.modelo.central.FatosCreditos;
import java.math.BigDecimal;
import java.math.RoundingMode;
import java.util.List;

/**
 *
 * @author Juniel
 */
@ManagedBean
@ViewScoped
public class FatosCreditosMB extends AbstractBaseBean<FatosCreditos> implements Serializable {

    @EJB
    private FatosCreditosBO fatosCreditosBO;

    @Override
    public FatosCreditosBO getBO() {
        return fatosCreditosBO;
    }

    @Override
    public String getDataModelOrder() {
        return "id";
    }
    
    public BigDecimal totalArrecadadoPaginaAtual() {

        BigDecimal valor = BigDecimal.ZERO;
        //o getDataModel retorna a lista paginada
        //o getWrappedData retorna os itens da pagina atual
        List<FatosCreditos> fatosBoletos = (List<FatosCreditos>) getDataModel().getWrappedData();
        for (FatosCreditos fb : fatosBoletos) {
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
        List<FatosCreditos> fatosBoletos = (List<FatosCreditos>) getDataModel().getWrappedData();
        for (FatosCreditos fb : fatosBoletos) {
            if (fb.getUnitarioconvenio()!= null) {
                valor = valor.add(fb.getUnitarioconvenio());

            }
        }
        return valor.divide(new BigDecimal (fatosBoletos.size()),2, RoundingMode.HALF_UP);
    }
    
    public BigDecimal totalUniLojaPaginaAtual() {

        BigDecimal valor = BigDecimal.ZERO;
        //o getDataModel retorna a lista paginada
        //o getWrappedData retorna os itens da pagina atual
        List<FatosCreditos> fatosBoletos = (List<FatosCreditos>) getDataModel().getWrappedData();
        for (FatosCreditos fb : fatosBoletos) {
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
        List<FatosCreditos> fatosBoletos = (List<FatosCreditos>) getDataModel().getWrappedData();
        for (FatosCreditos fb : fatosBoletos) {
            if (fb.getUnitarioLiquido() != null) {
                valor = valor.add(fb.getUnitarioLiquido());

            }
        }
        return valor;
    }
    
    public Integer totalQtdPaginaAtual() {
        Integer total = 0;
        List<FatosCreditos> fatosBoletos = (List<FatosCreditos>) getDataModel().getWrappedData();
        for (FatosCreditos fb : fatosBoletos) {
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
        List<FatosCreditos> fatosBoletos = (List<FatosCreditos>) getDataModel().getWrappedData();
        for (FatosCreditos fb : fatosBoletos) {
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
        List<FatosCreditos> fatosBoletos = (List<FatosCreditos>) getDataModel().getWrappedData();
        for (FatosCreditos fb : fatosBoletos) {
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
        List<FatosCreditos> fatosBoletos = (List<FatosCreditos>) getDataModel().getWrappedData();
        for (FatosCreditos fb : fatosBoletos) {
            if (fb.getComissaoLiquida()!= null) {
                valor = valor.add(fb.getComissaoLiquida());

            }
        }
        return valor;
    }
}
