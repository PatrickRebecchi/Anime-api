package com.patrick.animex.DTO.response;

import com.patrick.animex.entity.enums.Genero;

public record AnimeResponseDTO(

        Long id,
        String titulo,
        String descricao,
        Genero genero,
        Integer episodios

) {}