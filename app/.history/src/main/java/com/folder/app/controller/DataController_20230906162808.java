package com.folder.app.controller;

import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RestController;

import lombok.extern.log4j.Log4j2;

@Log4j2
@RestController
public class DataController {
    
    @GetMapping("/")
    public String home(){
        return "Data 준비 중....";
    }   // end home

    @GetMapping("/api")
    public String api(){
        log.info("GetMapping api() invoked.");
    }

    // @CrossOrigin(origins="http://localhost:8800")
    // @PostMapping("/api")
    // public String post(){
    //     return "Method:Post";
    // }   // end post
    
    // @PutMapping("/api")
    // public String put(){
    //     return "Method:PUT";
    // }   // end put
    
}   // end class
