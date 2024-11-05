package org.elis.cinema.dto.errori;

import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

import java.time.LocalDateTime;
import java.util.List;

@Getter
@Setter
@NoArgsConstructor
public class ValidationErrorDTO {
    private LocalDateTime timestamp;
    private int status;
    private String statusString;
    private String message;
    private List<ErrorFieldDTO> errori;
}
