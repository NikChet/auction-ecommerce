package com.auction.commerce.services;


import java.util.ArrayList;
import java.util.List;

import org.springframework.stereotype.Service;
import com.auction.commerce.entity.login;

@Service
public class loginServiceImp implements loginService {

    List<login> list = new ArrayList<>();
    

    @Override
    public String User_password(String name) {
        list.add(new login("user1", "pass1"));
        list.add(new login("user2", "pass2"));

        for(login l : list){
            if(l.getUserName().equals(name)){
                return l.getPassWord();
            }
        }

        return "";
    }
    
}
