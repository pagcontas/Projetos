package br.com.jsoft.centralfinanceira.bo.central;

import br.com.jsoft.centralfinanceira.ClassesComparator.CidadeComparadaPorNome;
import com.xpert.core.crud.AbstractBusinessObject;
import br.com.jsoft.centralfinanceira.dao.central.FatosBoletosDAO;
import br.com.jsoft.centralfinanceira.modelo.central.Cidade;
import br.com.jsoft.centralfinanceira.modelo.central.FatosBoletos;
import br.com.jsoft.centralfinanceira.modelo.central.Loja;
import br.com.jsoft.centralfinanceira.modelo.enums.TipoBoletos;
import br.com.jsoft.centralfinanceira.vo.ComissaoConvenioVO;
import br.com.jsoft.centralfinanceira.vo.ComissaoLojaVO;
import br.com.jsoft.centralfinanceira.vo.ConsultaFatosVO;
import br.com.jsoft.centralfinanceira.vo.ConvenioCampConsultVO;
import br.com.jsoft.centralfinanceira.vo.GraficoHistoricoArrecadacaoVO;
import br.com.jsoft.centralfinanceira.vo.ReceitaEDespesaVO;
import br.com.jsoft.centralfinanceira.vo.RelatorioRemunecaoVO;
import br.com.jsoft.centralfinanceira.vo.RentabilidadeVO;
import static com.xpert.Configuration.getEntityManager;
import com.xpert.core.validation.UniqueField;
import com.xpert.core.exception.BusinessException;
import java.util.List;
import javax.ejb.EJB;
import javax.ejb.Stateless;
import com.xpert.faces.utils.FacesJasper;
import com.xpert.persistence.query.QueryBuilder;
import com.xpert.persistence.query.Restrictions;
import java.math.BigDecimal;
import java.math.BigInteger;
import java.text.SimpleDateFormat;
import java.util.ArrayList;
import java.util.Collections;
import java.util.Date;
import java.util.GregorianCalendar;
import java.util.HashMap;
import javax.faces.context.FacesContext;
import javax.persistence.Query;

/**
 *
 * @author Juniel
 */
@Stateless
public class FatosBoletosBO extends AbstractBusinessObject<FatosBoletos> {

    @EJB
    private FatosBoletosDAO fatosBoletosDAO;

    @Override
    public FatosBoletosDAO getDAO() {
        return fatosBoletosDAO;
    }

    @Override
    public List<UniqueField> getUniqueFields() {

        return null;
    }

    @Override
    public void validate(FatosBoletos fatosBoletos) throws BusinessException {
    }

    @Override
    public boolean isAudit() {
        return true;
    }

    /**
     *
     * @author Juniel
     * @param fatos
     * @see Metodo usado para gerar relatorio Caused by:
     * java.lang.OutOfMemoryError: GC overhead limit exceeded
     */
    public void gerarReport(List<RelatorioRemunecaoVO> fatos) {
        SimpleDateFormat dt = new SimpleDateFormat("dd/MM/yyyy HH:mm:ss");
        String caminho;
        caminho = FacesContext.getCurrentInstance().getExternalContext().getRealPath("/images/pag_contas.jpg");
        HashMap params = new HashMap();
        params.put("dataAtual", dt.format(new Date()));
        params.put("caminhoImagem", caminho);
        FacesJasper.createJasperReport(fatos, params,
                "/WEB-INF/report/template/FatosBoletos/relatorioRemuneracao.jasper", "Relatorio_de_Remuneração");

    }

    public List<RelatorioRemunecaoVO> consultaLoja(ConsultaFatosVO consultaFatosVO) {

        Restrictions restrictions = new Restrictions();

        if (consultaFatosVO.getLoja() != null) {
            restrictions.equals("fb.loja", consultaFatosVO.getLoja());
        }
        if (consultaFatosVO.getConvenio() != null) {
            restrictions.equals("fb.convenioboleto", consultaFatosVO.getConvenio());
        }

        if (!"".equals(consultaFatosVO.getPeriodoInicial()) && "".equals(consultaFatosVO.getPeriodoFinal())) {
            restrictions.greaterEqualsThan("fb.periodo", convertPeriodoInteger(consultaFatosVO.getPeriodoInicial()));
        }

        if ("".equals(consultaFatosVO.getPeriodoInicial()) && !"".equals(consultaFatosVO.getPeriodoFinal())) {
            restrictions.lessEqualsThan("fb.periodo", convertPeriodoInteger(consultaFatosVO.getPeriodoInicial()));
        }

        if (!"".equals(consultaFatosVO.getPeriodoInicial()) && !"".equals(consultaFatosVO.getPeriodoFinal())) {
            restrictions.greaterEqualsThan("fb.periodo", convertPeriodoInteger(consultaFatosVO.getPeriodoInicial()));
            restrictions.lessEqualsThan("fb.periodo", convertPeriodoInteger(consultaFatosVO.getPeriodoFinal()));
        }

        List<RelatorioRemunecaoVO> relatorioRemunecao = new ArrayList<RelatorioRemunecaoVO>();

        List<FatosBoletos> fatosBoletos;

        fatosBoletos = fatosBoletosDAO.getQueryBuilder()
                .from(FatosBoletos.class, "fb")
                .add(restrictions).orderBy("fb.loja.id, fb.convenioboleto.id, fb.periodo ASC")
                .getResultList();

        for (FatosBoletos fato : fatosBoletos) {
            relatorioRemunecao.add(new RelatorioRemunecaoVO(fato));
        }

        return relatorioRemunecao;
    }

    public void updateUniConvenio(ComissaoConvenioVO comissaoConvenio) {
        fatosBoletosDAO.updateUnitarioConvenio(comissaoConvenio.getId(), comissaoConvenio.getUnitarioconvenio(), comissaoConvenio.getPeriodo());
    }

    public void updateUniLoja(ComissaoLojaVO comissaoLoja) {
        fatosBoletosDAO.updateUnitarioLoja(comissaoLoja.getId(), comissaoLoja.getUnitarioloja(), comissaoLoja.getPeriodo());
    }

