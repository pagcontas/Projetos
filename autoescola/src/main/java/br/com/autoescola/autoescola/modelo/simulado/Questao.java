/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package br.com.autoescola.autoescola.modelo.simulado;

import java.io.Serializable;
import java.util.List;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.OneToMany;
import javax.persistence.OrderBy;
import javax.validation.constraints.NotNull;
import javax.validation.constraints.Size;
import org.hibernate.validator.constraints.NotBlank;

/**
 *
 * @author killerbee
 */
@Entity
public class Questao implements Serializable {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    @NotBlank(message = "A descrição da Questão é Obrigatória!")
    @Size(max = 400)
    private String descricao;

    @NotNull(message = "Tipo da Questão é Obrigatório!")
    private TipoProva tipo;
    
    @Size(max = 400)
    private String caminhoIMG;

    @Size(max = 5, min = 5)
    @OrderBy("letra")
    @OneToMany(mappedBy = "questao")
    private List<Alternativa> alternativas;

    public Questao() {
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

    public TipoProva getTipo() {
        return tipo;
    }

    public void setTipo(TipoProva tipo) {
        this.tipo = tipo;
    }

    public List<Alternativa> getAlternativas() {
        return alternativas;
    }

    public void setAlternativas(List<Alternativa> alternativas) {
        this.alternativas = alternativas;
    }

    public String getCaminhoIMG() {
        return caminhoIMG;
    }

    public void setCaminhoIMG(String caminhoIMG) {
        this.caminhoIMG = caminhoIMG;
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
        final Questao other = (Questao) obj;
        if (this.id != other.id && (this.id == null || !this.id.equals(other.id))) {
            return false;
        }
        return true;
    }

    
}
