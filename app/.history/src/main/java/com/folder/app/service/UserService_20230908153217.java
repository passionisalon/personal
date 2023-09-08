package com.folder.app.service;

import com.folder.app.dto.ResultDTO;

public interface UserService {
    
    public abstract ResultDTO findAll();
    public abstract ResultDTO editById(UserDTO uDto);
}   // end interface
