package org.elis.cinema.dto.biglietto;

import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;
import org.elis.cinema.dto.spettacolo.SpettacoloDTO;
import org.elis.cinema.dto.utente.UtenteDTO;

import java.time.LocalDateTime;

@Getter
@Setter
@NoArgsConstructor
public class BigliettoDTO {
    private Long id;
    private LocalDateTime dataAcquisto;
    private SpettacoloDTO spettacoloDTO;
}
