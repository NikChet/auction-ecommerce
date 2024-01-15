package com.auction.commerce.services;
import java.util.List;

import org.springframework.stereotype.Service;

import java.util.ArrayList;



import com.auction.commerce.entity.product;

@Service
public class productServiceImp implements productService {

    @Override
    public List<product> getProducts(){
        List<product> list;
        list = new ArrayList<>();
        list.add(new product(345, "Gaming Keyboard", "The bestselling keyboard at minimum price"));

        list.add(new product(321, "Bluetooth mouse", "wireless mouse"));
        return list;
    }
}
