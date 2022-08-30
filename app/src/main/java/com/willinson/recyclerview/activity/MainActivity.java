package com.willinson.recyclerview.activity;

import androidx.appcompat.app.AppCompatActivity;
import androidx.recyclerview.widget.DividerItemDecoration;
import androidx.recyclerview.widget.LinearLayoutManager;
import androidx.recyclerview.widget.RecyclerView;

import android.os.Bundle;
import android.view.View;
import android.widget.AdapterView;
import android.widget.LinearLayout;
import android.widget.Toast;

import com.willinson.recyclerview.R;
import com.willinson.recyclerview.RecyclerItemClickListener;
import com.willinson.recyclerview.adapter.Adapter;
import com.willinson.recyclerview.model.Filme;

import java.util.ArrayList;
import java.util.List;

public class MainActivity extends AppCompatActivity {

    private RecyclerView recyclerView;
    private List<Filme> listaFilmes = new ArrayList<>();

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        recyclerView = findViewById(R.id.recyclerView);

        //Listagem de itens
        this.criarFilmes();

        //Configurar Adapter
        Adapter adapter = new Adapter(listaFilmes);

        //Configurar RecyclerView
        RecyclerView.LayoutManager layoutManager = new LinearLayoutManager(getApplicationContext());
        recyclerView.setLayoutManager(layoutManager);
        recyclerView.setHasFixedSize(true);
        recyclerView.addItemDecoration(new DividerItemDecoration(this, LinearLayout.VERTICAL));
        recyclerView.setAdapter(adapter);

        //Evento de click
        recyclerView.addOnItemTouchListener(
            new RecyclerItemClickListener(
                    getApplicationContext(),
                    recyclerView,
                    new RecyclerItemClickListener.OnItemClickListener() {
                        @Override
                        public void onItemClick(View view, int position) {
                            Filme filme = listaFilmes.get(position);
                            Toast.makeText(getApplicationContext(), "Item selecionado: " + filme.getTituloFilme(),Toast.LENGTH_SHORT).show();
                        }

                        @Override
                        public void onLongItemClick(View view, int position) {
                            Filme filme = listaFilmes.get(position);
                            Toast.makeText(getApplicationContext(), "Click longo: " + filme.getTituloFilme(),Toast.LENGTH_SHORT).show();
                        }

                        @Override
                        public void onItemClick(AdapterView<?> parent, View view, int position, long id) {

                        }
                    }
            )
        );
    }

    public void criarFilmes(){

        Filme filme =  new Filme("Morbius", "Terror", "2022");
        this.listaFilmes.add(filme);

         filme =  new Filme("Homem de ferro", "Ação", "2008");
        this.listaFilmes.add(filme);

         filme =  new Filme("Thor", "Ação", "2011");
        this.listaFilmes.add(filme);

         filme =  new Filme("Doutor estranho", "Ação", "2016");
        this.listaFilmes.add(filme);

         filme =  new Filme("Deadpool", "Ação/Comédia", "2016");
        this.listaFilmes.add(filme);

         filme =  new Filme("Guardiões da galáxia", "Ação", "2014");
        this.listaFilmes.add(filme);

         filme =  new Filme("Venom", "Ação/Terror", "2018");
        this.listaFilmes.add(filme);

         filme =  new Filme("Homem-Aranha", "Ação", "2002");
        this.listaFilmes.add(filme);

         filme =  new Filme("Venom tempo de carnificina", "Ação/Terror", "2021");
        this.listaFilmes.add(filme);

         filme =  new Filme("Hulk", "Ação", "2003");
        this.listaFilmes.add(filme);

         filme =  new Filme("Logan", "Ação/Drama", "2017");
        this.listaFilmes.add(filme);

         filme =  new Filme("O justiceiro", "Ação", "2004");
        this.listaFilmes.add(filme);

         filme =  new Filme("Homem-Aranha 3", "Ação", "2007");
        this.listaFilmes.add(filme);
    }
}