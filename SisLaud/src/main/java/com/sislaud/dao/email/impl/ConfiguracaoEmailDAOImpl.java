package com.sislaud.dao.email.impl;

import com.sislaud.application.BaseDAOImpl;
import com.sislaud.dao.email.ConfiguracaoEmailDAO;
import com.sislaud.modelo.email.ConfiguracaoEmail;
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
