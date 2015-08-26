/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package br.com.jsoft.centralfinanceira.modelo.enums;

/**
 *
 * @author ti05
 */
public enum TipoBoletos {

    BOLETOS(1, "Boleto"),
    BOLETOSITE(2, "Boleto Site"),
    CREDIDOS(3, "Crédidos Digitais"),
    RECARGA(4, "Recarga"),
    VALEGAS(5, "Vale Gás"),
    OPS(6, "Ordem de Pagamento"),
    BB(7, "Banco do Brasil"),
    BP(8, "Banco Popular");

    private TipoBoletos(int num, String descricao) {
        this.descricao = descricao;
        this.num = num;
    }

    String descricao;

    int num;

    public String getDescricao() {
        return descricao;
    }

    public int getNum() {
        return num;
    }
}
