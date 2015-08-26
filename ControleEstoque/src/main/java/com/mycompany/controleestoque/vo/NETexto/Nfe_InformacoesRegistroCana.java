/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.mycompany.controleestoque.vo.NETexto;

import java.io.Serializable;

public class Nfe_InformacoesRegistroCana implements Serializable {

    private String zc03Safra;
    private String zc02Ref;
    private String zc05Dia;
    private String zc06Qtde;
    private String zc07Qtomes;
    private String zc08Qtotant;
    private String zc09Qtotger;
    private String zc11Xded;
    private String zc12Vded;
    private String zc13Vfor;
    private String zc14Vtotded;
    private String zc15Vliqfor;

    public Nfe_InformacoesRegistroCana() {
        inicializa();
    }

    public Nfe_InformacoesRegistroCana(String zc03Safra, String zc02Ref, String zc05Dia, String zc06Qtde, String zc07Qtomes, String zc08Qtotant, String zc09Qtotger, String zc11Xded, String zc12Vded, String zc13Vfor, String zc14Vtotded, String zc15Vliqfor) {
        this.zc03Safra = zc03Safra;
        this.zc02Ref = zc02Ref;
        this.zc05Dia = zc05Dia;
        this.zc06Qtde = zc06Qtde;
        this.zc07Qtomes = zc07Qtomes;
        this.zc08Qtotant = zc08Qtotant;
        this.zc09Qtotger = zc09Qtotger;
        this.zc11Xded = zc11Xded;
        this.zc12Vded = zc12Vded;
        this.zc13Vfor = zc13Vfor;
        this.zc14Vtotded = zc14Vtotded;
        this.zc15Vliqfor = zc15Vliqfor;
    }

    private void inicializa() {
        this.zc03Safra = "";
        this.zc02Ref = "";
        this.zc05Dia = "";
        this.zc06Qtde = "";
        this.zc07Qtomes = "";
        this.zc08Qtotant = "";
        this.zc09Qtotger = "";
        this.zc11Xded = "";
        this.zc12Vded = "";
        this.zc13Vfor = "";
        this.zc14Vtotded = "";
        this.zc15Vliqfor = "";
    }

    public String getZc03Safra() {
        return this.zc03Safra;
    }

    public void setZc03Safra(String zc03Safra) {
        this.zc03Safra = zc03Safra;
    }

    public String getZc02Ref() {
        return this.zc02Ref;
    }

    public void setZc02Ref(String zc02Ref) {
        this.zc02Ref = zc02Ref;
    }

    public String getZc05Dia() {
        return this.zc05Dia;
    }

    public void setZc05Dia(String zc05Dia) {
        this.zc05Dia = zc05Dia;
    }

    public String getZc06Qtde() {
        return this.zc06Qtde;
    }

    public void setZc06Qtde(String zc06Qtde) {
        this.zc06Qtde = zc06Qtde;
    }

    public String getZc07Qtomes() {
        return this.zc07Qtomes;
    }

    public void setZc07Qtomes(String zc07Qtomes) {
        this.zc07Qtomes = zc07Qtomes;
    }

    public String getZc08Qtotant() {
        return this.zc08Qtotant;
    }

    public void setZc08Qtotant(String zc08Qtotant) {
        this.zc08Qtotant = zc08Qtotant;
    }

    public String getZc09Qtotger() {
        return this.zc09Qtotger;
    }

    public void setZc09Qtotger(String zc09Qtotger) {
        this.zc09Qtotger = zc09Qtotger;
    }

    public String getZc11Xded() {
        return this.zc11Xded;
    }

    public void setZc11Xded(String zc11Xded) {
        this.zc11Xded = zc11Xded;
    }

    public String getZc12Vded() {
        return this.zc12Vded;
    }

    public void setZc12Vded(String zc12Vded) {
        this.zc12Vded = zc12Vded;
    }

    public String getZc13Vfor() {
        return this.zc13Vfor;
    }

    public void setZc13Vfor(String zc13Vfor) {
        this.zc13Vfor = zc13Vfor;
    }

    public String getZc14Vtotded() {
        return this.zc14Vtotded;
    }

    public void setZc14Vtotded(String zc14Vtotded) {
        this.zc14Vtotded = zc14Vtotded;
    }

    public String getZc15Vliqfor() {
        return this.zc15Vliqfor;
    }

    public void setZc15Vliqfor(String zc15Vliqfor) {
        this.zc15Vliqfor = zc15Vliqfor;
    }
}
