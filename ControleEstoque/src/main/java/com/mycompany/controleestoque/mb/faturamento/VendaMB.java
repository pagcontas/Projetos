package com.mycompany.controleestoque.mb.faturamento;

import com.mycompany.controleestoque.bo.faturamento.EstoqueBO;
import java.io.Serializable;
import com.xpert.core.crud.AbstractBaseBean;
import javax.ejb.EJB;
import javax.faces.bean.ManagedBean;
import javax.faces.bean.ViewScoped;
import com.mycompany.controleestoque.bo.faturamento.VendaBO;
import com.mycompany.controleestoque.dao.faturamento.EstoqueDAO;
import com.mycompany.controleestoque.dao.faturamento.ItemVendaDAO;
import com.mycompany.controleestoque.dao.faturamento.VendaDAO;
import com.mycompany.controleestoque.modelo.cadastro.Produto;
import com.mycompany.controleestoque.modelo.cadastro.enums.UnidadeDeMedida;
import com.mycompany.controleestoque.modelo.faturamento.Estoque;
import com.mycompany.controleestoque.modelo.faturamento.ItemVenda;
import com.mycompany.controleestoque.modelo.faturamento.Venda;
import com.mycompany.controleestoque.util.SessaoUtils;
import com.xpert.faces.utils.FacesMessageUtils;
import com.xpert.faces.utils.FacesUtils;
import com.xpert.persistence.exception.DeleteException;
import java.io.IOException;
import java.math.BigDecimal;
import java.util.ArrayList;
import java.util.List;

/**
 *
 * @author juniel
 */
@ManagedBean
@ViewScoped
public class VendaMB extends AbstractBaseBean<Venda> implements Serializable {

    @EJB
    private VendaBO vendaBO;

    @EJB
    private VendaDAO vendaDAO;

    @EJB
    private EstoqueBO estoqueBO;

    @EJB
    private EstoqueDAO estoqueDAO;

    @EJB
    private ItemVendaDAO itemDAO;

    private ItemVenda itemVenda;

    private ItemVenda itemRemove;

    private Produto produtoTela;

    private Venda vendaEditado;

    private List<ItemVenda> itensVendaTemp;

    private List<Produto> produtosAtivos;

    private List<UnidadeDeMedida> listUnidade;

    public List<UnidadeDeMedida> getListUnidade() {
        return listUnidade;
    }

    public void setListUnidade(List<UnidadeDeMedida> listUnidade) {
        this.listUnidade = listUnidade;
    }

    @Override
    public VendaBO getBO() {
        return vendaBO;
    }

    @Override
    public String getDataModelOrder() {
        return "id";
    }

    @Override
    public void init() {
        itemVenda = new ItemVenda();
        produtosAtivos = estoqueBO.getProdutosAtivos();
        getEntity().setVendedor(SessaoUtils.getUser());
        if (getEntity().getId() != null) {
            itensVendaTemp = itemDAO.list("venda_id", getEntity().getId());
        }
    }

    @Override
    public void postSave() {
        if (getId() != null) {
            FacesUtils.redirect("/view/faturamento/venda/listVenda.jsf");
        } else {
            setEntity(new Venda());
        }
    }

