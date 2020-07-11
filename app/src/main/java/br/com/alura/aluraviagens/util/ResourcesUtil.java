package br.com.alura.aluraviagens.util;

import android.content.Context;
import android.content.res.Resources;
import android.graphics.drawable.Drawable;

public class ResourcesUtil {

    public static final String DRAWABLE = "drawable";

    public static Drawable devolveDrawable(Context context, String drawableEmTexto) {
        Resources resources = context.getResources();
        int idDoDrawble = resources.getIdentifier(drawableEmTexto,
                DRAWABLE, context.getOpPackageName());
        return resources.getDrawable(idDoDrawble);
    }

}