    public List<RentabilidadeVO> listRentabilidade(Long loja, Date dataInicial, Date dataFinal, int boleto) {

        List<RentabilidadeVO> rentabilidades = new ArrayList<RentabilidadeVO>();
        String queryString = "";

        if (loja != null && dataInicial != null && dataFinal != null) {
            queryString = retornaQueryRentLoja(boleto).replaceAll("DATAINICIAL", convertPeriodo(dataInicial).toString())
                    .replaceAll("DATAFINAL", convertPeriodo(dataFinal).toString()) + " AND loja_id=LOJAIDQUERY "
                    .replaceAll("LOJAIDQUERY", loja.toString()) + getAfterWhere(boleto);

        }

        if (loja != null && dataInicial != null && dataFinal == null) {
            queryString = retornaQueryRentLoja(boleto).replaceAll("DATAINICIAL", convertPeriodo(dataInicial).toString())
                    .replaceAll("DATAFINAL", convertPeriodo(new Date()).toString()) + " AND loja_id=LOJAIDQUERY "
                    .replaceAll("LOJAIDQUERY", loja.toString()) + getAfterWhere(boleto);
        }

        if (loja != null && dataInicial == null && dataFinal != null) {
            queryString = retornaQueryRentLoja(boleto).replaceAll("DATAINICIAL", "199001")
                    .replaceAll("DATAFINAL", convertPeriodo(dataFinal).toString()) + " AND loja_id=LOJAIDQUERY "
                    .replaceAll("LOJAIDQUERY", loja.toString()) + getAfterWhere(boleto);
        }

        if (loja != null && dataInicial == null && dataFinal == null) {
            queryString = retornaQueryRentLoja(boleto).replaceAll("DATAINICIAL", "199001")
                    .replaceAll("DATAFINAL", convertPeriodo(new Date()).toString()) + " AND loja_id=LOJAIDQUERY "
                    .replaceAll("LOJAIDQUERY", loja.toString()) + getAfterWhere(boleto);
        }

        if (loja == null && dataInicial != null && dataFinal != null) {
            queryString = retornaQueryRentLoja(boleto)
                    .replaceAll("DATAINICIAL", convertPeriodo(dataInicial).toString())
                    .replaceAll("DATAFINAL", convertPeriodo(dataFinal).toString()) + getAfterWhere(boleto);
        }

        if (loja == null && dataInicial != null && dataFinal == null) {
            queryString = retornaQueryRentLoja(boleto)
                    .replaceAll("DATAINICIAL", convertPeriodo(dataInicial).toString())
                    .replaceAll("DATAFINAL", convertPeriodo(new Date()).toString()) + getAfterWhere(boleto);
        }

        if (loja == null && dataInicial == null && dataFinal != null) {
            queryString = retornaQueryRentLoja(boleto)
                    .replaceAll("DATAINICIAL", "199001")
                    .replaceAll("DATAFINAL", convertPeriodo(dataFinal).toString()) + getAfterWhere(boleto);
        }

        if (loja == null && dataInicial == null && dataFinal == null) {
            queryString = retornaQueryRentLoja(boleto).replaceAll("DATAINICIAL", "199001")
                    .replaceAll("DATAFINAL", convertPeriodo(new Date()).toString()) + getAfterWhere(boleto);
        }

        Query query;

        query = getEntityManager().createNativeQuery(queryString);

        List<Object[]> resultado = query.getResultList();

        for (Object[] tupla : resultado) {

            RentabilidadeVO rentabilidade = new RentabilidadeVO();
            if (tupla[0] != null) {
                rentabilidade.setConvenio(((BigInteger) tupla[0]).longValue());
            } else {
                rentabilidade.setConvenio(Long.valueOf(0));
            }

            if (tupla[1] != null) {
                rentabilidade.setEmpresa((String) tupla[1]);
            } else {
                rentabilidade.setEmpresa("");
            }

            if (tupla[2] != null) {
                rentabilidade.setGuias(((Number) tupla[2]).intValue());
            } else {
                rentabilidade.setGuias(Integer.valueOf(0));
            }

            if (tupla[3] != null) {
                rentabilidade.setValor((BigDecimal) tupla[3]);
            } else {
                rentabilidade.setValor(BigDecimal.ZERO);
            }

            if (tupla[4] != null) {
                rentabilidade.setTarifaConvenio((BigDecimal) tupla[4]);
            } else {
                rentabilidade.setTarifaConvenio(BigDecimal.ZERO);
            }

            if (tupla[5] != null) {
                rentabilidade.setComissaoConvenio((BigDecimal) tupla[5]);
            } else {
                rentabilidade.setComissaoConvenio(BigDecimal.ZERO);
            }

            if (tupla[6] != null) {
                rentabilidade.setTarifaLoja((BigDecimal) tupla[6]);
            } else {
                rentabilidade.setTarifaLoja(BigDecimal.ZERO);
            }

            if (tupla[7] != null) {
                rentabilidade.setComissaoLoja((BigDecimal) tupla[7]);
            } else {
                rentabilidade.setComissaoLoja(BigDecimal.ZERO);
            }

            if (tupla[8] != null) {
                rentabilidade.setComissaoW7((BigDecimal) tupla[8]);
            } else {
                rentabilidade.setComissaoW7(BigDecimal.ZERO);
            }

            if (tupla[9] != null) {
                rentabilidade.setComissao((BigDecimal) tupla[9]);
            } else {
                rentabilidade.setComissao(BigDecimal.ZERO);
            }

            if (tupla[10] != null) {
                rentabilidade.setImposto((BigDecimal) tupla[10]);
            } else {
                rentabilidade.setImposto(BigDecimal.ZERO);
            }

            if (tupla[11] != null) {
                rentabilidade.setLiquido((BigDecimal) tupla[11]);
            } else {
                rentabilidade.setLiquido(BigDecimal.ZERO);
            }

            rentabilidades.add(rentabilidade);
        }

        return rentabilidades;
    }

    public List<ReceitaEDespesaVO> listRentablidadeRecDesp(Long loja, Date dataInicial, Date dataFinal) {
        List<ReceitaEDespesaVO> receitaEDespesaVO = new ArrayList<ReceitaEDespesaVO>();
        String queryString = "select * from (select t.id, t.nome descricao, -sum(total) as valor "
                + "from financeira.despesaloja d "
                + "inner join cadastro.tipodespesa t on (t.id=d.tipodespesa_id) ";
        String queryString2 = "group by t.id, nome "
                + "union all "
                + "select t.id, t.nome, sum(total) "
                + "from financeira.receitaloja r "
                + "inner join cadastro.tiporeceita t on (t.id=r.tiporeceita_id) ";
        String queryWhereComID = "where loja_id=LOJAIDQUERY and periodo between DATAINICIAL and DATAFINAL ";
        String queryWhereSemID = "where periodo between DATAINICIAL and DATAFINAL ";

        if (loja != null && dataInicial != null && dataFinal != null) {
            queryString = queryString + queryWhereComID + queryString2 + queryWhereComID;
            queryString = queryString.replaceAll("DATAINICIAL", convertPeriodo(dataInicial).toString())
                    .replaceAll("DATAFINAL", convertPeriodo(dataFinal).toString())
                    .replaceAll("LOJAIDQUERY", loja.toString());

        }

        if (loja != null && dataInicial != null && dataFinal == null) {
            queryString = queryString + queryWhereComID + queryString2 + queryWhereComID;
            queryString = queryString.replaceAll("DATAINICIAL", convertPeriodo(dataInicial).toString())
                    .replaceAll("DATAFINAL", convertPeriodo(new Date()).toString())
                    .replaceAll("LOJAIDQUERY", loja.toString());
        }

        if (loja != null && dataInicial == null && dataFinal != null) {
            queryString = queryString + queryWhereComID + queryString2 + queryWhereComID;
            queryString = queryString.replaceAll("DATAINICIAL", "199001")
                    .replaceAll("DATAFINAL", convertPeriodo(dataFinal).toString())
                    .replaceAll("LOJAIDQUERY", loja.toString());
        }

        if (loja != null && dataInicial == null && dataFinal == null) {
            queryString = queryString + queryWhereComID + queryString2 + queryWhereComID;
            queryString = queryString.replaceAll("DATAINICIAL", "199001")
                    .replaceAll("DATAFINAL", convertPeriodo(new Date()).toString())
                    .replaceAll("LOJAIDQUERY", loja.toString());
        }

        if (loja == null && dataInicial != null && dataFinal != null) {
            queryString = queryString + queryWhereSemID + queryString2 + queryWhereSemID;
            queryString = queryString
                    .replaceAll("DATAINICIAL", convertPeriodo(dataInicial).toString())
                    .replaceAll("DATAFINAL", convertPeriodo(dataFinal).toString());
        }

        if (loja == null && dataInicial != null && dataFinal == null) {
            queryString = queryString + queryWhereSemID + queryString2 + queryWhereSemID;
            queryString = queryString
                    .replaceAll("DATAINICIAL", convertPeriodo(dataInicial).toString())
                    .replaceAll("DATAFINAL", convertPeriodo(new Date()).toString());
        }

        if (loja == null && dataInicial == null && dataFinal != null) {
            queryString = queryString + queryWhereSemID + queryString2 + queryWhereSemID;
            queryString = queryString
                    .replaceAll("DATAINICIAL", "199001")
                    .replaceAll("DATAFINAL", convertPeriodo(dataFinal).toString());
        }

        if (loja == null && dataInicial == null && dataFinal == null) {
            queryString = queryString + queryWhereSemID + queryString2 + queryWhereSemID;
            queryString = queryString.replaceAll("DATAINICIAL", "199001")
                    .replaceAll("DATAFINAL", convertPeriodo(new Date()).toString());
        }

        queryString = queryString + "group by t.id, nome) n order by descricao;";

        Query query;

        query = getEntityManager().createNativeQuery(queryString);

        List<Object[]> resultado = query.getResultList();

        for (Object[] tupla : resultado) {

            ReceitaEDespesaVO receitaDespesaVO = new ReceitaEDespesaVO();
            if (tupla[0] != null) {
                receitaDespesaVO.setCodigo(((BigInteger) tupla[0]).longValue());
            } else {
                receitaDespesaVO.setCodigo(Long.valueOf(0));
            }

            if (tupla[1] != null) {
                receitaDespesaVO.setDescricao((String) tupla[1]);
            } else {
                receitaDespesaVO.setDescricao("");
            }

            if (tupla[2] != null) {
                receitaDespesaVO.setValor((BigDecimal) tupla[2]);
            } else {
                receitaDespesaVO.setValor(BigDecimal.ZERO);
            }

            receitaEDespesaVO.add(receitaDespesaVO);
        }

        return receitaEDespesaVO;
    }

