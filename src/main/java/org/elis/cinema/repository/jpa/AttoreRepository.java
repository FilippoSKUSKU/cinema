package org.elis.cinema.repository.jpa;

import org.elis.cinema.model.Attore;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;

import java.util.List;

public interface AttoreRepository extends JpaRepository<Attore, Long> {
    @Query("select a from Attore a join a.film films where films.id=:movieId")
    List<Attore> findAllByMovieId(Long movieId);
}
