package org.elis.cinema.service.implementation.jpa;

import jakarta.persistence.EntityNotFoundException;
import lombok.RequiredArgsConstructor;
import org.elis.cinema.dto.film.FilmDTO;
import org.elis.cinema.dto.film.InsertFilmDTO;
import org.elis.cinema.mapper.AttoreMapper;
import org.elis.cinema.mapper.FilmMapper;
import org.elis.cinema.model.Film;
import org.elis.cinema.repository.jpa.FilmRepository;
import org.elis.cinema.service.definition.FilmService;
import org.springframework.stereotype.Service;

import java.util.ArrayList;
import java.util.List;

@Service
@RequiredArgsConstructor
public class FilmServiceJPA  implements FilmService {
    private final FilmRepository filmRepository;
    private final FilmMapper filmMapper;
    private final AttoreMapper attoreMapper;
    @Override
    public FilmDTO findById(long id) throws Exception {
        throw new NullPointerException("messaggio eccezione");
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
    public FilmDTO update(FilmDTO filmDTO,long id) {
        Film temp = filmRepository.findById(id).orElseThrow(()->new EntityNotFoundException("Aggiornamento non riuscito film con id: "+id+" non trovato"));
        if(filmDTO.getTitolo()!=null&&!filmDTO.getTitolo().equals(temp.getTitolo()))
        {
            temp.setTitolo(filmDTO.getTitolo());
        }
        if(filmDTO.getDurata()!=null&&filmDTO.getDurata()>0&&filmDTO.getDurata()!=temp.getDurata())
        {
            temp.setDurata(filmDTO.getDurata());
        }
        if(filmDTO.getCast()!=null&&!filmDTO.getCast().isEmpty()&&filmDTO.getCast().stream().noneMatch(t->t.getId()==null||t.getId()<=0))
        {
            temp.setCast(new ArrayList<>(filmDTO.getCast().stream().map(attoreMapper::fromAttoreDTO).toList()));
        }
        temp = filmRepository.save(temp);
       return filmMapper.toFilmDTO(temp);


//        Film temp = filmRepository.findById(filmDTO.getId()).orElseThrow(()->new EntityNotFoundException("Impossibile effettuare l'update, film non trovato"));
//        return filmMapper.toFilmDTO(temp);
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
