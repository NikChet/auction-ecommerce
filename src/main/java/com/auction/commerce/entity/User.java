package com.auction.commerce.entity;

// import jakarta.annotation.Generated;
import jakarta.persistence.Column;
import jakarta.persistence.Entity;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;
import jakarta.persistence.Id;
import jakarta.persistence.Table;

@Entity
@Table(name="user")
public class User {

    @Id
    @Column(name="username")
    private String username;

    @Column(name="password")
    private String password;

    @Column(name = "role")
    private String role;

    public User() {
        super();
    }
    
    public User(String userName, String passWord) {
        this.username = userName;
        this.password = passWord;
    }

    public String getUsername() {
        return username;
    }

    public String getPassword() {
        return password;
    }

    public String getRole(){
        return role;
    }
    public void setUsername(String username) {
        this.username = username;
    }

    public void setPassword(String password) {
        this.password = password;
    }

    @Override
    public String toString() {
        return "login [userName=" + username + ", passWord=" + password + "]";
    }
    
    

    // public login(String userName, String passWord) {
    //     this.userName = userName;
    //     this.passWord = passWord;
    // }
    
    // public String getUserName() {
    //     return userName;
    // }
    // public void setUserName(String userName) {
    //     this.userName = userName;
    // }
    // public String getPassWord() {
    //     return passWord;
    // }
    // public void setPassWord(String passWord) {
    //     this.passWord= passWord;
    // }

    // @Override
    // public String toString() {
    //     return "product [id=" + userName + ", product_name=" + passWord + "]";
    // }
}
