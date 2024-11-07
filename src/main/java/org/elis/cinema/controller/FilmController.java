package org.elis.cinema.controller;

import jakarta.validation.Valid;
import lombok.RequiredArgsConstructor;
import org.elis.cinema.dto.film.FilmDTO;
import org.elis.cinema.dto.film.InsertFilmDTO;
import org.elis.cinema.service.definition.FilmService;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequiredArgsConstructor
public class FilmController {
    private final FilmService filmService;

    @GetMapping("/all/film")
    public ResponseEntity<List<FilmDTO>> findAll() throws Exception{
           return ResponseEntity.ok(filmService.findAll());
//           return ResponseEntity.internalServerError().build();

    }
    @GetMapping("/all/film/{id}")
    public ResponseEntity<FilmDTO> findById(@PathVariable int id) throws Exception{
            return ResponseEntity.ok(filmService.findById(id));
    }
    @GetMapping("/all/film/bygenere/{id}")
    public ResponseEntity<List<FilmDTO>> findByGenere(@PathVariable int id) throws Exception{
            return ResponseEntity.ok(filmService.findByGenereId(id));
    }
    @PostMapping("/staff/film")
    public ResponseEntity<Void> insert(@Valid @RequestBody InsertFilmDTO filmDTO) throws Exception{
        filmService.save(filmDTO);
        return ResponseEntity.ok().build();
    }
    @PatchMapping("/staff/film/{id}")
    public ResponseEntity<Void> update(@RequestBody FilmDTO filmDTO, @PathVariable int id) throws Exception{
       filmService.update(filmDTO, id);
        return ResponseEntity.ok().build();
    }

}
