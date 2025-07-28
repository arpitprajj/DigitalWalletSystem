package com.digitalwallet.wallet_service.dto;

import io.jsonwebtoken.Claims;
import io.jsonwebtoken.security.Keys;
import org.springframework.stereotype.Component;
import io.jsonwebtoken.*;

import java.util.function.Function;

@Component
public class JwtUtil {

    private String secretKey= "mySuperSecureJwtKeyThatIsMoreThan32Chars!";
    public String extractUsername(String token) {
        return extractClaim(token, Claims::getSubject); // subject contains the email
    }

    public <T> T extractClaim(String token, Function<Claims, T> claimsResolver) {
        final Claims claims = extractAllClaims(token);
        return claimsResolver.apply(claims);
    }

    private Claims extractAllClaims(String token) {
        return Jwts.parser()
                .setSigningKey(Keys.hmacShaKeyFor(secretKey.getBytes()))
                .build()
                .parseClaimsJws(token)
                .getBody();
    }
}

//    public Claims extractAllClaims(String token) {
//        return Jwts.parser()
//                .setSigningKey(Keys.hmacShaKeyFor(secretKey.getBytes()))
//                .build()
//                .parseClaimsJws(token)
//                .getBody();
//    }
//
//    public String extractUserId(String token) {
//        return extractAllClaims(token).get("userId", Long.class);
//    }
//
//    public boolean isTokenValid(String token) {
//        try {
//            extractAllClaims(token);
//            return true;
//        } catch (Exception e) {
//            return false;
//        }
//    }
//}
