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
 * @author Juniel
 */
@Entity
@Table(schema = "financeira")
public class FatosCreditos implements Serializable{
    
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    @NotNull
    private Integer qtd;
    
    @NotNull
    private Integer periodo;
  
    private BigDecimal arrecadado;

    private BigDecimal unitarioconvenio;

    private BigDecimal unitarioloja;

    @ManyToOne(fetch = FetchType.LAZY)
    private Loja loja;

    @ManyToOne(fetch = FetchType.LAZY)
    private Conveniocredigi conveniocredigi;
    
    public BigDecimal getUnitarioLiquido() {
        if (unitarioconvenio != null && unitarioloja != null) {
            return this.unitarioconvenio.subtract(this.unitarioloja);

        }
        return BigDecimal.ZERO;
    }
    
    public BigDecimal getComissaoConvenio() {
        if (unitarioconvenio != null && arrecadado != null) {
            return this.unitarioconvenio.multiply(this.arrecadado).divide(new BigDecimal (100));

        }
        return BigDecimal.ZERO;
    }
    
    public BigDecimal getComissaoLoja() {
        if (unitarioloja != null && arrecadado != null) {
            return this.unitarioloja.multiply(this.arrecadado).divide(new BigDecimal (100));

        }
        return BigDecimal.ZERO;
    }
    
    public BigDecimal getComissaoLiquida() {
        return getComissaoConvenio().subtract(getComissaoLoja());
    }

    public Long getId() {
        return id;
    }

    public void setId(Long id) {
        this.id = id;
    }

    public Integer getQtd() {
        return qtd;
    }

    public void setQtd(Integer qtd) {
        this.qtd = qtd;
    }

    public Integer getPeriodo() {
        return periodo;
    }

    public void setPeriodo(Integer periodo) {
        this.periodo = periodo;
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

    public Loja getLoja() {
        return loja;
    }

    public void setLoja(Loja loja) {
        this.loja = loja;
    }

    public Conveniocredigi getConveniocredigi() {
        return conveniocredigi;
    }

    public void setConveniocredigi(Conveniocredigi conveniocredigi) {
        this.conveniocredigi = conveniocredigi;
    }
    
    public FatosCreditos() {
    }

    @Override
    public int hashCode() {
        int hash = 3;
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
        final FatosCreditos other = (FatosCreditos) obj;
        if (this.id != other.id && (this.id == null || !this.id.equals(other.id))) {
            return false;
        }
        return true;
    }
    
    
}
