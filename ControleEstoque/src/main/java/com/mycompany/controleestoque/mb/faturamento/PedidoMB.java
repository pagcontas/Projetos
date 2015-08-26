package com.mycompany.controleestoque.mb.faturamento;

import com.mycompany.controleestoque.bo.faturamento.EstoqueBO;
import java.io.Serializable;
import com.xpert.core.crud.AbstractBaseBean;
import javax.ejb.EJB;
import javax.faces.bean.ManagedBean;
import javax.faces.bean.ViewScoped;
import com.mycompany.controleestoque.bo.faturamento.PedidoBO;
import com.mycompany.controleestoque.dao.cadastro.ProdutoDAO;
import com.mycompany.controleestoque.dao.faturamento.EstoqueDAO;
import com.mycompany.controleestoque.dao.faturamento.ItemPedidoDAO;
import com.mycompany.controleestoque.dao.faturamento.PedidoDAO;
import com.mycompany.controleestoque.modelo.cadastro.Produto;
import com.mycompany.controleestoque.modelo.cadastro.enums.UnidadeDeMedida;
import com.mycompany.controleestoque.modelo.faturamento.Estoque;
import com.mycompany.controleestoque.modelo.faturamento.ItemPedido;
import com.mycompany.controleestoque.modelo.faturamento.Pedido;
import com.xpert.core.exception.BusinessException;
import com.xpert.faces.utils.FacesMessageUtils;
import com.xpert.faces.utils.FacesUtils;
import com.xpert.persistence.exception.DeleteException;
import java.math.BigDecimal;
import java.util.ArrayList;
import java.util.List;

/**
 *
 * @author juniel
 */
@ManagedBean
@ViewScoped
public class PedidoMB extends AbstractBaseBean<Pedido> implements Serializable {

    @EJB
    private PedidoBO pedidoBO;

    @EJB
    private PedidoDAO pedidoDAO;

    @EJB
    private EstoqueBO estoqueBO;

    @EJB
    private EstoqueDAO estoqueDAO;

    @EJB
    private ItemPedidoDAO itemDAO;

    @EJB
    private ProdutoDAO produtoDAO;

    private ItemPedido itemPedido;

    private Produto produtoTela;

    private Pedido pedidoEditado;

    private Pedido pedidoImpress;

    private boolean renderCampo = false;

    private List<UnidadeDeMedida> listUnidade;

    public List<UnidadeDeMedida> getListUnidade() {
        return listUnidade;
    }

    public void setListUnidade(List<UnidadeDeMedida> listUnidade) {
        this.listUnidade = listUnidade;
    }

    public boolean isRenderCampo() {
        return renderCampo;
    }

    @Override
    public void postSave() {
        if (getId() != null) {
            FacesUtils.redirect("/view/faturamento/pedido/listPedido.jsf");
        } else {
            setEntity(new Pedido());
        }
    }

    public void setRenderCampo(boolean renderCampo) {
        this.renderCampo = renderCampo;
    }

    @Override
    public PedidoBO getBO() {
        return pedidoBO;
    }

    @Override
    public String getDataModelOrder() {
        return "id";
    }

    @Override
    public void init() {
        itemPedido = new ItemPedido();
    }

    public void setarCamposDeItens() {
        if (produtoTela != null) {
            listUnidade = getUnidadeProduto();
            itemPedido.setProduto(produtoTela);
            itemPedido.setUnidadeDeVenda(produtoTela.getUnidadeDeVenda());
            itemPedido.setIcmsCompra(produtoTela.getIcmsCompra());
            itemPedido.setIpi(produtoTela.getIpi());

            itemPedido.setValorUnitario(produtoTela.getValorDeVenda());

            itemPedido.setPedido(getEntity());
        }
    }

