package br.com.autoescola.autoescola;

import br.com.autoescola.autoescola.dao.controleacesso.PermissaoDAO;
import br.com.autoescola.autoescola.modelo.controleacesso.Permissao;
import java.util.logging.Level;
import java.util.logging.Logger;
import javax.ejb.EJB;
import javax.ejb.Stateless;

/**
 * Classe para geracao das permissoes iniciais do sistema
 *
 * @author Ayslan
 */
@Stateless
public class GeracaoPermissao {

    private static final Logger logger = Logger.getLogger(GeracaoPermissao.class.getName());
    @EJB
    private PermissaoDAO permissaoDAO;

    public void generate() {

        /**
         * Administracao Sistema
         */
        create(new Permissao("administracaoSistema", "Sistema", true), null);


        /*
         * Controle de Acesso
         */
        create(new Permissao("controleAcesso", "Controle de Acesso", true), "administracaoSistema");

        //Permissao
        create(new Permissao("permissao", "Permissão", true), "controleAcesso");
        create(new Permissao("permissao.create", "Cadastro de Permissão", "/view/controleAcesso/permissao/createPermissao.jsf", true), "permissao");
        create(new Permissao("permissao.list", "Consulta de Permissão", "/view/controleAcesso/permissao/listPermissao.jsf", true), "permissao");
        create(new Permissao("permissao.audit", "Auditoria de Permissão"), "permissao");
        create(new Permissao("permissao.delete", "Exclusão de Permissão"), "permissao");

        //Usuario
        create(new Permissao("usuario", "Usuário", true), "controleAcesso");
        create(new Permissao("usuario.create", "Cadastro de Usuário", "/view/controleAcesso/usuario/createUsuario.jsf", true), "usuario");
        create(new Permissao("usuario.list", "Consulta de Usuário", "/view/controleAcesso/usuario/listUsuario.jsf", true), "usuario");
        create(new Permissao("usuario.audit", "Auditoria de Usuário"), "usuario");
        create(new Permissao("usuario.delete", "Exclusão de Usuário"), "usuario");

        //Perfil
        create(new Permissao("perfil", "Perfil", true), "controleAcesso");
        create(new Permissao("perfil.create", "Cadastro de Perfil", "/view/controleAcesso/perfil/createPerfil.jsf", true), "perfil");
        create(new Permissao("perfil.list", "Consulta de Perfil", "/view/controleAcesso/perfil/listPerfil.jsf", true), "perfil");
        create(new Permissao("perfil.audit", "Auditoria de Perfil"), "perfil");
        create(new Permissao("perfil.delete", "Exclusão de Perfil"), "perfil");

        //Acessos do Sistema
        create(new Permissao("acessoSistema.list", "Relatório de Acessos", "/view/controleAcesso/acessoSistema/listAcessoSistema.jsf", true), "controleAcesso");

        //Solicitacao recuperacao senha
        create(new Permissao("solicitacaoRecuperacaoSenha", "Recuperação de Senha", true), "controleAcesso");
        create(new Permissao("solicitacaoRecuperacaoSenha.list", "Consulta Recuperação de Senha", "/view/controleAcesso/solicitacaoRecuperacaoSenha/listSolicitacaoRecuperacaoSenha.jsf", true), "solicitacaoRecuperacaoSenha");
        create(new Permissao("solicitacaoRecuperacaoSenha.audit", "Auditoria de Recuperação de Senha"), "solicitacaoRecuperacaoSenha");


        /*
         * Email
         */
        create(new Permissao("email", "Email", true), "administracaoSistema");

        //Modelo email
        create(new Permissao("modeloEmail", "Modelo de Email", true), "email");
        create(new Permissao("modeloEmail.create", "Cadastro de Modelo de Email", "/view/email/modeloEmail/createModeloEmail.jsf", true), "modeloEmail");
        create(new Permissao("modeloEmail.list", "Consulta de Modelo de Email", "/view/email/modeloEmail/listModeloEmail.jsf", true), "modeloEmail");
        create(new Permissao("modeloEmail.audit", "Auditoria de Modelo de Email"), "modeloEmail");
        create(new Permissao("modeloEmail.delete", "Exclusão de Modelo de Email"), "modeloEmail");

        //Configuracao email
        create(new Permissao("configuracaoEmail", "Configuração de Email", true), "email");
        create(new Permissao("configuracaoEmail.create", "Cadastro de Configuração de Email", "/view/email/configuracaoEmail/createConfiguracaoEmail.jsf", true), "configuracaoEmail");
        create(new Permissao("configuracaoEmail.list", "Consulta de Configuração de Email", "/view/email/configuracaoEmail/listConfiguracaoEmail.jsf", true), "configuracaoEmail");
        create(new Permissao("configuracaoEmail.audit", "Auditoria de Configuração de Email"), "configuracaoEmail");
        create(new Permissao("configuracaoEmail.delete", "Exclusão de Configuração de Email"), "configuracaoEmail");

        //Cadastros Básicos
        create(new Permissao("cadastrosbasicos", "Cadastros Básicos", true), null);
        //Financeiro
        create(new Permissao("financeiro", "Financeiro", true), null);

        //Aluno
        create(new Permissao("aluno", "Aluno", true), "cadastrosbasicos");
        create(new Permissao("aluno.create", "Cadastro de Aluno", "/view/cadastro/aluno/createAluno.jsf", true), "aluno");
        create(new Permissao("aluno.list", "Consulta de Aluno", "/view/cadastro/aluno/listAluno.jsf", true), "aluno");
        create(new Permissao("aluno.audit", "Auditoria de Aluno"), "aluno");
        create(new Permissao("aluno.delete", "Exclusão de Aluno"), "aluno");

        //Cidade
        create(new Permissao("cidade", "Cidade", true), "cadastrosbasicos");
        create(new Permissao("cidade.create", "Cadastro de Cidade", "/view/cadastro/cidade/createCidade.jsf", true), "cidade");
        create(new Permissao("cidade.list", "Consulta de Cidade", "/view/cadastro/cidade/listCidade.jsf", true), "cidade");
        create(new Permissao("cidade.audit", "Auditoria de Cidade"), "cidade");
        create(new Permissao("cidade.delete", "Exclusão de Cidade"), "cidade");

        //Estado
        create(new Permissao("estado", "Estado", true), "cadastrosbasicos");
        create(new Permissao("estado.create", "Cadastro de Estado", "/view/cadastro/estado/createEstado.jsf", true), "estado");
        create(new Permissao("estado.list", "Consulta de Estado", "/view/cadastro/estado/listEstado.jsf", true), "estado");
        create(new Permissao("estado.audit", "Auditoria de Estado"), "estado");
        create(new Permissao("estado.delete", "Exclusão de Estado"), "estado");

        //Pais
        create(new Permissao("pais", "Pais", true), "cadastrosbasicos");
        create(new Permissao("pais.create", "Cadastro de Pais", "/view/cadastro/pais/createPais.jsf", true), "pais");
        create(new Permissao("pais.list", "Consulta de Pais", "/view/cadastro/pais/listPais.jsf", true), "pais");
        create(new Permissao("pais.audit", "Auditoria de Pais"), "pais");
        create(new Permissao("pais.delete", "Exclusão de Pais"), "pais");

        //Pagamento
        create(new Permissao("pagamento", "Pagamento", true), "financeiro");
        create(new Permissao("pagamento.create", "Cadastro de Pagamento", "/view/financeiro/pagamento/createPagamento.jsf", true), "pagamento");
        create(new Permissao("pagamento.list", "Consulta de Pagamento", "/view/financeiro/pagamento/listPagamento.jsf", true), "pagamento");
        create(new Permissao("pagamento.audit", "Auditoria de Pagamento"), "pagamento");
        create(new Permissao("pagamento.delete", "Exclusão de Pagamento"), "pagamento");
        create(new Permissao("pagamento.listPagamento", "Pagamentos Realizados", "/view/financeiro/pagamento/listPagamentoFeitos.jsf", true), "pagamento");

        //Questao
//        create(new Permissao("questao", "Simulado", true), null);
//        create(new Permissao("questao.create", "Cadastro de Questao", "/view/simulado/questao/createQuestao.jsf", true), "questao");
//        create(new Permissao("questao.list", "Consulta de Questao", "/view/simulado/questao/listQuestao.jsf", true), "questao");
//        create(new Permissao("questao.audit", "Auditoria de Questao"), "questao");
//        create(new Permissao("questao.delete", "Exclusão de Questao"), "questao");

        /*
         * Configuracao
         */
        create(new Permissao("configuracaoSistema", "Configuração", true), "administracaoSistema");

        //Erro sistema
        create(new Permissao("erroSistema.list", "Relatório de Erros", "/view/configuracao/erroSistema/listErroSistema.jsf", true), "configuracaoSistema");

        /**
         * Permissoes Globais
         */
        //Alterar Senha
        createGlobal(new Permissao("usuario.alterarSenha", "Alterar Senha", "/view/controleAcesso/password/alterPassword.jsf", true), "controleAcesso");
        createGlobal(new Permissao("usuario.ultimosAcessos", "Últimos Acessos", "/view/controleAcesso/acessoSistema/ultimosAcessoSistema.jsf", true), "controleAcesso");

    }

    private void createGlobal(Permissao permissao, String pai) {
        permissao.setGlobal(true);
        create(permissao, pai);
    }

    private void create(Permissao permissao, String pai) {

        if (pai != null && pai.equals(permissao.getKey())) {
            logger.log(Level.WARNING, "Permissao ''{0}'' pai dela mesmo. Esta permissao nao sera salva.", permissao.getKey());
            return;
        }

        Permissao permissaoDB = permissaoDAO.unique("key", permissao.getKey());

        if (pai != null && !pai.isEmpty()) {
            Permissao permissaoPai = permissaoDAO.unique("key", pai);
            permissao.setPermissaoPai(permissaoPai);
        }

        if (permissaoDB != null) {
            permissaoDB.setUrl(permissao.getUrl());
            permissaoDB.setDescricao(permissao.getDescricao());
            permissaoDB.setPermissaoPai(permissao.getPermissaoPai());
            permissaoDB.setPossuiMenu(permissao.isPossuiMenu());
            permissaoDB.setGlobal(permissao.isGlobal());
            permissao = permissaoDB;
        }

        permissaoDAO.merge(permissao, false);
    }
}
