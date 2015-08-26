package com.mycompany.controleestoque.mb.padrao;

import com.mycompany.controleestoque.modelo.faturamento.ItemVenda;
import com.mycompany.controleestoque.modelo.faturamento.Venda;
import com.mycompany.controleestoque.modelo.faturamento.Estoque;
import com.mycompany.controleestoque.modelo.faturamento.ItemPedido;
import com.mycompany.controleestoque.modelo.cadastro.enums.FormaDePagamento;
import com.mycompany.controleestoque.modelo.faturamento.Pedido;
import com.mycompany.controleestoque.modelo.cadastro.NaturezasDeOperacoes;
import com.mycompany.controleestoque.modelo.cadastro.Banco;
import com.mycompany.controleestoque.modelo.cadastro.Fornecedor;
import com.mycompany.controleestoque.modelo.cadastro.Loja_Filial;
import com.mycompany.controleestoque.modelo.cadastro.Produto;
import com.mycompany.controleestoque.modelo.cadastro.enums.TipoFornecedor;
import com.mycompany.controleestoque.modelo.cadastro.GruposDeSecoes;
import com.mycompany.controleestoque.modelo.cadastro.SecoesProduto;
import com.mycompany.controleestoque.modelo.cadastro.GrupoLoja;
import com.mycompany.controleestoque.modelo.cadastro.SituacaoTributaria;
import com.mycompany.controleestoque.modelo.cadastro.enums.TipoLoja;
import com.mycompany.controleestoque.modelo.cadastro.enums.TipoEndereco;
import com.mycompany.controleestoque.modelo.cadastro.enums.TipoCliente;
import com.mycompany.controleestoque.modelo.cadastro.Pais;
import com.mycompany.controleestoque.modelo.cadastro.enums.EstadoCivil;
import com.mycompany.controleestoque.modelo.cadastro.Cidade;
import com.mycompany.controleestoque.modelo.cadastro.Estado;
import com.mycompany.controleestoque.modelo.cadastro.Cliente;
import com.mycompany.controleestoque.modelo.cadastro.ContaBancaria;
import com.mycompany.controleestoque.modelo.cadastro.enums.TipoDePessoa;
import com.mycompany.controleestoque.modelo.cadastro.enums.Sexo;
import com.mycompany.controleestoque.modelo.cadastro.Convenio;
import com.mycompany.controleestoque.modelo.cadastro.enums.ModalidadeFrete;
import com.mycompany.controleestoque.modelo.cadastro.enums.StatusNF;
import com.mycompany.controleestoque.modelo.cadastro.enums.TipoDeConta;
import com.mycompany.controleestoque.modelo.cadastro.enums.TipoInsencaoCliente;
import com.mycompany.controleestoque.modelo.cadastro.enums.TipoPedido;
import com.mycompany.controleestoque.modelo.cadastro.enums.UnidadeDeMedida;
import com.mycompany.controleestoque.modelo.controleacesso.Permissao;
import com.mycompany.controleestoque.modelo.controleacesso.Usuario;
import com.mycompany.controleestoque.modelo.configuracao.ErroSistema;
import com.mycompany.controleestoque.modelo.controleacesso.SituacaoUsuario;
import com.mycompany.controleestoque.modelo.controleacesso.AcessoSistema;
import com.mycompany.controleestoque.modelo.email.ConfiguracaoEmail;
import com.mycompany.controleestoque.modelo.controleacesso.Perfil;
import com.mycompany.controleestoque.modelo.controleacesso.HistoricoSituacaoUsuario;
import com.mycompany.controleestoque.modelo.email.ModeloEmail;
import com.mycompany.controleestoque.modelo.controleacesso.SolicitacaoRecuperacaoSenha;
import com.mycompany.controleestoque.modelo.email.TipoAssuntoEmail;
import com.mycompany.controleestoque.modelo.controleacesso.TipoRecuperacaoSenha;
import com.mycompany.controleestoque.modelo.faturamento.NotaFiscal;
import javax.faces.bean.ManagedBean;

