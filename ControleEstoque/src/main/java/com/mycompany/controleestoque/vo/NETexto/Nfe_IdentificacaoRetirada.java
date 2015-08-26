/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.mycompany.controleestoque.vo.NETexto;

import java.io.Serializable;

public class Nfe_IdentificacaoRetirada implements Serializable {

    private String f02Cnpj;
    private String f02aCpf;
    private String f03Xlgr;
    private String f04Nro;
    private String f05Xcpl;
    private String f06Xbairro;
    private String f07Cmun;
    private String f08Xmun;
    private String f09Uf;

    public Nfe_IdentificacaoRetirada() {
        inicializa();
    }

    public Nfe_IdentificacaoRetirada(String f02Cnpj, String f02aCpf, String f03Xlgr, String f04Nro, String f05Xcpl, String f06Xbairro, String f07Cmun, String f08Xmun, String f09Uf) {
        this.f02Cnpj = f02Cnpj;
        this.f02aCpf = f02aCpf;
        this.f03Xlgr = f03Xlgr;
        this.f04Nro = f04Nro;
        this.f05Xcpl = f05Xcpl;
        this.f06Xbairro = f06Xbairro;
        this.f07Cmun = f07Cmun;
        this.f08Xmun = f08Xmun;
        this.f09Uf = f09Uf;
    }

    private void inicializa() {
        this.f02Cnpj = "";
        this.f02aCpf = "";
        this.f03Xlgr = "";
        this.f04Nro = "";
        this.f05Xcpl = "";
        this.f06Xbairro = "";
        this.f07Cmun = "";
        this.f08Xmun = "";
        this.f09Uf = "";
    }

    public String getF02Cnpj() {
        return this.f02Cnpj;
    }

    public void setF02Cnpj(String f02Cnpj) {
        this.f02Cnpj = f02Cnpj;
    }

    public String getF02aCpf() {
        return this.f02aCpf;
    }

    public void setF02aCpf(String f02aCpf) {
        this.f02aCpf = f02aCpf;
    }

    public String getF03Xlgr() {
        return this.f03Xlgr;
    }

    public void setF03Xlgr(String f03Xlgr) {
        this.f03Xlgr = f03Xlgr;
    }

    public String getF04Nro() {
        return this.f04Nro;
    }

    public void setF04Nro(String f04Nro) {
        this.f04Nro = f04Nro;
    }

    public String getF05Xcpl() {
        return this.f05Xcpl;
    }

    public void setF05Xcpl(String f05Xcpl) {
        this.f05Xcpl = f05Xcpl;
    }

    public String getF06Xbairro() {
        return this.f06Xbairro;
    }

    public void setF06Xbairro(String f06Xbairro) {
        this.f06Xbairro = f06Xbairro;
    }

    public String getF07Cmun() {
        return this.f07Cmun;
    }

    public void setF07Cmun(String f07Cmun) {
        this.f07Cmun = f07Cmun;
    }

    public String getF08Xmun() {
        return this.f08Xmun;
    }

    public void setF08Xmun(String f08Xmun) {
        this.f08Xmun = f08Xmun;
    }

    public String getF09Uf() {
        return this.f09Uf;
    }

    public void setF09Uf(String f09Uf) {
        this.f09Uf = f09Uf;
    }
}
