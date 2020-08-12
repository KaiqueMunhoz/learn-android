package com.learn.agenda.dao;

import com.learn.agenda.model.Aluno;

import java.util.ArrayList;
import java.util.List;

public class AlunoDAO {

    private final static List<Aluno> listaDeAlunos = new ArrayList<>();

    public void salva(Aluno aluno) {
        listaDeAlunos.add(aluno);
    }

    public List<Aluno> todos() {
        return new ArrayList<>(listaDeAlunos);
    }
}
