package com.pedrosaez.englishtrainer.loader;

import com.pedrosaez.englishtrainer.domain.entity.Vocabulario;
import com.pedrosaez.englishtrainer.domain.enums.Categoria;
import com.pedrosaez.englishtrainer.domain.enums.Nivel;
import com.pedrosaez.englishtrainer.domain.repository.VocabularioRepository;
import org.springframework.boot.CommandLineRunner;
import org.springframework.stereotype.Component;

@Component
public class VocabularioLoader implements CommandLineRunner {

    private final VocabularioRepository repository;

    public VocabularioLoader(VocabularioRepository repository) {
        this.repository = repository;
    }


    @Override
    public void run(String... args) throws Exception {
        cargar("apple", "manzana", "I eat an apple every day", Nivel.A1,Categoria.SUSTANTIVO);
        cargar("confidence", "confianza", "Confidence comes with practice", Nivel.B1,Categoria.SUSTANTIVO);
        cargar("challenge", "desafío", "This is a real challenge", Nivel.B1,Categoria.SUSTANTIVO);
        cargar("improve", "mejorar", "I want to improve my skills", Nivel.B1,Categoria.VERBO);
        cargar("banana", "plátano", "I like banana", Nivel.A1,Categoria.SUSTANTIVO);
    }

    private void cargar(String palabra, String significado, String ejemplo, Nivel nivel, Categoria categoria) {
        if (!repository.existsByPalabra(palabra)) {
            repository.save(new Vocabulario(palabra, significado, ejemplo, nivel,categoria));
        }
    }
}
