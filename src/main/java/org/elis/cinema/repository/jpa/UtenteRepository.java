package org.elis.cinema.repository.jpa;

import org.elis.cinema.model.Utente;
import org.springframework.data.jpa.repository.JpaRepository;

import java.util.Optional;

public interface UtenteRepository extends JpaRepository<Utente, Long> {
    public Optional<Utente> findByUsername(String username);
}
