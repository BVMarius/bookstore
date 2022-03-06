package com.randomhouse.bookstore.utils;

import com.auth0.jwt.JWT;
import com.auth0.jwt.exceptions.JWTCreationException;
import java.util.Calendar;
import java.util.Date;
import java.util.UUID;
import lombok.extern.slf4j.Slf4j;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.stereotype.Component;
import com.auth0.jwt.algorithms.Algorithm;

@Component
@Slf4j
public class Auth0JwtTools {
    public static final long LEEWAY_WINDOW_IN_SECONDS = 5 * 60L;
    public static final String AUDIENCE = "books_api";

    private String issuer;

    private final String secretKey;



    public Auth0JwtTools(@Value("${books.secretkey}") String secretKey,
            @Value("${books.issuer}") String issuer) {
        this.secretKey = secretKey;
        this.issuer = issuer;
    }

    public String createJwt(String userId, Long durationInSeconds) {

        String token = null;
        try {
            long duration = 1000 * durationInSeconds;
            Date now = Calendar.getInstance().getTime();
            Date expiration = new Date(Calendar.getInstance().getTimeInMillis() + duration);
            Algorithm algorithm = Algorithm.HMAC512(secretKey);

            token = JWT.create()
                    .withIssuer(issuer)
                    .withAudience(AUDIENCE)
                    .withSubject(userId)
                    .withExpiresAt(expiration)
                    .withIssuedAt(now)
                    .withNotBefore(now)
                    .withClaim("typ", "access")
                    .withClaim("jti", UUID.randomUUID().toString())
                    .sign(algorithm);
        } catch (JWTCreationException exception) {
            log.error("{}", exception.getMessage(), exception);
        }

        return token;
    }

}
