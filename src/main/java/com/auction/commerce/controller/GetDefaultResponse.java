package com.auction.commerce.controller;

import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
public class GetDefaultResponse {

    @RequestMapping("/")
    public long displaySum(){
        return 100;
    }

}