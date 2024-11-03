package org.elis.cinema.service.implementation.jpa;

import jakarta.persistence.EntityNotFoundException;
import lombok.RequiredArgsConstructor;
import org.elis.cinema.dto.genere.GenereDTO;
import org.elis.cinema.dto.genere.InsertGenereDTO;
import org.elis.cinema.mapper.GenereMapper;
import org.elis.cinema.model.Genere;
import org.elis.cinema.repository.jpa.GenereRepository;
import org.elis.cinema.service.definition.GenereService;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
@RequiredArgsConstructor
public class GenereServiceJPA implements GenereService {
    private final GenereRepository genereRepository;
    private final GenereMapper genereMapper;
    @Override
    public GenereDTO findById(long id) throws EntityNotFoundException {
        Genere genere = genereRepository.findById(id).orElseThrow(()->new EntityNotFoundException("Genere " + id + " non trovato"));
        return genereMapper.toGenereDTO(genere);
    }

    @Override
    public List<GenereDTO> findAll() {
        return genereRepository.findAll().stream().map(genereMapper::toGenereDTO).toList();
    }

    @Override
    public GenereDTO save(InsertGenereDTO genereDTO) {
        Genere temp =  genereRepository.save(genereMapper.fromInsertGenereDTO(genereDTO));
        return genereMapper.toGenereDTO(temp);
    }

    @Override
    public GenereDTO update(GenereDTO genereDTO) {
        Genere temp = genereRepository.findById(genereDTO.getId()).orElseThrow(()->new EntityNotFoundException("Impossibile effettuare l'update, genere non trovato"));
        return genereMapper.toGenereDTO(temp);
    }

    @Override
    public GenereDTO deleteById(long id) {
        Genere temp = genereRepository.findById(id).orElseThrow(()->new EntityNotFoundException("Impossibile eliminare l'genere: non trovato"));
        return genereMapper.toGenereDTO(temp);
    }


}
