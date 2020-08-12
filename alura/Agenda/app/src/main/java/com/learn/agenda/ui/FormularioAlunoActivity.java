package com.learn.agenda.ui;


import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.EditText;

import androidx.appcompat.app.AppCompatActivity;

import com.learn.agenda.R;
import com.learn.agenda.dao.AlunoDAO;
import com.learn.agenda.model.Aluno;

public class FormularioAlunoActivity extends AppCompatActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_formulario_aluno);
        final AlunoDAO dao = new AlunoDAO();

        final EditText campoNome = findViewById(R.id.activity_formulario_aluno_nome);
        final EditText campoTelefone = findViewById(R.id.activity_formulario_aluno_telefone);
        final EditText campoEmail = findViewById(R.id.activity_formulario_aluno_email);

        final View botao = findViewById(R.id.activity_formulario_aluno_botao_salvar);
        botao.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                final String nome = campoNome.getText().toString();
                final String telefone = campoTelefone.getText().toString();
                final String email = campoEmail.getText().toString();

                final Aluno aluno = new Aluno(nome, telefone, email);
                dao.salva(aluno);
                startActivity(new Intent(FormularioAlunoActivity.this, ListaAlunosActivity.class) );
            }
        });

    }
}
