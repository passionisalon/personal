package org.zerock.myapp.domain;

import lombok.Data;

@Data
public class UserDTO {
	private String email;
	private String password;
	private String name;
	private String gender;
	private String userauth;
	private String depart;
}	// end class
