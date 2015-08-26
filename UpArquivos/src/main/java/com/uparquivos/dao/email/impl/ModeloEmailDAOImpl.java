package com.uparquivos.dao.email.impl;

import com.uparquivos.application.BaseDAOImpl;
import com.uparquivos.dao.email.ModeloEmailDAO;
import com.uparquivos.modelo.email.ModeloEmail;
import javax.ejb.Stateless;

/**
 *
 * @author ayslan
 */
@Stateless
public class ModeloEmailDAOImpl extends BaseDAOImpl<ModeloEmail> implements ModeloEmailDAO {

    @Override
    public Class getEntityClass() {
        return ModeloEmail.class;
    }

}
