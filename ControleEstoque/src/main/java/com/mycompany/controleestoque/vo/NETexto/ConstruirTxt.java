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
public class ConstruirTxt {

    public String NfeDados(Nfe_Dados a) {
        String linha = "A|" + a.getA02Versao() + "|" + a.getA03Id() + "|" + a.getA04pk_nItem() + "|" + System.getProperty("line.separator");

        return linha;
    }

    private String preencheComZeros(String str) {
        for (int i = str.length(); i < 8; i++) {
            str = "0" + str;
        }
        return str;
    }

    public String NfeIdentificacao(Nfe_Identificacao b) {
        String linha = "";

        linha = "B|" + b.getB02cUF() + "|" + b.getB03cNF()+ "|" + b.getB04natOp() + "|" + b.getB05indPag() + "|" + b.getB06mod() + "|" + b.getB07serie() 
                + "|" + lpadTo(b.getB08nNF(), 9, ' ') + "|" + b.getB09dhEmi() + "|" + b.getB10dhSaiEnt() + "|" + b.getB11tpNF() + "|" + b.getB12idDest() + "|" + b.getB13cMunFG()
                + "|" + b.getB14tpImp() + "|" + b.getB15tpEmis() + "|" + b.getB16cDV() + "|" + b.getB17tpAmb() + "|" + b.getB18finNFe() + "|" + b.getB19indFinal()
                + "|" + b.getB20indPres() + "|" + b.getB21procEmi() + "|" + b.getB22verProc() + "|" + b.getB23dhCont() + "|" + b.getB24xJust() + "|"
                + System.getProperty("line.separator");

//        if ((b.getB13Refnfe() != null) && (!b.getB13Refnfe().isEmpty())) {
//            linha = linha + "B13|" + b.getB13Refnfe() + System.getProperty("line.separator");
//        } else if ((b.getB15Cuf() != null) && (!b.getB15Cuf().isEmpty())) {
//            linha = linha + "B14|" + b.getB13Refnfe() + "|" + b.getB16Aamm() + "|" + b.getB17Cnpj() + "|" + b.getB18Mod() + "|" + b.getB19Serie() + "|" + b.getB20Nnf() + System.getProperty("line.separator");
//        } else if ((b.getB20bCuf() != null) && (!b.getB20bCuf().isEmpty())) {
//            linha = linha + "B20a|" + b.getB20bCuf() + "|" + b.getB20cAamm() + "|" + b.getB20fIe() + "|" + b.getB20fMod() + "|" + b.getB20gSerie() + "|" + b.getB20hNnf() + System.getProperty("line.separator");
//
//            if ((b.getB20dCnpj() != null) && (!b.getB20dCnpj().isEmpty())) {
//                linha = linha + "B20d|" + b.getB20dCnpj() + System.getProperty("line.separator");
//            } else if ((b.getB20eCpf() != null) && (!b.getB20eCpf().isEmpty())) {
//                linha = linha + "B20e|" + b.getB20eCpf() + System.getProperty("line.separator");
//            }
//        } else if ((b.getB20iRefcte() != null) && (!b.getB20iRefcte().isEmpty())) {
//            linha = linha + "B20i|" + b.getB20iRefcte() + System.getProperty("line.separator");
//        } else if ((b.getB20kMod() != null) && (!b.getB20kMod().isEmpty())) {
//            linha = linha + "B20j|" + b.getB20kMod() + "|" + b.getB20lNecf() + "|" + b.getB20mNcoo() + System.getProperty("line.separator");
//        }

        return linha;
    }

    public String NfeIdentificacaoEmitente(Nfe_IdentificacaoEmitente c) {
        String linha = "C|" + c.getC03Xnome() + "|" + c.getC04Xfant() + "|" + c.getC17Ie() + "|" + c.getC18Iest() + "|" + c.getC19Im() + "|" + c.getC20Cnae() + "|" + c.getC21Crt() +  "|" + System.getProperty("line.separator");

        if ((c.getC02Cnpj() != null) && (!c.getC02Cnpj().isEmpty())) {
            linha = linha + "C02|" + c.getC02Cnpj() + "|" + System.getProperty("line.separator");
        } else {
            linha = linha + "C02a|" + c.getC02aCpf() + "|" + System.getProperty("line.separator");
        }

        linha = linha + "C05|" + c.getC06Xlgr() + "|" + c.getC07Nro() + "|"  + c.getC08Xcpl() + "|" + c.getC09Bairro() + "|" + c.getC10Cmun() + "|" + c.getC11Xmun() + "|" + c.getC12Uf() + "|" + c.getC13Cep() + "|" + c.getC14Cpais() + "|" + c.getC15Xpais() + "|" + c.getC16Fone() + "|" + System.getProperty("line.separator");

        return linha;
    }

