package com.patrick.animex.DTO.response;

public record LoginResponseDTO(
        String token,
        long id,
        String nome,
        String email,
        String role
) {
}