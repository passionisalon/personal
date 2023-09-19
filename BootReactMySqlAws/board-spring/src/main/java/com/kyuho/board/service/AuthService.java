package com.kyuho.board.service;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.kyuho.board.dto.ResponseDto;
import com.kyuho.board.dto.SignUpDto;
import com.kyuho.board.entity.UserEntity;
import com.kyuho.board.repository.UserRepository;

import lombok.Setter;

@Service
public class AuthService {
	
	// field
	@Autowired
	UserRepository userRepository;
	// method
	
	public void getThisClassInfo() {
		System.out.println();
		System.out.printf("현재 클래스는 : %s입니다.\n",this.getClass().getName());
		System.out.println();		
	}	// end getThisClassInfo
	
	public ResponseDto<?> signUp(SignUpDto signUpDTO){
		this.getThisClassInfo();
		
		System.out.printf("signUp method invoked.\n");
		System.out.printf("SignUpDto : %s\n",signUpDTO);
		
		String userEmail = signUpDTO.getUserEmail();
		String userPassword = signUpDTO.getUserPassword();
		String userPasswordCheck = signUpDTO.getUserPasswordCheck();
		System.out.printf("userEmail : %s\n", userEmail);
		System.out.printf("userPassword : %s\n", userPassword);
		System.out.printf("userPasswordCheck : %s\n", userPasswordCheck);
		
		// email 중복 확인
		try {
			boolean distinctEmail = this.userRepository.existsById(userEmail);
			System.out.printf("distinctEmail : %s\n",distinctEmail);
			if(distinctEmail) {
				System.out.println("중복된 이메일이 있습니다.");
				return ResponseDto.setFailed("Existed Email!");
			}	// end if
		}catch(Exception e) {
			e.printStackTrace();
			System.out.println("DB Error 발생!");
			return ResponseDto.setFailed("DB Error!");
		}	// end try-catch
		
		
		// 비밀번호가 서로 다르면 faild response 반환!
		if(!userPassword.equals(userPasswordCheck)) {
			System.out.println("비밀번호가 맞지 않습니다.!");
			return ResponseDto.setFailed("Password doesn't matched!!!!!");
		}	// end if
		
		// userEntity 생성
		UserEntity userEntity = new UserEntity(signUpDTO);
		this.getThisClassInfo();
		System.out.println("UserEntity 생성!");
		
		// UserRepository를 이용해서 DB에 Entity를 저장한다!
		try {
			this.userRepository.save(userEntity);
		}catch(Exception e) {
			e.printStackTrace();
			System.out.println("DB Error 발생!");
			return ResponseDto.setFailed("DB Error!");
		}	// end try-catch
		
		// 성공시 success response 반환
		this.getThisClassInfo();
		System.out.println("SingUp method Success!!");
		return ResponseDto.setSuccess("SignUp Success!", null);
	}	// end signUp
	
	
}	// end class
