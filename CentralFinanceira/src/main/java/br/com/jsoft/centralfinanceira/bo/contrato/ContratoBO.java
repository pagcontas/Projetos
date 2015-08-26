package br.com.jsoft.centralfinanceira.bo.contrato;

import com.xpert.core.crud.AbstractBusinessObject;
import br.com.jsoft.centralfinanceira.dao.contrato.ContratoDAO;
import br.com.jsoft.centralfinanceira.modelo.central.Loja;
import com.xpert.core.validation.UniqueField;
import com.xpert.core.exception.BusinessException;
import java.util.List;
import javax.ejb.EJB;
import javax.ejb.Stateless;
import br.com.jsoft.centralfinanceira.modelo.contrato.Contrato;
import br.com.jsoft.centralfinanceira.modelo.contrato.PagContas;
import br.com.jsoft.centralfinanceira.MetodoUtilitario;
import br.com.jsoft.centralfinanceira.modelo.central.Cidade;
import br.com.jsoft.centralfinanceira.modelo.central.Uf;
import br.com.jsoft.centralfinanceira.modelo.contrato.Equipe;
import br.com.jsoft.centralfinanceira.modelo.contrato.Filho;
import com.xpert.faces.utils.FacesJasper;
import java.math.BigDecimal;
import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.util.Calendar;
import java.util.Date;
import java.util.HashMap;
import javax.swing.text.MaskFormatter;

/**
 *
 * @author ti05
 */
@Stateless
public class ContratoBO extends AbstractBusinessObject<Contrato> {

    @EJB
    private ContratoDAO contratoDAO;

    @EJB
    private PagContasBO pagcontasBO;

    private MetodoUtilitario util;

    @Override
    public ContratoDAO getDAO() {
        return contratoDAO;
    }

    @Override
    public List<UniqueField> getUniqueFields() {
        return null;
    }

    @Override
    public void validate(Contrato contrato) throws BusinessException {
    }

    @Override
    public boolean isAudit() {
        return true;
    }

