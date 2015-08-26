package com.mycompany.controleestoque;

import com.mycompany.controleestoque.dao.controleacesso.PermissaoDAO;
import com.mycompany.controleestoque.modelo.controleacesso.Permissao;
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

        //Pessoa Exemplo
//        create(new Permissao("pessoaExemplo", "Pessoa Exemplo", true), null);
//        create(new Permissao("pessoaExemplo.create", "Cadastro de Pessoa Exemplo", "/view/exemplo/pessoaExemplo/createPessoaExemplo.jsf", true), "pessoaExemplo");
//        create(new Permissao("pessoaExemplo.list", "Consulta de Pessoa Exemplo", "/view/exemplo/pessoaExemplo/listPessoaExemplo.jsf", true), "pessoaExemplo");
//        create(new Permissao("pessoaExemplo.audit", "Auditoria de Pessoa Exemplo"), "pessoaExemplo");
//        create(new Permissao("pessoaExemplo.delete", "Exclusão de Pessoa Exemplo"), "pessoaExemplo");
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

        //Cadastros Básicos
        create(new Permissao("cadastrosbasicos", "Cadastros Básicos", true), null);
        create(new Permissao("cadastrosnecessarios", "Cadastros Necessários", true), "cadastrosbasicos");

        create(new Permissao("cep", "CEP", true), "cadastrosnecessarios");

        create(new Permissao("cidade", "Cidade", true), "cep");
        create(new Permissao("cidade.create", "Cadastro de Cidade", "/view/cadastro/cidade/createCidade.jsf", true), "cidade");
        create(new Permissao("cidade.list", "Consulta de Cidade", "/view/cadastro/cidade/listCidade.jsf", true), "cidade");
        create(new Permissao("cidade.audit", "Auditoria de Cidade"), "cidade");
        create(new Permissao("cidade.delete", "Exclusão de Cidade"), "cidade");

        create(new Permissao("estado", "Estado", true), "cep");
        create(new Permissao("estado.create", "Cadastro de Estado", "/view/cadastro/estado/createEstado.jsf", true), "estado");
        create(new Permissao("estado.list", "Consulta de Estado", "/view/cadastro/estado/listEstado.jsf", true), "estado");
        create(new Permissao("estado.audit", "Auditoria de Estado"), "estado");
        create(new Permissao("estado.delete", "Exclusão de Estado"), "estado");

        create(new Permissao("pais", "Pais", true), "cep");
        create(new Permissao("pais.create", "Cadastro de Pais", "/view/cadastro/pais/createPais.jsf", true), "pais");
        create(new Permissao("pais.list", "Consulta de Pais", "/view/cadastro/pais/listPais.jsf", true), "pais");
        create(new Permissao("pais.audit", "Auditoria de Pais"), "pais");
        create(new Permissao("pais.delete", "Exclusão de Pais"), "pais");

        create(new Permissao("cliente", "Cliente", true), "cadastrosbasicos");
        create(new Permissao("cliente.create", "Cadastro de Cliente", "/view/cadastro/cliente/createCliente.jsf", true), "cliente");
        create(new Permissao("cliente.list", "Consulta de Cliente", "/view/cadastro/cliente/listCliente.jsf", true), "cliente");
        create(new Permissao("cliente.audit", "Auditoria de Cliente"), "cliente");
        create(new Permissao("cliente.delete", "Exclusão de Cliente"), "cliente");

        create(new Permissao("convenio", "Convênio", true), "cadastrosnecessarios");
        create(new Permissao("convenio.create", "Cadastro de Convênio", "/view/cadastro/convenio/createConvenio.jsf", true), "convenio");
        create(new Permissao("convenio.list", "Consulta de Convênio", "/view/cadastro/convenio/listConvenio.jsf", true), "convenio");
        create(new Permissao("convenio.audit", "Auditoria de Convênio"), "convenio");
        create(new Permissao("convenio.delete", "Exclusão de Convênio"), "convenio");

//Fornecedor
        create(new Permissao("fornecedor", "Fornecedor", true), "cadastrosbasicos");
        create(new Permissao("fornecedor.create", "Cadastro de Fornecedor", "/view/cadastro/fornecedor/createFornecedor.jsf", true), "fornecedor");
        create(new Permissao("fornecedor.list", "Consulta de Fornecedor", "/view/cadastro/fornecedor/listFornecedor.jsf", true), "fornecedor");
        create(new Permissao("fornecedor.audit", "Auditoria de Fornecedor"), "fornecedor");
        create(new Permissao("fornecedor.delete", "Exclusão de Fornecedor"), "fornecedor");

