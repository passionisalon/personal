package org.zerock.myapp.service;

import org.zerock.myapp.exception.ServiceException;

public interface MailSendService {
	
	// 난수 만들기
	public abstract void makeRandomNumber() throws ServiceException;
	
	// 회원 인증번호
	public abstract String joinEmail(String Email) throws ServiceException;
	
	// 이메일 찾기 인증번호
	public abstract String findEmail(String Email) throws ServiceException;
	
	// 비밀번호 찾기 인증번호
	public abstract String findPw(String Email) throws ServiceException;
	
	// 메일 전송
	public abstract void mailSend(String toMail, String title, String content) throws ServiceException;
	
}	//	end interface
