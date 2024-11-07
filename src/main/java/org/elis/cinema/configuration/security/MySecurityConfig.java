package org.elis.cinema.configuration.security;

import lombok.RequiredArgsConstructor;
import org.elis.cinema.model.Ruolo;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.security.config.annotation.web.builders.HttpSecurity;
import org.springframework.security.config.annotation.web.configuration.EnableWebSecurity;
import org.springframework.security.config.http.SessionCreationPolicy;
import org.springframework.security.web.SecurityFilterChain;
import org.springframework.security.web.authentication.UsernamePasswordAuthenticationFilter;

@Configuration
@EnableWebSecurity
@RequiredArgsConstructor
public class MySecurityConfig {

    private final MyAuthenticationFilter myAuthenticationFilter;

    @Bean
    SecurityFilterChain securityFilterChain(HttpSecurity http) throws Exception{
       http.authorizeHttpRequests(t->{
           t.requestMatchers("/all/**").permitAll();
           t.requestMatchers("/staff/**").hasAnyRole(Ruolo.STAFF.toString(), Ruolo.ADMIN.toString());
           t.requestMatchers("/admin/**").hasRole( Ruolo.ADMIN.toString());
           t.anyRequest().authenticated();
       }) ;
       http.csrf(t->t.disable());
       http.sessionManagement(t->t.sessionCreationPolicy(SessionCreationPolicy.STATELESS));
       http.addFilterBefore(myAuthenticationFilter, UsernamePasswordAuthenticationFilter.class);
       return http.build();
    }
}
