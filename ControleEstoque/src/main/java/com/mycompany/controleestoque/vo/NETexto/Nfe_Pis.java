/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.mycompany.controleestoque.vo.NETexto;

import java.io.Serializable;

public class Nfe_Pis implements Serializable {

    private String q06Cst;
    private String q07Vbc;
    private String q08Ppis;
    private String q09Vpis;
    private String q10Qbcprod;
    private String q11Valiqprod;

    public Nfe_Pis() {
        inicializa();
    }

    public Nfe_Pis(String q06Cst, String q07Vbc, String q08Ppis, String q09Vpis, String q10Qbcprod, String q11Valiqprod) {
        this.q06Cst = q06Cst;
        this.q07Vbc = q07Vbc;
        this.q08Ppis = q08Ppis;
        this.q09Vpis = q09Vpis;
        this.q10Qbcprod = q10Qbcprod;
        this.q11Valiqprod = q11Valiqprod;
    }

    private void inicializa() {
        this.q06Cst = "";
        this.q07Vbc = "";
        this.q08Ppis = "";
        this.q09Vpis = "";
        this.q10Qbcprod = "";
        this.q11Valiqprod = "";
    }

    public String getQ06Cst() {
        return this.q06Cst;
    }

    public void setQ06Cst(String q06Cst) {
        this.q06Cst = q06Cst;
    }

    public String getQ07Vbc() {
        return this.q07Vbc;
    }

    public void setQ07Vbc(String q07Vbc) {
        this.q07Vbc = q07Vbc;
    }

    public String getQ08Ppis() {
        return this.q08Ppis;
    }

    public void setQ08Ppis(String q08Ppis) {
        this.q08Ppis = q08Ppis;
    }

    public String getQ09Vpis() {
        return this.q09Vpis;
    }

    public void setQ09Vpis(String q09Vpis) {
        this.q09Vpis = q09Vpis;
    }

    public String getQ10Qbcprod() {
        return this.q10Qbcprod;
    }

    public void setQ10Qbcprod(String q10Qbcprod) {
        this.q10Qbcprod = q10Qbcprod;
    }

    public String getQ11Valiqprod() {
        return this.q11Valiqprod;
    }

    public void setQ11Valiqprod(String q11Valiqprod) {
        this.q11Valiqprod = q11Valiqprod;
    }
}
