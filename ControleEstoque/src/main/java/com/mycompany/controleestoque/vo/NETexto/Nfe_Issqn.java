/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.mycompany.controleestoque.vo.NETexto;

import java.io.Serializable;

public class Nfe_Issqn implements Serializable {

    private String u02Vbc;
    private String u03Valiq;
    private String u04Vissqn;
    private String u05Cmunfg;
    private String u06Clistserv;
    private String u07Csittrib;

    public Nfe_Issqn() {
        inicializa();
    }

    public Nfe_Issqn(String u02Vbc, String u03Valiq, String u04Vissqn, String u05Cmunfg, String u06Clistserv, String u07Csittrib) {
        this.u02Vbc = u02Vbc;
        this.u03Valiq = u03Valiq;
        this.u04Vissqn = u04Vissqn;
        this.u05Cmunfg = u05Cmunfg;
        this.u06Clistserv = u06Clistserv;
        this.u07Csittrib = u07Csittrib;
    }

    private void inicializa() {
        this.u02Vbc = "";
        this.u03Valiq = "";
        this.u04Vissqn = "";
        this.u05Cmunfg = "";
        this.u06Clistserv = "";
        this.u07Csittrib = "";
    }

    public String getU02Vbc() {
        return this.u02Vbc;
    }

    public void setU02Vbc(String u02Vbc) {
        this.u02Vbc = u02Vbc;
    }

    public String getU03Valiq() {
        return this.u03Valiq;
    }

    public void setU03Valiq(String u03Valiq) {
        this.u03Valiq = u03Valiq;
    }

    public String getU04Vissqn() {
        return this.u04Vissqn;
    }

    public void setU04Vissqn(String u04Vissqn) {
        this.u04Vissqn = u04Vissqn;
    }

    public String getU05Cmunfg() {
        return this.u05Cmunfg;
    }

    public void setU05Cmunfg(String u05Cmunfg) {
        this.u05Cmunfg = u05Cmunfg;
    }

    public String getU06Clistserv() {
        return this.u06Clistserv;
    }

    public void setU06Clistserv(String u06Clistserv) {
        this.u06Clistserv = u06Clistserv;
    }

    public String getU07Csittrib() {
        return this.u07Csittrib;
    }

    public void setU07Csittrib(String u07Csittrib) {
        this.u07Csittrib = u07Csittrib;
    }
}
