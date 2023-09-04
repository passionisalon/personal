package org.zerock.myapp.domain;

import java.util.Date;

import org.springframework.format.annotation.DateTimeFormat;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;
import lombok.extern.log4j.Log4j2;


@Data
@NoArgsConstructor
@AllArgsConstructor


public class UserDTO {

	private String Email;
	private String Password;
	private String userEmail;
	private String NickName;
//	@DateTimeFormat(pattern="yyyy-MM-dd")
	private String BIRTH_DATE;
//	@DateTimeFormat(pattern="yyyy-MM-dd")
	private Date JOIN_DATE;
	private String GENDER;
	private String Introduction="";
	private String Profile_Img="";
	private String RememberMe="";
	private Date RememberMeAge;
	private Integer Auth;
	
	
}	// end class
