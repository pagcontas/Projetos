package com.mycompany.controleestoque.bo.faturamento;

import com.xpert.core.crud.AbstractBusinessObject;
import com.mycompany.controleestoque.dao.faturamento.NotaFiscalDAO;
import com.mycompany.controleestoque.modelo.cadastro.Cidade;
import com.mycompany.controleestoque.modelo.cadastro.Cliente;
import com.mycompany.controleestoque.modelo.cadastro.Estado;
import com.mycompany.controleestoque.modelo.cadastro.Loja_Filial;
import com.mycompany.controleestoque.modelo.cadastro.NaturezasDeOperacoes;
import com.mycompany.controleestoque.modelo.cadastro.enums.StatusNF;
import com.mycompany.controleestoque.modelo.faturamento.ItemVenda;
import com.xpert.core.validation.UniqueField;
import com.xpert.core.exception.BusinessException;
import java.util.List;
import javax.ejb.EJB;
import javax.ejb.Stateless;
import com.mycompany.controleestoque.modelo.faturamento.NotaFiscal;
import com.mycompany.controleestoque.modelo.faturamento.Venda;
import com.mycompany.controleestoque.vo.NFeVO;
import com.xpert.core.validation.UniqueFields;
import com.xpert.faces.utils.FacesJasper;
import com.xpert.persistence.query.QueryBuilder;
import java.text.SimpleDateFormat;
import java.util.ArrayList;
import java.util.Date;
import java.util.HashMap;
import java.util.Random;

/**
 *
 * @author KillerBeeTwo
 */
@Stateless
public class NotaFiscalBO extends AbstractBusinessObject<NotaFiscal> {

    @EJB
    private NotaFiscalDAO notaFiscalDAO;

    @Override
    public NotaFiscalDAO getDAO() {
        return notaFiscalDAO;
    }

    @Override
    public List<UniqueField> getUniqueFields() {
        return new UniqueFields().add("numeroNota");
    }

    @Override
    public void validate(NotaFiscal notaFiscal) throws BusinessException {
    }

    @Override
    public boolean isAudit() {
        return true;
    }

    public String gerarChave(NotaFiscal nota) {
        Venda venda = notaFiscalDAO.getInitialized(nota.getVenda());
        Loja_Filial empresa = notaFiscalDAO.getInitialized(venda.getLoja());
        Cidade cidade = notaFiscalDAO.getInitialized(empresa.getCidadeEndereco());
        Estado estado = notaFiscalDAO.getInitialized(cidade.getEstado());

        String chave = gerarChaveAcessoNFe(estado.getCodigo(), convertDateToString(venda.getDataVenda(), 6), empresa.getCnpj(), "55", "1", nota.getNumeroNota().toString(), gerarcNF());

        return chave;
    }

    //            String cUF = "42"; // Código da UF do emitente do Documento Fiscal.  
//            String dataAAMM = "1105"; // Ano e Mês de emissão da NF-e.  
//            String cnpjCpf = "85.785.244/0001-99"; // CNPJ do emitente.  
//            String mod = "55"; // Modelo do Documento Fiscal.  
//            String serie = "1"; // Série do Documento Fiscal.  
//            String tpEmis = "2"; // Forma de emissão da NF-e  // nao tem mais
//            String nNF = "20"; // Número do Documento Fiscal.  
//            String cNF = "5"; // Código Numérico que compõe a Chave de Acesso.
//            Exemplo NFe22150619843574000150550010000001631000009480
    private String gerarChaveAcessoNFe(String cUF, String dataAAMM, String cnpjCpf, String mod, String serie, String nNF, String cNF) {
        try {

            StringBuilder chave = new StringBuilder();
            chave.append(lpadTo(cUF, 2, '0'));
            chave.append(lpadTo(dataAAMM, 4, '0'));
            chave.append(lpadTo(cnpjCpf.replaceAll("\\D", ""), 14, '0'));
            chave.append(lpadTo(mod, 2, '0'));
            chave.append(lpadTo(serie, 3, '0'));
            chave.append(lpadTo(String.valueOf(nNF), 9, '0'));
            chave.append(lpadTo("1", 1, '0'));
            chave.append(lpadTo(cNF, 8, '0'));
            chave.append(modulo11(chave.toString()));

            chave.insert(0, "NFe");

            return chave.toString();
        } catch (Exception e) {
            error(e.toString());
        }
        return null;

    }

    private String gerarcNF() {
        Random gerador = new Random();

        int numero = gerador.nextInt(10000);
        return lpadTo(numero + "", 8, '0');
    }

    /**
     * Log ERROR.
     *
     * @param error
     */
    private static void error(String error) {
        System.out.println("| ERROR: " + error);
    }

