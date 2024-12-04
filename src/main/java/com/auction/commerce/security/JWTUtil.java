package com.auction.commerce.security;

import java.util.Date;
import java.util.HashMap;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.security.core.userdetails.UserDetails;
import org.springframework.stereotype.Component;
import java.util.*;
import io.jsonwebtoken.Claims;
import io.jsonwebtoken.Jwts;
import io.jsonwebtoken.SignatureAlgorithm;
import io.jsonwebtoken.io.Decoders;
import io.jsonwebtoken.security.Keys;
import java.security.Key;
import java.util.function.Function;
@Component
public class JWTUtil {
    
   @Value("${jwt_secret}")
   private String secret;

   @Value("${jwt_expiration}")
   private long jwtExpiration;

   public String extractUsername(String token) {
        return extractClaim(token, Claims::getSubject);
    }

    public <T> T extractClaim(String token, Function<Claims, T> claimsResolver) {
        final Claims claims = extractAllClaims(token);
        return claimsResolver.apply(claims);
    }

    public String generateToken(UserDetails userDetails) {
        return generateToken(new HashMap<>(), userDetails);
    }

    public String generateToken(Map<String, Object> extraClaims, UserDetails userDetails) {
        return buildToken(extraClaims, userDetails, jwtExpiration);
    }

    public long getExpirationTime() {
        return jwtExpiration;
    }

    private String buildToken(
      Map<String, Object> extraClaims,
      UserDetails userDetails,
      long expiration
      ) {
      return Jwts
               .builder()
               .setClaims(extraClaims)
               .setSubject(userDetails.getUsername())
               .setIssuedAt(new Date(System.currentTimeMillis()))
               .setExpiration(new Date(System.currentTimeMillis() + expiration))
               .signWith(getSignInKey(), SignatureAlgorithm.HS256)
               .compact();
      }

      public boolean isTokenValid(String token, UserDetails userDetails) {
      final String username = extractUsername(token);
      return (username.equals(userDetails.getUsername())) && !isTokenExpired(token);
      }

      private boolean isTokenExpired(String token) {
      return extractExpiration(token).before(new Date());
      }

      private Date extractExpiration(String token) {
      return extractClaim(token, Claims::getExpiration);
      }

      private Claims extractAllClaims(String token) {
      return Jwts
               .parserBuilder()
               .setSigningKey(getSignInKey())
               .build()
               .parseClaimsJws(token)
               .getBody();
      }

      private Key getSignInKey() {
      byte[] keyBytes = Decoders.BASE64.decode(secret);
      return Keys.hmacShaKeyFor(keyBytes);
      }

   // public String generateToken(String username){
   //  return JWT.create()
   //  .withSubject(username)
   //  .withExpiresAt(new Date(System.currentTimeMillis() + 10 * 60 * 1000)) // 10 minutes
   //  .sign(Algorithm.HMAC256(secret));
   // }

   // public String validateTokenAndRetrieveSubject(String token){
   //  return JWT.require(Algorithm.HMAC256(secret))
   //  .build()
   //  .verify(token)
   //  .getSubject();
   // }
}
