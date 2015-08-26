/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package br.com.jsoft.centralfinanceira;

import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.util.Calendar;
import java.util.Date;
import javax.swing.text.MaskFormatter;

/**
 *
 * @author KillerBeeTwo
 */
public class MetodoUtilitario {
     //Retorna o nome completo do mes (exe Janeiro) ou os tres primeiros digito do mes (exe Jan)
    public String nomeDoMes(int i, int tipo) {
        String mes[] = {"Janeiro", "Fevereiro", "Março", "Abril",
            "Maio", "Junho", "Julho", "Agosto", "Setembro", "Outubro",
            "Novembro", "Dezembro"};
        // Java é uma linguagem com vetores zero-based: as posições do vetor
        // iniciam a numeração a partir do valor 0 (0-janeiro, 1-fevereiro, ...)
        if (tipo == 0) {
            return (mes[i - 1]); // extenso
        }// o método "substring" retorna os 3 primeiros caracteres de "mes[i-1]"
        else {
            return (mes[i - 1].substring(0, 3)); // abreviado
        }
    }

// Retorna o dia da semana.
// Parâmetros: "i" = índice para o vetor "diasem"
//             "tipo" = 0 para retornar o nome completo e
//                      1 para o nome abreviado do dia da semana.
    public String diaDaSemana(int i, int tipo) {
        String diasem[] = {"domingo", "segunda-feira", "terça-feira",
            "quarta-feira", "quinta-feira", "sexta-feira", "sábado"};
        if (tipo == 0) {
            return (diasem[i - 1]); // extenso
        }// o método "substring" retorna os 3 primeiros caracteres de "diasem[i]"
        else {
            return (diasem[i - 1].substring(0, 3));
        }
    }

    // Retorna a data por extenso.
    // Parâmetros: "cidade" = nome da cidade; e, "dt" = data.
    public String dataPorExtenso(String cidade, Date dt) {
        // retorna os valores ano, mês e dia da variável "dt"

        if (dt == null) {
            return null;
        }

        Calendar c = Calendar.getInstance();
        c.setTime(dt);
        int d = c.get(Calendar.DAY_OF_MONTH);
        int m = c.get(Calendar.MONTH) + 1;
        int a = c.get(Calendar.YEAR);

        // retorna o dia da semana: 1=domingo, 2=segunda-feira, ..., 7=sábado
        //Calendar data = new GregorianCalendar(a, m - 1, d);
        //int ds = data.get(Calendar.DAY_OF_WEEK);
        return (cidade + ", " + d + " de " + nomeDoMes(m, 0) + " de " + a);
    }

    //Retorna uma data em string exemplo 07/08/1984 ou 1984/08/07 ou 13:30:22
    public String convertDateToString(Date date, int tipo) {
        SimpleDateFormat formataData = null;
        if (tipo == 1) {
            formataData = new SimpleDateFormat("dd/MM/yyyy");
        }

        if (tipo == 2) {
            formataData = new SimpleDateFormat("yyyy-MM-dd");
        }

        if (tipo == 3) {
            formataData = new SimpleDateFormat("HH:mm:ss");
        }

        String data = formataData.format(date);

        return data;
    }
    
    private static String format(String pattern, Object value) {
        MaskFormatter mask;
        try {
            mask = new MaskFormatter(pattern);
            mask.setValueContainsLiteralCharacters(false);
            return mask.valueToString(value);
        } catch (ParseException e) {
            throw new RuntimeException(e);
        }
    }

}
