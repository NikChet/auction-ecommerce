package com.auction.commerce.repository;

import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.CrudRepository;
import org.springframework.stereotype.Repository;
import com.auction.commerce.entity.Cart;

import java.util.List;

@Repository
public interface CartRepository extends CrudRepository<Cart, Integer>{

    @Query("SELECT c FROM Cart c WHERE c.user.username = ?1")
     List<Cart> findByUsername(String username);
}
