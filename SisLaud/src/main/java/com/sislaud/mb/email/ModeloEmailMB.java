package com.sislaud.mb.email;


import java.io.Serializable;
import com.xpert.core.crud.AbstractBaseBean;
import javax.ejb.EJB;
import javax.faces.bean.ManagedBean;
import javax.faces.bean.ViewScoped;
import com.sislaud.bo.email.ModeloEmailBO;
import com.sislaud.modelo.email.ModeloEmail;

/**
 *
 * @author ayslan
 */
@ManagedBean
@ViewScoped
public class ModeloEmailMB extends AbstractBaseBean<ModeloEmail> implements Serializable {

    @EJB
    private ModeloEmailBO modeloEmailBO;

    @Override
    public ModeloEmailBO getBO() {
        return modeloEmailBO;
    }

    @Override
    public String getDataModelOrder() {
        return "assunto";
    }
}
