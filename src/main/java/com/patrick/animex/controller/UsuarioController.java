package com.patrick.animex.controller;

import com.patrick.animex.DTO.response.AnimeResponseDTO;
import com.patrick.animex.DTO.response.UsuarioResponseDTO;
import com.patrick.animex.service.UsuarioService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import java.util.List;

@RestController
@RequestMapping("/usuarios")
public class UsuarioController {

    @Autowired
    private UsuarioService service;

    @GetMapping
    public List<UsuarioResponseDTO> obterTodosUsuarios() {
        return service.obterTodosUsuarios();
    }
}
