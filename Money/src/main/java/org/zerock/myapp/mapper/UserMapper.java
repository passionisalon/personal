package org.zerock.myapp.mapper;

import java.util.List;

import org.apache.ibatis.annotations.Select;
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
	
	// 사용자 이메일 찾기
	public abstract List<String> findEmail(String userEmail);
	
	// 사용자 비밀번호 찾기
	public abstract UserDTO findPassword(String Email,String userEmail);
	
	// 사용자 비밀번호 변경
	public abstract Boolean changePassword(String Email , String Password);
}	//	end interface
