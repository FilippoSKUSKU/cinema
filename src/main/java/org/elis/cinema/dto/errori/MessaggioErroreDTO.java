package org.elis.cinema.dto.errori;

import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

import java.time.LocalDateTime;

@Getter
@Setter
@NoArgsConstructor
public class MessaggioErroreDTO {
   private String messaggio;
   private String tipoErrore;
   private String percorso;
   private LocalDateTime timestamp;

}
