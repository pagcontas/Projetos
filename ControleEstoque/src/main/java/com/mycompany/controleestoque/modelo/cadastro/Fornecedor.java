/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.mycompany.controleestoque.modelo.cadastro;

import com.mycompany.controleestoque.modelo.cadastro.enums.TipoEndereco;
import com.mycompany.controleestoque.modelo.cadastro.enums.TipoFornecedor;
import com.mycompany.controleestoque.modelo.faturamento.Pedido;
import com.xpert.audit.NotAudited;
import java.io.Serializable;
import java.util.List;
import javax.persistence.Entity;
import javax.persistence.Enumerated;
import javax.persistence.FetchType;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.ManyToOne;
import javax.persistence.OneToMany;
import javax.persistence.OneToOne;
import javax.persistence.OrderBy;
import javax.validation.constraints.NotNull;
import javax.validation.constraints.Size;
import org.hibernate.validator.constraints.Email;
import org.hibernate.validator.constraints.NotBlank;

/**
 *
 * @author ti05
 *
 *
 */
@Entity
public class Fornecedor implements Serializable {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    @NotNull
    private TipoFornecedor tipo;

    @Size(max = 200)
    @NotBlank
    private String razaoSocial;

    @Size(max = 200)
    private String nomeFantasia;

    @Size(max = 20)
    @NotBlank
    private String cnpj;

    @Size(max = 20)
    private String inscricaoEstatual;

    // Tab Enderecos
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

    @Size(max = 14)
    private String cep;

    @Size(max = 100)
    private String complemento;

    @Enumerated
    private TipoEndereco tipoEndereco;

    @Size(max = 20)
    private String telefone;

    @Size(max = 20)
    private String fax;

    @Size(max = 20)
    private String celula1;

    @Size(max = 20)
    private String celular2;

    @Size(max = 20)
    private String whatsapp;

    @Size(max = 100)
    @Email
    private String email;

    @Size(max = 100)
    private String facebook;

    @Size(max = 100)
    private String contato;

    @Size(max = 100)
    private String cargo;

    @Size(max = 20)
    private String foneContato;

    @Size(max = 100)
    private String contaNoBanco;

    @Size(max = 400)
    private String observacao;

    private boolean ativo = true;
    
    @NotAudited
    @OrderBy("razaoSocial")
    @OneToMany(mappedBy = "fabricante")
    private List<Produto> produtos;
    
    @NotAudited
    @OrderBy("razaoSocial")
    @OneToMany(mappedBy = "fornecedor")
    private List<Pedido> pedido;

    public Fornecedor() {
    }

    @Override
    public String toString() {
        return getRazaoSocial();
    }

    public List<Produto> getProdutos() {
        return produtos;
    }

    public void setProdutos(List<Produto> produtos) {
        this.produtos = produtos;
    }
        
    @Override
    public int hashCode() {
        int hash = 7;
        hash = 13 * hash + (this.id != null ? this.id.hashCode() : 0);
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
        final Fornecedor other = (Fornecedor) obj;
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

    public TipoFornecedor getTipo() {
        return tipo;
    }

    public void setTipo(TipoFornecedor tipo) {
        this.tipo = tipo;
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

    public String getInscricaoEstatual() {
        return inscricaoEstatual;
    }

    public void setInscricaoEstatual(String inscricaoEstatual) {
        this.inscricaoEstatual = inscricaoEstatual;
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

    public TipoEndereco getTipoEndereco() {
        return tipoEndereco;
    }

    public void setTipoEndereco(TipoEndereco tipoEndereco) {
        this.tipoEndereco = tipoEndereco;
    }

    public String getTelefone() {
        return telefone;
    }

    public void setTelefone(String telefone) {
        this.telefone = telefone;
    }

    public String getFax() {
        return fax;
    }

    public void setFax(String fax) {
        this.fax = fax;
    }

    public String getCelula1() {
        return celula1;
    }

    public void setCelula1(String celula1) {
        this.celula1 = celula1;
    }

    public String getCelular2() {
        return celular2;
    }

    public void setCelular2(String celular2) {
        this.celular2 = celular2;
    }

    public String getWhatsapp() {
        return whatsapp;
    }

    public void setWhatsapp(String whatsapp) {
        this.whatsapp = whatsapp;
    }

    public String getEmail() {
        return email;
    }

    public void setEmail(String email) {
        this.email = email;
    }

    public String getFacebook() {
        return facebook;
    }

    public void setFacebook(String facebook) {
        this.facebook = facebook;
    }

    public String getContato() {
        return contato;
    }

    public void setContato(String contato) {
        this.contato = contato;
    }

    public String getCargo() {
        return cargo;
    }

    public void setCargo(String cargo) {
        this.cargo = cargo;
    }

    public String getFoneContato() {
        return foneContato;
    }

    public void setFoneContato(String foneContato) {
        this.foneContato = foneContato;
    }

    public String getContaNoBanco() {
        return contaNoBanco;
    }

    public void setContaNoBanco(String contaNoBanco) {
        this.contaNoBanco = contaNoBanco;
    }

    public String getObservacao() {
        return observacao;
    }

    public void setObservacao(String observacao) {
        this.observacao = observacao;
    }

    public boolean isAtivo() {
        return ativo;
    }

    public void setAtivo(boolean ativo) {
        this.ativo = ativo;
    }

    public List<Pedido> getPedido() {
        return pedido;
    }

    public void setPedido(List<Pedido> pedido) {
        this.pedido = pedido;
    }
    
    
}