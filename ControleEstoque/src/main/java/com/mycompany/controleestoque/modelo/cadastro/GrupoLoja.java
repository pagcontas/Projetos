/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.mycompany.controleestoque.modelo.cadastro;

import com.mycompany.controleestoque.modelo.faturamento.Venda;
import com.xpert.audit.NotAudited;
import java.io.Serializable;
import java.math.BigDecimal;
import java.util.List;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.OneToMany;
import javax.persistence.OrderBy;
import javax.validation.constraints.Size;
import org.hibernate.validator.constraints.NotBlank;

/**
 *
 * @author juniel
 */
@Entity
public class GrupoLoja implements Serializable {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    @NotBlank
    @Size(max = 200)
    private String descricao;

    private BigDecimal preco1;

    private BigDecimal preco2;

    private BigDecimal preco3;

    @NotAudited
    @OrderBy("descricao")
    @OneToMany(mappedBy = "grupoDeLojas")
    private List<Produto> produtos2;
    
    @NotAudited
    @OrderBy("descricao")
    @OneToMany(mappedBy = "grupoLoja")
    private List<Venda> venda;
    
    public GrupoLoja() {
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

    public String getDescricao() {
        return descricao;
    }

    public void setDescricao(String descricao) {
        this.descricao = descricao;
    }

    public BigDecimal getPreco1() {
        return preco1;
    }

    public void setPreco1(BigDecimal preco1) {
        this.preco1 = preco1;
    }

    public BigDecimal getPreco2() {
        return preco2;
    }

    public void setPreco2(BigDecimal preco2) {
        this.preco2 = preco2;
    }

    public BigDecimal getPreco3() {
        return preco3;
    }

    public void setPreco3(BigDecimal preco3) {
        this.preco3 = preco3;
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
        final GrupoLoja other = (GrupoLoja) obj;
        if (this.id != other.id && (this.id == null || !this.id.equals(other.id))) {
            return false;
        }
        return true;
    }

    public List<Venda> getVenda() {
        return venda;
    }

    public void setVenda(List<Venda> venda) {
        this.venda = venda;
    }
        
}
