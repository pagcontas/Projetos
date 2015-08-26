/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package br.com.jsoft.centralfinanceira.ClassesComparator;

import br.com.jsoft.centralfinanceira.modelo.central.Cidade;
import java.text.Normalizer;
import java.util.Comparator;

/**
 *
 * @author KillerBeeTwo
 */
public class CidadeComparadaPorNome implements Comparator<Cidade> {

    @Override
    public int compare(Cidade cidade1, Cidade cidade2) {
        return removeAcentos(cidade1.getNome()).compareTo(removeAcentos(cidade2.getNome()));
    }

    public String removeAcentos(String str) {

        str = Normalizer.normalize(str, Normalizer.Form.NFD);
        str = str.replaceAll("[^\\p{ASCII}]", "");
        return str;

    }
}
