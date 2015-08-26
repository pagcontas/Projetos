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
public enum UnidadeDeMedida {

    KG(1,"Quilo"),
    L(2,"Litro"),
    UN(3,"Unidade"),
    CX(4,"Caixa"),
    M2(5,"Metros Quadrado"),
    M3(6,"Metro Cúbico"),
    PR(7,"Par"),
    T(8,"Tonelada"),
    QUIL(9,"Quilate"),
    BR(10,"Barra"),
    CNT(11,"Cento"),
    DZ(12,"Duzia"),
    EST(13,"Estojo"),
    FRA(14,"Frasco"),
    FRD(15,"Fardo"),
    GL(16,"Galão"),
    JG(17,"Jogo"),
    AM(18,"Ampola"),
    BD(19,"Balde"),
    BIS(20,"Bisnaga"),
    CTE(21,"Cartela"),
    MÇ(22,"Maço"),
    PAST(23,"Pastilha"),
    PCT(24,"Pacote"),
    POTE(25,"Pote"),
    RO(26,"Rolo"),
    SER(27,"Seringa"),
    VAR(28,"Vareta"),
    KIT(29,"Kit");

    private UnidadeDeMedida(int num, String descricao) {
        this.descricao = descricao;
        this.num = num;
    }
    private String descricao;
    
    private int num;

    public String getDescricao() {
        return descricao;
    }

    public int getNum() {
        return num;
    }
    
}
