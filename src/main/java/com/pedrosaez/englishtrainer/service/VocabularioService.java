package com.pedrosaez.englishtrainer.service;

import com.pedrosaez.englishtrainer.domain.entity.Vocabulario;
import com.pedrosaez.englishtrainer.repository.VocabularioRepository;
import org.springframework.data.domain.PageRequest;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Random;

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

    public Vocabulario obtenerPalabraAleatoria() {
        List<Vocabulario> lista = repository.findRandom(PageRequest.of(0, 1));
        return lista.isEmpty() ? null : lista.getFirst();
    }
}
