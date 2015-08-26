/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package br.com.jsoft.centralfinanceira.modelo.central;

import br.com.jsoft.centralfinanceira.modelo.contrato.Endereco;
import br.com.jsoft.centralfinanceira.modelo.contrato.Contrato;
import br.com.jsoft.centralfinanceira.modelo.contrato.PagContas;
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
import javax.persistence.Table;
import javax.validation.constraints.Size;
import org.hibernate.validator.constraints.NotBlank;

/**
 *
 * @author juniel
 */
@Entity
@Table(schema = "cadastro")
public class Cidade implements Serializable {

    @Id
    @SequenceGenerator(name = "Cidade", sequenceName = "seq_cidade")
    @GeneratedValue(generator = "Cidade")
    private Long id;

    @Size(max = 50)
    @NotBlank
    private String nome;

    private Integer codigoibge;

    @ManyToOne(fetch = FetchType.LAZY)
    private Uf uf;

    @NotAudited
    @OrderBy("nome")
    @OneToMany(mappedBy = "cidade")
    private List<Loja> loja;  
    
    @NotAudited
    @OrderBy("nome")
    @OneToMany(mappedBy = "cidade")
    private List<PagContas> pagcontas;
    
    @NotAudited
    @OrderBy("endereco")
    @OneToMany(mappedBy = "cidade")
    private List<Endereco> enderecos;

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

    public Integer getCodigoibge() {
        return codigoibge;
    }

    public void setCodigoibge(Integer codigoibge) {
        this.codigoibge = codigoibge;
    }

    public Uf getUf() {
        return uf;
    }

    public void setUf(Uf uf) {
        this.uf = uf;
    }

    public List<Loja> getLoja() {
        return loja;
    }

    public void setLoja(List<Loja> loja) {
        this.loja = loja;
    }

    public List<PagContas> getPagcontas() {
        return pagcontas;
    }

    public void setPagcontas(List<PagContas> pagcontas) {
        this.pagcontas = pagcontas;
    }

    public List<Endereco> getEnderecos() {
        return enderecos;
    }

    public void setEnderecos(List<Endereco> enderecos) {
        this.enderecos = enderecos;
    }
   
    @Override
    public String toString() {
        return nome;
    }

    @Override
    public int hashCode() {
        int hash = 7;
        hash = 73 * hash + (this.id != null ? this.id.hashCode() : 0);
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