//Grupos De Secoes
        create(new Permissao("gruposDeSecoes", "Grupos De Secoes", true), "cadastrosnecessarios");
        create(new Permissao("gruposDeSecoes.create", "Cadastro de Grupos De Secoes", "/view/cadastro/gruposDeSecoes/createGruposDeSecoes.jsf", true), "gruposDeSecoes");
        create(new Permissao("gruposDeSecoes.list", "Consulta de Grupos De Secoes", "/view/cadastro/gruposDeSecoes/listGruposDeSecoes.jsf", true), "gruposDeSecoes");
        create(new Permissao("gruposDeSecoes.audit", "Auditoria de Grupos De Secoes"), "gruposDeSecoes");
        create(new Permissao("gruposDeSecoes.delete", "Exclusão de Grupos De Secoes"), "gruposDeSecoes");

//Produto
        create(new Permissao("produto", "Produto", true), "cadastrosbasicos");
        create(new Permissao("produto.create", "Cadastro de Produto", "/view/cadastro/produto/createProduto.jsf", true), "produto");
        create(new Permissao("produto.list", "Consulta de Produto", "/view/cadastro/produto/listProduto.jsf", true), "produto");
        create(new Permissao("produto.audit", "Auditoria de Produto"), "produto");
        create(new Permissao("produto.delete", "Exclusão de Produto"), "produto");

//Situacao Tributaria
//        create(new Permissao("situacaoTributaria", "Situacao Tributaria", true), "cadastrosnecessarios");
//        create(new Permissao("situacaoTributaria.create", "Cadastro de Situacao Tributaria", "/view/cadastro/situacaoTributaria/createSituacaoTributaria.jsf", true), "situacaoTributaria");
//        create(new Permissao("situacaoTributaria.list", "Consulta de Situacao Tributaria", "/view/cadastro/situacaoTributaria/listSituacaoTributaria.jsf", true), "situacaoTributaria");
//        create(new Permissao("situacaoTributaria.audit", "Auditoria de Situacao Tributaria"), "situacaoTributaria");
//        create(new Permissao("situacaoTributaria.delete", "Exclusão de Situacao Tributaria"), "situacaoTributaria");

//Grupo Loja
        create(new Permissao("grupoLoja", "Grupo Loja", true), "cadastrosnecessarios");
        create(new Permissao("grupoLoja.create", "Cadastro de Grupo Loja", "/view/cadastro/grupoLoja/createGrupoLoja.jsf", true), "grupoLoja");
        create(new Permissao("grupoLoja.list", "Consulta de Grupo Loja", "/view/cadastro/grupoLoja/listGrupoLoja.jsf", true), "grupoLoja");
        create(new Permissao("grupoLoja.audit", "Auditoria de Grupo Loja"), "grupoLoja");
        create(new Permissao("grupoLoja.delete", "Exclusão de Grupo Loja"), "grupoLoja");

//Secoes Produto
        create(new Permissao("secoesProduto", "Secoes Produto", true), "cadastrosnecessarios");
        create(new Permissao("secoesProduto.create", "Cadastro de Secoes Produto", "/view/cadastro/secoesProduto/createSecoesProduto.jsf", true), "secoesProduto");
        create(new Permissao("secoesProduto.list", "Consulta de Secoes Produto", "/view/cadastro/secoesProduto/listSecoesProduto.jsf", true), "secoesProduto");
        create(new Permissao("secoesProduto.audit", "Auditoria de Secoes Produto"), "secoesProduto");
        create(new Permissao("secoesProduto.delete", "Exclusão de Secoes Produto"), "secoesProduto");

