package org.elis.cinema.mapper;

import lombok.RequiredArgsConstructor;
import org.elis.cinema.dto.spettacolo.InsertSpettacoloDTO;
import org.elis.cinema.dto.spettacolo.SpettacoloDTO;
import org.elis.cinema.model.Spettacolo;
import org.springframework.stereotype.Component;

@Component
@RequiredArgsConstructor
public class SpettacoloMapper {
    private final SalaMapper salaMapper;
    private final FilmMapper filmMapper;

    public Spettacolo fromSpettacoloDTO(SpettacoloDTO dto)
    {
       Spettacolo spettacolo = new Spettacolo();
       spettacolo.setId(dto.getId());
       spettacolo.setFilm(filmMapper.fromFilmDTO(dto.getFilmDTO()));
       spettacolo.setSala(salaMapper.fromSalaDTO(dto.getSalaDTO()));
       return spettacolo;
    }
    public SpettacoloDTO toSpettacoloDTO(Spettacolo spettacolo)
    {
        SpettacoloDTO dto = new SpettacoloDTO();
        dto.setId(spettacolo.getId());
        dto.setFilmDTO(filmMapper.toFilmDTO(spettacolo.getFilm()));
        dto.setSalaDTO(salaMapper.toSalaDTO(spettacolo.getSala()));
        dto.setDataOra(spettacolo.getDataOra());
        return dto;
    }
    public Spettacolo fromInsertSpettacoloDTO(InsertSpettacoloDTO insertSpettacoloDTO)
    {
        Spettacolo spettacolo = new Spettacolo();
        spettacolo.setSala(salaMapper.fromSalaDTO(insertSpettacoloDTO.getSalaDTO()));
        spettacolo.setFilm(filmMapper.fromFilmDTO(insertSpettacoloDTO.getFilmDTO()));
        return spettacolo;
    }

}
