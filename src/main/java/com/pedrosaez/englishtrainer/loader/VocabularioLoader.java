package com.pedrosaez.englishtrainer.loader;

import com.pedrosaez.englishtrainer.domain.entity.Vocabulario;
import com.pedrosaez.englishtrainer.domain.entity.enums.Dificultad;
import com.pedrosaez.englishtrainer.domain.entity.enums.Nivel;
import com.pedrosaez.englishtrainer.repository.VocabularioRepository;
import org.springframework.boot.CommandLineRunner;
import org.springframework.stereotype.Component;

import java.time.LocalDateTime;

@Component
public class VocabularioLoader implements CommandLineRunner {

    private final VocabularioRepository repository;

    public VocabularioLoader(VocabularioRepository repository) {
        this.repository = repository;
    }


    @Override
    public void run(String... args) throws Exception {
        cargar("apple", "manzana", "I eat an apple every day", Nivel.A1);
        cargar("confidence", "confianza", "Confidence comes with practice", Nivel.B1);
        cargar("challenge", "desafío", "This is a real challenge", Nivel.B1);

    }

    private void cargar(String palabra, String significado, String ejemplo, Nivel nivel) {
        if (!repository.existsByPalabra(palabra)) {
            repository.save(new Vocabulario(palabra, significado, ejemplo, nivel));
        }
    }
}
