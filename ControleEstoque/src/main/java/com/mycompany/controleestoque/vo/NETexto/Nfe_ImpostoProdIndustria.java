/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.mycompany.controleestoque.vo.NETexto;

import java.io.Serializable;

public class Nfe_ImpostoProdIndustria implements Serializable {

    private String o02Clenq;
    private String o06Cenq;
    private String o03Cnpjprod;
    private String o04Cselo;
    private String o05Qselo;
    private String o09Cst;
    private String o10Vbc;
    private String o13Pipi;
    private String o11Qunid;
    private String o12Vunid;
    private String o14Vipi;

    public Nfe_ImpostoProdIndustria() {
        inicializa();
    }

    public Nfe_ImpostoProdIndustria(String o02Clenq, String o06Cenq, String o03Cnpjprod, String o04Cselo, String o05Qselo, String o09Cst, String o10Vbc, String o13Pipi, String o11Qunid, String o12Vunid, String o14Vipi) {
        this.o02Clenq = o02Clenq;
        this.o06Cenq = o06Cenq;
        this.o03Cnpjprod = o03Cnpjprod;
        this.o04Cselo = o04Cselo;
        this.o05Qselo = o05Qselo;
        this.o09Cst = o09Cst;
        this.o10Vbc = o10Vbc;
        this.o13Pipi = o13Pipi;
        this.o11Qunid = o11Qunid;
        this.o12Vunid = o12Vunid;
        this.o14Vipi = o14Vipi;
    }

    private void inicializa() {
        this.o02Clenq = "";
        this.o06Cenq = "";
        this.o03Cnpjprod = "";
        this.o04Cselo = "";
        this.o05Qselo = "";
        this.o09Cst = "";
        this.o10Vbc = "";
        this.o13Pipi = "";
        this.o11Qunid = "";
        this.o12Vunid = "";
        this.o14Vipi = "";
    }

    public String getO02Clenq() {
        return this.o02Clenq;
    }

    public void setO02Clenq(String o02Clenq) {
        this.o02Clenq = o02Clenq;
    }

    public String getO06Cenq() {
        return this.o06Cenq;
    }

    public void setO06Cenq(String o06Cenq) {
        this.o06Cenq = o06Cenq;
    }

    public String getO03Cnpjprod() {
        return this.o03Cnpjprod;
    }

    public void setO03Cnpjprod(String o03Cnpjprod) {
        this.o03Cnpjprod = o03Cnpjprod;
    }

    public String getO04Cselo() {
        return this.o04Cselo;
    }

    public void setO04Cselo(String o04Cselo) {
        this.o04Cselo = o04Cselo;
    }

    public String getO05Qselo() {
        return this.o05Qselo;
    }

    public void setO05Qselo(String o05Qselo) {
        this.o05Qselo = o05Qselo;
    }

    public String getO09Cst() {
        return this.o09Cst;
    }

    public void setO09Cst(String o09Cst) {
        this.o09Cst = o09Cst;
    }

    public String getO10Vbc() {
        return this.o10Vbc;
    }

    public void setO10Vbc(String o10Vbc) {
        this.o10Vbc = o10Vbc;
    }

    public String getO13Pipi() {
        return this.o13Pipi;
    }

    public void setO13Pipi(String o13Pipi) {
        this.o13Pipi = o13Pipi;
    }

    public String getO11Qunid() {
        return this.o11Qunid;
    }

    public void setO11Qunid(String o11Qunid) {
        this.o11Qunid = o11Qunid;
    }

    public String getO12Vunid() {
        return this.o12Vunid;
    }

    public void setO12Vunid(String o12Vunid) {
        this.o12Vunid = o12Vunid;
    }

    public String getO14Vipi() {
        return this.o14Vipi;
    }

    public void setO14Vipi(String o14Vipi) {
        this.o14Vipi = o14Vipi;
    }
}
