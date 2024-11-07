package org.elis.cinema.service.implementation.jpa;

import lombok.RequiredArgsConstructor;
import org.elis.cinema.repository.jpa.UtenteRepository;
import org.springframework.security.core.userdetails.UserDetails;
import org.springframework.security.core.userdetails.UserDetailsService;
import org.springframework.security.core.userdetails.UsernameNotFoundException;
import org.springframework.stereotype.Service;

@Service
@RequiredArgsConstructor
public class MyUserDetailsService implements UserDetailsService {
    private final UtenteRepository utenteRepository;
    @Override
    public UserDetails loadUserByUsername(String username) throws UsernameNotFoundException {
        return utenteRepository.findByUsername(username).orElseThrow(()->new UsernameNotFoundException("username non trovato: "+username));
    }
}
