/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.mycompany.controleestoque.modelo.faturamento;

import com.mycompany.controleestoque.modelo.cadastro.Produto;
import com.mycompany.controleestoque.modelo.cadastro.enums.UnidadeDeMedida;
import java.io.Serializable;
import java.math.BigDecimal;
import javax.persistence.Entity;
import javax.persistence.FetchType;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.ManyToOne;
import javax.validation.constraints.NotNull;

/**
 *
 * @author juniel
 */
@Entity
public class ItemPedido implements Serializable {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    @ManyToOne(fetch = FetchType.EAGER)
    private Pedido pedido;

    @NotNull
    @ManyToOne(fetch = FetchType.EAGER)
    private Produto produto;

    private BigDecimal qtd;

    private BigDecimal valorUnitario;
    
    private UnidadeDeMedida unidadeDeVenda;

    private BigDecimal icmsCompra;

    private BigDecimal ipi;
    
    private BigDecimal desconto;
    
    private boolean atualizarValor = false;
    
    public boolean ativo = true;

    public Long getId() {
        return id;
    }

    public void setId(Long id) {
        this.id = id;
    }

    public Pedido getPedido() {
        return pedido;
    }

    public void setPedido(Pedido pedido) {
        this.pedido = pedido;
    }
    
    public BigDecimal getQtd() {
        return qtd;
    }

    public void setQtd(BigDecimal qtd) {
        this.qtd = qtd;
    }

    public Produto getProduto() {
        return produto;
    }

    public void setProduto(Produto produto) {
        this.produto = produto;
    }

    public BigDecimal getValorUnitario() {
        return valorUnitario;
    }

    public void setValorUnitario(BigDecimal valorUnitario) {
        this.valorUnitario = valorUnitario;
    }

    public UnidadeDeMedida getUnidadeDeVenda() {
        return unidadeDeVenda;
    }

    public void setUnidadeDeVenda(UnidadeDeMedida unidadeDeVenda) {
        this.unidadeDeVenda = unidadeDeVenda;
    }

    public BigDecimal getIcmsCompra() {
        return icmsCompra;
    }

    public void setIcmsCompra(BigDecimal icmsCompra) {
        this.icmsCompra = icmsCompra;
    }

    public BigDecimal getIpi() {
        return ipi;
    }

    public BigDecimal getDesconto() {
        return desconto;
    }

    public void setDesconto(BigDecimal desconto) {
        this.desconto = desconto;
    }

    public void setIpi(BigDecimal ipi) {
        this.ipi = ipi;
    }

    public boolean isAtivo() {
        return ativo;
    }

    public void setAtivo(boolean ativo) {
        this.ativo = ativo;
    }

    public boolean isAtualizarValor() {
        return atualizarValor;
    }

    public void setAtualizarValor(boolean atualizarValor) {
        this.atualizarValor = atualizarValor;
    }

    @Override
    public int hashCode() {
        int hash = 7;
        hash = 67 * hash + (this.id != null ? this.id.hashCode() : 0);
        return hash;
    }

    @Override
    public boolean equals(Object obj) {
        if (obj == null) {
            return false;
        }
        if (getClass() != obj.getClass()) {
            return false;
        }
        final ItemPedido other = (ItemPedido) obj;
        if (this.id != other.id && (this.id == null || !this.id.equals(other.id))) {
            return false;
        }
        return true;
    }

}
