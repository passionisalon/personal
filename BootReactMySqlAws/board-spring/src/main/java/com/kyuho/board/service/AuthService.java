package com.kyuho.board.service;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.crypto.bcrypt.BCryptPasswordEncoder;
import org.springframework.security.crypto.password.PasswordEncoder;
import org.springframework.stereotype.Service;

import com.kyuho.board.dto.ResponseDto;
import com.kyuho.board.dto.SignInDto;
import com.kyuho.board.dto.SignInResponseDto;
import com.kyuho.board.dto.SignUpDto;
import com.kyuho.board.entity.UserEntity;
import com.kyuho.board.repository.UserRepository;
import com.kyuho.board.security.TokenProvider;

@Service
public class AuthService {
	
	// field
	@Autowired
	UserRepository userRepository;
	
	@Autowired
	TokenProvider tokenProvider;
	
	private PasswordEncoder passwordEncoder = new BCryptPasswordEncoder();
	
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
		
		// 비밀번호 암호화
		String passwordEncodeResult = this.passwordEncoder.encode(userPassword);
		System.out.printf("passwordEncodeResult : %s\n",passwordEncodeResult);
		userEntity.setUserPassword(passwordEncodeResult);
		
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
	
	
	public ResponseDto<SignInResponseDto> signIn(SignInDto dto){
		
		this.getThisClassInfo();
		System.out.printf("signIn(SignInDto : %s) invoked.\n",dto);
		String userEmail = dto.getUserEmail();
		String userPassword = dto.getUserPassword();
		System.out.printf("userEmail : %s\n",userEmail);
		System.out.printf("userPassword : %s\n",userPassword);
		
		UserEntity userEntity;
		
		try {
			
//			userEntity = this.userRepository.findById(userEmail).get();
			userEntity = this.userRepository.findByUserEmail(userEmail);
			this.getThisClassInfo();
			System.out.printf("userEntity : %s\n", userEntity);
			
			// 잘못된 이메일 
			if(userEntity == null) {
				System.out.println("userEntity가 null입니다.");
				return ResponseDto.setFailed("Sign In Failed!!!");
			}	// end if
			
			// 잘못된 패스워드 
			if( !this.passwordEncoder.matches(userPassword, userEntity.getUserPassword()) ) {
				System.out.println("password가 다릅니다.!");
				return ResponseDto.setFailed("Sign In Failed!!!");
			}	// end if
			
		}catch(Exception e) {
			e.printStackTrace();
			return ResponseDto.setFailed("DB ERROR");
		}	// end try-cath

		String token = this.tokenProvider.create(userEmail);
		System.out.printf("token : %s\n",token);
		int exprTime = 3600000;
		System.out.printf("exprTime : %s\n",exprTime);
		
		SignInResponseDto signInResponseDto = new SignInResponseDto(token,exprTime,userEntity); 
		System.out.printf("SignInResponseDto : %s\n",signInResponseDto);
		
		return ResponseDto.setSuccess("Sign In Success", signInResponseDto);
	}	// end signIn
}	// end class
