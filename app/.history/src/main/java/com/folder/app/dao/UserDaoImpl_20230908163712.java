package com.folder.app.dao;

import java.util.List;

import org.springframework.stereotype.Repository;

import com.folder.app.dto.UserDTO;

import lombok.extern.log4j.Log4j2;

@Log4j2
@Repository
public class UserDaoImpl implements UserDao {

    public void getThisClassInfo(){
       log.info("thisClass is {}",this.getClass().getName()) ;
    }

    @Override
    public List<UserDTO> findAll() {
        this.getThisClassInfo();
        log.info("findAll() invoked.");
        
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
