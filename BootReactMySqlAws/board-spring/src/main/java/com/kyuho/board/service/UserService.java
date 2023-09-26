package com.kyuho.board.service;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.kyuho.board.dto.PatchUserDto;
import com.kyuho.board.dto.PatchUserResponseDto;
import com.kyuho.board.dto.ResponseDto;
import com.kyuho.board.entity.UserEntity;
import com.kyuho.board.repository.UserRepository;

@Service
public class UserService {
	
	@Autowired
	UserRepository userRepository;
	
	private void thisClassIno() {
		System.out.println();
		System.out.printf("thisClass : %\n",this.getClass().getName());
		System.out.println();
	}	// end thisClassInfo
	
	public ResponseDto<PatchUserResponseDto> patchUser(PatchUserDto dto,String userEmail){
		this.thisClassIno();
		System.out.printf("patchUser(PatchUserDto : %s , userEmail : %s) invoked.\n",dto,userEmail);
		
		UserEntity userEntity = null;
		String userNickName = dto.getUserNickname();
		String userProfile = dto.getUserProfile();
		System.out.printf("userNickName : %s\n",userNickName);
		System.out.printf("userProfile : %s\n",userProfile);
		
		
		try {
			
			userEntity = this.userRepository.findByUserEmail(userEmail);
			System.out.printf("userEntity : %s\n",userEntity);
			
			
			if(userEntity == null) {
				System.out.println("userEntity is NULL!!!");
				return ResponseDto.setFailed("Does Not Exist User");
			}
			
			userEntity.setUserNickname(userNickName);
			userEntity.setUserProfile(userProfile);
			
			this.userRepository.save(userEntity);
		}catch(Exception e) {
			e.printStackTrace();
			ResponseDto.setFailed("DB Error");
		}	// end try-catch
		
		userEntity.setUserPassword("");
		
		PatchUserResponseDto patchUserResponseDto = new PatchUserResponseDto();
		
		
		System.out.printf("userEntity : %s\n",userEntity);
		
		return ResponseDto.setSuccess("Success", patchUserResponseDto);
		
	}	// end patchUser
	
	
}	// end class
