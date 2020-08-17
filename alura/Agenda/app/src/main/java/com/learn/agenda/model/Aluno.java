package com.learn.agenda.model;

import androidx.annotation.NonNull;

import java.io.Serializable;

public class Aluno implements Serializable {

    private int id;
    private final String nome;
    private final String telefone;
    private final String email;

    public Aluno(String nome, String telefone, String email){
        this.nome = nome;
        this.telefone = telefone;
        this.email = email;
    }

    public int getId() {
        return id;
    }

    public String getNome() {
        return nome;
    }

    public String getTelefone() {
        return telefone;
    }

    public String getEmail() {
        return email;
    }

    @NonNull
    @Override
    public String toString() {
        return nome;
    }


    public void setId(int id) {
        this.id = id;
    }
}
