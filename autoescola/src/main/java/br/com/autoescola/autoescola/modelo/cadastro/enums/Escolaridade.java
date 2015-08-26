/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package br.com.autoescola.autoescola.modelo.cadastro.enums;

/**
 *
 * @author killerbee
 */
public enum Escolaridade {
    PRIMEIROGRAU("1º Grau"),
    SEGUNDOGRAU("2º Grau"),
    TERCEIROGRAU("3º Grau");

    private Escolaridade(String descricao) {
        this.descricao = descricao;
    }
    private String descricao;

    public String getDescricao() {
        return descricao;
    }
}
