package com.folder.app.dao;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Repository;

import com.folder.app.dto.UserDTO;
import com.folder.app.mapper.UserMapper;

import lombok.extern.log4j.Log4j2;

@Log4j2
@Repository
public class UserDaoImpl implements UserDao {

    @Autowired
    UserMapper userMapper;

    public void getThisClassInfo(){
       log.info("thisClass is {}",this.getClass().getName()) ;
    }

    @Override
    public List<UserDTO> findAll() {
        this.getThisClassInfo();
        log.info("findAll() invoked.");
        return userMapper.findAll();
    }

    @Override
    public int editById(UserDTO uDto) {
        this.getThisClassInfo();
        log.info("editById(UserDTO : {}) invoked.",uDto);
        return 0;
    }

    @Override
    public int delete(int no) {
        this.getThisClassInfo();
        log.info("delete(UserDTO : {}) invoked.",uDto);
        return 0;
    }

    @Override
    public int save(UserDTO uDto) {
        this.getThisClassInfo();
        log.info("save(UserDTO : {}) invoked.",uDto);
        return 0;
    }
    
}
