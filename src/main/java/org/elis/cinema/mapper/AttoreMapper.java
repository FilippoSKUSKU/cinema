package org.elis.cinema.mapper;

import org.elis.cinema.dto.attore.AttoreDTO;
import org.elis.cinema.dto.attore.InsertAttoreDTO;
import org.elis.cinema.model.Attore;
import org.springframework.stereotype.Component;

@Component
public class AttoreMapper {
    public Attore fromInsertAttoreDTO(InsertAttoreDTO insertAttoreDTO) {
        Attore attore = new Attore();
        attore.setNome(insertAttoreDTO.getNome());
        attore.setCognome(insertAttoreDTO.getCognome());
        return attore;
    }

    public AttoreDTO toAttoreDTO(Attore attore) {
       AttoreDTO attoreDTO = new AttoreDTO();
       attoreDTO.setId(attore.getId());
       attoreDTO.setNome(attore.getNome());
       attoreDTO.setCognome(attore.getCognome());
       return attoreDTO;
    }
    public Attore fromAttoreDTO(AttoreDTO attoreDTO) {
        Attore attore = new Attore();
        attore.setId(attoreDTO.getId());
        attore.setNome(attoreDTO.getNome());
        attore.setCognome(attoreDTO.getCognome());
        return attore;
    }
}
