package com.pedrosaez.englishtrainer.model;

public class Vocabulario {

    public Vocabulario(){

    }
    public Vocabulario(String palabra, String significado, String ejemplo, String notas, int dificultad, String creado) {
        this.palabra = palabra;
        this.significado = significado;
        this.ejemplo = ejemplo;
        this.notas = notas;
        this.dificultad = dificultad;
        this.creado = creado;
    }

    private int id;
    private String palabra;
    private String significado;
    private String ejemplo;
    private String notas;
    private int dificultad;
    private String creado;


    public String getPalabra() {
        return palabra;
    }

    public void setPalabra(String palabra) {
        this.palabra = palabra;
    }

    public String getSignificado() {
        return significado;
    }

    public void setSignificado(String significado) {
        this.significado = significado;
    }

    public String getEjemplo() {
        return ejemplo;
    }

    public void setEjemplo(String ejemplo) {
        this.ejemplo = ejemplo;
    }

    public String getNotas() {
        return notas;
    }

    public void setNotas(String notas) {
        this.notas = notas;
    }

    public int getDificultad() {
        return dificultad;
    }

    public void setDificultad(int dificultad) {
        this.dificultad = dificultad;
    }

    public String getCreado() {
        return creado;
    }

    public void setCreado(String creado) {
        this.creado = creado;
    }




    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }
}