    public void gerarFichaDeInscricao(Contrato contrato) {
        Loja loja = contratoDAO.getInitialized(contrato.getLoja());
        Cidade cidadeLoja = contratoDAO.getInitialized(loja.getCidade());
        List<Filho> filhosProprietario = contratoDAO.getInitialized(contrato.getFilhosProprietario());
        List<Filho> filhosSocio = contratoDAO.getInitialized(contrato.getFilhosSocio());
        List<Equipe> equipe = contratoDAO.getInitialized(contrato.getEquipes());

        Uf estadoLoja = null;
        if (cidadeLoja != null) {
            estadoLoja = contratoDAO.getInitialized(cidadeLoja.getUf());
        }
        Cidade cidadeEndPro = null;
        if (contrato.getEnderecoProprietario() != null) {
            cidadeEndPro = contratoDAO.getInitialized(contrato.getEnderecoProprietario().getCidade());
        }

        Uf estadoEndPro = null;
        if (cidadeEndPro != null) {
            estadoEndPro = contratoDAO.getInitialized(cidadeEndPro.getUf());
        }
        Cidade cidadeEndSoc = null;
        if (contrato.getEnderecoSocio() != null) {
            cidadeEndSoc = contratoDAO.getInitialized(contrato.getEnderecoSocio().getCidade());
        }

        Uf estadoEndSoc = null;
        if (cidadeEndSoc != null) {
            estadoEndSoc = contratoDAO.getInitialized(cidadeEndSoc.getUf());
        }

        HashMap params = new HashMap();
        params.put("pagContas", getNegrito(getPagContas().getRazaoSocial().toUpperCase()));
        params.put("inforCad", getNegrito("INFORMAÇÕES CADASTRAIS"));
        params.put("inforPesPro", getNegrito("INFORMAÇÕES PESSOAIS DO PROPRIETÁRIO"));
        params.put("inforPesSoc", getNegrito("INFORMAÇÕES PESSOAIS DO SÓCIO - AVALISTA"));
        params.put("refBanc", getNegrito("REFERÊNCIAS BANCÁRIAS"));
        params.put("outInfor", getNegrito("OUTRAS INFORMAÇÕES"));
        params.put("dadosElabPro", getNegrito("DADOS PARA ELABORAÇÃO DA PROPAGANDA"));
        params.put("refPes", getNegrito("REFERÊNCIAS PESSOAIS"));
        params.put("inforEquipe", getNegrito("INFORMAÇÕES DA EQUIPE"));
        params.put("txtFieldDtInsta", getNegrito("DATA INSTALAÇÃO:"));
        params.put("txtFieldDtCons", getNegrito("DATA CONSULTA: "));
        params.put("txtFieldVendedor", getNegrito("VENDEDOR:"));

        params.put("dataInstalacao", (contrato.getDataInstalacao() != null ? convertDateToString(contrato.getDataInstalacao(), 1) : " "));
        params.put("dataConsulta", (contrato.getDataConsulta() != null ? convertDateToString(contrato.getDataConsulta(), 1) : ""));
        params.put("vendedor", contrato.getVendedor() != null ? contrato.getVendedor().toUpperCase() : "");
        params.put("numAgente", loja.getId().toString());
        params.put("numPost", loja.getId().toString());
        params.put("ramoAtividade", contrato.getRamoAtividades()!=null ? contrato.getRamoAtividades().toUpperCase():"");
        params.put("razaoSocial", loja.getRazaosocial()!=null ? loja.getRazaosocial().toUpperCase():"");
        params.put("nomeFantasia", loja.getNome() !=null ? loja.getNome().toUpperCase() : "");
        params.put("enderecoInfCad", loja.getEndereco() !=null ? loja.getEndereco().toUpperCase():"");
        params.put("cepInfCad", loja.getCep());
        params.put("bairroInfCad", loja.getBairro()!=null ? loja.getBairro().toUpperCase():"");
        params.put("cidadeInfCad", cidadeLoja != null ? cidadeLoja.getNome().toUpperCase() : "");
        params.put("ufInfCad", estadoLoja != null ? estadoLoja.getSigla().toUpperCase() : "");
        params.put("cnpjInfCad", (loja.getCnpj() != null ? format("##.###.###/####-##", loja.getCnpj()) : ""));
        params.put("insEstInfCad", (loja.getInscricaoEstadual() != null ? format("##.###.###-#", loja.getInscricaoEstadual()) : ""));
        params.put("teleInfCad", (contrato.getTelefone() != null && !contrato.getTelefone().equals("") ? format("(##) ####-####", contrato.getTelefone()) : ""));
        params.put("faxInfCad", (contrato.getFax() != null && !contrato.getFax().equals("") ? format("(##) ####-####", contrato.getFax()) : ""));
        params.put("celInfCad", (contrato.getCelular() != null && !contrato.getCelular().equals("") ? format("(##) ####-####", contrato.getCelular()) : ""));
        params.put("orelhaoInfCad", (contrato.getOrelhaoProximo() != null && !contrato.getOrelhaoProximo().equals("") ? format("(##) ####-####", contrato.getOrelhaoProximo()) : ""));
        params.put("emailInfCad", contrato.getEmail());
        params.put("siteInfCad", contrato.getSite());
        params.put("skypeInfCad", contrato.getSkype() !=null?contrato.getSkype().toUpperCase():"");
        params.put("inicAtInfCad", (contrato.getInicioAtividades() != null ? convertDateToString(contrato.getInicioAtividades(), 1) : ""));
        params.put("depSegInfCad", contrato.isDiaAutOpSeg() ? "(X)" : "( )");
        params.put("depTerInfCad", contrato.isDiaAutOpTerc() ? "(X)" : "( )");
        params.put("depQuaInfCad", contrato.isDiaAutOpQuar() ? "(X)" : "( )");
        params.put("depQuiInfCad", contrato.isDiaAutOpQui() ? "(X)" : "( )");
        params.put("depSexInfCad", contrato.isDiaAutOpSex() ? "(X)" : "( )");
        params.put("horFuncInfCad", (contrato.getFuncSegASextAbert() != null && contrato.getFuncSegASextFechar() != null ? convertDateToString(contrato.getFuncSegASextAbert(), 3) + "as "
                + convertDateToString(contrato.getFuncSegASextFechar(), 3) : ""));
        params.put("opArrecInfCad", contrato.isOpArrecContas() ? "(X)" : "( )");
        params.put("opVendInfCad", contrato.isOpVendCD() ? "(X)" : "( )");
        params.put("opServInfCad", contrato.isOpServicos() ? "(X)" : "( )");
        params.put("opBBInfCad", contrato.isOpBB() ? "(X)" : "( )");
        params.put("horFechCxInfCad", contrato.getHoraFechCaixa() != null ? convertDateToString(contrato.getHoraFechCaixa(), 3) + "HORAS" : "");
        params.put("autSegInfCad", contrato.isDiaAutOpSeg() ? "(X)" : "( )");
        params.put("autTerInfCad", contrato.isDiaAutOpTerc() ? "(X)" : "( )");
        params.put("autQuaInfCad", contrato.isDiaAutOpQuar() ? "(X)" : "( )");
        params.put("autQuiInfCad", contrato.isDiaAutOpQui() ? "(X)" : "( )");
        params.put("autSexInfCad", contrato.isDiaAutOpSex() ? "(X)" : "( )");
        params.put("autSabInfCad", contrato.isDiaAutOpSab() ? "(X)" : "( )");
        params.put("autDomInfCad", contrato.isDiaAutOpDom() ? "(X)" : "( )");
        params.put("autFerInfCad", contrato.isDiaAutOpFeriados() ? "(X)" : "( )");

        params.put("nomePro", contrato.getNomePro() !=null ? contrato.getNomePro().toUpperCase():"");
        params.put("nomeGuerraPro", contrato.getNomeGuerraPro());
        params.put("enderecoPro", contrato.getEnderecoProprietario() !=null ? contrato.getEnderecoProprietario().getEndereco():"");
        params.put("bairroPro", contrato.getEnderecoProprietario() !=null ? contrato.getEnderecoProprietario().getBairro(): "");
        params.put("cidadePro", cidadeEndPro != null ? cidadeEndPro.getNome().toUpperCase() : "");
        params.put("ufPro", estadoEndPro != null ? estadoEndPro.getSigla().toUpperCase() : "");
        params.put("cepPro", contrato.getEnderecoProprietario() !=null ? contrato.getEnderecoProprietario().getCep():"");
        params.put("telPro", contrato.getTelefonePro());
        params.put("celPro", contrato.getCelularPro());
        params.put("emailPro", contrato.getEmailPro());
        params.put("faxPro", contrato.getFax());
        params.put("cpfPro", format("###.###.###-##", contrato.getCpfPro()));
        params.put("rgPro", contrato.getRgPro());
        params.put("dtNascPro", contrato.getDataNascimentoPro() != null ? convertDateToString(contrato.getDataNascimentoPro(), 1) : "");
        params.put("profiPro", contrato.getNomePaiPro());
        params.put("rendaPro", contrato.getRendaPro());
        params.put("estadoCivPro", contrato.getEstadoCivilPro() != null ? contrato.getEstadoCivilPro().getDescricao().toUpperCase() : "");
        params.put("escolaPro", contrato.getEscolaridadePro() != null ? contrato.getEscolaridadePro().getDescricao().toUpperCase() : "");
        params.put("religiaoPro", contrato.getReligiaoPro());
        params.put("lazerPro", contrato.getLazerPro());
        params.put("prefMusciaPro", contrato.getPrefMusicalPro());
        params.put("prefLeituraPro", contrato.getPrefLeituraPro());
        params.put("esportPro", contrato.getEsportePro());
        params.put("timePro", contrato.getTimePro());
        params.put("conjuPro", contrato.getConjugeProprietario()!=null ? contrato.getConjugeProprietario().getNome():"");
        params.put("nomeGueConjPro", contrato.getConjugeProprietario()!=null ? contrato.getConjugeProprietario().getNomeGuerra():"");
        params.put("cpfConjPro", contrato.getConjugeProprietario()!=null ? contrato.getConjugeProprietario().getCpf() != null ? format("###.###.###-##", contrato.getConjugeProprietario().getCpf()) : "":"");
        params.put("rgConjPro", contrato.getConjugeProprietario()!=null ? contrato.getConjugeProprietario().getRg():"");
        params.put("celConjPro", contrato.getConjugeProprietario()!=null ? contrato.getConjugeProprietario().getCelular():"");
        params.put("dtNascConjPro", contrato.getConjugeProprietario()!=null ? contrato.getConjugeProprietario().getNascimento() != null ? convertDateToString(contrato.getConjugeProprietario().getNascimento(), 1) : "":"");
        if (filhosProprietario.size() == 1) {
            params.put("filho1Pro", filhosProprietario.get(0).getNome() !=null ? filhosProprietario.get(0).getNome().toUpperCase():"");
            params.put("filho1TelPro", filhosProprietario.get(0).getTelefone());
            params.put("filho1dtNascPro", filhosProprietario.get(0).getNascimento() != null ? convertDateToString(filhosProprietario.get(0).getNascimento(), 1) : "");
            params.put("filho1PartNegPro", filhosProprietario.get(0).getParticipaNegocio() != null ? filhosProprietario.get(0).getParticipaNegocio() ? "S" : "N" : "");
            params.put("filho1EmailPro", filhosProprietario.get(0).getEmail());
        }
        if (filhosProprietario.size() == 2) {
            params.put("filho2Pro", filhosProprietario.get(1).getNome() !=null ?filhosProprietario.get(1).getNome().toUpperCase():"");
            params.put("filho2TelPro", filhosProprietario.get(1).getTelefone());
            params.put("filho2dtNascPro", filhosProprietario.get(1).getNascimento() != null ? convertDateToString(filhosProprietario.get(1).getNascimento(), 1) : "");
            params.put("filho2PartNegPro", filhosProprietario.get(1).getParticipaNegocio() != null ? filhosProprietario.get(1).getParticipaNegocio() ? "S" : "N" : "");
            params.put("filho2EmailPro", filhosProprietario.get(1).getEmail());
        }
        if (filhosProprietario.size() == 3) {
            params.put("filho3Pro", filhosProprietario.get(2).getNome() !=null ? filhosProprietario.get(2).getNome().toUpperCase():"");
            params.put("filho3TelPro", filhosProprietario.get(2).getTelefone());
            params.put("filho3dtNascPro", filhosProprietario.get(2).getNascimento() != null ? convertDateToString(filhosProprietario.get(2).getNascimento(), 1) : "");
            params.put("filho3PartNegPro", filhosProprietario.get(2).getParticipaNegocio() != null ? filhosProprietario.get(2).getParticipaNegocio() ? "S" : "N" : "");
            params.put("filho3EmailPro", filhosProprietario.get(2).getEmail());
        }
        if (filhosProprietario.size() == 4) {
            params.put("filho4Pro", filhosProprietario.get(3).getNome() !=null ? filhosProprietario.get(3).getNome().toUpperCase():"");
            params.put("filho4TelPro", filhosProprietario.get(3).getTelefone());
            params.put("filho4dtNascPro", filhosProprietario.get(3).getNascimento() != null ? convertDateToString(filhosProprietario.get(3).getNascimento(), 1) : "");
            params.put("filho4PartNegPro", filhosProprietario.get(3).getParticipaNegocio() != null ? filhosProprietario.get(3).getParticipaNegocio() ? "S" : "N" : "");
            params.put("filho4EmailPro", filhosProprietario.get(3).getEmail());
        }
        if (filhosProprietario.size() == 5) {
            params.put("filho5Pro", filhosProprietario.get(4).getNome() !=null ? filhosProprietario.get(4).getNome().toUpperCase():"");
            params.put("filho5TelPro", filhosProprietario.get(4).getTelefone());
            params.put("filho5dtNascPro", filhosProprietario.get(4).getNascimento() != null ? convertDateToString(filhosProprietario.get(4).getNascimento(), 1) : "");
            params.put("filho5PartNegPro", filhosProprietario.get(4).getParticipaNegocio() != null ? filhosProprietario.get(4).getParticipaNegocio() ? "S" : "N" : "");
            params.put("filho5EmailPro", filhosProprietario.get(4).getEmail());
        }

        params.put("paiPro", contrato.getNomePaiPro());
        params.put("paiTelPro", contrato.getTelefonePaiPro());
        params.put("paiDtNascPro", contrato.getNascPaiPro() != null ? convertDateToString(contrato.getNascPaiPro(), 1) : "");
        params.put("paiPartNegPro", contrato.getParticipaNegocioPaiPro() != null ? (contrato.getParticipaNegocioPaiPro() ? "S" : "N") : "");
        params.put("paiEmailPro", contrato.getEmailPaiPro());
        params.put("maePro", contrato.getNomeMaePro());
        params.put("maeTelPro", contrato.getTelefoneMaePro());
        params.put("maeDtaNascPro", contrato.getNascMaePro() != null ? convertDateToString(contrato.getNascMaePro(), 1) : "");
        params.put("maePartNegPro", contrato.getParticipaNegocioMaePro() != null ? (contrato.getParticipaNegocioMaePro() ? "S" : "N") : "");
        params.put("maeEmailPro", contrato.getEmailMaePro());
        params.put("paiConjPro", contrato.getConjugeProprietario()!=null?contrato.getConjugeProprietario().getNomePai():"");
        params.put("paiConjTelPro", contrato.getConjugeProprietario()!=null?contrato.getConjugeProprietario().getTelefonePai():"");
        params.put("paiConjDtNascPro", contrato.getConjugeProprietario()!=null? contrato.getConjugeProprietario().getNascimentoPai() != null ? convertDateToString(contrato.getConjugeProprietario().getNascimentoPai(), 1) : "":"");
        params.put("paiConjPartNegPro", contrato.getConjugeProprietario()!=null? contrato.getConjugeProprietario().getParticipaNegocioPai() != null ? (contrato.getConjugeProprietario().getParticipaNegocioPai() ? "S" : "N") : "":"");
        params.put("paiConjEmailPro", contrato.getConjugeProprietario()!=null? contrato.getConjugeProprietario().getEmailPai():"");
        params.put("maeConjPro", contrato.getConjugeProprietario()!=null? contrato.getConjugeProprietario().getNomeMae():"");
        params.put("maeConjTelPro", contrato.getConjugeProprietario()!=null? contrato.getConjugeProprietario().getTelefoneMae():"");
        params.put("maeConjDtNascPro", contrato.getConjugeProprietario()!=null? contrato.getConjugeProprietario().getNascimentoMae() != null ? convertDateToString(contrato.getConjugeProprietario().getNascimentoMae(), 1) : "":"");
        params.put("maeConjPartNegPro", contrato.getConjugeProprietario()!=null? contrato.getConjugeProprietario().getParticipaNegocioMae() != null ? (contrato.getConjugeProprietario().getParticipaNegocioMae() ? "S" : "N") : "":"");
        params.put("maeConjEmailPro", contrato.getConjugeProprietario()!=null? contrato.getConjugeProprietario().getEmailMae():"");
        params.put("nomeSoc", contrato.getNomeSocio());
        params.put("nomeGuerraSoc", contrato.getNomeGuerraSocio());
        params.put("enderecoSoc", contrato.getEnderecoSocio() !=null ?contrato.getEnderecoSocio().getEndereco():"");
        params.put("bairroSoc", contrato.getEnderecoSocio() !=null ? contrato.getEnderecoSocio().getBairro():"");
        params.put("cidadeSoc", cidadeEndSoc != null ? cidadeEndSoc.getNome().toUpperCase() : "");
        params.put("ufSoc", estadoEndSoc != null ? estadoEndSoc.getSigla().toUpperCase() : "");
        params.put("cepSoc", contrato.getEnderecoSocio()!=null ? contrato.getEnderecoSocio().getCep(): "");
        params.put("telSoc", contrato.getTelefoneSocio());
        params.put("celSoc", contrato.getCelularSocio());
        params.put("emailSoc", contrato.getEmailSocio());
        params.put("faxSoc", contrato.getFaxSocio());
        params.put("cpfSoc", contrato.getCpfSocio() != null ? format("###.###.###-##", contrato.getCpfSocio()) : "");
        params.put("rgSoc", contrato.getRgSocio());
        params.put("dtNascSoc", contrato.getDataNascimentoSocio() != null ? convertDateToString(contrato.getDataNascimentoSocio(), 1) : "");
        params.put("profiSoc", contrato.getProfissaoSocio() !=null ? contrato.getProfissaoSocio().toUpperCase():"");
        params.put("rendaSoc", contrato.getRendaSocio());
        params.put("estadoCivSoc", contrato.getEstadoCivilPro() != null ? contrato.getEstadoCivilPro().getDescricao().toUpperCase() : "");
        params.put("escolaSoc", contrato.getEscolaridadeSocio() != null ? contrato.getEscolaridadeSocio().getDescricao().toUpperCase() : "");
        params.put("religiaoSoc", contrato.getReligiaoSocio());
        params.put("lazerSoc", contrato.getLazerSocio());
        params.put("prefMusciaSoc", contrato.getPrefMusicalSocio());
        params.put("prefLeituraSoc", contrato.getPrefLeituraSocio());
        params.put("esportSoc", contrato.getEsporteSocio());
        params.put("timeSoc", contrato.getTimeSocio());
        params.put("conjuSoc", contrato.getConjugeSocio()!=null ? contrato.getConjugeSocio().getNome():"");
        params.put("nomeGueConjSoc", contrato.getConjugeProprietario() !=null ?contrato.getConjugeProprietario().getNomeGuerra():"");
        params.put("cpfConjSoc", contrato.getConjugeProprietario() !=null ? contrato.getConjugeProprietario().getCpf() != null ? format("###.###.###-##", contrato.getConjugeProprietario().getCpf()) : "" :"");
        params.put("rgConjSoc", contrato.getConjugeProprietario() !=null ? contrato.getConjugeProprietario().getRg() :"");
        params.put("celConjSoc", contrato.getConjugeProprietario() !=null ? contrato.getConjugeProprietario().getCelular() :"");
        params.put("dtNascConjSoc", contrato.getConjugeProprietario() !=null ? contrato.getConjugeProprietario().getNascimento() != null ? convertDateToString(contrato.getConjugeProprietario().getNascimento(), 1) : "":"");

        if (filhosSocio.size() == 1) {
            params.put("filho1Soc", filhosSocio.get(0).getNome()!=null ? filhosSocio.get(0).getNome().toUpperCase():"");
            params.put("filho1TelSoc", filhosSocio.get(0).getTelefone());
            params.put("filho1dtNascSoc", filhosSocio.get(0).getNascimento() != null ? convertDateToString(filhosSocio.get(0).getNascimento(), 1) : "");
            params.put("filho1PartNegSoc", filhosSocio.get(0).getParticipaNegocio() != null ? filhosSocio.get(0).getParticipaNegocio() ? "S" : "N" : "");
            params.put("filho1EmailSoc", filhosSocio.get(0).getEmail());
        }

        if (filhosSocio.size() == 2) {
            params.put("filho2Soc", filhosSocio.get(1).getNome()!=null ? filhosSocio.get(1).getNome().toUpperCase():"");
            params.put("filho2TelSoc", filhosSocio.get(1).getTelefone());
            params.put("filho2dtNascSoc", filhosSocio.get(1).getNascimento() != null ? convertDateToString(filhosSocio.get(1).getNascimento(), 1) : "");
            params.put("filho2PartNegSoc", filhosSocio.get(1).getParticipaNegocio() != null ? filhosSocio.get(1).getParticipaNegocio() ? "S" : "N" : "");
            params.put("filho2EmailSoc", filhosSocio.get(1).getEmail());
        }

        if (filhosSocio.size() == 3) {
            params.put("filho3Soc", filhosSocio.get(2).getNome()!=null ?filhosSocio.get(2).getNome().toUpperCase():"");
            params.put("filho3TelSoc", filhosSocio.get(2).getTelefone());
            params.put("filho3dtNascSoc", filhosSocio.get(2).getNascimento() != null ? convertDateToString(filhosSocio.get(2).getNascimento(), 1) : "");
            params.put("filho3PartNegSoc", filhosSocio.get(2).getParticipaNegocio() != null ? filhosSocio.get(2).getParticipaNegocio() ? "S" : "N" : "");
            params.put("filho3EmailSoc", filhosSocio.get(2).getEmail());
        }

        if (filhosSocio.size() == 4) {
            params.put("filho4Soc", filhosSocio.get(3).getNome()!=null ? filhosSocio.get(3).getNome().toUpperCase():"");
            params.put("filho4TelSoc", filhosSocio.get(3).getTelefone());
            params.put("filho4dtNascSoc", filhosSocio.get(3).getNascimento() != null ? convertDateToString(filhosSocio.get(3).getNascimento(), 1) : "");
            params.put("filho4PartNegSoc", filhosSocio.get(3).getParticipaNegocio() != null ? filhosSocio.get(3).getParticipaNegocio() ? "S" : "N" : "");
            params.put("filho4EmailSoc", filhosSocio.get(3).getEmail());
        }

        if (filhosSocio.size() == 5) {
            params.put("filho5Soc", filhosSocio.get(4).getNome()!=null ? filhosSocio.get(4).getNome().toUpperCase():"");
            params.put("filho5TelSoc", filhosSocio.get(4).getTelefone());
            params.put("filho5dtNascSoc", filhosSocio.get(4).getNascimento() != null ? convertDateToString(filhosSocio.get(4).getNascimento(), 1) : "");
            params.put("filho5PartNegSoc", filhosSocio.get(4).getParticipaNegocio() != null ? filhosSocio.get(4).getParticipaNegocio() ? "S" : "N" : "");
            params.put("filho5EmailSoc", filhosSocio.get(4).getEmail());
        }

        params.put("paiSoc", contrato.getNomePaiSocio());
        params.put("paiTelSoc", contrato.getTelefonePaiSocio());
        params.put("paiDtNascSoc", contrato.getNascPaiSocio() != null ? convertDateToString(contrato.getNascPaiSocio(), 1) : "");
        params.put("paiPartNegSoc", contrato.getParticipaNegocioPaiSocio() != null ? (contrato.getParticipaNegocioPaiSocio() ? "S" : "N") : "");
        params.put("paiEmailSoc", contrato.getEmailPaiSocio());
        params.put("maeSoc", contrato.getNomeMaeSocio());
        params.put("maeTelSoc", contrato.getTelefoneMaeSocio());
        params.put("maeDtaNascSoc", contrato.getNascMaeSocio() != null ? convertDateToString(contrato.getNascMaeSocio(), 1) : "");
        params.put("maePartNegSoc", contrato.getParticipaNegocioMaeSocio() != null ? (contrato.getParticipaNegocioMaeSocio() ? "S" : "N") : "");
        params.put("maeEmailSoc", contrato.getEmailMaeSocio());
        params.put("paiConjSoc", contrato.getConjugeSocio() !=null ? contrato.getConjugeSocio().getNomePai():"");
        params.put("paiConjTelSoc", contrato.getConjugeSocio() !=null ? contrato.getConjugeSocio().getTelefonePai():"");
        params.put("paiConjDtNascSoc", contrato.getConjugeSocio() !=null ? contrato.getConjugeSocio().getNascimentoPai() != null ? convertDateToString(contrato.getConjugeSocio().getNascimentoPai(), 1) : "":"");
        params.put("paiConjPartNegSoc", contrato.getConjugeSocio() !=null ? contrato.getConjugeSocio().getParticipaNegocioPai() != null ? (contrato.getConjugeSocio().getParticipaNegocioPai() ? "S" : "N") : "":"");
        params.put("paiConjEmailSoc", contrato.getConjugeSocio() !=null ? contrato.getConjugeSocio().getEmailPai():"");
        params.put("maeConjSoc", contrato.getConjugeSocio() !=null ? contrato.getConjugeSocio().getNomeMae():"");
        params.put("maeConjTelSoc", contrato.getConjugeSocio() !=null ? contrato.getConjugeSocio().getTelefoneMae():"");
        params.put("maeConjDtNascSoc", contrato.getConjugeSocio() !=null ? contrato.getConjugeSocio().getNascimentoMae() != null ? convertDateToString(contrato.getConjugeSocio().getNascimentoMae(), 1) : "":"");
        params.put("maeConjPartNegSoc", contrato.getConjugeSocio() !=null ? contrato.getConjugeSocio().getParticipaNegocioMae() != null ? (contrato.getConjugeSocio().getParticipaNegocioMae() ? "S" : "N") : "":"");
        params.put("maeConjEmailSoc", contrato.getConjugeSocio() !=null ? contrato.getConjugeSocio().getEmailMae():"");
        params.put("titularConta", contrato.getNomeTitularConta()!=null ?contrato.getNomeTitularConta().toUpperCase():"");
        params.put("banco", contrato.getBanco() != null ? contrato.getBanco().getDescricao() !=null ? contrato.getBanco().getDescricao().toUpperCase() :"" : "");
        params.put("agencia", contrato.getAgencia()!=null ? contrato.getAgencia().toUpperCase():"");
        params.put("tipoConta", contrato.getTipoConta() != null ? contrato.getTipoConta().getDescricao()!=null ? contrato.getTipoConta().getDescricao().toUpperCase():"" : "");
        params.put("numConta", contrato.getNumeroConta());
        params.put("limiteCaixa", "");
        params.put("limiteBoleto", "");
        params.put("tipoCorresp", "");
        params.put("hRecBanc", "");
        params.put("conhecidoPac", "");
        params.put("comoConhPac", "");
        params.put("nomeFantPropag", contrato.getNomePropag()!=null ? contrato.getNomePropag().toUpperCase():"");
        params.put("enderecoPropag", contrato.getEnderecoPropag()!=null ? contrato.getEnderecoPropag().toUpperCase():"");
        params.put("pontRefPropag", contrato.getPontoRefereciaPropag()!=null? contrato.getPontoRefereciaPropag().toUpperCase():"");
        params.put("recebCheqPropag", contrato.getPontoRefereciaPropag()!=null ? contrato.getPontoRefereciaPropag().toUpperCase():"");
        params.put("sloga", contrato.getSlogan()!=null ? contrato.getSlogan().toUpperCase():"");

        params.put("nome1RefPess", "");
        params.put("nome1GuerrRefPess", "");
        params.put("endereco1RefPess", "");
        params.put("bairro1RefPess", "");
        params.put("cidade1RefPess", "");
        params.put("uf1RefPess", "");
        params.put("tel1RefPess", "");
        params.put("cel1RefPess", "");
        params.put("email1RefPess", "");
        params.put("nome2RefPess", "");
        params.put("nome2GuerrRefPess", "");
        params.put("endereco2RefPess", "");
        params.put("bairro2RefPess", "");
        params.put("cidade2RefPess", "");
        params.put("uf2RefPess", "");
        params.put("tel2RefPess", "");
        params.put("cel2RefPess", "");
        params.put("email2RefPess", "");

        if (equipe.size() == 1) {
            params.put("cargo1Equipe", equipe.get(0).getCargo().toUpperCase());
            params.put("nome1Equipe", equipe.get(0).getNome().toUpperCase());
            params.put("dtNasc1Equipe", equipe.get(0).getDataNascimento() != null ? convertDateToString(equipe.get(0).getDataNascimento(), 1) : "");
            params.put("tel1Equipe", equipe.get(0).getTelefone());
            params.put("cel1Equipe", equipe.get(0).getCelular());
            params.put("email1Equipe", equipe.get(0).getEmail());
        }
        if (equipe.size() == 2) {
            params.put("cargo2Equipe", equipe.get(1).getCargo().toUpperCase());
            params.put("nome2Equipe", equipe.get(1).getNome().toUpperCase());
            params.put("dtNasc2Equipe", equipe.get(1).getDataNascimento() != null ? convertDateToString(equipe.get(1).getDataNascimento(), 1) : "");
            params.put("tel2Equipe", equipe.get(1).getTelefone());
            params.put("cel2Equipe", equipe.get(1).getCelular());
            params.put("ema2l1Equipe", equipe.get(1).getEmail());
        }
        if (equipe.size() == 3) {
            params.put("cargo3Equipe", equipe.get(2).getCargo().toUpperCase());
            params.put("nome3Equipe", equipe.get(2).getNome().toUpperCase());
            params.put("dtNasc3Equipe", equipe.get(2).getDataNascimento() != null ? convertDateToString(equipe.get(2).getDataNascimento(), 1) : "");
            params.put("tel3Equipe", equipe.get(2).getTelefone());
            params.put("cel3Equipe", equipe.get(2).getCelular());
            params.put("email3Equipe", equipe.get(2).getEmail());
        }
        if (equipe.size() == 4) {
            params.put("cargo4Equipe", equipe.get(3).getCargo().toUpperCase());
            params.put("nome4Equipe", equipe.get(3).getNome().toUpperCase());
            params.put("dtNasc4Equipe", equipe.get(3).getDataNascimento() != null ? convertDateToString(equipe.get(3).getDataNascimento(), 1) : "");
            params.put("tel4Equipe", equipe.get(3).getTelefone());
            params.put("cel4Equipe", equipe.get(3).getCelular());
            params.put("email4Equipe", equipe.get(3).getEmail());
        }
        if (equipe.size() == 5) {
            params.put("cargo5Equipe", equipe.get(4).getCargo().toUpperCase());
            params.put("nome5Equipe", equipe.get(4).getNome().toUpperCase());
            params.put("dtNasc5Equipe", equipe.get(4).getDataNascimento() != null ? convertDateToString(equipe.get(4).getDataNascimento(), 1) : "");
            params.put("tel5Equipe", equipe.get(4).getTelefone());
            params.put("cel5Equipe", equipe.get(4).getCelular());
            params.put("email5Equipe", equipe.get(4).getEmail());
        }
        if (equipe.size() == 6) {
            params.put("cargo6Equipe", equipe.get(5).getCargo().toUpperCase());
            params.put("nome6Equipe", equipe.get(5).getNome().toUpperCase());
            params.put("dtNasc6Equipe", equipe.get(5).getDataNascimento() != null ? convertDateToString(equipe.get(5).getDataNascimento(), 1) : "");
            params.put("tel6Equipe", equipe.get(5).getTelefone());
            params.put("cel6Equipe", equipe.get(5).getCelular());
            params.put("email6Equipe", equipe.get(5).getEmail());
        }
        if (equipe.size() == 7) {
            params.put("cargo7Equipe", equipe.get(6).getCargo().toUpperCase());
            params.put("nome7Equipe", equipe.get(6).getNome().toUpperCase());
            params.put("dtNasc7Equipe", equipe.get(6).getDataNascimento() != null ? convertDateToString(equipe.get(6).getDataNascimento(), 1) : "");
            params.put("tel7Equipe", equipe.get(6).getTelefone());
            params.put("cel7Equipe", equipe.get(6).getCelular());
            params.put("email7Equipe", equipe.get(6).getEmail());
        }
        if (equipe.size() == 8) {
            params.put("cargo8Equipe", equipe.get(7).getCargo().toUpperCase());
            params.put("nome8Equipe", equipe.get(7).getNome());
            params.put("dtNasc8Equipe", equipe.get(7).getDataNascimento() != null ? convertDateToString(equipe.get(7).getDataNascimento(), 1) : "");
            params.put("tel8Equipe", equipe.get(7).getTelefone());
            params.put("cel8Equipe", equipe.get(7).getCelular());
            params.put("email8Equipe", equipe.get(7).getEmail());
        }
        if (equipe.size() == 9) {
            params.put("cargo9Equipe", equipe.get(8).getCargo().toUpperCase());
            params.put("nome9Equipe", equipe.get(8).getNome().toUpperCase());
            params.put("dtNasc9Equipe", equipe.get(8).getDataNascimento() != null ? convertDateToString(equipe.get(8).getDataNascimento(), 1) : "");
            params.put("tel9Equipe", equipe.get(8).getTelefone());
            params.put("cel9Equipe", equipe.get(8).getCelular());
            params.put("email9Equipe", equipe.get(8).getEmail());
        }
        if (equipe.size() == 10) {
            params.put("cargo10Equipe", equipe.get(9).getCargo().toUpperCase());
            params.put("nome10Equipe", equipe.get(9).getNome().toUpperCase());
            params.put("dtNasc10Equipe", equipe.get(9).getDataNascimento() != null ? convertDateToString(equipe.get(9).getDataNascimento(), 1) : "");
            params.put("tel10Equipe", equipe.get(9).getTelefone());
            params.put("cel10Equipe", equipe.get(9).getCelular());
            params.put("email10Equipe", equipe.get(9).getEmail());
        }

        String nomeArquivo = loja.getNome() + " - " + loja.getId();
        FacesJasper.createJasperReport(null, params,
                "/WEB-INF/report/template/Contratos/fichaInscricao.jasper", "Ficha de Inscricao " + nomeArquivo);

    }

