package com.learn.agenda.dao;

import com.learn.agenda.model.Aluno;

import java.util.ArrayList;
import java.util.List;

public class AlunoDAO {

    private final static List<Aluno> listaDeAlunos = new ArrayList<>();
    private static int contadorId = 1;

    public void salva(Aluno aluno) {
        aluno.setId(contadorId);
        listaDeAlunos.add(aluno);
        contadorId = contadorId + 1;
    }

    public void edita(Aluno aluno, int id) {
        for (Aluno a: listaDeAlunos) {
            if(a.getId() == id) {
                aluno.setId(id);
                final int position = listaDeAlunos.indexOf(a);
                listaDeAlunos.set(position, aluno);
            }
        }
    }

    public List<Aluno> todos() {
        return new ArrayList<>(listaDeAlunos);
    }
}
