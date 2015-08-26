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
import javax.persistence.Table;
import javax.validation.constraints.NotNull;

/**
 *
 * @author ti05
 */
@Entity
@Table(schema = "financeira")
public class Fatosbb implements Serializable {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    @NotNull
    private Integer periodo;

    @ManyToOne(fetch = FetchType.LAZY)
    private Loja loja;

    @ManyToOne(fetch = FetchType.LAZY)
    private Conveniobb conveniobb;

    @NotNull
    private Integer qtd;

    private BigDecimal arrecadado;

    private BigDecimal unitarioconvenio;

    private BigDecimal unitarioloja;
    
    private BigDecimal comissao_sn_ph;

    public BigDecimal getUnitarioLiquido() {
        if (unitarioconvenio != null && unitarioloja != null) {
            return this.unitarioconvenio.subtract(this.unitarioloja);

        }
        return BigDecimal.ZERO;
    }

    public BigDecimal getComissaoConvenio() {
        if (unitarioconvenio != null && qtd != null) {
            return this.unitarioconvenio.multiply(new BigDecimal(this.qtd));

        }
        return BigDecimal.ZERO;
    }

    public BigDecimal getComissaoLoja() {
        if (unitarioloja != null && qtd != null) {
            return this.unitarioloja.multiply(new BigDecimal(this.qtd));

        }
        return BigDecimal.ZERO;
    }

    public BigDecimal getComissaoLiquida() {
        return getComissaoConvenio().subtract(getComissaoLoja());
    }

    public Fatosbb() {
    }

    @Override
    public int hashCode() {
        int hash = 7;
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
        final Fatosbb other = (Fatosbb) obj;
        if (this.id != other.id && (this.id == null || !this.id.equals(other.id))) {
            return false;
        }
        return true;
    }

    public Long getId() {
        return id;
    }

    public void setId(Long id) {
        this.id = id;
    }

    public Integer getPeriodo() {
        return periodo;
    }

    public void setPeriodo(Integer periodo) {
        this.periodo = periodo;
    }

    public Loja getLoja() {
        return loja;
    }

    public void setLoja(Loja loja) {
        this.loja = loja;
    }

    public Conveniobb getConveniobb() {
        return conveniobb;
    }

    public void setConveniobb(Conveniobb conveniobb) {
        this.conveniobb = conveniobb;
    }
    
    public Integer getQtd() {
        return qtd;
    }

    public void setQtd(Integer qtd) {
        this.qtd = qtd;
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

    public BigDecimal getUnitarioloja() {
        return unitarioloja;
    }

    public void setUnitarioloja(BigDecimal unitarioloja) {
        this.unitarioloja = unitarioloja;
    }

    public BigDecimal getComissao_sn_ph() {
        return comissao_sn_ph;
    }

    public void setComissao_sn_ph(BigDecimal comissao_sn_ph) {
        this.comissao_sn_ph = comissao_sn_ph;
    }
    
    
}
