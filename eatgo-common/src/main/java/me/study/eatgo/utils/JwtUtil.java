package me.study.eatgo.utils;

import io.jsonwebtoken.Jwts;
import org.springframework.stereotype.Component;

@Component
public class JwtUtil {

    public String createToken(Long userId, String userName) {
        String token = Jwts.builder()
            .claim("userId", userId)
            .compact();
        return token;
    }
}
