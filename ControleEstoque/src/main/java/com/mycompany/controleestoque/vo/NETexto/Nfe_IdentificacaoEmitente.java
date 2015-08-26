/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.mycompany.controleestoque.vo.NETexto;

import java.io.Serializable;

public class Nfe_IdentificacaoEmitente implements Serializable {

    private String c02Cnpj;
    private String c02aCpf;
    private String c03Xnome;
    private String c04Xfant;
    private String c06Xlgr;
    private String c07Nro;
    private String c08Xcpl;
    private String c09Bairro;
    private String c10Cmun;
    private String c11Xmun;
    private String c12Uf;
    private String c13Cep;
    private String c14Cpais;
    private String c15Xpais;
    private String c16Fone;
    private String c17Ie;
    private String c18Iest;
    private String c19Im;
    private String c20Cnae;
    private String c21Crt;

    public Nfe_IdentificacaoEmitente() {
        inicializa();
    }

    public Nfe_IdentificacaoEmitente(String c02Cnpj, String c02aCpf, String c03Xnome, String c04Xfant, String c06Xlgr, String c07Nro, String c08Xcpl, String c09Bairro, String c10Cmun, String c11Xmun, String c12Uf, String c13Cep, String c14Cpais, String c15Xpais, String c16Fone, String c17Ie, String c18Iest, String c19Im, String c20Cnae, String c21Crt) {
        this.c02Cnpj = c02Cnpj;
        this.c02aCpf = c02aCpf;
        this.c03Xnome = c03Xnome;
        this.c04Xfant = c04Xfant;
        this.c06Xlgr = c06Xlgr;
        this.c07Nro = c07Nro;
        this.c08Xcpl = c08Xcpl;
        this.c09Bairro = c09Bairro;
        this.c10Cmun = c10Cmun;
        this.c11Xmun = c11Xmun;
        this.c12Uf = c12Uf;
        this.c13Cep = c13Cep;
        this.c14Cpais = c14Cpais;
        this.c15Xpais = c15Xpais;
        this.c16Fone = c16Fone;
        this.c17Ie = c17Ie;
        this.c18Iest = c18Iest;
        this.c19Im = c19Im;
        this.c20Cnae = c20Cnae;
        this.c21Crt = c21Crt;
    }

    private void inicializa() {
        this.c02Cnpj = "";
        this.c02aCpf = "";
        this.c03Xnome = "";
        this.c04Xfant = "";
        this.c06Xlgr = "";
        this.c07Nro = "";
        this.c08Xcpl = "";
        this.c09Bairro = "";
        this.c10Cmun = "";
        this.c11Xmun = "";
        this.c12Uf = "";
        this.c13Cep = "";
        this.c14Cpais = "";
        this.c15Xpais = "";
        this.c16Fone = "";
        this.c17Ie = "";
        this.c18Iest = "";
        this.c19Im = "";
        this.c20Cnae = "";
        this.c21Crt = "";
    }

    public String getC02Cnpj() {
        return this.c02Cnpj;
    }

    public void setC02Cnpj(String c02Cnpj) {
        this.c02Cnpj = c02Cnpj;
    }

    public String getC02aCpf() {
        return this.c02aCpf;
    }

    public void setC02aCpf(String c02aCpf) {
        this.c02aCpf = c02aCpf;
    }

    public String getC03Xnome() {
        return this.c03Xnome;
    }

    public void setC03Xnome(String c03Xnome) {
        this.c03Xnome = c03Xnome;
    }

    public String getC04Xfant() {
        return this.c04Xfant;
    }

    public void setC04Xfant(String c04Xfant) {
        this.c04Xfant = c04Xfant;
    }

    public String getC06Xlgr() {
        return this.c06Xlgr;
    }

    public void setC06Xlgr(String c06Xlgr) {
        this.c06Xlgr = c06Xlgr;
    }

    public String getC07Nro() {
        return this.c07Nro;
    }

    public void setC07Nro(String c07Nro) {
        this.c07Nro = c07Nro;
    }

    public String getC08Xcpl() {
        return this.c08Xcpl;
    }

    public void setC08Xcpl(String c08Xcpl) {
        this.c08Xcpl = c08Xcpl;
    }

    public String getC09Bairro() {
        return this.c09Bairro;
    }

    public void setC09Bairro(String c09Bairro) {
        this.c09Bairro = c09Bairro;
    }

    public String getC10Cmun() {
        return this.c10Cmun;
    }

    public void setC10Cmun(String c10Cmun) {
        this.c10Cmun = c10Cmun;
    }

    public String getC11Xmun() {
        return this.c11Xmun;
    }

    public void setC11Xmun(String c11Xmun) {
        this.c11Xmun = c11Xmun;
    }

    public String getC12Uf() {
        return this.c12Uf;
    }

    public void setC12Uf(String c12Uf) {
        this.c12Uf = c12Uf;
    }

    public String getC13Cep() {
        return this.c13Cep;
    }

    public void setC13Cep(String c13Cep) {
        this.c13Cep = c13Cep;
    }

    public String getC14Cpais() {
        return this.c14Cpais;
    }

    public void setC14Cpais(String c14Cpais) {
        this.c14Cpais = c14Cpais;
    }

    public String getC15Xpais() {
        return this.c15Xpais;
    }

    public void setC15Xpais(String c15Xpais) {
        this.c15Xpais = c15Xpais;
    }

    public String getC16Fone() {
        return this.c16Fone;
    }

    public void setC16Fone(String c16Fone) {
        this.c16Fone = c16Fone;
    }

    public String getC17Ie() {
        return this.c17Ie;
    }

    public void setC17Ie(String c17Ie) {
        this.c17Ie = c17Ie;
    }

    public String getC18Iest() {
        return this.c18Iest;
    }

    public void setC18Iest(String c18Iest) {
        this.c18Iest = c18Iest;
    }

    public String getC19Im() {
        return this.c19Im;
    }

    public void setC19Im(String c19Im) {
        this.c19Im = c19Im;
    }

    public String getC20Cnae() {
        return this.c20Cnae;
    }

    public void setC20Cnae(String c20Cnae) {
        this.c20Cnae = c20Cnae;
    }

    public String getC21Crt() {
        return this.c21Crt;
    }

    public void setC21Crt(String c21Crt) {
        this.c21Crt = c21Crt;
    }
}
