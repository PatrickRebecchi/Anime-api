package com.patrick.animex.DTO.request;

import com.patrick.animex.entity.enums.Genero;
import jakarta.validation.constraints.NotBlank;
import jakarta.validation.constraints.NotNull;
import jakarta.validation.constraints.Positive;

public record AnimeRequestDTO(

        @NotBlank(message = "Título é obrigatório")
        String titulo,

        @NotBlank(message = "Descrição é obrigatória")
        String descricao,

        @NotNull(message = "Gênero é obrigatório")
        Genero genero,

        @NotNull(message = "Número de episódios é obrigatório")
        @Positive(message = "Episódios deve ser maior que zero")
        Integer episodios

) {}