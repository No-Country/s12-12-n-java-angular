package com.nocountry.recetas.infra.security.configuracion;

import com.purcocktel.webapp.security.filtros.JwtAuthenticationFilter;
import com.purcocktel.webapp.security.filtros.JwtAuthorizationFilter;
import com.purcocktel.webapp.security.services.UserDetailsServiceImplementation;
import com.purcocktel.webapp.security.utils.JwtUtil;
import com.purcocktel.webapp.services.IUsuarioService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.security.authentication.AuthenticationManager;
import org.springframework.security.config.annotation.authentication.builders.AuthenticationManagerBuilder;
import org.springframework.security.config.annotation.method.configuration.EnableGlobalMethodSecurity;
import org.springframework.security.config.annotation.web.builders.HttpSecurity;
import org.springframework.security.config.annotation.web.configuration.EnableWebSecurity;
import org.springframework.security.config.annotation.web.configurers.AbstractHttpConfigurer;
import org.springframework.security.config.http.SessionCreationPolicy;
import org.springframework.security.crypto.bcrypt.BCryptPasswordEncoder;
import org.springframework.security.crypto.password.PasswordEncoder;
import org.springframework.security.web.SecurityFilterChain;
import org.springframework.security.web.authentication.UsernamePasswordAuthenticationFilter;

@Configuration
@EnableWebSecurity
@EnableGlobalMethodSecurity(securedEnabled = true, prePostEnabled = true)
//ANOTACION PARA HABILITAR LA RESTRICCION POR MEDIO DE LOS METODOS
public class SecurityConfig {

    /*@Autowired
    private IUsuarioService iUsuarioService;*/

    @Autowired
    private UserDetailsServiceImplementation userDetailsServiceImplementation;

    @Autowired
    private JwtAuthorizationFilter jwtAuthorizationFilter;

    @Autowired
    private JwtUtil jwtUtil;


    @Bean
    public AuthenticationManager authenticationManager(HttpSecurity httpSecurity,
        PasswordEncoder passwordEncoder) throws Exception {
        return httpSecurity.getSharedObject(AuthenticationManagerBuilder.class)
            .userDetailsService(userDetailsServiceImplementation)
            .passwordEncoder(passwordEncoder)
            .and()
            .build();
    }

    @Bean
    protected SecurityFilterChain securityFilterChain(HttpSecurity http,
        AuthenticationManager authenticationManager) throws Exception {

        JwtAuthenticationFilter authenticationFilter = new JwtAuthenticationFilter(jwtUtil,
            iUsuarioService);
        authenticationFilter.setAuthenticationManager(authenticationManager);

        return http
            .csrf(AbstractHttpConfigurer::disable)
            .authorizeHttpRequests(
                auth -> {
                    auth.requestMatchers("/intranet/login", "/", "/login", "/**").permitAll();
                    auth.anyRequest().authenticated();
                }
            )
            .sessionManagement(session -> {
                session.sessionCreationPolicy(SessionCreationPolicy.STATELESS);
            })
            .addFilter(authenticationFilter)
            .addFilterBefore(jwtAuthorizationFilter, UsernamePasswordAuthenticationFilter.class)
            .build();

    }

    @Bean
    public PasswordEncoder passwordEncoder() {
        return new BCryptPasswordEncoder();
    }

}