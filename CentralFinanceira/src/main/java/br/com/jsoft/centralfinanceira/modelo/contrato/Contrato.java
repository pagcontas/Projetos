/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package br.com.jsoft.centralfinanceira.modelo.contrato;

import br.com.jsoft.centralfinanceira.bo.contrato.Conjuge;
import br.com.jsoft.centralfinanceira.modelo.central.Loja;
import br.com.jsoft.centralfinanceira.modelo.enums.Bancos;
import br.com.jsoft.centralfinanceira.modelo.enums.Escolaridade;
import br.com.jsoft.centralfinanceira.modelo.enums.EstadoCivil;
import br.com.jsoft.centralfinanceira.modelo.enums.TipoContaBanco;
import java.io.Serializable;
import java.math.BigDecimal;
import java.util.ArrayList;
import java.util.Date;
import java.util.List;
import javax.persistence.CascadeType;
import javax.persistence.Entity;
import javax.persistence.FetchType;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.ManyToOne;
import javax.persistence.OneToMany;
import javax.persistence.OneToOne;
import javax.persistence.Table;
import javax.persistence.Temporal;
import javax.persistence.TemporalType;
import javax.validation.constraints.NotNull;
import javax.validation.constraints.Size;
import org.hibernate.validator.constraints.Email;
import org.hibernate.validator.constraints.NotBlank;

/**
 *
 * @author ti05
 */
@Entity
@Table(schema = "contrato")
public class Contrato implements Serializable {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    @ManyToOne(fetch = FetchType.LAZY)
    @NotNull
    private Loja loja;

    @Size(max = 50)
    @NotBlank
    private String ramoAtividades;

    @Temporal(TemporalType.DATE)
    private Date inicioAtividades;

    private boolean depositoSeg;

    private boolean depositoTer;

    private boolean depositoQuar;

    private boolean depositoQuin;

    private boolean depositoSex;

    @Size(max = 16)
    private String telefone;

    @Size(max = 16)
    private String celular;

    @Size(max = 16)
    private String fax;

    @Size(max = 16)
    private String whatsApp;

    @Size(max = 16)
    private String orelhaoProximo;

    @Size(max = 150)
    @Email
    private String email;

    @Size(max = 60)
    private String skype;

    @Size(max = 60)
    private String facebook;

    @Size(max = 60)
    private String site;

    @Temporal(TemporalType.TIME)
    private Date funcSegASextAbert;

    @Temporal(TemporalType.TIME)
    private Date funcSegASextFechar;

    @Temporal(TemporalType.TIME)
    private Date funcSabadoAbert;

    @Temporal(TemporalType.TIME)
    private Date funcSabadoFechar;

    private boolean opArrecContas;

    private boolean opVendCD;

    private boolean opServicos;

    private boolean opBB;

    @Temporal(TemporalType.TIME)
    private Date horaFechCaixa;

    private boolean diaAutOpSeg;

    private boolean diaAutOpTerc;

    private boolean diaAutOpQuar;

    private boolean diaAutOpQui;

    private boolean diaAutOpSex;

    private boolean diaAutOpSab;

    private boolean diaAutOpDom;

    private boolean diaAutOpFeriados;

    @Size(max = 60)
    @NotBlank
    private String nomePro;

    @Size(max = 60)
    private String nomeGuerraPro;

    @Size(max = 50)
    @NotBlank
    private String cpfPro;

    @Size(max = 50)
    @NotBlank
    private String rgPro;

    @Temporal(TemporalType.DATE)
    private Date dataNascimentoPro;
    
    @Size(max = 16)
    private String telefonePro;

    @Size(max = 16)
    private String celularPro;

    @Size(max = 16)
    private String faxPro;

    @Size(max = 150)
    @Email
    private String emailPro;

    @Size(max = 60)
    private String profissaoPro;

    private BigDecimal rendaPro;

    private EstadoCivil estadoCivilPro;

    private Escolaridade escolaridadePro;

