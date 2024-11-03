package org.elis.cinema.dto.film;

import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;
import org.elis.cinema.dto.attore.AttoreDTO;
import org.elis.cinema.dto.genere.GenereDTO;

import java.util.List;

@Getter
@Setter
@NoArgsConstructor
public class InsertFilmDTO {
    private String titolo;
    private Integer durata;
    private GenereDTO genere;
    private List<AttoreDTO> cast;
}
