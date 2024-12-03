package com.auction.commerce.services;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import java.util.*;
// import com.auction.commerce.repository.ProductRepository;
import com.auction.commerce.entity.Cart;
import com.auction.commerce.repository.CartRepository;

@Service
public class cartServiceImp implements cartSevice{

    @Autowired
    private CartRepository cart_repo;

    @Override 
    public List<Cart> findProductsOfCart(String username){
        return cart_repo.findByUsername(username);
    }
}