    public String NfeIdentificacaoDestinario(Nfe_IdentificacaoDestinario e) {
        String linha = "E|" + e.getE04Xnome() + "|" + e.getE20indEDest() + "|" + e.getE17Ie() + "|" + e.getE18Isuf() + "|" + e.getE21IM() + "|"+ e.getE19Email() + "|" + System.getProperty("line.separator");

        if ((e.getE02Cnpj() != null) && (!e.getE02Cnpj().isEmpty())) {
            linha = linha + "E02|" + e.getE02Cnpj() + "|" + System.getProperty("line.separator");
        } else {
            linha = linha + "E03|" + e.getE03Cpf() + "|" + System.getProperty("line.separator");
        }

        linha = linha + "E05|" + e.getE06Xlgr() + "|" + e.getE07Nro() + "|" + e.getE08Cpl() + "|" + e.getE09Xbairro() + "|" + e.getE10Cmun() + "|" + e.getE11Xmun() + "|" + e.getE12Uf() + "|" + e.getE13Cep() + "|" + e.getE14Cpais() + "|" + e.getE15Xpais() + "|" + e.getE16Fone() + "|" + System.getProperty("line.separator");

        return linha;
    }

    public String NfeIdentificacaoRetirada(Nfe_IdentificacaoRetirada f) {
        String linha = "F|" + f.getF03Xlgr() + "|" + f.getF04Nro() + "|" + f.getF05Xcpl() + "|" + f.getF06Xbairro() + "|" + f.getF07Cmun() + "|" + f.getF08Xmun() + "|" + f.getF09Uf() + System.getProperty("line.separator");

        if ((f.getF02Cnpj() != null) && (!f.getF02Cnpj().isEmpty())) {
            linha = linha + "F02|" + f.getF02Cnpj() + System.getProperty("line.separator");
        } else {
            linha = linha + "F02a|" + f.getF02aCpf() + System.getProperty("line.separator");
        }

        return linha;
    }

    public String NfeIdentificacaoEntrega(Nfe_IdentificacaoEntrega g) {
        String linha = "G|" + g.getG03Xlgr() + "|" + g.getG04Nro() + "|" + g.getG05Xcpl() + "|" + g.getG06Xbairro() + "|" + g.getG07Cmun() + "|" + g.getG08Xmun() + "|" + g.getG09Uf() + System.getProperty("line.separator");

        if ((g.getG02Cnpj() != null) && (!g.getG02Cnpj().isEmpty())) {
            linha = linha + "G02|" + g.getG02Cnpj() + System.getProperty("line.separator");
        } else {
            linha = linha + "G02a|" + g.getG02aCpf() + System.getProperty("line.separator");
        }

        return linha;
    }

    public String NfeProdutosServicos(Nfe_ProdutosServicos i) {
        String linha = "";

        if ((i.getH02Nitem() != null) && (!i.getH02Nitem().isEmpty())) {
            linha = linha + "H|" + i.getH02Nitem() + "|" + i.getH03InfAdProd() + System.getProperty("line.separator");
        }

        if ((i.getI02Cprod() != null) && (!i.getI02Cprod().isEmpty())) {
            linha = linha + "I|" + i.getI02Cprod() + "|" + i.getI03Cean() + "|" + i.getI04Xprod() + "|" + i.getI05Ncm() + "|" + i.getI06Extipi() + "|" + i.getI08Cfop() + "|" + i.getI09Ucom() + "|" + i.getI10Qcom() + "|" + i.getI10aVuncom() + "|" + i.getI11Vprod() + "|" + i.getI12Ceantrib() + "|" + i.getI13Utrib() + "|" + i.getI14Qtrib() + "|" + i.getI14aVuntrib() + "|" + i.getI15Vfrete() + "|" + i.getI16Vseg() + "|" + i.getI17Vdesc() + "|" + i.getI17aVoutro() + "|" + i.getI17bIndtot() + "|" + i.getI30Xped() + "|" + i.getI31Nitemped() + System.getProperty("line.separator");
        }

        if ((i.getI19Ndi() != null) && (!i.getI19Ndi().isEmpty())) {
            linha = linha + "I18|" + i.getI19Ndi() + "|" + i.getI20Ddi() + "|" + i.getI21Xlocdesemb() + "|" + i.getI22Ufdesemb() + "|" + i.getI23Ddesemb() + "|" + i.getI24Cexportador() + System.getProperty("line.separator");

            if ((i.getI26Nadicao() != null) && (!i.getI26Nadicao().isEmpty())) {
                linha = linha + "I25|" + i.getI26Nadicao() + "|" + i.getI27Nseqadic() + "|" + i.getI28Cfabricante() + "|" + i.getI29Vdescdi() + System.getProperty("line.separator");
            }

        }

        return linha;
    }

