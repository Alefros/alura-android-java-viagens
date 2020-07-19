package br.com.alura.aluraviagens.ui.activity;

import android.content.Intent;
import android.graphics.drawable.Drawable;
import android.os.Bundle;
import android.support.v7.app.AppCompatActivity;
import android.view.View;
import android.widget.Button;
import android.widget.ImageView;
import android.widget.TextView;

import br.com.alura.aluraviagens.R;
import br.com.alura.aluraviagens.model.Pacote;
import br.com.alura.aluraviagens.util.DataUtil;
import br.com.alura.aluraviagens.util.DiasUtil;
import br.com.alura.aluraviagens.util.MoedaUtil;
import br.com.alura.aluraviagens.util.ResourcesUtil;

import static br.com.alura.aluraviagens.ui.activity.PacoteViagemConstantes.CHAVE_PACOTE;


public class ResumoDoPacoteActivity extends AppCompatActivity {

    public static final String TITULO_APPBAR = "Resumo do Pacote";

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_resumo_do_pacote);

        setTitle(TITULO_APPBAR);
        Intent intent = getIntent();
        carregaPacoteRecebido(intent);
    }

    private void carregaPacoteRecebido(Intent intent) {
        if (intent.hasExtra(CHAVE_PACOTE)) {
            final Pacote pacote = (Pacote) intent.getSerializableExtra(CHAVE_PACOTE);

            preencheCampos(pacote);
            configuraBotaoPagar(pacote);

        }
    }

    private void configuraBotaoPagar(final Pacote pacote) {
        Button botaoPagar = findViewById(R.id.resumo_pacote_botao_pagar);
        botaoPagar.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                chamaPagamento(pacote);
            }
        });
    }

    private void chamaPagamento(Pacote pacote) {
        Intent intent = new Intent(ResumoDoPacoteActivity.this, PagamentoActivity.class);
        intent.putExtra(CHAVE_PACOTE, pacote);
        startActivity(intent);
    }

    private void preencheCampos(Pacote pacote) {
        mostraLocal(pacote);
        mostraImagem(pacote);
        mostraDias(pacote.getDias());
        mostraValor(pacote);
        mostraPeriodo(pacote);
    }

    private void mostraPeriodo(Pacote pacote) {
        TextView periodoViagem = findViewById(R.id.resumo_pacote_periodo);
        String periodoFormatado = DataUtil.periodoEmTexto(pacote.getDias());
        periodoViagem.setText(periodoFormatado);
    }

    private void mostraValor(Pacote pacote) {
        TextView valor = findViewById(R.id.resumo_pacote_preco);
        String precoEmTexto = MoedaUtil.formataMoedaParaReal(pacote.getPreco());
        valor.setText(precoEmTexto);
    }

    private void mostraDias(int quantidadeDeDias) {
        TextView dias = findViewById(R.id.resumo_pacote_dias);
        String diasEmTexto = DiasUtil.formataDiasEmTexto(quantidadeDeDias);
        dias.setText(diasEmTexto);
    }

    private void mostraImagem(Pacote pacote) {
        ImageView imagem = findViewById(R.id.resumo_pacote_imagem);
        Drawable drawableDoPacote = ResourcesUtil.devolveDrawable(this, pacote.getImagem());
        imagem.setImageDrawable(drawableDoPacote);
    }

    private void mostraLocal(Pacote pacote) {
        TextView local = findViewById(R.id.resumo_pacote_local);
        local.setText(pacote.getLocal());
    }
}