    @Size(max = 80)
    private String nomePaiPro;

    @Size(max = 80)
    private String nomeMaePro;

    @Size(max = 16)
    private String telefoneMaePro;

    @Size(max = 16)
    private String telefonePaiPro;

    @Temporal(TemporalType.DATE)
    private Date nascPaiPro;

    @Temporal(TemporalType.DATE)
    private Date nascMaePro;

    @Size(max = 60)
    private String emailPaiPro;

    @Size(max = 150)
    @Email
    private String emailMaePro;

    private Boolean participaNegocioMaePro = null;

    private Boolean participaNegocioPaiPro = null;

    @Size(max = 60)
    private String religiaoPro;

    @Size(max = 60)
    private String lazerPro;

    @Size(max = 60)
    private String prefMusicalPro;

    @Size(max = 60)
    private String prefLeituraPro;

    @Size(max = 60)
    private String esportePro;

    @Size(max = 60)
    private String timePro;
    
    @OneToOne(cascade = CascadeType.ALL)
    private Conjuge conjugeProprietario = new Conjuge();

    @Size(max = 50)
    private String nomeSocio;

    @Size(max = 50)
    private String nomeGuerraSocio;

    @Size(max = 16)
    private String cpfSocio;

    @Size(max = 20)
    private String rgSocio;

    @Temporal(TemporalType.DATE)
    private Date dataNascimentoSocio;

    @Size(max = 15)
    private String telefoneSocio;

    @Size(max = 15)
    private String celularSocio;

    @Size(max = 15)
    private String faxSocio;

    @Size(max = 150)
    @Email
    private String emailSocio;

    @Size(max = 50)
    private String profissaoSocio;

    private BigDecimal rendaSocio;

    private EstadoCivil estadoCivilSocio;

    private Escolaridade escolaridadeSocio;

    @Size(max = 50)
    private String nomePaiSocio;

    @Size(max = 50)
    private String nomeMaeSocio;

    @Size(max = 15)
    private String telefoneMaeSocio;

    @Size(max = 15)
    private String telefonePaiSocio;

    @Temporal(TemporalType.DATE)
    private Date nascPaiSocio;

    @Temporal(TemporalType.DATE)
    private Date nascMaeSocio;

    @Size(max = 150)
    @Email
    private String emailPaiSocio;

    @Size(max = 150)
    @Email
    private String emailMaeSocio;

    private Boolean participaNegocioMaeSocio = null;

    private Boolean participaNegocioPaiSocio = null;

    @Size(max = 20)
    private String religiaoSocio;

    @Size(max = 20)
    private String lazerSocio;

    @Size(max = 20)
    private String prefMusicalSocio;

    @Size(max = 20)
    private String prefLeituraSocio;

    @Size(max = 20)
    private String esporteSocio;

    @Size(max = 20)
    private String timeSocio;

    @OneToOne(cascade = CascadeType.ALL)
    private Conjuge conjugeSocio = new Conjuge();

    @Size(max = 50)
    private String nomeTitularConta;

    private Bancos banco;

    @Size(max = 20)
    private String agencia;

    private TipoContaBanco tipoConta;

    @Size(max = 20)
    private String numeroConta;

    @Size(max = 50)
    private String nomePropag;

    @Size(max = 50)
    private String enderecoPropag;

    @Size(max = 50)
    private String pontoRefereciaPropag;

    @Size(max = 50)
    private String slogan;

    @Temporal(TemporalType.DATE)
    private Date dataInstalacao;

    @Temporal(TemporalType.DATE)
    private Date dataAssinatura;

    @Temporal(TemporalType.DATE)
    private Date dataConsulta;

    @Size(max = 80)
    private String vendedor;

    @NotNull
    private Integer metaDeGuias;

    @NotNull
    private BigDecimal metaCreditosDigitais;

    @NotNull
    private BigDecimal valorDaPromissoria;

