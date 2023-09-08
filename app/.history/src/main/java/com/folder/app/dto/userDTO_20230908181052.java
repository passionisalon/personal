package com.folder.app.dto;

import java.time.LocalDate;

import lombok.Data;

@Data
public class UserDTO {
    private int seq;
    private String name;
    private String email;
    private String pwd;
    private Boolean gender;
    private char del;
    private LocalDate regDate;


}   // end class
