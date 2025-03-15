package com.auction.commerce.controller;
import java.util.*;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.security.crypto.bcrypt.BCrypt;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;
import com.auction.commerce.entity.Product;
import com.auction.commerce.entity.User;
// import com.auction.commerce.repository.UserRepository;
import com.auction.commerce.entity.Cart;
import com.auction.commerce.services.UserService;
import com.auction.commerce.services.productService;
import com.auction.commerce.services.cartSevice;


@RestController
@CrossOrigin(origins = "http://localhost:3000") 
// @RestController
public class GetDefaultResponse {

    @RequestMapping("/")
    public long displaySum(){
        return 100;
    }
    @Autowired
    private productService Product_service;

    @Autowired
    private UserService uService;

    @Autowired
    private cartSevice cartService;

    @GetMapping("/login/{username}")
    public ResponseEntity<String> getMethodName(@PathVariable String username) {
        String storedPassword = uService.user_password(username);
        if(storedPassword == null || storedPassword.isEmpty()){
            return ResponseEntity.status(404).body("User not found");
        }
        return ResponseEntity.ok(storedPassword);
    }
    

    //get the products
    @GetMapping("/products")
    public ResponseEntity<List<Product>> getAllProducts(){
        List<Product> list = Product_service.findAllProducts();
        return ResponseEntity.ok(list);
    }

    @RequestMapping(value = "/products/{Id}", method = RequestMethod.GET)
     public ResponseEntity<Product> getProductById(@PathVariable String Id){
        // Optional<product> p = Product_service.findProductById(Id);
        System.out.println("hello " + Id);
        Product p = Product_service.findProductById(Id);
        return ResponseEntity.ok(p);
     }

    @GetMapping("/cart/{username}")
    public List<Cart> getAllProductsForUsername(@PathVariable String username){
        return cartService.findProductsOfCart(username);
    }  
}

