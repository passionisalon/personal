package com.kyuho.board.controller;

import org.springframework.security.core.annotation.AuthenticationPrincipal;
import org.springframework.web.bind.annotation.PatchMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.kyuho.board.dto.PatchUserDto;
import com.kyuho.board.dto.PatchUserResponseDto;
import com.kyuho.board.dto.ResponseDto;

@RestController
@RequestMapping("/api/user")
public class UserController {
	
	//. field
	
	
	// method
	private void thisClassInfo() {
		System.out.println();
		System.out.printf("thisClass : %s\n",this.getClass().getName());
		System.out.println();
	}	// end thisClassInfo
		
	@PatchMapping("/")
	public ResponseDto<PatchUserResponseDto> patchUser(@RequestBody PatchUserDto patchUserDto , @AuthenticationPrincipal String userEmail){
		this.thisClassInfo();
		System.out.printf("patchUser(PatchUSerDto : %s , userEmail : %s) invoked.",patchUserDto,userEmail);
		return null;
	}	// end patchUser
	
}	// end class
