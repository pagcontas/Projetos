package com.uparquivos.dao.email.impl;

import com.uparquivos.application.BaseDAOImpl;
import com.uparquivos.dao.email.ConfiguracaoEmailDAO;
import com.uparquivos.modelo.email.ConfiguracaoEmail;
import javax.ejb.Stateless;

/**
 *
 * @author ayslan
 */
@Stateless
public class ConfiguracaoEmailDAOImpl extends BaseDAOImpl<ConfiguracaoEmail> implements ConfiguracaoEmailDAO {

    @Override
    public Class getEntityClass() {
        return ConfiguracaoEmail.class;
    }
}
