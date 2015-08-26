/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package br.com.jsoft.centralfinanceira.vo;

import java.math.BigDecimal;

/**
 *
 * @author Juniel
 */
public class ComissaoLojaVO {

    private Integer periodo;
    private Long id;
    private String nome;
    private Integer qtd;
    private BigDecimal arrecadado;
    private BigDecimal unitarioloja;
    private BigDecimal comissaoconvenio;

    public Integer getPeriodo() {
        return periodo;
    }

    public void setPeriodo(Integer periodo) {
        this.periodo = periodo;
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

    public Integer getQtd() {
        return qtd;
    }

    public void setQtd(Integer qtd) {
        this.qtd = qtd;
    }

    public BigDecimal getArrecadado() {
        if (arrecadado != null) {
            return arrecadado;
        }
        return BigDecimal.ZERO;

    }

    public void setArrecadado(BigDecimal arrecadado) {
        this.arrecadado = arrecadado;
    }

    public BigDecimal getUnitarioloja() {
        if (unitarioloja != null) {
            return unitarioloja;
        }
        return BigDecimal.ZERO;

    }

    public void setUnitarioloja(BigDecimal unitarioloja) {
        this.unitarioloja = unitarioloja;
    }

    public BigDecimal getComissaoconvenio() {
        if (comissaoconvenio != null) {
            return comissaoconvenio;
        }
        return BigDecimal.ZERO;

    }

    public void setComissaoconvenio(BigDecimal comissaoconvenio) {
        this.comissaoconvenio = comissaoconvenio;
    }

    public BigDecimal getComissaoliquida() {
        return getComissaoconvenio().subtract(getComissaoloja());
    }

    public BigDecimal getComissaoloja() {
        if (unitarioloja != null && qtd != null) {
            return this.unitarioloja.multiply(new BigDecimal(this.qtd));

        }
        return BigDecimal.ZERO;
    }

}
