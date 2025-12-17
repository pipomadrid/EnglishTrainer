package com.pedrosaez.englishtrainer.domain.entity;


import com.pedrosaez.englishtrainer.domain.entity.enums.Dificultad;
import com.pedrosaez.englishtrainer.domain.entity.enums.Nivel;
import jakarta.persistence.*;

import java.time.LocalDateTime;

@Entity
@Table(name = "vocabulario")
public class Vocabulario {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    @Column(length = 100,nullable = false)
    private String palabra;

    @Column(length = 255,nullable = false)
    private String significado;

    private String ejemplo;

    private String notas;

    @Column(nullable = false)
    @Enumerated(EnumType.STRING)
    private Dificultad  dificultad;


    @Column(nullable = false)
    @Enumerated(EnumType.STRING)
    private Nivel nivel;

    @Column(nullable = false, updatable = false)
    private LocalDateTime creado;



    public Vocabulario(){

    }
    public Vocabulario(String palabra, String significado, String ejemplo, Nivel nivel ) {
        this.palabra = palabra;
        this.significado = significado;
        this.ejemplo = ejemplo;
        this.notas = "";
        this.dificultad = Dificultad.MEDIUM;
        this.nivel = nivel;
    }

    @PrePersist
    protected void onCreate() {
        this.creado = LocalDateTime.now();
    }


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

    public Dificultad getDificultad() {
        return dificultad;
    }

    public void setDificultad(Dificultad dificultad) {
        this.dificultad = dificultad;
    }

    public LocalDateTime getCreado() {
        return creado;
    }

    public void setCreado(LocalDateTime creado) {
        this.creado = creado;
    }

    public Long getId() {
        return id;
    }

    public void setId(Long id) {
        this.id = id;
    }
    public Nivel getNivel() {
        return nivel;
    }

    public void setNivel(Nivel nivel) {
        this.nivel = nivel;
    }

}
