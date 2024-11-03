package org.elis.cinema.controller;

import lombok.RequiredArgsConstructor;
import org.elis.cinema.dto.film.FilmDTO;
import org.elis.cinema.service.definition.FilmService;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RestController;

import java.util.List;

@RestController
@RequiredArgsConstructor
public class FilmController {
    private final FilmService filmService;

    @GetMapping("/film")
    public ResponseEntity<List<FilmDTO>> findAll(){
       try{
           return ResponseEntity.ok(filmService.findAll());
       }
       catch (Exception e)
       {
           return ResponseEntity.internalServerError().build();
       }

    }
    @GetMapping("/film/{id}")
    public ResponseEntity<FilmDTO> findById(@PathVariable int id){
        try{
            return ResponseEntity.ok(filmService.findById(id));
        }
        catch (Exception e)
        {
            return ResponseEntity.internalServerError().build();
        }

    }
    @GetMapping("/film/bygenere/{id}")
    public ResponseEntity<List<FilmDTO>> findByGenere(@PathVariable int id){
        try{
            return ResponseEntity.ok(filmService.findByGenereId(id));
        }
        catch (Exception e)
        {
            return ResponseEntity.internalServerError().build();
        }

    }

}
