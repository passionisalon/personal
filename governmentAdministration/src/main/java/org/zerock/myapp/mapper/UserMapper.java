package org.zerock.myapp.mapper;

import org.zerock.myapp.domain.UserDTO;
import org.zerock.myapp.domain.UserVO;

public interface UserMapper {
	
	// 사용자 정보들고오기
	public abstract UserDTO UserInfo(String email);
	
	// 로그인
	public abstract UserVO loginUser(UserDTO userDTO);
	
	// 회원가입
	public abstract Integer insertJoin(UserDTO userDTO);
	
	// 이메일 중복확인 
	public abstract Integer checkDistinctEmail(String userEmail);
	
	// 회원정보 수정
	public abstract Integer updateUserInformation(UserDTO dto);
}	// end interface
