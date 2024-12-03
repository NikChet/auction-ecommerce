package com.auction.commerce.security;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Configurable;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.security.authentication.AuthenticationManager;
import org.springframework.security.config.annotation.authentication.builders.AuthenticationManagerBuilder;
import org.springframework.security.config.annotation.web.builders.HttpSecurity;
import org.springframework.security.config.http.SessionCreationPolicy;
import org.springframework.security.crypto.bcrypt.BCrypt;
import org.springframework.security.crypto.password.PasswordEncoder;

import com.auction.commerce.services.UserServiceImp;
import org.springframework.security.web.SecurityFilterChain;
import org.springframework.security.crypto.bcrypt.BCryptPasswordEncoder;
import org.springframework.security.crypto.password.PasswordEncoder;

@Configuration
public class SecurityConfig {
    @Autowired
    private final UserServiceImp userServiceImp;

    public SecurityConfig(UserServiceImp userServiceImp){
        this.userServiceImp = userServiceImp;
    }

    //configures HTTP security setting for application like authorizatin rules, session management
    @Bean
    public SecurityFilterChain filterChain(HttpSecurity http) throws Exception{
        http
        .csrf(csrf -> csrf.disable())
        .authorizeHttpRequests(auth -> auth
        .requestMatchers("/auth/login").permitAll() // Allow public access to login
        .anyRequest().authenticated()
         // Require authentication for all other requests
        )
        .sessionManagement(session -> session
        .sessionCreationPolicy(SessionCreationPolicy.STATELESS) // creating of session for every Request
        );

        return http.build();
    }


    //Authenticating users
    @Bean
    public AuthenticationManager authenticationManager(HttpSecurity http) throws Exception{
        AuthenticationManagerBuilder authenticationManagerBuilder = http.getSharedObject(AuthenticationManagerBuilder.class); // Retrieves the AuthenticationManagerBuilder from the HttpSecurity object to build AuthenticationManager
        authenticationManagerBuilder.userDetailsService(userServiceImp) // Tells Spring Security to use UserServiceImp for user authentication
        .passwordEncoder(passwordEncoder());

        return authenticationManagerBuilder.build();
    }


    @Bean
    public PasswordEncoder passwordEncoder(){
        return new BCryptPasswordEncoder(); // ensures that passwords are stored and compared securely by hashing the before storage
    }
}
