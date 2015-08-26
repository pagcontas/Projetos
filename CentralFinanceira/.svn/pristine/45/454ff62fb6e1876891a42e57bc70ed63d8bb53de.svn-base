package br.com.jsoft.centralfinanceira.converters;


import javax.faces.component.UIComponent;
import javax.faces.context.FacesContext;
import javax.faces.convert.Converter;
import javax.faces.convert.FacesConverter;

/**
 *
 */
@FacesConverter(value = "inscricaoPiauiConverter")
public class InscricaoPiauiConverter implements Converter {

    public Object getAsObject(FacesContext fc, UIComponent uic, String string) {
        //remover mascara
        if (string != null && !string.isEmpty()) {
            return string.replace(".", "").replace("-", "");
        }
        return null;
    }

    public String getAsString(FacesContext fc, UIComponent uic, Object object) {
        if (object != null) {
            return mascaraInscricao(object.toString());
        }
        return null;
    }

    public static String mascaraInscricao(String inscricao) {
        if (inscricao == null) {
            return "";
        }
        if (inscricao.isEmpty()) {
            return "";
        }
        if (inscricao.length() < 9) {
            return inscricao;
        }
        return inscricao.substring(0, 2) + "." + inscricao.substring(2, 5) + "." + inscricao.substring(5, 8) + "-" + inscricao.substring(8, 9);
    }
}
	

