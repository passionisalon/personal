package org.zerock.myapp.mapper;

import org.zerock.myapp.domain.UserDTO;

public interface UserMapper {
	
	// 회원정보 확인
	public abstract UserDTO UserInfo(String Email);
	
	//	사용자 정보확인 로그인 시
	public abstract UserDTO UserLogin(String Email, String Pw);
	
	// 회원 가입시 아이디 중복첵크
	public abstract Integer distinckedEmail(String Email);
	
	// 회원가입시 닉네임 중복첵크
	public abstract Integer distinckedNickName(String NickName);
	
	// 회원가입
	public abstract Boolean insertJoin(UserDTO userDTO);
	
}	//	end interface
