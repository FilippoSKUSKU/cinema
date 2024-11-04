package org.elis.cinema.dto.utente;

import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

@Getter
@Setter
@NoArgsConstructor
public class InsertUtenteDTO {
    private String username;
    private String email;
    private String password;
    private String codiceFiscale;
}