    @OneToMany(mappedBy = "contrato", cascade = CascadeType.ALL)
    private List<Equipe> equipes = new ArrayList<Equipe>();
    
    @OneToMany(mappedBy = "contrato1", cascade = CascadeType.ALL)
    private List<Filho> filhosProprietario = new ArrayList<Filho>();
    
    @OneToMany(mappedBy = "contrato2", cascade = CascadeType.ALL)
    private List<Filho> filhosSocio = new ArrayList<Filho>();
    
    @OneToOne(cascade = CascadeType.ALL)
    private Endereco enderecoProprietario = new Endereco();
    
    @OneToOne(cascade = CascadeType.ALL)
    private Endereco enderecoSocio = new Endereco();

    private boolean ativo = true;

    @Override
    public String toString() {
        return cpfPro + " - " + nomePro; //To change body of generated methods, choose Tools | Templates.
    }

    
    public Long getId() {
        return id;
    }

    public void setId(Long id) {
        this.id = id;
    }

    public List<Equipe> getEquipes() {
        return equipes;
    }

    public void setEquipes(List<Equipe> equipes) {
        this.equipes = equipes;
    }

    public Loja getLoja() {
        return loja;
    }

    public void setLoja(Loja loja) {
        this.loja = loja;
    }

    public String getRamoAtividades() {
        return ramoAtividades;
    }

    public void setRamoAtividades(String ramoAtividades) {
        this.ramoAtividades = ramoAtividades;
    }

    public Date getInicioAtividades() {
        return inicioAtividades;
    }

    public void setInicioAtividades(Date inicioAtividades) {
        this.inicioAtividades = inicioAtividades;
    }

    public boolean isDepositoSeg() {
        return depositoSeg;
    }

    public void setDepositoSeg(boolean depositoSeg) {
        this.depositoSeg = depositoSeg;
    }

    public boolean isDepositoTer() {
        return depositoTer;
    }

    public void setDepositoTer(boolean depositoTer) {
        this.depositoTer = depositoTer;
    }

    public boolean isDepositoQuar() {
        return depositoQuar;
    }

    public void setDepositoQuar(boolean depositoQuar) {
        this.depositoQuar = depositoQuar;
    }

    public boolean isDepositoQuin() {
        return depositoQuin;
    }

    public void setDepositoQuin(boolean depositoQuin) {
        this.depositoQuin = depositoQuin;
    }

    public boolean isDepositoSex() {
        return depositoSex;
    }

    public void setDepositoSex(boolean depositoSex) {
        this.depositoSex = depositoSex;
    }

    public String getTelefone() {
        return telefone;
    }

    public void setTelefone(String telefone) {
        this.telefone = telefone;
    }

    public String getCelular() {
        return celular;
    }

    public void setCelular(String celular) {
        this.celular = celular;
    }

    public String getFax() {
        return fax;
    }

    public void setFax(String fax) {
        this.fax = fax;
    }

    public String getWhatsApp() {
        return whatsApp;
    }

    public void setWhatsApp(String whatsApp) {
        this.whatsApp = whatsApp;
    }

    public String getOrelhaoProximo() {
        return orelhaoProximo;
    }

    public void setOrelhaoProximo(String orelhaoProximo) {
        this.orelhaoProximo = orelhaoProximo;
    }

    public String getEmail() {
        return email;
    }

    public void setEmail(String email) {
        this.email = email;
    }

    public String getSkype() {
        return skype;
    }

    public void setSkype(String skype) {
        this.skype = skype;
    }

    public String getFacebook() {
        return facebook;
    }

    public void setFacebook(String facebook) {
        this.facebook = facebook;
    }

    public String getSite() {
        return site;
    }

    public void setSite(String site) {
        this.site = site;
    }

    public Date getFuncSegASextAbert() {
        return funcSegASextAbert;
    }

    public void setFuncSegASextAbert(Date funcSegASextAbert) {
        this.funcSegASextAbert = funcSegASextAbert;
    }

