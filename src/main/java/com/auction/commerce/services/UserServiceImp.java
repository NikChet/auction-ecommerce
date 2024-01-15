package com.auction.commerce.services;

import java.lang.String;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.auction.commerce.entity.User;
// import com.auction.commerce.entity.User;
import com.auction.commerce.repository.UserRepository;
// import com.mysql.cj.x.protobuf.MysqlxDatatypes.Scalar.String;


@Service
public class UserServiceImp implements UserService {

    // List<login> list = new ArrayList<>();
    @Autowired
    private UserRepository user_repo;


    @Override
    public String user_password(String uname) {
        // list.add(new login("user1", "pass1"));
        // list.add(new login("user2", "pass2"));

        // for(login l : list){
        //     if(l.getUserName().equals(name)){
        //         return l.getPassWord();
        //     }
        // }
        // System.out.println(lgRepo.findById(name));
        // return user_repo.findByUserName(name);
        try{
            User u = user_repo.findByUserName(uname);
            return u.getPassWord();
        }
        catch (Exception e){
            e.printStackTrace();
            return "Error";
        }
        
        
        
    }
    
}
