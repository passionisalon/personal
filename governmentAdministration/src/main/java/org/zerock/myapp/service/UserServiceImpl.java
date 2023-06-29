package org.zerock.myapp.service;

import java.util.Objects;

import org.springframework.beans.factory.DisposableBean;
import org.springframework.beans.factory.InitializingBean;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.zerock.myapp.domain.UserDTO;
import org.zerock.myapp.domain.UserVO;
import org.zerock.myapp.exception.ServiceException;
import org.zerock.myapp.mapper.UserMapper;

import lombok.NoArgsConstructor;
import lombok.Setter;
import lombok.extern.log4j.Log4j2;

@Log4j2
@NoArgsConstructor
@Service("UserService")
public class UserServiceImpl implements UserService,InitializingBean, DisposableBean {

	@Setter(onMethod_= {@Autowired})
	private UserMapper userMapper;
	
//	@Setter(onMethod_= {@Autowired})
//	private BCryptPasswordEncoder bcryptPasswordEncoder;
	
//	@Setter(onMethod_= {@Autowired})
//	private SqlSessionFactory sqlSessionFactory;
	
	@Override
	public void afterPropertiesSet() throws Exception {
		log.trace("\n\t afterPropertiesSet() invoked.");
		
	}	// end afterPropertiesSet
	
	// 사용자 정보 들고오기
	@Override
	public UserDTO UserInfo(String email) throws ServiceException{
		System.out.printf("\t thisClass : %s\n",this.getClass());
		System.out.printf("\t UserInfo($s) invoked.\n",email);
		UserDTO userDTO = this.userMapper.UserInfo(email);
		System.out.printf("\t UserVO : $s \n",userDTO);
		return userDTO;
	}	// UserInfo
	// 로그인 
	@Override
	public UserVO loginUser(UserDTO userDTO) throws ServiceException {
		System.out.printf("\t thisClass : %s\n",this.getClass());
		System.out.printf("\t loginUser($s) invoked.\n",userDTO);
		
		
		try {
			String getEmail = userDTO.getEmail();
			String getPassword = userDTO.getPassword();
			System.out.printf("\t getEmail : %s\n", getEmail);
			System.out.printf("\t getPassword : %s\n", getPassword);
			
			// 사용자 정보 들고오기
			UserDTO	getInfo = this.userMapper.UserInfo(getEmail);
			
			// 로그인 
			UserVO vo = this.userMapper.loginUser(userDTO);
			System.out.printf("\t UserVO : $s \n",vo);
			if(vo.getPassword().equals(getInfo.getPassword())) {
				log.info("\n\t 비즈니스 계층 로그인 성공 \n");
				return vo;
			}else {
				log.info("\n\t 비즈니스 계층 로그인 *** 실패 ***\n");
				return null;
			}	// end if-else
		}catch(Exception e) {
			throw new ServiceException(e);
		}	// end try-catch

	}	// end loginUser

	// 회원가입 
	@Override
	public Integer insertJoin(UserDTO userDTO) throws ServiceException {
		System.out.printf("\t thisClass : %s\n",this.getClass());
		System.out.printf("\t insertJoin($s) invoked.\n",userDTO);
		Integer result = this.userMapper.insertJoin(userDTO);
		Objects.requireNonNull(result);
		if(result==1) {
			return 1; // 잘되면 1 
		}else {
			return 0; // 못되면 0 
		}
	}	// end insertJoin

	// 이메일 중복확인 
	@Override
	public Integer checkDistinctEmail(String userEmail) throws ServiceException {
		log.info("\n\t thisClass : {}",this.getClass());
		System.out.printf("\t checkDistinctEmail($s) invoked.\n", userEmail);
		Integer result = this.userMapper.checkDistinctEmail(userEmail);
		if(result ==1) {
			log.info("\n\t thisClass : {}",this.getClass());
			log.info("\n\t result : {} 중복된 이메일입니다.",result);
			return 1;
		}else {
			log.info("\n\t thisClass : {}",this.getClass());
			log.info("\n\t result : {} 사용가능한 이메일입니다.",result);
			return 0;
		}
		
	}	// end checkDistinctEmail

	//회원정보 수정
	@Override
	public Integer updateUserInformation(UserDTO dto) throws ServiceException {
		log.info("\n\t thisClass : {}",this.getClass());
		System.out.printf("\t updateUserInformation(%s) invoked.",dto);
		Integer result = this.userMapper.updateUserInformation(dto);
		System.out.printf("\t result : %s\n",result);
		if(result == 1) {
			System.out.println("수정됨");
			return result;
		}else {
			System.out.println("수정안됨");
			return result;
		}
		
	}	// end updateUserInformation

	@Override
	public void destroy() throws Exception {
		log.info("destroy() invoked.");
		
	}	// end destroy



}	// end class
