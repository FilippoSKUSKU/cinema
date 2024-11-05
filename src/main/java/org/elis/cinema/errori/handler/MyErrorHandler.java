package org.elis.cinema.errori.handler;

import jakarta.persistence.EntityNotFoundException;
import org.elis.cinema.dto.errori.ErrorFieldDTO;
import org.elis.cinema.dto.errori.MessaggioErroreDTO;
import org.elis.cinema.dto.errori.ValidationErrorDTO;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.MethodArgumentNotValidException;
import org.springframework.web.bind.annotation.ExceptionHandler;
import org.springframework.web.bind.annotation.RestControllerAdvice;
import org.springframework.web.context.request.WebRequest;
import org.springframework.web.server.ResponseStatusException;

import java.time.LocalDateTime;

@RestControllerAdvice
public class MyErrorHandler {


    @ExceptionHandler(EntityNotFoundException.class)
    public ResponseEntity<MessaggioErroreDTO> entitaNonTrovataHandler(EntityNotFoundException exception, WebRequest request){
       MessaggioErroreDTO dto = new MessaggioErroreDTO();
       dto.setTimestamp(LocalDateTime.now());
       dto.setMessaggio(exception.getMessage());
       dto.setPercorso(request.getDescription(false));
       dto.setTipoErrore(HttpStatus.NOT_FOUND.toString());
       return ResponseEntity.badRequest().body(dto);
    }
    @ExceptionHandler(MethodArgumentNotValidException.class)
    public ResponseEntity<ValidationErrorDTO> validationHandler(MethodArgumentNotValidException exception, WebRequest request){
        ValidationErrorDTO dto = new ValidationErrorDTO();
        dto.setTimestamp(LocalDateTime.now());
        dto.setMessage("richiesta rifiutata per inconsistenza dei dati");
        dto.setStatus(HttpStatus.BAD_REQUEST.value());
        dto.setStatusString(HttpStatus.BAD_REQUEST.toString());
        dto.setErrori(exception.getFieldErrors().stream().map(ErrorFieldDTO::new).toList());
        return ResponseEntity.badRequest().body(dto);
    }
//    MODO "DEPRECATO"
//    @ExceptionHandler(Exception.class)
//    public ResponseEntity<MessaggioErroreDTO> erroreGenericoHandler(Exception exception, WebRequest request){
//        MessaggioErroreDTO dto = new MessaggioErroreDTO();
//        dto.setTimestamp(LocalDateTime.now());
//       dto.setMessaggio(exception.getMessage());
//       dto.setTipoErrore(HttpStatus.INTERNAL_SERVER_ERROR.toString());
//       dto.setPercorso(request.getDescription(false));
//       return ResponseEntity.internalServerError().body(dto);
//    }
//    @ExceptionHandler(Exception.class)
//    public ResponseEntity<String> generalException(ResponseStatusException exception, WebRequest request){
//
//    }

}
