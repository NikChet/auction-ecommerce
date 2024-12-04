package com.auction.commerce.repository;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import com.auction.commerce.entity.Role;

@Repository
public interface RoleRepository extends JpaRepository<Role, Long> { // Primary key type is Long
    Role findByUser_Username(String username); // Find a Role by the associated User's username
}

