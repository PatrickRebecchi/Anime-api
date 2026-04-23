package com.patrick.animex.validacao;

import com.patrick.animex.DTO.request.UsuarioRequestDTO;
import com.patrick.animex.exception.AnimeException;
import com.patrick.animex.repository.UsuarioRepository;
import jakarta.persistence.OneToMany;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;

@Component
public class ValidacaoUsuarioCriar implements ValidacaoCriarUsuario {

    @Autowired
    private UsuarioRepository repository;

    @Override
    public void validar(UsuarioRequestDTO dto){
        if  (repository.existsByEmail(dto.email())){
            throw new AnimeException("Email já cadastrado! (ValidacaoEmail)");
        }
    }
}
