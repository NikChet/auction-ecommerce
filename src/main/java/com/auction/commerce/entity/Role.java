package com.auction.commerce.entity;

import jakarta.persistence.Entity;
import jakarta.persistence.EnumType;
import jakarta.persistence.Enumerated;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;
import jakarta.persistence.Id;
import jakarta.persistence.JoinColumn;
import jakarta.persistence.OneToOne;

@Entity
public class Role {

    public enum RoleType {
        BUYER, 
        SELLER,
        ADMIN;
    }
    
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id; // Auto-generated primary key

    @OneToOne
    @JoinColumn(name = "username", referencedColumnName = "username", nullable = false)
    private User user; // One-to-One relationship with User

    @Enumerated(EnumType.STRING)
    private RoleType role; // Role can be Admin, User, or Moderator

    // Getters and setters
    public Long getId() {
        return id;
    }

    public void setId(Long id) {
        this.id = id;
    }

    public User getUser() {
        return user;
    }

    public void setUser(User user) {
        this.user = user;
    }

    public RoleType getName() {
        return role;
    }

    public void setRole(RoleType role) {
        this.role = role;
    }
}
