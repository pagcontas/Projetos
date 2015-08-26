/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.mycompany.controleestoque.vo.NETexto;
import java.io.Serializable;

/**
 *
 * @author KillerBeeTwo
 */

public class Nfe_Confins implements Serializable {

    private String s06Cst;
    private String s07Vbc;
    private String s08Pconfins;
    private String s09Qbcprod;
    private String s10Valiqprod;
    private String s11Vconfins;

    public Nfe_Confins() {
        inicializa();
    }

    public Nfe_Confins(String s06Cst, String s07Vbc, String s08Pconfins, String s09Qbcprod, String s10Valiqprod, String s11Vconfins) {
        this.s06Cst = s06Cst;
        this.s07Vbc = s07Vbc;
        this.s08Pconfins = s08Pconfins;
        this.s09Qbcprod = s09Qbcprod;
        this.s10Valiqprod = s10Valiqprod;
        this.s11Vconfins = s11Vconfins;
    }

    private void inicializa() {
        this.s06Cst = "";
        this.s07Vbc = "";
        this.s08Pconfins = "";
        this.s09Qbcprod = "";
        this.s10Valiqprod = "";
        this.s11Vconfins = "";
    }

    public String getS06Cst() {
        return this.s06Cst;
    }

    public void setS06Cst(String s06Cst) {
        this.s06Cst = s06Cst;
    }

    public String getS07Vbc() {
        return this.s07Vbc;
    }

    public void setS07Vbc(String s07Vbc) {
        this.s07Vbc = s07Vbc;
    }

    public String getS08Pconfins() {
        return this.s08Pconfins;
    }

    public void setS08Pconfins(String s08Pconfins) {
        this.s08Pconfins = s08Pconfins;
    }

    public String getS09Qbcprod() {
        return this.s09Qbcprod;
    }

    public void setS09Qbcprod(String s09Qbcprod) {
        this.s09Qbcprod = s09Qbcprod;
    }

    public String getS10Valiqprod() {
        return this.s10Valiqprod;
    }

    public void setS10Valiqprod(String s10Valiqprod) {
        this.s10Valiqprod = s10Valiqprod;
    }

    public String getS11Vconfins() {
        return this.s11Vconfins;
    }

    public void setS11Vconfins(String s11Vconfins) {
        this.s11Vconfins = s11Vconfins;
    }
}
