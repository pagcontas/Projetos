package br.com.jsoft.centralfinanceira.mb.contrato;

import java.io.Serializable;
import com.xpert.core.crud.AbstractBaseBean;
import javax.ejb.EJB;
import javax.faces.bean.ManagedBean;
import javax.faces.bean.ViewScoped;
import br.com.jsoft.centralfinanceira.bo.contrato.EnderecoBO;
import br.com.jsoft.centralfinanceira.modelo.contrato.Endereco;

/**
 *
 * @author KillerBeeTwo
 */
@ManagedBean
@ViewScoped
public class EnderecoMB extends AbstractBaseBean<Endereco> implements Serializable {
    
    @EJB
    private EnderecoBO enderecoBO;
    
    @Override
    public EnderecoBO getBO() {
        return enderecoBO;
    }
    
    @Override
    public String getDataModelOrder() {
        return "id";
    }
    
    @Override
    public void postSave() {
        setEntity(new Endereco());
    }
    
}
