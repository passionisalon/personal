package com.kyuho.board.security;

import java.time.Instant;
import java.time.temporal.ChronoUnit;
import java.util.Date;

import org.springframework.stereotype.Service;

import io.jsonwebtoken.Claims;
import io.jsonwebtoken.Jwts;
import io.jsonwebtoken.SignatureAlgorithm;

@Service
public class TokenProvider {
	
	// JWT 생성 및 검증을 위한 키 
	private static final String SECURITY_KEY = "jwtseckey!@";

	public void thisClassInfo() {
		System.out.println();
		System.out.printf("thisClass is : %s\n",this.getClass().getName());;
		System.out.println();
	}
	
	// JWT 생성하는 메소드 
	public String create (String userEmail) {
		this.thisClassInfo();
		System.out.printf("create(userEmail : %s) invoked.\n",userEmail);
		
		// 만료 날짜를 현재 날짜 + 1시간으로 설정하는 것  
		Date exprTime = Date.from(Instant.now().plus(1,ChronoUnit.HOURS));
		System.out.printf("exprTime : %s\n",exprTime);
		
		// JWT를 생성 
		String result = 
				Jwts.builder()
				// 암호화에 사용 될 알고리즘과 키 
				.signWith(SignatureAlgorithm.HS512,SECURITY_KEY)
				// JWT의 제목과 생성일 그리고 만료일을 넣어주는 역할 
				.setSubject(userEmail).setIssuedAt(new Date()).setExpiration(exprTime)
				// 컴팩트하여 생성 
				.compact();
		System.out.printf("result : %s\n",result);
		return result;
		
	}	// end create
	
	// JWT 검증 
	public String validate(String token) {
		this.thisClassInfo();
		System.out.printf("validate(token : %s) invoked.\n",token);
		
		// 매개변수로 받은 token을 시큐리티키를 사용해서 복호화(디코딩)
		Claims claims = Jwts.parser().setSigningKey(SECURITY_KEY).parseClaimsJws(token).getBody();
		System.out.printf("claims : %s\n",claims);
		
		// 복호화된 토큰의 payload에서 제목을 가져옴 
		return claims.getSubject();
	}	// end validate
	
}	// end class
