package br.com.alura.aluraviagens.util;

import android.support.annotation.NonNull;

public class DiasUtil {

    public static final String PLURAL = " dias";
    public static final String SINGULAR = " dia";

    @NonNull
    public static String formataDiasEmTexto(int quantidadeDeDias) {

        if(quantidadeDeDias > 1){
            return quantidadeDeDias + PLURAL;
        }else{
            return quantidadeDeDias + SINGULAR;
        }

    }



}