    public void gerarContrato(Contrato contrato) {
        Loja loja = contratoDAO.getInitialized(contrato.getLoja());
        Cidade cidadeLoja = contratoDAO.getInitialized(loja.getCidade());
        Cidade cidadePro = null;
        if (contrato.getEnderecoProprietario() != null) {
            if (contrato.getEnderecoProprietario().getCidade() != null) {
                cidadePro = contratoDAO.getInitialized(contrato.getEnderecoProprietario().getCidade());
            }
        }
        Uf estadoPro = null;
        if (cidadePro != null) {
            estadoPro = contratoDAO.getInitialized(cidadePro.getUf());
        }
        Uf estadoLoja = null;

        if (cidadeLoja != null) {
            estadoLoja = contratoDAO.getInitialized(cidadeLoja.getUf());
        }

        HashMap params = new HashMap();
        params.put("tituloContrato", getTituloContrato());
        params.put("texto1Contrato", getText1ContratoPagcontas());

        params.put("permissionaria", getNegrito("Permissionária: ") + loja.getRazaosocial().toUpperCase());
        params.put("nomeFantasia", getNegrito("Nome Fantasia: ") + loja.getNome().toUpperCase());
        params.put("cnpj", getNegrito("CNPJ: ") + format("##.###.###/####-##", loja.getCnpj()));
        params.put("inscricaoEstadual", getNegrito("Insc. Est.: ") + (loja.getInscricaoEstadual() != null ? format("##.###.###-#", loja.getInscricaoEstadual()) : ""));
        params.put("endereco", getNegrito("Endereço: ") + loja.getEndereco().toUpperCase());
        params.put("bairro", getNegrito("Bairro: ") + loja.getBairro().toUpperCase());
        params.put("cep", getNegrito("CEP: ") + format("##.###-###", loja.getCep()));
        params.put("cidade", getNegrito("Cidade: ") + cidadeLoja.getNome().toUpperCase() + "/" + estadoLoja.getSigla().toUpperCase());

        params.put("proprietario", getNegrito("Proprietário: ") + contrato.getNomePro());
        params.put("enderecoP", getNegrito("Endereço: ") + (contrato.getEnderecoProprietario()!=null ? contrato.getEnderecoProprietario().getEndereco():""));
        params.put("bairroP", getNegrito("Bairro: ") + (contrato.getEnderecoProprietario()!=null ? contrato.getEnderecoProprietario().getBairro():""));
        params.put("cepP", getNegrito("CEP: ") + (contrato.getEnderecoProprietario()!=null ? contrato.getEnderecoProprietario().getCep() != null ? format("##.###-###", contrato.getEnderecoProprietario().getCep()) : "":""));
        params.put("cidadeP", getNegrito("Cidade: ") + (cidadePro != null ? cidadePro.getNome() + "/" + estadoPro.getSigla() : "").toUpperCase());
        params.put("cpfP", getNegrito("CPF: ") + format("###.###.###-##", contrato.getCpfPro()));
        params.put("rgP", getNegrito("RG: ") + contrato.getRgPro());
        params.put("fiador1", getNegrito("Fiador: ") + contrato.getNomePro());
        params.put("cpfF1", getNegrito("CPF: ") + (contrato.getCpfPro() !=null ? format("###.###.###-##", contrato.getCpfPro()):""));
        params.put("fiador2", getNegrito("Fiador: ") + (contrato.getNomeSocio() != null ? contrato.getNomeSocio() : ""));
        params.put("cpfF2", getNegrito("CPF: ") + (contrato.getCpfSocio() != null ? format("###.###.###-##", contrato.getCpfSocio()) : ""));

        params.put("metasDeGuias", getNegrito("Meta de Guias: ") + (contrato.getMetaDeGuias()!=null ? contrato.getMetaDeGuias().toString():""));
        params.put("metaDeCredDig", getNegrito("Meta de Crédito Digital: ") + (contrato.getMetaCreditosDigitais() !=null ? contrato.getMetaCreditosDigitais().toString():"") + " " + 
                (contrato.getMetaCreditosDigitais() !=null ? valorPorExtenso(contrato.getMetaCreditosDigitais().doubleValue()):"").toUpperCase());
        params.put("valorPromissoria", getNegrito("Valor da promissória: ") + (contrato.getValorDaPromissoria() !=null ? contrato.getValorDaPromissoria().toString():"") + " " + 
                (contrato.getValorDaPromissoria() !=null ? valorPorExtenso(contrato.getValorDaPromissoria().doubleValue()):"").toUpperCase());

        params.put("texto2Contrato", getText2ContratoPagcontas());
        params.put("pagcontasRazaoSocial", getPagContas().getRazaoSocial().toUpperCase());

        params.put("nomeMaisProc1e2", getNegrito("Nome: ") + getPagContas().getNomeProc1() + " e " + getPagContas().getNomeProc2());
        params.put("cpfProc1", getNegrito("CPF: ") + (getPagContas().getCpfProc1() !=null ? format("###.###.###-##", getPagContas().getCpfProc1()):""));
        params.put("cpfProc2", getNegrito("CPF: ") + (getPagContas().getCpfProc2()!=null ? format("###.###.###-##", getPagContas().getCpfProc2()):""));
        params.put("dataAssinatura", dataPorExtenso("Teresina-PI", contrato.getDataAssinatura())); //

        String nomeArquivo = loja.getNome() + " - " + loja.getId();

        FacesJasper.createJasperReport(null, params,
                "/WEB-INF/report/template/Contratos/Contrato.jasper", "Contrato " + nomeArquivo);

    }

