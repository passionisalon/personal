package org.zerock.myapp.service;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpSession;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.zerock.myapp.domain.UserDTO;
import org.zerock.myapp.exception.ServiceException;
import org.zerock.myapp.mapper.UserMapper;

import lombok.NoArgsConstructor;
import lombok.Setter;
import lombok.extern.log4j.Log4j2;

@Log4j2
@NoArgsConstructor
@Service
public class UserServiceImpl implements UserService {

	@Setter(onMethod_= {@Autowired})
	private UserMapper userMapper;
	
	public void getThisClassInfo() {
		System.out.printf("\n\t");
		log.info("\n\t thisClass : {}",this.getClass().getName());
		System.out.printf("\n\t");
	}	// end getThisClassInfo
	
	@Override
	public Boolean UserLogin(String Email, String Pw,HttpServletRequest hsr) throws ServiceException {
		this.getThisClassInfo();
		log.info("\n\t UserLogin(UserEmail : {}, UserPW : {})invoked.",Email,Pw);
		try {
			UserDTO getDBUserDto = new UserDTO();
			getDBUserDto = this.userMapper.UserLogin(Email, Pw);
			this.getThisClassInfo();
			log.info("\n\t getDBUserDto : {}",getDBUserDto);
			
			if(getDBUserDto != null) {
				HttpSession session = hsr.getSession(false);
				log.info("\n\t session destroy");
				
				if(!Email.equals(getDBUserDto.getEmail()) & !Pw.equals(getDBUserDto.getPw())) {
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

}	// end class
