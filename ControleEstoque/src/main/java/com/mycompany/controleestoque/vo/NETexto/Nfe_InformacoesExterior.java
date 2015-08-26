/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.mycompany.controleestoque.vo.NETexto;

import java.io.Serializable;

public class Nfe_InformacoesExterior implements Serializable {

    private String za02Ufembarq;
    private String za03Xlocembarq;

    public Nfe_InformacoesExterior() {
        inicializa();
    }

    public Nfe_InformacoesExterior(String za02Ufembarq, String za03Xlocembarq) {
        this.za02Ufembarq = za02Ufembarq;
        this.za03Xlocembarq = za03Xlocembarq;
    }

    private void inicializa() {
        this.za02Ufembarq = "";
        this.za03Xlocembarq = "";
    }

    public String getZa02Ufembarq() {
        return this.za02Ufembarq;
    }

    public void setZa02Ufembarq(String za02Ufembarq) {
        this.za02Ufembarq = za02Ufembarq;
    }

    public String getZa03Xlocembarq() {
        return this.za03Xlocembarq;
    }

    public void setZa03Xlocembarq(String za03Xlocembarq) {
        this.za03Xlocembarq = za03Xlocembarq;
    }
}
