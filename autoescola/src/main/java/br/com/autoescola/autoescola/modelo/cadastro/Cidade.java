/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package br.com.autoescola.autoescola.modelo.cadastro;

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
    @Size(max = 200)
    private String nome;
    
    @ManyToOne(fetch = FetchType.EAGER)
    private Estado estado;
    
    @NotAudited
    @OrderBy("nome")
    @OneToMany(mappedBy = "naturalidade")
    private List<Pessoa> pessoa;
    
    @NotAudited
    @OrderBy("nome")
    @OneToMany(mappedBy = "cidade")
    private List<Pessoa> pessoa1;

    public List<Pessoa> getPessoa1() {
        return pessoa1;
    }

    public void setPessoa1(List<Pessoa> pessoa1) {
        this.pessoa1 = pessoa1;
    }
      
    public List<Pessoa> getPessoa() {
        return pessoa;
    }

    public void setPessoa(List<Pessoa> pessoa) {
        this.pessoa = pessoa;
    }

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

    public Estado getEstado() {
        return estado;
    }

    public void setEstado(Estado estado) {
        this.estado = estado;
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
