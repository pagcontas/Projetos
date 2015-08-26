package com.mycompany.controleestoque.bo.faturamento;

import com.mycompany.controleestoque.dao.cadastro.ProdutoDAO;
import com.mycompany.controleestoque.dao.faturamento.EstoqueDAO;
import com.mycompany.controleestoque.dao.faturamento.ItemPedidoDAO;
import com.xpert.core.crud.AbstractBusinessObject;
import com.mycompany.controleestoque.dao.faturamento.PedidoDAO;
import com.mycompany.controleestoque.modelo.cadastro.Cidade;
import com.mycompany.controleestoque.modelo.cadastro.Estado;
import com.mycompany.controleestoque.modelo.cadastro.Loja_Filial;
import com.mycompany.controleestoque.modelo.cadastro.Produto;
import com.mycompany.controleestoque.modelo.cadastro.enums.TipoPedido;
import com.mycompany.controleestoque.modelo.cadastro.enums.UnidadeDeMedida;
import com.mycompany.controleestoque.modelo.faturamento.Estoque;
import com.mycompany.controleestoque.modelo.faturamento.ItemPedido;
import com.xpert.core.validation.UniqueField;
import com.xpert.core.exception.BusinessException;
import java.util.List;
import javax.ejb.EJB;
import javax.ejb.Stateless;
import com.mycompany.controleestoque.modelo.faturamento.Pedido;
import com.mycompany.controleestoque.vo.SolicitacaoPedidoVO;
import com.xpert.faces.utils.FacesJasper;
import com.xpert.persistence.exception.DeleteException;
import java.math.BigDecimal;
import java.text.SimpleDateFormat;
import java.util.ArrayList;
import java.util.Date;
import java.util.HashMap;
import javax.faces.context.FacesContext;

/**
 *
 * @author juniel
 */
@Stateless
public class PedidoBO extends AbstractBusinessObject<Pedido> {

    @EJB
    private PedidoDAO pedidoDAO;

    @EJB
    private ItemPedidoDAO itemDAO;

    @EJB
    private EstoqueDAO estoqueDAO;

    @EJB
    private ProdutoDAO produtoDAO;

    @Override
    public PedidoDAO getDAO() {
        return pedidoDAO;
    }

    @Override
    public void validate(Pedido pedido) throws BusinessException {
        if(pedido.getItensPedidos().isEmpty() || pedido.getItensPedidos()==null){
            throw new BusinessException("Produto é obrigatório!");
        }
    }

    @Override
    public boolean isAudit() {
        return true;
    }

    public void gerarPedidoPdf(Pedido item) {
        List<ItemPedido> itemPedidos;
        SolicitacaoPedidoVO solicitacaoPedido;
        List<SolicitacaoPedidoVO> listaVO = new ArrayList<SolicitacaoPedidoVO>();

        itemPedidos = pedidoDAO.getInitialized(item.getItensPedidos());
        Loja_Filial empresa = pedidoDAO.getInitialized(item.getLoja());
        Cidade cidade = pedidoDAO.getInitialized(empresa.getCidadeEndereco());
        Estado estado = pedidoDAO.getInitialized(cidade.getEstado());

        SimpleDateFormat dt = new SimpleDateFormat("dd/MM/yyyy HH:mm:ss");
        String caminhoLogo;
        caminhoLogo = FacesContext.getCurrentInstance().getExternalContext().getRealPath("/images/logo.png");
        HashMap params = new HashMap();
        params.put("cidadeCEP", cidade.getNome() + "-" + estado.getSigla() + ", " + dt.format(new Date()));
        params.put("caminhoImagem", caminhoLogo);
        params.put("rodaPe", empresa.getRazaoSocial() + ", " + empresa.getCnpj() + "\n" + empresa.getEndereco() + ", " + empresa.getNumero()
                + ", " + cidade.getNome() + "-" + estado.getSigla());
        params.put("valorTotal", item.getValorDaNota().setScale(2, BigDecimal.ROUND_HALF_UP).toString());
        params.put("valorDesconto", item.getDesconto()!=null ? item.getDesconto().setScale(2, BigDecimal.ROUND_HALF_UP).toString() : BigDecimal.ZERO);

        int i = 1;
        for (ItemPedido itemVO : itemPedidos) {
            solicitacaoPedido = new SolicitacaoPedidoVO(i, itemVO);
            listaVO.add(solicitacaoPedido);
        }

        FacesJasper.createJasperReport(listaVO, params,
                "/WEB-INF/report/relatorios/pedidoCompra.jasper", "Solicitação_Pedido_Compra.pdf");

    }

    @Override
    public void delete(Object id) throws DeleteException {
        Pedido pedido = pedidoDAO.find(id);
        for (ItemPedido item : pedido.getItensPedidos()) {
            itemDAO.delete(item.getId());
        }
        super.delete(id);

    }

    @Override
    public void save(Pedido pedido) throws BusinessException {
        List<ItemPedido> itensPedido = pedidoDAO.getInitialized(pedido.getItensPedidos());
        if (pedido.getTipo() == TipoPedido.ENTRADA) {
            for (ItemPedido item : itensPedido) {

                Estoque estoque = estoqueDAO.unique("produto_id", item.getProduto().getId());

                Produto produto = produtoDAO.unique("id", item.getProduto().getId());

                if (estoque != null) {

                    if (produto.isProdutoFracionado() && verificaTipo(item.getUnidadeDeVenda()) && item.getId()==null) {
                        BigDecimal valor = BigDecimal.ZERO;
                        valor = valor.add(item.getQtd().multiply(produto.getQtdFracoes() != null ? new BigDecimal(produto.getQtdFracoes()) : BigDecimal.ONE));
                        estoque.addQuantidade(valor);
                    } else {
                        estoque.addQuantidade(item.getQtd());
                    }

                    if (item.isAtualizarValor()) {
                        produto.setValorDaCompra(item.getValorUnitario());
                        produtoDAO.saveOrMerge(produto);
                    }
                } else {
                    estoque = new Estoque();
                    estoque.setEmpresa(pedido.getLoja());
                    estoque.setProduto(item.getProduto());
                    if (produto.isProdutoFracionado() && verificaTipo(item.getUnidadeDeVenda() ) && item.getId()==null) {
                        BigDecimal valor = BigDecimal.ZERO;
                        valor = valor.add(item.getQtd().multiply(produto.getQtdFracoes() != null ? new BigDecimal(produto.getQtdFracoes()) : BigDecimal.ONE));
                        estoque.addQuantidade(valor);
                    } else {
                        estoque.addQuantidade(item.getQtd());
                    }
                    estoque.setQtdMinima(BigDecimal.ZERO);

                }
                estoqueDAO.saveOrMerge(estoque);
            }
            pedido.setAtivo(true);
        }

        super.save(pedido);

    }

    @Override
    public List<UniqueField> getUniqueFields() {
        return null;
    }
    
    private boolean verificaTipo(UnidadeDeMedida unidade){
        if(unidade == UnidadeDeMedida.FRD || unidade == UnidadeDeMedida.CX || unidade == UnidadeDeMedida.DZ || unidade == UnidadeDeMedida.PCT){
            return true;
        }
        return false;
    }

}
