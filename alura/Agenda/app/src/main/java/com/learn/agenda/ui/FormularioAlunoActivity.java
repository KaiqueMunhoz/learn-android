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
    private EditText campoNome;
    private EditText campoTelefone;
    private EditText campoEmail;
    private final AlunoDAO dao = new AlunoDAO();
    private int alunoId;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_formulario_aluno);
        setTitle("Novo aluno");
        inicializacaoDosCampos();
        final Intent intent = getIntent();

        if(intent.hasExtra("aluno")) {
            Aluno aluno = (Aluno) intent.getSerializableExtra("aluno");
            alunoId = aluno.getId();
            campoNome.setText(aluno.getNome());
            campoTelefone.setText(aluno.getTelefone());
            campoEmail.setText(aluno.getEmail());
        }

        configuraBotao();
    }

    private void configuraBotao() {
        final View botao = findViewById(R.id.activity_formulario_aluno_botao_salvar);
        botao.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                final Aluno aluno = novoAluno();
                novo(aluno);
            }
        });
    }

    private void novo(Aluno aluno) {
        if(alunoId != 0) {
            dao.edita(aluno, alunoId);
        } else {
            dao.salva(aluno);
        }
        finish();
    }

    private void inicializacaoDosCampos() {
        campoNome = findViewById(R.id.activity_formulario_aluno_nome);
        campoTelefone = findViewById(R.id.activity_formulario_aluno_telefone);
        campoEmail = findViewById(R.id.activity_formulario_aluno_email);
    }

    private Aluno novoAluno() {
        final String nome = campoNome.getText().toString();
        final String telefone = campoTelefone.getText().toString();
        final String email = campoEmail.getText().toString();

        return new Aluno(nome, telefone, email);
    }
}
