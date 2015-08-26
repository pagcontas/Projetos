package com.uparquivos.mb.padrao;

import com.uparquivos.constante.Constantes;
import javax.faces.bean.ManagedBean;

/**
 * class que retorna o valor das constantes
 *
 * @author Ayslan
 */
@ManagedBean
public class ConstantesMB {
    
    public int getMinutosRecuperacaoSenha(){
        return Constantes.MINUTOS_VALIDADE_RECUPERACAO_SENHA;
    }
    
}