    public void setarValorFrancionado() {
        if (produtoTela.isProdutoFracionado() && !verificaTipo(itemPedido.getUnidadeDeVenda())) {
            itemPedido.setValorUnitario(produtoTela.getValorFracionado());
        } else {
            itemPedido.setValorUnitario(produtoTela.getValorDeVenda());
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
        ItemPedido item = new ItemPedido();

        if (itemPedido.getProduto() != null) {

            item.setProduto(itemPedido.getProduto());

            if (itemPedido.getUnidadeDeVenda() != null) {
                item.setUnidadeDeVenda(itemPedido.getUnidadeDeVenda());
            } else {
                FacesMessageUtils.error("Unidade de Venda é obrigatória!");
            }

            if (itemPedido.getIcmsCompra() != null) {
                item.setIcmsCompra(itemPedido.getIcmsCompra());
            } else {
                FacesMessageUtils.error("Icms é obrigatório!");
            }

            if (itemPedido.getQtd() != null) {
                item.setQtd(itemPedido.getQtd());
            } else {
                FacesMessageUtils.error("Quantidade é obrigatória!");
            }

            if (itemPedido.getDesconto() != null) {
                item.setDesconto(itemPedido.getDesconto());
            } else {
                item.setDesconto(BigDecimal.ZERO);
            }

            if (itemPedido.getIpi() != null) {
                item.setIpi(itemPedido.getIpi());
            } else {
                FacesMessageUtils.error("Ipi é obrigatória!");
            }

            if (itemPedido.getValorUnitario() != null) {
                item.setValorUnitario(itemPedido.getValorUnitario());
            } else {
                FacesMessageUtils.error("Valor Unitário é obrigatório!");
            }
            if (verificaItemExistente(item)) {
                FacesMessageUtils.error("O produto " + itemPedido.getProduto().getDescricao() + " já foi adicionado! Escolha outro produto!");
                itemPedido = new ItemPedido();
                produtoTela = new Produto();
            }

            if (!verificaItemExistente(item) && itemPedido.getUnidadeDeVenda() != null && itemPedido.getIcmsCompra() != null
                    && itemPedido.getQtd() != null && itemPedido.getIpi() != null && itemPedido.getValorUnitario() != null) {
                item.setPedido(getEntity());
                getEntity().getItensPedidos().add(item);
                itemPedido = new ItemPedido();
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

    public void editarProduto(ItemPedido item) {

    }

    public void removerItemLista(ItemPedido item) throws DeleteException {

        if (item.getId() != null) {
            itemDAO.delete(item.getId());
            getEntity().getItensPedidos().remove(item);
        } else {
            getEntity().getItensPedidos().remove(item);
        }

    }

    private boolean verificaItemExistente(ItemPedido itemReal) {
        for (ItemPedido item : getEntity().getItensPedidos()) {
            if (item.getProduto().equals(itemReal.getProduto())) {
                return true;
            }
        }
        return false;
    }

    public Produto getProdutoTela() {
        return produtoTela;
    }

    public Pedido getPedidoImpress() {
        return pedidoImpress;
    }

    public void setPedidoImpress(Pedido pedidoImpress) {
        this.pedidoImpress = pedidoImpress;
    }

    public void setProdutoTela(Produto produtoTela) {
        this.produtoTela = produtoTela;
    }

    public ItemPedido getItemPedido() {
        return itemPedido;
    }

    public void setItemPedido(ItemPedido itemPedido) {
        this.itemPedido = itemPedido;
    }

    public BigDecimal getValorMercadoria() {
        BigDecimal valor = BigDecimal.ZERO;

        for (ItemPedido item : getEntity().getItensPedidos()) {
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
        if (getEntity().getValorDoFrete() != null) {
            valor = valor.add(getEntity().getValorDoFrete());
        }

        return valor.add(getValorMercadoria());
    }

    public BigDecimal getTotalIcms() {
        BigDecimal valor = BigDecimal.ZERO;
        for (ItemPedido item : getEntity().getItensPedidos()) {
            if (item.getIcmsCompra() != null && getValorMercadoria() != null) {
                valor = valor.add(calculaValorPorcentagem(item.getIcmsCompra(), getValorMercadoria()));
            }
        }
        return valor;
    }

    public BigDecimal getTotalIpi() {
        BigDecimal valor = BigDecimal.ZERO;
        for (ItemPedido item : getEntity().getItensPedidos()) {
            if (item.getIpi() != null && getValorMercadoria() != null) {
                valor = valor.add(calculaValorPorcentagem(item.getIpi(), getValorMercadoria()));
            }
        }
        return valor;
    }

    public BigDecimal getTotalDesconto() {
        BigDecimal valor = BigDecimal.ZERO;
        for (ItemPedido item : getEntity().getItensPedidos()) {
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

    @Override
    public void save() {
        getEntity().setValorDaNota(getValorMercadoria());
        getEntity().setValorMercadoria(getValorDaNota());
        super.save();
    }

    public void confirmarPedido() throws BusinessException {

        pedidoEditado.setItensPedidos(pedidoDAO.getInitialized(pedidoEditado.getItensPedidos()));

        for (ItemPedido item : pedidoEditado.getItensPedidos()) {

            Produto produto = produtoDAO.unique("id", item.getProduto().getId());

            if (item.isAtualizarValor()) {
                produto.setValorDaCompra(item.getValorUnitario());
                produtoDAO.saveOrMerge(produto);
            }

            Estoque estoque = estoqueDAO.unique("produto_id", item.getProduto().getId());

            if (estoque != null) {
                if (produto.isProdutoFracionado() && verificaTipo(item.getUnidadeDeVenda())) {
                    BigDecimal valor = BigDecimal.ZERO;
                    valor = valor.add(item.getQtd().multiply(produto.getQtdFracoes() != null ? new BigDecimal(produto.getQtdFracoes()) : BigDecimal.ONE));
                    estoque.addQuantidade(valor);
                } else {
                    estoque.addQuantidade(item.getQtd());
                }
            } 

            estoqueDAO.saveOrMerge(estoque);
        }

        pedidoEditado.setAtivo(true);
        pedidoDAO.saveOrMerge(pedidoEditado);
        
        FacesMessageUtils.info("Pedido confirmada com sucesso!");

    }

    private boolean verificaTipo(UnidadeDeMedida unidade) {
        if (unidade == UnidadeDeMedida.FRD || unidade == UnidadeDeMedida.CX || unidade == UnidadeDeMedida.DZ || unidade == UnidadeDeMedida.PCT) {
            return true;
        }
        return false;
    }

    public Pedido getPedidoEditado() {
        return pedidoEditado;
    }

    public void setPedidoEditado(Pedido pedidoEditado) {
        this.pedidoEditado = pedidoEditado;
    }

    public void gerarPedidoPDF() {
        pedidoBO.gerarPedidoPdf(pedidoImpress);
    }

    public boolean verificarCampoFracao() {
        return (itemPedido.getUnidadeDeVenda() == UnidadeDeMedida.KG || itemPedido.getUnidadeDeVenda() == UnidadeDeMedida.L
                || itemPedido.getUnidadeDeVenda() == UnidadeDeMedida.T || itemPedido.getUnidadeDeVenda() == UnidadeDeMedida.M2
                || itemPedido.getUnidadeDeVenda() == UnidadeDeMedida.M3);
    }
}
