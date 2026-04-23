package com.patrick.animex.controller;

import com.patrick.animex.DTO.request.UsuarioRequestDTO;
import com.patrick.animex.DTO.response.AnimeResponseDTO;
import com.patrick.animex.DTO.response.UsuarioResponseDTO;
import com.patrick.animex.service.UsuarioService;
import jakarta.validation.Valid;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.security.access.prepost.PreAuthorize;
import org.springframework.web.bind.annotation.*;

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

    @PostMapping
    public ResponseEntity<UsuarioResponseDTO>cadastrarUsuario(@RequestBody @Valid UsuarioRequestDTO dto){
        return ResponseEntity.status(HttpStatus.CREATED)
                .body(service.cadastrar(dto));
    }

    @PutMapping("/{id}/admin")
    @PreAuthorize("hasRole('ADMIN')")
    public ResponseEntity<UsuarioResponseDTO> tornarAdmin(@PathVariable Long id) {
        return ResponseEntity.ok(service.tornarAdmin(id));
    }
}
