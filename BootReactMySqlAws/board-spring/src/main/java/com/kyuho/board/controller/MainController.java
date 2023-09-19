package com.kyuho.board.controller;

import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
@RequestMapping("/")
//@CrossOrigin(originPatterns="http://localhost:3000")
public class MainController {
	
	// filed
	
	
	
	// Method
	
	public void getThisClassInfo() {
		System.out.println();
		System.out.printf("현재 클래스는 %s입니다.\n",this.getClass().getName());
		System.out.println();
	}	// end getThisClassInfo
	
	@GetMapping("")
	public String hello() {
		this.getThisClassInfo();
		System.out.printf("hello() invoked.\n");
		return "Connextion Successful";
	}
}	// end class
