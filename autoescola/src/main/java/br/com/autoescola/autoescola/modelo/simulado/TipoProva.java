/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package br.com.autoescola.autoescola.modelo.simulado;

/**
 *
 * @author killerbee
 */
public enum TipoProva {
    
    
    LEGISLACAO("Legislação de Trânsito"),
    REGRASCIRCULACAO("Regras de Circulação"),
    MECANICA("Mecânica de Veículos"),
    MEIOAMBIENTE("Meio Ambiente e Cidadania"),
    SINALIZACAO("Sinalização"),
    DIRECAODEFENSIVA("Direção Defensiva"),
    INFRACAO("Infração"), 
    PRIMEIROSOCORROS("Noções de Primeiros Socorros");

    private TipoProva(String descricao) {
        this.descricao = descricao;
    }
    private String descricao;

    public String getDescricao() {
        return descricao;
    }
    
}