    public Date getFuncSegASextFechar() {
        return funcSegASextFechar;
    }

    public void setFuncSegASextFechar(Date funcSegASextFechar) {
        this.funcSegASextFechar = funcSegASextFechar;
    }

    public Date getFuncSabadoAbert() {
        return funcSabadoAbert;
    }

    public void setFuncSabadoAbert(Date funcSabadoAbert) {
        this.funcSabadoAbert = funcSabadoAbert;
    }

    public Date getFuncSabadoFechar() {
        return funcSabadoFechar;
    }

    public void setFuncSabadoFechar(Date funcSabadoFechar) {
        this.funcSabadoFechar = funcSabadoFechar;
    }

    public boolean isOpArrecContas() {
        return opArrecContas;
    }

    public void setOpArrecContas(boolean opArrecContas) {
        this.opArrecContas = opArrecContas;
    }

    public boolean isOpVendCD() {
        return opVendCD;
    }

    public void setOpVendCD(boolean opVendCD) {
        this.opVendCD = opVendCD;
    }

    public boolean isOpServicos() {
        return opServicos;
    }

    public void setOpServicos(boolean opServicos) {
        this.opServicos = opServicos;
    }

    public boolean isOpBB() {
        return opBB;
    }

    public void setOpBB(boolean opBB) {
        this.opBB = opBB;
    }

    public Date getHoraFechCaixa() {
        return horaFechCaixa;
    }

    public void setHoraFechCaixa(Date horaFechCaixa) {
        this.horaFechCaixa = horaFechCaixa;
    }

    public boolean isDiaAutOpSeg() {
        return diaAutOpSeg;
    }

    public void setDiaAutOpSeg(boolean diaAutOpSeg) {
        this.diaAutOpSeg = diaAutOpSeg;
    }

    public boolean isDiaAutOpTerc() {
        return diaAutOpTerc;
    }

    public void setDiaAutOpTerc(boolean diaAutOpTerc) {
        this.diaAutOpTerc = diaAutOpTerc;
    }

    public boolean isDiaAutOpQuar() {
        return diaAutOpQuar;
    }

    public void setDiaAutOpQuar(boolean diaAutOpQuar) {
        this.diaAutOpQuar = diaAutOpQuar;
    }

    public boolean isDiaAutOpQui() {
        return diaAutOpQui;
    }

    public void setDiaAutOpQui(boolean diaAutOpQui) {
        this.diaAutOpQui = diaAutOpQui;
    }

    public boolean isDiaAutOpSex() {
        return diaAutOpSex;
    }

    public void setDiaAutOpSex(boolean diaAutOpSex) {
        this.diaAutOpSex = diaAutOpSex;
    }

    public boolean isDiaAutOpSab() {
        return diaAutOpSab;
    }

    public void setDiaAutOpSab(boolean diaAutOpSab) {
        this.diaAutOpSab = diaAutOpSab;
    }

    public boolean isDiaAutOpDom() {
        return diaAutOpDom;
    }

    public void setDiaAutOpDom(boolean diaAutOpDom) {
        this.diaAutOpDom = diaAutOpDom;
    }

    public boolean isDiaAutOpFeriados() {
        return diaAutOpFeriados;
    }

    public void setDiaAutOpFeriados(boolean diaAutOpFeriados) {
        this.diaAutOpFeriados = diaAutOpFeriados;
    }

    public String getNomePro() {
        return nomePro;
    }

    public void setNomePro(String nomePro) {
        this.nomePro = nomePro;
    }

    public String getNomeGuerraPro() {
        return nomeGuerraPro;
    }

    public void setNomeGuerraPro(String nomeGuerraPro) {
        this.nomeGuerraPro = nomeGuerraPro;
    }

    public String getCpfPro() {
        return cpfPro;
    }

    public void setCpfPro(String cpfPro) {
        this.cpfPro = cpfPro;
    }

