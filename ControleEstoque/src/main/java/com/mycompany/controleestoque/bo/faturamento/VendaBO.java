package com.mycompany.controleestoque.bo.faturamento;

import com.mycompany.controleestoque.dao.faturamento.ItemVendaDAO;
import com.xpert.core.crud.AbstractBusinessObject;
import com.mycompany.controleestoque.dao.faturamento.VendaDAO;
import com.mycompany.controleestoque.modelo.cadastro.Cidade;
import com.mycompany.controleestoque.modelo.cadastro.Cliente;
import com.mycompany.controleestoque.modelo.cadastro.ContaBancaria;
import com.mycompany.controleestoque.modelo.cadastro.Estado;
import com.mycompany.controleestoque.modelo.cadastro.Loja_Filial;
import com.mycompany.controleestoque.modelo.cadastro.NaturezasDeOperacoes;
import com.mycompany.controleestoque.modelo.cadastro.Pais;
import com.mycompany.controleestoque.modelo.cadastro.SituacaoTributaria;
import com.mycompany.controleestoque.modelo.cadastro.enums.TipoDePessoa;
import com.mycompany.controleestoque.modelo.cadastro.enums.TipoInsencaoCliente;
import com.mycompany.controleestoque.modelo.faturamento.ItemVenda;
import com.mycompany.controleestoque.modelo.faturamento.NotaFiscal;
import com.xpert.core.validation.UniqueField;
import com.xpert.core.exception.BusinessException;
import java.util.List;
import javax.ejb.EJB;
import javax.ejb.Stateless;
import com.mycompany.controleestoque.modelo.faturamento.Venda;
import com.mycompany.controleestoque.vo.NETexto.ConstruirTxt;
import com.mycompany.controleestoque.vo.NETexto.Nfe_Confins;
import com.mycompany.controleestoque.vo.NETexto.Nfe_Dados;
import com.mycompany.controleestoque.vo.NETexto.Nfe_Icms;
import com.mycompany.controleestoque.vo.NETexto.Nfe_Identificacao;
import com.mycompany.controleestoque.vo.NETexto.Nfe_IdentificacaoDestinario;
import com.mycompany.controleestoque.vo.NETexto.Nfe_IdentificacaoEmitente;
import com.mycompany.controleestoque.vo.NETexto.Nfe_InformacoesAdicionais;
import com.mycompany.controleestoque.vo.NETexto.Nfe_InformacoesTransporte;
import com.mycompany.controleestoque.vo.NETexto.Nfe_Issqn;
import com.mycompany.controleestoque.vo.NETexto.Nfe_Pis;
import com.mycompany.controleestoque.vo.NETexto.Nfe_ProdutosServicos;
import com.mycompany.controleestoque.vo.NETexto.Nfe_ValoresTotais;
import com.mycompany.controleestoque.vo.SolicitacaoPedidoVO;
import com.xpert.faces.utils.FacesJasper;
import com.xpert.persistence.exception.DeleteException;
import com.xpert.persistence.query.QueryBuilder;
import java.math.BigDecimal;
import java.math.RoundingMode;
import java.text.DecimalFormat;
import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.util.ArrayList;
import java.util.Currency;
import java.util.Date;
import java.util.HashMap;
import javax.faces.context.FacesContext;
import javax.swing.text.MaskFormatter;
import org.hibernate.engine.internal.ForeignKeys;

/**
 *
 * @author juniel
 */
@Stateless
public class VendaBO extends AbstractBusinessObject<Venda> {

    @EJB
    private VendaDAO vendaDAO;

    @EJB
    private ItemVendaDAO itemDAO;

    @Override
    public List<UniqueField> getUniqueFields() {
        return null;
    }

    @Override
    public VendaDAO getDAO() {
        return vendaDAO;
    }

    @Override
    public void validate(Venda venda) throws BusinessException {
        if (venda.getItensVenda().isEmpty() || venda.getItensVenda() == null) {
            throw new BusinessException("Produto é obrigatório!");
        }
    }

    @Override
    public boolean isAudit() {
        return true;
    }

