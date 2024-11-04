package org.elis.cinema.mapper;

import lombok.RequiredArgsConstructor;
import org.elis.cinema.dto.film.FilmDTO;
import org.elis.cinema.dto.film.InsertFilmDTO;
import org.elis.cinema.model.Film;
import org.springframework.stereotype.Component;

@Component
@RequiredArgsConstructor
public class FilmMapper{
    private final AttoreMapper attoreMapper;
    private final GenereMapper genereMapper;

    public Film fromFilmDTO(FilmDTO filmDTO){
        Film film = new Film();
        film.setId(filmDTO.getId());
        film.setTitolo(filmDTO.getTitolo());
        film.setGenere(genereMapper.fromGenereDTO(filmDTO.getGenereDTO()));
        film.setDurata(filmDTO.getDurata());
        film.setCast(filmDTO.getCast().stream().map(attoreMapper::fromAttoreDTO).toList());
        return film;
    }
    public Film fromInsertFilmDTO(InsertFilmDTO insertFilmDTO)
    {
        Film film = new Film();
        film.setTitolo(insertFilmDTO.getTitolo());
        film.setCast(insertFilmDTO.getCast().stream().map(attoreMapper::fromAttoreDTO).toList());
        film.setDurata(insertFilmDTO.getDurata());
        film.setGenere(genereMapper.fromGenereDTO(insertFilmDTO.getGenere()));
        return film;
    }
    public FilmDTO toFilmDTO(Film film)
    {
        FilmDTO filmDTO = new FilmDTO();
        filmDTO.setTitolo(film.getTitolo());
        filmDTO.setId(film.getId());
        filmDTO.setGenereDTO(genereMapper.toGenereDTO(film.getGenere()));
        filmDTO.setCast(film.getCast().stream().map(attoreMapper::toAttoreDTO).toList());
        filmDTO.setDurata(film.getDurata());
        return filmDTO;
    }
}