    public void gerarNotaPromissoria(Contrato contrato) {
        Loja loja = contratoDAO.getInitialized(contrato.getLoja());
        Cidade cidade = contratoDAO.getInitialized(loja.getCidade());
        Uf estado = null;
        if (cidade != null) {
            estado = contratoDAO.getInitialized(cidade.getUf());
        }

        Cidade cidadeP = null;
        if (contrato.getEnderecoProprietario() != null) {
            if (contrato.getEnderecoProprietario().getCidade() != null) {
                cidadeP = contratoDAO.getInitialized(contrato.getEnderecoProprietario().getCidade());
            }
        }

        Uf estadoP = null;
        if (cidadeP != null) {
            estadoP = contratoDAO.getInitialized(cidadeP.getUf());
        }

        Cidade cidadeS = null;
        if (contrato.getEnderecoSocio() != null) {
            if (contrato.getEnderecoProprietario().getCidade() != null) {
                contratoDAO.getInitialized(contrato.getEnderecoProprietario().getCidade());
            }
        }

        Uf estadoS = null;
        if (cidadeS != null) {
            estadoS = contratoDAO.getInitialized(cidadeS.getUf());
        }

        HashMap params = new HashMap();
        params.put("titulo", getTituloNotaPromissoria());
        params.put("textoNota", getTexto1Promissoria(contrato.getValorDaPromissoria()));
        params.put("dataCidade", (dataPorExtenso((cidade.getNome() + "-" + estado.getSigla().toUpperCase()), (contrato.getDataAssinatura() != null ? contrato.getDataAssinatura() : new Date()))));
        params.put("numberNum", "Nº: " + loja.getId().toString());
        params.put("numberPost", "POS: " + loja.getId().toString());
        params.put("valor", "VALOR: R$ " + (contrato.getValorDaPromissoria()!=null ? contrato.getValorDaPromissoria().toString():""));
        params.put("dataVencimento", "DATA DE VENCIMENTO: À VISTA");
        params.put("razaoSocial", "Razão Social: " + loja.getRazaosocial().toUpperCase());
        params.put("nomeFantasia", "Nome Fantasia: " + loja.getNome().toUpperCase());
        params.put("cnpj", "CNPJ/CPF: " + (format("##.###.###/####-##", loja.getCnpj())));
        params.put("proprietario", "Proprietário: " + contrato.getNomePro().toUpperCase());
        params.put("cpfP", "CPF: " + (format("###.###.###-##", contrato.getCpfPro())));
        params.put("socio", "Proprietário: " + (contrato.getNomeSocio() != null ? contrato.getNomeSocio().toUpperCase() : ""));
        params.put("cpfS", "CPF: " + (contrato.getCpfSocio() != null && !contrato.getCpfSocio().equals("") ? format("###.###.###-##", contrato.getCpfSocio()) : ""));
        params.put("enderecoPost", (loja.getEndereco().toUpperCase() + " - " + loja.getBairro().toUpperCase() + " - " + loja.getCep() + " - " + cidade.getNome().toUpperCase()
                + "/" + estado.getSigla()).toUpperCase());
        params.put("enderecoP", ((contrato.getEnderecoProprietario() != null ? (contrato.getEnderecoProprietario().getEndereco()!=null ? contrato.getEnderecoProprietario().getEndereco():"") + " - " : "") + ""
                + (contrato.getEnderecoProprietario() != null ? (contrato.getEnderecoProprietario().getBairro()!=null ? contrato.getEnderecoProprietario().getBairro():"") + " - " : "") + ""
                + (contrato.getEnderecoProprietario() != null ? (contrato.getEnderecoProprietario().getCep()!=null ? contrato.getEnderecoProprietario().getCep() + " - ":"") : "") + " - "
                + (cidadeP != null ? cidadeP.getNome() + "/" : "") + "" + (estadoP != null ? estadoP.getSigla().toUpperCase() : "")));
        params.put("enderecoS", (contrato.getEnderecoSocio() != null ? ((contrato.getEnderecoSocio().getEndereco()!=null ? contrato.getEnderecoSocio().getEndereco().toUpperCase():"") + " - " + 
                (contrato.getEnderecoSocio() != null ? (contrato.getEnderecoSocio().getBairro()!=null ?contrato.getEnderecoSocio().getBairro().toUpperCase():"") : "") + " - "
                + (contrato.getEnderecoSocio() != null ? (contrato.getEnderecoSocio().getCep()!=null ? contrato.getEnderecoSocio().getCep().toUpperCase():"") : "") + " - " + (cidadeS != null ? cidadeS.getNome().toUpperCase() : "") + "/" + (estadoS != null ? estadoS.getSigla() : "")) : ""));
        params.put("cabecalho", getCabecalhoNotaPromissoria(loja.getId().toString()));
        params.put("emitente", loja.getRazaosocial().toUpperCase());
        params.put("cnpjEmitente", (format("##.###.###/####-##", loja.getCnpj())));
        params.put("avalista1", contrato.getNomePro().toUpperCase());
        params.put("cpfAvalista1", format("###.###.###-##", contrato.getCpfPro()));
        params.put("avalista2", (contrato.getNomeSocio() != null ? contrato.getNomeSocio().toUpperCase() : ""));
        params.put("cpfAvalista2", (contrato.getCpfSocio() != null ? format("###.###.###-##", contrato.getCpfSocio()) : ""));

        String nomeArquivo = loja.getNome() + " - " + loja.getId();
        FacesJasper.createJasperReport(null, params,
                "/WEB-INF/report/template/Contratos/notaPromissoria.jasper", "Nota Promissoria " + nomeArquivo);

    }

