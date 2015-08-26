/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.mycompany.controleestoque.vo.NETexto;

import java.io.Serializable;

public class Nfe_ImpostoImportacao implements Serializable {

    private String p02Vbc;
    private String p03Vdespadu;
    private String p04Vii;
    private String p05Viof;

    public Nfe_ImpostoImportacao() {
        inicializa();
    }

    public Nfe_ImpostoImportacao(String p02Vbc, String p03Vdespadu, String p04Vii, String p05Viof) {
        this.p02Vbc = p02Vbc;
        this.p03Vdespadu = p03Vdespadu;
        this.p04Vii = p04Vii;
        this.p05Viof = p05Viof;
    }

    private void inicializa() {
        this.p02Vbc = "";
        this.p03Vdespadu = "";
        this.p04Vii = "";
        this.p05Viof = "";
    }

    public String getP02Vbc() {
        return this.p02Vbc;
    }

    public void setP02Vbc(String p02Vbc) {
        this.p02Vbc = p02Vbc;
    }

    public String getP03Vdespadu() {
        return this.p03Vdespadu;
    }

    public void setP03Vdespadu(String p03Vdespadu) {
        this.p03Vdespadu = p03Vdespadu;
    }

    public String getP04Vii() {
        return this.p04Vii;
    }

    public void setP04Vii(String p04Vii) {
        this.p04Vii = p04Vii;
    }

    public String getP05Viof() {
        return this.p05Viof;
    }

    public void setP05Viof(String p05Viof) {
        this.p05Viof = p05Viof;
    }
}
