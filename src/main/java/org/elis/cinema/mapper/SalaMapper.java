package org.elis.cinema.mapper;

import org.elis.cinema.dto.sala.InsertSalaDTO;
import org.elis.cinema.dto.sala.SalaDTO;
import org.elis.cinema.model.Sala;
import org.springframework.stereotype.Component;

@Component
public class SalaMapper {
    public Sala fromSalaDTO(SalaDTO salaDTO) {
        Sala sala = new Sala();
        sala.setId(salaDTO.getId());
        sala.setNome(salaDTO.getNome());
        sala.setCapacita(salaDTO.getCapacita());
        return sala;
    }

    public SalaDTO toSalaDTO(Sala sala) {
        SalaDTO salaDTO = new SalaDTO();
        salaDTO.setId(sala.getId());
        salaDTO.setCapacita(sala.getCapacita());
        salaDTO.setNome(sala.getNome());
        return salaDTO;
    }
    public Sala fromInsertSalaDTO(InsertSalaDTO insertSalaDTO) {
        Sala sala = new Sala();
        sala.setNome(insertSalaDTO.getNome());
        sala.setCapacita(insertSalaDTO.getCapacita());
        return sala;
    }
}
