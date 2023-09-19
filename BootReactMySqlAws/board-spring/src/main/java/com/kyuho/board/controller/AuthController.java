package com.kyuho.board.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.kyuho.board.dto.ResponseDto;
import com.kyuho.board.dto.SignUpDto;
import com.kyuho.board.service.AuthService;

//@CrossOrigin(originPatterns = "http://localhost:3000")
@RestController
@RequestMapping("/api/auth")
public class AuthController {
	
	// field
	@Autowired
	AuthService authService;
	
	// method
	
	public void getThisClassInfo() {
		System.out.printf("\n");
		System.out.printf("현재 클래스는 : %s입니다.\n",this.getClass().getName());
		System.out.printf("\n");
	}
	
	@PostMapping("/signUp")
	public ResponseDto<?> signUp(
			@RequestBody SignUpDto requestBody
			){
		this.getThisClassInfo();
		System.out.printf("signUp(requestBody : %s) invoked.",requestBody.toString());
		
		ResponseDto<?> result = authService.signUp(requestBody);
		this.getThisClassInfo();
		System.out.printf("result : %s\n",result);
		System.out.println("Controller signUp method complete");
		return result;
	}	// end signUp
	
}	// end class
