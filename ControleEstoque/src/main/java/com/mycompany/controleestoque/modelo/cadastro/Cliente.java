/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.mycompany.controleestoque.modelo.cadastro;

import com.mycompany.controleestoque.modelo.cadastro.enums.EstadoCivil;
import com.mycompany.controleestoque.modelo.cadastro.enums.Sexo;
import com.mycompany.controleestoque.modelo.cadastro.enums.TipoCliente;
import com.mycompany.controleestoque.modelo.cadastro.enums.TipoDePessoa;
import com.mycompany.controleestoque.modelo.cadastro.enums.TipoEndereco;
import com.mycompany.controleestoque.modelo.cadastro.enums.TipoInsencaoCliente;
import com.mycompany.controleestoque.modelo.faturamento.Venda;
import com.xpert.audit.NotAudited;
import java.io.Serializable;
import java.math.BigDecimal;
import java.text.ParseException;
import java.util.Date;
import java.util.List;
import javax.persistence.Entity;
import javax.persistence.Enumerated;
import javax.persistence.FetchType;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.ManyToOne;
import javax.persistence.OneToMany;
import javax.persistence.OrderBy;
import javax.persistence.Temporal;
import javax.persistence.TemporalType;
import javax.swing.text.MaskFormatter;
import javax.validation.constraints.NotNull;
import javax.validation.constraints.Size;
import org.hibernate.validator.constraints.Email;
import org.hibernate.validator.constraints.NotBlank;

/**
 *
 * @author Juniel alves
 */
@Entity
public class Cliente implements Serializable {

    // Tab cadastros Basicos
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    private TipoDePessoa tipoDePessoa;

    private TipoCliente tipo;

    @Size(max = 200)
    private String nome;

    @Size(max = 200)
    private String razaoSocial;

    @Size(max = 200)
    private String nomeFantasia;
    
    @NotNull
    private TipoInsencaoCliente tipoIsencao;

    @Size(max = 14)
    private String cpf;

    @Size(max = 20)
    private String cnpj;

    @Size(max = 20)
    private String inscricaoEstatual;

    // Tab Enderecos
    @NotBlank
    @Size(max = 200)
    private String endereco;

    @Size(max = 50)
    private String numero;

    @Size(max = 50)
    private String bairro;

    @NotNull
    @ManyToOne(fetch = FetchType.LAZY)
    private Cidade cidadeEndereco;

    @Size(max = 14)
    private String cep;

    @Size(max = 100)
    private String complemento;

    @Enumerated
    private TipoEndereco tipoEndereco;

    // tab Telefones/Enderecos digitais
    @Size(max = 20)
    private String telefone;

    @Size(max = 20)
    private String fax;

    @Size(max = 20)
    private String celula1;

    @Size(max = 20)
    private String celular2;

    @Size(max = 20)
    private String whatsapp;

    @Size(max = 100)
    @Email
    private String email;

    @Size(max = 100)
    private String facebook;

    private BigDecimal renda;

    @ManyToOne(fetch = FetchType.LAZY)
    private Convenio fatura;

    @ManyToOne(fetch = FetchType.LAZY)
    private Convenio recebimento;

    @Size(max = 400)
    private String observacao;

    @Temporal(TemporalType.DATE)
    private Date dataNascimento;

    @Enumerated
    private EstadoCivil estadoCivil;

    private Sexo sexo;

    @Size(max = 200)
    private String nomeDaMae;

    @Size(max = 200)
    private String nomeDoPai;

    // Local de Trabalho Tab
    @Size(max = 200)
    private String nomeEmpresaTrabalho;

    @Size(max = 200)
    private String endEmpresaTrabalho;

    @Size(max = 50)
    private String numEndEmpTrabalho;

    private String bairroEmpresaTrabalho;

    @ManyToOne(fetch = FetchType.LAZY)
    private Cidade cidEndEmpresaTrabalho;

    @Size(max = 14)
    private String cepEndEmpresaTrabalho;

    @Size(max = 20)

    private String telefoneEmprTrabalho;

    @Temporal(TemporalType.DATE)
    private Date dataAdmissao;

    @Size(max = 200)
    private String funcao;

    private BigDecimal rendaTrabalho;

    @NotAudited
    @OneToMany(mappedBy = "cliente")
    private List<Venda> vendas;

    private boolean ativo = true;

    public Cliente() {
    }

    public List<Venda> getVendas() {
        return vendas;
    }