    @Override
    public void save() {
        boolean seTiverId = getEntity().getId() != null;
        getEntity().setTotalAPagar(getValorDaNota());
        List<ItemVenda> itensVenda;

        itensVenda = vendaDAO.getInitialized(getEntity().getItensVenda());

        super.save();
        if (seTiverId && getEntity().isAtivo()) {
            for (ItemVenda item : itensVenda) {
                Produto produto = vendaDAO.getInitialized(item.getProduto());

                Estoque estoque = estoqueDAO.unique("produto_id", produto.getId());

                for (ItemVenda itemTemp : itensVendaTemp) {

                    if (itemTemp.getId().equals(item.getId())) {
                        BigDecimal qtdNova;
                        if (produto.isProdutoFracionado() && verificaTipo(item.getUnidadeDeVenda()) && item.getId() == null) {
                            BigDecimal valor = BigDecimal.ZERO;

                            if (item.getQtd().compareTo(itemTemp.getQtd()) == 1) {
                                qtdNova = item.getQtd().subtract(itemTemp.getQtd());
                                valor = valor.add(qtdNova.multiply(produto.getQtdFracoes() != null ? new BigDecimal(produto.getQtdFracoes()) : BigDecimal.ONE));
                                estoque.setQuantidade(estoque.getQuantidade().subtract(valor));
                            }
                            if (item.getQtd().compareTo(itemTemp.getQtd()) == -1) {
                                qtdNova = itemTemp.getQtd().subtract(item.getQtd());
                                valor = valor.add(qtdNova.multiply(produto.getQtdFracoes() != null ? new BigDecimal(produto.getQtdFracoes()) : BigDecimal.ONE));
                                estoque.setQuantidade(estoque.getQuantidade().add(valor));
                            }

                        } else {
                            if (item.getQtd().compareTo(itemTemp.getQtd()) == 1) {
                                qtdNova = item.getQtd().subtract(itemTemp.getQtd());
                                estoque.setQuantidade(estoque.getQuantidade().subtract(qtdNova));
                            }
                            if (item.getQtd().compareTo(itemTemp.getQtd()) == -1) {
                                qtdNova = itemTemp.getQtd().subtract(item.getQtd());
                                estoque.setQuantidade(estoque.getQuantidade().add(qtdNova));
                            }
                        }
                        estoqueBO.getDAO().saveOrMerge(estoque);

                    } else if (!constaisItem(item)) {
                        if (estoque != null) {

                            if (produto.isProdutoFracionado() && verificaTipo(item.getUnidadeDeVenda()) && item.getId() == null) {
                                BigDecimal valor = BigDecimal.ZERO;
                                valor = valor.add(item.getQtd().multiply(produto.getQtdFracoes() != null ? new BigDecimal(produto.getQtdFracoes()) : BigDecimal.ONE));
                                estoque.setQuantidade(estoque.getQuantidade().subtract(valor));
                            } else {
                                estoque.setQuantidade(estoque.getQuantidade().subtract(item.getQtd()));
                            }
                            estoqueBO.getDAO().saveOrMerge(estoque);
                        }
                    }
                }
            }
        }

    }

    public void confirmaVenda(Venda venda) {

        List<ItemVenda> itensVenda;

        itensVenda = vendaDAO.getInitialized(venda.getItensVenda());

        for (ItemVenda item : itensVenda) {
            Produto produto = vendaDAO.getInitialized(item.getProduto());

            Estoque estoque = estoqueDAO.unique("produto_id", produto.getId());

            if (estoque != null) {

                if (produto.isProdutoFracionado() && verificaTipo(item.getUnidadeDeVenda()) && item.getId() == null) {
                    BigDecimal valor = BigDecimal.ZERO;
                    valor = valor.add(item.getQtd().multiply(produto.getQtdFracoes() != null ? new BigDecimal(produto.getQtdFracoes()) : BigDecimal.ONE));
                    estoque.setQuantidade(estoque.getQuantidade().subtract(valor));
                } else {
                    estoque.setQuantidade(estoque.getQuantidade().subtract(item.getQtd()));
                }
                estoqueBO.getDAO().saveOrMerge(estoque);
            }
        }

        venda.setAtivo(true);

        vendaDAO.saveOrMerge(venda);

        FacesMessageUtils.info("Venda confirmada com sucesso!");

    }

