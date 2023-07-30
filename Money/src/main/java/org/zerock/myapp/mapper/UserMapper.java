package org.zerock.myapp.mapper;

import org.zerock.myapp.domain.UserDTO;

public interface UserMapper {

//	사용자 정보확인 로그인 시
	public abstract UserDTO UserLogin(String Email, String Pw);
	
	
	
	
	
	
}	//	end interface
