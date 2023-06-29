package org.zerock.myapp.domain;

import lombok.AllArgsConstructor;
import lombok.NoArgsConstructor;
import lombok.Value;
import lombok.extern.log4j.Log4j2;



@Value
@Log4j2
public class UserVO {
	private String email;
	private String password;
	private String name;
	private String gender;
	private String userauth;
	private String depart;
	
	public UserDTO toDTO() {
		log.info("\n\t thisClass : ",this.getClass());
		log.info("\n\t toDTO() invoked.");
		UserDTO dto = new UserDTO();
		dto.setEmail(this.email);
		dto.setPassword(password);
		dto.setName(name);
		dto.setGender(gender);
		dto.setUserauth(userauth);
		dto.setDepart(depart);
		return dto;
	}	// end toDTO();
}	// end class
