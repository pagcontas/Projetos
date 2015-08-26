package br.com.autoescola.autoescola.mb.cadastro;

import java.io.Serializable;
import com.xpert.core.crud.AbstractBaseBean;
import javax.ejb.EJB;
import javax.faces.bean.ManagedBean;
import javax.faces.bean.ViewScoped;
import br.com.autoescola.autoescola.bo.cadastro.AlunoBO;
import br.com.autoescola.autoescola.modelo.cadastro.Aluno;

/**
 *
 * @author killerbee
 */
@ManagedBean
@ViewScoped
public class AlunoMB extends AbstractBaseBean<Aluno> implements Serializable {

    @EJB
    private AlunoBO alunoBO;

    @Override
    public AlunoBO getBO() {
        return alunoBO;
    }

    @Override
    public String getDataModelOrder() {
        return "id";
    }

    @Override
    public void init() {
    }
}