    public void gerarAnexo(Contrato contrato) {
        Loja loja = contratoDAO.getInitialized(contrato.getLoja());
        HashMap params = new HashMap();
        params.put("titulo", getTitleAnexo(loja.getId().toString()));
        params.put("subtitulo", getSubTitleAnexo());
        params.put("texto1", getTexto1Anexo(BigDecimal.ZERO));
        params.put("texto2", getTexto2Anexo(BigDecimal.ZERO));
        params.put("pagContas", getNegrito(getPagContas().getRazaoSocial().toUpperCase()));
        params.put("razaoSocial", getNegrito("Razão Social: ") + (loja.getRazaosocial().toUpperCase()));
        params.put("cnpj", getNegrito("CNPJ: ") + (format("##.###.###/####-##", loja.getCnpj())));
        params.put("nomeMaisProc1e2", getNegrito("Nome: ") + (getPagContas().getNomeProc1() + " e " + getPagContas().getNomeProc2()));
        params.put("cpfProc1", getNegrito("CPF: ") + (format("###.###.###-##", getPagContas().getCpfProc1())));
        params.put("cpfProc2", getNegrito("CPF: ") + (format("###.###.###-##", getPagContas().getCpfProc2())));
        params.put("dataAssinatura", dataPorExtenso("Teresina-PI", contrato.getDataAssinatura()));
        params.put("fiador1", getNegrito("Fiador: ") + contrato.getNomePro());
        params.put("cpfF1", getNegrito("CPF: ") + (format("###.###.###-##", contrato.getCpfPro())));
        params.put("fiador2", getNegrito("Fiador: ") + (contrato.getNomeSocio() != null ? contrato.getNomeSocio() : ""));
        params.put("cpfF2", getNegrito("CPF: ") + (contrato.getCpfSocio() != null ? format("###.###.###-##", contrato.getCpfSocio()) : ""));
        params.put("permissio", getNegrito("PERMISSIONÁRIA:"));
        params.put("fiad", getNegrito("FIADOR (ES):"));
        params.put("testem", getNegrito("TESTEMUNHAS:"));
        params.put("nom", getNegrito("Nome: "));
        params.put("cpf", getNegrito("CPF.: "));

        String nomeArquivo = loja.getNome() + " - " + loja.getId();

        FacesJasper.createJasperReport(null, params,
                "/WEB-INF/report/template/Contratos/anexo.jasper", "Anexo para Contrato " + nomeArquivo);

    }

    private String getTitleAnexo(String postoNumber) {
        return "<style isBold=\"true\" pdfFontName=\"Helvetica-Bold\">CONTRATO PARTICULAR DE PERMISSÃO DE RECEBIMENTOS DE CONTAS MEDIANTE CREDENCIAMENTO POR EMPRESA TERCEIRIZADA E VENDA DE CRÉDITO DIGITAL PARA TELEFONES PRÉ-PAGOS. POS Nº_</style>".concat(getNegrito(postoNumber));
    }

    private String getSubTitleAnexo() {
        return getNegrito("ANEXO");
    }

    private String getTexto1Anexo(BigDecimal valor) {
        return "- Remuneração por guias arrecadada de R$ 0,10 (dez centavos) para recebimento de Contas e,";
    }

    private String getTexto2Anexo(BigDecimal valor) {
        return "- Remuneração variável de 2% (dois por cento) a 4% (quatro por cento) para a venda de créditos digitais, de acordo com a negociação da Operadora.";
    }

    private String getTituloNotaPromissoria() {
        return "<style isBold=\"true\" isUnderline=\"true\" pdfFontName=\"Helvetica-Bold\">NOTA PROMISSÓRIA</style>";
    }

    private String getTexto1Promissoria(BigDecimal valor) {
        return "    Pagaremos por esta única via de Nota Promissória à <style isBold=\"true\" pdfFontName=\"Helvetica-Bold\">PAG CONTAS SERVIÇOS E REPRESENTAÇÃO LTDA</style> – CNPJ (MF) nº. 03.931.852/0001-90, ou à sua ordem, a quantia de R$ VALORPAGO, pagável em moeda corrente somente na Praça de Teresina-PI."
                .replace("VALORPAGO", ((valor!=null ? valor.toString() : "SEM VALOR") + " " + ((valor!=null ? valorPorExtenso(valor.doubleValue()):"SEM VALOR"))));
    }

    private String getCabecalhoNotaPromissoria(String codPost) {
        return "Esta Nota Promissória só poderá ser utilizada conforme as particularidades do contrato acima referido, sob o Nº.: " + codPost;
    }

    private String getTituloContrato() {
        return "<style isBold=\"true\" pdfFontName=\"Helvetica-Bold\">CONTRATO PARTICULAR DE PERMISSÃO DE RECEBIMENTOS DE CONTAS MEDIANTE CREDENCIAMENTO POR EMPRESA TERCEIRIZADA E VENDA DE CRÉDITO DIGITAL PARA TELEFONES PRÉ-PAGOS.</style>";
    }

    private String getText1ContratoPagcontas() {
        return "Pelo presente instrumento particular, <style isBold=\"true\" pdfFontName=\"Helvetica-Bold\">PAG CONTAS SERVIÇOS E REPRESENTAÇÃO LTDA</style>, inscrita no CNPJ sob o nº. 03.931.852/0001-90, "
                + "com sede na Rua José Noélia, nº. 87/A, Bairro: Centro, CEP: 64.110-000 na cidade de José de Freitas/PI, doravante denominada "
                + "<style isBold=\"true\" pdfFontName=\"Helvetica-Bold\">PAG CONTAS</style>, neste ato representada por seus procuradores Sr. Silvio Roberto Costa Leite Filho, brasileiro, casado, "
                + "empresário, RG: 1.672.203  SSP-PI, CPF: 302.713.418-31 e Sr. Delphino Luciani de Paula Araújo, brasileiro, casado, "
                + "analista de sistema, RG: 1.409.312 SSP–PI, CPF: 778.659.793-04, ou seus procuradores, doravante denominada PERMITENTE, "
                + "os signatários deste contrato, celebram com a empresa abaixo qualificada, doravante denominada <style isBold=\"true\" pdfFontName=\"Helvetica-Bold\">PERMISSIONÁRIA</style>, "
                + "e posto <style isBold=\"true\" pdfFontName=\"Helvetica-Bold\">nº.  3900-4</style> contrato particular de credenciamento para recebimento de contas terceirizadas à "
                + "<style isBold=\"true\" pdfFontName=\"Helvetica-Bold\">PAG CONTAS SERVIÇOS E REPRESENTAÇÃO LTDA</style>, venda de crédito digital para telefones celulares pré-pagos, denominados "
                + "‘PINS”, e pagamento de OP’s, nos termos e condições adiante grafados: ";
    }

