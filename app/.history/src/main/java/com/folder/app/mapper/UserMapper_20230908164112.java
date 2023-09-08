package com.folder.app.mapper;

import java.util.List;

import org.apache.ibatis.annotations.Mapper;

import com.folder.app.dto.UserDTO;

@Mapper
public interface UserMapper {

    @Select("SELECT * FROM user3")
    public List<UserDTO> findAll();

    public int editById(UserDTO uDto);
}   // end interface
