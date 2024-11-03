package org.elis.cinema.mapper;

import org.elis.cinema.dto.genere.InsertGenereDTO;
import org.elis.cinema.dto.genere.GenereDTO;
import org.elis.cinema.model.Genere;
import org.springframework.stereotype.Component;

@Component
public class GenereMapper {
    public Genere fromGenereDTO(GenereDTO genereDTO) {
        Genere genere = new Genere();
        genere.setId(genereDTO.getId());
        genere.setNome(genereDTO.getNome());
        return genere;
    }

    public GenereDTO toGenereDTO(Genere genere) {
        GenereDTO genereDTO = new GenereDTO();
        genereDTO.setId(genere.getId());
        genereDTO.setNome(genere.getNome());
        return genereDTO;
    }
    public Genere fromInsertGenereDTO(InsertGenereDTO insertGenereDTO) {
        Genere genere = new Genere();
        genere.setNome(insertGenereDTO.getNome());
        return genere;
    }
}
