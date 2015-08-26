/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.mycompany.controleestoque.vo.NETexto;


import java.io.Serializable;

public class Nfe_DetalhamentoMedicamentos implements Serializable
{
  private String k02Nlote;
  private String k03Qlote;
  private String k04Dfab;
  private String k05Dval;
  private String k06Vpmc;

  public Nfe_DetalhamentoMedicamentos()
  {
    inicializa();
  }
  public Nfe_DetalhamentoMedicamentos(String k02Nlote, String k03Qlote, String k04Dfab, String k05Dval, String k06Vpmc) {
    this.k02Nlote = k02Nlote;
    this.k03Qlote = k03Qlote;
    this.k04Dfab = k04Dfab;
    this.k05Dval = k05Dval;
    this.k06Vpmc = k06Vpmc;
  }

  private void inicializa() {
    this.k02Nlote = "";
    this.k03Qlote = "";
    this.k04Dfab = "";
    this.k05Dval = "";
    this.k06Vpmc = "";
  }

  public String getK02Nlote() {
    return this.k02Nlote;
  }

  public void setK02Nlote(String k02Nlote) {
    this.k02Nlote = k02Nlote;
  }
  public String getK03Qlote() {
    return this.k03Qlote;
  }

  public void setK03Qlote(String k03Qlote) {
    this.k03Qlote = k03Qlote;
  }
  public String getK04Dfab() {
    return this.k04Dfab;
  }

  public void setK04Dfab(String k04Dfab) {
    this.k04Dfab = k04Dfab;
  }
  public String getK05Dval() {
    return this.k05Dval;
  }

  public void setK05Dval(String k05Dval) {
    this.k05Dval = k05Dval;
  }
  public String getK06Vpmc() {
    return this.k06Vpmc;
  }

  public void setK06Vpmc(String k06Vpmc) {
    this.k06Vpmc = k06Vpmc;
  }
}