    public String NfeDetalhamentoVeiculos(Nfe_DetalhamentoVeiculos j) {
        String linha = "J|" + j.getJ02Tpop() + "|" + j.getJ03Chassi() + "|" + j.getJ04Ccor() + "|" + j.getJ05Xcor() + "|" + j.getJ06Pot() + "|" + j.getJ07Cilin() + "|" + j.getJ08Pesol() + "|" + j.getJ09Pesob() + "|" + j.getJ10Nserie() + "|" + j.getJ11Tpcomb() + "|" + j.getJ12Nmotor() + "|" + j.getJ13Cmt() + "|" + j.getJ14Dist() + "|" + j.getJ16Anomod() + "|" + j.getJ17Anofab() + "|" + j.getJ18Tppint() + "|" + j.getJ19Tpveic() + "|" + j.getJ20Espveic() + "|" + j.getJ21Vin() + "|" + j.getJ22Condveic() + "|" + j.getJ23Cmod() + "|" + j.getJ24Ccordenatran() + "|" + j.getJ25Lota() + "|" + j.getJ26Tprest() + System.getProperty("line.separator");

        return linha;
    }

    public String NfeDetalhamentoMedicamentos(Nfe_DetalhamentoMedicamentos k) {
        String linha = "K|" + k.getK02Nlote() + "|" + k.getK03Qlote() + "|" + k.getK04Dfab() + "|" + k.getK05Dval() + "|" + k.getK06Vpmc() + System.getProperty("line.separator");

        return linha;
    }

    public String NfeDetalhamentoArmamentos(Nfe_DetalhamentoArmamentos l) {
        String linha = "L|" + l.getL02Tparma() + "|" + l.getL03Nserie() + "|" + l.getL04Ncano() + "|" + l.getL05Descr() + System.getProperty("line.separator");

        return linha;
    }

    public String NfeDetalhamentoCombustiveis(Nfe_DetalhamentoCombustiveis l1) {
        String linha = "L101|" + l1.getL102Cprodanp() + "|" + l1.getL103Codig() + "|" + l1.getL104Qtemp() + "|" + l1.getL120Ufcons() + System.getProperty("line.separator");

        if ((l1.getL106Qbcprod() != null) && (!l1.getL106Qbcprod().isEmpty())) {
            linha = linha + "L105|" + l1.getL106Qbcprod() + "|" + l1.getL107Valiqprod() + "|" + l1.getL108Vcide() + System.getProperty("line.separator");
        }

        return linha;
    }

