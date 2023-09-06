package com.folder.app.controller;

import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
public class DataController {
    
    @GetMapping("/")
    public String home(){
        return "Data 준비 중....";
    }   // end home

    @CrossOrigin(origins="http://localhost:8800")
    @PostMapping("/api")
    public String post(){
        return "Method:Post";
    }   // end post
    
    @PutMapping("/api")
    public String put(){
        return "Method:PUT";
    }   // end put
    
}   // end class