    private Integer convertPeriodo(Date data) {
        SimpleDateFormat formatador = new SimpleDateFormat("yyyyMM");

        return Integer.parseInt(formatador.format(data));
    }

    /*
     método de retorno de querys. Abaixo os equivalentes
     boletos; => 1
     boletosSite; => 2
     boletosCreditos; => 3
     boletosRecargas; => 4
     boletosValeGas; => 5
     boletosOps; => 6
     boletosBB; =>7
     boletosBP; =>8
     */
    private String retornaQueryRentLoja(int tipo) {
        String query = "";
        switch (tipo) {
            case 1:
                query = "select convenioboleto_id as convenio, nome empresa, sum(COALESCE(qtd,0.0)) as guias, sum(COALESCE(arrecadado,0.0)) as valor"
                        + ",avg(COALESCE(unitarioconvenio,0.0)) as tarifaconvenio, sum(COALESCE(qtd,0.0)*COALESCE(unitarioconvenio,0.0)) comissaoconvenio"
                        + ",avg(COALESCE(unitarioloja,0.0)) as tarifaloja, sum(COALESCE(qtd,0.0)*COALESCE(unitarioloja,0.0)) as comissaoloja"
                        + ",0.0 as comissaow7, sum(COALESCE(comissao_sn_ph,0.0)) as custoper"
                        + ",sum(COALESCE(qtd,0.0)*COALESCE(unitarioconvenio,0.0)*0.2215) as imposto, "
                        + "sum((COALESCE(qtd,0.0)*COALESCE(unitarioconvenio,0.0))-(COALESCE(qtd,0.0)*COALESCE(unitarioloja,0.0))-(COALESCE(qtd,0.0)*COALESCE(unitarioconvenio,0.0)*0.2215)-(COALESCE(comissao_sn_ph,0.0))) as liquido "
                        + "from financeira.fatosboletos f "
                        + "inner join cadastro.convenioboleto c on (c.id=convenioboleto_id) "
                        + "where periodo between DATAINICIAL and DATAFINAL ";
                break;
            case 2:
                query = "select conveniosite_id as convenio, nome empresa, sum(COALESCE(qtd,0.0)) as guias, sum(COALESCE(arrecadado,0.0)) as valor"
                        + ",avg(COALESCE(unitarioconvenio,0.0)) as tarifaconvenio, sum(COALESCE(qtd,0.0)*COALESCE(unitarioconvenio,0.0)) comissaoconvenio"
                        + ",avg(COALESCE(unitarioloja,0.0)) as tarifaloja, sum(COALESCE(qtd,0.0)*COALESCE(unitarioloja,0.0)) as comissaoloja"
                        + ",sum(COALESCE(qtd,0.0)*COALESCE(unitarioconvenio,0.0)*COALESCE(comissaow7,0.0)/100) as comissaow7, sum(COALESCE(comissao_sn_ph,0.0)) as custoper"
                        + ",sum(COALESCE(qtd,0.0)*COALESCE(unitarioconvenio,0.0)*0.2215) as imposto, "
                        + "sum((COALESCE(qtd,0.0)*COALESCE(unitarioconvenio,0.0))-(COALESCE(qtd,0.0)*COALESCE(unitarioloja,0.0))-(COALESCE(qtd,0.0)*COALESCE(unitarioconvenio,0.0)*0.2215)-(COALESCE(qtd,0.0)*COALESCE(unitarioconvenio,0.0)*COALESCE(comissaow7,0.0)/100)-(COALESCE(comissao_sn_ph,0.0))) as liquido from financeira.fatosboletosite f "
                        + "inner join cadastro.conveniosite c on (c.id=conveniosite_id) "
                        + "where periodo between DATAINICIAL and DATAFINAL ";

                break;
            case 3:
                query = "select conveniocredigi_id as convenio, nome empresa, sum(COALESCE(qtd,0.0)) as guias, sum(COALESCE(arrecadado,0.0)) as valor"
                        + ",avg(COALESCE(unitarioconvenio,0.0)) as tarifaconvenio, sum(COALESCE(arrecadado,0.0)*COALESCE(unitarioconvenio,0.0)/100) comissaoconvenio "
                        + ",avg(COALESCE(unitarioloja,0.0)) as tarifaloja, sum(COALESCE(arrecadado,0.0)*COALESCE(unitarioloja,0.0)/100) as comissaoloja "
                        + ",0.0 as comissaow7, sum(COALESCE(comissao_sn_ph,0.0)) as custoper"
                        + ",sum((COALESCE(arrecadado,0.0)*COALESCE(unitarioconvenio,0.0)/100)*0) as imposto "
                        + ",sum((COALESCE(arrecadado,0.0)*COALESCE(unitarioconvenio,0.0)/100)-(COALESCE(arrecadado,0.0)*COALESCE(unitarioloja,0.0)/100)"
                        + "-((COALESCE(arrecadado,0.0)*COALESCE(unitarioconvenio,0.0)/100)*0)-(COALESCE(comissao_sn_ph,0.0))) as liquido "
                        + "from financeira.fatoscreditos f "
                        + "inner join cadastro.conveniocredigi c on (c.id=conveniocredigi_id) "
                        + "where periodo between DATAINICIAL and DATAFINAL ";
                break;
            case 4:
                query = "select conveniorecarga_id as convenio, nome empresa, sum(COALESCE(qtd,0.0)) as qtd, sum(COALESCE(arrecadado,0.0)) as valor "
                        + ",avg(COALESCE(unitarioconvenio,0.0)) as tarifaconvenio, sum(COALESCE(arrecadado,0.0)*COALESCE(unitarioconvenio,0.0)/100) comissaoconvenio "
                        + ",avg(COALESCE(unitarioloja,0.0)) as tarifaloja, sum(COALESCE(arrecadado,0.0)*COALESCE(unitarioloja,0.0)/100) as comissaoloja"
                        + ",0.0 as comissaow7, sum(COALESCE(comissao_sn_ph,0.0)) as custoper"
                        + ",sum((COALESCE(arrecadado,0.0)*COALESCE(unitarioconvenio,0.0)/100)*0) as imposto"
                        + ",sum((COALESCE(arrecadado,0.0)*COALESCE(unitarioconvenio,0.0)/100)-(COALESCE(arrecadado,0.0)*COALESCE(unitarioloja,0.0)/100)"
                        + "-((COALESCE(arrecadado,0.0)*COALESCE(unitarioconvenio,0.0)/100)*0)-(COALESCE(comissao_sn_ph,0.0))) as liquido "
                        + "from financeira.fatosrecarga f "
                        + "inner join cadastro.conveniorecarga c on (c.id=conveniorecarga_id) "
                        + "where periodo between DATAINICIAL and DATAFINAL ";
                break;
            case 5:
                query = "select conveniogas_id as convenio, nome empresa, sum(COALESCE(qtd,0.0)) as qtd, sum(COALESCE(arrecadado,0.0)) as valor"
                        + ",avg(COALESCE(unitarioconvenio,0.0)) as tarifaconvenio, sum(COALESCE(qtd,0.0)*COALESCE(unitarioconvenio,0.0)) comissaoconvenio"
                        + ",avg(COALESCE(unitarioloja,0.0)) as tarifaloja, sum(COALESCE(qtd,0.0)*COALESCE(unitarioloja,0.0)) as comissaoloja"
                        + ",0.0 as comissaow7, sum(COALESCE(comissao_sn_ph,0.0)) as custoper"
                        + ",sum((COALESCE(qtd,0.0)*COALESCE(unitarioconvenio,0.0))*0) as imposto"
                        + ",sum((COALESCE(qtd,0.0)*COALESCE(unitarioconvenio,0.0))-(COALESCE(qtd,0.0)*COALESCE(unitarioloja,0.0)/100)"
                        + "-((COALESCE(qtd,0.0)*COALESCE(unitarioconvenio,0.0)/100)*0)-(COALESCE(comissao_sn_ph,0.0))) as liquido "
                        + "from financeira.fatosvalegas f "
                        + "inner join cadastro.conveniogas c on (c.id=conveniogas_id) "
                        + "where periodo between DATAINICIAL and DATAFINAL ";
                break;
            case 6:
                query = "select conveniop_id as convenio, nome empresa, sum(COALESCE(qtd,0.0)) as qtd, sum(COALESCE(arrecadado,0.0)) as valor"
                        + ",avg(COALESCE(unitarioconvenio,0.0)) as tarifaconvenio, sum(COALESCE(qtd,0.0)*COALESCE(unitarioconvenio,0.0)) comissaoconvenio"
                        + ",avg(COALESCE(unitarioloja,0.0)) as tarifaloja, sum(COALESCE(qtd,0.0)*COALESCE(unitarioloja,0.0)) as comissaoloja"
                        + ",0.0 as comissaow7, sum(COALESCE(comissao_sn_ph,0.0)) as custoper, 0.0 as imposto "
                        + ",sum((COALESCE(qtd,0.0)*COALESCE(unitarioconvenio,0.0))-(COALESCE(qtd,0.0)*COALESCE(unitarioloja,0.0))-(COALESCE(comissao_sn_ph,0.0))) as liquido "
                        + "from financeira.fatosops f "
                        + "inner join cadastro.conveniop c on (c.id=conveniop_id) "
                        + "where periodo between DATAINICIAL and DATAFINAL ";
                break;
            case 7:
                query = "select conveniobb_id as convenio, nome empresa, sum(COALESCE(qtd,0.0)) as qtd, sum(COALESCE(arrecadado,0.0)) as valor"
                        + ",avg(COALESCE(unitarioconvenio,0.0)) as tarifaconvenio, sum(COALESCE(qtd,0.0)*COALESCE(unitarioconvenio,0.0)) comissaoconvenio"
                        + ",avg(COALESCE(unitarioloja,0.0)) as tarifaloja, sum(COALESCE(qtd,0.0)*COALESCE(unitarioloja,0.0)) as comissaoloja"
                        + ",0.0 as comissaow7, sum(COALESCE(comissao_sn_ph,0.0)) as custoper"
                        + ",sum((COALESCE(qtd,0.0)*COALESCE(unitarioconvenio,0.0))*0.225) as imposto "
                        + ",sum((COALESCE(qtd,0.0)*COALESCE(unitarioconvenio,0.0))-(COALESCE(qtd,0.0)*COALESCE(unitarioloja,0.0))"
                        + "-((COALESCE(qtd,0.0)*COALESCE(unitarioconvenio,0.0))*0.225)-(COALESCE(comissao_sn_ph,0.0))) as liquido  "
                        + "from financeira.fatosbb f "
                        + "inner join cadastro.conveniobb c on (c.id=conveniobb_id) "
                        + "where periodo between DATAINICIAL and DATAFINAL ";
                break;
            case 8: // Banco popular
                query = "select conveniobanpop_id as convenio, nome empresa, sum(COALESCE(qtd,0.0)) as qtd, sum(COALESCE(arrecadado,0.0)) as valor"
                        + ",avg(COALESCE(unitarioconvenio,0.0)) as tarifaconvenio, sum(COALESCE(qtd,0.0)*COALESCE(unitarioconvenio,0.0)) comissaoconvenio"
                        + ",avg(COALESCE(unitarioloja,0.0)) as tarifaloja, sum(COALESCE(qtd,0.0)*COALESCE(unitarioloja,0.0)) as comissaoloja"
                        + ",0.0 as comissaow7, sum(COALESCE(comissao_sn_ph,0.0)) as custoper"
                        + ",sum((COALESCE(qtd,0.0)*COALESCE(unitarioconvenio,0.0))*0.225) as imposto "
                        + ",sum((COALESCE(qtd,0.0)*COALESCE(unitarioconvenio,0.0))-(COALESCE(qtd,0.0)*COALESCE(unitarioloja,0.0))"
                        + "-((COALESCE(qtd,0.0)*COALESCE(unitarioconvenio,0.0))*0.225)-(COALESCE(comissao_sn_ph,0.0))) as liquido  "
                        + "from financeira.fatosbanpop f "
                        + "inner join cadastro.conveniobanpop c on (c.id=conveniobanpop_id) "
                        + "where periodo between DATAINICIAL and DATAFINAL ";
                break;
        }
        return query;
    }

