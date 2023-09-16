package com.kyuho.board.entity;

import javax.persistence.Entity;
import javax.persistence.Id;
import javax.persistence.Table;

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
	
}	// end class
