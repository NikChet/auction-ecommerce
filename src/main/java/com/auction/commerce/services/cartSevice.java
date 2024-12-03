package com.auction.commerce.services;

import com.auction.commerce.entity.Cart;
import java.util.*;


public interface cartSevice {
    public List<Cart> findProductsOfCart(String username);    
}