    private String getAfterWhere(int opcao) {
        String where = "";
        switch (opcao) {
            case 1: //boletos
                where = " group by nome, convenioboleto_id "
                        + "order by nome, convenioboleto_id;";
                break;
            case 2: //boletos site
                where = "group by nome, conveniosite_id "
                        + "order by nome, conveniosite_id;";
                break;
            case 3: //boletos credito
                where = "group by nome, conveniocredigi_id "
                        + "order by nome, conveniocredigi_id;";
                break;
            case 4: //boletos recarga
                where = "group by nome, conveniorecarga_id "
                        + "order by nome, conveniorecarga_id;";
                break;
            case 5: // boletos vale gas
                where = "group by nome, conveniogas_id "
                        + "order by nome, conveniogas_id;";
                break;
            case 6: // boletos ops
                where = "group by nome, conveniop_id "
                        + "order by nome, conveniop_id;";
                break;
            case 7: // boletos banco
                where = "group by nome, conveniobb_id "
                        + "order by nome, conveniobb_id;";
                break;
            case 8: // boletos bradesco
                where = "group by nome, conveniobanpop_id "
                        + "order by nome, conveniobanpop_id;";
                break;
            case 9: // nome e loja_id
                where = " group by nome, loja_id "
                        + "order by nome, loja_id;";
                break;

        }
        return where;
    }

