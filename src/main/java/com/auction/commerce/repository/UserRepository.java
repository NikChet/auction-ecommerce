package com.auction.commerce.repository;

import java.util.Optional;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.CrudRepository;
import org.springframework.stereotype.Repository;
import com.auction.commerce.entity.User;



@Repository
public interface UserRepository extends CrudRepository<User, String>{

    @Query("SELECT u.password FROM User u WHERE u.username = ?1")
    Optional<String> findByUsername(String username);
}

