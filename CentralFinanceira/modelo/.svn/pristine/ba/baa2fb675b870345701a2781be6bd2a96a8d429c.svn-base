/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package br.com.jsoft.centralfinanceira.modelo.central;

import com.xpert.audit.NotAudited;
import java.io.Serializable;
import java.math.BigDecimal;
import java.util.List;
import javax.persistence.Entity;
import javax.persistence.FetchType;
import javax.persistence.Id;
import javax.persistence.ManyToOne;
import javax.persistence.OneToMany;
import javax.persistence.OrderBy;
import javax.persistence.Table;
import javax.validation.constraints.Size;
import org.hibernate.validator.constraints.NotBlank;

/**
 *
 * @author jj
 */
@Entity
@Table(schema="dados")
public class ConvenioBoleto implements Serializable {
    
    @Id
    private Long id;
    
    @ManyToOne(fetch = FetchType.LAZY)
    private TipoFloat tipofloat;
    
    @Size(max = 50)
    @NotBlank
    private String nome;
    
    
    private boolean retemcomissao;
    
    private BigDecimal tarifa;
    
    private Integer diasfloat;
    
    private BigDecimal iss;
    
    private boolean ativo;
    
    @NotAudited
    @OneToMany(mappedBy = "convenioboleto")
    private List<FatosBoletos> fatosboletos;

    public TipoFloat getTipofloat() {
        return tipofloat;
    }

    public void setTipofloat(TipoFloat tipofloat) {
        this.tipofloat = tipofloat;
    }

    public String getNome() {
        return nome;
    }

    public void setNome(String nome) {
        this.nome = nome;
    }

    public boolean isRetemcomissao() {
        return retemcomissao;
    }

    public void setRetemcomissao(boolean retemcomissao) {
        this.retemcomissao = retemcomissao;
    }

    public BigDecimal getTarifa() {
        return tarifa;
    }

    public void setTarifa(BigDecimal tarifa) {
        this.tarifa = tarifa;
    }

    public Integer getDiasfloat() {
        return diasfloat;
    }

    public void setDiasfloat(Integer diasfloat) {
        this.diasfloat = diasfloat;
    }

    public BigDecimal getIss() {
        return iss;
    }

    public void setIss(BigDecimal iss) {
        this.iss = iss;
    }

    public boolean isAtivo() {
        return ativo;
    }

    public void setAtivo(boolean ativo) {
        this.ativo = ativo;
    }

    public Long getId() {
        return id;
    }

    public void setId(Long id) {
        this.id = id;
    }

    @Override
    public String toString() {
        return nome;
    }

    @Override
    public int hashCode() {
        int hash = 3;
        hash = 79 * hash + (this.id != null ? this.id.hashCode() : 0);
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
        final ConvenioBoleto other = (ConvenioBoleto) obj;
        if (this.id != other.id && (this.id == null || !this.id.equals(other.id))) {
            return false;
        }
        return true;
    }
    

    
}
