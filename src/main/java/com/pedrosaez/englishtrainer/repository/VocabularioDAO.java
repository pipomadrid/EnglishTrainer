package com.pedrosaez.englishtrainer.repository;

import com.pedrosaez.englishtrainer.model.Vocabulario;

import java.util.List;

public interface VocabularioDAO {

    void insert(Vocabulario v);
    void update(Vocabulario v);
    void delete(int id);
    Vocabulario findById(int id);
    List<Vocabulario> findAll();
    List<Vocabulario> search(String query);
}
