package com.pedrosaez.englishtrainer;

import com.pedrosaez.englishtrainer.domain.entity.Vocabulario;
import com.pedrosaez.englishtrainer.domain.entity.enums.Dificultad;
import com.pedrosaez.englishtrainer.repository.VocabularioRepository;
import com.pedrosaez.englishtrainer.service.VocabularioService;
import org.springframework.boot.CommandLineRunner;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;

import java.time.LocalDateTime;
import java.time.LocalTime;

@SpringBootApplication
public class TestVocabulario implements CommandLineRunner {

    private final VocabularioService service;

    public TestVocabulario(VocabularioService service) {
        this.service = service;
    }

    public static void main(String[] args) {
        SpringApplication.run(TestVocabulario.class, args);
    }

    @Override
    public void run(String... args) throws Exception {

    }
}