    @Override
    public void delete(Object id) throws DeleteException {
        Venda venda = vendaDAO.find(id);

        for (ItemVenda item : venda.getItensVenda()) {
            itemDAO.delete(item.getId());
        }

        super.delete(id); //To change body of generated methods, choose Tools | Templates.
    }

    public String gerarTxtNota(Venda venda, String numNota, String numChaveAcesso) {
        String corpo = gerarCabecalho();

        Nfe_Dados a = new Nfe_Dados();
        Nfe_Identificacao b = new Nfe_Identificacao();
        Nfe_IdentificacaoEmitente c = new Nfe_IdentificacaoEmitente();
        Nfe_IdentificacaoDestinario e = new Nfe_IdentificacaoDestinario();
        Nfe_ProdutosServicos i = new Nfe_ProdutosServicos();
        Nfe_Icms n = new Nfe_Icms();
        Nfe_Pis q = new Nfe_Pis();
        Nfe_Confins s = new Nfe_Confins();
        Nfe_Issqn u = new Nfe_Issqn();
        Nfe_ValoresTotais w = new Nfe_ValoresTotais();
        Nfe_InformacoesTransporte x = new Nfe_InformacoesTransporte();
        Nfe_InformacoesAdicionais z = new Nfe_InformacoesAdicionais();

        ConstruirTxt build = new ConstruirTxt();

        Loja_Filial empresa = vendaDAO.getInitialized(venda.getLoja());
        Cidade cidadeEmpresa = vendaDAO.getInitialized(empresa.getCidadeEndereco());
        Estado estadoEmpresa = vendaDAO.getInitialized(cidadeEmpresa.getEstado());
        Pais paisEmpresa = vendaDAO.getInitialized(estadoEmpresa.getPais());
        NaturezasDeOperacoes natureza = vendaDAO.getInitialized(venda.getNatureza());
        Cidade cidadeCliente = vendaDAO.getInitialized(venda.getCliente().getCidadeEndereco());
        Estado estadoCliente = vendaDAO.getInitialized(cidadeCliente.getEstado());
        Pais paisCliente = vendaDAO.getInitialized(estadoCliente.getPais());
        ContaBancaria conta = vendaDAO.getInitialized(venda.getConta());

        List<ItemVenda> list = vendaDAO.getInitialized(venda.getItensVenda());

        //GRUPO A  
        a.setA02Versao("3.10");
        String cUF = estadoEmpresa.getCodigo();

        a.setA03Id(numChaveAcesso);
        a.setNfeCodigo("");
        corpo += build.NfeDados(a);//59
//   ------------------ Fim Grupo A ----------------------

        //GRUPO B  
        b.setB02cUF(estadoEmpresa.getCodigo());
        b.setB03cNF(numChaveAcesso.substring(38, 46));
        b.setB04natOp(natureza.getNome().toUpperCase());
        b.setB05indPag(String.valueOf(venda.getFormaPagamento().getNumero()));
        b.setB06mod("55");
        b.setB07serie("1");
        b.setB08nNF(numNota);
        b.setB09dhEmi(convertDateToString(venda.getDataVenda(), 2) + "T" + convertDateToString(venda.getDataVenda(), 5) + "-03:00");
        b.setB10dhSaiEnt(convertDateToString((venda.getDataEntrega() != null ? venda.getDataEntrega() : venda.getDataVenda()), 2)
                + "T" + convertDateToString((venda.getDataEntrega() != null ? venda.getDataEntrega() : venda.getDataVenda()), 5) + "-03:00");
        b.setB11tpNF("1");
        b.setB12idDest("1");
        b.setB13cMunFG(cidadeEmpresa.getCodigo());
        b.setB14tpImp("1");
        b.setB15tpEmis("1");
        b.setB16cDV("7");
        b.setB17tpAmb("1");
        b.setB18finNFe("1");
        b.setB19indFinal("0");
        b.setB20indPres("0");
        b.setB21procEmi("3");
        b.setB22verProc("3.10.61");
        b.setB23dhCont("");
        b.setB24xJust("");

        corpo += build.NfeIdentificacao(b);
//   ------------------ Fim Grupo B ----------------------
        //GRUPO C  

        c.setC02Cnpj(empresa.getCnpj());
        c.setC17Ie(empresa.getInscricaoEstatual() != null ? empresa.getInscricaoEstatual().replace("-", "")
                .replace(".", "") : "");
        c.setC19Im("");
        c.setC20Cnae("");
        c.setC03Xnome(empresa.getRazaoSocial().toUpperCase());
        c.setC04Xfant(empresa.getNomeFantasia().toUpperCase());
        c.setC06Xlgr(empresa.getEndereco().toUpperCase());
        c.setC07Nro(empresa.getNumero().toUpperCase());
        c.setC09Bairro(empresa.getBairro().toUpperCase());
        c.setC10Cmun(cidadeEmpresa.getCodigo());
        c.setC11Xmun(cidadeEmpresa.getNome().toUpperCase());
        c.setC12Uf(estadoEmpresa.getSigla().toUpperCase());
        c.setC13Cep(empresa.getCep() != null ? empresa.getCep().replace("-", "") : "");
        c.setC14Cpais(paisEmpresa.getCodigo());
        c.setC15Xpais(paisEmpresa.getNome().toUpperCase());
        c.setC16Fone(empresa.getTelefone().replace("/", "").replace(" ", "").replace("-", "").replace("(", "").replace(")", ""));
        c.setC21Crt("1");

        corpo += build.NfeIdentificacaoEmitente(c);

        //GRUPO E  
        if (venda.getCliente().getTipoDePessoa() == TipoDePessoa.JURIDICA) {
            e.setE04Xnome(venda.getCliente().getRazaoSocial().toUpperCase());
            e.setE02Cnpj(venda.getCliente().getCnpj());

        } else {
            e.setE04Xnome(venda.getCliente().getNome().toUpperCase());
            e.setE03Cpf(venda.getCliente().getCpf());
        }

        e.setE06Xlgr(venda.getCliente().getEndereco().toUpperCase());
        e.setE07Nro(venda.getCliente().getNumero().toUpperCase());
        e.setE09Xbairro(venda.getCliente().getBairro().toUpperCase());
        e.setE10Cmun(cidadeCliente.getCodigo());
        e.setE11Xmun(cidadeCliente.getNome().toUpperCase());
        e.setE12Uf(estadoCliente.getSigla().toUpperCase());
        e.setE13Cep(venda.getCliente().getCep().replace("-", ""));
        e.setE14Cpais(paisCliente.getCodigo());
        e.setE15Xpais(paisCliente.getNome().toUpperCase());

        if (venda.getCliente().getTipoIsencao() == TipoInsencaoCliente.ISENTO) {
            e.setE17Ie("ISENTO");
        }
        if (venda.getCliente().getTipoIsencao() == TipoInsencaoCliente.CONTRIBUIENTE) {
            e.setE17Ie(venda.getCliente().getInscricaoEstatual() != null ? venda.getCliente().getInscricaoEstatual().
                    replace("-", "").replace(".", "") : "");
        }
        e.setE20indEDest(venda.getCliente().getTipoIsencao().getNum() + "");

        corpo += build.NfeIdentificacaoDestinario(e);

        int nItem = 1;
        SituacaoTributaria tri = null;  //Verificar se isso eh necessario

        BigDecimal totIcmsSt = BigDecimal.ZERO;
        BigDecimal totBcSt = BigDecimal.ZERO;
        BigDecimal totProd = BigDecimal.ZERO;
        BigDecimal totDesc = BigDecimal.ZERO;
        BigDecimal totBc = BigDecimal.ZERO;
        BigDecimal totIcms = BigDecimal.ZERO;
        BigDecimal totIss = BigDecimal.ZERO;
        BigDecimal totBcServico = BigDecimal.ZERO;
        BigDecimal totIpi = BigDecimal.ZERO;
        BigDecimal totServ = BigDecimal.ZERO;

        for (ItemVenda item : list) {
            //GRUPO H  
            i.setH02Nitem(String.valueOf(nItem++));

            //GRUPO I  
            BigDecimal desconto = BigDecimal.ZERO;

            if (item.getDesconto() != null) {
                desconto = item.getDesconto();
            }

            i.setI02Cprod(String.valueOf(item.getProduto().getId()));
//            i.setI03Cean(prod.getProEan().replace("-", ""));  // nao sei o que eh
            i.setI04Xprod(item.getProduto().getDescricao().toUpperCase());
            i.setI05Ncm(item.getProduto().getCodigoNCM());
            i.setI08Cfop(item.getProduto().getCfop());

            i.setI09Ucom(item.getUnidadeDeVenda().toString());
            i.setI10Qcom(String.valueOf(item.getQtd().doubleValue()).replace(",", ".") + "00");
            i.setI10aVuncom(String.valueOf(item.getValorUnitario().setScale(2, RoundingMode.UP)).replace(",", "."));
            i.setI11Vprod(String.valueOf((item.getQtd().multiply(item.getValorUnitario()).setScale(2, RoundingMode.UP))).replace(",", "."));
//            i.setI12Ceantrib(prod.getProEan().replace("-", ""));  //Nao sei o que eh
            i.setI13Utrib(item.getUnidadeDeVenda().toString());
            i.setI14Qtrib(String.valueOf(item.getQtd().doubleValue()).replace(",", ".") + "00");
            i.setI14aVuntrib(String.valueOf(item.getValorUnitario().setScale(2, RoundingMode.UP)).replace(",", "."));
//            i.setI17Vdesc(formatarDouble(desconto).replace(",", ".")+"00");  //Nao sei o que eh
            i.setI17bIndtot("1");

            corpo += build.NfeProdutosServicos(i);

            //GRUPO N  
            n = gerarTributacao(item.getProduto().getCodigoCst().substring(1, 4), item.getProduto().getCodigoCst().substring(0, 1), item.getProduto().getCodigoCst(), String.valueOf(item.getIcmsCompra()));
            corpo += build.NfeIcms(n);

            //GRUPO Q  
            q.setQ06Cst("99");
            q.setQ07Vbc("0.00");
            q.setQ08Ppis("0.00");
            q.setQ10Qbcprod("0.00");
            q.setQ11Valiqprod("0.00");
            q.setQ09Vpis("0.00");

            corpo += build.NfePis(q);

            //LINHA S  
            s.setS06Cst("99");
            s.setS07Vbc("0.00");
            s.setS08Pconfins("0.00");
            s.setS09Qbcprod("0.00");
            s.setS10Valiqprod("0.00");
            s.setS11Vconfins("0.00");

            corpo += build.NfeConfins(s);

        }

        //GRUPO W  
        w.setW03Vbc(String.valueOf(totBc).replace(",", "."));
        w.setW04Vicms(String.valueOf(totIcms).replace(",", "."));
        w.setW05Vbcst(String.valueOf(totBcSt).replace(",", "."));
        w.setW06Vst(String.valueOf(totIcmsSt).replace(",", "."));
        w.setW07Vprod(String.valueOf(totProd).replace(",", "."));
        w.setW10Vdesc(String.valueOf(totDesc).replace(",", "."));
        w.setW16Vnf(String.valueOf(totProd.add(totServ).subtract(totDesc)).replace(",", "."));

        if (totIss.compareTo(BigDecimal.ZERO) == 1) {
            w.setW18Vserv(String.valueOf(totServ).replace(",", "."));
            w.setW19Vbc(String.valueOf(totBcServico).replace(",", "."));
            w.setW20Viss(String.valueOf(totIss).replace(",", "."));
            w.setW21Vpis("0.00");
            w.setW22Vconfins("0.00");
        }

        corpo += build.NfeValoresTotais(w);

        //GRUPO X  
        x.setX02Modfrete(venda.getModalidade().getNum() + "");  //nf.getNfModalidadefrete() O que eh?

//        if (nf.getNfTransTipopessoa()=='F'){  // O que eh isso?
//            x.setX05Cpf(nf.getNfTransDocumento());  
//        }else{  
//            x.setX04Cnpj(nf.getNfTransDocumento());  
//        }  
        x.setX06Xnome("");  //nf.getNfTransportador() o que eh?

        String endereco = "";
//        if (nf.getNfTransEndereco()!=null && !nf.getNfTransEndereco().isEmpty()){  // o que eh isso?
//            endereco = String.valueOf(nf.getNfTransEndereco());  
//              
//            if (nf.getNfTransNumero()!=null){  
//                endereco += ", "+String.valueOf(nf.getNfTransNumero());  
//            }  
//            if (nf.getNfTransBairro()!=null && !nf.getNfTransBairro().isEmpty()){  
//                endereco += ", "+nf.getNfTransBairro();  
//            }  
//        }  
        String cidade = "";
        String estado = "";
//        if (nf.getCidadesByCidTransporte()!=null){  // o que eh?
//            cidade = String.valueOf(nf.getCidadesByCidTransporte().getCidDescricao());  
//            estado = nf.getCidadesByCidTransporte().getEstados().getEstSigla();  
//        }  

        x.setX08Xender(endereco);
        x.setX09Xmun(cidade);
        x.setX10Uf(estado);

        corpo += build.NfeInformacoesTransporte(x);

        //GRUPO Z  
        z.setZ02Infadfisco(""); // o que eh?
//        z.setZ03Infcpl("DADOS BANCARIOS: AG.: " + conta.getAgencia() + "CNTA CORRENTE: " + conta.getConta() + ", " + conta.getBanco().getNome() + "-" + conta.getBanco().getSigla());
        z.setZ03Infcpl(venda.getCampoComplementar() != null ? venda.getCampoComplementar() : "");
        corpo += build.NfeInformacoesAdicionais(z);

        return corpo;
    }

