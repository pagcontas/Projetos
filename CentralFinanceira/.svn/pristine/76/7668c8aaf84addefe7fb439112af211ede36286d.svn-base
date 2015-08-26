/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package br.com.jsoft.centralfinanceira.bo.contrato;

import java.io.Serializable;
import java.util.Date;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.Table;
import javax.persistence.Temporal;
import javax.persistence.TemporalType;
import javax.validation.constraints.Size;
import org.hibernate.validator.constraints.Email;

/**
 *
 * @author KillerBeeTwo
 */
@Entity
@Table(schema = "contrato")
public class Conjuge implements Serializable {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;
    
    @Size(max = 60)
    private String nome;

    @Size(max = 60)
    private String nomeGuerra;

    @Size(max = 15)
    private String cpf;

    @Size(max = 20)
    private String rg;

    @Size(max = 15)
    private String celular;

    @Temporal(TemporalType.DATE)
    private Date nascimento;

    @Size(max = 60)
    private String nomePai;

    @Size(max = 60)
    private String nomeMae;

    @Size(max = 15)
    private String telefoneMae;

    @Size(max = 15)
    private String telefonePai;

    @Temporal(TemporalType.DATE)
    private Date nascimentoPai;

    @Temporal(TemporalType.DATE)
    private Date nascimentoMae;

    @Size(max = 150)
    @Email
    private String emailPai;

    @Size(max = 150)
    @Email
    private String emailMae;

    private Boolean participaNegocioMae = null;

    private Boolean participaNegocioPai = null;

    public Long getId() {
        return id;
    }

    public void setId(Long id) {
        this.id = id;
    }

    public String getNome() {
        return nome;
    }

    public void setNome(String nome) {
        this.nome = nome;
    }

    public String getNomeGuerra() {
        return nomeGuerra;
    }

    public void setNomeGuerra(String nomeGuerra) {
        this.nomeGuerra = nomeGuerra;
    }

    public String getCpf() {
        return cpf;
    }

    public void setCpf(String cpf) {
        this.cpf = cpf;
    }

    public String getRg() {
        return rg;
    }

    public void setRg(String rg) {
        this.rg = rg;
    }

    public String getCelular() {
        return celular;
    }

    public void setCelular(String celular) {
        this.celular = celular;
    }

    public Date getNascimento() {
        return nascimento;
    }

    public void setNascimento(Date nascimento) {
        this.nascimento = nascimento;
    }

    public String getNomePai() {
        return nomePai;
    }

    public void setNomePai(String nomePai) {
        this.nomePai = nomePai;
    }

    public String getNomeMae() {
        return nomeMae;
    }

    public void setNomeMae(String nomeMae) {
        this.nomeMae = nomeMae;
    }

    public String getTelefoneMae() {
        return telefoneMae;
    }

    public void setTelefoneMae(String telefoneMae) {
        this.telefoneMae = telefoneMae;
    }

    public String getTelefonePai() {
        return telefonePai;
    }

    public void setTelefonePai(String telefonePai) {
        this.telefonePai = telefonePai;
    }

    public Date getNascimentoPai() {
        return nascimentoPai;
    }

    public void setNascimentoPai(Date nascimentoPai) {
        this.nascimentoPai = nascimentoPai;
    }

    public Date getNascimentoMae() {
        return nascimentoMae;
    }

    public void setNascimentoMae(Date nascimentoMae) {
        this.nascimentoMae = nascimentoMae;
    }

    public String getEmailPai() {
        return emailPai;
    }

    public void setEmailPai(String emailPai) {
        this.emailPai = emailPai;
    }

    public String getEmailMae() {
        return emailMae;
    }

    public void setEmailMae(String emailMae) {
        this.emailMae = emailMae;
    }

    public Boolean getParticipaNegocioMae() {
        return participaNegocioMae;
    }

    public void setParticipaNegocioMae(Boolean participaNegocioMae) {
        this.participaNegocioMae = participaNegocioMae;
    }

    public Boolean getParticipaNegocioPai() {
        return participaNegocioPai;
    }

    public void setParticipaNegocioPai(Boolean participaNegocioPai) {
        this.participaNegocioPai = participaNegocioPai;
    }

    @Override
    public int hashCode() {
        int hash = 7;
        hash = 37 * hash + (this.id != null ? this.id.hashCode() : 0);
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
        final Conjuge other = (Conjuge) obj;
        if (this.id != other.id && (this.id == null || !this.id.equals(other.id))) {
            return false;
        }
        return true;
    }
    
    
}
