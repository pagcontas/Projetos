/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.mycompany.controleestoque.vo.NETexto;


import java.io.Serializable;

public class Nfe_DetalhamentoCombustiveis implements Serializable
{
  private String l102Cprodanp;
  private String l103Codig;
  private String l104Qtemp;
  private String l120Ufcons;
  private String l106Qbcprod;
  private String l107Valiqprod;
  private String l108Vcide;

  public Nfe_DetalhamentoCombustiveis()
  {
    inicializa();
  }

  public Nfe_DetalhamentoCombustiveis(String l102Cprodanp, String l103Codig, String l104Qtemp, String l120Ufcons, String l106Qbcprod, String l107Valiqprod, String l108Vcide)
  {
    this.l102Cprodanp = l102Cprodanp;
    this.l103Codig = l103Codig;
    this.l104Qtemp = l104Qtemp;
    this.l120Ufcons = l120Ufcons;
    this.l106Qbcprod = l106Qbcprod;
    this.l107Valiqprod = l107Valiqprod;
    this.l108Vcide = l108Vcide;
  }

  private void inicializa() {
    this.l102Cprodanp = "";
    this.l103Codig = "";
    this.l104Qtemp = "";
    this.l120Ufcons = "";
    this.l106Qbcprod = "";
    this.l107Valiqprod = "";
    this.l108Vcide = "";
  }

  public String getL102Cprodanp() {
    return this.l102Cprodanp;
  }

  public void setL102Cprodanp(String l102Cprodanp) {
    this.l102Cprodanp = l102Cprodanp;
  }
  public String getL103Codig() {
    return this.l103Codig;
  }

  public void setL103Codig(String l103Codig) {
    this.l103Codig = l103Codig;
  }
  public String getL104Qtemp() {
    return this.l104Qtemp;
  }

  public void setL104Qtemp(String l104Qtemp) {
    this.l104Qtemp = l104Qtemp;
  }
  public String getL120Ufcons() {
    return this.l120Ufcons;
  }

  public void setL120Ufcons(String l120Ufcons) {
    this.l120Ufcons = l120Ufcons;
  }
  public String getL106Qbcprod() {
    return this.l106Qbcprod;
  }

  public void setL106Qbcprod(String l106Qbcprod) {
    this.l106Qbcprod = l106Qbcprod;
  }
  public String getL107Valiqprod() {
    return this.l107Valiqprod;
  }

  public void setL107Valiqprod(String l107Valiqprod) {
    this.l107Valiqprod = l107Valiqprod;
  }
  public String getL108Vcide() {
    return this.l108Vcide;
  }

  public void setL108Vcide(String l108Vcide) {
    this.l108Vcide = l108Vcide;
  }
}