    private String gerarCabecalho() {
        String cabecalho = "NOTA FISCAL|"
                + "    1|"
                + System.getProperty("line.separator");
        return cabecalho;
    }

    private Nfe_Icms gerarTributacao(String tri, String origem, String vlrBcSt, String icmsSt) {

        Nfe_Icms n = new Nfe_Icms();

        if (tri.equals("500")) {
            n.setN11Orig(origem);
            n.setN12ACSosn(tri);
            n.setN26Vbcstret(vlrBcSt.replace(",", "."));
            n.setN27Vicmsstret(icmsSt.replace(",", "."));

        } else {
            n.setN11Orig(origem);
            n.setN12ACSosn(tri);
        }

        return n;
    }

    private static String lpadTo(String input, int width, char ch) {
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

    /**
     * Log ERROR.
     *
     * @param error
     */
    private static void error(String error) {
        System.out.println("| ERROR: " + error);
    }

    private String convertDateToString(Date date, int tipo) {
        SimpleDateFormat formataData = null;
        if (tipo == 1) {
            formataData = new SimpleDateFormat("dd/MM/yyyy");
        }

        if (tipo == 2) {
            formataData = new SimpleDateFormat("yyyy-MM-dd");
        }

        if (tipo == 3) {
            formataData = new SimpleDateFormat("HH:mm");
        }

        if (tipo == 4) {
            formataData = new SimpleDateFormat("MMyy");
        }
        if (tipo == 5) {
            formataData = new SimpleDateFormat("HH:mm:ss");
        }
        if (tipo == 6) {
            formataData = new SimpleDateFormat("yyMM");
        }
        if (tipo == 7) {
            formataData = new SimpleDateFormat("yyMMdd");
        }

        String data = formataData.format(date);

        return data;
    }

    public void gerarOrcamento(Venda item) {
        List<ItemVenda> itemVendas;
        SolicitacaoPedidoVO solicitacaoPedido;
        List<SolicitacaoPedidoVO> listaVO = new ArrayList<SolicitacaoPedidoVO>();

        itemVendas = vendaDAO.getInitialized(item.getItensVenda());
        Loja_Filial empresa = vendaDAO.getInitialized(item.getLoja());
        Cliente cliente = vendaDAO.getInitialized(item.getCliente());
        Cidade cidade = vendaDAO.getInitialized(empresa.getCidadeEndereco());
        Estado estado = null;
        if (cidade != null) {
            estado = vendaDAO.getInitialized(cidade.getEstado());
        }

        Cidade cidadeCliente = vendaDAO.getInitialized(cliente.getCidadeEndereco());
        Estado estadoCliente = null;
        if (cidadeCliente != null) {
            estadoCliente = vendaDAO.getInitialized(cidadeCliente.getEstado());
        }

        String caminhoLogo;
        caminhoLogo = FacesContext.getCurrentInstance().getExternalContext().getRealPath("/images/logo.png");
        HashMap params = new HashMap();
        params.put("data", (cidade != null ? cidade.getNome() : "_________-") + (estado != null ? "-" + estado.getSigla() : "___") + ", "
                + convertDateToString(item.getDataVenda() != null ? item.getDataVenda() : new Date(), 1));
        params.put("caminhoImagem", caminhoLogo);
        params.put("nomeEmpresa", empresa.getRazaoSocial());
        params.put("txtDadosCliente", getNegrito("DADOS DO CLIENTE"));
        params.put("txtNumOrcamento", getNegrito("NÚMERO DO ORÇAMENTO"));
        params.put("txtItem", getNegrito("Item"));
        params.put("txtEspecif", getNegrito("Especificação"));
        params.put("txtMarca", getNegrito("Marca"));
        params.put("txtUnid", getNegrito("Unid."));
        params.put("txtQtd", getNegrito("Qtd"));
        params.put("txtVUnit", getNegrito("V.Unit."));
        params.put("txtVTotal", getNegrito("V.Total"));
        params.put("numOrcamento", getNegrito(convertDateToString(item.getDataVenda() != null ? item.getDataVenda() : new Date(), 7) + String.format("%05d", item.getId())));
        params.put("enderecoEmpresa", ((empresa.getEndereco() != null ? empresa.getEndereco() + ", " : "")
                + (empresa.getNumero() != null ? empresa.getNumero() + ", " : "")
                + (empresa.getBairro() != null ? empresa.getBairro() + ", " : "")
                + (cidade != null ? cidade.getNome() : "")
                + (estado != null ? "-" + estado.getSigla() : "")));
        params.put("docsEmpresa", (("CNPJ: " + format("##.###.###/####-##", empresa.getCnpj())) + (empresa.getInscricaoEstatual() != null ? ", Ins. Estadual: " + empresa.getInscricaoEstatual() : "")));
        params.put("contatos", "Fones: " + (empresa.getTelefone() != null ? empresa.getTelefone() : "")
                + (empresa.getCelula1() != null ? "/" + empresa.getCelula1() : "")
                + (empresa.getEmail() != null ? ", Email: " + empresa.getEmail() : ""));
        params.put("nomeCliente", (cliente.getRazaoSocial() != null ? cliente.getRazaoSocial() : "") + (cliente.getNome() != null ? cliente.getNome() : ""));
        params.put("endCliente", (cliente.getEndereco() != null ? cliente.getEndereco() + ", " : "")
                + (cliente.getNumero() != null ? cliente.getNumero() + ", " : "")
                + (cliente.getBairro() != null ? cliente.getBairro() + ", " : "")
                + (cidadeCliente != null ? cidadeCliente.getNome() : "")
                + (estadoCliente != null ? "-" + estadoCliente.getSigla() : ""));
        params.put("textoNota", getText1(empresa.getRazaoSocial()));
        params.put("textoObs", getText2());
        params.put("valorTotalNota", item.getTotalAPagar().setScale(2, BigDecimal.ROUND_HALF_UP).toString());

        int i = 1;
        for (ItemVenda itemVO : itemVendas) {
            solicitacaoPedido = new SolicitacaoPedidoVO(i, itemVO);
            listaVO.add(solicitacaoPedido);
            i++;
        }

        FacesJasper.createJasperReport(listaVO, params,
                "/WEB-INF/report/relatorios/orcamento.jasper", "Orcamento - "
                + (cliente.getRazaoSocial() != null ? cliente.getRazaoSocial() : "")
                + (cliente.getNome() != null ? cliente.getNome() : "") + ".pdf");

    }

    private String getNegrito(String nome) {
        return "<style size=\"12\" isBold=\"true\" pdfFontName=\"Helvetica-Bold\">SUBSTITUIR</style>".replace("SUBSTITUIR", nome);
    }

    private String getNegritoSize(String nome) {
        return "<style size=\"16\" isBold=\"true\" pdfFontName=\"Helvetica-Bold\">SUBSTITUIR</style>".replace("SUBSTITUIR", nome);
    }

    private String format(String pattern, Object value) {
        MaskFormatter mask;
        try {
            mask = new MaskFormatter(pattern);
            mask.setValueContainsLiteralCharacters(false);
            return mask.valueToString(value);
        } catch (ParseException e) {
            throw new RuntimeException(e);
        }
    }

    private String getText1(String razaoSocial) {
        String texto = "Proposta que faz a firma NOMEEMPRESA, para o fornecimento de mercadorias constantes da CONSULTA, abaixo referidas, a saber:";

        return texto.replace("NOMEEMPRESA", razaoSocial);
    }

    private String getText2() {
        String texto = "Obs.: Prazo para entrega é de até 10 dias após a conclusão da venda, onde a validade dessa proposta sera de 30 (trinta) dias contando a partir da data de emissão.";
        return texto;
    }

    public Long dupliclarVenda(Long id) {

        Venda venda = vendaDAO.find(id);

        List<ItemVenda> itensVenda;

        itensVenda = vendaDAO.getInitialized(venda.getItensVenda());

        List<ItemVenda> itensNovos = new ArrayList<ItemVenda>();

        Venda vendaNova = new Venda();

        for (ItemVenda item : itensVenda) {
            ItemVenda itemNovo = new ItemVenda();
            itemNovo.setVenda(vendaNova);
            itemNovo.setDesconto(item.getDesconto());
            itemNovo.setIcmsCompra(item.getIcmsCompra());
            itemNovo.setIpi(item.getIpi());
            itemNovo.setProduto(item.getProduto());
            itemNovo.setQtd(item.getQtd());
            itemNovo.setUnidadeDeVenda(item.getUnidadeDeVenda());
            itemNovo.setValorUnitario(item.getValorUnitario());
            itemNovo.setAtivo(true);
            itensNovos.add(itemNovo);
        }
        vendaNova.setCliente(venda.getCliente());
        vendaNova.setConta(venda.getConta());
        vendaNova.setDesconto(venda.getDesconto());
        vendaNova.setFormaPagamento(venda.getFormaPagamento());
        vendaNova.setGrupoLoja(venda.getGrupoLoja());
        vendaNova.setItensVenda(itensNovos);
        vendaNova.setLoja(venda.getLoja());
        vendaNova.setNatureza(venda.getNatureza());
        vendaNova.setTotalAPagar(venda.getTotalAPagar());
        vendaNova.setValorEntrada(venda.getValorEntrada());
        vendaNova.setVendedor(venda.getVendedor());
        vendaNova.setDataEntrega(new Date());
        vendaNova.setDataVenda(new Date());
        vendaNova.setAtivo(false);

        vendaDAO.saveOrMerge(vendaNova);

        return vendaNova.getId();
    }

    public String pegarUltimoComplemento(Long id) {

        if (id != null) {
            QueryBuilder query = vendaDAO.getQueryBuilder();
            List<Venda> nota = query.from(Venda.class).equals("loja_id", id).getResultList();
            if (nota.size() > 0) {
                return nota.get(nota.size() - 1).getCampoComplementar() != null ? nota.get(nota.size() - 1).getCampoComplementar() : "";
            } else {
                return "";
            }
        } else {
            return "";
        }

    }

    @Override
    public void save(Venda object) throws BusinessException {
        Currency currency = Currency.getInstance("BRL");
        DecimalFormat formato = new DecimalFormat(currency.getSymbol() + "#,##0.00");
        Cliente cliente = vendaDAO.getInitialized(object.getCliente());
        String cnpjNome = ((cliente.getNomeFantasia() != null ? cliente.getNomeFantasia() : cliente.getNome()) + ", Data: "
                + convertDateToString(object.getDataVenda(), 1) + " "+ formato.format(object.getTotalAPagar()));
        object.setNomeEcNPJCliente(cnpjNome);

        super.save(object);

    }

}