    public String NfeIcms(Nfe_Icms n) {
        String linha = "M" + System.getProperty("line.separator");

        linha = linha + "N" + System.getProperty("line.separator");

        if (n.getN12Cst().equals("00")) {
            linha = linha + "N02|" + n.getN11Orig() + "|" + n.getN12Cst() + "|" + n.getN13Modbc() + "|" + n.getN15Vbc() + "|" + n.getN16Picms() + "|" + n.getN17Vicms() + System.getProperty("line.separator");
        } else if (n.getN12Cst().equals("10")) {
            linha = linha + "N03|" + n.getN11Orig() + "|" + n.getN12Cst() + "|" + n.getN13Modbc() + "|" + n.getN15Vbc() + "|" + n.getN16Picms() + "|" + n.getN17Vicms() + "|" + n.getN18Modbcst() + "|" + n.getN19Pmvast() + "|" + n.getN20Predbcst() + "|" + n.getN21Vbcst() + "|" + n.getN22Picmsst() + "|" + n.getN23Vicmsst() + System.getProperty("line.separator");
        } else if (n.getN12Cst().equals("20")) {
            linha = linha + "N04|" + n.getN11Orig() + "|" + n.getN12Cst() + "|" + n.getN13Modbc() + "|" + n.getN14Predbc() + "|" + n.getN15Vbc() + "|" + n.getN16Picms() + "|" + n.getN17Vicms() + System.getProperty("line.separator");
        } else if (n.getN12Cst().equals("30")) {
            linha = linha + "N05|" + n.getN11Orig() + "|" + n.getN12Cst() + "|" + n.getN18Modbcst() + "|" + n.getN19Pmvast() + "|" + n.getN20Predbcst() + "|" + n.getN21Vbcst() + "|" + n.getN22Picmsst() + "|" + n.getN23Vicmsst() + System.getProperty("line.separator");
        } else if ((n.getN12Cst().equals("40")) || (n.getN12Cst().equals("41")) || (n.getN12Cst().equals("50"))) {
            linha = linha + "N06|" + n.getN11Orig() + "|" + n.getN12Cst() + "|" + n.getN17Vicms() + "|" + n.getN28Motdesicms() + System.getProperty("line.separator");
        } else if (n.getN12Cst().equals("51")) {
            linha = linha + "N07|" + n.getN11Orig() + "|" + n.getN12Cst() + "|" + n.getN13Modbc() + "|" + n.getN14Predbc() + "|" + n.getN15Vbc() + "|" + n.getN16Picms() + "|" + n.getN17Vicms() + System.getProperty("line.separator");
        } else if (n.getN12Cst().equals("60")) {
            linha = linha + "N08|" + n.getN11Orig() + "|" + n.getN12Cst() + "|" + n.getN21Vbcst() + "|" + n.getN23Vicmsst() + System.getProperty("line.separator");
        } else if (n.getN12Cst().equals("70")) {
            linha = linha + "N09|" + n.getN11Orig() + "|" + n.getN12Cst() + "|" + n.getN13Modbc() + "|" + n.getN14Predbc() + "|" + n.getN15Vbc() + "|" + n.getN16Picms() + "|" + n.getN17Vicms() + "|" + n.getN18Modbcst() + "|" + n.getN19Pmvast() + "|" + n.getN20Predbcst() + "|" + n.getN21Vbcst() + "|" + n.getN22Picmsst() + "|" + n.getN23Vicmsst() + System.getProperty("line.separator");
        } else if (n.getN12Cst().equals("90")) {
            linha = linha + "N10|" + n.getN11Orig() + "|" + n.getN12Cst() + "|" + n.getN13Modbc() + "|" + n.getN14Predbc() + "|" + n.getN15Vbc() + "|" + n.getN16Picms() + "|" + n.getN17Vicms() + "|" + n.getN18Modbcst() + "|" + n.getN19Pmvast() + "|" + n.getN20Predbcst() + "|" + n.getN21Vbcst() + "|" + n.getN22Picmsst() + "|" + n.getN23Vicmsst() + System.getProperty("line.separator");
        } else if ((n.getN12Cst().toUpperCase().equals("10A")) || (n.getN12Cst().toUpperCase().equals("90A"))) {
            linha = linha + "N10a|" + n.getN11Orig() + "|" + n.getN12Cst() + "|" + n.getN13Modbc() + "|" + n.getN14Predbc() + "|" + n.getN15Vbc() + "|" + n.getN16Picms() + "|" + n.getN17Vicms() + "|" + n.getN18Modbcst() + "|" + n.getN19Pmvast() + "|" + n.getN20Predbcst() + "|" + n.getN21Vbcst() + "|" + n.getN22Picmsst() + "|" + n.getN23Vicmsst() + "|" + n.getN25Pbcop() + "|" + n.getN24Ufst() + System.getProperty("line.separator");
        } else if (n.getN12Cst().toUpperCase().equals("41B")) {
            linha = linha + "N10b|" + n.getN11Orig() + "|" + n.getN12Cst() + "|" + n.getN26Vbcstret() + "|" + n.getN27Vicmsstret() + "|" + n.getN31Vbcstdest() + "|" + n.getN32Vicmsstdest() + System.getProperty("line.separator");
        } else if (n.getN12ACSosn().equals("101")) {
            linha = linha + "N10c|" + n.getN11Orig() + "|" + n.getN12ACSosn() + "|" + n.getN29Pcredsn() + "|" + n.getN30Vcredicmssn() + System.getProperty("line.separator");
        } else if ((n.getN12ACSosn().equals("102")) || (n.getN12ACSosn().equals("103")) || (n.getN12ACSosn().equals("300")) || (n.getN12ACSosn().equals("400"))) {
            linha = linha + "N10d|" + n.getN11Orig() + "|" + n.getN12ACSosn() + System.getProperty("line.separator");
        } else if (n.getN12ACSosn().equals("201")) {
            linha = linha + "N10e|" + n.getN11Orig() + "|" + n.getN12ACSosn() + "|" + n.getN18Modbcst() + "|" + n.getN19Pmvast() + "|" + n.getN20Predbcst() + "|" + n.getN21Vbcst() + "|" + n.getN22Picmsst() + "|" + n.getN23Vicmsst() + "|" + n.getN29Pcredsn() + "|" + n.getN30Vcredicmssn() + System.getProperty("line.separator");
        } else if ((n.getN12ACSosn().equals("202")) || (n.getN12ACSosn().equals("203"))) {
            linha = linha + "N10f|" + n.getN11Orig() + "|" + n.getN12ACSosn() + "|" + n.getN18Modbcst() + "|" + n.getN19Pmvast() + "|" + n.getN20Predbcst() + "|" + n.getN21Vbcst() + "|" + n.getN22Picmsst() + "|" + n.getN23Vicmsst() + System.getProperty("line.separator");
        } else if (n.getN12ACSosn().equals("500")) {
            linha = linha + "N10g|" + n.getN11Orig() + "|" + n.getN12ACSosn() + "|" + n.getN18Modbcst() + "|" + n.getN26Vbcstret() + "|" + n.getN27Vicmsstret() + System.getProperty("line.separator");
        } else if (n.getN12ACSosn().equals("900")) {
            linha = linha + "N10h|" + n.getN11Orig() + "|" + n.getN12ACSosn() + "|" + n.getN13Modbc() + "|" + n.getN15Vbc() + "|" + n.getN14Predbc() + "|" + n.getN16Picms() + "|" + n.getN17Vicms() + "|" + n.getN18Modbcst() + "|" + n.getN19Pmvast() + "|" + n.getN20Predbcst() + "|" + n.getN21Vbcst() + "|" + n.getN22Picmsst() + "|" + n.getN23Vicmsst() + "|" + n.getN29Pcredsn() + "|" + n.getN30Vcredicmssn() + System.getProperty("line.separator");
        }

        return linha;
    }

