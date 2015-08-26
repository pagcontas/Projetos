/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.mycompany.controleestoque.vo.NETexto;


import java.io.Serializable;

public class Nfe_DadosCobranca implements Serializable{
    
  private String y03Nfat;
  private String y04Vorig;
  private String y05Vdesc;
  private String y06Vliq;
  private String y08Ndup;
  private String y09Dvenc;
  private String y10Vdup;

  public Nfe_DadosCobranca()
  {
    inicializa();
  }

  public Nfe_DadosCobranca(String y03Nfat, String y04Vorig, String y05Vdesc, String y06Vliq, String y08Ndup, String y09Dvenc, String y10Vdup)
  {
    this.y03Nfat = y03Nfat;
    this.y04Vorig = y04Vorig;
    this.y05Vdesc = y05Vdesc;
    this.y06Vliq = y06Vliq;
    this.y08Ndup = y08Ndup;
    this.y09Dvenc = y09Dvenc;
    this.y10Vdup = y10Vdup;
  }

  private void inicializa() {
    this.y03Nfat = "";
    this.y04Vorig = "";
    this.y05Vdesc = "";
    this.y06Vliq = "";
    this.y08Ndup = "";
    this.y09Dvenc = "";
    this.y10Vdup = "";
  }

  public String getY03Nfat() {
    return this.y03Nfat;
  }

  public void setY03Nfat(String y03Nfat) {
    this.y03Nfat = y03Nfat;
  }
  public String getY04Vorig() {
    return this.y04Vorig;
  }

  public void setY04Vorig(String y04Vorig) {
    this.y04Vorig = y04Vorig;
  }
  public String getY05Vdesc() {
    return this.y05Vdesc;
  }

  public void setY05Vdesc(String y05Vdesc) {
    this.y05Vdesc = y05Vdesc;
  }
  public String getY06Vliq() {
    return this.y06Vliq;
  }

  public void setY06Vliq(String y06Vliq) {
    this.y06Vliq = y06Vliq;
  }
  public String getY08Ndup() {
    return this.y08Ndup;
  }

  public void setY08Ndup(String y08Ndup) {
    this.y08Ndup = y08Ndup;
  }
  public String getY09Dvenc() {
    return this.y09Dvenc;
  }

  public void setY09Dvenc(String y09Dvenc) {
    this.y09Dvenc = y09Dvenc;
  }
  public String getY10Vdup() {
    return this.y10Vdup;
  }

  public void setY10Vdup(String y10Vdup) {
    this.y10Vdup = y10Vdup;
  }
}