    private Integer convertPeriodoInteger(String periodo) {
        String[] temp = periodo.split("/");
        Integer periodoTemp = Integer.valueOf(temp[1] + temp[0]);

        return periodoTemp;
    }

    public List<GraficoHistoricoArrecadacaoVO> listaHistoricoArrecadacao(Long lojaId, Long cidadeId, Integer periodoInicial, Integer periodoFinal) {
        List<GraficoHistoricoArrecadacaoVO> lista = new ArrayList<GraficoHistoricoArrecadacaoVO>();
        String queryString = "select periodo"
                + ", sum(boletos) boletos, sum(site) as site, sum(creditos) as creditos, sum(recargas) as recargas, sum(ops) as ops"
                + ", sum(valegas) as valegas, sum(bb) as bb, sum(banpop) as banpop from ("
                + "select periodo, loja_id "
                + ",sum((qtd*coalesce(unitarioconvenio,0.0))-(qtd*coalesce(unitarioloja,0.0))-(qtd*coalesce(unitarioconvenio,0.0)*0.2215)-(coalesce(comissao_sn_ph,0.0))) as boletos "
                + ", 0.0 as site, 0.0 as creditos, 0.0 as recargas, 0.0 as ops, 0.0 as valegas, 0.0 as bb, 0.0 as banpop "
                + "from financeira.fatosboletos f "
                + "group by periodo, loja_id "
                + "union all "
                + "select periodo, loja_id, 0.0 "
                + ",sum((qtd*coalesce(unitarioconvenio,0.0))-(qtd*coalesce(unitarioloja,0.0))-(qtd*coalesce(unitarioconvenio,0.0)*0.2215)"
                + "-(qtd*coalesce(unitarioconvenio,0.0)*comissaow7/100)-(coalesce(comissao_sn_ph,0.0))) "
                + ", 0.0, 0.0, 0.0, 0.0, 0.0, 0.0 "
                + "from financeira.fatosboletosite f "
                + "group by periodo, loja_id "
                + "union all "
                + "select periodo, loja_id, 0.0 ,0.0 "
                + ",sum((arrecadado*coalesce(unitarioconvenio,0.0)/100)-(arrecadado*coalesce(unitarioloja,0.0)/100) "
                + "-((arrecadado*coalesce(unitarioconvenio,0.0)/100)*0.0)-(coalesce(comissao_sn_ph,0.0))) "
                + ", 0.0, 0.0, 0.0, 0.0, 0.0 "
                + "from financeira.fatoscreditos f "
                + "group by periodo, loja_id "
                + "union all "
                + "select periodo, loja_id, 0.0, 0.0, 0.0  "
                + ",sum((arrecadado*coalesce(unitarioconvenio,0.0)/100)-(arrecadado*coalesce(unitarioloja,0.0)/100) "
                + "-((arrecadado*coalesce(unitarioconvenio,0.0)/100)*0.0)-(coalesce(comissao_sn_ph,0.0))) "
                + ", 0.0, 0.0, 0.0, 0.0 "
                + "from financeira.fatosrecarga f "
                + "group by periodo, loja_id "
                + "union all "
                + "select periodo, loja_id "
                + ", 0.0, 0.0, 0.0, 0.0 "
                + ",sum((qtd*coalesce(unitarioconvenio,0.0))-(qtd*coalesce(unitarioloja,0.0))-(coalesce(comissao_sn_ph,0.0))) "
                + ", 0.0, 0.0, 0.0 "
                + "from financeira.fatosops f "
                + "group by periodo, loja_id "
                + "union all "
                + "select periodo, loja_id , 0.0, 0.0, 0.0, 0.0, 0.0 "
                + ",sum((qtd*coalesce(unitarioconvenio,0.0))-(qtd*coalesce(unitarioloja,0.0)) "
                + "-((qtd*coalesce(unitarioconvenio,0.0))*0)-(coalesce(comissao_sn_ph,0))) , 0.0, 0.0 "
                + "from financeira.fatosvalegas f "
                + "group by periodo, loja_id "
                + "union all "
                + "select periodo, loja_id , 0.0, 0.0, 0.0, 0.0, 0.0, 0.0 "
                + ",sum((qtd*coalesce(unitarioconvenio,0.0))-(qtd*coalesce(unitarioloja,0.0)) "
                + "-(qtd*coalesce(unitarioconvenio,0.0)*0.225)-(coalesce(comissao_sn_ph,0.0))) , 0.0 "
                + "from financeira.fatosbb f "
                + "group by periodo, loja_id "
                + "union all "
                + "select periodo, loja_id "
                + ", 0.0, 0.0, 0.0, 0.0, 0.0, 0.0, 0.0 "
                + ",sum((qtd*coalesce(unitarioconvenio,0.0))-(qtd*coalesce(unitarioloja,0.0))-((qtd*coalesce(unitarioconvenio,0.0))*0.225)-(coalesce(comissao_sn_ph,0.0))) as liquido "
                + "from financeira.fatosbanpop f "
                + "group by periodo, loja_id ) as c "
                + "inner join cadastro.loja l on (l.id=c.loja_id) "
                + "inner join cadastro.cidade i on (i.id=l.cidade_id) "
                + "where periodo < "
                + dataEmPeriodo(new Date());

        if (lojaId != null) {
            queryString = queryString.concat(" AND loja_id =" + String.valueOf(lojaId));
        }
        if (cidadeId != null && lojaId == null) {
            queryString = queryString.concat(" AND cidade_id=" + String.valueOf(cidadeId));
        }

        queryString = queryString.concat(" group by periodo order by periodo");

        //--cidade_id = 1153 and  
        Query query;
        query = getEntityManager().createNativeQuery(queryString);

        List<Object[]> resultado = query.getResultList();

        for (Object[] tupla : resultado) {

            GraficoHistoricoArrecadacaoVO graficoHistoricoArrVO = new GraficoHistoricoArrecadacaoVO();
            if (tupla[0] != null) {
                graficoHistoricoArrVO.setPeriodo(((Integer) tupla[0]));
            } else {
                graficoHistoricoArrVO.setPeriodo(000000);
            }

            if (tupla[1] != null) {
                graficoHistoricoArrVO.setBoletos((BigDecimal) tupla[1]);
            } else {
                graficoHistoricoArrVO.setBoletos(BigDecimal.ZERO);
            }

            if (tupla[2] != null) {
                graficoHistoricoArrVO.setSite((BigDecimal) tupla[2]);
            } else {
                graficoHistoricoArrVO.setSite(BigDecimal.ZERO);
            }

            if (tupla[3] != null) {
                graficoHistoricoArrVO.setCreditos((BigDecimal) tupla[3]);
            } else {
                graficoHistoricoArrVO.setCreditos(BigDecimal.ZERO);
            }

            if (tupla[4] != null) {
                graficoHistoricoArrVO.setRecargas((BigDecimal) tupla[4]);
            } else {
                graficoHistoricoArrVO.setRecargas(BigDecimal.ZERO);
            }

            if (tupla[5] != null) {
                graficoHistoricoArrVO.setOps((BigDecimal) tupla[5]);
            } else {
                graficoHistoricoArrVO.setOps(BigDecimal.ZERO);
            }

            if (tupla[6] != null) {
                graficoHistoricoArrVO.setValegas((BigDecimal) tupla[6]);
            } else {
                graficoHistoricoArrVO.setValegas(BigDecimal.ZERO);
            }

            if (tupla[7] != null) {
                graficoHistoricoArrVO.setBb((BigDecimal) tupla[7]);
            } else {
                graficoHistoricoArrVO.setBb(BigDecimal.ZERO);
            }

            if (tupla[8] != null) {
                graficoHistoricoArrVO.setBp((BigDecimal) tupla[8]);
            } else {
                graficoHistoricoArrVO.setBp(BigDecimal.ZERO);
            }

            lista.add(graficoHistoricoArrVO);
        }

        return lista;
    }