    public String getRgPro() {
        return rgPro;
    }

    public void setRgPro(String rgPro) {
        this.rgPro = rgPro;
    }

    public Date getDataNascimentoPro() {
        return dataNascimentoPro;
    }

    public void setDataNascimentoPro(Date dataNascimentoPro) {
        this.dataNascimentoPro = dataNascimentoPro;
    }

    public String getTelefonePro() {
        return telefonePro;
    }

    public void setTelefonePro(String telefonePro) {
        this.telefonePro = telefonePro;
    }

    public String getCelularPro() {
        return celularPro;
    }

    public void setCelularPro(String celularPro) {
        this.celularPro = celularPro;
    }

    public String getFaxPro() {
        return faxPro;
    }

    public void setFaxPro(String faxPro) {
        this.faxPro = faxPro;
    }

    public String getEmailPro() {
        return emailPro;
    }

    public void setEmailPro(String emailPro) {
        this.emailPro = emailPro;
    }

    public String getProfissaoPro() {
        return profissaoPro;
    }

    public void setProfissaoPro(String profissaoPro) {
        this.profissaoPro = profissaoPro;
    }

    public BigDecimal getRendaPro() {
        return rendaPro;
    }

    public void setRendaPro(BigDecimal rendaPro) {
        this.rendaPro = rendaPro;
    }

    public EstadoCivil getEstadoCivilPro() {
        return estadoCivilPro;
    }

    public void setEstadoCivilPro(EstadoCivil estadoCivilPro) {
        this.estadoCivilPro = estadoCivilPro;
    }

    public Escolaridade getEscolaridadePro() {
        return escolaridadePro;
    }

    public void setEscolaridadePro(Escolaridade escolaridadePro) {
        this.escolaridadePro = escolaridadePro;
    }

    public String getNomePaiPro() {
        return nomePaiPro;
    }

    public void setNomePaiPro(String nomePaiPro) {
        this.nomePaiPro = nomePaiPro;
    }

    public String getNomeMaePro() {
        return nomeMaePro;
    }

    public void setNomeMaePro(String nomeMaePro) {
        this.nomeMaePro = nomeMaePro;
    }

    public String getTelefoneMaePro() {
        return telefoneMaePro;
    }

    public void setTelefoneMaePro(String telefoneMaePro) {
        this.telefoneMaePro = telefoneMaePro;
    }

    public String getTelefonePaiPro() {
        return telefonePaiPro;
    }

    public void setTelefonePaiPro(String telefonePaiPro) {
        this.telefonePaiPro = telefonePaiPro;
    }

    public Date getNascPaiPro() {
        return nascPaiPro;
    }

    public void setNascPaiPro(Date nascPaiPro) {
        this.nascPaiPro = nascPaiPro;
    }

    public Date getNascMaePro() {
        return nascMaePro;
    }

    public void setNascMaePro(Date nascMaePro) {
        this.nascMaePro = nascMaePro;
    }

    public String getEmailPaiPro() {
        return emailPaiPro;
    }

    public void setEmailPaiPro(String emailPaiPro) {
        this.emailPaiPro = emailPaiPro;
    }

    public String getEmailMaePro() {
        return emailMaePro;
    }

    public void setEmailMaePro(String emailMaePro) {
        this.emailMaePro = emailMaePro;
    }

    public Boolean getParticipaNegocioMaePro() {
        return participaNegocioMaePro;
    }

    public void setParticipaNegocioMaePro(Boolean participaNegocioMaePro) {
        this.participaNegocioMaePro = participaNegocioMaePro;
    }

    public Boolean getParticipaNegocioPaiPro() {
        return participaNegocioPaiPro;
    }

    public void setParticipaNegocioPaiPro(Boolean participaNegocioPaiPro) {
        this.participaNegocioPaiPro = participaNegocioPaiPro;
    }

    public String getReligiaoPro() {
        return religiaoPro;
    }

