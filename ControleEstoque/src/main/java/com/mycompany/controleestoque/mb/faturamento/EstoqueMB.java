package com.mycompany.controleestoque.mb.faturamento;

import java.io.Serializable;
import com.xpert.core.crud.AbstractBaseBean;
import javax.ejb.EJB;
import javax.faces.bean.ManagedBean;
import javax.faces.bean.ViewScoped;
import com.mycompany.controleestoque.bo.faturamento.EstoqueBO;
import com.mycompany.controleestoque.modelo.cadastro.enums.UnidadeDeMedida;
import com.mycompany.controleestoque.modelo.faturamento.Estoque;
import com.xpert.faces.utils.FacesUtils;
import java.util.ArrayList;
import java.util.List;

/**
 *
 * @author juniel
 */
@ManagedBean
@ViewScoped
public class EstoqueMB extends AbstractBaseBean<Estoque> implements Serializable {

    @EJB
    private EstoqueBO estoqueBO;

    private List<UnidadeDeMedida> listUnidade;

    public List<UnidadeDeMedida> getListUnidade() {
        return listUnidade;
    }

    public void setListUnidade(List<UnidadeDeMedida> listUnidade) {
        this.listUnidade = listUnidade;
    }

    @Override
    public EstoqueBO getBO() {
        return estoqueBO;
    }

    @Override
    public String getDataModelOrder() {
        return "id";
    }

    @Override
    public void init() {
    }

    public List<UnidadeDeMedida> getUnidadeProduto() {
        List<UnidadeDeMedida> lista = new ArrayList<UnidadeDeMedida>();

        if (getEntity().getProduto() != null) {
            if (getEntity().getProduto().getUnidadeDeFracao() != null) {
                lista.add(getEntity().getProduto().getUnidadeDeFracao());
            }
            lista.add(getEntity().getProduto().getUnidadeDeVenda());
        }

        return lista;

    }

    public boolean verificarCampoFracao() {
        boolean retorno = false;
        switch (getEntity().getUnidadeDeVenda()!= null ? getEntity().getUnidadeDeVenda().getNum() : 0) {
            case 0:
                retorno= false;
                break;
            case 1:
                retorno= true;
                break;
            case 2:
                retorno= true;
                break;
            case 5:
                retorno= true;
                break;
            case 6:
                retorno= true;
                break;
            case 8:
                retorno= true;
                break;
        }
        return retorno;

    }
    
    @Override
    public void postSave() {
        if (getId() != null) {
            FacesUtils.redirect("/view/faturamento/estoque/listEstoque.jsf");
        } else {
            setEntity(new Estoque());
        }
    }
}