    public String NfeImpostoProdIndustria(Nfe_ImpostoProdIndustria o) {
        String linha = "O|" + o.getO02Clenq() + "|" + o.getO03Cnpjprod() + "|" + o.getO04Cselo() + "|" + o.getO05Qselo() + "|" + o.getO06Cenq() + System.getProperty("line.separator");

        if ((o.getO09Cst().equals("00")) || (o.getO09Cst().equals("49")) || (o.getO09Cst().equals("50")) || (o.getO09Cst().equals("99"))) {
            linha = linha + "O07|" + o.getO09Cst() + "|" + o.getO14Vipi() + System.getProperty("line.separator");

            if ((o.getO10Vbc() != null) && (!o.getO10Vbc().isEmpty())) {
                linha = linha + "O10|" + o.getO10Vbc() + "|" + o.getO14Vipi() + System.getProperty("line.separator");
            } else if ((o.getO11Qunid() != null) && (!o.getO11Qunid().isEmpty())) {
                linha = linha + "O11|" + o.getO11Qunid() + "|" + o.getO12Vunid() + System.getProperty("line.separator");
            }

        } else if ((o.getO09Cst().equals("01")) || (o.getO09Cst().equals("02")) || (o.getO09Cst().equals("03")) || (o.getO09Cst().equals("04")) || (o.getO09Cst().equals("51")) || (o.getO09Cst().equals("52")) || (o.getO09Cst().equals("53")) || (o.getO09Cst().equals("54")) || (o.getO09Cst().equals("55"))) {
            linha = linha + "O08|" + o.getO09Cst() + System.getProperty("line.separator");
        }

        return linha;
    }

    public String NfeImpostoImportacao(Nfe_ImpostoImportacao p) {
        String linha = "P|" + p.getP02Vbc() + "|" + p.getP03Vdespadu() + "|" + p.getP04Vii() + "|" + p.getP05Viof() + System.getProperty("line.separator");

        return linha;
    }

    public String NfePis(Nfe_Pis q) {
        String linha = "Q" + System.getProperty("line.separator");

        if ((q.getQ06Cst().equals("01")) || (q.getQ06Cst().equals("02"))) {
            linha = linha + "Q02|" + q.getQ06Cst() + "|" + q.getQ07Vbc() + "|" + q.getQ08Ppis() + "|" + q.getQ09Vpis() + System.getProperty("line.separator");
        } else if (q.getQ06Cst().equals("03")) {
            linha = linha + "Q03|" + q.getQ06Cst() + "|" + q.getQ10Qbcprod() + "|" + q.getQ11Valiqprod() + "|" + q.getQ09Vpis() + System.getProperty("line.separator");
        } else if ((q.getQ06Cst().equals("04")) || (q.getQ06Cst().equals("06")) || (q.getQ06Cst().equals("07")) || (q.getQ06Cst().equals("08")) || (q.getQ06Cst().equals("09"))) {
            linha = linha + "Q04|" + q.getQ06Cst() + System.getProperty("line.separator");
        } else if (q.getQ06Cst().equals("99")) {
            linha = linha + "Q05|" + q.getQ06Cst() + "|" + q.getQ09Vpis() + System.getProperty("line.separator");

            if ((q.getQ07Vbc() != null) && (!q.getQ07Vbc().isEmpty())) {
                linha = linha + "Q07|" + q.getQ07Vbc() + "|" + q.getQ08Ppis() + System.getProperty("line.separator");
            } else if ((q.getQ10Qbcprod() != null) && (!q.getQ10Qbcprod().isEmpty())) {
                linha = linha + "Q10|" + q.getQ10Qbcprod() + "|" + q.getQ11Valiqprod() + System.getProperty("line.separator");
            }

        }

        return linha;
    }