    public void setReligiaoPro(String religiaoPro) {
        this.religiaoPro = religiaoPro;
    }

    public String getLazerPro() {
        return lazerPro;
    }

    public void setLazerPro(String lazerPro) {
        this.lazerPro = lazerPro;
    }

    public String getPrefMusicalPro() {
        return prefMusicalPro;
    }

    public void setPrefMusicalPro(String prefMusicalPro) {
        this.prefMusicalPro = prefMusicalPro;
    }

    public String getPrefLeituraPro() {
        return prefLeituraPro;
    }

    public void setPrefLeituraPro(String prefLeituraPro) {
        this.prefLeituraPro = prefLeituraPro;
    }

    public String getEsportePro() {
        return esportePro;
    }

    public void setEsportePro(String esportePro) {
        this.esportePro = esportePro;
    }

    public String getTimePro() {
        return timePro;
    }

    public void setTimePro(String timePro) {
        this.timePro = timePro;
    }

    public String getNomeSocio() {
        return nomeSocio;
    }

    public void setNomeSocio(String nomeSocio) {
        this.nomeSocio = nomeSocio;
    }

    public String getNomeGuerraSocio() {
        return nomeGuerraSocio;
    }

    public void setNomeGuerraSocio(String nomeGuerraSocio) {
        this.nomeGuerraSocio = nomeGuerraSocio;
    }

    public String getCpfSocio() {
        return cpfSocio;
    }

    public void setCpfSocio(String cpfSocio) {
        this.cpfSocio = cpfSocio;
    }

    public String getRgSocio() {
        return rgSocio;
    }

    public void setRgSocio(String rgSocio) {
        this.rgSocio = rgSocio;
    }

    public Date getDataNascimentoSocio() {
        return dataNascimentoSocio;
    }

    public void setDataNascimentoSocio(Date dataNascimentoSocio) {
        this.dataNascimentoSocio = dataNascimentoSocio;
    }

    public String getTelefoneSocio() {
        return telefoneSocio;
    }

    public void setTelefoneSocio(String telefoneSocio) {
        this.telefoneSocio = telefoneSocio;
    }

    public String getCelularSocio() {
        return celularSocio;
    }

    public void setCelularSocio(String celularSocio) {
        this.celularSocio = celularSocio;
    }

    public String getFaxSocio() {
        return faxSocio;
    }

    public void setFaxSocio(String faxSocio) {
        this.faxSocio = faxSocio;
    }

    public String getEmailSocio() {
        return emailSocio;
    }

    public void setEmailSocio(String emailSocio) {
        this.emailSocio = emailSocio;
    }

    public String getProfissaoSocio() {
        return profissaoSocio;
    }

    public void setProfissaoSocio(String profissaoSocio) {
        this.profissaoSocio = profissaoSocio;
    }

    public BigDecimal getRendaSocio() {
        return rendaSocio;
    }

    public void setRendaSocio(BigDecimal rendaSocio) {
        this.rendaSocio = rendaSocio;
    }

    public EstadoCivil getEstadoCivilSocio() {
        return estadoCivilSocio;
    }

    public void setEstadoCivilSocio(EstadoCivil estadoCivilSocio) {
        this.estadoCivilSocio = estadoCivilSocio;
    }

    public Escolaridade getEscolaridadeSocio() {
        return escolaridadeSocio;
    }

    public void setEscolaridadeSocio(Escolaridade escolaridadeSocio) {
        this.escolaridadeSocio = escolaridadeSocio;
    }

    public String getNomePaiSocio() {
        return nomePaiSocio;
    }

    public void setNomePaiSocio(String nomePaiSocio) {
        this.nomePaiSocio = nomePaiSocio;
    }

    public String getNomeMaeSocio() {
        return nomeMaeSocio;
    }

    public void setNomeMaeSocio(String nomeMaeSocio) {
        this.nomeMaeSocio = nomeMaeSocio;
    }

    public String getTelefoneMaeSocio() {
        return telefoneMaeSocio;
    }

