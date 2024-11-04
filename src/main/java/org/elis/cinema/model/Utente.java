package org.elis.cinema.model;

import jakarta.persistence.*;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;
import org.hibernate.annotations.CreationTimestamp;
import org.hibernate.annotations.UpdateTimestamp;

import java.time.LocalDateTime;
import java.util.List;

@Entity
@Getter
@Setter
@NoArgsConstructor
public class Utente{
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;
    private String codiceFiscale;
    private String username;
    private String email;
    private String password;
    @OneToMany(mappedBy = "utente")
    private List<Biglietto> biglietti;
    @CreationTimestamp
    private LocalDateTime dataCreazione;
    @UpdateTimestamp
    private LocalDateTime dataUltimaModifica;
    private Ruolo ruolo;
}