    public String NfePisSt(Nfe_PisSt r) {
        String linha = "R|" + r.getR06Vpis() + System.getProperty("line.separator");

        if ((r.getR02Vbc() != null) && (!r.getR02Vbc().isEmpty())) {
            linha = linha + "R02|" + r.getR02Vbc() + "|" + r.getR03Ppis() + System.getProperty("line.separator");
        } else if ((r.getR04Qbcprod() != null) && (!r.getR04Qbcprod().isEmpty())) {
            linha = linha + "R03|" + r.getR04Qbcprod() + "|" + r.getR05Valiqprod() + System.getProperty("line.separator");
        }

        return linha;
    }

    public String NfeConfins(Nfe_Confins s) {
        String linha = "S" + System.getProperty("line.separator");

        if ((s.getS06Cst().equals("01")) || (s.getS06Cst().equals("02"))) {
            linha = linha + "S02|" + s.getS06Cst() + "|" + s.getS07Vbc() + "|" + s.getS08Pconfins() + "|" + s.getS11Vconfins() + System.getProperty("line.separator");
        } else if (s.getS06Cst().equals("03")) {
            linha = linha + "S03|" + s.getS06Cst() + "|" + s.getS09Qbcprod() + "|" + s.getS10Valiqprod() + "|" + s.getS11Vconfins() + System.getProperty("line.separator");
        } else if ((s.getS06Cst().equals("04")) || (s.getS06Cst().equals("06")) || (s.getS06Cst().equals("07")) || (s.getS06Cst().equals("08")) || (s.getS06Cst().equals("09"))) {
            linha = linha + "S04|" + s.getS06Cst() + System.getProperty("line.separator");
        } else if (s.getS06Cst().equals("99")) {
            linha = linha + "S05|" + s.getS06Cst() + "|" + s.getS11Vconfins() + System.getProperty("line.separator");

            if ((s.getS07Vbc() != null) && (!s.getS07Vbc().isEmpty())) {
                linha = linha + "S07|" + s.getS07Vbc() + "|" + s.getS08Pconfins() + System.getProperty("line.separator");
            } else if ((s.getS07Vbc() != null) && (!s.getS07Vbc().isEmpty())) {
                linha = linha + "S09||" + s.getS09Qbcprod() + "|" + s.getS10Valiqprod() + System.getProperty("line.separator");
            }

        }

        return linha;
    }

    public String NfeConfinsSt(Nfe_ConfinsSt t) {
        String linha = "T|" + t.getT06Vconfins() + System.getProperty("line.separator");

        if ((t.getT02Vbc() != null) && (!t.getT02Vbc().isEmpty())) {
            linha = linha + "T02|" + t.getT02Vbc() + "|" + t.getT03Pconfins() + System.getProperty("line.separator");
        } else if ((t.getT04Qbcprod() != null) && (!t.getT04Qbcprod().isEmpty())) {
            linha = linha + "T03|" + t.getT04Qbcprod() + "|" + t.getT05Valiqprod() + System.getProperty("line.separator");
        }

        return linha;
    }

    public String NfeIssqn(Nfe_Issqn u) {
        String linha = "M" + System.getProperty("line.separator");

        linha = linha + "U|" + u.getU02Vbc() + "|" + u.getU03Valiq() + "|" + u.getU04Vissqn() + "|" + u.getU05Cmunfg() + "|" + u.getU06Clistserv() + "|" + u.getU07Csittrib() + System.getProperty("line.separator");

        return linha;
    }

