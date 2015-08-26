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
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.ManyToOne;
import javax.persistence.OneToMany;
import javax.persistence.Table;
import javax.validation.constraints.Size;
import org.hibernate.validator.constraints.NotBlank;

/**
 *
 * @author Juniel
 */
@Entity
@Table(schema = "cadastro")
public class ConvenioSite implements Serializable {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    @ManyToOne(fetch = FetchType.LAZY)
    private TipoFloat tipofloat;

    @Size(max = 50)
    @NotBlank
    private String nome;

    private Boolean retemcomissao;

    private BigDecimal tarifa;

    private Integer diasfloat;

    private BigDecimal iss;

    private boolean ativo;

    @NotAudited
    @OneToMany(mappedBy = "conveniosite")
    private List<FatosBoletoSite> fatosboletoSite;

    public List<FatosBoletoSite> getFatosboletoSite() {
        return fatosboletoSite;
    }

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

    public Boolean getRetemcomissao() {
        return retemcomissao;
    }

    public void setRetemcomissao(Boolean retemcomissao) {
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
        return id + " - " + nome;
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
        final ConvenioSite other = (ConvenioSite) obj;
        if (this.id != other.id && (this.id == null || !this.id.equals(other.id))) {
            return false;
        }
        return true;
    }

}
