package com.auction.commerce.controller;

import javax.naming.AuthenticationException;

import org.springframework.security.authentication.AuthenticationManager;
import org.springframework.security.authentication.UsernamePasswordAuthenticationToken;
import org.springframework.security.core.Authentication;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.auction.commerce.security.JWTUtil;

@CrossOrigin(origins = "http://localhost:3000")
@RestController
@RequestMapping("/auth")
public class AuthController {
    
    private final AuthenticationManager authenticationManager;
    private final JWTUtil jwtUtil;
        
    public AuthController(AuthenticationManager authenticationManager, JWTUtil jwtUtil){
        this.authenticationManager = authenticationManager;
        this.jwtUtil = jwtUtil;
    }

    @PostMapping("/login")
    // @RequestBody binds JSON payload sent in HTTP request body to the AuthRequest object
    // JSON is deserialized into an AuthRequest object with the corresponding values for username and password
    public String login(@RequestBody AuthRequest authRequest){
        try{
            // authenticationManager.authenticate() delegates authentication request to UserServiceImp. Fetches the user's details from database and verifies the credentials.
            Authentication authentication = authenticationManager.authenticate(
                // This is a wrapper for user's credentials
                new UsernamePasswordAuthenticationToken(authRequest.getUsername(), authRequest.getPassword())
                );
                // If authentication is successfull it returns and Authentication object containing the authenticated user's  details.
            return jwtUtil.generateToken(authentication.getName()); //  If credentials are valid, JWT token is generated and returned to user.
        }catch (Exception e){
            throw new RuntimeException("Invalid credentials");
        }
    }
}
