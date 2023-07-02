package org.zerock.myapp.service;

import org.zerock.myapp.domain.UserDTO;
import org.zerock.myapp.domain.UserVO;
import org.zerock.myapp.exception.ServiceException;

public interface UserService {
	
	// 사용자 정보들고오기
	public abstract UserDTO UserInfo(String email) throws ServiceException;
	
	// 로그인
	public abstract UserVO loginUser(UserDTO userDTO) throws ServiceException;
	// 회원가입
	public abstract Integer insertJoin(UserDTO userDTO) throws ServiceException;
	// 이메일 중복확인
	public abstract Integer checkDistinctEmail(String userEmail) throws ServiceException;
	// 회원정보 수정
	public abstract Integer updateUserInformation(UserDTO dto) throws ServiceException;
	
}	// 	end interface
