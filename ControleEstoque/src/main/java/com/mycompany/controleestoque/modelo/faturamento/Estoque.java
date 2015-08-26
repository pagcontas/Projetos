/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.mycompany.controleestoque.modelo.faturamento;

import com.mycompany.controleestoque.modelo.cadastro.Loja_Filial;
import com.mycompany.controleestoque.modelo.cadastro.Produto;
import com.mycompany.controleestoque.modelo.cadastro.enums.UnidadeDeMedida;
import java.io.Serializable;
import java.math.BigDecimal;
import javax.persistence.Entity;
import javax.persistence.Enumerated;
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
public class Estoque implements Serializable {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    @NotNull
    @ManyToOne(fetch = FetchType.LAZY)
    private Loja_Filial empresa;

    @NotNull
    @ManyToOne(fetch = FetchType.EAGER)
    private Produto produto;
    
    @NotNull
    @Enumerated
    private UnidadeDeMedida unidadeDeVenda;

    @NotNull
    private BigDecimal quantidade;

    @NotNull
    private BigDecimal qtdMinima = BigDecimal.ZERO;
    
    private boolean ativo = true;

    public BigDecimal getValorTotal() {
        if (quantidade != null && produto != null) {
            return quantidade.multiply(produto.getValorDaCompra());
        } else {
            return BigDecimal.ZERO;
        }
    }

    public Estoque() {
    }

    @Override
    public String toString() {
        return produto.getCodigoDeBarra() + " - " + produto.getDescricao();
    }

    public Long getId() {
        return id;
    }

    public void setId(Long id) {
        this.id = id;
    }

    public Loja_Filial getEmpresa() {
        return empresa;
    }

    public void setEmpresa(Loja_Filial empresa) {
        this.empresa = empresa;
    }

    public Produto getProduto() {
        return produto;
    }

    public void setProduto(Produto produto) {
        this.produto = produto;
    }

    public BigDecimal getQuantidade() {
        return quantidade;
    }

    public void setQuantidade(BigDecimal quantidade) {
        this.quantidade = quantidade;
    }

    public BigDecimal getQtdMinima() {
        return qtdMinima;
    }

    public void setQtdMinima(BigDecimal qtdMinima) {
        this.qtdMinima = qtdMinima;
    }

    public boolean isAtivo() {
        return ativo;
    }

    public void setAtivo(boolean ativo) {
        this.ativo = ativo;
    }    

    public UnidadeDeMedida getUnidadeDeVenda() {
        return unidadeDeVenda;
    }

    public void setUnidadeDeVenda(UnidadeDeMedida unidadeDeVenda) {
        this.unidadeDeVenda = unidadeDeVenda;
    }
    
    @Override
    public int hashCode() {
        int hash = 3;
        hash = 17 * hash + (this.id != null ? this.id.hashCode() : 0);
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
        final Estoque other = (Estoque) obj;
        if (this.id != other.id && (this.id == null || !this.id.equals(other.id))) {
            return false;
        }
        return true;
    }

    public void addQuantidade(BigDecimal qtd) {
        if (quantidade != null) {
            quantidade = quantidade.add(qtd);
        }else{
            quantidade = qtd;
        }
    }

    public void removeQuantidade(BigDecimal qtd) {
        quantidade = quantidade.subtract(qtd);
    }
    
    
}
