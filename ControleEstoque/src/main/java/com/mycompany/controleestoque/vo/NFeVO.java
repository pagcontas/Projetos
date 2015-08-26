/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.mycompany.controleestoque.vo;

import com.mycompany.controleestoque.modelo.faturamento.ItemVenda;
import com.mycompany.controleestoque.modelo.faturamento.Venda;
import java.math.BigDecimal;

/**
 *
 * @author KillerBeeTwo
 */
public class NFeVO {

    private final String codigo;

    private final String descricaoPouS;

    private final String ncm;

    private final String cst;

    private final String cfop;

    private final String unid;

    private final String qtd;
    
    private final String valorUni;

    private final String valorTotal;

    private final String icms;

    private final String valorIcms;

    private final String valorIpi;

    private final String aliqIcms;

    private final String aliqIpi;

    public NFeVO(ItemVenda item) {
        this.codigo = String.format("%013d", item.getProduto().getId());

        this.descricaoPouS = item.getProduto().getDescricao();

        this.ncm = item.getProduto().getCodigoNCM();

        this.cst = item.getProduto().getCodigoCst();

        this.cfop = item.getProduto().getCfop();

        this.unid = item.getProduto().getUnidadeDeVenda().getDescricao();

        this.qtd = item.getQtd().toString();
        
        this.valorUni = item.getValorUnitario().toString();

        this.valorTotal = item.getQtd().multiply(item.getValorUnitario()).setScale(2, BigDecimal.ROUND_HALF_UP).toString();

        this.icms = "0.00";

        this.valorIcms = item.getProduto().getIcmsCompra().toString();

        this.valorIpi = item.getProduto().getIpi().toString();

        this.aliqIcms = "0.00";

        this.aliqIpi = "0.00";
    }

    public String getCodigo() {
        return codigo;
    }

    public String getDescricaoPouS() {
        return descricaoPouS;
    }

    public String getNcm() {
        return ncm;
    }

    public String getCst() {
        return cst;
    }

    public String getCfop() {
        return cfop;
    }

    public String getUnid() {
        return unid;
    }

    public String getQtd() {
        return qtd;
    }

    public String getValorUni() {
        return valorUni;
    }

    public String getValorTotal() {
        return valorTotal;
    }

    public String getIcms() {
        return icms;
    }

    public String getValorIcms() {
        return valorIcms;
    }

    public String getValorIpi() {
        return valorIpi;
    }

    public String getAliqIcms() {
        return aliqIcms;
    }

    public String getAliqIpi() {
        return aliqIpi;
    }

   

}
