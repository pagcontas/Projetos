/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.mycompany.controleestoque.modelo.cadastro;

import com.mycompany.controleestoque.mb.padrao.FindAllBean;
import com.xpert.audit.NotAudited;
import java.io.Serializable;
import java.util.List;
import javax.persistence.Entity;
import javax.persistence.FetchType;
import javax.persistence.GeneratedValue;
import javax.persistence.Id;
import javax.persistence.ManyToOne;
import javax.persistence.OneToMany;
import javax.persistence.OrderBy;
import javax.persistence.SequenceGenerator;
import javax.validation.constraints.Size;
import org.hibernate.validator.constraints.NotBlank;

/**
 *
 * @author killerbee
 */
@Entity
public class Cidade implements Serializable {

    @Id
    @SequenceGenerator(name = "Cidade", allocationSize = 1, sequenceName = "seq_cidade")
    @GeneratedValue(generator = "Cidade")
    private Long id;
    
    @NotBlank
    @Size(min = 7, max = 7)
    private String codigo;

    @NotBlank
    @Size(max = 200)
    private String nome;

    @ManyToOne(fetch = FetchType.LAZY)
    private Estado estado;

    @NotAudited
    @OrderBy("nome")
    @OneToMany(mappedBy = "cidadeEndereco")
    private List<Cliente> clienteEndereco1;

    @NotAudited
    @OrderBy("nome")
    @OneToMany(mappedBy = "cidEndEmpresaTrabalho")
    private List<Cliente> clienteEnderecoTrab;

    @NotAudited
    @OrderBy("nome")
    @OneToMany(mappedBy = "cidadeEndereco")
    private List<Loja_Filial> clienteEndereco2;

    @NotAudited
    @OrderBy("nome")
    @OneToMany(mappedBy = "cidade")
    private List<Banco> banco;

    @NotAudited
    @OrderBy("nome")
    @OneToMany(mappedBy = "cidade")
    private List<Fornecedor> fornecedor;

    public Cidade() {
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

    public String getCodigo() {
        return codigo;
    }

    public void setCodigo(String codigo) {
        this.codigo = codigo;
    }

    public Estado getEstado() {
        return estado;
    }

    public void setEstado(Estado estado) {
        this.estado = estado;
    }

    public List<Cliente> getClienteEndereco1() {
        return clienteEndereco1;
    }

    public void setClienteEndereco1(List<Cliente> clienteEndereco1) {
        this.clienteEndereco1 = clienteEndereco1;
    }

    public List<Loja_Filial> getClienteEndereco2() {
        return clienteEndereco2;
    }

    public void setClienteEndereco2(List<Loja_Filial> clienteEndereco2) {
        this.clienteEndereco2 = clienteEndereco2;
    }

    public List<Cliente> getClienteEnderecoTrab() {
        return clienteEnderecoTrab;
    }

    public void setClienteEnderecoTrab(List<Cliente> clienteEnderecoTrab) {
        this.clienteEnderecoTrab = clienteEnderecoTrab;
    }

    public List<Fornecedor> getFornecedor() {
        return fornecedor;
    }

    public void setFornecedor(List<Fornecedor> fornecedor) {
        this.fornecedor = fornecedor;
    }

    public List<Banco> getBanco() {
        return banco;
    }

    public void setBanco(List<Banco> banco) {
        this.banco = banco;
    }

    @Override
    public int hashCode() {
        int hash = 7;
        hash = 11 * hash + (this.id != null ? this.id.hashCode() : 0);
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
        final Cidade other = (Cidade) obj;
        if (this.id != other.id && (this.id == null || !this.id.equals(other.id))) {
            return false;
        }
        return true;
    }

}