    public List<GraficoHistoricoArrecadacaoVO> listaHistoricoArrecadacaoConvenio(ConvenioCampConsultVO campos) {
        List<GraficoHistoricoArrecadacaoVO> lista = new ArrayList<GraficoHistoricoArrecadacaoVO>();
        String queryString = "select periodo "
                + ",sum((qtd*coalesce(unitarioconvenio,0))-(qtd*coalesce(unitarioloja,0))-(qtd*coalesce(unitarioconvenio,0)*0.2215)-(coalesce(comissao_sn_ph,0))) as liquido "
                + "from " + getFromFatos(campos.getTipoBoleto())
                + "where periodo < "
                + dataEmPeriodo(new Date());
        if (campos.getTipoBoleto() == TipoBoletos.BOLETOS) {
            if (campos.getConvenioBoleto() != null) {
                queryString = queryString.concat(" AND convenioboleto_id=" + String.valueOf(campos.getConvenioBoleto().getId()));
            }
        }

        if (campos.getTipoBoleto() == TipoBoletos.BOLETOSITE) {
            if (campos.getConvenioSite() != null) {
                queryString = queryString.concat(" AND conveniosite_id=" + String.valueOf(campos.getConvenioSite().getId()));
            }
        }

        if (campos.getTipoBoleto() == TipoBoletos.CREDIDOS) {
            if (campos.getConvenioCredito() != null) {
                queryString = queryString.concat(" AND conveniocredigi_id=" + String.valueOf(campos.getConvenioCredito().getId()));
            }
        }

        if (campos.getTipoBoleto() == TipoBoletos.RECARGA) {
            if (campos.getConvenioRecarga() != null) {
                queryString = queryString.concat(" AND conveniorecarga_id=" + String.valueOf(campos.getConvenioRecarga().getId()));
            }
        }

        if (campos.getTipoBoleto() == TipoBoletos.VALEGAS) {
            if (campos.getConvenioValeGas() != null) {
                queryString = queryString.concat(" AND conveniogas_id=" + String.valueOf(campos.getConvenioValeGas().getId()));
            }
        }

        if (campos.getTipoBoleto() == TipoBoletos.OPS) {
            if (campos.getConvenioOp() != null) {
                queryString = queryString.concat(" AND conveniop_id=" + String.valueOf(campos.getConvenioOp().getId()));
            }
        }

        if (campos.getTipoBoleto() == TipoBoletos.BB) {
            if (campos.getConvenioBB() != null) {
                queryString = queryString.concat(" AND conveniobb_id=" + String.valueOf(campos.getConvenioBB().getId()));
            }
        }

        if (campos.getTipoBoleto() == TipoBoletos.BP) {
            if (campos.getConvenioBP() != null) {
                queryString = queryString.concat(" AND conveniobanpop_id=" + String.valueOf(campos.getConvenioBP().getId()));
            }
        }

        queryString = queryString.concat(" group by periodo order by periodo");

        Query query;
        query = getEntityManager().createNativeQuery(queryString);

        List<Object[]> resultado = query.getResultList();

        for (Object[] tupla : resultado) {

            GraficoHistoricoArrecadacaoVO graficoHistoricoArrVO = new GraficoHistoricoArrecadacaoVO();
            if (tupla[0] != null) {
                graficoHistoricoArrVO.setPeriodo(((Integer) tupla[0]));
            } else {
                graficoHistoricoArrVO.setPeriodo(000000);
            }

            if (tupla[1] != null) {
                graficoHistoricoArrVO.setBoletos((BigDecimal) tupla[1]);
            } else {
                graficoHistoricoArrVO.setBoletos(BigDecimal.ZERO);
            }

            lista.add(graficoHistoricoArrVO);
        }

        return lista;
    }

    private String dataEmPeriodo(Date data) {

        GregorianCalendar calendar = new GregorianCalendar();
        calendar.setTime(new Date());
        int mes = calendar.get(GregorianCalendar.MONTH) + 1;
        int ano = calendar.get(GregorianCalendar.YEAR);

        String periodo = String.valueOf(ano).concat(String.format("%02d", mes));

        return periodo;
    }

    public List<Cidade> getCidadesComPosto() {
        QueryBuilder query = fatosBoletosDAO.getQueryBuilder();
        List<Cidade> cidades;
        cidades = query.selectDistinct("c").from(Loja.class, "l").innerJoin("l.cidade", "c").orderBy("c.nome").getResultList();

        Collections.sort(cidades, new CidadeComparadaPorNome());

        return cidades;
    }

