package com.folder.app.service;

import com.folder.app.dto.ResultDTO;
import com.folder.app.dto.UserDTO;

public interface UserService {
    
    public abstract ResultDTO findAll();
    public abstract ResultDTO editById(UserDTO uDto);
    public abstract ResultDTO delete(int seq);
    public abstract ResultDTO save(UserDTO uDto);


}   // end interface
