package com.patrick.animex.service;

import com.patrick.animex.DTO.response.AnimeResponseDTO;
import com.patrick.animex.entity.Anime;
import com.patrick.animex.repository.AnimeRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.stream.Collectors;

@Service
public class AnimeService {

    @Autowired
    private AnimeRepository repository;

    public List<AnimeResponseDTO> obterTodosAnimes() {
        return converteDados(repository.findAll());
    }

    public List<AnimeResponseDTO> converteDados(List<Anime> animes) {
        return animes.stream()
                .map(a -> new AnimeResponseDTO(
                        a.getId(),
                        a.getNome(),
                        a.getDescricao(),
                        a.getGenero(),
                        a.getEpisodios()))
                .collect(Collectors.toList());
    }


}
