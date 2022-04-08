package com.mobileexercicio.agendacontatos;

import android.database.sqlite.SQLiteOpenHelper;

import java.io.Serializable;

public class Pessoa implements Serializable {

    private int id;
    private String nome;
    private String celular;
    private String endereco;
    private String email;

    public Pessoa() {
        this.id = 0;
        this.nome = "";
        this.celular = "";
        this.endereco = "";
        this.email = "";
    }

    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }

    public String getNome() {
        return nome;
    }

    public void setNome(String nome) {
        this.nome = nome;
    }

    public String getCelular() {
        return celular;
    }

    public void setCelular(String celular) {
        this.celular = celular;
    }

    public String getEndereco() {
        return endereco;
    }

    public void setEndereco(String endereço) {
        this.endereco = endereco;
    }

    public String getEmail() {
        return email;
    }

    public void setEmail(String email) {
        this.email = email;
    }
}
