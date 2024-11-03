package org.elis.cinema.dto.biglietto;

import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;
import org.elis.cinema.dto.spettacolo.SpettacoloDTO;
import org.elis.cinema.dto.utente.UtenteDTO;

@Getter
@Setter
@NoArgsConstructor
public class InsertBigliettoDTO {
    private SpettacoloDTO spettacoloDTO;
    private UtenteDTO utenteDTO;
}