    @Override
    public void delete() {
        Venda venda = vendaDAO.find(getId());
        boolean novo = venda.isAtivo();

        List<ItemVenda> itensVenda = vendaDAO.getInitialized(venda.getItensVenda());

        super.delete();

        if (novo) {

            for (ItemVenda item : itensVenda) {
                Produto produto = vendaDAO.getInitialized(item.getProduto());

                Estoque estoque = estoqueDAO.unique("produto_id", produto.getId());

                if (estoque != null) {
                    if (produto.isProdutoFracionado() && verificaTipo(item.getUnidadeDeVenda()) && item.getId() == null) {
                        BigDecimal valor = BigDecimal.ZERO;
                        valor = valor.add(item.getQtd().multiply(produto.getQtdFracoes() != null ? new BigDecimal(produto.getQtdFracoes()) : BigDecimal.ONE));
                        estoque.setQuantidade(estoque.getQuantidade().add(valor));
                    } else {
                        estoque.setQuantidade(estoque.getQuantidade().add(item.getQtd()));
                    }
                    estoqueBO.getDAO().saveOrMerge(estoque);
                }
            }
        }
    }

    public void setarCamposDeItens() {
        if (produtoTela != null) {
            listUnidade = getUnidadeProduto();
            itemVenda.setProduto(produtoTela);
            itemVenda.setUnidadeDeVenda(produtoTela.getUnidadeDeVenda());
            itemVenda.setIcmsCompra(produtoTela.getIcmsCompra());
            itemVenda.setIpi(produtoTela.getIpi());

            itemVenda.setValorUnitario(produtoTela.getValorDeVenda());

            itemVenda.setVenda(getEntity());
        }
    }

    public void setarValorFrancionado() {
        if (produtoTela.isProdutoFracionado() && !verificaTipo(itemVenda.getUnidadeDeVenda())) {
            itemVenda.setValorUnitario(produtoTela.getValorFracionado());
        } else {
            itemVenda.setValorUnitario(produtoTela.getValorDeVenda());
        }
    }

    private List<UnidadeDeMedida> getUnidadeProduto() {
        List<UnidadeDeMedida> lista = new ArrayList<UnidadeDeMedida>();

        if (produtoTela.getUnidadeDeFracao() != null) {
            lista.add(produtoTela.getUnidadeDeFracao());
        }

        lista.add(produtoTela.getUnidadeDeVenda());

        return lista;

    }

    public void addItemLista() {
        ItemVenda item = new ItemVenda();

        if (itemVenda.getProduto() != null) {

            item.setProduto(itemVenda.getProduto());

            if (itemVenda.getUnidadeDeVenda() != null) {
                item.setUnidadeDeVenda(itemVenda.getUnidadeDeVenda());
            } else {
                FacesMessageUtils.error("Unidade de Venda é obrigatória!");
            }

            if (itemVenda.getIcmsCompra() != null) {
                item.setIcmsCompra(itemVenda.getIcmsCompra());
            } else {
                FacesMessageUtils.error("Icms é ç!");
            }

            if (itemVenda.getQtd() != null) {
                item.setQtd(itemVenda.getQtd());
            } else {
                FacesMessageUtils.error("Quantidade é obrigatória!");
            }

            if (itemVenda.getDesconto() != null) {
                item.setDesconto(itemVenda.getDesconto());
            } else {
                item.setDesconto(BigDecimal.ZERO);
            }

            if (itemVenda.getDesconto() != null) {
                item.setDesconto(itemVenda.getDesconto());
            } else {
                item.setDesconto(BigDecimal.ZERO);
            }

            if (itemVenda.getIpi() != null) {
                item.setIpi(itemVenda.getIpi());
            } else {
                FacesMessageUtils.error("Ipi é obrigatória!");
            }

            if (itemVenda.getValorUnitario() != null) {
                item.setValorUnitario(itemVenda.getValorUnitario());
            } else {
                FacesMessageUtils.error("Valor Unitário é obrigatório!");
            }
            if (verificaItemExistente(item)) {
                FacesMessageUtils.error("O produto " + itemVenda.getProduto().getDescricao() + " já foi adicionado! Escolha outro produto!");
                itemVenda = new ItemVenda();
                produtoTela = new Produto();
            }
//            if (verificarItemExisteEmEstoque(item)) {
//                FacesMessageUtils.error("O produto " + itemVenda.getProduto().getDescricao() + " não está cadastrado em Estoque!");
//                itemVenda = new ItemVenda();
//                produtoTela = new Produto();
//            }

            if (!verificaItemExistente(item) && itemVenda.getUnidadeDeVenda() != null && itemVenda.getIcmsCompra() != null
                    && itemVenda.getQtd() != null && itemVenda.getIpi() != null && itemVenda.getValorUnitario() != null) {
                item.setVenda(getEntity());
                getEntity().getItensVenda().add(item);
                itemVenda = new ItemVenda();
                produtoTela = new Produto();
            }

        } else {
            FacesMessageUtils.error("Produto é obrigatório!");
        }

    }