    private String getText2ContratoPagcontas() {
        return "<style isBold=\"true\" isUnderline=\"true\" pdfFontName=\"Helvetica-Bold\">I. DECLARAÇÕES</style>\n"
                + "<style isBold=\"true\" pdfFontName=\"Helvetica-Bold\">CLÁUSULA 1ª</style>. A <style isBold=\"true\" pdfFontName=\"Helvetica-Bold\">PERMISSIONÁRIA</style> declara sua concordância com a natureza jurídica administrativa deste Contrato, o qual não constitui vínculo empregatício de qualquer espécie e não estabelece subordinação hierárquica.\n"
                + "<style isBold=\"true\" pdfFontName=\"Helvetica-Bold\">CLÁUSULA 2ª</style>. A <style isBold=\"true\" pdfFontName=\"Helvetica-Bold\">PERMISSIONÁRIA</style> ficará como depositária de todos os valores recebidos em nome da <style isBold=\"true\" pdfFontName=\"Helvetica-Bold\">PAG CONTAS SERVIÇOS E REPRESENTAÇÃO LTDA</style> e seus convênios até a efetiva prestação de contas que comprove a sua regular entrega ou depósito em conta bancária por esta autorizada.\n"
                + "Parágrafo Único – A retenção ou omissão quanto ao repasse nos prazos estabelecidos neste instrumento, sem a devida anuência da <style isBold=\"true\" pdfFontName=\"Helvetica-Bold\">PAG CONTAS SERVIÇOS E REPRESENTAÇÃO LTDA</style>, configuram crime de <style isBold=\"true\" pdfFontName=\"Helvetica-Bold\">APROPRIAÇÃO INDÉBITA</style>, de pronto reconhecida pelas partes.  \n"
                + "<style isBold=\"true\" isUnderline=\"true\" pdfFontName=\"Helvetica-Bold\">II. DO OBJETO E DO PRAZO</style>\n"
                + "<style isBold=\"true\" pdfFontName=\"Helvetica-Bold\">CLÁUSULA 3ª</style>. A <style isBold=\"true\" pdfFontName=\"Helvetica-Bold\">PAG CONTAS SERVIÇOS E REPRESENTAÇÃO LTDA</style>, na qualidade de agente arrecadador, por meio deste instrumento, credencia a <style isBold=\"true\" pdfFontName=\"Helvetica-Bold\">PERMISSIONÁRIA</style> a, no seu estabelecimento, promover o recebimento de contas que lhe são terceirizadas, emitidas por empresas conveniadas ou por quaisquer outros credores ou prestadores de serviços, a venda de créditos digital para telefones pré-pagos, o pagamento de Ordens de Pagamento, durante a vigência do presente instrumento.\n"
                + "<style isBold=\"true\" pdfFontName=\"Helvetica-Bold\">Parágrafo Único</style> – Fica facultado a qualquer das partes, promover a extinção contratual, mediante aviso prévio por escrito, no prazo de 30 (trinta) dias. Havendo descumprimento de qualquer uma das cláusulas contratuais, a extinção será de imediato, assegurada a qualquer das partes a indenização neste especificada.\n"
                + "<style isBold=\"true\" pdfFontName=\"Helvetica-Bold\">CLÁUSULA 4ª</style>. Fica facultada à <style isBold=\"true\" pdfFontName=\"Helvetica-Bold\">PAG CONTAS SERVIÇOS E REPRESENTAÇÃO LTDA</style>, a imediata rescisão do presente contrato, caso a permissionária não alcance o mínimo de 500 guias/mês e Créditos Digitais (PINS), após noventa dias de funcionamento. \n"
                + "<style isBold=\"true\" pdfFontName=\"Helvetica-Bold\">CLÁUSULA 5ª</style>. A <style isBold=\"true\" pdfFontName=\"Helvetica-Bold\">PAG CONTAS SERVIÇOS E REPRESENTAÇÃO LTDA</style> poderá promover o imediato bloqueio de permissão de recebimento de contas e conseqüente rescisão contratual, caso a permissionária não efetue os depósitos bancários diários correspondentes à arrecadação de contas e venda dos créditos digitais de celulares no prazo estabelecido para vencimento.\n"
                + "<style isBold=\"true\" isUnderline=\"true\" pdfFontName=\"Helvetica-Bold\">III. DO RECEBIMENTO DE CONTAS E DA VENDA DE CRÉDITOS DIGITAIS PARA TELEFONES PRÉ-PAGOS</style>\n"
                + "<style isBold=\"true\" pdfFontName=\"Helvetica-Bold\">CLÁUSULA 6ª</style>. A <style isBold=\"true\" pdfFontName=\"Helvetica-Bold\">PERMISSIONÁRIA</style> somente pode receber e dar quitação em contas terceirizadas e vender créditos digitais para telefones celulares pré-pagos de acordo com as regras de recebimento ajustadas entre a PAG CONTAS SERVIÇOS E REPRESENTAÇÃO LTDA e as empresas credoras, em moeda corrente deste país e constantes nas cláusulas 7a e 8a deste.\n"
                + "Parágrafo Único: Caso a PERMISSIONÁRIA se recuse a receber qualquer tipo de conta ou pagamento de OP’S, relativo a este contrato, deve fixar avisos de forma clara e totalmente visíveis, comunicando o não recebimento ou pagamento. A não observância deste disposto é de única e inteira responsabilidade da PERMISSIONÁRIA, sendo esta a única responsável por qualquer ação civil ou criminal referente ao ato.\n"
                + "<style isBold=\"true\" isUnderline=\"true\" pdfFontName=\"Helvetica-Bold\">IV. DO RECEBIMENTO E DO DEPÓSITO DA ARRECADAÇÀO ATRAVÉS DE CHEQUE</style>\n"
                + "<style isBold=\"true\" pdfFontName=\"Helvetica-Bold\">CLÁUSULA 7ª</style>. A <style isBold=\"true\" pdfFontName=\"Helvetica-Bold\">PERMISSIONÁRIA</style> não poderá, em nenhuma hipótese, repassar à <style isBold=\"true\" pdfFontName=\"Helvetica-Bold\">PAG CONTAS SERVIÇOS E REPRESENTAÇÃO LTDA</style> arrecadação, total ou parcial, de contas, ou da venda de créditos digitais, através de depósitos de cheques próprios ou de terceiros.\n"
                + "<style isBold=\"true\" pdfFontName=\"Helvetica-Bold\">Parágrafo Único</style>.  A <style isBold=\"true\" pdfFontName=\"Helvetica-Bold\">PERMISSIONÁRIA</style> obriga-se a cobrar os juros e multas de todos os documentos que constem essa informação, ou conceder descontos se for o caso, enfim obedecer a todas as instruções contidas nos documentos calculando o valor correto e, responsabilizando-se por tal ato. \n"
                + "<style isBold=\"true\" isUnderline=\"true\" pdfFontName=\"Helvetica-Bold\">V. DO RECEBIMENTO E DO DEPÓSITO DA ARRECADAÇÀO ATRAVÉS DE CHEQUE</style>\n"
                + "<style isBold=\"true\" pdfFontName=\"Helvetica-Bold\">CLÁUSULA 8ª</style>. A <style isBold=\"true\" pdfFontName=\"Helvetica-Bold\">PERMISSIONÁRIA</style> não poderá, em nenhuma hipótese, repassar à <style isBold=\"true\" pdfFontName=\"Helvetica-Bold\">PAG CONTAS SERVIÇOS E REPRESENTAÇÃO LTDA</style> arrecadação, total ou parcial, de contas, venda de créditos digitais e pagamento das compras de cartão telefônico, através de depósitos de cheques próprios ou de terceiros.\n"
                + "<style isBold=\"true\" pdfFontName=\"Helvetica-Bold\">Parágrafo Único</style>.  A <style isBold=\"true\" pdfFontName=\"Helvetica-Bold\">PERMISSIONÁRIA</style> obriga-se a cobrar os juros e multas, enfim obedecer às instruções contidas nos documentos calculando o valor correto e, responsabilizando-se por tal ato. \n"
                + "<style isBold=\"true\" isUnderline=\"true\" pdfFontName=\"Helvetica-Bold\">VI. DA OPERACIONALIDADE.</style>\n"
                + "<style isBold=\"true\" pdfFontName=\"Helvetica-Bold\">CLÁUSULA 9ª</style>. A <style isBold=\"true\" pdfFontName=\"Helvetica-Bold\">PERMISSIONÁRIA</style> ficará obrigada a cumprir as rotinas operacionais em vigor, bem como, a acatar todas as novas e eventuais orientações operacionais emanadas da <style isBold=\"true\" pdfFontName=\"Helvetica-Bold\">PAG CONTAS SERVIÇOS E REPRESENTAÇÃO LTDA</style>. \n"
                + "<style isBold=\"true\" pdfFontName=\"Helvetica-Bold\">CLÁUSULA 10ª</style>. A <style isBold=\"true\" pdfFontName=\"Helvetica-Bold\">PERMISSIONÁRIA</style> se obriga a efetuar o depósito do produto da arrecadação em conta indicada pela <style isBold=\"true\" pdfFontName=\"Helvetica-Bold\">PAG CONTAS SERVIÇOS E REPRESENTAÇÃO LTDA</style> em duas etapas, sendo a primeira, um depósito parcial, com a arrecadação do dia, <style isBold=\"true\" pdfFontName=\"Helvetica-Bold\">até o fim do expediente bancário</style>, e, a segunda, um depósito complementar, <style isBold=\"true\" pdfFontName=\"Helvetica-Bold\">no dia seguinte ao do recebimento</style>, com o valor total arrecadado após o primeiro depósito.\n"
                + "<style isBold=\"true\" pdfFontName=\"Helvetica-Bold\">CLÁUSULA 11ª</style>. A posse dos valores arrecadados, desde o recebimento até o depósito no Banco, na conta da empresa credora conveniada, é de inteira responsabilidade da <style isBold=\"true\" pdfFontName=\"Helvetica-Bold\">PERMISSIONÁRIA</style>, importando no caso de omissão quanto ao repasse nos prazos estipulados, em crime de <style isBold=\"true\" pdfFontName=\"Helvetica-Bold\">APROPRIAÇÃO INDÉBITA</style>.\n"
                + "<style isBold=\"true\" pdfFontName=\"Helvetica-Bold\">CLÁUSULA 12ª</style>. É de inteira responsabilidade da <style isBold=\"true\" pdfFontName=\"Helvetica-Bold\">PERMISSIONÁRIA</style> qualquer incorreção quanto aos valores recebidos a menor ou indevidamente, como também por eventuais prejuízos, de ordem material ou moral, sofridos pelos usuários em decorrência da má utilização do sistema.\n"
                + "<style isBold=\"true\" pdfFontName=\"Helvetica-Bold\">CLÁUSULA 13ª</style>. É autorizado à <style isBold=\"true\" pdfFontName=\"Helvetica-Bold\">PAG CONTAS SERVIÇOS E REPRESENTAÇÃO LTDA</style> proceder a auditorias, tendo acesso a tudo, fiscalizando a qualquer tempo a execução deste <style isBold=\"true\" isUnderline=\"true\" pdfFontName=\"Helvetica-Bold\">contrato</style>.\n"
                + "<style isBold=\"true\" isUnderline=\"true\" pdfFontName=\"Helvetica-Bold\">VII. DO DEPÓSITO E PENALIDADES.</style>\n"
                + "<style isBold=\"true\" pdfFontName=\"Helvetica-Bold\">CLÁUSULA 14ª</style>. A omissão quanto ao repasse dos valores recebidos em nome da <style isBold=\"true\" pdfFontName=\"Helvetica-Bold\">PAG CONTAS SERVIÇOS E REPRESENTAÇÃO LTDA</style> e de seus convênios, nos termos previstos na <style isBold=\"true\" pdfFontName=\"Helvetica-Bold\">CLÁUSULA 9ª</style>, acarretará aplicação de multa contratual de 2% (dois por cento) sobre valor arrecadado, acrescida de juros de mora de 12% a.a. (doze por cento ao ano) e correção através dos índices dispostos na tabela de atualização monetária do Poder Judiciário do Estado do Piauí, bem como, em caso ser acionado o departamento jurídico para cobrança extrajudicial, honorários advocatícios à base de 10% (dez por cento) do valor do débito.\n"
                + "<style isBold=\"true\" pdfFontName=\"Helvetica-Bold\">CLÁUSULA 15ª</style>. A <style isBold=\"true\" pdfFontName=\"Helvetica-Bold\">PAG CONTAS SERVIÇOS E REPRESENTAÇÃO LTDA</style> fica expressamente autorizada a informar os dados relativos a todas as obrigações perante si assumidas pela <style isBold=\"true\" pdfFontName=\"Helvetica-Bold\">PERMISSIONÁRIA</style>, para constarem de cadastros compartilhados com outras instituições conveniadas para tanto, administradas pelo SPC, SERASA ou por outras entidades de proteção ao crédito.\n"
                + "<style isBold=\"true\" pdfFontName=\"Helvetica-Bold\">CLÁUSULA 16ª</style>. No ato da contratação, a <style isBold=\"true\" pdfFontName=\"Helvetica-Bold\">PERMISSIONÁRIA</style> firmará em conjunto com seus avalistas, em favor da <style isBold=\"true\" pdfFontName=\"Helvetica-Bold\">PAG CONTAS SERVIÇOS E REPRESENTAÇÃO LTDA</style>, a Nota Promissória em apenso, a qual a critério desta última e sem prejuízo às demais espécies de garantia estipuladas neste pacto, em caso de omissão quanto aos repasses dos valores recebidos nos prazos estipulados, ou de repasse a menor, poderá ser executada, até o limite do valor em débito, importe este que, por força do presente instrumento, a <style isBold=\"true\" pdfFontName=\"Helvetica-Bold\">PERMISSIONÁRIA</style> reconhece desde logo, como líquido, certo e exigível.\n"
                + "<style isBold=\"true\" isUnderline=\"true\" pdfFontName=\"Helvetica-Bold\">VIII. DO EQUIPAMENTO</style>\n"
                + "<style isBold=\"true\" pdfFontName=\"Helvetica-Bold\">CLÁUSULA 17ª</style>. A <style isBold=\"true\" pdfFontName=\"Helvetica-Bold\">PAG CONTAS SERVIÇOS E REPRESENTAÇÃO LTDA</style>, na condição de <style isBold=\"true\" pdfFontName=\"Helvetica-Bold\">PERMITENTE</style>, colocam à disposição da <style isBold=\"true\" pdfFontName=\"Helvetica-Bold\">PERMISSIONÁRIA</style> o equipamento de captura de contas, leitor óptico, fonte e cabo, <style isBold=\"true\" isUnderline=\"true\" pdfFontName=\"Helvetica-Bold\">em regime de Comodato; efetuando</style>, neste ato, a entrega do mesmo, que fica sob responsabilidade desta última, na qualidade de depositária, comprometendo‑se a usá‑lo exclusivamente para os fins expressos neste contrato, vedado seu uso fora do recinto para o qual foi autorizado, e em que funciona o estabelecimento ora habilitado.\n"
                + "<style isBold=\"true\" pdfFontName=\"Helvetica-Bold\">CLÁUSULA 18ª</style>. A <style isBold=\"true\" pdfFontName=\"Helvetica-Bold\">PERMISSIONÁRIA</style> assume integral responsabilidade pela guarda do equipamento acima caracterizado antes, durante e após o expediente, e se obriga a conferir diariamente, todos os registros relativos aos recebimentos efetuados, <style isBold=\"true\" pdfFontName=\"Helvetica-Bold\">os quais de pronto reconhecem como corretos</style>, para fins de promoção do depósito dos valores recebidos no dia subseqüente.\n"
                + "<style isBold=\"true\" pdfFontName=\"Helvetica-Bold\">CLÁUSULA 19ª</style>. A <style isBold=\"true\" pdfFontName=\"Helvetica-Bold\">PERMISSIONÁRIA</style> obriga‑se a conservar o equipamento e programa que lhe serão entregues como se de sua propriedade fossem, cabendo-lhe ressarcir a <style isBold=\"true\" pdfFontName=\"Helvetica-Bold\">PAG CONTAS SERVIÇOS E REPRESENTAÇÃO LTDA</style> por quaisquer danos causados em decorrência da sua má utilização. \n"
                + "<style isBold=\"true\" pdfFontName=\"Helvetica-Bold\">CLÁUSULA 20ª</style>. À <style isBold=\"true\" pdfFontName=\"Helvetica-Bold\">PERMISSIONÁRIA</style> é absolutamente vedado abrir, desmontar ou violar o equipamento que lhe é entregue, assim como, alterar seu programa o que vindo a ocorrer, acarretar‑lhe-á as correspondentes sanções civis, e aos responsáveis as sanções penais;\n"
                + "<style isBold=\"true\" pdfFontName=\"Helvetica-Bold\">Parágrafo Único</style>. Na ocorrência de defeitos de funcionamento do equipamento, obriga‑se a <style isBold=\"true\" pdfFontName=\"Helvetica-Bold\">PERMISSIONÁRIA</style> comunicar imediatamente à <style isBold=\"true\" pdfFontName=\"Helvetica-Bold\">PAG CONTAS SERVIÇOS E REPRESENTAÇÃO LTDA</style>, a fim de que esta providencie o conserto ou substituição, que será feito por pessoal técnico especializado.\n"
                + "<style isBold=\"true\" isUnderline=\"true\" pdfFontName=\"Helvetica-Bold\">IX. DO PESSOAL</style>\n"
                + "<style isBold=\"true\" pdfFontName=\"Helvetica-Bold\">CLÁUSULA 21ª</style>. Ficam a cargo da <style isBold=\"true\" pdfFontName=\"Helvetica-Bold\">PERMISSIONÁRIA</style> todas as despesas de remuneração do operador do equipamento e dos serviços de caixa e demais funcionários empregados no sistema no seu estabelecimento, aí compreendidos os salários e todos os encargos trabalhistas e sociais atinentes, inclusive a responsabilidade civil e trabalhista de empregador.\n"
                + "<style isBold=\"true\" isUnderline=\"true\" pdfFontName=\"Helvetica-Bold\">X. DA REMUNERAÇÃO</style>\n"
                + "<style isBold=\"true\" pdfFontName=\"Helvetica-Bold\">CLÁUSULA 22ª</style>. A prestação de serviço feita pela <style isBold=\"true\" pdfFontName=\"Helvetica-Bold\">PERMISSIONÁRIA</style> assegura à mesma uma remuneração por guia arrecadada para recebimento de contas e, uma variável ara a venda de créditos digitais, de acordo com a negociação da Operadora, conforme Anexo a esse contrato.\n"
                + "<style isBold=\"true\" pdfFontName=\"Helvetica-Bold\">CLÁUSULA 23ª</style>. Não havendo qualquer descumprimento das cláusulas inerentes a este contrato, a remuneração será paga 15 dias após o encerramento do mês com crédito em conta corrente indicada pela permissionária, sem prejuízo de observância da cláusula 5a.\n"
                + "<style isBold=\"true\" isUnderline=\"true\" pdfFontName=\"Helvetica-Bold\">XI. DA GUARDA DOS DOCUMENTOS</style>\n"
                + "<style isBold=\"true\" pdfFontName=\"Helvetica-Bold\">CLASULA 24ª</style>. Os documentos recebidos pela <style isBold=\"true\" pdfFontName=\"Helvetica-Bold\">PERMISSIONÁRIA</style> deverão ser, arquivados e acondicionados, sendo o único responsável, na qualidade de fiel depositária, pelo prazo de 180 dias (cento e oitenta dias), tomando providências para que estes documentos mantenham-se seguros e íntegros durante este período.\n"
                + "<style isBold=\"true\" pdfFontName=\"Helvetica-Bold\">Parágrafo Único</style>.  A <style isBold=\"true\" pdfFontName=\"Helvetica-Bold\">PERMISSIONÁRIA</style> após o prazo de 180 dias (cento e oitenta dias), previsto na clausula XI acima, deverá proceder ao expurgo de todos os documentos, utilizando, obrigatoriamente, o método de <style isBold=\"true\" pdfFontName=\"Helvetica-Bold\">FRAGMENTAÇÃO</style>, considerando que estes documentos possuem registros de dados bancários, resguardados pelo sigilo.\n"
                + "<style isBold=\"true\" isUnderline=\"true\" pdfFontName=\"Helvetica-Bold\">XII.  DO MATERIAL DE EXPEDIENTE</style>\n"
                + "<style isBold=\"true\" pdfFontName=\"Helvetica-Bold\">CLÁUSULA 25ª</style>. A aquisição do material de expediente para uso do equipamento é de responsabilidade da <style isBold=\"true\" pdfFontName=\"Helvetica-Bold\">PERMISSIONÁRIA</style>, que arcará com os custos de tal aquisição.\n"
                + "<style isBold=\"true\" isUnderline=\"true\" pdfFontName=\"Helvetica-Bold\">XIII.  DA FIANÇA E GARANTIAS</style>\n"
                + "<style isBold=\"true\" pdfFontName=\"Helvetica-Bold\">CLÁUSULA 26ª</style>. Assinam ainda, como <style isBold=\"true\" pdfFontName=\"Helvetica-Bold\">FIADORES</style>, que se obrigam como devedores solidários e principais pagadores de todas as obrigações deste contrato, as pessoas físicas constantes do quadro inicial deste contrato.\n"
                + "<style isBold=\"true\" pdfFontName=\"Helvetica-Bold\">CLÁUSULA 27ª</style>. Renunciam os <style isBold=\"true\" pdfFontName=\"Helvetica-Bold\">FIADORES</style>, expressamente, ao benefício de ordem a que se refere o Art. 827 do Novo Código Civil, e a pluralidade de <style isBold=\"true\" pdfFontName=\"Helvetica-Bold\">FIADORES</style> importa em solidariedade entre eles. \n"
                + "<style isBold=\"true\" pdfFontName=\"Helvetica-Bold\">CLÁUSULA 28ª</style>. Não configura moratória e, por conseguinte, não desobriga os <style isBold=\"true\" pdfFontName=\"Helvetica-Bold\">FIADORES</style>, a tolerância da <style isBold=\"true\" pdfFontName=\"Helvetica-Bold\">PAG CONTAS SERVIÇOS E REPRESENTAÇÃO LTDA</style>, com relação ao termo estipulado para cumprimento das obrigações da <style isBold=\"true\" pdfFontName=\"Helvetica-Bold\">PERMISSIONÁRIA</style>, nem a prorrogação do vencimento das obrigações.\n"
                + "<style isBold=\"true\" pdfFontName=\"Helvetica-Bold\">CLÁUSULA 29ª</style>. Em caso de requerimento de Recuperação Judicial, Extrajudicial e Falência da <style isBold=\"true\" pdfFontName=\"Helvetica-Bold\">PERMISSIONÁRIA</style> ou de seu responsável não se aplicam às obrigações a serem cumpridas pelos <style isBold=\"true\" pdfFontName=\"Helvetica-Bold\">FIADORES</style>, nem em hipótese alguma, as dilações, proporções, rateios ou quaisquer outras condições decorrentes do procedimento de recuperação judicial ou falimentar, em estrita obediência ao que preceitua a Lei nº. 11.101, de 09/02/2005.\n"
                + "<style isBold=\"true\" pdfFontName=\"Helvetica-Bold\">CLÁUSULA 30ª</style>. A presente fiança é outorgada por prazo indeterminado, ultimando-se quando satisfeitos os pagamentos de todas as obrigações deste contrato.\n"
                + "<style isBold=\"true\" pdfFontName=\"Helvetica-Bold\">CLÁUSULA 31ª</style>. Na hipótese de inadimplemento das obrigações em suas datas e termos, fica estipulada a multa de dez por cento (10%) sobre o total vencido e não pago além das despesas para a recepção do crédito, inclusive os honorários advocatícios.\n"
                + "<style isBold=\"true\" pdfFontName=\"Helvetica-Bold\">CLÁUSULA 32ª</style>. A falta de exercício de ação da <style isBold=\"true\" pdfFontName=\"Helvetica-Bold\">PAG CONTAS SERVIÇOS E REPRESENTAÇÃO LTDA</style> contra a <style isBold=\"true\" pdfFontName=\"Helvetica-Bold\">PERMISSIONÁRIA</style> não implica em causa de exoneração dos <style isBold=\"true\" pdfFontName=\"Helvetica-Bold\">FIADORES</style>, renunciando estes, ainda expressamente, à hipótese de exoneração prevista nos artigos 838 e seguinte do Novo Código Civil.\n"
                + "<style isBold=\"true\" pdfFontName=\"Helvetica-Bold\">CLÁUSULA 33ª</style>. Comprometem-se os <style isBold=\"true\" pdfFontName=\"Helvetica-Bold\">FIADORES</style> a satisfazerem imediatamente as obrigações assumidas e não cumpridas pela <style isBold=\"true\" pdfFontName=\"Helvetica-Bold\">PERMISSIONÁRIA</style> até a data do vencimento, notadamente, mediante a simples apresentação da conta, independentemente de protesto.\n"
                + "<style isBold=\"true\" pdfFontName=\"Helvetica-Bold\">CLÁUSULA 34ª</style>. Ficará a critério de a <style isBold=\"true\" pdfFontName=\"Helvetica-Bold\">PAG CONTAS SERVIÇOS E REPRESENTAÇÃO LTDA</style> acatar outras garantias oferecidas pela Permissionária.\n"
                + "<style isBold=\"true\" pdfFontName=\"Helvetica-Bold\">CLÁUSULA 35ª</style>. A garantia será executada imediatamente após a <style isBold=\"true\" pdfFontName=\"Helvetica-Bold\">PAG CONTAS SERVIÇOS E REPRESENTAÇÃO LTDA</style> tomar ciência da ocorrência, procedimento este com o qual a Permissionária concorda integralmente.\n"
                + "<style isBold=\"true\" pdfFontName=\"Helvetica-Bold\">CLÁUSULA 36ª</style>. Na hipótese de quitação de valores em débito para com a <style isBold=\"true\" pdfFontName=\"Helvetica-Bold\">PAG CONTAS SERVIÇOS E REPRESENTAÇÃO LTDA</style> esta repassará a Permissionária a importância devida por força do presente contrato. \n"
                + "<style isBold=\"true\" isUnderline=\"true\" pdfFontName=\"Helvetica-Bold\">XIV. DO SIGILO CONTRATUAL E DA QUARENTENA</style>\n"
                + "<style isBold=\"true\" pdfFontName=\"Helvetica-Bold\">CLÁUSULA 37ª</style>. Tendo o presente contrato como objeto o recebimento de contas e venda de créditos digitais, e por conseqüência a troca de informações e tecnologia, <style isBold=\"true\" isUnderline=\"true\" pdfFontName=\"Helvetica-Bold\">a PERMISSIONÁRIA se obriga a manter sob sigilo todas e quaisquer informações decorrentes deste</style>, inclusive sobre o funcionamento dos equipamentos da <style isBold=\"true\" pdfFontName=\"Helvetica-Bold\">PAG CONTAS SERVIÇOS E REPRESENTAÇÃO LTDA</style>, forma de execução do contrato, transferência de dados, informações das transações efetuadas e quaisquer outras informações que importem em quebra e/ou transferência de tecnologia, bem como, afetem a integridade e sigilo pessoal dos usuários deste sistema.\n"
                + "<style isBold=\"true\" pdfFontName=\"Helvetica-Bold\">CLÁUSULA 38ª</style>. Em decorrência do sigilo exigido na <style isBold=\"true\" pdfFontName=\"Helvetica-Bold\">CLÁUSULA 36ª</style>, a Permissionária, em caso de rescisão desse contrato, com conseqüentemente extinção de seus efeitos diretos, estará obrigada pelo prazo de 01(um) ano (da data de rescisão contratual) a eximir-se de manter quaisquer relações jurídicas com quaisquer firmas e/ou pessoas físicas que explorem o mesmo ramo de atividades da PAG CONTAS SERVIÇOS E REPRESENTAÇÃO LTDA.\n"
                + "<style isBold=\"true\" pdfFontName=\"Helvetica-Bold\">CLÁUSULA 39ª</style>. Em síntese, a <style isBold=\"true\" pdfFontName=\"Helvetica-Bold\">PERMISSIONÁRIA</style> não poderá, até 01 (um) ano após a rescisão do presente contrato, ser permissionária ou prestadora de serviços de qualquer outra firma que tenha por objeto e finalidade os serviços realizados pela <style isBold=\"true\" pdfFontName=\"Helvetica-Bold\">PAG CONTAS SERVIÇOS E REPRESENTAÇÃO LTDA</style>.\n"
                + "<style isBold=\"true\" isUnderline=\"true\" pdfFontName=\"Helvetica-Bold\">XV. DA MULTA POR DESRESPEITO À QUARENTENA</style>\n"
                + "<style isBold=\"true\" pdfFontName=\"Helvetica-Bold\">CLÁUSULA 40ª</style>. Ocorrendo quebra do compromisso estipulado nas cláusulas dos itens XI e XIV, acima, <style isBold=\"true\" pdfFontName=\"Helvetica-Bold\">PAG CONTAS SERVIÇOS E REPRESENTAÇÃO LTDA</style> terá o direito de exigir, judicial ou extrajudicialmente, multa por quebra de contrato da Permissionária. A presente multa será calculada com base na média dos últimos três meses de remuneração da Permissionária multiplicada pelo valor 10, conforme a fórmula: (Média dos 03 últimos meses de remuneração da Permissionária) X 10 = Multa.\n"
                + "<style isBold=\"true\" isUnderline=\"true\" pdfFontName=\"Helvetica-Bold\">XVI. DA RESCISÃO CONTRATUAL</style>\n"
                + "<style isBold=\"true\" pdfFontName=\"Helvetica-Bold\">CLÁUSULA 41ª</style>. Constituirá motivo para a rescisão deste contrato:\n"
                + "I) requerimento ou homologação de falência, concordata, dissolução, liquidação judicial ou extrajudicial das partes contratantes; \n"
                + "II) descumprimento, pelos contratantes de qualquer cláusula deste contrato;\n"
                + "III) ausência de recolhimento de qualquer tributos ou encargo sociais relacionados com o fornecimento dos serviços, por parte da Permissionária;\n"
                + "IV) quebra de sigilo por parte da Permissionária, ficando claro que estão englobados seus sócios e prepostos.\n"
                + "<style isBold=\"true\" pdfFontName=\"Helvetica-Bold\">CLÁUSULA 42ª</style>. Á Permissionária, como posto acima, também é concedido o direito de rescindir o presente instrumento na hipótese de descumprimento, pela <style isBold=\"true\" pdfFontName=\"Helvetica-Bold\">PAG CONTAS SERVIÇOS E REPRESENTAÇÃO LTDA de suas obrigações</style>.\n"
                + "<style isBold=\"true\" pdfFontName=\"Helvetica-Bold\">CLAUSULA 43ª</style>. No caso da rescisão do Contrato, os equipamentos indicados na <style isBold=\"true\" pdfFontName=\"Helvetica-Bold\">CLÁUSULA 17ª</style> deste, fornecidos em regime de comodato, deverão ser devolvidos sem ônus a qualquer das partes.\n"
                + "<style isBold=\"true\" isUnderline=\"true\" pdfFontName=\"Helvetica-Bold\">XVII. DA VIGÊNCIA DO CONTRATO</style>\n"
                + "<style isBold=\"true\" pdfFontName=\"Helvetica-Bold\">CLÁUSULA 44ª</style>. A vigência do presente contrato será de 12 (doze) meses, e a renovação do presente contrato ocorrerá automaticamente por mais 04 (quatro) sucessivos iguais períodos ao mencionado nesta cláusula, sem necessidade de aditivos específicos para essas finalidades, caso não haja manifestação em contrário de quaisquer das partes, com prova de recebimento por uma das partes, até 30 (trinta) dias antes do término do período.\n"
                + "<style isBold=\"true\" pdfFontName=\"Helvetica-Bold\">CLÁUSULA 45ª</style>. A partir da presente data ficam rescindidas todas as disposições contratuais anteriormente firmadas entre as partes.\n"
                + "<style isBold=\"true\" pdfFontName=\"Helvetica-Bold\">CLÁUSULA 46</style>ª. Para qualquer ação ou litígio decorrente deste contrato, fica eleito o Foro desta Comarca de Teresina, Capital do Estado do Piauí, que prefere a qualquer outro, por mais privilegiado que seja.  \n"
                + "\n"
                + "E, por estarem assim, justos e contratados, a tudo tendo lido e achado a fiel expressão do que celebram, assinam o presente contrato em duas vias, de um só teor e para um mesmo fim, na presença de duas testemunhas.";
    }

