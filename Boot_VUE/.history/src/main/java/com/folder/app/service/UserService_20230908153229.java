package com.folder.app.service;

import com.folder.app.dto.ResultDTO;
import com.folder.app.dto.UserDTO;

public interface UserService {
    
    public abstract ResultDTO findAll();
    public abstract ResultDTO editById(UserDTO uDto);
}   // end interface
