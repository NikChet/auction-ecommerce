package com.auction.commerce.controller;

import org.springframework.bootpackage com.auction.commerce.controller;
import java.util.*;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;


import com.auction.commerce.entity.product;
import com.auction.commerce.services.loginService;
import com.auction.commerce.services.productService;


@CrossOrigin(origins = "http://localhost:3000")
@RestController
public class GetDefaultResponse {

    // @RequestMapping("/")
    // public long displaySum(){
    //     return 100;
    // }
    @Autowired
    private productService Product_service;

    @Autowired
    private loginService login_passWord;

    //get the products
    @GetMapping("/products")
    public List<product> productName(){
        return this.Product_service.getProducts();
    }

    @RequestMapping("/login")
    public String loginStatus(){
        return "Success";
    }

    @GetMapping("/login/{name}")
    public String getUserInfo(@PathVariable String name) {
        return login_passWord.User_password(name);
    }
    
}

.autoconfigure.SpringBootApplication;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
public class GetDefaultResponse {

    @RequestMapping("/")
    public long displaySum(){
        return 100;
    }

}
