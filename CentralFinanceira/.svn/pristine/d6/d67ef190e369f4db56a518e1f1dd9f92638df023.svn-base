package br.com.jsoft.centralfinanceira.dao.central.impl;

import br.com.jsoft.centralfinanceira.application.BaseDAOImpl;
import br.com.jsoft.centralfinanceira.dao.central.FatosopsDAO;
import br.com.jsoft.centralfinanceira.modelo.central.Fatosops;
import br.com.jsoft.centralfinanceira.vo.ComissaoConvenioOPVO;
import br.com.jsoft.centralfinanceira.vo.ComissaoLojaOPVO;
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
public class FatosopsDAOImpl extends BaseDAOImpl<Fatosops> implements FatosopsDAO {
    
    @Override
    public void updateUnitarioConvenio(Long id, BigDecimal valor, Integer periodo) {
        String queryString = " UPDATE " + Fatosops.class.getName()
                + " SET unitarioconvenio = ?1";
        Query query = null;
        queryString += " WHERE conveniop.id = ?2 and periodo = ?3";
        query = getEntityManager().createQuery(queryString);       
        query.setParameter(1, valor);
        query.setParameter(2, id);
        query.setParameter(3, periodo);
        query.executeUpdate();        
    }
    
    @Override
    public void updateUnitarioLoja(Long id, BigDecimal valor, Integer periodo) {
        String queryString = " UPDATE " + Fatosops.class.getName()
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
    public List<ComissaoConvenioOPVO> listBoletoConvenio() {
        List<ComissaoConvenioOPVO> listaComissao = new ArrayList<ComissaoConvenioOPVO>();

        String queryString = "select periodo, conveniop_id, c.nome, "
                + "sum(qtd) qtd, sum(arrecadado) arrecadado, avg(unitarioconvenio) unitarioconvenio, "
                + "sum(qtd*unitarioloja) comissaoloja from financeira.fatosops f "
                + "inner join cadastro.conveniop c on (c.id=f.conveniop_id) "
                + "group by conveniop_id, c.nome, periodo "
                + "order by conveniop_id, periodo";

        Query query;

        query = getEntityManager().createNativeQuery(queryString);

        List<Object[]> resultado = query.getResultList();

        for (Object[] tupla : resultado) {
            ComissaoConvenioOPVO comissaoConvenio = new ComissaoConvenioOPVO();
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
    public List<ComissaoLojaOPVO> listBoletoLoja() {
        List<ComissaoLojaOPVO> listaComissao = new ArrayList<ComissaoLojaOPVO>();

        String queryString = "select periodo, loja_id, l.nome, "
                + "sum(qtd) qtd, sum(arrecadado) arrecadado, avg(unitarioloja) unitarioloja, "
                + "sum(qtd*unitarioconvenio) comissaoconvenio from financeira.fatosops f "
                + "inner join cadastro.loja l on (l.id=f.loja_id) "
                + "group by loja_id, l.nome, periodo "
                + "order by loja_id, periodo";

        Query query;

        query = getEntityManager().createNativeQuery(queryString);

        List<Object[]> resultado = query.getResultList();

        for (Object[] tupla : resultado) {
            ComissaoLojaOPVO comissaoConvenio = new ComissaoLojaOPVO();
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
