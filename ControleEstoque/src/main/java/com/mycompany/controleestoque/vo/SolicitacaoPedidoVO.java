/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.mycompany.controleestoque.vo;

import com.mycompany.controleestoque.modelo.faturamento.ItemPedido;
import com.mycompany.controleestoque.modelo.faturamento.ItemVenda;
import java.math.BigDecimal;

/**
 *
 * @author KillerBeeTwo
 */
public class SolicitacaoPedidoVO {
    
    private final String index;

    private final String produto;

    private final String qtd;

    private final String valorUnitario;

    private final String unidadeDeVenda;

    private final String icmsCompra;

    private final String ipi;

    private final String desconto;

    private final String marca;

    private final String totalPorProd;

    public SolicitacaoPedidoVO(int i, ItemPedido item) {
        this.index = String.format("%03d", i);
        this.produto = item.getProduto().getDescricao();
        this.marca = item.getProduto().getMarca() != null ? item.getProduto().getMarca() : "";
        this.unidadeDeVenda = item.getUnidadeDeVenda().toString();
        this.qtd = item.getQtd().setScale(2, BigDecimal.ROUND_HALF_UP).toString();
        this.valorUnitario = item.getValorUnitario().setScale(2, BigDecimal.ROUND_HALF_UP).toString();
        this.icmsCompra = item.getIcmsCompra().setScale(2, BigDecimal.ROUND_HALF_UP).toString();
        this.ipi = item.getIpi().setScale(2, BigDecimal.ROUND_HALF_UP).toString();
        this.desconto = item.getDesconto().setScale(2, BigDecimal.ROUND_HALF_UP).toString();
        this.totalPorProd = item.getQtd().multiply(item.getValorUnitario()).setScale(2, BigDecimal.ROUND_HALF_UP).toString();
    }

    public SolicitacaoPedidoVO(int i, ItemVenda item) {
        this.index = String.format("%03d", i);
        this.produto = item.getProduto().getDescricao();
        this.marca = item.getProduto().getMarca() != null ? item.getProduto().getMarca() : "";
        this.unidadeDeVenda = item.getUnidadeDeVenda().toString() ;
        this.qtd = item.getQtd().setScale(2, BigDecimal.ROUND_HALF_UP).toString();
        this.valorUnitario = item.getValorUnitario().setScale(2, BigDecimal.ROUND_HALF_UP).toString();
        this.icmsCompra = item.getIcmsCompra().setScale(2, BigDecimal.ROUND_HALF_UP).toString();
        this.ipi = item.getIpi().setScale(2, BigDecimal.ROUND_HALF_UP).toString();
        this.desconto = item.getDesconto().setScale(2, BigDecimal.ROUND_HALF_UP).toString();
        this.totalPorProd = item.getQtd().multiply(item.getValorUnitario()).setScale(2, BigDecimal.ROUND_HALF_UP).toString();
    }

    public String getProduto() {
        return produto;
    }

    public String getQtd() {
        return qtd;
    }

    public String getValorUnitario() {
        return valorUnitario;
    }

    public String getUnidadeDeVenda() {
        return unidadeDeVenda;
    }

    public String getIcmsCompra() {
        return icmsCompra;
    }

    public String getIpi() {
        return ipi;
    }

    public String getDesconto() {
        return desconto;
    }

    public String getMarca() {
        return marca;
    }

    public String getTotalPorProd() {
        return totalPorProd;
    }

    public String getIndex() {
        return index;
    }
    
    

}