    private PagContas getPagContas() {
        return pagcontasBO.getDAO().find(1L);
    }

    //Retorna o nome completo do mes (exe Janeiro) ou os tres primeiros digito do mes (exe Jan)
    private String nomeDoMes(int i, int tipo) {
        String mes[] = {"Janeiro", "Fevereiro", "Março", "Abril",
            "Maio", "Junho", "Julho", "Agosto", "Setembro", "Outubro",
            "Novembro", "Dezembro"};
        // Java é uma linguagem com vetores zero-based: as posições do vetor
        // iniciam a numeração a partir do valor 0 (0-janeiro, 1-fevereiro, ...)
        if (tipo == 0) {
            return (mes[i - 1]); // extenso
        }// o método "substring" retorna os 3 primeiros caracteres de "mes[i-1]"
        else {
            return (mes[i - 1].substring(0, 3)); // abreviado
        }
    }

// Retorna o dia da semana.
// Parâmetros: "i" = índice para o vetor "diasem"
//             "tipo" = 0 para retornar o nome completo e
//                      1 para o nome abreviado do dia da semana.
    private String diaDaSemana(int i, int tipo) {
        String diasem[] = {"domingo", "segunda-feira", "terça-feira",
            "quarta-feira", "quinta-feira", "sexta-feira", "sábado"};
        if (tipo == 0) {
            return (diasem[i - 1]); // extenso
        }// o método "substring" retorna os 3 primeiros caracteres de "diasem[i]"
        else {
            return (diasem[i - 1].substring(0, 3));
        }
    }