    public List<RentabilidadeVO> listRentabilidadeConvenio(Long convenio, Date dataInicial, Date dataFinal, int boleto) {
        List<RentabilidadeVO> rentabilidades = new ArrayList<RentabilidadeVO>();
        String queryString = "";

        if (convenio != null && dataInicial != null && dataFinal != null) {
            queryString = retornaQueryRentConvenio(boleto).replaceAll("DATAINICIAL", convertPeriodo(dataInicial).toString())
                    .replaceAll("DATAFINAL", convertPeriodo(dataFinal).toString()) + getAndConvenio(boleto)
                    .replaceAll("CONVENIOIDQUERY", convenio.toString()) + getAfterWhere(9);

        }

        if (convenio != null && dataInicial != null && dataFinal == null) {
            queryString = retornaQueryRentConvenio(boleto).replaceAll("DATAINICIAL", convertPeriodo(dataInicial).toString())
                    .replaceAll("DATAFINAL", convertPeriodo(new Date()).toString()) + getAndConvenio(boleto)
                    .replaceAll("CONVENIOIDQUERY", convenio.toString()) + getAfterWhere(9);
        }

        if (convenio != null && dataInicial == null && dataFinal != null) {
            queryString = retornaQueryRentConvenio(boleto).replaceAll("DATAINICIAL", "199001")
                    .replaceAll("DATAFINAL", convertPeriodo(dataFinal).toString()) + getAndConvenio(boleto)
                    .replaceAll("CONVENIOIDQUERY", convenio.toString()) + getAfterWhere(9);
        }

        if (convenio != null && dataInicial == null && dataFinal == null) {
            queryString = retornaQueryRentConvenio(boleto).replaceAll("DATAINICIAL", "199001")
                    .replaceAll("DATAFINAL", convertPeriodo(new Date()).toString()) + getAndConvenio(boleto)
                    .replaceAll("CONVENIOIDQUERY", convenio.toString()) + getAfterWhere(9);
        }

        if (convenio == null && dataInicial != null && dataFinal != null) {
            queryString = retornaQueryRentConvenio(boleto)
                    .replaceAll("DATAINICIAL", convertPeriodo(dataInicial).toString())
                    .replaceAll("DATAFINAL", convertPeriodo(dataFinal).toString()) + getAfterWhere(9);
        }

        if (convenio == null && dataInicial != null && dataFinal == null) {
            queryString = retornaQueryRentConvenio(boleto)
                    .replaceAll("DATAINICIAL", convertPeriodo(dataInicial).toString())
                    .replaceAll("DATAFINAL", convertPeriodo(new Date()).toString()) + getAfterWhere(9);
        }

        if (convenio == null && dataInicial == null && dataFinal != null) {
            queryString = retornaQueryRentConvenio(boleto)
                    .replaceAll("DATAINICIAL", "199001")
                    .replaceAll("DATAFINAL", convertPeriodo(dataFinal).toString()) + getAfterWhere(9);
        }

        if (convenio == null && dataInicial == null && dataFinal == null) {
            queryString = retornaQueryRentConvenio(boleto).replaceAll("DATAINICIAL", "199001")
                    .replaceAll("DATAFINAL", convertPeriodo(new Date()).toString()) + getAfterWhere(9);
        }

        Query query;

        query = getEntityManager().createNativeQuery(queryString);

        List<Object[]> resultado = query.getResultList();

        for (Object[] tupla : resultado) {

            RentabilidadeVO rentabilidade = new RentabilidadeVO();
            if (tupla[0] != null) {
                rentabilidade.setConvenio(((BigInteger) tupla[0]).longValue());
            } else {
                rentabilidade.setConvenio(Long.valueOf(0));
            }

            if (tupla[1] != null) {
                rentabilidade.setEmpresa((String) tupla[1]);
            } else {
                rentabilidade.setEmpresa("");
            }

            if (tupla[2] != null) {
                rentabilidade.setGuias(((Number) tupla[2]).intValue());
            } else {
                rentabilidade.setGuias(Integer.valueOf(0));
            }

            if (tupla[3] != null) {
                rentabilidade.setValor((BigDecimal) tupla[3]);
            } else {
                rentabilidade.setValor(BigDecimal.ZERO);
            }

            if (tupla[4] != null) {
                rentabilidade.setTarifaConvenio((BigDecimal) tupla[4]);
            } else {
                rentabilidade.setTarifaConvenio(BigDecimal.ZERO);
            }

            if (tupla[5] != null) {
                rentabilidade.setComissaoConvenio((BigDecimal) tupla[5]);
            } else {
                rentabilidade.setComissaoConvenio(BigDecimal.ZERO);
            }

            if (tupla[6] != null) {
                rentabilidade.setTarifaLoja((BigDecimal) tupla[6]);
            } else {
                rentabilidade.setTarifaLoja(BigDecimal.ZERO);
            }

            if (tupla[7] != null) {
                rentabilidade.setComissaoLoja((BigDecimal) tupla[7]);
            } else {
                rentabilidade.setComissaoLoja(BigDecimal.ZERO);
            }

            if (tupla[8] != null) {
                rentabilidade.setComissaoW7((BigDecimal) tupla[8]);
            } else {
                rentabilidade.setComissaoW7(BigDecimal.ZERO);
            }

            if (tupla[9] != null) {
                rentabilidade.setComissao((BigDecimal) tupla[9]);
            } else {
                rentabilidade.setComissao(BigDecimal.ZERO);
            }

            if (tupla[10] != null) {
                rentabilidade.setImposto((BigDecimal) tupla[10]);
            } else {
                rentabilidade.setImposto(BigDecimal.ZERO);
            }

            if (tupla[11] != null) {
                rentabilidade.setLiquido((BigDecimal) tupla[11]);
            } else {
                rentabilidade.setLiquido(BigDecimal.ZERO);
            }

            rentabilidades.add(rentabilidade);
        }

        return rentabilidades;
    }

