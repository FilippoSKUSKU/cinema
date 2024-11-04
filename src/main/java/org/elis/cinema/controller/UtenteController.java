package org.elis.cinema.controller;

import lombok.RequiredArgsConstructor;
import org.elis.cinema.dto.utente.InsertUtenteDTO;
import org.elis.cinema.dto.utente.UtenteDTO;
import org.elis.cinema.service.definition.UtenteService;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RestController;

import java.util.List;

@RestController
@RequiredArgsConstructor
public class UtenteController {

    private final UtenteService utenteService;

    @GetMapping("/utente")
    public ResponseEntity<List<UtenteDTO>> findAll()throws Exception{
        return ResponseEntity.ok(utenteService.findAll());
    }
    @PostMapping("/utente")
    public ResponseEntity<Void> insert(@RequestBody InsertUtenteDTO dto) throws Exception
    {
       utenteService.save(dto);
       return ResponseEntity.ok().build();
    }
}
