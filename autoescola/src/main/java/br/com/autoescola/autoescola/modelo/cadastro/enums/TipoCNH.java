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
public enum TipoCNH {
    PRIMEIRA(0,"1ª CNH"),
    RENOVACAO(1,"Renovação CNH"),
    INCLUSAOCATEGORIA(2,"Inclusão da Categoria"),
    MUDANCA(3,"Mudança");    

    private TipoCNH(int numero, String descricao) {
        this.numero = numero;
        this.descricao = descricao;
    }
    private String descricao;   
    
    private int numero;
    
    public int getNumero() {
        return numero;
    }

    public String getDescricao() {
        return descricao;
    }
}
