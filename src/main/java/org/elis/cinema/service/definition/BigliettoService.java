package org.elis.cinema.service.definition;

import org.elis.cinema.dto.biglietto.BigliettoDTO;
import org.elis.cinema.dto.biglietto.InsertBigliettoDTO;

import java.util.List;

public interface BigliettoService {
    BigliettoDTO findById(long id) throws Exception;
    BigliettoDTO save(InsertBigliettoDTO bigliettoDTO) throws Exception;
    List<BigliettoDTO> findAll() throws Exception;
    BigliettoDTO update(BigliettoDTO bigliettoDTO) throws Exception;
    BigliettoDTO deleteById(long id) throws Exception;
    List<BigliettoDTO> findByUtenteId(long utenteId) throws Exception;
}