    private String retornaQueryRentConvenio(int tipo) {
        String query = "";
        switch (tipo) {
            case 1:
                query = "select loja_id as loja, nome empresa, sum(qtd) as qtd, sum(arrecadado) as valor "
                        + ",avg(unitarioconvenio) as tarifaconvenio, sum(qtd*unitarioconvenio) comissaoconvenio "
                        + ",avg(unitarioloja) as tarifaloja, sum(qtd*unitarioloja) as comissaoloja "
                        + ",0.0 as comissaow7, sum(comissao_sn_ph) as custoper "
                        + ",sum(qtd*unitarioconvenio*0.2215) as imposto,  "
                        + "sum((qtd*unitarioconvenio)-(qtd*unitarioloja)-(qtd*unitarioconvenio*0.2215)-(comissao_sn_ph)) as liquido "
                        + "from financeira.fatosboletos f "
                        + "inner join cadastro.loja l on (l.id=f.loja_id) "
                        + "where periodo between DATAINICIAL and DATAFINAL ";
                break;
            case 2:
                query = "select loja_id as loja, nome empresa, sum(qtd) as qtd, sum(arrecadado) as valor"
                        + ",avg(unitarioconvenio) as tarifaconvenio, sum(qtd*unitarioconvenio) comissaoconvenio"
                        + ",avg(unitarioloja) as tarifaloja, sum(qtd*unitarioloja) as comissaoloja"
                        + ",sum(qtd*unitarioconvenio*comissaow7/100) as comissaow7, sum(comissao_sn_ph) as custoper"
                        + ",sum(qtd*unitarioconvenio*0.2215) as imposto, "
                        + "sum((qtd*unitarioconvenio)-(qtd*unitarioloja)-(qtd*unitarioconvenio*0.2215)-(qtd*unitarioconvenio*comissaow7/100)-(comissao_sn_ph)) as liquido "
                        + "from financeira.fatosboletosite f "
                        + "inner join cadastro.loja l on (l.id=f.loja_id) "
                        + "where periodo between DATAINICIAL and DATAFINAL ";

                break;
            case 3:
                query = "select loja_id as loja, nome empresa, sum(qtd) as qtd, sum(arrecadado) as valor "
                        + ",avg(unitarioconvenio) as tarifaconvenio, sum(arrecadado*unitarioconvenio/100) comissaoconvenio  "
                        + ",avg(unitarioloja) as tarifaloja, sum(arrecadado*unitarioloja/100) as comissaoloja "
                        + ",0.0 as comissaow7, sum(comissao_sn_ph) as custoper "
                        + ",sum((arrecadado*unitarioconvenio/100)*0) as imposto  "
                        + ",sum((arrecadado*unitarioconvenio/100)-(arrecadado*unitarioloja/100) "
                        + "-((arrecadado*unitarioconvenio/100)*0)-(comissao_sn_ph)) as liquido  "
                        + "from financeira.fatoscreditos f "
                        + "inner join cadastro.loja l on (l.id=f.loja_id) "
                        + "where periodo between DATAINICIAL and DATAFINAL ";
                break;
            case 4:
                query = "select loja_id as loja, nome empresa, sum(qtd) as qtd, sum(arrecadado) as valor "
                        + ",avg(unitarioconvenio) as tarifaconvenio, sum(arrecadado*unitarioconvenio/100) comissaoconvenio  "
                        + ",avg(unitarioloja) as tarifaloja, sum(arrecadado*unitarioloja/100) as comissaoloja "
                        + ",0.0 as comissaow7, sum(comissao_sn_ph) as custoper "
                        + ",sum((arrecadado*unitarioconvenio/100)*0) as imposto  "
                        + ",sum((arrecadado*unitarioconvenio/100)-(arrecadado*unitarioloja/100) "
                        + "-((arrecadado*unitarioconvenio/100)*0)-(comissao_sn_ph)) as liquido  "
                        + "from financeira.fatosrecarga f "
                        + "inner join cadastro.loja l on (l.id=f.loja_id) "
                        + "where periodo between DATAINICIAL and DATAFINAL ";
                break;
            case 5:
                query = "select loja_id as loja, nome empresa, sum(qtd) as qtd, sum(arrecadado) as valor "
                        + ",avg(unitarioconvenio) as tarifaconvenio, sum(qtd*unitarioconvenio) comissaoconvenio  "
                        + ",avg(unitarioloja) as tarifaloja, sum(qtd*unitarioloja) as comissaoloja "
                        + ",0.0 as comissaow7, sum(comissao_sn_ph) as custoper "
                        + ",sum((qtd*unitarioconvenio)*0) as imposto  "
                        + ",sum((qtd*unitarioconvenio)-(qtd*unitarioloja) "
                        + "-((qtd*unitarioconvenio)*0)-(comissao_sn_ph)) as liquido  "
                        + "from financeira.fatosvalegas f "
                        + "inner join cadastro.loja l on (l.id=f.loja_id) "
                        + "where periodo between DATAINICIAL and DATAFINAL ";
                break;
            case 6:
                query = "select loja_id as loja, nome empresa, sum(qtd) as qtd, sum(arrecadado) as valor "
                        + ",avg(unitarioconvenio) as tarifaconvenio, sum(qtd*unitarioconvenio) comissaoconvenio  "
                        + ",avg(unitarioloja) as tarifaloja, sum(qtd*unitarioloja) as comissaoloja "
                        + ",0.0 as comissaow7, sum(comissao_sn_ph) as custoper "
                        + ",sum((qtd*unitarioconvenio)*0) as imposto  "
                        + ",sum((qtd*unitarioconvenio)-(qtd*unitarioloja) "
                        + "-((qtd*unitarioconvenio)*0)-(comissao_sn_ph)) as liquido  "
                        + "from financeira.fatosops f "
                        + "inner join cadastro.loja l on (l.id=f.loja_id) "
                        + "where periodo between DATAINICIAL and DATAFINAL ";
                break;
            case 7:
                query = "select loja_id as loja, nome empresa, sum(qtd) as qtd, sum(arrecadado) as valor "
                        + ",avg(unitarioconvenio) as tarifaconvenio, sum(qtd*unitarioconvenio) comissaoconvenio  "
                        + ",avg(unitarioloja) as tarifaloja, sum(qtd*unitarioloja) as comissaoloja "
                        + ",0.0 as comissaow7, sum(comissao_sn_ph) as custoper "
                        + ",sum((qtd*unitarioconvenio)*0.225) as imposto  "
                        + ",sum((qtd*unitarioconvenio)-(qtd*unitarioloja) "
                        + "-((qtd*unitarioconvenio)*0.225)-(comissao_sn_ph)) as liquido  "
                        + "from financeira.fatosbb f "
                        + "inner join cadastro.loja l on (l.id=f.loja_id) "
                        + "where periodo between DATAINICIAL and DATAFINAL ";
                break;
            case 8: // Banco popular
                query = "select loja_id as loja, nome empresa, sum(qtd) as qtd, sum(arrecadado) as valor "
                        + ",avg(unitarioconvenio) as tarifaconvenio, sum(qtd*unitarioconvenio) comissaoconvenio  "
                        + ",avg(unitarioloja) as tarifaloja, sum(qtd*unitarioloja) as comissaoloja "
                        + ",0.0 as comissaow7, sum(comissao_sn_ph) as custoper "
                        + ",sum((qtd*unitarioconvenio)*0.225) as imposto  "
                        + ",sum((qtd*unitarioconvenio)-(qtd*unitarioloja) "
                        + "-((qtd*unitarioconvenio)*0.225)-(comissao_sn_ph)) as liquido  "
                        + "from financeira.fatosbanpop f "
                        + "inner join cadastro.loja l on (l.id=f.loja_id) "
                        + "where periodo between DATAINICIAL and DATAFINAL ";
                break;
        }
        return query;
    }

    private String getAndConvenio(int tipo) {
        String andConvenio = "";
        switch (tipo) {
            case 1:
                andConvenio = " and convenioboleto_id=CONVENIOIDQUERY ";
                break;
            case 2:
                andConvenio = " and conveniosite_id=CONVENIOIDQUERY ";
                break;
            case 3:
                andConvenio = " and conveniocredigi_id=CONVENIOIDQUERY ";
                break;
            case 4:
                andConvenio = " and conveniorecarga_id=CONVENIOIDQUERY ";
                break;
            case 5:
                andConvenio = " and conveniogas_id=CONVENIOIDQUERY ";
                break;
            case 6:
                andConvenio = " and conveniop_id=CONVENIOIDQUERY ";
                break;
            case 7:
                andConvenio = " and conveniobb_id=CONVENIOIDQUERY ";
                break;
            case 8:
                andConvenio = " and conveniobanpop_id=CONVENIOIDQUERY ";
                break;
        }
        return andConvenio;
    }

    private String getFromFatos(TipoBoletos tipo) {
        String from = "";
        if (tipo == TipoBoletos.BOLETOS) {
            from = "financeira.fatosboletos f ";
        }
        if (tipo == TipoBoletos.BOLETOSITE) {
            from = "financeira.fatosboletosite f ";
        }
        if (tipo == TipoBoletos.CREDIDOS) {
            from = "financeira.fatoscreditos f ";
        }
        if (tipo == TipoBoletos.RECARGA) {
            from = "financeira.fatosrecarga f ";
        }
        if (tipo == TipoBoletos.VALEGAS) {
            from = "financeira.fatosvalegas f ";
        }
        if (tipo == TipoBoletos.OPS) {
            from = "financeira.fatosops f ";
        }
        if (tipo == TipoBoletos.BB) {
            from = "financeira.fatosbb f ";
        }
        if (tipo == TipoBoletos.BP) {
            from = "financeira.fatosbanpop f ";
        }
        return from;
    }
}