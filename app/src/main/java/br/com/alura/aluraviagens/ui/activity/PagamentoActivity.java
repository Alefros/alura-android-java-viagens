package br.com.alura.aluraviagens.ui.activity;

import android.content.Intent;
import android.os.Bundle;
import android.support.v7.app.AppCompatActivity;
import android.view.View;
import android.widget.Button;
import android.widget.TextView;

import br.com.alura.aluraviagens.R;
import br.com.alura.aluraviagens.model.Pacote;
import br.com.alura.aluraviagens.util.MoedaUtil;

import static br.com.alura.aluraviagens.ui.activity.PacoteViagemConstantes.CHAVE_PACOTE;

public class PagamentoActivity extends AppCompatActivity {

    public static final String TITULO_APPBAR = "Pagamento";

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_pagamento);

        setTitle(TITULO_APPBAR);
        carregaDadosRecebidos();
    }

    private void carregaDadosRecebidos() {
        Intent intent = getIntent();
        if (intent.hasExtra(CHAVE_PACOTE)) {

            final Pacote pacote = (Pacote) intent.getSerializableExtra(CHAVE_PACOTE);

            mostraPreco(pacote);
            configuraBotaoFinalizar(pacote);
        }
    }

    private void configuraBotaoFinalizar(final Pacote pacote) {
        Button botaoFinalizar = findViewById(R.id.pagamento_finalizar);
        botaoFinalizar.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                chamaActivityResumo(pacote);
            }
        });
    }

    private void chamaActivityResumo(Pacote pacote) {
        Intent intent = new Intent(PagamentoActivity.this, ResumoCompraActivity.class);
        intent.putExtra(CHAVE_PACOTE, pacote);
        startActivity(intent);
    }

    private void mostraPreco(Pacote pacote) {
        TextView preco = findViewById(R.id.pagamento_montante);
        String precoFormatado = MoedaUtil.formataMoedaParaReal(pacote.getPreco());
        preco.setText(precoFormatado);
    }
}