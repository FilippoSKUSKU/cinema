package org.elis.cinema.repository.jpa;

import org.elis.cinema.model.Biglietto;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;

import java.util.List;

public interface BigliettoRepository extends JpaRepository<Biglietto, Long> {
    @Query("select b from Biglietto b join b.utente u where u.id=:utenteId")
    List<Biglietto> findByUtenteId(long utenteId);
}
