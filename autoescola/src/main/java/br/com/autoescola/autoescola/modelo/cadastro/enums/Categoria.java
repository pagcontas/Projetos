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
public enum Categoria {

    A("Categoria A"),
    AB("Categoria AB"),
    ACC("Categoria ACC"),
    B("Categoria B"),
    C("Categoria C"),
    D("Categoria D"),
    E("Categoria E");

    private Categoria(String descricao) {
        this.descricao = descricao;
    }
    private String descricao;

    public String getDescricao() {
        return descricao;
    }

}
