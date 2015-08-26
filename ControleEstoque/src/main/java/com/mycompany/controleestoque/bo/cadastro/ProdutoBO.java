package com.mycompany.controleestoque.bo.cadastro;

import com.xpert.core.crud.AbstractBusinessObject;
import com.mycompany.controleestoque.dao.cadastro.ProdutoDAO;
import com.mycompany.controleestoque.dao.faturamento.EstoqueDAO;
import com.xpert.core.validation.UniqueField;
import com.xpert.core.exception.BusinessException;
import java.util.List;
import javax.ejb.EJB;
import javax.ejb.Stateless;
import com.mycompany.controleestoque.modelo.cadastro.Produto;
import com.mycompany.controleestoque.modelo.faturamento.Estoque;
import com.xpert.core.validation.UniqueFields;
import com.xpert.persistence.utils.EntityUtils;
import java.math.BigDecimal;

/**
 *
 * @author juniel
 */
@Stateless
public class ProdutoBO extends AbstractBusinessObject<Produto> {

    @EJB
    private ProdutoDAO produtoDAO;

    @EJB
    private EstoqueDAO estoqueDAO;

    @Override
    public ProdutoDAO getDAO() {
        return produtoDAO;
    }

    @Override
    public List<UniqueField> getUniqueFields() {
        return new UniqueFields().add("descricao", "empresa", "fabricante").add("codigoDeBarra", "empresa");
    }

    @Override
    public void validate(Produto produto) throws BusinessException {
    }

    @Override
    public boolean isAudit() {
        return true;
    }

    @Override
    public void save(Produto produto) throws BusinessException {
        boolean novo = produto.getId() == null;
        Estoque estoque = new Estoque();
        estoque.setEmpresa(produto.getEmpresa());
        estoque.setProduto(produto);
        estoque.setAtivo(true);
        estoque.setQtdMinima(BigDecimal.ZERO);
        estoque.setQuantidade(BigDecimal.ZERO);

        if (produto.isProdutoFracionado()) {
            estoque.setUnidadeDeVenda(produto.getUnidadeDeFracao());
        } else {
            estoque.setUnidadeDeVenda(produto.getUnidadeDeVenda());
        }

        validate(produto);
        if (produto.getCodigoDeBarra() != null && produto.getCodigoDeBarra().isEmpty() && !produto.getCodigoDeBarra().equals("")) {
            validateUniqueFields(produto);
        }
        if (!EntityUtils.isPersisted(produto)) {
            getDAO().save(produto, isAudit());
            if (novo) {
                estoqueDAO.saveOrMerge(estoque);
            }
        } else {
            getDAO().merge(produto, isAudit());
            if (novo) {
                estoqueDAO.saveOrMerge(estoque);
            }
        }
    }

}
