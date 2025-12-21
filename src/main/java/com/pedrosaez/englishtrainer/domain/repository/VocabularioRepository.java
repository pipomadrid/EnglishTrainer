package com.pedrosaez.englishtrainer.domain.repository;

import com.pedrosaez.englishtrainer.domain.entity.Vocabulario;
import com.pedrosaez.englishtrainer.domain.enums.Dificultad;
import com.pedrosaez.englishtrainer.domain.enums.Nivel;
import org.springframework.data.domain.Pageable;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;

import java.util.List;


public interface VocabularioRepository  extends JpaRepository<Vocabulario, Long> {

    boolean existsByPalabra(String palabra);

    List<Vocabulario> findByDificultad(Dificultad dificultad);

    List<Vocabulario> findByNivel(Nivel nivel);

    List<Vocabulario> findByPalabraContainingIgnoreCase(String palabra);

    @Query("SELECT v FROM Vocabulario v ORDER BY function('RANDOM')")
    List<Vocabulario> findRandom(Pageable pageable);

    @Query("""
    SELECT v FROM Vocabulario v
    WHERE v.id <> :id
    ORDER BY function('RANDOM')
""")
    List<Vocabulario> findRandomExcluding(
            @Param("id") Long id,
            Pageable pageable
    );
}