    public void setVendas(List<Venda> vendas) {
        this.vendas = vendas;
    }

    public Long getId() {
        return id;
    }

    public void setId(Long id) {
        this.id = id;
    }

    public TipoDePessoa getTipoDePessoa() {
        return tipoDePessoa;
    }

    public void setTipoDePessoa(TipoDePessoa tipoDePessoa) {
        this.tipoDePessoa = tipoDePessoa;
    }

    public TipoCliente getTipo() {
        return tipo;
    }

    public void setTipo(TipoCliente tipo) {
        this.tipo = tipo;
    }

    public String getNome() {
        return nome;
    }

    public void setNome(String nome) {
        this.nome = nome;
    }

    public String getRazaoSocial() {
        return razaoSocial;
    }

    public void setRazaoSocial(String razaoSocial) {
        this.razaoSocial = razaoSocial;
    }

    public String getNomeFantasia() {
        return nomeFantasia;
    }

    public void setNomeFantasia(String nomeFantasia) {
        this.nomeFantasia = nomeFantasia;
    }

    public String getCpf() {
        return cpf;
    }

    public void setCpf(String cpf) {
        this.cpf = cpf;
    }

    public String getCnpj() {
        return cnpj;
    }

    public void setCnpj(String cnpj) {
        this.cnpj = cnpj;
    }

    public String getInscricaoEstatual() {
        return inscricaoEstatual;
    }

    public void setInscricaoEstatual(String inscricaoEstatual) {
        this.inscricaoEstatual = inscricaoEstatual;
    }

    public String getEndereco() {
        return endereco;
    }

    public void setEndereco(String endereco) {
        this.endereco = endereco;
    }

    public String getNumero() {
        return numero;
    }

    public void setNumero(String numero) {
        this.numero = numero;
    }

    public String getBairro() {
        return bairro;
    }

    public void setBairro(String bairro) {
        this.bairro = bairro;
    }

    public Cidade getCidadeEndereco() {
        return cidadeEndereco;
    }

    public void setCidadeEndereco(Cidade cidadeEndereco) {
        this.cidadeEndereco = cidadeEndereco;
    }

    public String getCep() {
        return cep;
    }

    public void setCep(String cep) {
        this.cep = cep;
    }

    public String getComplemento() {
        return complemento;
    }

    public void setComplemento(String complemento) {
        this.complemento = complemento;
    }

    public TipoEndereco getTipoEndereco() {
        return tipoEndereco;
    }

    public void setTipoEndereco(TipoEndereco tipoEndereco) {
        this.tipoEndereco = tipoEndereco;
    }

    public String getTelefone() {
        return telefone;
    }

    public void setTelefone(String telefone) {
        this.telefone = telefone;
    }

    public String getFax() {
        return fax;
    }

    public void setFax(String fax) {
        this.fax = fax;
    }

    public String getCelula1() {
        return celula1;
    }

    public void setCelula1(String celula1) {
        this.celula1 = celula1;
    }

    public String getCelular2() {
        return celular2;
    }

    public void setCelular2(String celular2) {
        this.celular2 = celular2;
    }

    public String getWhatsapp() {
        return whatsapp;
    }

    public void setWhatsapp(String whatsapp) {
        this.whatsapp = whatsapp;
    }

    public String getEmail() {
        return email;
    }

    public void setEmail(String email) {
        this.email = email;
    }

    public String getFacebook() {
        return facebook;
    }

    public void setFacebook(String facebook) {
        this.facebook = facebook;
    }

    public BigDecimal getRenda() {
        return renda;
    }

    public void setRenda(BigDecimal renda) {
        this.renda = renda;
    }

    public Convenio getFatura() {
        return fatura;
    }

    public void setFatura(Convenio fatura) {
        this.fatura = fatura;
    }

    public Convenio getRecebimento() {
        return recebimento;
    }

    public void setRecebimento(Convenio recebimento) {
        this.recebimento = recebimento;
    }

    public String getObservacao() {
        return observacao;
    }

    public void setObservacao(String observacao) {
        this.observacao = observacao;
    }

    public Date getDataNascimento() {
        return dataNascimento;
    }

    public void setDataNascimento(Date dataNascimento) {
        this.dataNascimento = dataNascimento;
    }

    public EstadoCivil getEstadoCivil() {
        return estadoCivil;
    }

    public void setEstadoCivil(EstadoCivil estadoCivil) {
        this.estadoCivil = estadoCivil;
    }

