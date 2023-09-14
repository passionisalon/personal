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
            resultDTO.setResult(resultList);
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
        this.getThisClassInfo();
        log.info("state : {}",state);
        if(state == 1){
            resultDTO.setState(true);
            resultDTO.setMessage("사용자 수정에 성공하였습니다.");
        }else{
            resultDTO.setState(false);
            resultDTO.setMessage("사용자 수정에 실패하였습니다.");
        }
        
        return this.resultDTO;
    }   // end editById

    @Override
    public ResultDTO delete(int no){
        this.getThisClassInfo();
        log.info("editById(int no : {}) invoked.",no);
        resultDTO = new ResultDTO();
        int state = userDao.delete(no);
        if(state == 1){
            resultDTO.setState(true);
            resultDTO.setMessage("사용자 삭제가 성공하였습니다.");
        }else{
            resultDTO.setState(false);
            resultDTO.setMessage("사용자 삭제가 실패하였습니다.");
        }
        return this.resultDTO;
    }   // end delete
    
    @Override
    public ResultDTO save(UserDTO uDto){
        this.getThisClassInfo();
        log.info("editById(UserDTO : {}) invoked.",uDto);
        resultDTO = new ResultDTO();
        ResultDTO resultDTO = userDao.save(uDto);
        if(resultDTO.getState() == 1){
            resultDTO.setState(true);
            resultDTO.setMessage("사용자 생성이 성공하였습니다.");
        }else{
            resultDTO.setState(false);
            resultDTO.setMessage("사용자 생성을 실패하였습니다.");
        }
        return this.resultDTO;
    }   // end save


}   // end class
