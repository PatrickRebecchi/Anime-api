package com.patrick.animex.service;

import com.patrick.animex.DTO.request.UsuarioRequestDTO;
import com.patrick.animex.DTO.response.AnimeResponseDTO;
import com.patrick.animex.DTO.response.UsuarioResponseDTO;
import com.patrick.animex.entity.Anime;
import com.patrick.animex.entity.Usuario;
import com.patrick.animex.entity.enums.Role;
import com.patrick.animex.repository.UsuarioRepository;
import com.patrick.animex.validacao.ValidacaoUsuarioCriar;
import jakarta.transaction.Transactional;
import jakarta.validation.Valid;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.crypto.bcrypt.BCryptPasswordEncoder;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.stream.Collectors;

@Service
public class UsuarioService {
    @Autowired
    private UsuarioRepository repository;

    @Autowired
    private List<ValidacaoUsuarioCriar> validacao;

    @Transactional
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

    @Transactional
    public UsuarioResponseDTO cadastrar(UsuarioRequestDTO dto) {

        validacao.forEach(v -> v.validar(dto));

        Usuario usuario = new Usuario();
        usuario.setNome(dto.nome());
        usuario.setEmail(dto.email());
        usuario.setRole(Role.CLIENTE);
        usuario.setSenha(new BCryptPasswordEncoder().encode(dto.senha()));
        usuario.setDataCriacao(java.time.LocalDateTime.now());

        Usuario usuarioSalvo = repository.save(usuario);

        return new UsuarioResponseDTO(
                usuarioSalvo.getId(),
                usuarioSalvo.getNome(),
                usuarioSalvo.getEmail(),
                usuarioSalvo.getRole()
        );
    }

    @Transactional
    public UsuarioResponseDTO tornarAdmin(Long id) {

        Usuario usuario = repository.findById(id)
                .orElseThrow(() -> new RuntimeException("Usuário não encontrado"));

        usuario.setRole(Role.ADMIN);

        return new UsuarioResponseDTO(
                usuario.getId(),
                usuario.getNome(),
                usuario.getEmail(),
                usuario.getRole()
        );
    }
}
