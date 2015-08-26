package br.com.jsoft.centralfinanceira.dao.central.impl;

import br.com.jsoft.centralfinanceira.application.BaseDAOImpl;
import br.com.jsoft.centralfinanceira.dao.central.FatosBoletosDAO;
import br.com.jsoft.centralfinanceira.modelo.central.FatosBoletos;
import br.com.jsoft.centralfinanceira.vo.ComissaoConvenioVO;
import br.com.jsoft.centralfinanceira.vo.ComissaoLojaVO;
import java.math.BigDecimal;
import java.math.BigInteger;
import java.util.ArrayList;
import java.util.List;
import javax.ejb.Stateless;
import javax.persistence.Query;

/**
 *
 * @author Juniel
 */
@Stateless
public class FatosBoletosDAOImpl extends BaseDAOImpl<FatosBoletos> implements FatosBoletosDAO {

    /** Metodo utilizado para atualizaçao do unitario de um determiado convenio (update all) em um determinado periodo
     * @author Juniel
     * @param id
     * @param valor
     * @param periodo 
     */
    @Override
    public void updateUnitarioConvenio(Long id, BigDecimal valor, Integer periodo) {
        String queryString = " UPDATE " + FatosBoletos.class.getName()
                + " SET unitarioconvenio = ?1";
        Query query = null;
        queryString += " WHERE convenioboleto.id = ?2 and periodo = ?3";
        query = getEntityManager().createQuery(queryString);       
        query.setParameter(1, valor);
        query.setParameter(2, id);
        query.setParameter(3, periodo);
        query.executeUpdate();        
    }
    
    /** Metodo utilizado para atualizaçao do unitario de um determiada Loja (update all) em um determinado periodo
     * 
     * @param id
     * @param valor
     * @param periodo 
     */
    @Override
    public void updateUnitarioLoja(Long id, BigDecimal valor, Integer periodo) {
        String queryString = " UPDATE " + FatosBoletos.class.getName()
                + " SET unitarioloja = ?1";
        Query query = null;
        queryString += " WHERE loja.id = ?2 and periodo = ?3";
        query = getEntityManager().createQuery(queryString);       
        query.setParameter(1, valor);
        query.setParameter(2, id);
        query.setParameter(3, periodo);
        query.executeUpdate();
    }

    /** Metodo utilizado para listar a comissao de todos os convenios ordenando por periodo
     * @author Juniel
     * @return List<ComissaoConvenioVO>
     */
    @Override
    public List<ComissaoConvenioVO> listBoletoConvenio() {
        List<ComissaoConvenioVO> listaComissao = new ArrayList<ComissaoConvenioVO>();

        String queryString = "select periodo, convenioboleto_id, c.nome, "
                + "sum(qtd) qtd, sum(arrecadado) arrecadado, avg(unitarioconvenio) unitarioconvenio, "
                + "sum(qtd*unitarioloja) comissaoloja from financeira.fatosboletos f "
                + "inner join cadastro.convenioboleto c on (c.id=f.convenioboleto_id) "
                + "group by convenioboleto_id, c.nome, periodo "
                + "order by convenioboleto_id, periodo";

        Query query;

        query = getEntityManager().createNativeQuery(queryString);

        List<Object[]> resultado = query.getResultList();

        for (Object[] tupla : resultado) {
            ComissaoConvenioVO comissaoConvenio = new ComissaoConvenioVO();
            comissaoConvenio.setPeriodo(((Integer) tupla[0]));
            comissaoConvenio.setId(((BigInteger) tupla[1]).longValue());
            comissaoConvenio.setNome((String) tupla[2]);
            comissaoConvenio.setQtd(((BigInteger) tupla[3]).intValue());
            comissaoConvenio.setArrecadado((BigDecimal) tupla[4]);
            comissaoConvenio.setUnitarioconvenio(((BigDecimal) tupla[5]));
            comissaoConvenio.setComissaoloja((BigDecimal) tupla[6]);

            listaComissao.add(comissaoConvenio);
        }

        return listaComissao;
    }
    
    /** Metodo utilizado para listar a comissao de todas as lojas ordenando por periodo
     * @author Juniel
     * @return List<ComissaoLojaVO>
     */
    @Override
    public List<ComissaoLojaVO> listBoletoLoja() {
        List<ComissaoLojaVO> listaComissao = new ArrayList<ComissaoLojaVO>();

        String queryString = "select periodo, loja_id, l.nome, "
                + "sum(qtd) qtd, sum(arrecadado) arrecadado, avg(unitarioloja) unitarioloja, "
                + "sum(qtd*unitarioconvenio) comissaoconvenio from financeira.fatosboletos f "
                + "inner join cadastro.loja l on (l.id=f.loja_id) "
                + "group by loja_id, l.nome, periodo "
                + "order by loja_id, periodo";

        Query query;

        query = getEntityManager().createNativeQuery(queryString);

        List<Object[]> resultado = query.getResultList();

        for (Object[] tupla : resultado) {
            ComissaoLojaVO comissaoConvenio = new ComissaoLojaVO();
            comissaoConvenio.setPeriodo(((Integer) tupla[0]));
            comissaoConvenio.setId(((BigInteger) tupla[1]).longValue());
            comissaoConvenio.setNome((String) tupla[2]);
            comissaoConvenio.setQtd(((BigInteger) tupla[3]).intValue());
            comissaoConvenio.setArrecadado((BigDecimal) tupla[4]);
            comissaoConvenio.setUnitarioloja(((BigDecimal) tupla[5]));
            comissaoConvenio.setComissaoconvenio((BigDecimal) tupla[6]);

            listaComissao.add(comissaoConvenio);
        }

        return listaComissao;
    }
  
}
