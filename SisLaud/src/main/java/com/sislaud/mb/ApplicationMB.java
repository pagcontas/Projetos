package com.sislaud.mb;

import com.sislaud.GeracaoDadosSistema;
import com.sislaud.GeracaoPermissao;
import javax.annotation.PostConstruct;
import javax.ejb.EJB;
import javax.faces.bean.ApplicationScoped;
import javax.faces.bean.ManagedBean;

/**
 *
 * @author ayslan
 */
@ManagedBean(eager = true)
@ApplicationScoped
public class ApplicationMB {

    @EJB
    private GeracaoDadosSistema geracaoDadosSistema;

    @PostConstruct
    public void init() {
        //gerar permissoes ao iniciar aplicacao
        geracaoDadosSistema.generate();
    }
}
