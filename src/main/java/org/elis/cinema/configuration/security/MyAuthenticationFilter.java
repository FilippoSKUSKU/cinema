package org.elis.cinema.configuration.security;

import jakarta.servlet.FilterChain;
import jakarta.servlet.ServletException;
import jakarta.servlet.http.HttpServletRequest;
import jakarta.servlet.http.HttpServletResponse;
import jdk.jfr.Registered;
import lombok.RequiredArgsConstructor;
import org.springframework.security.authentication.UsernamePasswordAuthenticationToken;
import org.springframework.security.core.context.SecurityContext;
import org.springframework.security.core.context.SecurityContextHolder;
import org.springframework.security.core.userdetails.UserDetails;
import org.springframework.security.core.userdetails.UserDetailsService;
import org.springframework.security.crypto.password.PasswordEncoder;
import org.springframework.security.web.authentication.WebAuthenticationDetailsSource;
import org.springframework.stereotype.Component;
import org.springframework.web.filter.OncePerRequestFilter;

import java.io.IOException;
@Component
@RequiredArgsConstructor
public class MyAuthenticationFilter extends OncePerRequestFilter {
    private final UserDetailsService userDetailsService;
    private final PasswordEncoder passwordEncoder;
    @Override
    protected void doFilterInternal(HttpServletRequest request, HttpServletResponse response, FilterChain filterChain) throws ServletException, IOException {
        SecurityContext sc = SecurityContextHolder.getContext();
        String username = request.getHeader("username");
        String password = request.getHeader("password");

        boolean utenteIsAuthenticated = sc.getAuthentication()!=null;
        if(username==null||password==null||utenteIsAuthenticated)
        {
            filterChain.doFilter(request,response);
           return;
        }

        UserDetails userDetails = userDetailsService.loadUserByUsername(username);
        if(userDetails==null)
        {
            filterChain.doFilter(request,response);
            return;
        }

        if(!passwordEncoder.matches(password, userDetails.getPassword())){
            filterChain.doFilter(request,response);
            return;
        }

        var upat = new UsernamePasswordAuthenticationToken(userDetails, null, userDetails.getAuthorities());
        upat.setDetails(new WebAuthenticationDetailsSource());

        sc.setAuthentication(upat);

        filterChain.doFilter(request, response);


    }
}
