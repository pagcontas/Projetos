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
public enum ModalidadeFrete {

    PORCONTAEMITENTE(0, "Por Conta do Emitente"),
    PORCONTADESTINATARIO(1, "Por Conta do Destinatário/Remetente"),
    PORCONTATERCEIROS(2, "Por Conta de Terceiros"),
    SEMFRETE(9, "Sem Frete");

    private ModalidadeFrete(int num, String descricao) {
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
