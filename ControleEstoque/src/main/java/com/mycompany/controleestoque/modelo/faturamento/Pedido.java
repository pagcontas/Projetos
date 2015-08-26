/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.mycompany.controleestoque.modelo.faturamento;

import com.mycompany.controleestoque.modelo.cadastro.Fornecedor;
import com.mycompany.controleestoque.modelo.cadastro.Loja_Filial;
import com.mycompany.controleestoque.modelo.cadastro.enums.FormaDePagamento;
import com.mycompany.controleestoque.modelo.cadastro.enums.TipoPedido;
import java.io.Serializable;
import java.math.BigDecimal;
import java.util.ArrayList;
import java.util.Date;
import java.util.List;
import javax.persistence.CascadeType;
import javax.persistence.Entity;
import javax.persistence.FetchType;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.ManyToOne;
import javax.persistence.OneToMany;
import javax.persistence.Temporal;
import javax.persistence.TemporalType;
import javax.validation.constraints.NotNull;

/**
 *
 * @author juniel
 */
@Entity
public class Pedido implements Serializable {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    @ManyToOne(fetch = FetchType.LAZY)
    private Loja_Filial loja;

    @ManyToOne(fetch = FetchType.LAZY)
    private Fornecedor fornecedor;

    @NotNull
    @OneToMany(mappedBy = "pedido", cascade = CascadeType.ALL)
    private List<ItemPedido> itensPedidos = new ArrayList<ItemPedido>();

    @Temporal(TemporalType.DATE)
    private Date dataEmissao = new Date();
    
    @NotNull
    @Temporal(TemporalType.DATE)
    private Date dataPedido = new Date();

    @Temporal(TemporalType.DATE)
    private Date dataPrevista = new Date();

    private FormaDePagamento formaPagamento;

    private BigDecimal valorMercadoria;

    private BigDecimal valorDoFrete;

    private BigDecimal valorDaNota;
    
    private String codigoNota;
    
    private BigDecimal desconto;
    
    @NotNull
    private TipoPedido tipo;

    private boolean ativo = false;

    public Long getId() {
        return id;
    }

    public void setId(Long id) {
        this.id = id;
    }

    public Pedido() {
    }

    @Override
    public String toString() {
        return id+"";
    }   

    public Loja_Filial getLoja() {
        return loja;
    }

    public void setLoja(Loja_Filial loja) {
        this.loja = loja;
    }

    public Fornecedor getFornecedor() {
        return fornecedor;
    }

    public void setFornecedor(Fornecedor fornecedor) {
        this.fornecedor = fornecedor;
    }

    public Date getDataPedido() {
        return dataPedido;
    }

    public void setDataPedido(Date dataPedido) {
        this.dataPedido = dataPedido;
    }

    public Date getDataPrevista() {
        return dataPrevista;
    }

    public void setDataPrevista(Date dataPrevista) {
        this.dataPrevista = dataPrevista;
    }

    public FormaDePagamento getFormaPagamento() {
        return formaPagamento;
    }

    public void setFormaPagamento(FormaDePagamento formaPagamento) {
        this.formaPagamento = formaPagamento;
    }

    public BigDecimal getDesconto() {
        return desconto;
    }

    public void setDesconto(BigDecimal desconto) {
        this.desconto = desconto;
    }

    public BigDecimal getValorMercadoria() {
        return valorMercadoria;
    }

    public void setValorMercadoria(BigDecimal valorMercadoria) {
        this.valorMercadoria = valorMercadoria;
    }

    public BigDecimal getValorDoFrete() {
        return valorDoFrete;
    }

    public void setValorDoFrete(BigDecimal valorDoFrete) {
        this.valorDoFrete = valorDoFrete;
    }

    public BigDecimal getValorDaNota() {
        return valorDaNota;
    }

    public void setValorDaNota(BigDecimal valorDaNota) {
        this.valorDaNota = valorDaNota;
    }

    public List<ItemPedido> getItensPedidos() {
        return itensPedidos;
    }

    public void setItensPedidos(List<ItemPedido> itensPedidos) {
        this.itensPedidos = itensPedidos;
    }

    public String getCodigoNota() {
        return codigoNota;
    }

    public void setCodigoNota(String codigoNota) {
        this.codigoNota = codigoNota;
    }

    @Override
    public int hashCode() {
        int hash = 5;
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
        final Pedido other = (Pedido) obj;
        if (this.id != other.id && (this.id == null || !this.id.equals(other.id))) {
            return false;
        }
        return true;
    }

    public boolean isAtivo() {
        return ativo;
    }

    public void setAtivo(boolean ativo) {
        this.ativo = ativo;
    }

    public Date getDataEmissao() {
        return dataEmissao;
    }

    public void setDataEmissao(Date dataEmissao) {
        this.dataEmissao = dataEmissao;
    }

    public TipoPedido getTipo() {
        return tipo;
    }

    public void setTipo(TipoPedido tipo) {
        this.tipo = tipo;
    }

}
