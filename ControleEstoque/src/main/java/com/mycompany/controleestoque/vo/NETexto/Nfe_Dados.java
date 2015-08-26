/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.mycompany.controleestoque.vo.NETexto;

import java.io.Serializable;

public class Nfe_Dados implements Serializable {

    private String nfeCodigo;
    private String a02Versao;
    private String a03Id;
    private String a04pk_nItem;

    public Nfe_Dados() {
        inicializa();
    }

    public Nfe_Dados(String nfeCodigo, String a02Versao, String a03Id) {
        this.nfeCodigo = nfeCodigo;
        this.a02Versao = a02Versao;
        this.a03Id = a03Id;
    }

    private void inicializa() {
        this.nfeCodigo = "";
        this.a02Versao = "";
        this.a03Id = "";
        this.a04pk_nItem = "";
    }

    public String getNfeCodigo() {
        return this.nfeCodigo;
    }

    public void setNfeCodigo(String nfeCodigo) {
        this.nfeCodigo = nfeCodigo;
    }

    public String getA02Versao() {
        return this.a02Versao;
    }

    public void setA02Versao(String a02Versao) {
        this.a02Versao = a02Versao;
    }

    public String getA03Id() {
        return this.a03Id;
    }

    public void setA03Id(String a03Id) {
        this.a03Id = a03Id;
    }

    public String getA04pk_nItem() {
        return a04pk_nItem;
    }

    public void setA04pk_nItem(String a04pk_nItem) {
        this.a04pk_nItem = a04pk_nItem;
    }

}
