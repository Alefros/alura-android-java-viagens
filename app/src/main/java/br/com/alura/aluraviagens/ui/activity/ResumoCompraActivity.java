package br.com.alura.aluraviagens.ui.activity;

import android.content.Intent;
import android.graphics.drawable.Drawable;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;
import android.widget.ImageView;
import android.widget.TextView;

import java.io.Serializable;
import java.math.BigDecimal;

import br.com.alura.aluraviagens.R;
import br.com.alura.aluraviagens.model.Pacote;
import br.com.alura.aluraviagens.util.DataUtil;
import br.com.alura.aluraviagens.util.MoedaUtil;
import br.com.alura.aluraviagens.util.ResourcesUtil;

import static br.com.alura.aluraviagens.ui.activity.PacoteViagemConstantes.CHAVE_PACOTE;

public class ResumoCompraActivity extends AppCompatActivity {

    public static final String TITLE_APPBAR = "Resumo da Compra";

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_resumo_compra);

        setTitle(TITLE_APPBAR);
        carregaPacoteRecebido();
    }

    private void carregaPacoteRecebido() {
        Intent intent = getIntent();
        if (intent.hasExtra(CHAVE_PACOTE)) {
            Pacote pacote = (Pacote) intent.getSerializableExtra(CHAVE_PACOTE);
            carregaCampos(pacote);
        }
    }

    private void carregaCampos(Pacote pacote) {
        mostraImagem(pacote);
        mostraDestino(pacote);
        mostraPeriodo(pacote.getDias());
        mostraPreco(pacote.getPreco());
    }

    private void mostraPreco(BigDecimal precoPacote) {
        TextView preco = findViewById(R.id.resumo_compra_valor);
        String valorFormatado = MoedaUtil.formataMoedaParaReal(precoPacote);
        preco.setText(valorFormatado);
    }

    private void mostraPeriodo(int dias) {
        TextView perido = findViewById(R.id.resumo_compra_periodo);
        String periodoEmTexto = DataUtil.periodoEmTexto(dias);
        perido.setText(periodoEmTexto);
    }

    private void mostraDestino(Pacote pacote) {
        TextView destino = findViewById(R.id.resumo_compra_lugar);
        destino.setText(pacote.getLocal());
    }

    private void mostraImagem(Pacote pacote) {
        ImageView imagem = findViewById(R.id.resumo_compra_imagem_pacote);
        Drawable drawableImagemPacote = ResourcesUtil.devolveDrawable(this, pacote.getImagem());
        imagem.setImageDrawable(drawableImagemPacote);
    }
}