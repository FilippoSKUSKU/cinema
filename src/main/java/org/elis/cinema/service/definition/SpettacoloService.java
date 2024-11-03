package org.elis.cinema.service.definition;

import org.elis.cinema.dto.spettacolo.SpettacoloDTO;
import org.elis.cinema.dto.spettacolo.InsertSpettacoloDTO;

import java.util.List;

public interface SpettacoloService {    SpettacoloDTO findById(long id);
    SpettacoloDTO save(InsertSpettacoloDTO spettacoloDTO) throws Exception;
    List<SpettacoloDTO> findAll() throws Exception;
    SpettacoloDTO update(SpettacoloDTO spettacoloDTO) throws Exception;
    SpettacoloDTO deleteById(long id) throws Exception;
}
