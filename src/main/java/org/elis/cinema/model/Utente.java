package org.elis.cinema.model;

import jakarta.persistence.*;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;
import org.hibernate.annotations.CreationTimestamp;
import org.hibernate.annotations.UpdateTimestamp;
import org.springframework.security.core.GrantedAuthority;
import org.springframework.security.core.authority.SimpleGrantedAuthority;
import org.springframework.security.core.userdetails.UserDetails;

import java.time.LocalDateTime;
import java.util.Collection;
import java.util.List;

@Entity
@Getter
@Setter
@NoArgsConstructor
public class Utente implements UserDetails {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;
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

    @Override
    public Collection<? extends GrantedAuthority> getAuthorities() {
        //ROLE_ADMIN
        //ROLE_BASE
        //ROLE_STAFF
        return List.of(new SimpleGrantedAuthority("ROLE_"+ruolo.toString()));
    }
}