    public BigDecimal getTotalPorProduto(BigDecimal qtd, BigDecimal valorUnitario, BigDecimal icms, BigDecimal ipi, BigDecimal desconto) {
        BigDecimal valor = BigDecimal.ZERO;

        valor = valor.add(qtd);
        valor = valor.multiply(valorUnitario);
        valor = valor.add(calculaValorPorcentagem(icms, valorUnitario));
        valor = valor.add(calculaValorPorcentagem(ipi, valorUnitario));
        valor = valor.subtract(calculaValorPorcentagem(desconto, valor));

        return valor;
    }

    public void editarProduto(ItemVenda item) {

    }

    public void removerItemLista(ItemVenda item) throws DeleteException {

        if (item.isAtivo()) {
            itemDAO.delete(item.getId());
            getEntity().getItensVenda().remove(item);

            Produto produto = vendaDAO.getInitialized(item.getProduto());

            Estoque estoque = estoqueDAO.unique("produto_id", produto.getId());

            if (estoque != null) {
                if (produto.isProdutoFracionado() && verificaTipo(item.getUnidadeDeVenda()) && item.getId() == null) {
                    BigDecimal valor = BigDecimal.ZERO;
                    valor = valor.add(item.getQtd().multiply(produto.getQtdFracoes() != null ? new BigDecimal(produto.getQtdFracoes()) : BigDecimal.ONE));
                    estoque.setQuantidade(estoque.getQuantidade().add(valor));
                } else {
                    estoque.setQuantidade(estoque.getQuantidade().add(item.getQtd()));
                }
                estoqueBO.getDAO().saveOrMerge(estoque);
            }
        } else {
            getEntity().getItensVenda().remove(item);
        }
    }

    private boolean verificaItemExistente(ItemVenda itemReal) {
        for (ItemVenda item : getEntity().getItensVenda()) {
            if (item.getProduto().equals(itemReal.getProduto())) {
                return true;
            }
        }
        return false;
    }

    private boolean verificarItemExisteEmEstoque(ItemVenda itemReal) {

        if (estoqueDAO.find(itemReal.getProduto().getId()) != null) {
            return false;
        }
        return true;
    }

    public ItemVenda getItemVenda() {
        return itemVenda;
    }

    public void setItemVenda(ItemVenda itemVenda) {
        this.itemVenda = itemVenda;
    }

    public ItemVenda getItemRemove() {
        return itemRemove;
    }

    public void setItemRemove(ItemVenda itemRemove) {
        this.itemRemove = itemRemove;
    }

    public Produto getProdutoTela() {
        return produtoTela;
    }

    public void setProdutoTela(Produto produtoTela) {
        this.produtoTela = produtoTela;
    }

    public Venda getVendaEditado() {
        return vendaEditado;
    }

    public void setVendaEditado(Venda vendaEditado) {
        this.vendaEditado = vendaEditado;
    }

    public List<Produto> getProdutosAtivos() {
        return produtosAtivos;
    }

    public void setProdutosAtivos(List<Produto> produtosAtivos) {
        this.produtosAtivos = produtosAtivos;
    }