    public void setTelefoneMaeSocio(String telefoneMaeSocio) {
        this.telefoneMaeSocio = telefoneMaeSocio;
    }

    public String getTelefonePaiSocio() {
        return telefonePaiSocio;
    }

    public void setTelefonePaiSocio(String telefonePaiSocio) {
        this.telefonePaiSocio = telefonePaiSocio;
    }

    public Date getNascPaiSocio() {
        return nascPaiSocio;
    }

    public void setNascPaiSocio(Date nascPaiSocio) {
        this.nascPaiSocio = nascPaiSocio;
    }

    public Date getNascMaeSocio() {
        return nascMaeSocio;
    }

    public void setNascMaeSocio(Date nascMaeSocio) {
        this.nascMaeSocio = nascMaeSocio;
    }

    public String getEmailPaiSocio() {
        return emailPaiSocio;
    }

    public void setEmailPaiSocio(String emailPaiSocio) {
        this.emailPaiSocio = emailPaiSocio;
    }

    public String getEmailMaeSocio() {
        return emailMaeSocio;
    }

    public void setEmailMaeSocio(String emailMaeSocio) {
        this.emailMaeSocio = emailMaeSocio;
    }

    public Boolean getParticipaNegocioMaeSocio() {
        return participaNegocioMaeSocio;
    }

    public void setParticipaNegocioMaeSocio(Boolean participaNegocioMaeSocio) {
        this.participaNegocioMaeSocio = participaNegocioMaeSocio;
    }

    public Boolean getParticipaNegocioPaiSocio() {
        return participaNegocioPaiSocio;
    }

    public void setParticipaNegocioPaiSocio(Boolean participaNegocioPaiSocio) {
        this.participaNegocioPaiSocio = participaNegocioPaiSocio;
    }

    public String getReligiaoSocio() {
        return religiaoSocio;
    }

    public void setReligiaoSocio(String religiaoSocio) {
        this.religiaoSocio = religiaoSocio;
    }

    public String getLazerSocio() {
        return lazerSocio;
    }

    public void setLazerSocio(String lazerSocio) {
        this.lazerSocio = lazerSocio;
    }

    public String getPrefMusicalSocio() {
        return prefMusicalSocio;
    }

    public void setPrefMusicalSocio(String prefMusicalSocio) {
        this.prefMusicalSocio = prefMusicalSocio;
    }

    public String getPrefLeituraSocio() {
        return prefLeituraSocio;
    }

    public void setPrefLeituraSocio(String prefLeituraSocio) {
        this.prefLeituraSocio = prefLeituraSocio;
    }

    public String getEsporteSocio() {
        return esporteSocio;
    }

    public void setEsporteSocio(String esporteSocio) {
        this.esporteSocio = esporteSocio;
    }

    public String getTimeSocio() {
        return timeSocio;
    }

    public void setTimeSocio(String timeSocio) {
        this.timeSocio = timeSocio;
    }

    public Conjuge getConjugeProprietario() {
        return conjugeProprietario;
    }

    public void setConjugeProprietario(Conjuge conjugeProprietario) {
        this.conjugeProprietario = conjugeProprietario;
    }

    public Conjuge getConjugeSocio() {
        return conjugeSocio;
    }

    public void setConjugeSocio(Conjuge conjugeSocio) {
        this.conjugeSocio = conjugeSocio;
    }

    public String getNomeTitularConta() {
        return nomeTitularConta;
    }

    public void setNomeTitularConta(String nomeTitularConta) {
        this.nomeTitularConta = nomeTitularConta;
    }

    public Bancos getBanco() {
        return banco;
    }

    public void setBanco(Bancos banco) {
        this.banco = banco;
    }

    public String getAgencia() {
        return agencia;
    }

    public void setAgencia(String agencia) {
        this.agencia = agencia;
    }

    public TipoContaBanco getTipoConta() {
        return tipoConta;
    }

