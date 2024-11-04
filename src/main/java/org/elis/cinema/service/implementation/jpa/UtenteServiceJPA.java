package org.elis.cinema.service.implementation.jpa;

import jakarta.persistence.EntityNotFoundException;
import lombok.RequiredArgsConstructor;
import org.elis.cinema.dto.utente.InsertUtenteDTO;
import org.elis.cinema.dto.utente.LoginDTO;
import org.elis.cinema.dto.utente.UtenteDTO;
import org.elis.cinema.mapper.UtenteMapper;
import org.elis.cinema.model.Utente;
import org.elis.cinema.repository.jpa.UtenteRepository;
import org.elis.cinema.service.definition.UtenteService;
import org.springframework.http.HttpStatus;
import org.springframework.stereotype.Component;
import org.springframework.web.server.ResponseStatusException;

import java.util.List;

@Component
@RequiredArgsConstructor
public class UtenteServiceJPA implements UtenteService {
    private final UtenteRepository utenteRepository;
    private final UtenteMapper utenteMapper;
    @Override
    public UtenteDTO findById(long id) throws EntityNotFoundException {
        Utente utente = utenteRepository.findById(id).orElseThrow(()->new EntityNotFoundException("Utente " + id + " non trovato"));
        return utenteMapper.toUtenteDTO(utente);
    }

    @Override
    public List<UtenteDTO> findAll() {
        return utenteRepository.findAll().stream().map(utenteMapper::toUtenteDTO).toList();
    }

    @Override
    public UtenteDTO save(InsertUtenteDTO utenteDTO) {
        if(utenteDTO.getCodiceFiscale().isBlank())
        {
            throw new ResponseStatusException(HttpStatus.BAD_REQUEST,"formato del codice fiscale invalido");
        }
        Utente temp =  utenteRepository.save(utenteMapper.fromInsertUtenteDTO(utenteDTO));
        return utenteMapper.toUtenteDTO(temp);
    }

    @Override
    public UtenteDTO update(UtenteDTO utenteDTO) {
        Utente temp = utenteRepository.findById(utenteDTO.getId()).orElseThrow(()->new EntityNotFoundException("Impossibile effettuare l'update, utente non trovato"));
        return utenteMapper.toUtenteDTO(temp);
    }

    @Override
    public UtenteDTO deleteById(long id) {
        Utente temp = utenteRepository.findById(id).orElseThrow(()->new EntityNotFoundException("Impossibile eliminare l'utente: non trovato"));
        return utenteMapper.toUtenteDTO(temp);
    }

    @Override
    public UtenteDTO login(LoginDTO loginDTO) throws Exception {
        return utenteMapper.toUtenteDTO(utenteRepository.findByUsernameAndPassword(loginDTO.getUsername(), loginDTO.getPassword()));
    }

}
