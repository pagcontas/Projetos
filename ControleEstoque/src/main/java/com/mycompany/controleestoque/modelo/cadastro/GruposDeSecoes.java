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
import javax.persistence.FetchType;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.ManyToOne;
import javax.persistence.OneToMany;
import javax.persistence.OrderBy;
import javax.validation.constraints.NotNull;
import javax.validation.constraints.Size;
import org.hibernate.validator.constraints.NotBlank;

/**
 *
 * @author juniel
 */
@Entity
public class GruposDeSecoes implements Serializable {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;
    
    @NotNull
    @ManyToOne(fetch = FetchType.EAGER)
    private SecoesProduto secao;
    
    @NotBlank
    @Size(max = 50)
    private String codigo;
    
    @NotBlank
    @Size(max = 50)
    private String descricao;
    
    @NotAudited
    @OrderBy("descricao")
    @OneToMany(mappedBy = "grupo")
    private List<Produto> produtos2;

    public GruposDeSecoes() {
    }

    @Override
    public String toString() {
        return getDescricao();
    }       

    public Long getId() {
        return id;
    }

    public void setId(Long id) {
        this.id = id;
    }

    public SecoesProduto getSecao() {
        return secao;
    }

    public void setSecao(SecoesProduto secao) {
        this.secao = secao;
    }

    public String getCodigo() {
        return codigo;
    }

    public void setCodigo(String codigo) {
        this.codigo = codigo;
    }

    public String getDescricao() {
        return descricao;
    }

    public void setDescricao(String descricao) {
        this.descricao = descricao;
    }

    public List<Produto> getProdutos2() {
        return produtos2;
    }

    public void setProdutos2(List<Produto> produtos2) {
        this.produtos2 = produtos2;
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
        final GruposDeSecoes other = (GruposDeSecoes) obj;
        if (this.id != other.id && (this.id == null || !this.id.equals(other.id))) {
            return false;
        }
        return true;
    }
    
    
}
