package com.kyuho.board.dto;

import com.kyuho.board.entity.UserEntity;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

@Data
@AllArgsConstructor
@NoArgsConstructor
public class SignInResponseDto {
	
	private String token;
	private int exprTime;
	private UserEntity user;
}	// end class
