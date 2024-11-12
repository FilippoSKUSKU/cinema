package org.elis.cinema.configuration.security;

import jakarta.servlet.FilterChain;
import jakarta.servlet.ServletException;
import jakarta.servlet.http.HttpServletRequest;
import jakarta.servlet.http.HttpServletResponse;
import jdk.jfr.Registered;
import lombok.RequiredArgsConstructor;
import org.springframework.beans.factory.annotation.Qualifier;
import org.springframework.http.HttpHeaders;
import org.springframework.security.authentication.UsernamePasswordAuthenticationToken;
import org.springframework.security.core.context.SecurityContext;
import org.springframework.security.core.context.SecurityContextHolder;
import org.springframework.security.core.userdetails.UserDetails;
import org.springframework.security.core.userdetails.UserDetailsService;
import org.springframework.security.crypto.password.PasswordEncoder;
import org.springframework.security.web.authentication.WebAuthenticationDetailsSource;
import org.springframework.stereotype.Component;
import org.springframework.web.filter.OncePerRequestFilter;
import org.springframework.web.servlet.HandlerExceptionResolver;

import java.io.IOException;
@Component
public class MyAuthenticationFilter extends OncePerRequestFilter {
    private final UserDetailsService userDetailsService;
    private final JwtUtilies jwtUtilies;
    private final HandlerExceptionResolver exceptionResolver;

    public MyAuthenticationFilter(UserDetailsService userDetailsService, JwtUtilies jwtUtilies, @Qualifier("handlerExceptionResolver") HandlerExceptionResolver exceptionResolver) {
        this.userDetailsService = userDetailsService;
        this.jwtUtilies = jwtUtilies;
        this.exceptionResolver = exceptionResolver;
    }


    @Override
    protected void doFilterInternal(HttpServletRequest request, HttpServletResponse response, FilterChain filterChain) throws ServletException, IOException {
        try{
            SecurityContext sc = SecurityContextHolder.getContext();

            String authorizationHeader = request.getHeader(HttpHeaders.AUTHORIZATION);

            boolean utenteIsAuthenticated = sc.getAuthentication()!=null;
            if(utenteIsAuthenticated||authorizationHeader==null||!authorizationHeader.startsWith("Bearer "))
            {
                filterChain.doFilter(request,response);
                return;
            }

            String token = authorizationHeader.substring(7);
            String username = jwtUtilies.getSubject(token);
            UserDetails userDetails = userDetailsService.loadUserByUsername(username);
            if(userDetails==null)
            {
                filterChain.doFilter(request,response);
                return;
            }


            var upat = new UsernamePasswordAuthenticationToken(userDetails, null, userDetails.getAuthorities());
            upat.setDetails(new WebAuthenticationDetailsSource());

            sc.setAuthentication(upat);

            filterChain.doFilter(request, response);

        }
        catch (Exception e)
        {
            e.printStackTrace();
           exceptionResolver.resolveException(request, response, null, e);
           filterChain.doFilter(request, response);
        }

    }
}
