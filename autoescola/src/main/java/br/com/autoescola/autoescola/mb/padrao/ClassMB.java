package br.com.autoescola.autoescola.mb.padrao;

import br.com.autoescola.autoescola.modelo.simulado.TipoProva;
import br.com.autoescola.autoescola.modelo.simulado.Alternativa;
import br.com.autoescola.autoescola.modelo.simulado.LetraAlternativa;
import br.com.autoescola.autoescola.modelo.simulado.Questao;
import br.com.autoescola.autoescola.modelo.controleacesso.Permissao;
import br.com.autoescola.autoescola.modelo.controleacesso.Usuario;
import br.com.autoescola.autoescola.modelo.configuracao.ErroSistema;
import br.com.autoescola.autoescola.modelo.controleacesso.SituacaoUsuario;
import br.com.autoescola.autoescola.modelo.controleacesso.AcessoSistema;
import br.com.autoescola.autoescola.modelo.email.ConfiguracaoEmail;
import br.com.autoescola.autoescola.modelo.controleacesso.Perfil;
import br.com.autoescola.autoescola.modelo.controleacesso.HistoricoSituacaoUsuario;
import br.com.autoescola.autoescola.modelo.email.ModeloEmail;
import br.com.autoescola.autoescola.modelo.controleacesso.SolicitacaoRecuperacaoSenha;
import br.com.autoescola.autoescola.modelo.email.TipoAssuntoEmail;
import br.com.autoescola.autoescola.modelo.controleacesso.TipoRecuperacaoSenha;
import br.com.autoescola.autoescola.modelo.cadastro.enums.EstadoCivil;
import br.com.autoescola.autoescola.modelo.cadastro.enums.Categoria;
import br.com.autoescola.autoescola.modelo.cadastro.Cidade;
import br.com.autoescola.autoescola.modelo.cadastro.enums.Sexo;
import br.com.autoescola.autoescola.modelo.cadastro.Pais;
import br.com.autoescola.autoescola.modelo.cadastro.enums.Escolaridade;
import br.com.autoescola.autoescola.modelo.cadastro.enums.TipoCNH;
import br.com.autoescola.autoescola.modelo.cadastro.Pessoa;
import br.com.autoescola.autoescola.modelo.cadastro.Estado;
import br.com.autoescola.autoescola.modelo.cadastro.Aluno;
import br.com.autoescola.autoescola.modelo.financeiro.Pagamento;
import br.com.autoescola.autoescola.modelo.financeiro.Parcelas;
import br.com.autoescola.autoescola.modelo.financeiro.enums.Bandeira;

import javax.faces.bean.ManagedBean;

@ManagedBean
public class ClassMB {

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

    public Class getEstadoCivil() {
        return EstadoCivil.class;
    }

    public Class getCategoria() {
        return Categoria.class;
    }

    public Class getCidade() {
        return Cidade.class;
    }

    public Class getSexo() {
        return Sexo.class;
    }

    public Class getPais() {
        return Pais.class;
    }

    public Class getEscolaridade() {
        return Escolaridade.class;
    }

    public Class getTipoCNH() {
        return TipoCNH.class;
    }

    public Class getPessoa() {
        return Pessoa.class;
    }

    public Class getEstado() {
        return Estado.class;
    }

    public Class getAluno() {
        return Aluno.class;
    }

     public Class getParcelas() {
        return Parcelas.class;
    }
    public Class getBandeira() {
        return Bandeira.class;
    }
    public Class getPagamento() {
        return Pagamento.class;
    }


    public Class getTipoProva() {
        return TipoProva.class;
    }
    public Class getAlternativa() {
        return Alternativa.class;
    }
    public Class getLetraAlternativa() {
        return LetraAlternativa.class;
    }
    public Class getQuestao() {
        return Questao.class;
    }

}