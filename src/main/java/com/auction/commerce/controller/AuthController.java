package com.auction.commerce.controller;

import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RestController;

import com.auction.commerce.security.JWTUtil;
import com.auction.commerce.dto.LoginUserDto;
import com.auction.commerce.dto.RegisterUserDto;
import com.auction.commerce.entity.User;
import com.auction.commerce.services.AuthenticationServiceImpl;


@RestController
public class AuthController {
    
    private final JWTUtil jwtUtil;
    private final AuthenticationServiceImpl authenticationService;

    public AuthController(JWTUtil jwtService, AuthenticationServiceImpl authenticationService) {
        this.jwtUtil = jwtService;
        this.authenticationService = authenticationService;
    }

    @PostMapping("/auth/login")
    // @RequestBody binds JSON payload sent in HTTP request body to the AuthRequest object
    // JSON is deserialized into an AuthRequest object with the corresponding values for username and password
    public String login(@RequestBody LoginUserDto loginUserDto){
        try{
             System.out.println("this is login api");
            // authenticationManager.authenticate() delegates authentication request to UserServiceImp. Fetches the user's details from database and verifies the credentials.
            User authenticatedUser = authenticationService.authenticate(loginUserDto);
                // If authentication is successfull it returns and Authentication object containing the authenticated user's  details.
            return jwtUtil.generateToken(authenticatedUser); //  If credentials are valid, JWT token is generated and returned to user.
        }catch (Exception e){
            System.out.println("kuch toh exception aaya hai");
            throw new RuntimeException("Invalid credentials");
        }
    }

    @PostMapping("/auth/signup")
    public ResponseEntity<User> register(@RequestBody RegisterUserDto registerUserDto) {
        try {
            User registeredUser = authenticationService.signup(registerUserDto);

            return ResponseEntity.ok(registeredUser);
        } catch (Exception e){
            System.out.println("kuch toh exception aaya hai");
            throw new RuntimeException("invalid signup information");
        }
        
    }
}
