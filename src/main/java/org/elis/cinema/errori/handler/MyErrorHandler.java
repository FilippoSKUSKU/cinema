package org.elis.cinema.errori.handler;

import jakarta.persistence.EntityNotFoundException;
import org.elis.cinema.dto.errori.MessaggioErroreDTO;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.ExceptionHandler;
import org.springframework.web.bind.annotation.RestControllerAdvice;
import org.springframework.web.context.request.WebRequest;

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
    //MODO "DEPRECATO"
//    @ExceptionHandler(Exception.class)
//    public ResponseEntity<MessaggioErroreDTO> erroreGenericoHandler(Exception exception, WebRequest request){
//        MessaggioErroreDTO dto = new MessaggioErroreDTO();
//        dto.setTimestamp(LocalDateTime.now());
//       dto.setMessaggio(exception.getMessage());
//       dto.setTipoErrore(HttpStatus.INTERNAL_SERVER_ERROR.toString());
//       dto.setPercorso(request.getDescription(false));
//       return ResponseEntity.internalServerError().body(dto);
//    }

}