    public String NfeValoresTotais(Nfe_ValoresTotais w) {
        String linha = "W" + System.getProperty("line.separator");

        if ((w.getW03Vbc() != null) && (!w.getW03Vbc().isEmpty())) {
            linha = linha + "W02|" + w.getW03Vbc() + "|" + w.getW04Vicms() + "|" + w.getW05Vbcst() + "|" + w.getW06Vst() + "|" + w.getW07Vprod() + "|" + w.getW08Vfrete() + "|" + w.getW09Vseg() + "|" + w.getW10Vdesc() + "|" + w.getW11Vii() + "|" + w.getW12Vipi() + "|" + w.getW13Pis() + "|" + w.getW14Vconfins() + "|" + w.getW15Voutro() + "|" + w.getW16Vnf() + System.getProperty("line.separator");
        }

        if (((w.getW18Vserv() != null) && (!w.getW18Vserv().isEmpty())) || ((w.getW19Vbc() != null) && (!w.getW19Vbc().isEmpty())) || ((w.getW20Viss() != null) && (!w.getW20Viss().isEmpty())) || ((w.getW21Vpis() != null) && (!w.getW21Vpis().isEmpty())) || ((w.getW22Vconfins() != null) && (!w.getW22Vconfins().isEmpty()))) {
            linha = linha + "W17|" + w.getW18Vserv() + "|" + w.getW19Vbc() + "|" + w.getW20Viss() + "|" + w.getW21Vpis() + "|" + w.getW22Vconfins() + System.getProperty("line.separator");
        }

        if (((w.getW24Vretpis() != null) && (!w.getW24Vretpis().isEmpty())) || ((w.getW25Vretconfins() != null) && (!w.getW25Vretconfins().isEmpty())) || ((w.getW26Vretcsll() != null) && (!w.getW26Vretcsll().isEmpty())) || ((w.getW27Vbcirrf() != null) && (!w.getW27Vbcirrf().isEmpty())) || ((w.getW28Virrf() != null) && (!w.getW28Virrf().isEmpty())) || ((w.getW29Vbcretprev() != null) && (!w.getW29Vbcretprev().isEmpty())) || ((w.getW30Vretprev() != null) && (!w.getW30Vretprev().isEmpty()))) {
            linha = linha + "W23|" + w.getW24Vretpis() + "|" + w.getW25Vretconfins() + "|" + w.getW26Vretcsll() + "|" + w.getW27Vbcirrf() + "|" + w.getW28Virrf() + "|" + w.getW29Vbcretprev() + "|" + w.getW30Vretprev() + System.getProperty("line.separator");
        }

        return linha;
    }

    public String NfeInformacoesTransporte(Nfe_InformacoesTransporte x) {
        String linha = "X|" + x.getX02Modfrete() +  "|" + System.getProperty("line.separator");

        if (((x.getX04Cnpj() != null) && (!x.getX04Cnpj().isEmpty())) || ((x.getX05Cpf() != null) && (!x.getX05Cpf().isEmpty())) || ((x.getX07Ie() != null) && (!x.getX07Ie().isEmpty())) || ((x.getX08Xender() != null) && (!x.getX08Xender().isEmpty())) || ((x.getX09Xmun() != null) && (!x.getX09Xmun().isEmpty())) || ((x.getX10Uf() != null) && (!x.getX10Uf().isEmpty()))) {
            linha = linha + "X03|" + x.getX06Xnome() + "|" + x.getX07Ie() + "|" + x.getX08Xender() + "|" + x.getX10Uf() + "|" + x.getX09Xmun() + System.getProperty("line.separator");

            if ((x.getX04Cnpj() != null) && (!x.getX04Cnpj().isEmpty())) {
                linha = linha + "X04|" + x.getX04Cnpj() + System.getProperty("line.separator");
            } else if ((x.getX05Cpf() != null) && (!x.getX05Cpf().isEmpty())) {
                linha = linha + "X05|" + x.getX05Cpf() + System.getProperty("line.separator");
            }

        }

        if ((x.getX12Vserv() != null) && (!x.getX12Vserv().isEmpty())) {
            linha = linha + "X11|" + x.getX12Vserv() + "|" + x.getX13Vbcret() + "|" + x.getX14Picmsret() + "|" + x.getX15Vicmsret() + "|" + x.getX16Cfop() + "|" + x.getX17Cmunfg() + System.getProperty("line.separator");
        }

        if ((x.getX19Placa() != null) && (!x.getX19Placa().isEmpty())) {
            linha = linha + "X18|" + x.getX19Placa() + "|" + x.getX20Uf() + "|" + x.getX21Rntc() + System.getProperty("line.separator");
        }

        if ((x.getX23Placa() != null) && (!x.getX23Placa().isEmpty())) {
            linha = linha + "X22|" + x.getX23Placa() + "|" + x.getX24Uf() + "|" + x.getX25Rntc() + System.getProperty("line.separator");
        }

        if (((x.getX27Qvol() != null) && (!x.getX27Qvol().isEmpty())) || ((x.getX28Esp() != null) && (!x.getX28Esp().isEmpty())) || ((x.getX29Marca() != null) && (!x.getX29Marca().isEmpty())) || ((x.getX30Nvol() != null) && (!x.getX30Nvol().isEmpty())) || ((x.getX31Pesol() != null) && (!x.getX31Pesol().isEmpty())) || ((x.getX32Pesob() != null) && (!x.getX32Pesob().isEmpty()))) {
            linha = linha + "X26|" + x.getX27Qvol() + "|" + x.getX28Esp() + "|" + x.getX29Marca() + "|" + x.getX30Nvol() + "|" + x.getX31Pesol() + "|" + x.getX32Pesob() + System.getProperty("line.separator");

            if ((x.getX34Nlacre() != null) && (!x.getX34Nlacre().isEmpty())) {
                linha = linha + "X33|" + x.getX34Nlacre() + System.getProperty("line.separator");
            }

        }

        return linha;
    }

