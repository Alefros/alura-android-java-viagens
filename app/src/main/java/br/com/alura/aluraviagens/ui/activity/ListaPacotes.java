package br.com.alura.aluraviagens.ui.activity;

import android.content.Intent;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;
import android.widget.AdapterView;
import android.widget.ListView;

import java.util.List;

import br.com.alura.aluraviagens.R;
import br.com.alura.aluraviagens.dao.PacoteDAO;
import br.com.alura.aluraviagens.model.Pacote;
import br.com.alura.aluraviagens.ui.adapter.ListaPacoteAdapter;

import static br.com.alura.aluraviagens.ui.activity.PacoteViagemConstantes.CHAVE_PACOTE;

public class ListaPacotes extends AppCompatActivity {

    public static final String TITULO_APPBAR = "Pacotes";

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_lista_pacotes);

        setTitle(TITULO_APPBAR);
        configuraLista();

    }

    private void configuraLista() {
        final ListView listaDePacotes = findViewById(R.id.lista_pacotes_listview);
        List<Pacote> pacotes = new PacoteDAO().lista();
        listaDePacotes.setAdapter(new ListaPacoteAdapter(pacotes, this));

        listaDePacotes.setOnItemClickListener(new AdapterView.OnItemClickListener() {
            @Override
            public void onItemClick(AdapterView<?> parent, View view, int position, long id) {
                Pacote pacoteSelecionado = (Pacote) listaDePacotes.getItemAtPosition(position);
                vaiParaResumoPacote(pacoteSelecionado);
            }
        });

    }

    private void vaiParaResumoPacote(Pacote pacote) {
        Intent intent = new Intent(ListaPacotes.this, ResumoDoPacoteActivity.class);
        intent.putExtra(CHAVE_PACOTE, pacote);
        startActivity(intent);
    }
}