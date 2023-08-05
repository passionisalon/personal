package org.zerock.myapp.service;

import java.util.List;
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
	public Boolean UserLogin(String Email, String UserPw,HttpServletRequest hsr,Model model) throws ServiceException {
		this.getThisClassInfo();
		log.info("\n\t UserLogin(UserEmail : {}, UserPW : {})invoked.",Email,UserPw);
		try {

			UserDTO userInfo = this.userMapper.UserInfo(Email);
			this.getThisClassInfo();
			log.info("\n\t userInfo : {}",userInfo);
			
			if(userInfo != null) {
				HttpSession session = hsr.getSession(false);
				log.info("\n\t session destroy");
				Boolean isUserPwMatched = this.bcrypt.matches(UserPw,userInfo.getPassword());
				this.getThisClassInfo();
				log.info("\n\t 패스워드 일치 확인 : {}",isUserPwMatched);
				
				if(!isUserPwMatched) {
					log.info("\n\t 패스워드 불일치!");
					return false;
				}	//	end if
				
				if(session != null) {
					session.invalidate();
					log.info("\n\t 세션 invalidate");

					session = hsr.getSession();
					session.setAttribute("USER_EMAIL", userInfo.getEmail());
					session.setAttribute("USER_NICKNAME",userInfo.getNickName());
					session.setAttribute("USER_PROFILEIMG",userInfo.getProfileImg());
					session.setAttribute("USER_BIRTHDATE",userInfo.getBIRTH_DATE());
					session.setAttribute("USER_JOINDATE",userInfo.getJOIN_DATE());
					session.setAttribute("USER_GENDER",userInfo.getGENDER());
					session.setAttribute("USER_INTRODUCTION",userInfo.getIntroduction());
					
					log.info("\n\t Session_USER_EMAIL : {}",session.getAttribute("USER_EMAIL"));
					log.info("\n\t Session_USER_NICKNAME : {}",session.getAttribute("USER_NICKNAME"));
					log.info("\n\t Session_USER_PROFILEIMG : {}",session.getAttribute("USER_PROFILEIMG"));
					log.info("\n\t Session_USER_BIRTHDATE : {}",session.getAttribute("USER_BIRTHDATE"));
					log.info("\n\t Session_USER_JOINDATE : {}",session.getAttribute("USER_JOINDATE"));
					log.info("\n\t Session_USER_GENDER : {}",session.getAttribute("USER_GENDER"));
					log.info("\n\t Session_USER_INTRODUCTION : {}",session.getAttribute("USER_INTRODUCTION"));
					
					model.addAttribute("__AUTH__",userInfo);
					
					this.getThisClassInfo();
					log.info("\n\t end this method : {}","UserLogin");
					return true;
				}else {
					return false;
				}// end inner if
				
				
			}else {
				log.info("\n\t getDBUserDto : {}",userInfo);
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
				String userPw = userDTO.getPassword();
				String hashedPw = this.bcrypt.encode(userPw);
				log.info("\n\t userPw : {}",userPw);
				log.info("\n\t hashedPw : {}",hashedPw);
				userDTO.setPassword(hashedPw);
				Boolean resultInsertJoin = this.userMapper.insertJoin(userDTO);
				this.getThisClassInfo();
				log.info("\n\t resultInsertJoin : {}",resultInsertJoin);
				
				return resultInsertJoin;
			}catch(Exception e) {
				throw new ServiceException(e);
			}	// end try-catch
			
		}	// end insertJoin
		
		// 이메일 찾기
		@Override
		public List<String> findEmail(String userEmail) throws ServiceException{
			
			this.getThisClassInfo();
			log.info("\n\t findEmail(Email : {}) invoked.",userEmail);
			
			try {
				List<String> Email = this.userMapper.findEmail(userEmail);
				this.getThisClassInfo();
				log.info("Email : {}",Email);
				Email.forEach(log::info);
				return Email;
			}catch(Exception e) {
				throw new ServiceException(e);
			}
		}	// end findEmail
		@Override
		public void destroy() throws Exception {
			this.getThisClassInfo();
			log.trace("\n\t destroy() invoked.");
		}	// end destroy

		// 비밀번호 찾기
		public UserDTO findPassword(String Email, String userEmail) throws ServiceException{
			this.getThisClassInfo();
			log.info("\n\t findPassword(Email : {}, userEmail : {})",Email , userEmail);
			
			try {
				UserDTO resultFindPassword = this.userMapper.findPassword(Email, userEmail);
				this.getThisClassInfo();
				log.info("\n\t resultFindPassword : {}",resultFindPassword);
				
				if(resultFindPassword.getEmail().equals(Email) & resultFindPassword.getUserEmail().equals(userEmail)) {
					this.getThisClassInfo();
					log.info("Email : {}",resultFindPassword.getEmail());
					log.info("userEmail : {}",resultFindPassword.getUserEmail());
					log.info("이메일을 찾았습니다.");
					return resultFindPassword;
				}else {
					this.getThisClassInfo();
					log.info("이메일을 찾지 못했습니다.");
					return null;
				}	// end if else
				
			}catch(Exception e) {
				throw new ServiceException(e);
			}
		}	// 	end findPassword;

		public Boolean changePassword(String Email, String Pw)throws ServiceException{
			this.getThisClassInfo();
			log.info("\n\t changePassword(Email : {}, Pw : {}",Email,Pw);
			try {
				String hashedPw = this.bcrypt.encode(Pw);
				log.info("\n\t hashedPw : {}",hashedPw);
				Boolean resultChangePassword = this.userMapper.changePassword(Email, hashedPw);
				this.getThisClassInfo();
				log.info("resultChangePassword : {}",resultChangePassword);
				if(resultChangePassword) {
					log.info("비밀번호 변경 성공!!!");
					return resultChangePassword;
				}else {
					log.info("비밀번호 변경 실패!!!");
					return resultChangePassword;
				}
			}catch(Exception e) {
				throw new ServiceException(e);
			}
		}	// end changePassword
		
}	// end class
