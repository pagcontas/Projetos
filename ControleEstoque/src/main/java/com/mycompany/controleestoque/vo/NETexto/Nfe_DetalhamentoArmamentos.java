/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.mycompany.controleestoque.vo.NETexto;


import java.io.Serializable;

public class Nfe_DetalhamentoArmamentos implements Serializable
{
  private String l02Tparma;
  private String l03Nserie;
  private String l04Ncano;
  private String l05Descr;

  public Nfe_DetalhamentoArmamentos()
  {
    inicializa();
  }

  public Nfe_DetalhamentoArmamentos(String l02Tparma, String l03Nserie, String l04Ncano, String l05Descr)
  {
    this.l02Tparma = l02Tparma;
    this.l03Nserie = l03Nserie;
    this.l04Ncano = l04Ncano;
    this.l05Descr = l05Descr;
  }

  private void inicializa() {
    this.l02Tparma = "";
    this.l03Nserie = "";
    this.l04Ncano = "";
    this.l05Descr = "";
  }

  public String getL02Tparma() {
    return this.l02Tparma;
  }

  public void setL02Tparma(String l02Tparma) {
    this.l02Tparma = l02Tparma;
  }
  public String getL03Nserie() {
    return this.l03Nserie;
  }

  public void setL03Nserie(String l03Nserie) {
    this.l03Nserie = l03Nserie;
  }
  public String getL04Ncano() {
    return this.l04Ncano;
  }

  public void setL04Ncano(String l04Ncano) {
    this.l04Ncano = l04Ncano;
  }
  public String getL05Descr() {
    return this.l05Descr;
  }

  public void setL05Descr(String l05Descr) {
    this.l05Descr = l05Descr;
  }
}
