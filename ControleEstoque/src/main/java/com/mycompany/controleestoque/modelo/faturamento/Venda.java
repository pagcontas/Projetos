/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.mycompany.controleestoque.modelo.faturamento;

import com.mycompany.controleestoque.modelo.cadastro.Cliente;
import com.mycompany.controleestoque.modelo.cadastro.ContaBancaria;
import com.mycompany.controleestoque.modelo.cadastro.GrupoLoja;
import com.mycompany.controleestoque.modelo.cadastro.Loja_Filial;
import com.mycompany.controleestoque.modelo.cadastro.NaturezasDeOperacoes;
import com.mycompany.controleestoque.modelo.cadastro.enums.FormaDePagamento;
import com.mycompany.controleestoque.modelo.cadastro.enums.ModalidadeFrete;
import com.mycompany.controleestoque.modelo.controleacesso.Usuario;
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
import javax.persistence.Temporal;
import javax.persistence.TemporalType;
import javax.validation.constraints.NotNull;
import javax.persistence.OneToMany;
import javax.persistence.OrderBy;
import com.xpert.audit.NotAudited;

/**
 *
 * @author juniel
 */
@Entity
public class Venda implements Serializable {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    @NotNull
    @ManyToOne(fetch = FetchType.LAZY)
    private Loja_Filial loja;

    @ManyToOne(fetch = FetchType.LAZY)
    private Usuario vendedor;

    @NotNull
    @ManyToOne(fetch = FetchType.LAZY)
    private GrupoLoja grupoLoja;

    @NotNull
    @ManyToOne(fetch = FetchType.LAZY)
    private Cliente cliente;
    
    private String nomeEcNPJCliente;

    @NotNull
    @ManyToOne(fetch = FetchType.LAZY)
    private ContaBancaria conta;

    @NotNull
    @ManyToOne(fetch = FetchType.LAZY)
    private NaturezasDeOperacoes natureza;

    @NotNull
    @Temporal(TemporalType.TIMESTAMP)
    private Date dataVenda = new Date();

    @NotNull
    @Temporal(TemporalType.TIMESTAMP)
    private Date dataEntrega = new Date();

    @NotNull
    private FormaDePagamento formaPagamento;

    @NotNull
    private ModalidadeFrete modalidade = ModalidadeFrete.SEMFRETE;

    @NotNull
    private BigDecimal totalAPagar;

    private BigDecimal valorEntrada;

    private BigDecimal desconto;
    
    private String campoComplementar;

    @OneToMany(mappedBy = "venda", cascade = CascadeType.ALL)
    private List<ItemVenda> itensVenda = new ArrayList<ItemVenda>();

    @NotAudited
    @OrderBy("numeroNota")
    @OneToMany(mappedBy = "venda")
    private List<NotaFiscal> notaFiscal;

    private boolean ativo = false;

    public Long getId() {
        return id;
    }

    public void setId(Long id) {
        this.id = id;
    }

    public Loja_Filial getLoja() {
        return loja;
    }

    public void setLoja(Loja_Filial loja) {
        this.loja = loja;
    }

    public Usuario getVendedor() {
        return vendedor;
    }

    public void setVendedor(Usuario vendedor) {
        this.vendedor = vendedor;
    }

    public ContaBancaria getConta() {
        return conta;
    }

    public void setConta(ContaBancaria conta) {
        this.conta = conta;
    }

    public GrupoLoja getGrupoLoja() {
        return grupoLoja;
    }

    public void setGrupoLoja(GrupoLoja grupoLoja) {
        this.grupoLoja = grupoLoja;
    }

    public BigDecimal getDesconto() {
        return desconto;
    }

    public void setDesconto(BigDecimal desconto) {
        this.desconto = desconto;
    }

    public Cliente getCliente() {
        return cliente;
    }

    public void setCliente(Cliente cliente) {
        this.cliente = cliente;
    }

    public NaturezasDeOperacoes getNatureza() {
        return natureza;
    }

    public void setNatureza(NaturezasDeOperacoes natureza) {
        this.natureza = natureza;
    }

    public Date getDataVenda() {
        return dataVenda;
    }

    public void setDataVenda(Date dataVenda) {
        this.dataVenda = dataVenda;
    }

    public Date getDataEntrega() {
        return dataEntrega;
    }

    public void setDataEntrega(Date dataEntrega) {
        this.dataEntrega = dataEntrega;
    }

    public FormaDePagamento getFormaPagamento() {
        return formaPagamento;
    }

    public void setFormaPagamento(FormaDePagamento formaPagamento) {
        this.formaPagamento = formaPagamento;
    }

    public BigDecimal getTotalAPagar() {
        return totalAPagar;
    }

    public void setTotalAPagar(BigDecimal totalAPagar) {
        this.totalAPagar = totalAPagar;
    }

    public BigDecimal getValorEntrada() {
        return valorEntrada;
    }

    public void setValorEntrada(BigDecimal valorEntrada) {
        this.valorEntrada = valorEntrada;
    }

    public List<ItemVenda> getItensVenda() {
        return itensVenda;
    }

    public void setItensVenda(List<ItemVenda> itensVenda) {
        this.itensVenda = itensVenda;
    }

    public String getCampoComplementar() {
        return campoComplementar;
    }

    public void setCampoComplementar(String campoComplementar) {
        this.campoComplementar = campoComplementar;
    }

    public String getNomeEcNPJCliente() {
        return nomeEcNPJCliente;
    }

    public void setNomeEcNPJCliente(String nomeEcNPJCliente) {
        this.nomeEcNPJCliente = nomeEcNPJCliente;
    }

    public boolean isAtivo() {
        return ativo;
    }

    public void setAtivo(boolean ativo) {
        this.ativo = ativo;
    }

    public List<NotaFiscal> getNotaFiscal() {
        return notaFiscal;
    }

    public void setNotaFiscal(List<NotaFiscal> notaFiscal) {
        this.notaFiscal = notaFiscal;
    }

    public ModalidadeFrete getModalidade() {
        return modalidade;
    }

    public void setModalidade(ModalidadeFrete modalidade) {
        this.modalidade = modalidade;
    }

    @Override
    public String toString() {
        return id + "";
    }

    public Venda() {
    }

    @Override
    public int hashCode() {
        int hash = 7;
        hash = 47 * hash + (this.id != null ? this.id.hashCode() : 0);
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
        final Venda other = (Venda) obj;
        if (this.id != other.id && (this.id == null || !this.id.equals(other.id))) {
            return false;
        }
        return true;
    }

}
