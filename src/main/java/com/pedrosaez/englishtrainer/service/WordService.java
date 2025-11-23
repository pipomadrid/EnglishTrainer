package com.pedrosaez.englishtrainer.service;

import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Random;

@Service
public class WordService {
    private final List<String> words = List.of("apple", "banana", "challenge", "confidence", "improve");

    public String getRandomWord() {
        return words.get(new Random().nextInt(words.size()));
    }
}
