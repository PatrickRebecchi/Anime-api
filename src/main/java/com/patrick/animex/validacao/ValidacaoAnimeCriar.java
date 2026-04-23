package com.patrick.animex.validacao;

import com.patrick.animex.DTO.request.AnimeRequestDTO;
import com.patrick.animex.DTO.request.UsuarioRequestDTO;
import com.patrick.animex.exception.AnimeException;
import com.patrick.animex.repository.AnimeRepository;
import com.patrick.animex.repository.UsuarioRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;

@Component
public class ValidacaoAnimeCriar implements ValidacaoCriarAnime {

    @Autowired
    private AnimeRepository repository;

    @Override
    public void validar(AnimeRequestDTO dto){
        if  (repository.existsByName(dto.titulo()) ){
            throw new AnimeException("Anime já cadastrado! (ValidacaoNome)");
        }
    }
}
