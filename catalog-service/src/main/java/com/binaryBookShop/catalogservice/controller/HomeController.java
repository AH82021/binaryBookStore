package com.binaryBookShop.catalogservice.controller;

import com.binaryBookShop.catalogservice.config.BinaryProperties;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
public class HomeController {
    private final BinaryProperties binaryProperties;

    public HomeController(BinaryProperties binaryProperties) {
        this.binaryProperties = binaryProperties;
    }
    @GetMapping("/")
    public String greeting(){
        return binaryProperties.getGreeting();
    }
}
