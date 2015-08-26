/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.mycompany.controleestoque.vo.NETexto;

import java.io.Serializable;

public class Nfe_InformacoesCompras implements Serializable {

    private String zb02XNemp;
    private String zb03Xped;
    private String zb04Xcont;

    public Nfe_InformacoesCompras() {
        inicializa();
    }

    public Nfe_InformacoesCompras(String zb02XNemp, String zb03Xped, String zb04Xcont) {
        this.zb02XNemp = zb02XNemp;
        this.zb03Xped = zb03Xped;
        this.zb04Xcont = zb04Xcont;
    }

    private void inicializa() {
        this.zb02XNemp = "";
        this.zb03Xped = "";
        this.zb04Xcont = "";
    }

    public String getZb02XNemp() {
        return this.zb02XNemp;
    }

    public void setZb02XNemp(String zb02XNemp) {
        this.zb02XNemp = zb02XNemp;
    }

    public String getZb03Xped() {
        return this.zb03Xped;
    }

    public void setZb03Xped(String zb03Xped) {
        this.zb03Xped = zb03Xped;
    }

    public String getZb04Xcont() {
        return this.zb04Xcont;
    }

    public void setZb04Xcont(String zb04Xcont) {
        this.zb04Xcont = zb04Xcont;
    }
}
