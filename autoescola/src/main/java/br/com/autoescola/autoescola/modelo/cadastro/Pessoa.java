/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package br.com.autoescola.autoescola.modelo.cadastro;

import br.com.autoescola.autoescola.modelo.cadastro.enums.Escolaridade;
import br.com.autoescola.autoescola.modelo.cadastro.enums.EstadoCivil;
import br.com.autoescola.autoescola.modelo.cadastro.enums.Sexo;
import java.io.Serializable;
import java.util.Date;
import javax.persistence.DiscriminatorColumn;
import javax.persistence.DiscriminatorType;
import javax.persistence.DiscriminatorValue;
import javax.persistence.Entity;
import javax.persistence.FetchType;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.Inheritance;
import javax.persistence.InheritanceType;
import javax.persistence.ManyToOne;
import javax.persistence.Temporal;
import javax.persistence.TemporalType;
import javax.validation.constraints.NotNull;
import javax.validation.constraints.Size;
import org.hibernate.validator.constraints.Email;
import org.hibernate.validator.constraints.NotBlank;

/**
 *
 * @author killerbee
 */
@Entity
@Inheritance(strategy = InheritanceType.SINGLE_TABLE)
@DiscriminatorColumn(name = "tipo", length = 1, discriminatorType = DiscriminatorType.INTEGER)
@DiscriminatorValue("0")
public class Pessoa implements Serializable {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    @Size(max = 200)
    @NotBlank
    private String nome;

    @NotBlank
    @Size(max = 30)
    private String rg;

    @NotBlank
    @Size(max = 10)
    private String orgaoRg;

    @NotNull
    @Temporal(TemporalType.DATE)
    private Date dataEmissaoRg;

    @ManyToOne(fetch = FetchType.LAZY)
    private Cidade naturalidade;

    @NotBlank
    @Size(max = 200)
    private String endereco;

    @Size(max = 50)
    private String numero;

    @Size(max = 50)
    private String bairro;

    @NotNull
    @ManyToOne(fetch = FetchType.LAZY)
    private Cidade cidade;

    @Size(max = 10)
    private String cep;

    @Size(max = 100)
    private String complemento;

    @Size(max = 14)
    @NotNull
    private String cpf;

    @Size(max = 100)
    @Email
    private String email;

    @Size(max = 100)
    private String facebook;

    @Size(max = 20)
    private String titulo;

    @Size(max = 20)
    private String zona;

    @Size(max = 20)
    private String secao;

    private Escolaridade grauDeEscolaridade;

    @Size(max = 200)
    private String mae;

    @Size(max = 200)
    private String pai;

    @NotNull
    @Temporal(TemporalType.DATE)
    private Date dataNascimento;

    private EstadoCivil estadoCivil;

    private Sexo sexo;

    @Size(max = 20)
    private String residencial;

    @Size(max = 20)
    private String celular;

    @Size(max = 20)
    private String whatsapp;

    private Boolean active = true;

    public Pessoa() {

    }

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

    public String getRg() {
        return rg;
    }

    public void setRg(String rg) {
        this.rg = rg;
    }

    public String getOrgaoRg() {
        return orgaoRg;
    }

    public void setOrgaoRg(String orgaoRg) {
        this.orgaoRg = orgaoRg;
    }

    public Date getDataEmissaoRg() {
        return dataEmissaoRg;
    }

    public void setDataEmissaoRg(Date dataEmissaoRg) {
        this.dataEmissaoRg = dataEmissaoRg;
    }

    public Cidade getNaturalidade() {
        return naturalidade;
    }

    public void setNaturalidade(Cidade naturalidade) {
        this.naturalidade = naturalidade;
    }

    public String getCpf() {
        return cpf;
    }

    public void setCpf(String cpf) {
        this.cpf = cpf;
    }

    public String getEmail() {
        return email;
    }

    public void setEmail(String email) {
        this.email = email;
    }

    public String getTitulo() {
        return titulo;
    }

    public void setTitulo(String titulo) {
        this.titulo = titulo;
    }

    public String getZona() {
        return zona;
    }

    public void setZona(String zona) {
        this.zona = zona;
    }

    public String getSecao() {
        return secao;
    }

    public void setSecao(String secao) {
        this.secao = secao;
    }

    public Escolaridade getGrauDeEscolaridade() {
        return grauDeEscolaridade;
    }

    public void setGrauDeEscolaridade(Escolaridade grauDeEscolaridade) {
        this.grauDeEscolaridade = grauDeEscolaridade;
    }

    public Date getDataNascimento() {
        return dataNascimento;
    }

    public void setDataNascimento(Date dataNascimento) {
        this.dataNascimento = dataNascimento;
    }

    public Boolean getActive() {
        return active;
    }

    public void setActive(Boolean active) {
        this.active = active;
    }

    public String getMae() {
        return mae;
    }

    public void setMae(String mae) {
        this.mae = mae;
    }

    public String getPai() {
        return pai;
    }

    public void setPai(String pai) {
        this.pai = pai;
    }

    public EstadoCivil getEstadoCivil() {
        return estadoCivil;
    }

    public void setEstadoCivil(EstadoCivil estadoCivil) {
        this.estadoCivil = estadoCivil;
    }

    public Sexo getSexo() {
        return sexo;
    }

    public void setSexo(Sexo sexo) {
        this.sexo = sexo;
    }

    public String getFacebook() {
        return facebook;
    }

    public void setFacebook(String facebook) {
        this.facebook = facebook;
    }

    public String getResidencial() {
        return residencial;
    }

    public void setResidencial(String residencial) {
        this.residencial = residencial;
    }

    public String getCelular() {
        return celular;
    }

    public void setCelular(String celular) {
        this.celular = celular;
    }

    public String getWhatsapp() {
        return whatsapp;
    }

    public void setWhatsapp(String whatsapp) {
        this.whatsapp = whatsapp;
    }

    public String getEndereco() {
        return endereco;
    }

    public void setEndereco(String endereco) {
        this.endereco = endereco;
    }

    public String getNumero() {
        return numero;
    }

    public void setNumero(String numero) {
        this.numero = numero;
    }

    public String getBairro() {
        return bairro;
    }

    public void setBairro(String bairro) {
        this.bairro = bairro;
    }

    public Cidade getCidade() {
        return cidade;
    }

    public void setCidade(Cidade cidade) {
        this.cidade = cidade;
    }

    public String getCep() {
        return cep;
    }

    public void setCep(String cep) {
        this.cep = cep;
    }

    public String getComplemento() {
        return complemento;
    }

    public void setComplemento(String complemento) {
        this.complemento = complemento;
    }

    @Override
    public int hashCode() {
        int hash = 5;
        hash = 59 * hash + (this.id != null ? this.id.hashCode() : 0);
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
        final Pessoa other = (Pessoa) obj;
        if (this.id != other.id && (this.id == null || !this.id.equals(other.id))) {
            return false;
        }
        return true;
    }

}
