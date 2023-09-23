package com.kyuho.board.filter;

import java.io.IOException;

import javax.servlet.FilterChain;
import javax.servlet.ServletException;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.authentication.AbstractAuthenticationToken;
import org.springframework.security.authentication.UsernamePasswordAuthenticationToken;
import org.springframework.security.core.authority.AuthorityUtils;
import org.springframework.security.core.context.SecurityContext;
import org.springframework.security.core.context.SecurityContextHolder;
import org.springframework.security.web.authentication.WebAuthenticationDetailsSource;
import org.springframework.stereotype.Component;
import org.springframework.util.StringUtils;
import org.springframework.web.filter.OncePerRequestFilter;

import com.kyuho.board.security.TokenProvider;



@Component
public class JwtAuthenticationFilter extends OncePerRequestFilter {

	// request가 들어왔을 때 Request Header의 Authentication 필드의 Bearer Token값을 가져옴
	// 가져온 토큰을 검증하고 검증 결과를 SecurityContext에 추가 
	
	@Autowired
	private TokenProvider tokenProvider;
	
	private void thisClassInfo() {
		
		System.out.println();
		System.out.printf("현재 클래스는 : %s입니다.\n",this.getClass().getName());
		System.out.println();
		
	}	// end thisClassInfo
	
	@Override
	protected void doFilterInternal(HttpServletRequest request, HttpServletResponse response, FilterChain filterChain)
			throws ServletException, IOException {
		this.thisClassInfo();
		System.out.printf("doFilterInternal(request : %s , response : %s , filterChain : %s) invoked.\n",request,response,filterChain);
		
		try {

			String token = parseBearerToken(request);
			System.out.printf("token : %s\n",token);
			
			if(token != null && !token.equalsIgnoreCase("null")) {
				// 토큰을 검증해서 payload의 userEmail 가져옴 
				String userEmail = this.tokenProvider.validate(token);
				
				// SecuritoyContext에 추가 할 객체 
				AbstractAuthenticationToken authentication = 
						new UsernamePasswordAuthenticationToken(userEmail, null,AuthorityUtils.NO_AUTHORITIES);
				System.out.printf("authentication : %s\n",authentication);
				
				authentication.setDetails(new WebAuthenticationDetailsSource().buildDetails(request));
			
				// SecuritoyContext에 AbstractAuthenticationToken 객체를 추가해서
				// 해당 Thread가 지속적으로 인증 정보를 가질 수 있도록 해줌
				SecurityContext securityContext = SecurityContextHolder.createEmptyContext();
				securityContext.setAuthentication(authentication);
				SecurityContextHolder.setContext(securityContext);
				System.out.printf("securityContext : %s\n", securityContext);
			}	// end if
		}catch(Exception e) {
			System.out.printf("예외 발생 : %s\n",e);
			e.printStackTrace();
		}	// end try-catch
		
		filterChain.doFilter(request, response);

	}	// end doFilterInternal
	
	// Request Header에서 Authentication 필드의 Bearer Token을 가져오는 메소드
	private String parseBearerToken(HttpServletRequest request) {
		this.thisClassInfo();
		System.out.printf("parseBearerToken(request : %s) invoked.\n", request);
		String bearerToken = request.getHeader("Authorization");
		
		if(StringUtils.hasText(bearerToken) && bearerToken.startsWith("Bearer ")) {
			String result = bearerToken.substring(7);
			System.out.printf("result : %s\n",result);
			System.out.println("parseBearerToken 잘 작동됨");
			return result;
		}else {
			System.out.println("parseBearerToken 작동 안됨");
			return null;
		}	// end if - else
	}	// end parseBearerToken
	
}	// end class
