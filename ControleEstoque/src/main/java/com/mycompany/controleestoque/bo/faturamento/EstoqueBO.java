package com.mycompany.controleestoque.bo.faturamento;

import com.xpert.core.crud.AbstractBusinessObject;
import com.mycompany.controleestoque.dao.faturamento.EstoqueDAO;
import com.mycompany.controleestoque.modelo.cadastro.Produto;
import com.mycompany.controleestoque.modelo.cadastro.enums.UnidadeDeMedida;
import com.xpert.core.validation.UniqueField;
import com.xpert.core.exception.BusinessException;
import java.util.List;
import javax.ejb.EJB;
import javax.ejb.Stateless;
import com.mycompany.controleestoque.modelo.faturamento.Estoque;
import com.xpert.core.validation.UniqueFields;
import com.xpert.persistence.query.Restrictions;
import java.math.BigDecimal;

/**
 *
 * @author juniel
 */
@Stateless
public class EstoqueBO extends AbstractBusinessObject<Estoque> {

    @EJB
    private EstoqueDAO estoqueDAO;

    @Override
    public EstoqueDAO getDAO() {
        return estoqueDAO;
    }

    @Override
    public List<UniqueField> getUniqueFields() {
        return new UniqueFields().add("produto", "empresa", "ativo");
    }

    @Override
    public void validate(Estoque estoque) throws BusinessException {
    }

    @Override
    public boolean isAudit() {
        return true;
    }

    public List<Produto> getProdutosAtivos() {
        Restrictions restrictions = new Restrictions();
        restrictions.add("e.ativo", true);

        List<Produto> produtos;
        produtos = estoqueDAO.getQueryBuilder().select("e.produto").from(Estoque.class, "e").add(restrictions).
                orderBy("e.produto.descricao").getResultList();
        return produtos;
    }

    @Override
    public void save(Estoque object) throws BusinessException {
        if (object.getId() == null && object.getProduto().isProdutoFracionado() && verificaTipo(object.getUnidadeDeVenda())) {
            BigDecimal valor = BigDecimal.ZERO;
            valor = valor.add(object.getQuantidade().multiply(object.getProduto().getQtdFracoes() != null ? new BigDecimal(object.getProduto().getQtdFracoes()) : BigDecimal.ONE));
            object.setQuantidade(valor);
        }
        super.save(object);
    }

    private boolean verificaTipo(UnidadeDeMedida unidade) {
        if (unidade == UnidadeDeMedida.FRD || unidade == UnidadeDeMedida.CX || unidade == UnidadeDeMedida.DZ || unidade == UnidadeDeMedida.PCT) {
            return true;
        }
        return false;
    }

}