//Loja Filial
        create(new Permissao("loja_Filial", "Empresa", true), "cadastrosbasicos");
        create(new Permissao("loja_Filial.create", "Cadastro de Empresa", "/view/cadastro/loja_Filial/createLoja_Filial.jsf", true), "loja_Filial");
        create(new Permissao("loja_Filial.list", "Consulta de Empresa", "/view/cadastro/loja_Filial/listLoja_Filial.jsf", true), "loja_Filial");
        create(new Permissao("loja_Filial.audit", "Auditoria de Empresa"), "loja_Filial");
        create(new Permissao("loja_Filial.delete", "Exclusão de Empresa"), "loja_Filial");

        //Banco
        create(new Permissao("banco", "Banco", true), "cadastrosnecessarios");
        create(new Permissao("banco.create", "Cadastro de Banco", "/view/cadastro/banco/createBanco.jsf", true), "banco");
        create(new Permissao("banco.list", "Consulta de Banco", "/view/cadastro/banco/listBanco.jsf", true), "banco");
        create(new Permissao("banco.audit", "Auditoria de Banco"), "banco");
        create(new Permissao("banco.delete", "Exclusão de Banco"), "banco");

        //Conta Bancaria
        create(new Permissao("contaBancaria", "Conta Bancaria", true), "cadastrosnecessarios");
        create(new Permissao("contaBancaria.create", "Cadastro de Conta Bancaria", "/view/cadastro/contaBancaria/createContaBancaria.jsf", true), "contaBancaria");
        create(new Permissao("contaBancaria.list", "Consulta de Conta Bancaria", "/view/cadastro/contaBancaria/listContaBancaria.jsf", true), "contaBancaria");
        create(new Permissao("contaBancaria.audit", "Auditoria de Conta Bancaria"), "contaBancaria");
        create(new Permissao("contaBancaria.delete", "Exclusão de Conta Bancaria"), "contaBancaria");

        //Naturezas De Operacoes
        create(new Permissao("naturezasDeOperacoes", "Naturezas de Operações", true), "cadastrosnecessarios");
        create(new Permissao("naturezasDeOperacoes.create", "Cadastro de de Operações", "/view/cadastro/naturezasDeOperacoes/createNaturezasDeOperacoes.jsf", true), "naturezasDeOperacoes");
        create(new Permissao("naturezasDeOperacoes.list", "Consulta de de Operações", "/view/cadastro/naturezasDeOperacoes/listNaturezasDeOperacoes.jsf", true), "naturezasDeOperacoes");
        create(new Permissao("naturezasDeOperacoes.audit", "Auditoria de de Operações"), "naturezasDeOperacoes");
        create(new Permissao("naturezasDeOperacoes.delete", "Exclusão de de Operações"), "naturezasDeOperacoes");

        //Faturamento
        create(new Permissao("faturamento", "Faturamento", true), null);
        create(new Permissao("pedido", "Pedidos/Entrada", true), "faturamento");
        create(new Permissao("pedido.create", "Cadastro de Pedido/Entrada", "/view/faturamento/pedido/createPedido.jsf", true), "pedido");
        create(new Permissao("pedido.list", "Consulta de Pedido/Entrada", "/view/faturamento/pedido/listPedido.jsf", true), "pedido");
        create(new Permissao("pedido.audit", "Auditoria de Pedido/Entrada"), "pedido");
        create(new Permissao("pedido.delete", "Exclusão de Pedido/Entrada"), "pedido");

        //Estoque
        create(new Permissao("estoque", "Estoque", true), "faturamento");
        create(new Permissao("estoque.create", "Cadastro de Estoque", "/view/faturamento/estoque/createEstoque.jsf", true), "estoque");
        create(new Permissao("estoque.list", "Consulta de Estoque", "/view/faturamento/estoque/listEstoque.jsf", true), "estoque");
        create(new Permissao("estoque.audit", "Auditoria de Estoque"), "estoque");
        create(new Permissao("estoque.delete", "Exclusão de Estoque"), "estoque");

        //Venda
        create(new Permissao("venda", "Venda", true), "faturamento");
        create(new Permissao("venda.create", "Cadastro de Venda", "/view/faturamento/venda/createVenda.jsf", true), "venda");
        create(new Permissao("venda.list", "Consulta de Venda", "/view/faturamento/venda/listVenda.jsf", true), "venda");
        create(new Permissao("venda.audit", "Auditoria de Venda"), "venda");
        create(new Permissao("venda.delete", "Exclusão de Venda"), "venda");

        //Nota Fiscal
        create(new Permissao("notaFiscal", "Nota Fiscal", true), "faturamento");
        create(new Permissao("notaFiscal.create", "Cadastro de Nota Fiscal", "/view/faturamento/notaFiscal/createNotaFiscal.jsf", true), "notaFiscal");
        create(new Permissao("notaFiscal.list", "Consulta de Nota Fiscal", "/view/faturamento/notaFiscal/listNotaFiscal.jsf", true), "notaFiscal");
        create(new Permissao("notaFiscal.audit", "Auditoria de Nota Fiscal"), "notaFiscal");
        create(new Permissao("notaFiscal.delete", "Exclusão de Nota Fiscal"), "notaFiscal");

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
