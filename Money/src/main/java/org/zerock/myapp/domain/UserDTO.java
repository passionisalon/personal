package org.zerock.myapp.domain;

import java.util.Date;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;
import lombok.extern.log4j.Log4j2;

@Log4j2
@Data
@NoArgsConstructor
@AllArgsConstructor


public class UserDTO {

	private String Email;
	private String Pw;
	private String NickName;
	private Date BIRTH_DATE;
	private Date JOIN_DATE;
	private String GENDER;
	private String INTRODUCTION;
	private String ProfileImg;
	private String RememberMe;
	private Date RememberMeAge;
	private Integer Auth;
	
	
}	// end class
