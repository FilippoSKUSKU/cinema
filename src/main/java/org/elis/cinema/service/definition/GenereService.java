package org.elis.cinema.service.definition;

import org.elis.cinema.dto.genere.GenereDTO;
import org.elis.cinema.dto.genere.InsertGenereDTO;

import java.util.List;

public interface GenereService {    GenereDTO findById(long id);
    GenereDTO save(InsertGenereDTO genereDTO) throws Exception;
    List<GenereDTO> findAll() throws Exception;
    GenereDTO update(GenereDTO genereDTO) throws Exception;
    GenereDTO deleteById(long id) throws Exception;
}
