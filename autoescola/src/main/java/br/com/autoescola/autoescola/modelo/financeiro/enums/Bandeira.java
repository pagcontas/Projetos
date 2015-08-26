/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package br.com.autoescola.autoescola.modelo.financeiro.enums;

/**
 *
 * @author killerbee
 */
public enum Bandeira {

    AVISTA(0, "A Vista"),
    CARNE(1, "Carnê");

    private final String descricao;
    private final int numero;

    Bandeira(int numero, String descricao) {
        this.descricao = descricao;
        this.numero = numero;
    }

    public int getNumero() {
        return numero;
    }

    public String getDescricao() {
        return descricao;
    }

}
