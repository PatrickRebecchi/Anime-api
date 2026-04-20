package com.patrick.animex.entity;

import com.patrick.animex.entity.enums.Genero;
import jakarta.persistence.*;
import jakarta.validation.constraints.NotBlank;
import lombok.Getter;
import lombok.Setter;

import java.util.List;

@Getter
@Setter
@Entity
@Table(name = "animes")
public class Anime {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private long id;
    @NotBlank(message = "Nome do anime obrigatorio")
    private String nome;
    @NotBlank(message = "Descrição obrigatorio")
    private String descricao;
    @Enumerated(EnumType.STRING)
    private Genero genero;
    private Integer episodios;


    @OneToMany(mappedBy = "anime", cascade = CascadeType.ALL)
    private List<Favorito> animeList;
}
