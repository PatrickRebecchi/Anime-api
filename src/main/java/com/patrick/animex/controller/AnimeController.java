package com.patrick.animex.controller;

import com.patrick.animex.DTO.request.AnimeRequestDTO;
import com.patrick.animex.DTO.response.AnimeResponseDTO;
import com.patrick.animex.service.AnimeService;
import jakarta.validation.Valid;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/anime")
public class AnimeController {
    @Autowired
    private AnimeService service;

    @GetMapping
    public List<AnimeResponseDTO> obterTodosAnimes(){
        return service.obterTodosAnimes();
    }

    @PostMapping
    public ResponseEntity<AnimeResponseDTO> cadastrarAnime(@RequestBody @Valid AnimeRequestDTO dto) {
        return ResponseEntity.status(HttpStatus.CREATED)
                .body(service.cadastrar(dto));

    }
}
