package com.patrick.animex.repository;

import com.patrick.animex.entity.Anime;
import jakarta.validation.constraints.NotBlank;
import org.springframework.data.jpa.repository.JpaRepository;

public interface AnimeRepository extends JpaRepository<Anime, Long> {
    boolean existsByName (String nome);
}
