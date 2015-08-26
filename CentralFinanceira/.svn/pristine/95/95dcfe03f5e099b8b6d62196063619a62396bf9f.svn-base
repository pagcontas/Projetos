/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package br.com.jsoft.centralfinanceira.modelo.contrato;

import br.com.jsoft.centralfinanceira.modelo.contrato.Contrato;
import java.io.Serializable;
import java.util.Date;
import javax.persistence.Entity;
import javax.persistence.FetchType;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.ManyToOne;
import javax.persistence.Table;
import javax.persistence.Temporal;
import javax.persistence.TemporalType;
import javax.validation.constraints.NotNull;
import javax.validation.constraints.Size;
import org.hibernate.validator.constraints.Email;
import org.hibernate.validator.constraints.NotBlank;

/**
 *
 * @author Juniel
 */
@Entity
@Table(schema = "contrato")
public class Filho implements Serializable {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    @Size(max = 50)
    @NotBlank
    private String nome;

    @Size(max = 15)
    @NotBlank
    private String telefone;

    @Temporal(TemporalType.DATE)
    private Date nascimento;

    
    private Boolean participaNegocio = null;

    @Size(max = 150)
    @Email
    private String email;

    @ManyToOne(fetch = FetchType.EAGER)
    private Contrato contrato1;

    @ManyToOne(fetch = FetchType.EAGER)
    private Contrato contrato2;

    public Contrato getContrato1() {
        return contrato1;
    }

    public void setContrato1(Contrato contrato1) {
        this.contrato1 = contrato1;
    }

    public Contrato getContrato2() {
        return contrato2;
    }

    public void setContrato2(Contrato contrato2) {
        this.contrato2 = contrato2;
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

    public String getTelefone() {
        return telefone;
    }

    public void setTelefone(String telefone) {
        this.telefone = telefone;
    }

    public Date getNascimento() {
        return nascimento;
    }

    public void setNascimento(Date nascimento) {
        this.nascimento = nascimento;
    }

    public Boolean getParticipaNegocio() {
        return participaNegocio;
    }

    public void setParticipaNegocio(Boolean participaNegocio) {
        this.participaNegocio = participaNegocio;
    }

    public String getEmail() {
        return email;
    }

    public void setEmail(String email) {
        this.email = email;
    }

    @Override
    public int hashCode() {
        int hash = 3;
        hash = 19 * hash + (this.id != null ? this.id.hashCode() : 0);
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
        final Filho other = (Filho) obj;
        if (this.id != null) {
            if (this.id != other.id && (this.id == null || !this.id.equals(other.id))) {
                return false;
            }
        } else {
            if ((this.nome == null) ? (other.nome != null) : !this.nome.equals(other.nome)) {
                return false;
            }
            if ((this.telefone == null) ? (other.telefone != null) : !this.telefone.equals(other.telefone)) {
                return false;
            }
        }
        return true;
    }

}
