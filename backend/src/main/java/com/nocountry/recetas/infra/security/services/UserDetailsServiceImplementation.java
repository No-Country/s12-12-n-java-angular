package com.purcocktel.webapp.security.services;

import com.nocountry.recetas.domain.response.UsrResponse;
import com.nocountry.recetas.service.UsrService;
import java.util.Collection;
import java.util.List;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.core.GrantedAuthority;
import org.springframework.security.core.authority.SimpleGrantedAuthority;
import org.springframework.security.core.userdetails.User;
import org.springframework.security.core.userdetails.UserDetails;
import org.springframework.security.core.userdetails.UserDetailsService;
import org.springframework.security.core.userdetails.UsernameNotFoundException;
import org.springframework.stereotype.Service;

@Service
public class UserDetailsServiceImplementation implements UserDetailsService {

    @Autowired
    UsrService usrService;

    @Override
    public UserDetails loadUserByUsername(String email) throws UsernameNotFoundException {
        UsrResponse user = usrService.findByEmail(email);
        if (user == null) {
            throw new UsernameNotFoundException("not found user: " + email);
        }
        Collection<? extends GrantedAuthority> authorities = List.of(
            new SimpleGrantedAuthority("ROLE_" + userEntity.getRol().name()));

        return new User(userEntity.getEmail(),
            userEntity.getPasswd(),
            true,
            true,
            true,
            true,
            authorities);
    }
}
