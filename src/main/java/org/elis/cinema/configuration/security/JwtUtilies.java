package org.elis.cinema.configuration.security;

import io.jsonwebtoken.Claims;
import io.jsonwebtoken.Jwts;
import io.jsonwebtoken.security.Keys;
import org.elis.cinema.dto.utente.UtenteDTO;
import org.elis.cinema.model.Ruolo;
import org.springframework.stereotype.Component;

import javax.crypto.SecretKey;
import java.time.LocalDateTime;
import java.util.Date;

@Component
public class JwtUtilies {

    private static final String CHIAVE_SEGRETA = "LKASMFV0913247u)*(&@$)*(AJOSIFJNCVKLXJMQA0123498901824LKJNASDLCKNCM<ZXNCasiolDJ";

    private SecretKey getSecretKey(){
        return Keys.hmacShaKeyFor(CHIAVE_SEGRETA.getBytes());
    }

    public String generateToken(UtenteDTO utente){
        long oggi = System.currentTimeMillis();
        long oggiPiuTrentaGiorni = oggi+1000L*60*60*24*30;
       return Jwts.builder()
               .subject(utente.getUsername())
               .issuedAt(new Date(oggi))
               .expiration(new Date(oggiPiuTrentaGiorni))
               .claim("ruolo",utente.getRuolo().toString())
               .signWith(getSecretKey())
               .compact();
    }

    private Claims parseToken(String token){
        return Jwts.parser()
                .verifyWith(getSecretKey())
                .build()
                .parseSignedClaims(token)
                .getPayload();
    }

    public LocalDateTime getIssuedAt(String token){
        Date d = parseToken(token).getIssuedAt();
        return LocalDateTime.from(d.toInstant());
    }
    public LocalDateTime getExpiration(String token){
        Date d = parseToken(token).getExpiration();
        return LocalDateTime.from(d.toInstant());
    }
    public Ruolo getRuolo(String token)
    {
        String ruoloString = parseToken(token).get("ruolo",String.class);

        return Ruolo.valueOf(ruoloString);
    }
    public String getSubject(String token)
    {
        return parseToken(token).getSubject();
    }



}
