package com.sislaud.mb.exemplo;


import java.io.Serializable;
import com.xpert.core.crud.AbstractBaseBean;
import javax.ejb.EJB;
import javax.faces.bean.ManagedBean;
import javax.faces.bean.ViewScoped;
import com.sislaud.bo.exemplo.PessoaExemploBO;
import com.sislaud.modelo.exemplo.PessoaExemplo;

/**
 *
 * @author Ayslan
 */
@ManagedBean
@ViewScoped
public class PessoaExemploMB extends AbstractBaseBean<PessoaExemplo> implements Serializable {

    @EJB
    private PessoaExemploBO pessoaExemploBO;

    @Override
    public PessoaExemploBO getBO() {
        return pessoaExemploBO;
    }

    @Override
    public String getDataModelOrder() {
        return "id";
    }
}
