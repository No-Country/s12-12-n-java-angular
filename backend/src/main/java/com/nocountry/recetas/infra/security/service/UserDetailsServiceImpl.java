package com.nocountry.recetas.infra.security.service;

import com.nocountry.recetas.domain.entities.usr.Usr;
import com.nocountry.recetas.service.UsrService;
import java.util.Collection;
import java.util.List;
import java.util.stream.Collectors;
import lombok.RequiredArgsConstructor;
import org.springframework.security.core.GrantedAuthority;
import org.springframework.security.core.authority.SimpleGrantedAuthority;
import org.springframework.security.core.userdetails.User;
import org.springframework.security.core.userdetails.UserDetails;
import org.springframework.security.core.userdetails.UserDetailsService;
import org.springframework.security.core.userdetails.UsernameNotFoundException;
import org.springframework.stereotype.Service;

@RequiredArgsConstructor
@Service
public class UserDetailsServiceImpl implements UserDetailsService {

    private final UsrService usrService;

    @Override
    public UserDetails loadUserByUsername(String email) throws UsernameNotFoundException {

        Usr userEntity = usrService.findByEmail(email);

        if (userEntity == null) {
            throw new UsernameNotFoundException("not found user: " + email);
        }

        Collection<? extends GrantedAuthority> authorities = List.of(
            new SimpleGrantedAuthority("ROLE_USER"));

        return new User(
            userEntity.getEmail(),
            userEntity.getPassword(),
            true,
            true,
            true,
            true,
            authorities);
    }
}
