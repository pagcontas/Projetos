package com.sislaud.dao.email.impl;

import com.sislaud.application.BaseDAOImpl;
import com.sislaud.dao.email.ModeloEmailDAO;
import com.sislaud.modelo.email.ModeloEmail;
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
