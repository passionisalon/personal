package com.kyuho.board.entity;

import javax.persistence.Entity;
import javax.persistence.Id;
import javax.persistence.Table;

import com.kyuho.board.dto.SignUpDto;

import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;

@Builder
@Entity(name="User") 
@Table(name="User")	  
@Data
@AllArgsConstructor
@NoArgsConstructor
public class UserEntity {
	
	// @Entity(name="사용할 Entity명") 해당 클래스를 Entity 클래스로 사용하겠다.
	// @Table(name="테이블명") DB에 있는 테이블과 현재 클래스를 맵핑시키는 어노테이션 
	
	@Id
	private String userEmail;
	private String userPassword;
	private String userNickname;
	private String userPhoneNumber;
	private String userAddress;
	private String userProfile;
	
	public UserEntity(SignUpDto dto) {
		
		System.out.printf("현재 클래스는 : %s입니다.\n",this.getClass().getName());
		
		this.userEmail = dto.getUserEmail();
		this.userPassword = dto.getUserPassword();
		this.userNickname = dto.getUserNickname();
		this.userPhoneNumber = dto.getUserPhoneNumber();
		this.userAddress = dto.getUserAddress()+" "+dto.getUserAddressDetail();
		
		System.out.printf("this.userEmail : %s\n",this.userEmail);
		System.out.printf("this.userPassword : %s\n",this.userPassword);
		System.out.printf("this.userNickname : %s\n",this.userNickname);
		System.out.printf("this.userPhoneNumber : %s\n",this.userPhoneNumber);
		System.out.printf("this.userAddress : %s\n",this.userAddress);
		
	}	// end constructor
	
}	// end class
