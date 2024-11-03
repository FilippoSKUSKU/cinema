package org.elis.cinema.mapper;

import lombok.RequiredArgsConstructor;
import org.elis.cinema.dto.biglietto.BigliettoDTO;
import org.elis.cinema.dto.biglietto.InsertBigliettoDTO;
import org.elis.cinema.model.Biglietto;
import org.springframework.stereotype.Component;

import java.time.LocalDateTime;

@Component
@RequiredArgsConstructor
public class BigliettoMapper {
    private final SpettacoloMapper spettacoloMapper;
    private final UtenteMapper utenteMapper;

    public Biglietto fromInsertBigliettoDTO(InsertBigliettoDTO insertBigliettoDTO) {
        Biglietto biglietto = new Biglietto();
        biglietto.setDataAcquisto(LocalDateTime.now());
        biglietto.setSpettacolo(spettacoloMapper.fromSpettacoloDTO(insertBigliettoDTO.getSpettacoloDTO()));
        biglietto.setUtente(utenteMapper.fromUtenteDTO(insertBigliettoDTO.getUtenteDTO()));
        return biglietto;
    }

    public BigliettoDTO toBigliettoDTO(Biglietto biglietto) {
        BigliettoDTO bigliettoDTO = new BigliettoDTO();
        bigliettoDTO.setId(biglietto.getId());
        return bigliettoDTO;
    }
}
