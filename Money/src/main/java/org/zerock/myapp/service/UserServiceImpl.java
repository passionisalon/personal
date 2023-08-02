package org.zerock.myapp.service;

import java.util.Objects;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpSession;

import org.apache.ibatis.session.SqlSessionFactory;
import org.springframework.beans.factory.DisposableBean;
import org.springframework.beans.factory.InitializingBean;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.crypto.bcrypt.BCryptPasswordEncoder;
import org.springframework.stereotype.Service;
import org.springframework.ui.Model;
import org.zerock.myapp.domain.UserDTO;
import org.zerock.myapp.exception.ServiceException;
import org.zerock.myapp.mapper.UserMapper;

import lombok.NoArgsConstructor;
import lombok.Setter;
import lombok.extern.log4j.Log4j2;

@Log4j2
@NoArgsConstructor
@Service
public class UserServiceImpl implements UserService, InitializingBean, DisposableBean  {

	@Setter(onMethod_= {@Autowired})
	private UserMapper userMapper;
	
	@Setter(onMethod_= {@Autowired})
	private SqlSessionFactory sqlSessionFactory;
	
	@Setter(onMethod_= {@Autowired})
	private BCryptPasswordEncoder bcrypt;
	
	@Override
	public void afterPropertiesSet() throws Exception {
		this.getThisClassInfo();
		log.trace("\n\t afterPropertiesSet() invoked.");
		log.info("\n\t sqlSessionFactory : {}",sqlSessionFactory);
		Objects.requireNonNull(this.sqlSessionFactory);
	}	// end afterPropertiesSet
	
	public void getThisClassInfo() {
		System.out.printf("\n\t");
		log.info("\n\t thisClass : {}",this.getClass().getName());
		System.out.printf("\n\t");
	}	// end getThisClassInfo
	
	@Override
	public Boolean UserLogin(String Email, String Pw,HttpServletRequest hsr,Model model) throws ServiceException {
		this.getThisClassInfo();
		log.info("\n\t UserLogin(UserEmail : {}, UserPW : {})invoked.",Email,Pw);
		try {
			UserDTO getDBUserDto = new UserDTO();
			getDBUserDto = this.userMapper.UserLogin(Email, Pw);
			UserDTO userInfo = this.userMapper.UserInfo(Email);
			this.getThisClassInfo();
			log.info("\n\t getDBUserDto : {}",getDBUserDto);
			log.info("\n\t userInfo : {}",userInfo);
			
			if(getDBUserDto != null) {
				HttpSession session = hsr.getSession(false);
				log.info("\n\t session destroy");
				
				Boolean isUserPwMatched = this.bcrypt.matches(getDBUserDto.getPw(),userInfo.getPw());
				this.getThisClassInfo();
				log.info("\n\t 패스워드 일치 확인 : {}",isUserPwMatched);
				
				if(!isUserPwMatched) {
					log.info("\n\t 패스워드 불일치!");
					return false;
				}	//	end if
				if(!Email.equals(getDBUserDto.getEmail()) & !userInfo.getPw().equals(getDBUserDto.getPw())) {
					this.getThisClassInfo();
					log.info("로그인실패");
					return false;
				}	//	end if
				
				if(session != null) {
					session.invalidate();
					log.info("\n\t 세션 invalidate");

					session = hsr.getSession();
					session.setAttribute("USER_EMAIL", getDBUserDto.getEmail());
					session.setAttribute("USER_NICKNAME",getDBUserDto.getNickName());
					session.setAttribute("USER_PROFILEIMG",getDBUserDto.getProfileImg());
					session.setAttribute("USER_BIRTHDATE",getDBUserDto.getBIRTH_DATE());
					session.setAttribute("USER_JOINDATE",getDBUserDto.getJOIN_DATE());
					session.setAttribute("USER_GENDER",getDBUserDto.getGENDER());
					session.setAttribute("USER_INTRODUCTION",getDBUserDto.getINTRODUCTION());
					
					log.info("\n\t Session_USER_EMAIL : {}",session.getAttribute("USER_EMAIL"));
					log.info("\n\t Session_USER_NICKNAME : {}",session.getAttribute("USER_NICKNAME"));
					log.info("\n\t Session_USER_PROFILEIMG : {}",session.getAttribute("USER_PROFILEIMG"));
					log.info("\n\t Session_USER_BIRTHDATE : {}",session.getAttribute("USER_BIRTHDATE"));
					log.info("\n\t Session_USER_JOINDATE : {}",session.getAttribute("USER_JOINDATE"));
					log.info("\n\t Session_USER_GENDER : {}",session.getAttribute("USER_GENDER"));
					log.info("\n\t Session_USER_INTRODUCTION : {}",session.getAttribute("USER_INTRODUCTION"));
					
					model.addAttribute("__AUTH__",getDBUserDto);
					
					this.getThisClassInfo();
					log.info("\n\t end this method : {}","UserLogin");
					return true;
				}else {
					return false;
				}// end inner if
				
				
			}else {
				log.info("\n\t getDBUserDto : {}",getDBUserDto);
				return false;
			}	//	end outer if-else
			
		}catch(Exception e) {
			throw new ServiceException(e);
		}	// end try-catch
		
	}	// end UserLogin
	