    public Sexo getSexo() {
        return sexo;
    }

    public void setSexo(Sexo sexo) {
        this.sexo = sexo;
    }

    public String getNomeDaMae() {
        return nomeDaMae;
    }

    public void setNomeDaMae(String nomeDaMae) {
        this.nomeDaMae = nomeDaMae;
    }

    public String getNomeDoPai() {
        return nomeDoPai;
    }

    public void setNomeDoPai(String nomeDoPai) {
        this.nomeDoPai = nomeDoPai;
    }

    public String getNomeEmpresaTrabalho() {
        return nomeEmpresaTrabalho;
    }

    public void setNomeEmpresaTrabalho(String nomeEmpresaTrabalho) {
        this.nomeEmpresaTrabalho = nomeEmpresaTrabalho;
    }

    public String getEndEmpresaTrabalho() {
        return endEmpresaTrabalho;
    }

    public void setEndEmpresaTrabalho(String endEmpresaTrabalho) {
        this.endEmpresaTrabalho = endEmpresaTrabalho;
    }

    public String getNumEndEmpTrabalho() {
        return numEndEmpTrabalho;
    }

    public void setNumEndEmpTrabalho(String numEndEmpTrabalho) {
        this.numEndEmpTrabalho = numEndEmpTrabalho;
    }

    public String getBairroEmpresaTrabalho() {
        return bairroEmpresaTrabalho;
    }

    public void setBairroEmpresaTrabalho(String bairroEmpresaTrabalho) {
        this.bairroEmpresaTrabalho = bairroEmpresaTrabalho;
    }

    public Cidade getCidEndEmpresaTrabalho() {
        return cidEndEmpresaTrabalho;
    }

    public void setCidEndEmpresaTrabalho(Cidade cidEndEmpresaTrabalho) {
        this.cidEndEmpresaTrabalho = cidEndEmpresaTrabalho;
    }

    public String getCepEndEmpresaTrabalho() {
        return cepEndEmpresaTrabalho;
    }

    public void setCepEndEmpresaTrabalho(String cepEndEmpresaTrabalho) {
        this.cepEndEmpresaTrabalho = cepEndEmpresaTrabalho;
    }

    public String getTelefoneEmprTrabalho() {
        return telefoneEmprTrabalho;
    }

    public void setTelefoneEmprTrabalho(String telefoneEmprTrabalho) {
        this.telefoneEmprTrabalho = telefoneEmprTrabalho;
    }

    public Date getDataAdmissao() {
        return dataAdmissao;
    }

    public void setDataAdmissao(Date dataAdmissao) {
        this.dataAdmissao = dataAdmissao;
    }

    public String getFuncao() {
        return funcao;
    }

    public void setFuncao(String funcao) {
        this.funcao = funcao;
    }

    public BigDecimal getRendaTrabalho() {
        return rendaTrabalho;
    }

    public void setRendaTrabalho(BigDecimal rendaTrabalho) {
        this.rendaTrabalho = rendaTrabalho;
    }

    public boolean isAtivo() {
        return ativo;
    }

    public void setAtivo(boolean ativo) {
        this.ativo = ativo;
    }

    public TipoInsencaoCliente getTipoIsencao() {
        return tipoIsencao;
    }

    public void setTipoIsencao(TipoInsencaoCliente tipoIsencao) {
        this.tipoIsencao = tipoIsencao;
    }
    

    @Override
    public int hashCode() {
        int hash = 7;
        hash = 59 * hash + (this.id != null ? this.id.hashCode() : 0);
        return hash;
    }

    @Override
    public String toString() {
        return cnpj!=null && !cnpj.equals("") ? format("##.###.###/####-##", cnpj) + " - " + razaoSocial : format("###.###.###-##",cpf) + " - " + nome; //To change body of generated methods, choose Tools | Templates.
    }
    
    @Override
    public boolean equals(Object obj) {
        if (obj == null) {
            return false;
        }
        if (getClass() != obj.getClass()) {
            return false;
        }
        final Cliente other = (Cliente) obj;
        if (this.id != other.id && (this.id == null || !this.id.equals(other.id))) {
            return false;
        }
        return true;
    }

    private static String format(String pattern, Object value) {
        MaskFormatter mask;
        try {
            mask = new MaskFormatter(pattern);
            mask.setValueContainsLiteralCharacters(false);
            return mask.valueToString(value);
        } catch (ParseException e) {
            throw new RuntimeException(e);
        }
    }
}
