package com.mycompany.controleestoque.mb.padrao;

import com.mycompany.controleestoque.modelo.cadastro.Cidade;
import com.mycompany.controleestoque.modelo.cadastro.Estado;
import com.mycompany.controleestoque.modelo.cadastro.Pais;
import com.mycompany.controleestoque.modelo.cadastro.Produto;
import com.mycompany.controleestoque.modelo.controleacesso.Perfil;
import com.mycompany.controleestoque.modelo.controleacesso.Permissao;
import com.mycompany.controleestoque.modelo.controleacesso.SituacaoUsuario;
import com.mycompany.controleestoque.modelo.controleacesso.Usuario;
import com.mycompany.controleestoque.modelo.email.TipoAssuntoEmail;
import com.xpert.faces.bean.ClassModel;
import com.xpert.persistence.query.Restriction;
import java.util.HashMap;
import java.util.List;
import java.util.Map;
import javax.faces.bean.ManagedBean;
import javax.faces.bean.ViewScoped;

/**
 *
 * @author
 */
@ManagedBean
@ViewScoped
public class FindAllBean extends com.xpert.faces.bean.FindAllBean {

    private static final Map<Class, ClassModel> MODEL = new HashMap<Class, ClassModel>();

    static {
        put(Permissao.class, "descricao");
        put(Perfil.class, "descricao");
        put(Usuario.class, "nome");
        put(SituacaoUsuario.class, "descricao");
        put(TipoAssuntoEmail.class, "descricao");
        put(Produto.class, "descricao");
        put(Cidade.class, "nome");
        put(Estado.class, "nome");
        put(Pais.class, "nome");
    }

    public static void put(Class entity, String order) {
        MODEL.put(entity, new ClassModel(order));
    }

    public static void put(Class entity, Restriction restriction, String order) {
        MODEL.put(entity, new ClassModel(order, restriction, order));
    }

    public static void put(Class entity, List<Restriction> restrictions, String order) {
        MODEL.put(entity, new ClassModel(order, restrictions, order));
    }

    @Override
    public Map<Class, ClassModel> getClassModel() {
        return MODEL;
    }
}
