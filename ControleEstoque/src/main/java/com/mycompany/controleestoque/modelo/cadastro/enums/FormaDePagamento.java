/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.mycompany.controleestoque.modelo.cadastro.enums;

/**
 *
 * @author killerbee
 */
public enum FormaDePagamento {
    AVISTA(0,"Pagamento a Vista"),
    APRAZO(1,"Pagamento a Prazo"),
    OUTROS(2,"Outros");
    
    
    

    private FormaDePagamento(int numero, String descricao) {
        this.numero = numero;
        this.descricao = descricao;
    }
    private String descricao;
    private int numero;

    public String getDescricao() {
        return descricao;
    }

    public int getNumero() {
        return numero;
    }
    
}
