/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.mycompany.controleestoque.modelo.cadastro;

import com.mycompany.controleestoque.modelo.cadastro.enums.TipoDeConta;
import com.mycompany.controleestoque.modelo.faturamento.Venda;
import com.xpert.audit.NotAudited;
import java.io.Serializable;
import java.util.List;
import javax.persistence.Entity;
import javax.persistence.Enumerated;
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
 * @author KillerBeeTwo
 */
@Entity
public class ContaBancaria implements Serializable {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    @NotNull
    @ManyToOne(fetch = FetchType.LAZY)
    private Loja_Filial loja;
    
    @NotNull
    @ManyToOne(fetch = FetchType.EAGER)
    private Banco banco;
    
    @NotBlank
    @Size(max = 50)
    private String nomeTitularConta;

    @NotBlank
    @Size(max = 50)
    private String conta;

    @NotBlank
    @Size(max = 50)
    private String agencia;
    
    @NotNull
    @Enumerated
    private TipoDeConta tipo;
    
    @NotAudited
    @OrderBy("id")
    @OneToMany(mappedBy = "conta")
    private List<Venda> venda;

    public Long getId() {
        return id;
    }

    public void setId(Long id) {
        this.id = id;
    }

    public Loja_Filial getLoja() {
        return loja;
    }

    public void setLoja(Loja_Filial loja) {
        this.loja = loja;
    }

    public Banco getBanco() {
        return banco;
    }

    public void setBanco(Banco banco) {
        this.banco = banco;
    }

    public String getNomeTitularConta() {
        return nomeTitularConta;
    }

    public void setNomeTitularConta(String nomeTitularConta) {
        this.nomeTitularConta = nomeTitularConta;
    }

    public String getConta() {
        return conta;
    }

    public void setConta(String conta) {
        this.conta = conta;
    }

    public String getAgencia() {
        return agencia;
    }

    public void setAgencia(String agencia) {
        this.agencia = agencia;
    }

    public List<Venda> getVenda() {
        return venda;
    }

    public void setVenda(List<Venda> venda) {
        this.venda = venda;
    }

    public TipoDeConta getTipo() {
        return tipo;
    }

    public void setTipo(TipoDeConta tipo) {
        this.tipo = tipo;
    }

    @Override
    public int hashCode() {
        int hash = 7;
        hash = 37 * hash + (this.id != null ? this.id.hashCode() : 0);
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
        final ContaBancaria other = (ContaBancaria) obj;
        if (this.id != other.id && (this.id == null || !this.id.equals(other.id))) {
            return false;
        }
        return true;
    }

    @Override
    public String toString() {
        return "Conta: " + conta + ", Ag." + agencia; //To change body of generated methods, choose Tools | Templates.
    }
    
    
}
