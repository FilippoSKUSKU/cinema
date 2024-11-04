package org.elis.cinema.service.implementation.jpa;

import jakarta.persistence.EntityNotFoundException;
import lombok.RequiredArgsConstructor;
import org.elis.cinema.dto.film.FilmDTO;
import org.elis.cinema.dto.film.InsertFilmDTO;
import org.elis.cinema.mapper.FilmMapper;
import org.elis.cinema.model.Film;
import org.elis.cinema.repository.jpa.FilmRepository;
import org.elis.cinema.service.definition.FilmService;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
@RequiredArgsConstructor
public class FilmServiceJPA  implements FilmService {
    private final FilmRepository filmRepository;
    private final FilmMapper filmMapper;
    @Override
    public FilmDTO findById(long id) throws Exception {
        throw new Exception("Eccezione non prevista (internal server error)");
//        Film film = filmRepository.findById(id).orElseThrow(()->new EntityNotFoundException("Film " + id + " non trovato"));
//        return filmMapper.toFilmDTO(film);
    }

    @Override
    public List<FilmDTO> findAll() {
        return filmRepository.findAll().stream().map(filmMapper::toFilmDTO).toList();
    }

    @Override
    public FilmDTO save(InsertFilmDTO filmDTO) {
        Film temp =  filmRepository.save(filmMapper.fromInsertFilmDTO(filmDTO));
        return filmMapper.toFilmDTO(temp);
    }

    @Override
    public FilmDTO update(FilmDTO filmDTO) {
        Film temp = filmRepository.findById(filmDTO.getId()).orElseThrow(()->new EntityNotFoundException("Impossibile effettuare l'update, film non trovato"));
        return filmMapper.toFilmDTO(temp);
    }

    @Override
    public FilmDTO deleteById(long id) {
        Film temp = filmRepository.findById(id).orElseThrow(()->new EntityNotFoundException("Impossibile eliminare l'film: non trovato"));
        return filmMapper.toFilmDTO(temp);
    }

    @Override
    public List<FilmDTO> findByGenereId(long genereId) throws Exception {
        return filmRepository.findByGenereId(genereId).stream().map(filmMapper::toFilmDTO).toList();
    }

}