	// 이메일 중복첵크
	public Integer distinckedEmail(String Email) throws ServiceException{
		this.getThisClassInfo();
		log.info("\n\t distinckedEmail(Email : {}) invoked.",Email);
		
		try {
			Integer resultDistinckedEamil = this.userMapper.distinckedEmail(Email);
			this.getThisClassInfo();
			log.info("\n\t resultDistinckedEmail : {}",resultDistinckedEamil);
			
			if(resultDistinckedEamil == 0) {
				log.info("\n\t 이메일 중복확인 결과 => 이메일 사용가능");
				return 0;
			}else {
				log.info("\n\t 이메일 중복확인 결과 => 이메일 불가능");
				return 1;
			}	// end if - else
		}catch(Exception e) {
			throw new ServiceException(e);
		}	// end try-catch
		
	}	// end distinckedEmail
	
	// 이메일 중복첵크
		public Integer distinckedNickName(String NickName) throws ServiceException{
			this.getThisClassInfo();
			log.info("\n\t distinckedNickName(Email : {}) invoked.",NickName);
			
			try {
				Integer resultDistinckedNickName = this.userMapper.distinckedNickName(NickName);
				this.getThisClassInfo();
				log.info("\n\t resultDistinckedNickName : {}",resultDistinckedNickName);
				
				if(resultDistinckedNickName == 0) {
					log.info("\n\t 닉네임 중복확인 결과 => 닉네임 사용가능");
					return 0;
				}else {
					log.info("\n\t 닉네임 중복확인 결과 => 닉네임 불가능");
					return 1;
				}	// end if - else
			}catch(Exception e) {
				throw new ServiceException(e);
			}	// end try-catch
			
		}// end distinckedEmail

		// 회원가입
		@Override
		public Boolean insertJoin(UserDTO userDTO) throws ServiceException{
			this.getThisClassInfo();
			log.info("\n\t insertJoin(UserDTO : {}) invoked.",userDTO);
			
			try {
				String userPw = userDTO.getPw();
				String hashedPw = this.bcrypt.encode(userPw);
				log.info("\n\t userPw : {}",userPw);
				log.info("\n\t hashedPw : {}",hashedPw);
				userDTO.setPw(hashedPw);
				Boolean resultInsertJoin = this.userMapper.insertJoin(userDTO);
				this.getThisClassInfo();
				log.info("\n\t resultInsertJoin : {}",resultInsertJoin);
				
				return resultInsertJoin;
			}catch(Exception e) {
				throw new ServiceException(e);
			}	// end try-catch
			
		}	// end insertJoin
		
		
		@Override
		public void destroy() throws Exception {
			this.getThisClassInfo();
			log.trace("\n\t destroy() invoked.");
		}	// end destroy



}	// end class
