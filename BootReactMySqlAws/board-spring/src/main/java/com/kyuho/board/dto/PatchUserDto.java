package com.kyuho.board.dto;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

@Data
@AllArgsConstructor
@NoArgsConstructor
public class PatchUserDto {
	private String userNickname;
	private String userProfile;
}	// end class
