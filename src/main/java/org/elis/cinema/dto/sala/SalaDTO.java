package org.elis.cinema.dto.sala;

import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

@Getter
@Setter
@NoArgsConstructor
public class SalaDTO {
    private Long id;
    private String nome;
    private Integer capacita;
}
