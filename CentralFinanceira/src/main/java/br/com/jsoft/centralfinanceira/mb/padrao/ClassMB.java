package br.com.jsoft.centralfinanceira.mb.padrao;

import br.com.jsoft.centralfinanceira.modelo.enums.EstadoCivil;
import br.com.jsoft.centralfinanceira.modelo.enums.Escolaridade;
import br.com.jsoft.centralfinanceira.modelo.enums.TipoContaBanco;
import br.com.jsoft.centralfinanceira.modelo.enums.Bancos;
import br.com.jsoft.centralfinanceira.modelo.contrato.PagContas;
import br.com.jsoft.centralfinanceira.modelo.contrato.Contrato;
import br.com.jsoft.centralfinanceira.modelo.central.FatosBanPop;
import br.com.jsoft.centralfinanceira.modelo.central.ConvenioBanPop;
import br.com.jsoft.centralfinanceira.modelo.central.Conveniobb;
import br.com.jsoft.centralfinanceira.modelo.central.Fatosbb;
import br.com.jsoft.centralfinanceira.modelo.central.FatosRecarga;
import br.com.jsoft.centralfinanceira.modelo.central.ConvenioRecarga;
import br.com.jsoft.centralfinanceira.modelo.central.Cidade;
import br.com.jsoft.centralfinanceira.modelo.central.ConvenioBoleto;
import br.com.jsoft.centralfinanceira.modelo.central.ConvenioGas;
import br.com.jsoft.centralfinanceira.modelo.central.ConvenioSite;
import br.com.jsoft.centralfinanceira.modelo.central.Conveniocredigi;
import br.com.jsoft.centralfinanceira.modelo.central.Conveniop;
import br.com.jsoft.centralfinanceira.modelo.central.DespesaLoja;
import br.com.jsoft.centralfinanceira.modelo.central.FatosBoletoSite;
import br.com.jsoft.centralfinanceira.modelo.central.FatosBoletos;
import br.com.jsoft.centralfinanceira.modelo.central.FatosCreditos;
import br.com.jsoft.centralfinanceira.modelo.central.FatosValeGas;
import br.com.jsoft.centralfinanceira.modelo.central.Fatosops;
import br.com.jsoft.centralfinanceira.modelo.central.Loja;
import br.com.jsoft.centralfinanceira.modelo.central.ReceitaLoja;
import br.com.jsoft.centralfinanceira.modelo.central.Segmento;
import br.com.jsoft.centralfinanceira.modelo.central.TipoDespesa;
import br.com.jsoft.centralfinanceira.modelo.central.TipoFloat;
import br.com.jsoft.centralfinanceira.modelo.central.TipoLoja;
import br.com.jsoft.centralfinanceira.modelo.central.TipoReceita;
import br.com.jsoft.centralfinanceira.modelo.central.Uf;
import br.com.jsoft.centralfinanceira.modelo.controleacesso.Permissao;
import br.com.jsoft.centralfinanceira.modelo.configuracao.ErroSistema;
import br.com.jsoft.centralfinanceira.modelo.contrato.Endereco;
import br.com.jsoft.centralfinanceira.modelo.contrato.Equipe;
import br.com.jsoft.centralfinanceira.modelo.contrato.Filho;
import br.com.jsoft.centralfinanceira.modelo.controleacesso.SituacaoUsuario;
import br.com.jsoft.centralfinanceira.modelo.controleacesso.AcessoSistema;
import br.com.jsoft.centralfinanceira.modelo.email.ConfiguracaoEmail;
import br.com.jsoft.centralfinanceira.modelo.controleacesso.Perfil;
import br.com.jsoft.centralfinanceira.modelo.controleacesso.HistoricoSituacaoUsuario;
import br.com.jsoft.centralfinanceira.modelo.email.ModeloEmail;
import br.com.jsoft.centralfinanceira.modelo.controleacesso.SolicitacaoRecuperacaoSenha;
import br.com.jsoft.centralfinanceira.modelo.email.TipoAssuntoEmail;
import br.com.jsoft.centralfinanceira.modelo.controleacesso.TipoRecuperacaoSenha;
import br.com.jsoft.centralfinanceira.modelo.controleacesso.Usuario;
import br.com.jsoft.centralfinanceira.modelo.enums.CidadeOuLoja;
import br.com.jsoft.centralfinanceira.modelo.enums.TipoBoletos;
import javax.faces.bean.ManagedBean;

@ManagedBean
public class ClassMB {

    public Class getLoja() {
        return Loja.class;
    }

    public Class getFatosBoletoSite() {
        return FatosBoletoSite.class;
    }

    public Class getConvenioSite() {
        return ConvenioSite.class;
    }

    public Class getAcessoSistema() {
        return AcessoSistema.class;
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

    public Class getTipoFloat() {
        return TipoFloat.class;
    }

    public Class getConvenioBoleto() {
        return ConvenioBoleto.class;
    }

    public Class getUf() {
        return Uf.class;
    }

    public Class getCidade() {
        return Cidade.class;
    }

    public Class getSegmento() {
        return Segmento.class;
    }

    public Class getFatosBoletos() {
        return FatosBoletos.class;
    }

    public Class getConveniop() {
        return Conveniop.class;
    }

    public Class getFatosops() {
        return Fatosops.class;
    }

    public Class getConveniocredigi() {
        return Conveniocredigi.class;
    }

    public Class getFatosCreditos() {
        return FatosCreditos.class;
    }

    public Class getFatosValeGas() {
        return FatosValeGas.class;
    }

    public Class getConvenioGas() {
        return ConvenioGas.class;
    }

    public Class getFatosRecarga() {
        return FatosRecarga.class;
    }

    public Class getConvenioRecarga() {
        return ConvenioRecarga.class;
    }

    public Class getConveniobb() {
        return Conveniobb.class;
    }

    public Class getFatosbb() {
        return Fatosbb.class;
    }

    public Class getFatosBanPop() {
        return FatosBanPop.class;
    }

    public Class getConvenioBanPop() {
        return ConvenioBanPop.class;
    }

    public Class getEstadoCivil() {
        return EstadoCivil.class;
    }

    public Class getCidadeOuLoja() {
        return CidadeOuLoja.class;
    }

    public Class getTipoBoletos() {
        return TipoBoletos.class;
    }

    public Class getEscolaridade() {
        return Escolaridade.class;
    }

    public Class getTipoContaBanco() {
        return TipoContaBanco.class;
    }

    public Class getBancos() {
        return Bancos.class;
    }

    public Class getPagContas() {
        return PagContas.class;
    }

    public Class getContrato() {
        return Contrato.class;
    }

    public Class getEquipe() {
        return Equipe.class;
    }

    public Class getFilho() {
        return Filho.class;
    }

    public Class getEndereco() {
        return Endereco.class;
    }

    public Class getTipoDespesa() {
        return TipoDespesa.class;
    }

    public Class getReceitaLoja() {
        return ReceitaLoja.class;
    }

    public Class getTipoReceita() {
        return TipoReceita.class;
    }

    public Class getDespesaLoja() {
        return DespesaLoja.class;
    }
    
    public Class getTipoLoja() {
        return TipoLoja.class;
    }


}