    // Retorna a data por extenso.
    // Parâmetros: "cidade" = nome da cidade; e, "dt" = data.
    private String dataPorExtenso(String cidade, Date dt) {
        // retorna os valores ano, mês e dia da variável "dt"

        if (dt == null) {
            return cidade + "__/____/______";
        }

        Calendar c = Calendar.getInstance();
        c.setTime(dt);
        int d = c.get(Calendar.DAY_OF_MONTH);
        int m = c.get(Calendar.MONTH) + 1;
        int a = c.get(Calendar.YEAR);

        // retorna o dia da semana: 1=domingo, 2=segunda-feira, ..., 7=sábado
        //Calendar data = new GregorianCalendar(a, m - 1, d);
        //int ds = data.get(Calendar.DAY_OF_WEEK);
        return (cidade + ", " + d + " de " + nomeDoMes(m, 0) + " de " + a);
    }

    //Retorna uma data em string exemplo 07/08/1984 ou 1984/08/07 ou 13:30:22
    private String convertDateToString(Date date, int tipo) {
        SimpleDateFormat formataData = null;
        if (tipo == 1) {
            formataData = new SimpleDateFormat("dd/MM/yyyy");
        }

        if (tipo == 2) {
            formataData = new SimpleDateFormat("yyyy-MM-dd");
        }

        if (tipo == 3) {
            formataData = new SimpleDateFormat("HH:mm");
        }

        String data = formataData.format(date);

        return data;
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

    public static String valorPorExtenso(double vlr) {
        if (vlr == 0) {
            return ("zero");
        }

        long inteiro = (long) Math.abs(vlr); // parte inteira do valor
        double resto = vlr - inteiro;       // parte fracionária do valor

        String vlrS = String.valueOf(inteiro);
        if (vlrS.length() > 15) {
            return ("Erro: valor superior a 999 trilhões.");
        }

        String s = "", saux, vlrP;
        String centavos = String.valueOf((int) Math.round(resto * 100));

        String[] unidade = {"", "um", "dois", "três", "quatro", "cinco",
            "seis", "sete", "oito", "nove", "dez", "onze",
            "doze", "treze", "quatorze", "quinze", "dezesseis",
            "dezessete", "dezoito", "dezenove"};
        String[] centena = {"", "cento", "duzentos", "trezentos",
            "quatrocentos", "quinhentos", "seiscentos",
            "setecentos", "oitocentos", "novecentos"};
        String[] dezena = {"", "", "vinte", "trinta", "quarenta", "cinquenta",
            "sessenta", "setenta", "oitenta", "noventa"};
        String[] qualificaS = {"", "mil", "milhão", "bilhão", "trilhão"};
        String[] qualificaP = {"", "mil", "milhões", "bilhões", "trilhões"};

// definindo o extenso da parte inteira do valor
        int n, unid, dez, cent, tam, i = 0;
        boolean umReal = false, tem = false;
        while (!vlrS.equals("0")) {
            tam = vlrS.length();
// retira do valor a 1a. parte, 2a. parte, por exemplo, para 123456789:
// 1a. parte = 789 (centena)
// 2a. parte = 456 (mil)
// 3a. parte = 123 (milhões)
            if (tam > 3) {
                vlrP = vlrS.substring(tam - 3, tam);
                vlrS = vlrS.substring(0, tam - 3);
            } else { // última parte do valor
                vlrP = vlrS;
                vlrS = "0";
            }
            if (!vlrP.equals("000")) {
                saux = "";
                if (vlrP.equals("100")) {
                    saux = "cem";
                } else {
                    n = Integer.parseInt(vlrP, 10);  // para n = 371, tem-se:
                    cent = n / 100;                  // cent = 3 (centena trezentos)
                    dez = (n % 100) / 10;            // dez  = 7 (dezena setenta)
                    unid = (n % 100) % 10;           // unid = 1 (unidade um)
                    if (cent != 0) {
                        saux = centena[cent];
                    }
                    if ((n % 100) <= 19) {
                        if (saux.length() != 0) {
                            saux = saux + " e " + unidade[n % 100];
                        } else {
                            saux = unidade[n % 100];
                        }
                    } else {
                        if (saux.length() != 0) {
                            saux = saux + " e " + dezena[dez];
                        } else {
                            saux = dezena[dez];
                        }
                        if (unid != 0) {
                            if (saux.length() != 0) {
                                saux = saux + " e " + unidade[unid];
                            } else {
                                saux = unidade[unid];
                            }
                        }
                    }
                }
                if (vlrP.equals("1") || vlrP.equals("001")) {
                    if (i == 0) // 1a. parte do valor (um real)
                    {
                        umReal = true;
                    } else {
                        saux = saux + " " + qualificaS[i];
                    }
                } else if (i != 0) {
                    saux = saux + " " + qualificaP[i];
                }
                if (s.length() != 0) {
                    s = saux + ", " + s;
                } else {
                    s = saux;
                }
            }
            if (((i == 0) || (i == 1)) && s.length() != 0) {
                tem = true; // tem centena ou mil no valor
            }
            i = i + 1; // próximo qualificador: 1- mil, 2- milhão, 3- bilhão, ...
        }

        if (s.length() != 0) {
            if (umReal) {
                s = s + " real";
            } else if (tem) {
                s = s + " reais";
            } else {
                s = s + " de reais";
            }
        }

// definindo o extenso dos centavos do valor
        if (!centavos.equals("0")) { // valor com centavos
            if (s.length() != 0) // se não é valor somente com centavos
            {
                s = s + " e ";
            }
            if (centavos.equals("1")) {
                s = s + "um centavo";
            } else {
                n = Integer.parseInt(centavos, 10);
                if (n <= 19) {
                    s = s + unidade[n];
                } else {             // para n = 37, tem-se:
                    unid = n % 10;   // unid = 37 % 10 = 7 (unidade sete)
                    dez = n / 10;    // dez  = 37 / 10 = 3 (dezena trinta)
                    s = s + dezena[dez];
                    if (unid != 0) {
                        s = s + " e " + unidade[unid];
                    }
                }
                s = s + " centavos";
            }
        }
        return ("(" + s + ")");
    }

    private String getNegrito(String nome) {
        return "<style isBold=\"true\" pdfFontName=\"Helvetica-Bold\">" + nome + "</style>";
    }

}
