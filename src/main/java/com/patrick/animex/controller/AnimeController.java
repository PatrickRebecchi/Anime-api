package com.patrick.animex.controller;

import com.patrick.animex.DTO.response.AnimeResponseDTO;
import com.patrick.animex.service.AnimeService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

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
}
