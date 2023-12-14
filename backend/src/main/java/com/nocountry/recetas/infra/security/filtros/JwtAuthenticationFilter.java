package com.purcocktel.webapp.security.filtros;

import com.fasterxml.jackson.databind.ObjectMapper;
import com.purcocktel.webapp.models.dto.LoginDto;
import com.purcocktel.webapp.models.entities.Usuario;
import com.purcocktel.webapp.security.utils.JwtUtil;
import com.purcocktel.webapp.services.IUsuarioService;
import org.springframework.http.HttpStatus;
import org.springframework.http.MediaType;
import org.springframework.security.authentication.UsernamePasswordAuthenticationToken;
import org.springframework.security.core.Authentication;
import org.springframework.security.core.AuthenticationException;
import org.springframework.security.core.userdetails.User;
import org.springframework.security.core.userdetails.UsernameNotFoundException;
import org.springframework.security.web.authentication.UsernamePasswordAuthenticationFilter;

import jakarta.servlet.FilterChain;
import jakarta.servlet.ServletException;
import jakarta.servlet.http.HttpServletRequest;
import jakarta.servlet.http.HttpServletResponse;
import java.io.IOException;
import java.util.HashMap;
import java.util.Map;

public class JwtAuthenticationFilter extends UsernamePasswordAuthenticationFilter {

    private final JwtUtil jwtUtil;

    private final IUsuarioService iUsuarioService;

    public JwtAuthenticationFilter(JwtUtil jwtUtil, IUsuarioService iUsuarioService) {
        this.jwtUtil = jwtUtil;
        this.iUsuarioService = iUsuarioService;
    }

    @Override
    public Authentication attemptAuthentication(HttpServletRequest request,
        HttpServletResponse response) throws AuthenticationException {
        LoginDto userAuth;

        try {
            //Receptor de datos de login y mapeo
            userAuth = new ObjectMapper().readValue(request.getInputStream(), LoginDto.class);

        } catch (IOException e) {
            throw new RuntimeException(e);
        }

        UsernamePasswordAuthenticationToken authenticationToken = new UsernamePasswordAuthenticationToken(
            userAuth.getEmail(), userAuth.getPasswd());

        return getAuthenticationManager().authenticate(authenticationToken);
    }

    @Override
    protected void successfulAuthentication(HttpServletRequest request,
        HttpServletResponse response, FilterChain chain, Authentication authResult)
        throws IOException, ServletException {
        User user = (User) authResult.getPrincipal();

        Usuario userEntity = iUsuarioService.obtenerUsuarioPorEmailSvc(user.getUsername())
            .orElseThrow(
                () -> new UsernameNotFoundException("not found user: " + user.getUsername()));

        String token = jwtUtil.tokenGeneration(userEntity);

        //DEVOLUCION DEL TOKEN EN EL HEADER "AUTHORIZATION"
        response.addHeader("Authorization", token);

        Map<String, Object> httpResponse = new HashMap<>();
        httpResponse.put("token", token);
        httpResponse.put("Message", "Autenticacion Correcta");
        httpResponse.put("Username", user.getUsername());
        httpResponse.put("id", userEntity.getId());

        response.getWriter().write(new ObjectMapper().writeValueAsString(httpResponse));
        response.setStatus(HttpStatus.OK.value());
        response.setContentType(MediaType.APPLICATION_JSON_VALUE);
        response.getWriter().flush();

        super.successfulAuthentication(request, response, chain, authResult);
    }
}