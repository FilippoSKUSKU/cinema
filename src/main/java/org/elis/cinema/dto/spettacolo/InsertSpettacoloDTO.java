package org.elis.cinema.dto.spettacolo;

import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;
import org.elis.cinema.dto.film.FilmDTO;
import org.elis.cinema.dto.sala.SalaDTO;

import java.time.LocalDateTime;

@Getter
@Setter
@NoArgsConstructor
public class InsertSpettacoloDTO {
    private FilmDTO filmDTO;
    private SalaDTO salaDTO;
    private LocalDateTime dataOra;
}
