package com.uparquivos.mb.padrao;

import com.uparquivos.modelo.upArquivos.Arquivo;
import com.uparquivos.modelo.upArquivos.BaseLegal;
import com.uparquivos.modelo.exemplo.PessoaExemplo;
import com.uparquivos.modelo.controleacesso.Permissao;
import com.uparquivos.modelo.controleacesso.Usuario;
import com.uparquivos.modelo.configuracao.ErroSistema;
import com.uparquivos.modelo.controleacesso.SituacaoUsuario;
import com.uparquivos.modelo.controleacesso.AcessoSistema;
import com.uparquivos.modelo.email.ConfiguracaoEmail;
import com.uparquivos.modelo.controleacesso.Perfil;
import com.uparquivos.modelo.controleacesso.HistoricoSituacaoUsuario;
import com.uparquivos.modelo.email.ModeloEmail;
import com.uparquivos.modelo.controleacesso.SolicitacaoRecuperacaoSenha;
import com.uparquivos.modelo.email.TipoAssuntoEmail;
import com.uparquivos.modelo.controleacesso.TipoRecuperacaoSenha;
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
    public Class getPessoaExemplo() {
        return PessoaExemplo.class;
    }

    public Class getArquivo() {
        return Arquivo.class;
    }
    public Class getBaseLegal() {
        return BaseLegal.class;
    }

}