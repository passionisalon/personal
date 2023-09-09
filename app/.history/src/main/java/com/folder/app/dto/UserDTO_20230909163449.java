package com.folder.app.dto;

import java.time.LocalDate;

import lombok.Data;
@Data
public class UserDTO {
    private int no;
    private String name;
    private String email;
    private String pwd;
    private boolean gender;
    private boolean del;
    private LocalDate regDate;


}   // end class
