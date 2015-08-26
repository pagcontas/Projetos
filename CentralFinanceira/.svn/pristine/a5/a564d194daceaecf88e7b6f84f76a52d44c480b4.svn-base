/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package br.com.jsoft.centralfinanceira.converters;

import javax.faces.component.UIComponent;
import javax.faces.context.FacesContext;
import javax.faces.convert.Converter;
import javax.faces.convert.FacesConverter;

/**
 *
 * @author killerbee
 */
@FacesConverter(value = "periodoConverterUpdate")
public class PeriodoConverterUpdate implements Converter {

    @Override
    public Object getAsObject(FacesContext context, UIComponent component, String value) {
        String[] temp = value.split("/");
        Integer periodo = Integer.valueOf(temp[1] + temp[0]);
        return periodo;
    }

    @Override
    public String getAsString(FacesContext context, UIComponent component, Object value) {
        if (value == null) {
            return "";
        }
        Integer valor = (Integer) value;
        return getMes(valor) + "/" + getAno(valor);
    }

    private String getMes(Integer periodo) {
        String str = periodo.toString();
        return str.substring(4, 6);
    }

    private String getAno(Integer periodo) {
        String str = periodo.toString();
        return str.substring(0, 4);
    }   
}
