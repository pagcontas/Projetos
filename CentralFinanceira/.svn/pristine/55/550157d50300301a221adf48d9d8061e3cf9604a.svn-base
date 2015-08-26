/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package br.com.jsoft.centralfinanceira.modelo.contrato;

import br.com.jsoft.centralfinanceira.modelo.central.Cidade;
import br.com.jsoft.centralfinanceira.modelo.enums.EstadoCivil;
import java.io.Serializable;
import javax.persistence.Entity;
import javax.persistence.FetchType;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.ManyToOne;
import javax.persistence.Table;
import javax.validation.constraints.NotNull;
import javax.validation.constraints.Size;
import org.hibernate.validator.constraints.NotBlank;

/**
 *
 * @author ti05
 */
@Entity
@Table(schema = "cadastro")
public class PagContas implements Serializable{
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;
    
    @Size(max = 80)
    @NotBlank
    private String razaoSocial;
    
    @Size(max = 50)
    @NotBlank
    private String nomeFantasia;
    
    @Size(max = 50)
    @NotBlank
    private String cnpj;
    
    private String inscricaoEstadual;
    
    @Size(max = 90)
    @NotBlank
    private String endereco;
    
    @Size(max = 50)
    @NotBlank
    private String bairro;
    
    @Size(max = 30)
    @NotBlank
    private String numero;
    
    @Size(max = 20)
    @NotBlank
    private String cep;
    
    @ManyToOne(fetch = FetchType.LAZY)
    @NotNull
    private Cidade cidade;
    
    @Size(max = 90)
    @NotBlank
    private String nomeProc1;
    
    @Size(max = 50)
    @NotBlank
    private String nacionalidadeProc1;
    
    @NotNull
    private EstadoCivil estadoCivilProc1;
    
    @Size(max = 50)
    @NotBlank
    private String profissaoProc1;
    
    @Size(max = 20)
    @NotBlank
    private String rgProc1;
    
    @Size(max = 20)
    @NotBlank
    private String orgaoExpeditorPro1;
    
    @Size(max = 15)
    @NotBlank
    private String cpfProc1;
    
    private String nomeProc2;
    
    private String nacionalidadeProc2;
    
    private EstadoCivil estadoCivilProc2;
    
    private String profissaoProc2;
    
    private String rgProc2;
    
    private String orgaoExpeditorPro2;
    
    private String cpfProc2;   

    public PagContas() {
    }

    public Long getId() {
        return id;
    }

    public void setId(Long id) {
        this.id = id;
    }

    public String getRazaoSocial() {
        return razaoSocial;
    }

    public void setRazaoSocial(String razaoSocial) {
        this.razaoSocial = razaoSocial;
    }

    public String getNomeFantasia() {
        return nomeFantasia;
    }

    public void setNomeFantasia(String nomeFantasia) {
        this.nomeFantasia = nomeFantasia;
    }

    public String getCnpj() {
        return cnpj;
    }

    public void setCnpj(String cnpj) {
        this.cnpj = cnpj;
    }

    public String getInscricaoEstadual() {
        return inscricaoEstadual;
    }

    public void setInscricaoEstadual(String inscricaoEstadual) {
        this.inscricaoEstadual = inscricaoEstadual;
    }

    public String getEndereco() {
        return endereco;
    }

    public void setEndereco(String endereco) {
        this.endereco = endereco;
    }

    public String getBairro() {
        return bairro;
    }

    public void setBairro(String bairro) {
        this.bairro = bairro;
    }

    public String getNumero() {
        return numero;
    }

    public void setNumero(String numero) {
        this.numero = numero;
    }

    public String getCep() {
        return cep;
    }

    public void setCep(String cep) {
        this.cep = cep;
    }

    public Cidade getCidade() {
        return cidade;
    }

    public void setCidade(Cidade cidade) {
        this.cidade = cidade;
    }

    public String getNomeProc1() {
        return nomeProc1;
    }

    public void setNomeProc1(String nomeProc1) {
        this.nomeProc1 = nomeProc1;
    }

    public String getNacionalidadeProc1() {
        return nacionalidadeProc1;
    }

    public void setNacionalidadeProc1(String nacionalidadeProc1) {
        this.nacionalidadeProc1 = nacionalidadeProc1;
    }

    public EstadoCivil getEstadoCivilProc1() {
        return estadoCivilProc1;
    }

    public void setEstadoCivilProc1(EstadoCivil estadoCivilProc1) {
        this.estadoCivilProc1 = estadoCivilProc1;
    }

    public String getProfissaoProc1() {
        return profissaoProc1;
    }

    public void setProfissaoProc1(String profissaoProc1) {
        this.profissaoProc1 = profissaoProc1;
    }

    public String getRgProc1() {
        return rgProc1;
    }

    public void setRgProc1(String rgProc1) {
        this.rgProc1 = rgProc1;
    }

    public String getOrgaoExpeditorPro1() {
        return orgaoExpeditorPro1;
    }

    public void setOrgaoExpeditorPro1(String orgaoExpeditorPro1) {
        this.orgaoExpeditorPro1 = orgaoExpeditorPro1;
    }

    public String getCpfProc1() {
        return cpfProc1;
    }

    public void setCpfProc1(String cpfProc1) {
        this.cpfProc1 = cpfProc1;
    }

    public String getNomeProc2() {
        return nomeProc2;
    }

    public void setNomeProc2(String nomeProc2) {
        this.nomeProc2 = nomeProc2;
    }

    public String getNacionalidadeProc2() {
        return nacionalidadeProc2;
    }

    public void setNacionalidadeProc2(String nacionalidadeProc2) {
        this.nacionalidadeProc2 = nacionalidadeProc2;
    }

    public EstadoCivil getEstadoCivilProc2() {
        return estadoCivilProc2;
    }

    public void setEstadoCivilProc2(EstadoCivil estadoCivilProc2) {
        this.estadoCivilProc2 = estadoCivilProc2;
    }

    public String getProfissaoProc2() {
        return profissaoProc2;
    }

    public void setProfissaoProc2(String profissaoProc2) {
        this.profissaoProc2 = profissaoProc2;
    }

    public String getRgProc2() {
        return rgProc2;
    }

    public void setRgProc2(String rgProc2) {
        this.rgProc2 = rgProc2;
    }

    public String getOrgaoExpeditorPro2() {
        return orgaoExpeditorPro2;
    }

    public void setOrgaoExpeditorPro2(String orgaoExpeditorPro2) {
        this.orgaoExpeditorPro2 = orgaoExpeditorPro2;
    }

    public String getCpfProc2() {
        return cpfProc2;
    }

    public void setCpfProc2(String cpfProc2) {
        this.cpfProc2 = cpfProc2;
    }

    @Override
    public int hashCode() {
        int hash = 7;
        hash = 89 * hash + (this.id != null ? this.id.hashCode() : 0);
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
        final PagContas other = (PagContas) obj;
        if (this.id != other.id && (this.id == null || !this.id.equals(other.id))) {
            return false;
        }
        return true;
    }
    
    
}