    public String NfeDadosCobranc(Nfe_DadosCobranca y) {
        String linha = "Y|" + System.getProperty("line.separator");

        if (((y.getY03Nfat() != null) && (!y.getY03Nfat().isEmpty())) || ((y.getY04Vorig() != null) && (!y.getY04Vorig().isEmpty())) || ((y.getY05Vdesc() != null) && (!y.getY05Vdesc().isEmpty())) || ((y.getY06Vliq() != null) && (!y.getY06Vliq().isEmpty()))) {
            linha = linha + "Y02|" + y.getY03Nfat() + "|" + y.getY04Vorig() + "|" + y.getY05Vdesc() + "|" + y.getY06Vliq() + System.getProperty("line.separator");
        }

        if (((y.getY08Ndup() != null) && (!y.getY08Ndup().isEmpty())) || ((y.getY09Dvenc() != null) && (!y.getY09Dvenc().isEmpty())) || ((y.getY10Vdup() != null) && (!y.getY10Vdup().isEmpty()))) {
            linha = linha + "Y07|" + y.getY08Ndup() + "|" + y.getY09Dvenc() + "|" + y.getY10Vdup() + System.getProperty("line.separator");
        }

        return linha;
    }

    public String NfeInformacoesAdicionais(Nfe_InformacoesAdicionais z) {
        String linha = "Z" + z.getZ02Infadfisco() + "|" + z.getZ03Infcpl() + System.getProperty("line.separator");

        if ((z.getZ05Xcampo() != null) && (!z.getZ05Xcampo().isEmpty())) {
            linha = linha + "Z04|" + z.getZ05Xcampo() + "|" + z.getZ06Xtexto() + System.getProperty("line.separator");
        }

        if ((z.getZ08Xcampo() != null) && (!z.getZ08Xcampo().isEmpty())) {
            linha = linha + "Z07|" + z.getZ08Xcampo() + "|" + z.getZ09Xtexto() + System.getProperty("line.separator");
        }

        if ((z.getZ11Nproc() != null) && (!z.getZ11Nproc().isEmpty())) {
            linha = linha + "Z10|" + z.getZ11Nproc() + "|" + z.getZ12Indproc() + System.getProperty("line.separator");
        }

        return linha;
    }

    public String NfeInformacoesExterior(Nfe_InformacoesExterior za) {
        String linha = "ZA" + za.getZa02Ufembarq() + "|" + za.getZa03Xlocembarq() + System.getProperty("line.separator");

        return linha;
    }

    public String NfeInformacoesCompras(Nfe_InformacoesCompras zb) {
        String linha = "ZB|" + zb.getZb02XNemp() + "|" + zb.getZb03Xped() + "|" + zb.getZb04Xcont() + System.getProperty("line.separator");

        return linha;
    }

    public String NfeInformacoesRegistroCana(Nfe_InformacoesRegistroCana zc) {
        String linha = "ZC01|" + zc.getZc03Safra() + "|" + zc.getZc02Ref() + "|" + zc.getZc07Qtomes() + "|" + zc.getZc08Qtotant() + "|" + zc.getZc09Qtotger() + "|" + zc.getZc13Vfor() + "|" + zc.getZc14Vtotded() + "|" + zc.getZc15Vliqfor() + System.getProperty("line.separator");

        if ((zc.getZc05Dia() != null) && (!zc.getZc05Dia().isEmpty())) {
            linha = linha + "ZC04|" + zc.getZc05Dia() + "|" + zc.getZc06Qtde() + System.getProperty("line.separator");
        }

        if ((zc.getZc11Xded() != null) && (!zc.getZc11Xded().isEmpty())) {
            linha = linha + "ZC10|" + zc.getZc11Xded() + "|" + zc.getZc12Vded() + System.getProperty("line.separator");
        }

        return linha;
    }
    
    private String lpadTo(String input, int width, char ch) {
        String strPad = "";

        StringBuilder sb = new StringBuilder(input.trim());
        while (sb.length() < width) {
            sb.insert(0, ch);
        }
        strPad = sb.toString();

        if (strPad.length() > width) {
            strPad = strPad.substring(0, width);
        }
        return strPad;
    }
}
