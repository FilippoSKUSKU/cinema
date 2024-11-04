package org.elis.cinema.controller;

import lombok.RequiredArgsConstructor;
import org.elis.cinema.dto.attore.AttoreDTO;
import org.elis.cinema.service.definition.AttoreService;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RestController;

import java.util.List;

@RestController
@RequiredArgsConstructor
public class AttoreController {
    private final AttoreService attoreService;

    @GetMapping("/attore")
    public ResponseEntity<List<AttoreDTO>> findAll() throws Exception{
            return ResponseEntity.ok(attoreService.findAll());
    }
    @GetMapping("/attore/{id}")
    public ResponseEntity<AttoreDTO> findById(@PathVariable int id) throws Exception{
            return ResponseEntity.ok(attoreService.findById(id));

    }
    @GetMapping("/attore/byfilm/{id}")
    public ResponseEntity<List<AttoreDTO>> findByMovieId(@PathVariable int id) throws Exception{
            return ResponseEntity.ok(attoreService.searchByMovieId(id));
    }

}
