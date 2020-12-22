package com.learn.agenda.dao;

import com.learn.agenda.model.Aluno;

import java.util.ArrayList;
import java.util.List;

public class AlunoDAO {

    private final static List<Aluno> alunos = new ArrayList<>();
    private static int contadorId = 1;

    public void salva(Aluno aluno) {
        aluno.setId(contadorId);
        alunos.add(aluno);
        contadorId = contadorId + 1;
    }

    public void edita(Aluno alunoModificado, int id) {
        for (Aluno aluno: alunos) {
            if(aluno.hasId()) {
                alunoModificado.setId(id);
                final int position = alunos.indexOf(aluno);
                alunos.set(position, alunoModificado);
            }
        }
    }

    public List<Aluno> todos() {
        return new ArrayList<>(alunos);
    }
}
