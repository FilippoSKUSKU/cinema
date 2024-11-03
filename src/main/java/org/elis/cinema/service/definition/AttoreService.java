package org.elis.cinema.service.definition;


import org.elis.cinema.dto.attore.AttoreDTO;
import org.elis.cinema.dto.attore.InsertAttoreDTO;

import java.util.List;

public interface AttoreService {
    AttoreDTO findById(long id) throws Exception;
    List<AttoreDTO> findAll() throws Exception;
    AttoreDTO save(InsertAttoreDTO attoreDTO) throws Exception;
    AttoreDTO update(AttoreDTO attoreDTO) throws Exception;
    AttoreDTO deleteById(long id) throws Exception;
    List<AttoreDTO> searchByMovieId(long id) throws Exception;
}
