package com.folder.app.dto;

import lombok.Data;

@Data
public class ResultDTO {
    private Boolean state;
    private UserDTO uDto;
    private String message;
}   // end class
