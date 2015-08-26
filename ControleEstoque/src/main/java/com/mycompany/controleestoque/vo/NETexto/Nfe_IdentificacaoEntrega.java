/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.mycompany.controleestoque.vo.NETexto;

import java.io.Serializable;

public class Nfe_IdentificacaoEntrega implements Serializable {

    private String g02Cnpj;
    private String g02aCpf;
    private String g03Xlgr;
    private String g04Nro;
    private String g05Xcpl;
    private String g06Xbairro;
    private String g07Cmun;
    private String g08Xmun;
    private String g09Uf;

    public Nfe_IdentificacaoEntrega() {
        inicializa();
    }

    public Nfe_IdentificacaoEntrega(String g02Cnpj, String g02aCpf, String g03Xlgr, String g04Nro, String g05Xcpl, String g06Xbairro, String g07Cmun, String g08Xmun, String g09Uf) {
        this.g02Cnpj = g02Cnpj;
        this.g02aCpf = g02aCpf;
        this.g03Xlgr = g03Xlgr;
        this.g04Nro = g04Nro;
        this.g05Xcpl = g05Xcpl;
        this.g06Xbairro = g06Xbairro;
        this.g07Cmun = g07Cmun;
        this.g08Xmun = g08Xmun;
        this.g09Uf = g09Uf;
    }

    private void inicializa() {
        this.g02Cnpj = "";
        this.g02aCpf = "";
        this.g03Xlgr = "";
        this.g04Nro = "";
        this.g05Xcpl = "";
        this.g06Xbairro = "";
        this.g07Cmun = "";
        this.g08Xmun = "";
        this.g09Uf = "";
    }

    public String getG02Cnpj() {
        return this.g02Cnpj;
    }

    public void setG02Cnpj(String g02Cnpj) {
        this.g02Cnpj = g02Cnpj;
    }

    public String getG02aCpf() {
        return this.g02aCpf;
    }

    public void setG02aCpf(String g02aCpf) {
        this.g02aCpf = g02aCpf;
    }

    public String getG03Xlgr() {
        return this.g03Xlgr;
    }

    public void setG03Xlgr(String g03Xlgr) {
        this.g03Xlgr = g03Xlgr;
    }

    public String getG04Nro() {
        return this.g04Nro;
    }

    public void setG04Nro(String g04Nro) {
        this.g04Nro = g04Nro;
    }

    public String getG05Xcpl() {
        return this.g05Xcpl;
    }

    public void setG05Xcpl(String g05Xcpl) {
        this.g05Xcpl = g05Xcpl;
    }

    public String getG06Xbairro() {
        return this.g06Xbairro;
    }

    public void setG06Xbairro(String g06Xbairro) {
        this.g06Xbairro = g06Xbairro;
    }

    public String getG07Cmun() {
        return this.g07Cmun;
    }

    public void setG07Cmun(String g07Cmun) {
        this.g07Cmun = g07Cmun;
    }

    public String getG08Xmun() {
        return this.g08Xmun;
    }

    public void setG08Xmun(String g08Xmun) {
        this.g08Xmun = g08Xmun;
    }

    public String getG09Uf() {
        return this.g09Uf;
    }

    public void setG09Uf(String g09Uf) {
        this.g09Uf = g09Uf;
    }
}
