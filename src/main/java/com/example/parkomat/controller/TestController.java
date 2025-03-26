package com.example.parkomat.controller;


import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;
@CrossOrigin(origins = "http://localhost:5174") // Pozwala na żądania z frontendu
@RequestMapping("/api")
@RestController
public class TestController {

    @GetMapping("/test")
    public String test() {
        return "Połączenie z back-endem działa.";
    }

}
