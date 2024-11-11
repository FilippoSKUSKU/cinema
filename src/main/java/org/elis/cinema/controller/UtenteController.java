package org.elis.cinema.controller;

import lombok.RequiredArgsConstructor;
import org.elis.cinema.configuration.security.JwtUtilies;
import org.elis.cinema.dto.utente.InsertUtenteDTO;
import org.elis.cinema.dto.utente.LoginDTO;
import org.elis.cinema.dto.utente.UtenteDTO;
import org.elis.cinema.service.definition.UtenteService;
import org.springframework.http.HttpHeaders;
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
    private final JwtUtilies jwtUtilies;

    @PostMapping("/all/utente/login")
    public ResponseEntity<Void> login(@RequestBody LoginDTO loginDTO) throws Exception{
       UtenteDTO u = utenteService.login(loginDTO);
       String token = jwtUtilies.generateToken(u);
       return ResponseEntity.ok().header(HttpHeaders.AUTHORIZATION, token).build();
    }
    @GetMapping("/all/utente")
    public ResponseEntity<List<UtenteDTO>> findAll()throws Exception{
        return ResponseEntity.ok(utenteService.findAll());
    }
    @PostMapping("/all/utente")
    public ResponseEntity<Void> insert(@RequestBody InsertUtenteDTO dto) throws Exception
    {
       utenteService.save(dto);
       return ResponseEntity.ok().build();
    }

    @PostMapping("/all/creaUtenteStaff")
    public ResponseEntity<Void> insertStaff(@RequestBody InsertUtenteDTO dto) throws Exception
    {
        utenteService.insertStaffUser(dto);
        return ResponseEntity.ok().build();
    }
}
