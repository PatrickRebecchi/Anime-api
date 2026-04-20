package com.patrick.animex.DTO.response;

import com.patrick.animex.entity.enums.Role;

public record UsuarioResponseDTO(
        Long id,
        String nome,
        String email,
        Role role
) {

}
