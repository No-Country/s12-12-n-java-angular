package com.nocountry.recetas.infra.security.filters;

import com.nocountry.recetas.infra.security.service.UserDetailsServiceImpl;
import com.nocountry.recetas.infra.security.utils.JwtUtil;
import jakarta.servlet.FilterChain;
import jakarta.servlet.ServletException;
import jakarta.servlet.http.Cookie;
import jakarta.servlet.http.HttpServletRequest;
import jakarta.servlet.http.HttpServletResponse;
import java.io.IOException;
import lombok.NonNull;
import lombok.RequiredArgsConstructor;
import org.springframework.http.HttpStatus;
import org.springframework.http.MediaType;
import org.springframework.security.authentication.UsernamePasswordAuthenticationToken;
import org.springframework.security.core.context.SecurityContextHolder;
import org.springframework.security.core.userdetails.UserDetails;
import org.springframework.stereotype.Component;
import org.springframework.web.filter.OncePerRequestFilter;

@RequiredArgsConstructor
@Component
public class JwtAuthorizationFilter extends OncePerRequestFilter {

    private final JwtUtil jwtUtil;
    private final UserDetailsServiceImpl userDetailsService;

    @Override
    protected void doFilterInternal(@NonNull HttpServletRequest request,
        @NonNull HttpServletResponse response, @NonNull FilterChain filterChain)
        throws ServletException, IOException, ServletException {

        // Obtener la cookie del cliente
        Cookie[] cookies = request.getCookies();
        String tokenCookie = null;
        if (cookies != null) {
            for (Cookie cookie : cookies) {
                if (cookie.getName().equals("token")) {  // Ajusta el nombre de la cookie
                    tokenCookie = cookie.getValue();
                    break;
                }
            }
        }

        // Priorizar el token obtenido de la cookie
        String token = tokenCookie;

        try {
            if (token != null) {

                if (jwtUtil.validToken(token)) {
                    String email = jwtUtil.getUserFromToken(token);

                    UserDetails userDetails = userDetailsService.loadUserByUsername(
                        email);

                    UsernamePasswordAuthenticationToken authenticationToken = new UsernamePasswordAuthenticationToken(
                        email, null, userDetails.getAuthorities());

                    SecurityContextHolder.getContext().setAuthentication(authenticationToken);

                }
            }

        } catch (Exception e) {
            response.setStatus(HttpStatus.FORBIDDEN.value());
            response.setContentType(MediaType.APPLICATION_JSON_VALUE);
        }

        filterChain.doFilter(request, response);
    }

}