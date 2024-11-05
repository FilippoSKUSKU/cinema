package org.elis.cinema.dto.film;

import jakarta.validation.constraints.Min;
import jakarta.validation.constraints.NotBlank;
import jakarta.validation.constraints.NotNull;
import jakarta.validation.constraints.Size;
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
    @NotBlank(message = "il titolo del film non puo' essere vuoto o null")
    private String titolo;
    @Min(value = 40, message = "la durata non puo' essere inferiore a 40 minuti")
    private Integer durata;
//    private Long genereId;
//    private List<Long> attoriIdList;
    @NotNull(message = "ogni film deve avere un genere associato")
    private GenereDTO genere;
    @Size(min = 1,message = "ogni film deve avere almeno un attore associato")
    private List<AttoreDTO> cast;
}
