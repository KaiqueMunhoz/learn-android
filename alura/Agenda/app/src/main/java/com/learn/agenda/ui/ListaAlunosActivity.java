package com.learn.agenda.ui;

import android.content.Intent;
import android.os.Bundle;
import android.util.Log;
import android.view.View;
import android.widget.AdapterView;
import android.widget.ArrayAdapter;
import android.widget.ListView;

import androidx.annotation.Nullable;
import androidx.appcompat.app.AppCompatActivity;

import com.google.android.material.floatingactionbutton.FloatingActionButton;
import com.learn.agenda.R;
import com.learn.agenda.dao.AlunoDAO;
import com.learn.agenda.model.Aluno;

import java.util.List;

public class ListaAlunosActivity extends AppCompatActivity {
    private final AlunoDAO dao = new AlunoDAO();

    @Override
    protected void onCreate(@Nullable Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_lista_alunos);
        setTitle("Lista de alunos");
        configuraFabNovoAluno();
        dao.salva(new Aluno("Kaique", "35988597863", "munhoz13km@gmail.com"));
    }

    private void configuraFabNovoAluno() {
        FloatingActionButton fabNovoAluno = findViewById(R.id.activity_lista_alunos_fab_novo_aluno);
        fabNovoAluno.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                abreFormularioAlunoActivity();
            }
        });
    }

    private void abreFormularioAlunoActivity() {
        startActivity(new Intent(this, FormularioAlunoActivity.class));
    }

    @Override
    protected void onResume() {
        super.onResume();
        configuraLista();
    }

    private void configuraLista() {
        final ListView listaDeAlunos = findViewById(R.id.activity_lista_alunos_list_view);
        final List<Aluno> lista = dao.todos();

        listaDeAlunos.setAdapter(new ArrayAdapter<>(this, android.R.layout.simple_list_item_1, dao.todos()));
        listaDeAlunos.setOnItemClickListener(new AdapterView.OnItemClickListener() {
            @Override
            public void onItemClick(AdapterView<?> adapterView, View view, int position, long l) {
                final Aluno aluno = lista.get(position);
                final Intent vaiParaFormularioAlunoActivity = new Intent(ListaAlunosActivity.this, FormularioAlunoActivity.class);
                vaiParaFormularioAlunoActivity.putExtra("aluno", aluno);
                startActivity(vaiParaFormularioAlunoActivity);
            }
        });
    }
}
