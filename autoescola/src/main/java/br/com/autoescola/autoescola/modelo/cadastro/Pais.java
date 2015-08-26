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
import javax.persistence.GeneratedValue;
import javax.persistence.Id;
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
public class Pais implements Serializable{
    @Id
    @SequenceGenerator(name = "Pais", allocationSize = 1, sequenceName = "seq_pais")
    @GeneratedValue(generator = "Pais")
    private Long id;
    
    @NotBlank
    @Size(max = 200)
    private String nome;
    
    @NotBlank
    @Size(min = 4, max = 4)
    private String codigo;
    
    @NotBlank
    @Size(min = 3, max = 3)
    private String sigla;
    
    @NotAudited
    @OrderBy("nome")
    @OneToMany(mappedBy = "pais")
    private List<Estado> estado;

    @Override
    public int hashCode() {
        int hash = 7;
        hash = 47 * hash + (this.id != null ? this.id.hashCode() : 0);
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
        final Pais other = (Pais) obj;
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

    public String getSigla() {
        return sigla;
    }

    public void setSigla(String sigla) {
        this.sigla = sigla;
    }

    public List<Estado> getEstado() {
        return estado;
    }

    public void setEstado(List<Estado> estado) {
        this.estado = estado;
    }

    public Pais() {
    }
    
    
}
