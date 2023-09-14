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
    
    @CrossOrigin(origins = "http://localhost:8800")
    @GetMapping("/")
    public String home(){
        return "Data 준비 중....";
    }   // end home

    @GetMapping("/api")
    public String api(){
        log.info("GetMapping api() invoked.");
        return "Api Data 준비 중 ...";
    }   // end api

    @PostMapping("/findAll")
    public void findAll(){
    
    }

@PostMapping("/editById")
public void editById(){

}

@DeleteMapping("/delete")
public void delete(){
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
