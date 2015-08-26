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
public enum TipoCliente {
    INTERNO(1,"Interno"),
    EXTERNO(2,"Externo");
    

    private TipoCliente(int num, String descricao) {
        this.descricao = descricao;
        this.num = num;
    }
    private String descricao;
    
    private int num;

    public String getDescricao() {
        return descricao;
    }
    
    public int getNum(){
        return num;
    }
}
