package org.elis.cinema.mapper;

import lombok.RequiredArgsConstructor;
import org.elis.cinema.dto.utente.UtenteDTO;
import org.elis.cinema.dto.utente.InsertUtenteDTO;
import org.elis.cinema.model.Utente;
import org.springframework.stereotype.Component;

@Component
@RequiredArgsConstructor
public class UtenteMapper {


    public Utente fromUtenteDTO(UtenteDTO dto) {
        Utente utente = new Utente();
        utente.setId(dto.getId());
        utente.setUsername(dto.getUsername());
        utente.setEmail(dto.getEmail());
        utente.setRuolo(dto.getRuolo());
        return utente;
    }
    public Utente fromInsertUtenteDTO(InsertUtenteDTO insertUtenteDTO) {
        Utente utente = new Utente();
        utente.setUsername(insertUtenteDTO.getUsername());
        utente.setPassword(insertUtenteDTO.getPassword());
        utente.setEmail(insertUtenteDTO.getEmail());
        return utente;
    }

    public UtenteDTO toUtenteDTO(Utente utente) {
        UtenteDTO utenteDTO = new UtenteDTO();
        utenteDTO.setId(utente.getId());
        utenteDTO.setUsername(utente.getUsername());
        utenteDTO.setEmail(utente.getEmail());
        utenteDTO.setRuolo(utente.getRuolo());
        return utenteDTO;
    }}