    public void setTipoConta(TipoContaBanco tipoConta) {
        this.tipoConta = tipoConta;
    }

    public String getNumeroConta() {
        return numeroConta;
    }

    public void setNumeroConta(String numeroConta) {
        this.numeroConta = numeroConta;
    }

    public String getNomePropag() {
        return nomePropag;
    }

    public void setNomePropag(String nomePropag) {
        this.nomePropag = nomePropag;
    }

    public String getEnderecoPropag() {
        return enderecoPropag;
    }

    public void setEnderecoPropag(String enderecoPropag) {
        this.enderecoPropag = enderecoPropag;
    }

    public String getPontoRefereciaPropag() {
        return pontoRefereciaPropag;
    }

    public void setPontoRefereciaPropag(String pontoRefereciaPropag) {
        this.pontoRefereciaPropag = pontoRefereciaPropag;
    }

    public String getSlogan() {
        return slogan;
    }

    public void setSlogan(String slogan) {
        this.slogan = slogan;
    }

    public Date getDataInstalacao() {
        return dataInstalacao;
    }

    public void setDataInstalacao(Date dataInstalacao) {
        this.dataInstalacao = dataInstalacao;
    }

    public Date getDataConsulta() {
        return dataConsulta;
    }

    public void setDataConsulta(Date dataConsulta) {
        this.dataConsulta = dataConsulta;
    }

    public Date getDataAssinatura() {
        return dataAssinatura;
    }

    public void setDataAssinatura(Date dataAssinatura) {
        this.dataAssinatura = dataAssinatura;
    }

    public String getVendedor() {
        return vendedor;
    }

    public void setVendedor(String vendedor) {
        this.vendedor = vendedor;
    }

    public Integer getMetaDeGuias() {
        return metaDeGuias;
    }

    public void setMetaDeGuias(Integer metaDeGuias) {
        this.metaDeGuias = metaDeGuias;
    }

    public BigDecimal getMetaCreditosDigitais() {
        return metaCreditosDigitais;
    }

    public void setMetaCreditosDigitais(BigDecimal metaCreditosDigitais) {
        this.metaCreditosDigitais = metaCreditosDigitais;
    }

    public BigDecimal getValorDaPromissoria() {
        return valorDaPromissoria;
    }

    public void setValorDaPromissoria(BigDecimal valorDaPromissoria) {
        this.valorDaPromissoria = valorDaPromissoria;
    }

    public List<Filho> getFilhosProprietario() {
        return filhosProprietario;
    }

    public void setFilhosProprietario(List<Filho> filhosProprietario) {
        this.filhosProprietario = filhosProprietario;
    }

    public List<Filho> getFilhosSocio() {
        return filhosSocio;
    }

    public void setFilhosSocio(List<Filho> filhosSocio) {
        this.filhosSocio = filhosSocio;
    }

    public Endereco getEnderecoSocio() {
        return enderecoSocio;
    }

    public void setEnderecoSocio(Endereco enderecoSocio) {
        this.enderecoSocio = enderecoSocio;
    }

    public boolean isAtivo() {
        return ativo;
    }

    public void setAtivo(boolean ativo) {
        this.ativo = ativo;
    }

    public Endereco getEnderecoProprietario() {
        return enderecoProprietario;
    }

    public void setEnderecoProprietario(Endereco enderecoProprietario) {
        this.enderecoProprietario = enderecoProprietario;
    }

    public Contrato() {
    }

    @Override
    public int hashCode() {
        int hash = 3;
        hash = 61 * hash + (this.id != null ? this.id.hashCode() : 0);
        return hash;
    }

    @Override
    public boolean equals(Object obj) {
        if (obj == null) {
            return false;
        }
        if (getClass() != obj.getClass()) {
            return false;
        }
        final Contrato other = (Contrato) obj;
        if (this.id != other.id && (this.id == null || !this.id.equals(other.id))) {
            return false;
        }
        return true;
    }

}
