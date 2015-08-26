/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package br.com.autoescola.autoescola.modelo.simulado;

/**
 *
 * @author killerbee
 */
public enum LetraAlternativa {
    A("A"),
    B("B"),
    C("C"),
    D("D"),
    E("E");

    private LetraAlternativa(String descricao) {
        this.descricao = descricao;
    }
    private String descricao;

    public String getDescricao() {
        return descricao;
    }
}
