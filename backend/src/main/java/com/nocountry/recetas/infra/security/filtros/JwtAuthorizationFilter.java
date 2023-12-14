package com.purcocktel.webapp.security.filtros;

import com.purcocktel.webapp.security.services.UserDetailsServiceImplementation;
import com.purcocktel.webapp.security.utils.JwtUtil;
import jakarta.servlet.http.Cookie;
import lombok.NonNull;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.authentication.UsernamePasswordAuthenticationToken;
import org.springframework.security.core.context.SecurityContextHolder;
import org.springframework.security.core.userdetails.UserDetails;
import org.springframework.stereotype.Component;
import org.springframework.web.filter.OncePerRequestFilter;
import org.springframework.http.MediaType;
import org.springframework.http.HttpStatus;
import jakarta.servlet.FilterChain;
import jakarta.servlet.ServletException;
import jakarta.servlet.http.HttpServletRequest;
import jakarta.servlet.http.HttpServletResponse;
import java.io.IOException;


@Component
public class JwtAuthorizationFilter extends OncePerRequestFilter {

    @Autowired
    private JwtUtil jwtUtil;

    @Autowired
    private UserDetailsServiceImplementation userDetailsServiceImplementation;

    @Override
    protected void doFilterInternal(@NonNull HttpServletRequest request, @NonNull HttpServletResponse response, @NonNull FilterChain filterChain) throws ServletException, IOException, ServletException {

        // Verificar si la solicitud es para la página de inicio de sesión
        if (request.getRequestURI().equals("/intranet/login") || request.getRequestURI().equals("/login")) {
            filterChain.doFilter(request, response);
            return;
        }



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

                    UserDetails userDetails = userDetailsServiceImplementation.loadUserByUsername(email);

                    UsernamePasswordAuthenticationToken authenticationToken = new UsernamePasswordAuthenticationToken(email, null, userDetails.getAuthorities());

                    SecurityContextHolder.getContext().setAuthentication(authenticationToken);

                }else {
                    // Te envía a login si no es válido
                    redirectToLogin(response);
                    return;
                }
            }else {
                // Te envía a login si no es válido
                redirectToLogin(response);
                return;
            }

        } catch (Exception e) {
            response.setStatus(HttpStatus.FORBIDDEN.value());
            response.setContentType(MediaType.APPLICATION_JSON_VALUE);
        }

        filterChain.doFilter(request, response);
    }

    private void redirectToLogin(HttpServletResponse response) throws IOException {
        response.sendRedirect("/intranet/login");
    }
}