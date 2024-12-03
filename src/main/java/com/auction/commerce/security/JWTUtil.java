package com.auction.commerce.security;

import java.util.Date;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.filter.OncePerRequestFilter;

import com.auction.commerce.services.UserServiceImp;
import com.auth0.jwt.JWT;
import com.auth0.jwt.algorithms.Algorithm;

import org.springframework.beans.factory.annotation.Value;
// import lombok.Value;
import org.springframework.stereotype.Component;

@Component
public class JWTUtil {
    
   @Value("${jwt_secret}")
   private String secret;

   public String generateToken(String username){
    return JWT.create()
    .withSubject(username)
    .withExpiresAt(new Date(System.currentTimeMillis() + 10 * 60 * 1000)) // 10 minutes
    .sign(Algorithm.HMAC256(secret));
   }

   public String validateTokenAndRetrieveSubject(String token){
    return JWT.require(Algorithm.HMAC256(secret))
    .build()
    .verify(token)
    .getSubject();
   }
}
