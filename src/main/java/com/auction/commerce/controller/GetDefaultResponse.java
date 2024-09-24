package com.auction.commerce.controller;
import java.util.*;
// import java.util.Collection.stream();

import org.springframework.beans.factory.annotation.Autowired;
// import org.springframework.http.HttpStatus;
// import org.springframework.http.HttpStatusCode;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RestController;

// import com.auction.commerce.entity.User;
import com.auction.commerce.entity.Product;
import com.auction.commerce.entity.Cart;
import com.auction.commerce.services.UserService;
import com.auction.commerce.services.productService;
import com.auction.commerce.services.cartSevice;
import org.springframework.web.bind.annotation.RequestParam;



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
    private UserService uService;

    @Autowired
    private cartSevice cartService;

    //get the products
    @GetMapping("/products")
    public ResponseEntity<List<Product>> getAllProducts(){
        List<Product> list = Product_service.findAllProducts();
        return ResponseEntity.ok(list);
    }

    // @GetMapping("/products/{id}")
    @RequestMapping(value = "/products/{Id}", method = RequestMethod.GET)
     public ResponseEntity<Product> getProductById(@PathVariable String Id){
        // Optional<product> p = Product_service.findProductById(Id);
        System.out.println("hello " + Id);
        Product p = Product_service.findProductById(Id);
        return ResponseEntity.ok(p);
     }

    @RequestMapping("/login")
    public String loginStatus(){
        return "Success";
    }

    // @GetMapping("/login/{name}")
    // public login getUserInfo(@PathVariable String name) {

    //     return login_passWord.User_password(name);
    // }

    @GetMapping("/login/{name}")
    public ResponseEntity<String> getUserInfo(@PathVariable String name){
        String password = uService.user_password(name);
        if (password != null) {
            System.out.print(password);
            return ResponseEntity.ok(password);
        } else {
            return ResponseEntity.notFound().build();
        }
    }

    @GetMapping("/cart/{username}")
    public List<Cart> getAllProductsForUsername(@PathVariable String username){
        // List<Product> list = Product_service.findAllProducts();
        // return ResponseEntity.ok(list);
        // List<Cart> cartList = cartService.findProductsOfCart(username);
        //     return cartList.stream().map(cart -> new CartDTO(cart.getUsername().getUsername(), cart.getProductId().getProductId(), cart.getQuantity(), cart.getPrice())).collect(Collectors.toList());
        return cartService.findProductsOfCart(username);
    }

    // @GetMapping("")
    // public SomeData getMethodName(@RequestParam String param) {
    //     return new SomeData();
    // }
    
    
}

