/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.mycompany.controleestoque.vo.NETexto;

/**
 *
 * @author KillerBeeTwo
 */

import java.io.Serializable;

public class Nfe_ConfinsSt implements Serializable{
    
  private String t02Vbc;
  private String t03Pconfins;
  private String t04Qbcprod;
  private String t05Valiqprod;
  private String t06Vconfins;

  public Nfe_ConfinsSt()
  {
    inicializa();
  }

  public Nfe_ConfinsSt(String t02Vbc, String t03Pconfins, String t04Qbcprod, String t05Valiqprod, String t06Vconfins)
  {
    this.t02Vbc = t02Vbc;
    this.t03Pconfins = t03Pconfins;
    this.t04Qbcprod = t04Qbcprod;
    this.t05Valiqprod = t05Valiqprod;
    this.t06Vconfins = t06Vconfins;
  }

  private void inicializa() {
    this.t02Vbc = "";
    this.t03Pconfins = "";
    this.t04Qbcprod = "";
    this.t05Valiqprod = "";
    this.t06Vconfins = "";
  }

  public String getT02Vbc()
  {
    return this.t02Vbc;
  }

  public void setT02Vbc(String t02Vbc) {
    this.t02Vbc = t02Vbc;
  }
  public String getT03Pconfins() {
    return this.t03Pconfins;
  }

  public void setT03Pconfins(String t03Pconfins) {
    this.t03Pconfins = t03Pconfins;
  }
  public String getT04Qbcprod() {
    return this.t04Qbcprod;
  }

  public void setT04Qbcprod(String t04Qbcprod) {
    this.t04Qbcprod = t04Qbcprod;
  }
  public String getT05Valiqprod() {
    return this.t05Valiqprod;
  }

  public void setT05Valiqprod(String t05Valiqprod) {
    this.t05Valiqprod = t05Valiqprod;
  }
  public String getT06Vconfins() {
    return this.t06Vconfins;
  }

  public void setT06Vconfins(String t06Vconfins) {
    this.t06Vconfins = t06Vconfins;
  }
}
