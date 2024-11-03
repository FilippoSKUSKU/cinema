package org.elis.cinema.dto.attore;

import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

@Getter
@Setter
@NoArgsConstructor
public class AttoreDTO {
    private Long id;
    private String nome;
    private String cognome;
}
