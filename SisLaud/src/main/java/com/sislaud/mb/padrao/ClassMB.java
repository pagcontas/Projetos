package com.sislaud.mb.padrao;

import com.sislaud.modelo.laudo.DowloadArquivos;
import com.sislaud.modelo.laudo.Laudo;
import com.sislaud.modelo.exemplo.PessoaExemplo;
import com.sislaud.modelo.controleacesso.Permissao;
import com.sislaud.modelo.controleacesso.Usuario;
import com.sislaud.modelo.configuracao.ErroSistema;
import com.sislaud.modelo.controleacesso.SituacaoUsuario;
import com.sislaud.modelo.controleacesso.AcessoSistema;
import com.sislaud.modelo.email.ConfiguracaoEmail;
import com.sislaud.modelo.controleacesso.Perfil;
import com.sislaud.modelo.controleacesso.HistoricoSituacaoUsuario;
import com.sislaud.modelo.email.ModeloEmail;
import com.sislaud.modelo.controleacesso.SolicitacaoRecuperacaoSenha;
import com.sislaud.modelo.email.TipoAssuntoEmail;
import com.sislaud.modelo.controleacesso.TipoRecuperacaoSenha;
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

    public Class getLaudo() {
        return Laudo.class;
    }

    public Class getDowloadArquivos() {
        return DowloadArquivos.class;
    }

}