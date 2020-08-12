package com.learn.agenda.ui;

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

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_formulario_aluno);
        setTitle("Novo aluno");
        inicializacaoDosCampos();
        configuraBotaoSalvar();
    }

    private void configuraBotaoSalvar() {
        final View botao = findViewById(R.id.activity_formulario_aluno_botao_salvar);
        botao.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                final Aluno aluno = criaAluno();
                salva(aluno);
            }
        });
    }

    private void salva(Aluno aluno) {
        dao.salva(aluno);
        finish();
    }

    private void inicializacaoDosCampos() {
        campoNome = findViewById(R.id.activity_formulario_aluno_nome);
        campoTelefone = findViewById(R.id.activity_formulario_aluno_telefone);
        campoEmail = findViewById(R.id.activity_formulario_aluno_email);
    }

    private Aluno criaAluno() {
        final String nome = campoNome.getText().toString();
        final String telefone = campoTelefone.getText().toString();
        final String email = campoEmail.getText().toString();

        return new Aluno(nome, telefone, email);
    }
}
