/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.mycompany.controleestoque.vo.NETexto;

import java.io.Serializable;

public class Nfe_InformacoesAdicionais implements Serializable {

    private String z02Infadfisco;
    private String z03Infcpl;
    private String z05Xcampo;
    private String z06Xtexto;
    private String z08Xcampo;
    private String z09Xtexto;
    private String z11Nproc;
    private String z12Indproc;

    public Nfe_InformacoesAdicionais() {
        inicializa();
    }

    public Nfe_InformacoesAdicionais(String z02Infadfisco, String z03Infcpl, String z05Xcampo, String z06Xtexto, String z08Xcampo, String z09Xtexto, String z11Nproc, String z12Indproc) {
        this.z02Infadfisco = z02Infadfisco;
        this.z03Infcpl = z03Infcpl;
        this.z05Xcampo = z05Xcampo;
        this.z06Xtexto = z06Xtexto;
        this.z08Xcampo = z08Xcampo;
        this.z09Xtexto = z09Xtexto;
        this.z11Nproc = z11Nproc;
        this.z12Indproc = z12Indproc;
    }

    private void inicializa() {
        this.z02Infadfisco = "";
        this.z03Infcpl = "";
        this.z05Xcampo = "";
        this.z06Xtexto = "";
        this.z08Xcampo = "";
        this.z09Xtexto = "";
        this.z11Nproc = "";
        this.z12Indproc = "";
    }

    public String getZ02Infadfisco() {
        return this.z02Infadfisco;
    }

    public void setZ02Infadfisco(String z02Infadfisco) {
        this.z02Infadfisco = z02Infadfisco;
    }

    public String getZ03Infcpl() {
        return this.z03Infcpl;
    }

    public void setZ03Infcpl(String z03Infcpl) {
        this.z03Infcpl = z03Infcpl;
    }

    public String getZ05Xcampo() {
        return this.z05Xcampo;
    }

    public void setZ05Xcampo(String z05Xcampo) {
        this.z05Xcampo = z05Xcampo;
    }

    public String getZ06Xtexto() {
        return this.z06Xtexto;
    }

    public void setZ06Xtexto(String z06Xtexto) {
        this.z06Xtexto = z06Xtexto;
    }

    public String getZ08Xcampo() {
        return this.z08Xcampo;
    }

    public void setZ08Xcampo(String z08Xcampo) {
        this.z08Xcampo = z08Xcampo;
    }

    public String getZ09Xtexto() {
        return this.z09Xtexto;
    }

    public void setZ09Xtexto(String z09Xtexto) {
        this.z09Xtexto = z09Xtexto;
    }

    public String getZ11Nproc() {
        return this.z11Nproc;
    }

    public void setZ11Nproc(String z11Nproc) {
        this.z11Nproc = z11Nproc;
    }

    public String getZ12Indproc() {
        return this.z12Indproc;
    }

    public void setZ12Indproc(String z12Indproc) {
        this.z12Indproc = z12Indproc;
    }
}
