package org.elis.cinema.service.implementation.jpa;

import jakarta.persistence.EntityNotFoundException;
import lombok.RequiredArgsConstructor;
import org.elis.cinema.dto.spettacolo.InsertSpettacoloDTO;
import org.elis.cinema.dto.spettacolo.SpettacoloDTO;
import org.elis.cinema.mapper.SpettacoloMapper;
import org.elis.cinema.model.Spettacolo;
import org.elis.cinema.repository.jpa.SpettacoloRepository;
import org.elis.cinema.service.definition.SpettacoloService;
import org.springframework.stereotype.Component;

import java.util.List;

@Component
@RequiredArgsConstructor
public class SpettacoloServiceJPA implements SpettacoloService {
    private final SpettacoloRepository spettacoloRepository;
    private final SpettacoloMapper spettacoloMapper;
    @Override
    public SpettacoloDTO findById(long id) throws EntityNotFoundException {
        Spettacolo spettacolo = spettacoloRepository.findById(id).orElseThrow(()->new EntityNotFoundException("Spettacolo " + id + " non trovato"));
        return spettacoloMapper.toSpettacoloDTO(spettacolo);
    }

    @Override
    public List<SpettacoloDTO> findAll() {
        return spettacoloRepository.findAll().stream().map(spettacoloMapper::toSpettacoloDTO).toList();
    }

    @Override
    public SpettacoloDTO save(InsertSpettacoloDTO spettacoloDTO) {
        Spettacolo temp =  spettacoloRepository.save(spettacoloMapper.fromInsertSpettacoloDTO(spettacoloDTO));
        return spettacoloMapper.toSpettacoloDTO(temp);
    }

    @Override
    public SpettacoloDTO update(SpettacoloDTO spettacoloDTO) {
        Spettacolo temp = spettacoloRepository.findById(spettacoloDTO.getId()).orElseThrow(()->new EntityNotFoundException("Impossibile effettuare l'update, spettacolo non trovato"));
        return spettacoloMapper.toSpettacoloDTO(temp);
    }

    @Override
    public SpettacoloDTO deleteById(long id) {
        Spettacolo temp = spettacoloRepository.findById(id).orElseThrow(()->new EntityNotFoundException("Impossibile eliminare l'spettacolo: non trovato"));
        return spettacoloMapper.toSpettacoloDTO(temp);
    }

}
