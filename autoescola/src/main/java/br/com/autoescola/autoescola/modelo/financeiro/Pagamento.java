/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package br.com.autoescola.autoescola.modelo.financeiro;

import br.com.autoescola.autoescola.modelo.cadastro.Aluno;
import br.com.autoescola.autoescola.modelo.financeiro.enums.Bandeira;
import java.io.Serializable;
import java.math.BigDecimal;
import java.util.Date;
import java.util.List;
import javax.persistence.CascadeType;
import javax.persistence.Entity;
import javax.persistence.FetchType;
import javax.persistence.GeneratedValue;
import javax.persistence.Id;
import javax.persistence.ManyToOne;
import javax.persistence.OneToMany;
import javax.persistence.OrderBy;
import javax.persistence.SequenceGenerator;
import javax.persistence.Temporal;
import javax.persistence.TemporalType;
import javax.validation.constraints.NotNull;

/**
 *
 * @author killerbee
 */
@Entity
public class Pagamento implements Serializable {

    @Id
    @SequenceGenerator(name = "Pagamento", allocationSize = 1, sequenceName = "seq_pagamento")
    @GeneratedValue(generator = "Pagamento")
    private long id;

    @ManyToOne(fetch = FetchType.EAGER)
    private Aluno aluno;

    @NotNull
    private BigDecimal valor;

    private BigDecimal desconto;

    private BigDecimal entrada;

    @NotNull
    private Bandeira tipoPagamento;

    @NotNull
    @Temporal(TemporalType.DATE)
    private Date dataPrimeiraParcela;

    @NotNull
    private Integer qtdParcelas;
    
    private boolean pago = false;

    @OrderBy("dataPagamento")
    @OneToMany(mappedBy = "pagamento", cascade = CascadeType.ALL)
    private List<Parcelas> parcelas;

    public Pagamento() {
    }

    public boolean isPago() {
        return pago;
    }

    public void setPago(boolean pago) {
        this.pago = pago;
    }
    
    public long getId() {
        return id;
    }

    public void setId(long id) {
        this.id = id;
    }

    public Aluno getAluno() {
        return aluno;
    }

    public void setAluno(Aluno aluno) {
        this.aluno = aluno;
    }

    public BigDecimal getValor() {
        return valor;
    }

    public void setValor(BigDecimal valor) {
        this.valor = valor;
    }

    public BigDecimal getDesconto() {
        return desconto;
    }

    public void setDesconto(BigDecimal desconto) {
        this.desconto = desconto;
    }

    public BigDecimal getEntrada() {
        return entrada;
    }

    public void setEntrada(BigDecimal entrada) {
        this.entrada = entrada;
    }

    public Bandeira getTipoPagamento() {
        return tipoPagamento;
    }

    public void setTipoPagamento(Bandeira tipoPagamento) {
        this.tipoPagamento = tipoPagamento;
    }

    public Date getDataPrimeiraParcela() {
        return dataPrimeiraParcela;
    }

    public void setDataPrimeiraParcela(Date dataPrimeiraParcela) {
        this.dataPrimeiraParcela = dataPrimeiraParcela;
    }

    public Integer getQtdParcelas() {
        return qtdParcelas;
    }

    public void setQtdParcelas(Integer qtdParcelas) {
        this.qtdParcelas = qtdParcelas;
    }

    public List<Parcelas> getParcelas() {
        return parcelas;
    }

    public void setParcelas(List<Parcelas> parcelas) {
        this.parcelas = parcelas;
    }

    @Override
    public int hashCode() {
        int hash = 5;
        hash = 53 * hash + (int) (this.id ^ (this.id >>> 32));
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
        final Pagamento other = (Pagamento) obj;
        if (this.id != other.id) {
            return false;
        }
        return true;
    }

}
