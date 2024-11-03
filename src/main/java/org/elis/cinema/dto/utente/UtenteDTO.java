package org.elis.cinema.dto.utente;

import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;
import org.elis.cinema.dto.biglietto.BigliettoDTO;
import org.elis.cinema.model.Ruolo;

import java.util.List;

@Getter
@Setter
@NoArgsConstructor
public class UtenteDTO {
    private Long id;
    private Ruolo ruolo;
    private String username;
    private String email;
}
