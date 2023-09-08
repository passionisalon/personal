package com.folder.app.dao;

import java.util.List;

import com.folder.app.dto.UserDTO;

import lombok.extern.log4j.Log4j2;

@Log4j2
public class UserDaoImpl implements UserDao {

    public getThisClassInfo(){
       log.info("thisClass is {}",this.getClass().getName()) ;
    }

    @Override
    public List<UserDTO> findAll() {
        // TODO Auto-generated method stub
        throw new UnsupportedOperationException("Unimplemented method 'findAll'");
    }

    @Override
    public int editById(UserDTO uDto) {
        // TODO Auto-generated method stub
        throw new UnsupportedOperationException("Unimplemented method 'editById'");
    }

    @Override
    public int delete(int no) {
        // TODO Auto-generated method stub
        throw new UnsupportedOperationException("Unimplemented method 'delete'");
    }

    @Override
    public int save(UserDTO uDto) {
        // TODO Auto-generated method stub
        throw new UnsupportedOperationException("Unimplemented method 'save'");
    }
    
}
