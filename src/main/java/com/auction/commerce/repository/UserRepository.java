package com.auction.commerce.repository;

import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.CrudRepository;
import org.springframework.stereotype.Component;
// import org.springframework.stereotype.Component;
import org.springframework.stereotype.Repository;
// import org.springframework.web.bind.annotation.PathVariable;

import com.auction.commerce.entity.User;
// import java.util.List;


// @Repository
// @Component
public interface UserRepository extends CrudRepository<User, Integer>{

    @Query("SELECT u FROM User u WHERE u.userName = ?1")
    User findByUserName(String uname);
}
