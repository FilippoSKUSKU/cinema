package org.elis.cinema.repository.jpa;

import org.elis.cinema.model.Film;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;

import java.util.List;

public interface FilmRepository extends JpaRepository<Film, Long> {
    @Query("select f from Film f join f.genere generi where generi.id=:genereId")
    List<Film> findByGenereId(long genereId);
}
