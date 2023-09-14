package com.folder.app.service;

import com.folder.app.dto.ResultDTO;
import com.folder.app.dto.UserDTO;

public class UserServiceImpl implements UserService{
    
    public abstract ResultDTO findAll();
    public abstract ResultDTO editById(UserDTO uDto);
    public ResultDTO delete(int no);
    public ResultDTO save(UserDTO uDto);


}   // end class
