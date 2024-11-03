package org.elis.cinema.service.implementation.jpa;

import jakarta.persistence.EntityNotFoundException;
import lombok.RequiredArgsConstructor;
import org.elis.cinema.dto.biglietto.BigliettoDTO;
import org.elis.cinema.dto.biglietto.InsertBigliettoDTO;
import org.elis.cinema.mapper.BigliettoMapper;
import org.elis.cinema.model.Biglietto;
import org.elis.cinema.repository.jpa.BigliettoRepository;
import org.elis.cinema.service.definition.BigliettoService;

import java.util.List;

@RequiredArgsConstructor
public class BigliettoServiceJPA implements BigliettoService {
    private final BigliettoRepository bigliettoRepository;
    private final BigliettoMapper bigliettoMapper;
    @Override
    public BigliettoDTO findById(long id) throws EntityNotFoundException {
        Biglietto biglietto = bigliettoRepository.findById(id).orElseThrow(()->new EntityNotFoundException("Biglietto " + id + " non trovato"));
        return bigliettoMapper.toBigliettoDTO(biglietto);
    }

    @Override
    public List<BigliettoDTO> findAll() {
        return bigliettoRepository.findAll().stream().map(bigliettoMapper::toBigliettoDTO).toList();
    }

    @Override
    public BigliettoDTO save(InsertBigliettoDTO bigliettoDTO) {
        Biglietto temp =  bigliettoRepository.save(bigliettoMapper.fromInsertBigliettoDTO(bigliettoDTO));
        return bigliettoMapper.toBigliettoDTO(temp);
    }

    @Override
    public BigliettoDTO update(BigliettoDTO bigliettoDTO) {
        Biglietto temp = bigliettoRepository.findById(bigliettoDTO.getId()).orElseThrow(()->new EntityNotFoundException("Impossibile effettuare l'update, biglietto non trovato"));
        return bigliettoMapper.toBigliettoDTO(temp);
    }

    @Override
    public BigliettoDTO deleteById(long id) {
        Biglietto temp = bigliettoRepository.findById(id).orElseThrow(()->new EntityNotFoundException("Impossibile eliminare l'biglietto: non trovato"));
        return bigliettoMapper.toBigliettoDTO(temp);
    }

    @Override
    public List<BigliettoDTO> findByUtenteId(long utenteId) throws Exception {
        return bigliettoRepository.findByUtenteId(utenteId).stream().map(bigliettoMapper::toBigliettoDTO).toList();
    }

}
