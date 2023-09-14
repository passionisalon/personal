package com.folder.app.service;

import com.folder.app.dto.ResultDTO;
import com.folder.app.dto.UserDTO;

import lombok.extern.log4j.Log4j2;

@Log4j2
public class UserServiceImpl implements UserService{
    
    private ResultDTO resultDTO;

    public void getThisClassInfo(){
        log.info("this Class is : {}",this.getClass().getName());    
    }

    @Override
    public ResultDTO findAll(){
        this.getThisClassInfo();
        log.info("findAll() invoked.");
    }   // end findAll

    @Override
    public ResultDTO editById(UserDTO uDto){
        this.getThisClassInfo();
    }

    @Override
    public ResultDTO delete(int no){
        this.getThisClassInfo();
    }
    
    @Override
    public ResultDTO save(UserDTO uDto){
        this.getThisClassInfo();
    }


}   // end class
