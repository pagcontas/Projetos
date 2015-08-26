/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.mycompany.controleestoque.vo.NETexto;


import java.io.Serializable;

public class Nfe_IdentificacaoDestinario implements Serializable
{
  private String e02Cnpj;
  private String e03Cpf;
  private String e04Xnome;
  private String e06Xlgr;
  private String e07Nro;
  private String e08Cpl;
  private String e08Xcpl;
  private String e09Xbairro;
  private String e10Cmun;
  private String e11Xmun;
  private String e12Uf;
  private String e13Cep;
  private String e14Cpais;
  private String e15Xpais;
  private String e16Fone;
  private String e17Ie;
  private String e18Isuf;
  private String e19Email;
  private String e20indEDest;
  private String e21IM;
  

  public Nfe_IdentificacaoDestinario()
  {
    inicializa();
  }
  public Nfe_IdentificacaoDestinario(String e02Cnpj, String e03Cpf, String e04Xnome, String e06Xlgr, String e07Nro, String e08Cpl, String e09Xbairro, String e10Cmun, String e11Xmun, String e12Uf, String e13Cep, String e14Cpais, String e15Xpais, String e16Fone, String e17Ie, String e18Isuf, String e19Email, String e08Xcpl, String e21IM, String e20indEDest) {
    this.e02Cnpj = e02Cnpj;
    this.e03Cpf = e03Cpf;
    this.e04Xnome = e04Xnome;
    this.e06Xlgr = e06Xlgr;
    this.e07Nro = e07Nro;
    this.e08Cpl = e08Cpl;
    this.e09Xbairro = e09Xbairro;
    this.e10Cmun = e10Cmun;
    this.e11Xmun = e11Xmun;
    this.e12Uf = e12Uf;
    this.e13Cep = e13Cep;
    this.e14Cpais = e14Cpais;
    this.e15Xpais = e15Xpais;
    this.e16Fone = e16Fone;
    this.e17Ie = e17Ie;
    this.e18Isuf = e18Isuf;
    this.e19Email = e19Email;
    this.e08Xcpl = e08Xcpl;
    this.e20indEDest = e20indEDest;
    this.e21IM = e21IM;
  }

  private void inicializa() {
    this.e02Cnpj = "";
    this.e03Cpf = "";
    this.e04Xnome = "";
    this.e06Xlgr = "";
    this.e07Nro = "";
    this.e08Cpl = "";
    this.e09Xbairro = "";
    this.e10Cmun = "";
    this.e11Xmun = "";
    this.e12Uf = "";
    this.e13Cep = "";
    this.e14Cpais = "";
    this.e15Xpais = "";
    this.e16Fone = "";
    this.e17Ie = "";
    this.e18Isuf = "";
    this.e19Email = "";
    this.e08Xcpl = "";
    this.e20indEDest =  "";
    this.e21IM = "";
  }

  public String getE02Cnpj() {
    return this.e02Cnpj;
  }

  public void setE02Cnpj(String e02Cnpj) {
    this.e02Cnpj = e02Cnpj;
  }
  public String getE03Cpf() {
    return this.e03Cpf;
  }

  public void setE03Cpf(String e03Cpf) {
    this.e03Cpf = e03Cpf;
  }
  public String getE04Xnome() {
    return this.e04Xnome;
  }

  public void setE04Xnome(String e04Xnome) {
    this.e04Xnome = e04Xnome;
  }
  public String getE06Xlgr() {
    return this.e06Xlgr;
  }

  public void setE06Xlgr(String e06Xlgr) {
    this.e06Xlgr = e06Xlgr;
  }
  public String getE07Nro() {
    return this.e07Nro;
  }

  public void setE07Nro(String e07Nro) {
    this.e07Nro = e07Nro;
  }
  public String getE08Cpl() {
    return this.e08Cpl;
  }

  public void setE08Cpl(String e08Cpl) {
    this.e08Cpl = e08Cpl;
  }
  public String getE09Xbairro() {
    return this.e09Xbairro;
  }

  public void setE09Xbairro(String e09Xbairro) {
    this.e09Xbairro = e09Xbairro;
  }
  public String getE10Cmun() {
    return this.e10Cmun;
  }

  public void setE10Cmun(String e10Cmun) {
    this.e10Cmun = e10Cmun;
  }
  public String getE11Xmun() {
    return this.e11Xmun;
  }

  public void setE11Xmun(String e11Xmun) {
    this.e11Xmun = e11Xmun;
  }
  public String getE12Uf() {
    return this.e12Uf;
  }

  public void setE12Uf(String e12Uf) {
    this.e12Uf = e12Uf;
  }
  public String getE13Cep() {
    return this.e13Cep;
  }

  public void setE13Cep(String e13Cep) {
    this.e13Cep = e13Cep;
  }
  public String getE14Cpais() {
    return this.e14Cpais;
  }

  public void setE14Cpais(String e14Cpais) {
    this.e14Cpais = e14Cpais;
  }
  public String getE15Xpais() {
    return this.e15Xpais;
  }

  public void setE15Xpais(String e15Xpais) {
    this.e15Xpais = e15Xpais;
  }
  public String getE16Fone() {
    return this.e16Fone;
  }

  public void setE16Fone(String e16Fone) {
    this.e16Fone = e16Fone;
  }
  public String getE17Ie() {
    return this.e17Ie;
  }

  public void setE17Ie(String e17Ie) {
    this.e17Ie = e17Ie;
  }
  public String getE18Isuf() {
    return this.e18Isuf;
  }

  public void setE18Isuf(String e18Isuf) {
    this.e18Isuf = e18Isuf;
  }
  public String getE19Email() {
    return this.e19Email;
  }

  public void setE19Email(String e19Email) {
    this.e19Email = e19Email;
  }
  public String getE08Xcpl() {
    return this.e08Xcpl;
  }

  public void setE08Xcpl(String e08Xcpl) {
    this.e08Xcpl = e08Xcpl;
  }

    public String getE20indEDest() {
        return e20indEDest;
    }

    public void setE20indEDest(String e20indEDest) {
        this.e20indEDest = e20indEDest;
    }

    public String getE21IM() {
        return e21IM;
    }

    public void setE21IM(String e21IM) {
        this.e21IM = e21IM;
    }
  
}
