package org.elis.cinema.repository.jpa;

import org.elis.cinema.model.Utente;
import org.springframework.data.jpa.repository.JpaRepository;

public interface UtenteRepository extends JpaRepository<Utente, Long> {
    public Utente findByUsernameAndPassword(String username, String password);
}
