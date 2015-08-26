package br.com.jsoft.centralfinanceira.dao.central.impl;

import br.com.jsoft.centralfinanceira.application.BaseDAOImpl;
import br.com.jsoft.centralfinanceira.dao.central.FatosCreditosDAO;
import br.com.jsoft.centralfinanceira.modelo.central.FatosCreditos;
import br.com.jsoft.centralfinanceira.vo.ComissaoConvenioCredVO;
import br.com.jsoft.centralfinanceira.vo.ComissaoLojaCredVO;
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
public class FatosCreditosDAOImpl extends BaseDAOImpl<FatosCreditos> implements FatosCreditosDAO {
    
    @Override
    public void updateUnitarioConvenio(Long id, BigDecimal valor, Integer periodo) {
        String queryString = " UPDATE " + FatosCreditos.class.getName()
                + " SET unitarioconvenio = ?1";
        Query query = null;
        queryString += " WHERE conveniocredigi.id = ?2 and periodo = ?3";
        query = getEntityManager().createQuery(queryString);       
        query.setParameter(1, valor);
        query.setParameter(2, id);
        query.setParameter(3, periodo);
        query.executeUpdate();        
    }
    
    @Override
    public void updateUnitarioLoja(Long id, BigDecimal valor, Integer periodo) {
        String queryString = " UPDATE " + FatosCreditos.class.getName()
                + " SET unitarioloja = ?1";
        Query query = null;
        queryString += " WHERE loja.id = ?2 and periodo = ?3";
        query = getEntityManager().createQuery(queryString);       
        query.setParameter(1, valor);
        query.setParameter(2, id);
        query.setParameter(3, periodo);
        query.executeUpdate();
    }

    @Override
    public List<ComissaoConvenioCredVO> listBoletoConvenio() {
        List<ComissaoConvenioCredVO> listaComissao = new ArrayList<ComissaoConvenioCredVO>();

        String queryString = "select periodo, conveniocredigi_id, c.nome, "
                + "sum(qtd) qtd, sum(arrecadado) arrecadado, avg(unitarioconvenio) unitarioconvenio, "
                + "sum(unitarioloja*arrecadado/100) comissaoloja from financeira.fatoscreditos f "
                + "inner join cadastro.conveniocredigi c on (c.id=f.conveniocredigi_id) "
                + "group by conveniocredigi_id, c.nome, periodo "
                + "order by conveniocredigi_id, periodo";

        Query query;

        query = getEntityManager().createNativeQuery(queryString);

        List<Object[]> resultado = query.getResultList();

        for (Object[] tupla : resultado) {
            ComissaoConvenioCredVO comissaoConvenio = new ComissaoConvenioCredVO();
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
    
    @Override
    public List<ComissaoLojaCredVO> listBoletoLoja() {
        List<ComissaoLojaCredVO> listaComissao = new ArrayList<ComissaoLojaCredVO>();

        String queryString = "select periodo, loja_id, l.nome, "
                + "sum(qtd) qtd, sum(arrecadado) arrecadado, avg(unitarioloja) unitarioloja, "
                + "sum(unitarioconvenio*arrecadado/100) comissaoconvenio from financeira.fatoscreditos f "
                + "inner join cadastro.loja l on (l.id=f.loja_id) "
                + "group by loja_id, l.nome, periodo "
                + "order by loja_id, periodo";

        Query query;

        query = getEntityManager().createNativeQuery(queryString);

        List<Object[]> resultado = query.getResultList();

        for (Object[] tupla : resultado) {
            ComissaoLojaCredVO comissaoConvenio = new ComissaoLojaCredVO();
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