    public BigDecimal getValorMercadoria() {
        BigDecimal valor = BigDecimal.ZERO;

        for (ItemVenda item : getEntity().getItensVenda()) {
            if (item.getValorUnitario() != null && item.getQtd() != null) {
                valor = valor.add(item.getValorUnitario().multiply(item.getQtd())).add(calculaValorPorcentagem(item.getIcmsCompra(),
                        item.getValorUnitario())).add(calculaValorPorcentagem(item.getIpi(), item.getValorUnitario()));
                valor = valor.subtract(calculaValorPorcentagem(item.getDesconto(), valor));
            }
        }

        return valor;
    }

    public BigDecimal getValorDaNota() {
        BigDecimal valor = BigDecimal.ZERO;
        if (getEntity().getDesconto() != null) {
            valor = valor.subtract(calculaValorPorcentagem(getEntity().getDesconto(), getValorMercadoria()));
        }
        if (getEntity().getValorEntrada() != null) {
            valor = valor.subtract(getEntity().getValorEntrada());
        }

        return valor.add(getValorMercadoria());
    }

    public BigDecimal getTotalIcms() {
        BigDecimal valor = BigDecimal.ZERO;
        for (ItemVenda item : getEntity().getItensVenda()) {
            if (item.getIcmsCompra() != null && getValorMercadoria() != null) {
                valor = valor.add(calculaValorPorcentagem(item.getIcmsCompra(), getValorMercadoria()));
            }
        }
        return valor;
    }

    public BigDecimal getTotalIpi() {
        BigDecimal valor = BigDecimal.ZERO;
        for (ItemVenda item : getEntity().getItensVenda()) {
            if (item.getIpi() != null && getValorMercadoria() != null) {
                valor = valor.add(calculaValorPorcentagem(item.getIpi(), getValorMercadoria()));
            }
        }
        return valor;
    }

    public BigDecimal getTotalDescontoProduto() {
        BigDecimal valor = BigDecimal.ZERO;
        for (ItemVenda item : getEntity().getItensVenda()) {
            if (item.getDesconto() != null && getValorMercadoria() != null) {
                valor = valor.add(calculaValorPorcentagem(item.getDesconto(), getValorMercadoria()));
            }
        }
        return valor;
    }

    private BigDecimal calculaValorPorcentagem(BigDecimal porcentagem, BigDecimal valor) {
        BigDecimal valorRetorno = BigDecimal.ZERO;

        valorRetorno = valorRetorno.add(porcentagem.multiply(valor).divide(BigDecimal.valueOf(100), 2, BigDecimal.ROUND_UP));

        return valorRetorno;
    }

    private boolean verificaTipo(UnidadeDeMedida unidade) {
        if (unidade == UnidadeDeMedida.FRD || unidade == UnidadeDeMedida.CX || unidade == UnidadeDeMedida.DZ || unidade == UnidadeDeMedida.PCT) {
            return true;
        }
        return false;
    }

    public boolean verificarCampoFracao() {
        return (itemVenda.getUnidadeDeVenda() == UnidadeDeMedida.KG || itemVenda.getUnidadeDeVenda() == UnidadeDeMedida.L
                || itemVenda.getUnidadeDeVenda() == UnidadeDeMedida.T || itemVenda.getUnidadeDeVenda() == UnidadeDeMedida.M2
                || itemVenda.getUnidadeDeVenda() == UnidadeDeMedida.M3);
    }

    private boolean constaisItem(ItemVenda item) {
        for (ItemVenda itemTemp : itensVendaTemp) {
            if (itemTemp.getId().equals(item.getId())) {
                return true;
            }
        }
        return false;
    }

    public void duplicarVenda(Long id) {
        Long idNovo = null;
        idNovo = vendaBO.dupliclarVenda(id);
        if (idNovo != null) {
            FacesUtils.redirect("/view/faturamento/venda/createVenda.jsf?id=" + idNovo);
        }
    }

    public void gerarNota(Venda venda) {
        vendaBO.gerarOrcamento(venda);
    }

    private String getObservacao() {
        return vendaBO.pegarUltimoComplemento(getEntity().getLoja()!= null ? getEntity().getLoja().getId() : null);
    }

    public void setValorPorEmpresa() {
        getEntity().setCampoComplementar(getObservacao());
    }
}
