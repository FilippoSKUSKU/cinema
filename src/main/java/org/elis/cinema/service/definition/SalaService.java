package org.elis.cinema.service.definition;

import org.elis.cinema.dto.sala.SalaDTO;
import org.elis.cinema.dto.sala.InsertSalaDTO;

import java.util.List;

public interface SalaService {    SalaDTO findById(long id);
    SalaDTO save(InsertSalaDTO salaDTO) throws Exception;
    List<SalaDTO> findAll() throws Exception;
    SalaDTO update(SalaDTO salaDTO) throws Exception;
    SalaDTO deleteById(long id) throws Exception;
}
