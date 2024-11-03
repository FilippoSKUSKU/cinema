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
public class Film {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;
    private String titolo;
    private int durata;
    @OneToMany(mappedBy = "film")
    private List<Spettacolo> spettacoli;
    @ManyToMany
    @JoinTable(name = "film_attori", joinColumns =
            @JoinColumn(name = "film_id")
    ,inverseJoinColumns = @JoinColumn(name = "attore_id"))
    private List<Attore> cast;
    @ManyToOne
    private Genere genere;
    @CreationTimestamp
    private LocalDateTime dataCreazione;
    @UpdateTimestamp
    private LocalDateTime dataUltimaModifica;
}
