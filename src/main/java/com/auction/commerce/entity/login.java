package com.auction.commerce.entity;

public class login {
    private String userName;
    private String passWord;
    

    public login(String userName, String passWord) {
        this.userName = userName;
        this.passWord = passWord;
    }
    public login() {
        super();
    }
    public String getUserName() {
        return userName;
    }
    public void setUserName(String userName) {
        this.userName = userName;
    }
    public String getPassWord() {
        return passWord;
    }
    public void setPassWord(String passWord) {
        this.passWord= passWord;
    }

    @Override
    public String toString() {
        return "product [id=" + userName + ", product_name=" + passWord + "]";
    }
}
