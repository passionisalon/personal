package com.folder.app.dao;

public interface UserDao {
    
    public List<UserDTO> findAll();
    public int editById(UserDTO uDto);


}   // end interface
