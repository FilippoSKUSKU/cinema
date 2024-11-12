package org.elis.cinema.controller;

import lombok.RequiredArgsConstructor;
import org.elis.cinema.dto.attore.AttoreDTO;
import org.elis.cinema.dto.attore.InsertAttoreDTO;
import org.elis.cinema.service.definition.AttoreService;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

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
    @PostMapping("/staff/attore")
    public ResponseEntity<Void> insertAttore(@RequestBody InsertAttoreDTO attoreDTO) throws Exception{
        attoreService.save(attoreDTO);
        return ResponseEntity.ok().build();
    }

}
