package com.folder.app.mapper;

import java.util.List;

import org.apache.ibatis.annotations.Insert;
import org.apache.ibatis.annotations.Mapper;
import org.apache.ibatis.annotations.Select;
import org.apache.ibatis.annotations.Update;

import com.folder.app.dto.UserDTO;

@Mapper
public interface UserMapper {

    @Select("SELECT * FROM user3")
    public List<UserDTO> findAll();

    @Update("UPDATE USER3 SET NAME = #{name}, pwd = #{pwd}, gender = #{gender} WHERE no = #{no}")
    public int editById(UserDTO uDto);

    // 1을 전달 받기 위해 DELETE가 아닌 UPDATE를 사용함
    @Update("UPDATE user3 set del = true WHERE no = #{no}")
    public int delete(int no);

    @Insert
}   // end interface
