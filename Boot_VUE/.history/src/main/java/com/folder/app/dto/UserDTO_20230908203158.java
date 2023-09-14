package com.folder.app.dto;

import java.time.LocalDate;

import lombok.Data;

@Data
public class UserDTO {
    private int no;
    private String name;
    private String email;
    private String pwd;
    private char gender;
    private char del;
    private LocalDate regDate;


}   // end class