@ManagedBean
public class ClassMB {

    public Class getAcessoSistema() {
        return AcessoSistema.class;
    }

    public Class getModalidadeFrete() {
        return ModalidadeFrete.class;
    }

    public Class getErroSistema() {
        return ErroSistema.class;
    }

    public Class getHistoricoSituacaoUsuario() {
        return HistoricoSituacaoUsuario.class;
    }

    public Class getPerfil() {
        return Perfil.class;
    }

    public Class getPermissao() {
        return Permissao.class;
    }

    public Class getSituacaoUsuario() {
        return SituacaoUsuario.class;
    }

    public Class getUsuario() {
        return Usuario.class;
    }

    public Class getTipoAssuntoEmail() {
        return TipoAssuntoEmail.class;
    }

    public Class getModeloEmail() {
        return ModeloEmail.class;
    }

    public Class getSolicitacaoRecuperacaoSenha() {
        return SolicitacaoRecuperacaoSenha.class;
    }

    public Class getTipoRecuperacaoSenha() {
        return TipoRecuperacaoSenha.class;
    }

    public Class getConfiguracaoEmail() {
        return ConfiguracaoEmail.class;
    }

    public Class getTipoEndereco() {
        return TipoEndereco.class;
    }

    public Class getTipoCliente() {
        return TipoCliente.class;
    }

    public Class getPais() {
        return Pais.class;
    }

    public Class getEstadoCivil() {
        return EstadoCivil.class;
    }

    public Class getCidade() {
        return Cidade.class;
    }

    public Class getEstado() {
        return Estado.class;
    }

    public Class getCliente() {
        return Cliente.class;
    }

    public Class getTipoInsencaoCliente() {
        return TipoInsencaoCliente.class;
    }

    public Class getTipoDePessoa() {
        return TipoDePessoa.class;
    }

    public Class getSexo() {
        return Sexo.class;
    }

    public Class getConvenio() {
        return Convenio.class;
    }

    public Class getFornecedor() {
        return Fornecedor.class;
    }

    public Class getLoja_Filial() {
        return Loja_Filial.class;
    }

    public Class getProduto() {
        return Produto.class;
    }

    public Class getTipoFornecedor() {
        return TipoFornecedor.class;
    }

    public Class getUnidadeDeMedita() {
        return UnidadeDeMedida.class;
    }

    public Class getGruposDeSocoes() {
        return GruposDeSecoes.class;
    }

    public Class getSecoesProduto() {
        return SecoesProduto.class;
    }

    public Class getGrupoLoja() {
        return GrupoLoja.class;
    }

    public Class getSituacaoTributaria() {
        return SituacaoTributaria.class;
    }

    public Class getTipoLoja() {
        return TipoLoja.class;
    }

    public Class getNaturezasDeOperacoes() {
        return NaturezasDeOperacoes.class;
    }

    public Class getBanco() {
        return Banco.class;
    }

    public Class getFormaDePagamento() {
        return FormaDePagamento.class;
    }

    public Class getUnidadeDeMedida() {
        return UnidadeDeMedida.class;
    }

    public Class getPedido() {
        return Pedido.class;
    }

    public Class getItemPedido() {
        return ItemPedido.class;
    }

    public Class getEstoque() {
        return Estoque.class;
    }

    public Class getItemVenda() {
        return ItemVenda.class;
    }

    public Class getVenda() {
        return Venda.class;
    }

    public Class getContaBancaria() {
        return ContaBancaria.class;
    }

    public Class getTipoDeConta() {
        return TipoDeConta.class;
    }

    public Class getTipoPedido() {
        return TipoPedido.class;
    }

    public Class getNotaFiscal() {
        return NotaFiscal.class;
    }

    public Class getStatusNF() {
        return StatusNF.class;
    }

}
