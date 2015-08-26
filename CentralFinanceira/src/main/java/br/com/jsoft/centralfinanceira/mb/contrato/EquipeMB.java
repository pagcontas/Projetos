package br.com.jsoft.centralfinanceira.mb.contrato;


import java.io.Serializable;
import com.xpert.core.crud.AbstractBaseBean;
import javax.ejb.EJB;
import javax.faces.bean.ManagedBean;
import javax.faces.bean.ViewScoped;
import br.com.jsoft.centralfinanceira.bo.contrato.EquipeBO;
import br.com.jsoft.centralfinanceira.modelo.contrato.Equipe;

/**
 *
 * @author Juniel
 */
@ManagedBean
@ViewScoped
public class EquipeMB extends AbstractBaseBean<Equipe> implements Serializable {

    @EJB
    private EquipeBO equipeBO;

    @Override
    public EquipeBO getBO() {
        return equipeBO;
    }

    @Override
    public String getDataModelOrder() {
        return "id";
    }

    @Override
    public void postSave() {
        setEntity(new Equipe());
    }
    
    
}
