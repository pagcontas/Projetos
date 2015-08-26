/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package br.com.autoescola.autoescola.modelo.simulado;

import com.xpert.audit.NotAudited;
import java.io.Serializable;
import javax.persistence.Entity;
import javax.persistence.FetchType;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.ManyToOne;
import javax.validation.constraints.NotNull;
import javax.validation.constraints.Size;
import org.hibernate.validator.constraints.NotBlank;

/**
 *
 * @author killerbee
 */
@Entity
public class Alternativa implements Serializable {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    @NotNull(message = "A letra da Alternativa é Obrigatória!")
    private LetraAlternativa letra;

    @NotBlank(message = "A descrição da Alternativa é Obrigatória!")
    @Size(max = 400)
    private String descricao;

    @Size(max = 400)
    private String caminhoIMG;

    private boolean correta = false;
    
    @NotAudited
    @ManyToOne(fetch = FetchType.EAGER)
    private Questao questao;

    public Long getId() {
        return id;
    }

    public void setId(Long id) {
        this.id = id;
    }

    public LetraAlternativa getLetra() {
        return letra;
    }

    public void setLetra(LetraAlternativa letra) {
        this.letra = letra;
    }

    public String getDescricao() {
        return descricao;
    }

    public void setDescricao(String descricao) {
        this.descricao = descricao;
    }

    public String getCaminhoIMG() {
        return caminhoIMG;
    }

    public void setCaminhoIMG(String caminhoIMG) {
        this.caminhoIMG = caminhoIMG;
    }

    public boolean isCorreta() {
        return correta;
    }

    public void setCorreta(boolean correta) {
        this.correta = correta;
    }

    public Questao getQuestao() {
        return questao;
    }

    public void setQuestao(Questao questao) {
        this.questao = questao;
    }

    public Alternativa() {
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
        final Alternativa other = (Alternativa) obj;
        if (this.id != other.id && (this.id == null || !this.id.equals(other.id))) {
            return false;
        }
        return true;
    }

}
