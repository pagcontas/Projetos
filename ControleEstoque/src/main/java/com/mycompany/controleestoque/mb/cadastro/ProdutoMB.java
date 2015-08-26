package com.mycompany.controleestoque.mb.cadastro;

import java.io.Serializable;
import com.xpert.core.crud.AbstractBaseBean;
import javax.ejb.EJB;
import javax.faces.bean.ManagedBean;
import javax.faces.bean.ViewScoped;
import com.mycompany.controleestoque.bo.cadastro.ProdutoBO;
import com.mycompany.controleestoque.modelo.cadastro.Produto;
import com.xpert.faces.utils.FacesUtils;
import java.math.BigDecimal;

/**
 *
 * @author juniel
 */
@ManagedBean
@ViewScoped
public class ProdutoMB extends AbstractBaseBean<Produto> implements Serializable {

    @EJB
    private ProdutoBO produtoBO;

    @Override
    public ProdutoBO getBO() {
        return produtoBO;
    }

    @Override
    public String getDataModelOrder() {
        return "descricao";
    }

    @Override
    public void postSave() {
        if (getId() != null) {
            FacesUtils.redirect("/view/cadastro/produto/listProduto.jsf");
        } else {
            setEntity(new Produto());
        }
    }
    
    private BigDecimal getPrecoCusto() {
        BigDecimal valor = BigDecimal.ZERO;

        if (getEntity().getValorDaCompra() != null) {
            if (getEntity().getIcmsPreco() != null) {
                valor = valor.add(calculaPorcentagem(getEntity().getIcmsPreco(), getEntity().getValorDaCompra()));
            }

            if (getEntity().getIcmsCompra() != null) {
                valor = valor.subtract(calculaPorcentagem(getEntity().getIcmsCompra(), getEntity().getValorDaCompra()));
            }

            if (getEntity().getIpi() != null) {
                valor = valor.add(calculaPorcentagem(getEntity().getIpi(), getEntity().getValorDaCompra()));
            }

            if (getEntity().getFrete() != null) {
                valor = valor.add(calculaPorcentagem(getEntity().getFrete(), getEntity().getValorDaCompra()));
            }

            valor = valor.add(getEntity().getValorDaCompra());
        }

        return valor;
    }

    private BigDecimal getPrecoDeVenda() {
        BigDecimal valor = BigDecimal.ZERO;

        valor = valor.add(getPrecoCusto());

        if (getEntity().getLucroBruto() != null) {
            valor = valor.add(calculaPorcentagem(getEntity().getLucroBruto(), getPrecoCusto()));
        }

        return valor;
    }

    private BigDecimal getPrecoRevenda() {
        return getPrecoDeVenda();
    }

    private BigDecimal getPercLucroLiquido() {
        BigDecimal porcentagem = BigDecimal.ZERO;
        if (getEntity().getValorDeVenda() != null && getEntity().getValorDeVenda() != BigDecimal.ZERO && getPrecoCusto() != BigDecimal.ZERO && getPrecoCusto() !=null) {
            porcentagem = porcentagem.add(getEntity().getValorDeVenda().subtract(getPrecoCusto()).multiply(BigDecimal.valueOf(100)).divide(getEntity().getValorDeVenda(), 2, BigDecimal.ROUND_UP));
        }

        return porcentagem;
    }

    private BigDecimal getPercLucroBruto() {
        BigDecimal porcentagem = BigDecimal.ZERO;
        if (getEntity().getValorDeVenda() != null && getEntity().getValorDeVenda() != BigDecimal.ZERO && getPrecoCusto() != BigDecimal.ZERO) {
            porcentagem = porcentagem.add(getEntity().getValorDeVenda().subtract(getPrecoCusto()).multiply(BigDecimal.valueOf(100)).divide(getEntity().getValorDeVenda(), 2, BigDecimal.ROUND_UP));
        }

        return porcentagem;
    }

    private BigDecimal calculaPorcentagem(BigDecimal porcentagem, BigDecimal valor) {
        BigDecimal valorRetorno = BigDecimal.ZERO;

        valorRetorno = valorRetorno.add(porcentagem.multiply(valor).divide(BigDecimal.valueOf(100), 2, BigDecimal.ROUND_UP));

        return valorRetorno;
    }

    private BigDecimal getValorFracao() {
        BigDecimal valor = BigDecimal.ZERO;

        if (getEntity().getQtdFracoes() != null && getEntity().getValorDeVenda() != null) {
            if (BigDecimal.valueOf(getEntity().getQtdFracoes()) != BigDecimal.ZERO) {
                valor = valor.add(getEntity().getValorDeVenda().divide(BigDecimal.valueOf(getEntity().getQtdFracoes()), 2, BigDecimal.ROUND_UP));
            }
        }

        return valor;

    }

    public void setPrecoCusto() {
        getEntity().setPrecoDeCusto(getPrecoCusto());
    }
    
    public void setPrecoVenda(){
        getEntity().setValorDeVenda(getPrecoDeVenda());
    }    
  
    public void setValorRevenda(){
        getEntity().setValorRevenda(getPrecoRevenda());
    }
    
    public void setFracionado(){
        getEntity().setValorFracionado(getValorFracao());
    }
    
    public void setLucro(){
        getEntity().setLucroBruto( getPercLucroLiquido());
    }

}
