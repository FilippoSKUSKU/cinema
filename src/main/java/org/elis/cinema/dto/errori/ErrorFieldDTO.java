package org.elis.cinema.dto.errori;

import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;
import org.springframework.validation.FieldError;

@Getter
@Setter
@NoArgsConstructor
public class ErrorFieldDTO {
    private String nomeCampo;
    private String messaggioErrore;

    public ErrorFieldDTO(FieldError fieldError)
    {
        this.nomeCampo = fieldError.getField();
        this.messaggioErrore = fieldError.getDefaultMessage();
    }
}
