package com.kyuho.board.controller;

import org.springframework.security.core.annotation.AuthenticationPrincipal;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
@RequestMapping("/api/board")
public class BoardController {
	
	
	private void thisClassInfo() {
		System.out.println();
		System.out.printf("thisClass : %s\n",this.getClass().getName());
		System.out.println();
	}	// end thisClassInfo
	
	
	@GetMapping("/")
	public String getBoard(@AuthenticationPrincipal String userEmail) {
		this.thisClassInfo();
		System.out.printf("getBoard() invoked.\n");
		
		String result = "로그인된 사용자는 "+userEmail+"입니다.";
		System.out.printf("%s\n",result);
		return result;
	}	// end getBoard
	
	
}	// end class
