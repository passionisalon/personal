package com.folder.app.mapper;

import java.util.List;

import org.apache.ibatis.annotations.Insert;
import org.apache.ibatis.annotations.Mapper;
import org.apache.ibatis.annotations.Select;
import org.apache.ibatis.annotations.Update;
import org.apache.ibatis.jdbc.AbstractSQL.SQLStatement.StatementType;
import org.springframework.boot.autoconfigure.security.SecurityProperties.User;

import com.folder.app.dto.UserDTO;

@Mapper
public interface UserMapper {

    @Select("SELECT * FROM user3 WHERE del != 0")
    public List<UserDTO> findAll();

    @Update("""
        UPDATE USER3 SET 
            name = #{name}, 
            pwd = #{pwd},
            gender = #{gender} 
        WHERE no = #{no}
                """)
    public int editById(UserDTO uDto);

    // 1을 전달 받기 위해 DELETE가 아닌 UPDATE를 사용함
    @Update("""
            UPDATE user3 set 
                del = true
            WHERE no = #{no}
            """)
    public int delete(int no);

    @SelectKey(statementType = org.apache.ibatis.mapping.StatementType.PREPARED, statement="select last_insert_id() as no")
    @Insert("""
        INSERT INTO user3 
            (name,email,pwd,gender) 
        VALUES 
            (#{name},#{email},#{pwd},#{gender})
            """)
    public int save(UserDTO uDto);
}   // end interface