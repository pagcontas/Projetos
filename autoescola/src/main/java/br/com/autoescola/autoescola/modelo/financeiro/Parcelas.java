/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package br.com.autoescola.autoescola.modelo.financeiro;

import com.xpert.audit.NotAudited;
import java.io.Serializable;
import java.math.BigDecimal;
import java.util.Date;
import javax.persistence.Entity;
import javax.persistence.FetchType;
import javax.persistence.GeneratedValue;
import javax.persistence.Id;
import javax.persistence.ManyToOne;
import javax.persistence.SequenceGenerator;
import javax.persistence.Temporal;
import javax.persistence.TemporalType;

/**
 *
 * @author killerbee
 */
@Entity
public class Parcelas implements Serializable{

    @Id
    @SequenceGenerator(name = "Parcelas", allocationSize = 1, sequenceName = "seq_parcelas")
    @GeneratedValue(generator = "Parcelas")
    private long id;

    private Integer parcela;

    private BigDecimal valor;
    
    @Temporal(TemporalType.DATE)
    private Date dataVencimento;

    @Temporal(TemporalType.DATE)
    private Date dataPagamento;

    private boolean situacao = false;
    
    private String codigoIdenficacao;
    
    @NotAudited
    @ManyToOne(fetch = FetchType.LAZY)
    private Pagamento pagamento;
    

    public Pagamento getPagamento() {
        return pagamento;
    }

    public void setPagamento(Pagamento pagamento) {
        this.pagamento = pagamento;
    }

    public Parcelas() {
    }

    public long getId() {
        return id;
    }

    public String getCodigoIdenficacao() {
        return codigoIdenficacao;
    }

    public void setCodigoIdenficacao(String codigoIdenficacao) {
        this.codigoIdenficacao = codigoIdenficacao;
    }

    public void setId(long id) {
        this.id = id;
    }

    public Integer getParcela() {
        return parcela;
    }

    public void setParcela(Integer parcela) {
        this.parcela = parcela;
    }

    public BigDecimal getValor() {
        return valor;
    }

    public void setValor(BigDecimal valor) {
        this.valor = valor;
    }

    public Date getDataPagamento() {
        return dataPagamento;
    }

    public void setDataPagamento(Date dataPagamento) {
        this.dataPagamento = dataPagamento;
    }

    public Date getDataVencimento() {
        return dataVencimento;
    }

    public void setDataVencimento(Date dataVencimento) {
        this.dataVencimento = dataVencimento;
    }
        
    public boolean getSituacao() {
        return situacao;
    }

    public void setSituacao(boolean situacao) {
        this.situacao = situacao;
    }

    @Override
    public int hashCode() {
        int hash = 7;
        hash = 59 * hash + (int) (this.id ^ (this.id >>> 32));
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
        final Parcelas other = (Parcelas) obj;
        if (this.id != other.id) {
            return false;
        }
        return true;
    }

}
