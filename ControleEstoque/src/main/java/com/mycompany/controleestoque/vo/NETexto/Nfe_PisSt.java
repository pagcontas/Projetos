/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.mycompany.controleestoque.vo.NETexto;

import java.io.Serializable;

public class Nfe_PisSt implements Serializable {

    private String r02Vbc;
    private String r03Ppis;
    private String r04Qbcprod;
    private String r05Valiqprod;
    private String r06Vpis;

    public Nfe_PisSt() {
        inicializa();
    }

    public Nfe_PisSt(String r02Vbc, String r03Ppis, String r04Qbcprod, String r05Valiqprod, String r06Vpis) {
        this.r02Vbc = r02Vbc;
        this.r03Ppis = r03Ppis;
        this.r04Qbcprod = r04Qbcprod;
        this.r05Valiqprod = r05Valiqprod;
        this.r06Vpis = r06Vpis;
    }

    private void inicializa() {
        this.r02Vbc = "";
        this.r03Ppis = "";
        this.r04Qbcprod = "";
        this.r05Valiqprod = "";
        this.r06Vpis = "";
    }

    public String getR02Vbc() {
        return this.r02Vbc;
    }

    public void setR02Vbc(String r02Vbc) {
        this.r02Vbc = r02Vbc;
    }

    public String getR03Ppis() {
        return this.r03Ppis;
    }

    public void setR03Ppis(String r03Ppis) {
        this.r03Ppis = r03Ppis;
    }

    public String getR04Qbcprod() {
        return this.r04Qbcprod;
    }

    public void setR04Qbcprod(String r04Qbcprod) {
        this.r04Qbcprod = r04Qbcprod;
    }

    public String getR05Valiqprod() {
        return this.r05Valiqprod;
    }

    public void setR05Valiqprod(String r05Valiqprod) {
        this.r05Valiqprod = r05Valiqprod;
    }

    public String getR06Vpis() {
        return this.r06Vpis;
    }

    public void setR06Vpis(String r06Vpis) {
        this.r06Vpis = r06Vpis;
    }
}
