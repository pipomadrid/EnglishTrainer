package com.pedrosaez.englishtrainer.domain.service;

import com.pedrosaez.englishtrainer.application.model.PreguntaVocabulario;
import com.pedrosaez.englishtrainer.domain.entity.Vocabulario;
import com.pedrosaez.englishtrainer.domain.repository.VocabularioRepository;
import org.springframework.data.domain.PageRequest;
import org.springframework.stereotype.Service;

import java.util.ArrayList;
import java.util.Collections;
import java.util.List;
import java.util.Optional;

@Service
public class VocabularioService {

    private final VocabularioRepository repository;

    public VocabularioService(VocabularioRepository repository) {
        this.repository = repository;
    }

    public Vocabulario guardar(Vocabulario vocabulario){
        if (repository.existsByPalabra(vocabulario.getPalabra())) {
            throw new IllegalArgumentException("La palabra ya existe");
        }
        return repository.save(vocabulario);
    }

    public Optional<Vocabulario> obtenerPalabraAleatoria() {
        return repository.findRandom(PageRequest.of(0, 1))
                .stream()
                .findFirst();
    }



    public Optional<PreguntaVocabulario> generarPregunta(){

        Optional<Vocabulario> respuestaCorrectaOpt = obtenerPalabraAleatoria();
        if(respuestaCorrectaOpt.isEmpty()){
            return Optional.empty();
        }
        Vocabulario respuestaCorrecta = respuestaCorrectaOpt.get();


        List<Vocabulario> incorrectas =
                repository.findRandomExcluding(
                        respuestaCorrecta.getId(),
                        PageRequest.of(0, 3)
                );

        List<String> opciones = new ArrayList<>();
        opciones.add(respuestaCorrecta.getSignificado());
        incorrectas.forEach(v -> opciones.add(v.getSignificado()));
        Collections.shuffle(opciones);
        return Optional.of(
                new PreguntaVocabulario(
                        respuestaCorrecta.getPalabra(),
                        respuestaCorrecta.getSignificado(),
                        opciones
                )
        );
    }
}
