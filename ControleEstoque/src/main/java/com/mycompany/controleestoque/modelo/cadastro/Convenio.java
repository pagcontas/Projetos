/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.mycompany.controleestoque.modelo.cadastro;

import com.xpert.audit.NotAudited;
import java.io.Serializable;
import java.util.List;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.OneToMany;
import javax.persistence.OrderBy;
import javax.validation.constraints.Size;

/**
 *
 * @author juniel
 */
@Entity
public class Convenio implements Serializable {
    
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;
    
    @Size(max = 200)
    private String nome;
    
    @NotAudited
    @OrderBy("nome")
    @OneToMany(mappedBy = "fatura")
    private List<Cliente> clienteFatura;
    
    @NotAudited
    @OrderBy("nome")
    @OneToMany(mappedBy = "recebimento")
    private List<Cliente> clienteRecebimento;

    public Convenio() {
    }

    public Long getId() {
        return id;
    }

    public String getNome() {
        return nome;
    }

    public void setId(Long id) {
        this.id = id;
    }

    public void setNome(String nome) {
        this.nome = nome;
    }   
    
    @Override
    public int hashCode() {
        int hash = 7;
        hash = 29 * hash + (this.id != null ? this.id.hashCode() : 0);
        return hash;
    }

    public List<Cliente> getClienteFatura() {
        return clienteFatura;
    }

    public void setClienteFatura(List<Cliente> clienteFatura) {
        this.clienteFatura = clienteFatura;
    }

    public List<Cliente> getClienteRecebimento() {
        return clienteRecebimento;
    }

    public void setClienteRecebimento(List<Cliente> clienteRecebimento) {
        this.clienteRecebimento = clienteRecebimento;
    }    
    
    @Override
    public boolean equals(Object obj) {
        if (obj == null) {
            return false;
        }
        if (getClass() != obj.getClass()) {
            return false;
        }
        final Convenio other = (Convenio) obj;
        if (this.id != other.id && (this.id == null || !this.id.equals(other.id))) {
            return false;
        }
        return true;
    }
    
    
}
