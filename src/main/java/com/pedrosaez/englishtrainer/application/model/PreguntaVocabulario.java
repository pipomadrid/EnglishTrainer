package com.pedrosaez.englishtrainer.application.model;

import java.util.List;

public class PreguntaVocabulario {

    private final String palabra;
    private final String significadoCorrecto;
    private final List<String> opciones;

    public PreguntaVocabulario(
            String palabra,
            String significadoCorrecto,
            List<String> opciones) {
        this.palabra = palabra;
        this.significadoCorrecto = significadoCorrecto;
        this.opciones = opciones;
    }

    public String getPalabra() {
        return palabra;
    }

    public String getSignificadoCorrecto() {
        return significadoCorrecto;
    }

    public List<String> getOpciones() {
        return opciones;
    }
}
