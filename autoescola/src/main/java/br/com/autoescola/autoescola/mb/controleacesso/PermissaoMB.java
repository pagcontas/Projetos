package br.com.autoescola.autoescola.mb.controleacesso;


import br.com.autoescola.autoescola.bo.controleacesso.PermissaoBO;
import br.com.autoescola.autoescola.modelo.controleacesso.Permissao;
import java.io.Serializable;
import com.xpert.core.crud.AbstractBaseBean;
import com.xpert.core.crud.AbstractBusinessObject;
import com.xpert.persistence.query.Restriction;
import java.util.List;
import javax.ejb.EJB;
import javax.faces.bean.ManagedBean;
import javax.faces.bean.ViewScoped;

/**
 *
 * @author Ayslan
 */
@ManagedBean
@ViewScoped
public class PermissaoMB extends AbstractBaseBean<Permissao> implements Serializable {

    @EJB
    private PermissaoBO permissaoBO;

    @Override
    public AbstractBusinessObject getBO() {
        return permissaoBO;
    }

    @Override
    public String getDataModelOrder() {
        return "descricao";
    }

    @Override
    public List<Restriction> getDataModelRestrictions() {
        return null;
    }
    
    
}
