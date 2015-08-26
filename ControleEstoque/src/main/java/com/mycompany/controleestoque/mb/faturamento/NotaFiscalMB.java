package com.mycompany.controleestoque.mb.faturamento;

import java.io.Serializable;
import com.xpert.core.crud.AbstractBaseBean;
import javax.ejb.EJB;
import javax.faces.bean.ManagedBean;
import javax.faces.bean.ViewScoped;
import com.mycompany.controleestoque.bo.faturamento.NotaFiscalBO;
import com.mycompany.controleestoque.bo.faturamento.VendaBO;
import com.mycompany.controleestoque.dao.faturamento.NotaFiscalDAO;
import com.mycompany.controleestoque.modelo.cadastro.Loja_Filial;
import com.mycompany.controleestoque.modelo.faturamento.NotaFiscal;
import com.mycompany.controleestoque.modelo.faturamento.Venda;
import com.xpert.faces.utils.FacesMessageUtils;
import com.xpert.faces.utils.FacesUtils;
import java.io.IOException;
import java.util.ArrayList;
import java.util.List;

/**
 *
 * @author KillerBeeTwo
 */
@ManagedBean
@ViewScoped
public class NotaFiscalMB extends AbstractBaseBean<NotaFiscal> implements Serializable {

    @EJB
    private NotaFiscalBO notaFiscalBO;

    @EJB
    NotaFiscalDAO notaDAO;

    @EJB
    private VendaBO vendaBO;

    NotaFiscal notaConfirmada;

    public NotaFiscal getNotaConfirmada() {
        return notaConfirmada;
    }

    public void setNotaConfirmada(NotaFiscal notaConfirmada) {
        this.notaConfirmada = notaConfirmada;
    }

    @Override
    public NotaFiscalBO getBO() {
        return notaFiscalBO;
    }

    @Override
    public void init() {
        notaConfirmada = new NotaFiscal();
    }

    @Override
    public void postSave() {
        if (getId() != null) {
            FacesUtils.redirect("view/faturamento/notaFiscal/listNotaFiscal.jsf");
        } else {
            setEntity(new NotaFiscal());
        }
    }

    @Override
    public String getDataModelOrder() {
        return "id";
    }

    public void gerarArquivoTextNfe(NotaFiscal nota) throws IOException, InterruptedException {
        Venda venda = notaDAO.getInitialized(nota.getVenda());
        String texto = vendaBO.gerarTxtNota(venda, nota.getNumeroNota().toString(), nota.getNumChaveDeAcesso());
        Thread.sleep(5000);
        FacesUtils.download(texto.getBytes(), "text/plain", "NotaFiscalArquivoTexto" + nota.getId() + ".txt");
    }

    private String gerarChaveAcesso() {
        if (getEntity().getVenda() != null) {
            return notaFiscalBO.gerarChave(getEntity());
        }
        return null;
    }

    private Long pegaUltimoNumNota() {
        if (getEntity().getVenda() != null) {
            return notaFiscalBO.pegarUltimoNumNota(getEntity().getVenda());
        }
        return null;
    }

    public void carregarValores() {
        getEntity().setNumeroNota(pegaUltimoNumNota());
        getEntity().setNumChaveDeAcesso(gerarChaveAcesso());
    }

    public void setarChaveAcesso() {
        getEntity().setNumChaveDeAcesso(gerarChaveAcesso());
    }

    public void gerarNFe(NotaFiscal nota) {
        notaFiscalBO.visualizarNFe(nota);
    }

    public void confirmarNota() {
        notaFiscalBO.confirmarNFe(notaConfirmada);
        FacesMessageUtils.info("Nota Fiscal Confirmada com sucesso!");

    }

    public void cancelarNota(NotaFiscal nota) {
        notaFiscalBO.cancelarNFe(nota);
        FacesMessageUtils.info("Nota Fiscal Cancelada com sucesso!");
    }

    public List<Venda> getVendasLoja() {
        List<Venda> vendas = null;
        List<Venda> vendasFechadas = new ArrayList<Venda>();

        if (getEntity().getLoja() != null) {
            if (getEntity().getId() != null) {
                vendasFechadas.add(getEntity().getVenda());
            } else {
                vendas = vendaBO.getDAO().list("loja", getEntity().getLoja());
                for (Venda vendasFechada : vendas) {
                    if (vendasFechada.isAtivo() && !verificarSeExite(vendasFechada)) {
                        vendasFechadas.add(vendasFechada);
                    }
                }
            }

        }
        return vendasFechadas;
    }

    private boolean verificarSeExite(Venda venda) {
        List<NotaFiscal> notas = new ArrayList<NotaFiscal>();
        Loja_Filial loja = notaDAO.getInitialized(venda.getLoja());
        notas = notaFiscalBO.getDAO().list("loja", loja);

        for (NotaFiscal nota : notas) {
            Venda vendaDaNota = notaDAO.getInitialized(nota.getVenda());
            if (vendaDaNota.equals(venda)) {
                return true;
            }
        }

        return false;
    }
}
