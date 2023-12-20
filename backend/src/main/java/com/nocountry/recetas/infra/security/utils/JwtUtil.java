package com.nocountry.recetas.infra.security.utils;

import com.auth0.jwt.JWT;
import com.auth0.jwt.algorithms.Algorithm;
import com.auth0.jwt.exceptions.JWTCreationException;
import com.auth0.jwt.exceptions.JWTVerificationException;
import com.auth0.jwt.interfaces.DecodedJWT;
import com.nocountry.recetas.domain.entities.usr.Usr;
import java.time.Duration;
import java.time.Instant;
import org.springframework.stereotype.Component;

@Component
public class JwtUtil {


    //@Value("${com.purcocktel.webapp.api.key}")
    private final String secretKey = "dkshlskajfopewirnj152kldjafslñkfjañiewlruoñajerflkasndflnrl8y";

    public String tokenGeneration(Usr userEntity) {
        try {
            Algorithm algorithm = Algorithm.HMAC256(secretKey);
            return JWT.create()
                .withSubject(userEntity.getEmail())
                .withClaim("id", userEntity.getId())
                .withExpiresAt(dueDateToken())
                .sign(algorithm);
        } catch (JWTCreationException exception) {
            throw new RuntimeException();
        }
    }

    public Boolean validToken(String token) {
        notNullToken(token);

        DecodedJWT verifier = null;
        try {
            Algorithm algorithm = Algorithm.HMAC256(secretKey); // validando firma
            verifier = JWT.require(algorithm)
                .build()
                .verify(token);

        } catch (JWTVerificationException exception) {
            System.out.println(exception.toString());
        }
        assert verifier != null;

        if (verifier.getSubject() == null) {
            throw new RuntimeException("Invalid verified");
        }
        return true;
    }

    public String getUserFromToken(String token) {
        notNullToken(token);

        DecodedJWT verifier = null;
        try {
            Algorithm algorithm = Algorithm.HMAC256(secretKey); // validando firma
            verifier = JWT.require(algorithm)
                .build()
                .verify(token);
            verifier.getSubject();
        } catch (JWTVerificationException exception) {
            System.out.println(exception.toString());
        }
        assert verifier != null;
        if (verifier.getSubject() == null) {
            throw new RuntimeException("Invalid verified");
        }

        return verifier.getSubject();
    }


    private Instant dueDateToken() {
        return Instant.now().plus(Duration.ofHours(2));
    }

    private void notNullToken(String token) {
        if (token == null) {
            throw new RuntimeException();
        }
    }
}
