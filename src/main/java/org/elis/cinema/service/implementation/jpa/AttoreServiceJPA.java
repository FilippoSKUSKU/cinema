package org.elis.cinema.service.implementation.jpa;

import jakarta.persistence.EntityManager;
import jakarta.persistence.EntityNotFoundException;
import lombok.RequiredArgsConstructor;
import org.elis.cinema.dto.attore.AttoreDTO;
import org.elis.cinema.dto.attore.InsertAttoreDTO;
import org.elis.cinema.mapper.AttoreMapper;
import org.elis.cinema.model.Attore;
import org.elis.cinema.repository.jpa.AttoreRepository;
import org.elis.cinema.service.definition.AttoreService;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
@RequiredArgsConstructor
public class AttoreServiceJPA implements AttoreService {
    private final AttoreRepository attoreRepository;
    private final AttoreMapper attoreMapper;
    @Override
    public AttoreDTO findById(long id) throws EntityNotFoundException {
        Attore attore = attoreRepository.findById(id).orElseThrow(()->new EntityNotFoundException("Attore " + id + " non trovato"));
        return attoreMapper.toAttoreDTO(attore);
    }

    @Override
    public List<AttoreDTO> findAll() {
        return attoreRepository.findAll().stream().map(attoreMapper::toAttoreDTO).toList();
    }

    @Override
    public AttoreDTO save(InsertAttoreDTO attoreDTO) {
        Attore temp =  attoreRepository.save(attoreMapper.fromInsertAttoreDTO(attoreDTO));
        return attoreMapper.toAttoreDTO(temp);
    }

    @Override
    public AttoreDTO update(AttoreDTO attoreDTO) {
        Attore temp = attoreRepository.findById(attoreDTO.getId()).orElseThrow(()->new EntityNotFoundException("Impossibile effettuare l'update, attore non trovato"));
        return attoreMapper.toAttoreDTO(temp);
    }

    @Override
    public AttoreDTO deleteById(long id) {
        Attore temp = attoreRepository.findById(id).orElseThrow(()->new EntityNotFoundException("Impossibile eliminare l'attore: non trovato"));
        return attoreMapper.toAttoreDTO(temp);
    }

    @Override
    public List<AttoreDTO> searchByMovieId(long id) {
        return attoreRepository.findAllByMovieId(id).stream().map(attoreMapper::toAttoreDTO).toList();
    }
}
