package br.com.alura.aluraviagens.util;

import java.text.SimpleDateFormat;
import java.util.Calendar;

public class DataUtil {

    public static final String FORMATO_DATA = "dd/MM";

    public static String periodoEmTexto(int quantidadeDeDias) {
        Calendar dataIda = Calendar.getInstance();
        Calendar dataVolta = Calendar.getInstance();
        dataVolta.add(Calendar.DATE, quantidadeDeDias);
        SimpleDateFormat formatadorDeData = new SimpleDateFormat(FORMATO_DATA);
        String dataIdaFormatada = formatadorDeData.format(dataIda.getTime());
        String dataVoltaFormatada = formatadorDeData.format(dataVolta.getTime());
        return dataIdaFormatada + " - " +
                dataVoltaFormatada + " de " +
                dataVolta.get(Calendar.YEAR);
    }

}
