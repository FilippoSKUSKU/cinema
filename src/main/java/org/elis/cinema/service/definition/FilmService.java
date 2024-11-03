package org.elis.cinema.service.definition;

import org.elis.cinema.dto.film.FilmDTO;
import org.elis.cinema.dto.film.InsertFilmDTO;
import org.elis.cinema.dto.film.FilmDTO;
import org.elis.cinema.dto.film.InsertFilmDTO;

import java.util.List;

public interface FilmService {
    FilmDTO findById(long id) throws Exception;
    FilmDTO save(InsertFilmDTO filmDTO) throws Exception;
    List<FilmDTO> findAll() throws Exception;
    FilmDTO update(FilmDTO filmDTO) throws Exception;
    FilmDTO deleteById(long id) throws Exception;
    List<FilmDTO> findByGenereId(long genereId) throws Exception;
}