    private static int modulo11(String chave) {
        int total = 0;
        int peso = 2;

        for (int i = 0; i < chave.length(); i++) {
            total += (chave.charAt((chave.length() - 1) - i) - '0') * peso;
            peso++;
            if (peso == 10) {
                peso = 2;
            }
        }
        int resto = total % 11;
        return (resto == 0 || resto == 1) ? 0 : (11 - resto);
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

    public Long pegarUltimoNumNota(Venda venda) {
        QueryBuilder query = notaFiscalDAO.getQueryBuilder();
        Loja_Filial empresa = notaFiscalDAO.getInitialized(venda.getLoja());
        //select max(numeroNota) from notaFiscal n inner join venda v on (n.venda_id=v.id) inner join loja_filial l on  
        //(l.id=v.loja_id) where l.id=1

        Long id = (Long) query.select("n.numeroNota").from(NotaFiscal.class, "n").innerJoin("n.venda", "v").innerJoinFetch("v.loja", "l").equals("l.id", empresa.getId()).max("n.numeroNota");
        if (id != null) {
            return id + 1;
        } else {
            return (long) 1;
        }
    }

    public void confirmarNFe(NotaFiscal nota) {
        nota.setAtivo(true);
        nota.setStatus(StatusNF.CONFIRMANDA);

        if (nota.getDataEmissao() != null) {
            nota.setDataEmissao(new Date());
        }

        if (nota.getHoraEmissao() != null) {
            nota.setHoraEmissao(new Date());
        }

        notaFiscalDAO.saveOrMerge(nota);
    }

    public void cancelarNFe(NotaFiscal nota) {
        nota.setAtivo(false);
        nota.setStatus(StatusNF.CANCELADA);

        nota.setDataEmissao(new Date());

        nota.setHoraEmissao(new Date());

        notaFiscalDAO.saveOrMerge(nota);
    }

    public void visualizarNFe(NotaFiscal nota) {
        List<ItemVenda> itemVendas;
        NFeVO nfeVO;
        List<NFeVO> listaVO = new ArrayList<NFeVO>();
        Venda venda = notaFiscalDAO.getInitialized(nota.getVenda());
        itemVendas = notaFiscalDAO.getInitialized(venda.getItensVenda());
        NaturezasDeOperacoes natureza = notaFiscalDAO.getInitialized(venda.getNatureza());
        Loja_Filial empresa = notaFiscalDAO.getInitialized(venda.getLoja());
        Cliente cliente = notaFiscalDAO.getInitialized(venda.getCliente());
        Cidade cidade = notaFiscalDAO.getInitialized(empresa.getCidadeEndereco());
        Estado estado = null;
        if (cidade != null) {
            estado = notaFiscalDAO.getInitialized(cidade.getEstado());
        }

        Cidade cidadeCliente = notaFiscalDAO.getInitialized(cliente.getCidadeEndereco());
        Estado estadoCliente = null;
        if (cidadeCliente != null) {
            estadoCliente = notaFiscalDAO.getInitialized(cidadeCliente.getEstado());
        }

        HashMap params = new HashMap();
        params.put("nomeEmpresa", empresa.getRazaoSocial() != null ? empresa.getRazaoSocial() : "");
        params.put("enderecoEmpresa", ((empresa.getEndereco() != null ? empresa.getEndereco() + ", " : "")
                + (empresa.getNumero() != null ? empresa.getNumero() + ", " : "")
                + (empresa.getBairro() != null ? empresa.getBairro() + ", " : "")
                + (cidade != null ? cidade.getNome() : "")
                + (estado != null ? "-" + estado.getSigla() : "")));
        params.put("chaveAcesso", dividirString(nota.getNumChaveDeAcesso()));
        params.put("serie", nota.getNumChaveDeAcesso().substring(37, 38));
        params.put("numNota", nota.getNumChaveDeAcesso().substring(29, 37));
        params.put("naturezaOp", natureza.getNome() != null ? natureza.getNome().toUpperCase() : "");
        params.put("protocolo", ((nota.getProtocolo() != null ? nota.getProtocolo() : "") + (nota.getDataEmissao() != null ? " - " + convertDateToString(nota.getDataEmissao(), 1) : "")
                + (nota.getHoraEmissao() != null ? " - " + convertDateToString(nota.getHoraEmissao(), 3) : "")));
        params.put("inscriEstad", empresa.getInscricaoEstatual());
        params.put("cnpj", empresa.getCnpj());
        params.put("nomeCliente", (cliente.getRazaoSocial() != null ? cliente.getRazaoSocial() : "") + (cliente.getNome() != null ? cliente.getNome() : ""));
        params.put("cnpjCliente", cliente.getCnpj());
        params.put("dataEmissao", convertDateToString(venda.getDataVenda(), 1));
        params.put("enderecoCliente", cliente.getEndereco());
        params.put("bairroCliente", cliente.getBairro());
        params.put("cepCliente", cliente.getCep());
        params.put("dataEmissaoVenda", convertDateToString(venda.getDataEntrega(), 1));
        params.put("horaEmissaoVenda", convertDateToString(venda.getDataEntrega(), 3));
        params.put("municipioCliente", cidadeCliente.getNome() != null ? cidadeCliente.getNome().toUpperCase() : "");
        params.put("foneCliente", cliente.getTelefone());
        params.put("ufCliente", estadoCliente != null ? estadoCliente.getSigla().toUpperCase() : "");
        params.put("ieCliente", cliente.getInscricaoEstatual());
        params.put("baseIcms", "0.00");
        params.put("valorIcms", "0.00");
        params.put("baseIcmsSt", "0.00");
        params.put("valorIcmsSt", "0.00");
        params.put("valorTotalProdutos", "0.00");
        params.put("valorDoFrete", "0.00");
        params.put("valorDoSeguro", "0.00");
        params.put("desconto", venda.getDesconto() != null ? venda.getDesconto().toString() : "");
        params.put("outrasDespesas", "0.00");
        params.put("valorDoApi", "0.00");
        params.put("valorTotalNota", venda.getTotalAPagar().toString());

        for (ItemVenda itemVO : itemVendas) {
            nfeVO = new NFeVO(itemVO);
            listaVO.add(nfeVO);
        }
        FacesJasper.createJasperReport(listaVO, params,
                "/WEB-INF/report/relatorios/NFeModelo1.jasper", "NFe - "
                + (cliente.getRazaoSocial() != null ? cliente.getRazaoSocial() : "")
                + (cliente.getNome() != null ? cliente.getNome() : "") + ".pdf");
    }

    private String dividirString(String chave) {
        StringBuilder sb = new StringBuilder(chave.substring(3, 47));
        for (int j = 4; j < sb.length(); j = j + 5) {
            sb.insert(j, ' ');
        }

        return sb.toString();
    }

}
