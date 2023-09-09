package com.folder.app.service;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.folder.app.dao.UserDao;
import com.folder.app.dto.ResultDTO;
import com.folder.app.dto.UserDTO;

import lombok.extern.log4j.Log4j2;

@Log4j2
@Service
public class UserServiceImpl implements UserService{
    
    private ResultDTO resultDTO;

    @Autowired UserDao userDao;

    public void getThisClassInfo(){
        log.info("this Class is : {}",this.getClass().getName());    
    }   // getThisClassInfo

    @Override
    public ResultDTO findAll(){
        this.getThisClassInfo();
        log.info("findAll() invoked.");

        resultDTO = new ResultDTO();
        List<UserDTO> resultList = userDao.findAll();

        if(resultList != null){
            resultDTO.setState(true);
            resultDTO.setUDto(resultList);
        }else{
            resultDTO.setState(false);
        }

        return this.resultDTO;
    }   // end findAll

    @Override
    public ResultDTO editById(UserDTO uDto){
        this.getThisClassInfo();
        log.info("editById(UserDTO : {}) invoked.",uDto);
        
        resultDTO = new ResultDTO();
        int state = userDao.editById(uDto);
        if(state == 1){
        
        }else{
        
        }
        
        return this.resultDTO;
    }   // end editById

    @Override
    public ResultDTO delete(int no){
        this.getThisClassInfo();
        log.info("editById(int no : {}) invoked.",no);
        return this.resultDTO;
    }   // end delete
    
    @Override
    public ResultDTO save(UserDTO uDto){
        this.getThisClassInfo();
        log.info("editById(UserDTO : {}) invoked.",uDto);
        return this.resultDTO;
    }   // end save


}   // end class
