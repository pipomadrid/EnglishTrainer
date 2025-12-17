package com.pedrosaez.englishtrainer.repository;

import com.pedrosaez.englishtrainer.domain.entity.Vocabulario;
import com.pedrosaez.englishtrainer.domain.entity.enums.Dificultad;
import com.pedrosaez.englishtrainer.domain.entity.enums.Nivel;
import org.springframework.data.domain.Pageable;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;

import java.util.List;


public interface VocabularioRepository  extends JpaRepository<Vocabulario, Long> {

    boolean existsByPalabra(String palabra);

    List<Vocabulario> findByDificultad(Dificultad dificultad);

    List<Vocabulario> findByNivel(Nivel nivel);

    List<Vocabulario> findByPalabraContainingIgnoreCase(String palabra);

    @Query("SELECT v FROM Vocabulario v ORDER BY function('RAND')")
    List<Vocabulario> findRandom(Pageable pageable);
}
