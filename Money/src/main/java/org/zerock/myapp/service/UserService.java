package org.zerock.myapp.service;

import java.util.List;

import javax.servlet.http.HttpServletRequest;

import org.springframework.ui.Model;
import org.zerock.myapp.domain.UserDTO;
import org.zerock.myapp.exception.ServiceException;

public interface UserService {
	
	// 로그인 
	public abstract Boolean UserLogin(String Email,String Pw,HttpServletRequest hsr,Model model) throws ServiceException;
	
	// 이메일 중복첵크
	public abstract Integer distinckedEmail(String Email) throws ServiceException;
	
	// 닉네임 중복첵크
	public abstract Integer distinckedNickName(String NickName) throws ServiceException;
	
	// 회원가입
	public abstract Boolean insertJoin(UserDTO userDTO) throws ServiceException;
	
	// 이메일 찾기
	public abstract List<String> findEmail(String userEmail) throws ServiceException;
}	// end interface
