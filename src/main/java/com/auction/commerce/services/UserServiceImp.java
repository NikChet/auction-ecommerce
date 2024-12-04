package com.auction.commerce.services;

import java.lang.String;
import java.util.Collections;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.core.GrantedAuthority;
import org.springframework.security.core.authority.SimpleGrantedAuthority;
import org.springframework.security.core.userdetails.UserDetails;
import org.springframework.security.core.userdetails.UserDetailsService;
import org.springframework.security.core.userdetails.UsernameNotFoundException;
import org.springframework.stereotype.Service;

import com.auction.commerce.entity.Role;
import com.auction.commerce.entity.User;
import com.auction.commerce.repository.UserRepository;


@Service
public class UserServiceImp implements UserService, UserDetailsService {

    @Autowired
    private UserRepository userRepo;


    @Override
    public String user_password(String username) throws UsernameNotFoundException {
       return userRepo.findByUsername(username)
       .map(User::getPassword)
       .orElseThrow(() -> new UsernameNotFoundException("User not found"));
    }

    @Override
    public UserDetails loadUserByUsername(String username) throws UsernameNotFoundException{

        // Fetch the user from the database
        User user = userRepo.findByUsername(username)
        .orElseThrow(() -> new UsernameNotFoundException("User not Found"));

        // Get the associated role
        Role role = user.getRole();
        if (role == null) {
            throw new UsernameNotFoundException("Role not assigned to the user");
        }

        // Create a granted authority from the role
        GrantedAuthority authority = new SimpleGrantedAuthority(user.getRole().getName().name());



        return new org.springframework.security.core.userdetails.User(
            user.getUsername(), 
            user.getPassword(), 
            Collections.singletonList(authority)
        ); //No roles/authorities assigned for now
    }
    
}
