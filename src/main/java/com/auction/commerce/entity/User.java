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
    // @GeneratedValue(strategy = GenerationType.IDENTITY)
    // private int id;
    @Column(name="username")
    private String username;

    @Column(name="password")
    private String passWord;

    public User() {
        super();
    }
    
    public User(String userName, String passWord) {
        this.username = userName;
        this.passWord = passWord;
    }

    public String getUserName() {
        return username;
    }

    public String getPassWord() {
        return passWord;
    }

    public void setUserName(String userName) {
        this.username = userName;
    }

    public void setPassWord(String passWord) {
        this.passWord = passWord;
    }

    @Override
    public String toString() {
        return "login [userName=" + username + ", passWord=" + passWord + "]";
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
