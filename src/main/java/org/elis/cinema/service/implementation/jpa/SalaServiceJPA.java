package org.elis.cinema.service.implementation.jpa;

import jakarta.persistence.EntityNotFoundException;
import lombok.RequiredArgsConstructor;
import org.elis.cinema.dto.sala.SalaDTO;
import org.elis.cinema.dto.sala.InsertSalaDTO;
import org.elis.cinema.mapper.SalaMapper;
import org.elis.cinema.model.Sala;
import org.elis.cinema.repository.jpa.SalaRepository;
import org.elis.cinema.service.definition.SalaService;
import org.springframework.stereotype.Component;

import java.util.List;

@Component
@RequiredArgsConstructor
public class SalaServiceJPA implements SalaService {
    private final SalaRepository salaRepository;
    private final SalaMapper salaMapper;
    @Override
    public SalaDTO findById(long id) throws EntityNotFoundException {
        Sala sala = salaRepository.findById(id).orElseThrow(()->new EntityNotFoundException("Sala " + id + " non trovato"));
        return salaMapper.toSalaDTO(sala);
    }

    @Override
    public List<SalaDTO> findAll() {
        return salaRepository.findAll().stream().map(salaMapper::toSalaDTO).toList();
    }

    @Override
    public SalaDTO save(InsertSalaDTO salaDTO) {
        Sala temp =  salaRepository.save(salaMapper.fromInsertSalaDTO(salaDTO));
        return salaMapper.toSalaDTO(temp);
    }

    @Override
    public SalaDTO update(SalaDTO salaDTO) {
        Sala temp = salaRepository.findById(salaDTO.getId()).orElseThrow(()->new EntityNotFoundException("Impossibile effettuare l'update, sala non trovato"));
        return salaMapper.toSalaDTO(temp);
    }

    @Override
    public SalaDTO deleteById(long id) {
        Sala temp = salaRepository.findById(id).orElseThrow(()->new EntityNotFoundException("Impossibile eliminare l'sala: non trovato"));
        return salaMapper.toSalaDTO(temp);
    }

}
