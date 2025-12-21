package com.pedrosaez.englishtrainer;

import com.pedrosaez.englishtrainer.domain.service.VocabularioService;
import org.springframework.boot.CommandLineRunner;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;

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
