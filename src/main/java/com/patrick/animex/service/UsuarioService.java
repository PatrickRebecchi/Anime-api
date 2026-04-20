package com.patrick.animex.service;

import com.patrick.animex.DTO.response.AnimeResponseDTO;
import com.patrick.animex.DTO.response.UsuarioResponseDTO;
import com.patrick.animex.entity.Anime;
import com.patrick.animex.entity.Usuario;
import com.patrick.animex.repository.UsuarioRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.stream.Collectors;

@Service
public class UsuarioService {
    @Autowired
    private UsuarioRepository repository;


    public List<UsuarioResponseDTO> obterTodosUsuarios() {
        return converteDados(repository.findAll());
    }

    public List<UsuarioResponseDTO> converteDados(List<Usuario> usuarios) {
        return usuarios.stream()
                .map(u -> new UsuarioResponseDTO(
                        u.getId(),
                        u.getNome(),
                        u.getEmail(),
                        u.getRole()))
                .collect(Collectors.toList());
    }


}
