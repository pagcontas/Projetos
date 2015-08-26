package br.com.autoescola.autoescola.bo.controleacesso;

import br.com.autoescola.autoescola.dao.controleacesso.PerfilDAO;
import br.com.autoescola.autoescola.dao.controleacesso.UsuarioDAO;
import br.com.autoescola.autoescola.modelo.controleacesso.Perfil;
import br.com.autoescola.autoescola.modelo.controleacesso.Usuario;
import br.com.autoescola.autoescola.util.SessaoUtils;
import com.xpert.core.crud.AbstractBusinessObject;
import com.xpert.persistence.dao.BaseDAO;
import com.xpert.core.validation.UniqueField;
import com.xpert.core.exception.BusinessException;
import com.xpert.core.validation.UniqueFields;
import java.util.List;
import javax.ejb.EJB;
import javax.ejb.Stateless;
import java.util.ArrayList;

/**
 *
 * @author #Author
 */
@Stateless
public class PerfilBO extends AbstractBusinessObject<Perfil> {

    @EJB
    private PerfilDAO perfilDAO;
    @EJB
    private UsuarioDAO usuarioDAO;

    @Override
    public BaseDAO getDAO() {
        return perfilDAO;
    }

    @Override
    public List<UniqueField> getUniqueFields() {
          return new UniqueFields().add("descricao");
    }

    @Override
    public void save(Perfil perfil) throws BusinessException {

        boolean novo = perfil.getId() == null;
        super.save(perfil);

        if (novo == true) {
            //adicionar o perfil ao usuario logado
            Usuario usuario = SessaoUtils.getUser();
            if (usuario != null) {
                usuario.getPerfis().add(perfil);
                usuarioDAO.merge(usuario);
            }
        }
    }

    @Override
    public void validate(Perfil perfil) throws BusinessException {
    }

    @Override
    public boolean isAudit() {
        return true;
    }
}
