/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package br.com.jsoft.centralfinanceira.modelo.central;

import java.io.Serializable;
import java.math.BigDecimal;
import javax.persistence.Entity;
import javax.persistence.FetchType;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.ManyToOne;
import javax.persistence.PostLoad;
import javax.persistence.Table;
import javax.persistence.Transient;
import javax.validation.constraints.Min;
import javax.validation.constraints.NotNull;
import org.hibernate.annotations.Formula;

/**
 *
 * @author jj
 */
@Entity
@Table(schema="dados")
public class FatosBoletos implements Serializable {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    @NotNull
    private short ano;
    
    @NotNull
    private short mes;

    @NotNull
    private int qtd;
 
    private BigDecimal arrecadado;
    
    private BigDecimal unitarioconvenio;

    private BigDecimal unitarioposto;
    
    @Transient
    private BigDecimal unitarioliquido;
    
    @ManyToOne(fetch = FetchType.LAZY)     
    private Posto posto;

    @ManyToOne(fetch = FetchType.LAZY) 
    private ConvenioBoleto convenioboleto;
    
    

    public BigDecimal getUnitarioliquido() {
        return unitarioliquido;
    }
    
    @PostLoad
    public void setUnitarioliquido() {
        unitarioliquido = this.unitarioconvenio.subtract(this.unitarioposto);
    }
    
    public BigDecimal getArrecadado() {
        return arrecadado;
    }

    public void setArrecadado(BigDecimal arrecadado) {
        this.arrecadado = arrecadado;
    }

    public BigDecimal getUnitarioconvenio() {
        return unitarioconvenio;
    }

    public void setUnitarioconvenio(BigDecimal unitarioconvenio) {
        this.unitarioconvenio = unitarioconvenio;
    }

    public Posto getPosto() {
        return posto;
    }

    public void setPosto(Posto posto) {
        this.posto = posto;
    }

    public ConvenioBoleto getConvenioboleto() {
        return convenioboleto;
    }

    public void setConvenioboleto(ConvenioBoleto convenioboleto) {
        this.convenioboleto = convenioboleto;
    }

    
    public Long getId() {
        return id;
    }

    public void setId(Long id) {
        this.id = id;
    }

    public short getAno() {
        return ano;
    }

    public void setAno(short ano) {
        this.ano = ano;
    }

    public short getMes() {
        return mes;
    }

    public void setMes(short mes) {
        this.mes = mes;
    }

    public int getQtd() {
        return qtd;
    }

    public void setQtd(int qtd) {
        this.qtd = qtd;
    }

    public BigDecimal getUnitarioposto() {
        return unitarioposto;
    }

    public void setUnitarioposto(BigDecimal unitarioposto) {
        this.unitarioposto = unitarioposto;
    }


    @Override
    public int hashCode() {
        int hash = 0;
        hash += (id != null ? id.hashCode() : 0);
        return hash;
    }

    @Override
    public boolean equals(Object object) {
        // TODO: Warning - this method won't work in the case the id fields are not set
        if (!(object instanceof FatosBoletos)) {
            return false;
        }
        FatosBoletos other = (FatosBoletos) object;
        if ((this.id == null && other.id != null) || (this.id != null && !this.id.equals(other.id))) {
            return false;
        }
        return true;
    }

    @Override
    public String toString() {
        return ano+"/"+mes;
    }
    
}
