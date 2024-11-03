package org.elis.cinema.service.definition;

import org.elis.cinema.dto.utente.LoginDTO;
import org.elis.cinema.dto.utente.UtenteDTO;
import org.elis.cinema.dto.utente.InsertUtenteDTO;

import java.util.List;

public interface UtenteService {    UtenteDTO findById(long id);
    UtenteDTO save(InsertUtenteDTO utenteDTO) throws Exception;
    List<UtenteDTO> findAll() throws Exception;
    UtenteDTO update(UtenteDTO utenteDTO) throws Exception;
    UtenteDTO deleteById(long id) throws Exception;
    UtenteDTO login(LoginDTO loginDTO) throws Exception;
}
