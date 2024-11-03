package org.elis.cinema.repository.jpa;

import org.elis.cinema.model.Spettacolo;
import org.springframework.data.jpa.repository.JpaRepository;

public interface SpettacoloRepository extends JpaRepository<Spettacolo, Long> {
}
