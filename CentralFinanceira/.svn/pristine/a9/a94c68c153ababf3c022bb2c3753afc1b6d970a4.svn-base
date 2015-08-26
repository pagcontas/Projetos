package br.com.jsoft.centralfinanceira.mb.central;

import java.io.Serializable;
import com.xpert.core.crud.AbstractBaseBean;
import javax.ejb.EJB;
import javax.faces.bean.ManagedBean;
import javax.faces.bean.ViewScoped;
import br.com.jsoft.centralfinanceira.bo.central.LojaBO;
import br.com.jsoft.centralfinanceira.dao.central.LojaDAO;
import br.com.jsoft.centralfinanceira.modelo.central.Loja;
import java.util.List;

/**
 *
 * @author Juniel
 */
@ManagedBean
@ViewScoped
public class LojaMB extends AbstractBaseBean<Loja> implements Serializable {

    @EJB
    private LojaBO lojaBO;

    @EJB

    private LojaDAO lojaDAO;

    @Override
    public LojaBO getBO() {
        return lojaBO;
    }

    @Override
    public String getDataModelOrder() {
        return "id";
    }

    public List<Loja> consultarLoja(String nome) {

        if (nome != null && !nome.isEmpty()) {

            return lojaDAO.getLojaPorNome(nome);

        }

        return null;

    }

    @Override
    public void postSave() {
        setEntity(new Loja());
    }
    
}
