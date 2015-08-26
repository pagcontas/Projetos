/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.mycompany.controleestoque.modelo.faturamento;

import com.mycompany.controleestoque.modelo.cadastro.Loja_Filial;
import com.mycompany.controleestoque.modelo.cadastro.enums.StatusNF;
import java.io.Serializable;
import java.util.Date;
import javax.persistence.Entity;
import javax.persistence.FetchType;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.ManyToOne;
import javax.persistence.Temporal;
import javax.persistence.TemporalType;
import javax.validation.constraints.NotNull;
import org.hibernate.validator.constraints.NotBlank;

/**
 *
 * @author juniel
 */
@Entity
public class NotaFiscal implements Serializable {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;
    
    @NotNull
    @ManyToOne(fetch = FetchType.LAZY)
    private Loja_Filial loja;

    @NotNull
    @ManyToOne(fetch = FetchType.LAZY)
    private Venda venda;

    @NotBlank
    private String numChaveDeAcesso;

    @Temporal(TemporalType.DATE)
    private Date dataEmissao;

    @Temporal(TemporalType.TIME)
    private Date horaEmissao;

    private String protocolo;

    @NotNull
    private Long numeroNota;

    private boolean ativo = true;

    @NotNull
    private StatusNF status = StatusNF.ACONFIRMAR;

    @Override
    public String toString() {
        return numeroNota.toString();
    }

    public Long getId() {
        return id;
    }

    public void setId(Long id) {
        this.id = id;
    }

    public Venda getVenda() {
        return venda;
    }

    public void setVenda(Venda venda) {
        this.venda = venda;
    }

    public String getNumChaveDeAcesso() {
        return numChaveDeAcesso;
    }

    public void setNumChaveDeAcesso(String numChaveDeAcesso) {
        this.numChaveDeAcesso = numChaveDeAcesso;
    }

    public Long getNumeroNota() {
        return numeroNota;
    }

    public void setNumeroNota(Long numeroNota) {
        this.numeroNota = numeroNota;
    }

    public boolean isAtivo() {
        return ativo;
    }

    public void setAtivo(boolean ativo) {
        this.ativo = ativo;
    }

    public StatusNF getStatus() {
        return status;
    }

    public void setStatus(StatusNF status) {
        this.status = status;
    }

    public Date getDataEmissao() {
        return dataEmissao;
    }

    public void setDataEmissao(Date dataEmissao) {
        this.dataEmissao = dataEmissao;
    }

    public Date getHoraEmissao() {
        return horaEmissao;
    }

    public void setHoraEmissao(Date horaEmissao) {
        this.horaEmissao = horaEmissao;
    }

    public String getProtocolo() {
        return protocolo;
    }

    public void setProtocolo(String protocolo) {
        this.protocolo = protocolo;
    }

    public Loja_Filial getLoja() {
        return loja;
    }

    public void setLoja(Loja_Filial loja) {
        this.loja = loja;
    }

    @Override
    public int hashCode() {
        int hash = 5;
        hash = 97 * hash + (this.id != null ? this.id.hashCode() : 0);
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
        final NotaFiscal other = (NotaFiscal) obj;
        if (this.id != other.id && (this.id == null || !this.id.equals(other.id))) {
            return false;
        }
        return true;
    }

}
