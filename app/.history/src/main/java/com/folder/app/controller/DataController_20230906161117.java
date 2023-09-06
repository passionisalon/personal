package com.folder.app.controller;

import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
public class DataController {
    
    @CrossOrigin(origins="http://localhost:8800")
    @PostMapping("/api")
    public String post(){
    }
    
    
    @GetMapping("/")
    public String home(){
        return "Data 준비 중....";
    }
}
