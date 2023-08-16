package org.zerock.myapp.controller;

import java.util.HashMap;
import java.util.List;
import java.util.Map;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpSession;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.ResponseBody;
import org.springframework.web.servlet.mvc.support.RedirectAttributes;
import org.zerock.myapp.domain.UserDTO;
import org.zerock.myapp.exception.ControllerException;
import org.zerock.myapp.service.MailSendService;
import org.zerock.myapp.service.UserService;

import lombok.NoArgsConstructor;
import lombok.Setter;
import lombok.extern.log4j.Log4j2;

@Log4j2
@NoArgsConstructor

@RequestMapping("/user")
@Controller
public class UserController {
	
	@Setter(onMethod_= {@Autowired})
	private UserService userSerivce;
	
	@Setter(onMethod_= {@Autowired})
	private MailSendService mailService;
	
	public void getThisClassInfo() {
		System.out.printf("\n\t");
		log.info("\n\t thisClass : {}",this.getClass().getName());
		System.out.printf("\n\t");
	}	// end getThisClassInfo
	
	
	@RequestMapping("/logout")
	public String logoutMainGet(HttpServletRequest request) throws ControllerException{
		
		this.getThisClassInfo();
		HttpSession session = request.getSession();
		session.invalidate();
		return "redirect:/user/login";
	}	// end logout
	
	
	@GetMapping("/login")
	public void login() throws ControllerException {
		this.getThisClassInfo();
		log.info("\n\t GetMapping login() invoked");
		try {
			;;
		}catch(Exception e) {
			throw new ControllerException(e);
		}
	}	// end login
	
	@PostMapping("/login")
	public String login (
			String Email, 
			String Password, 
			Model model, 
			HttpServletRequest hrs, 
			RedirectAttributes rttrs
		) throws ControllerException{
		
		this.getThisClassInfo();
		log.info("\n\t PostMapping login() invoked.");
		log.info("\n\t UserEmail : {}",Email);
		log.info("\n\t UserPw : {}",Password);
		log.info("\n\t model : {}",model);
		log.info("\n\t HttpServletRequest : {}",hrs);
		log.info("\n\t RedirectAttributes : {}",rttrs);
		
		try {
			log.info("\n\t UserSerivce : {}",userSerivce);
			log.info("asdfasdfasdfdas");
			Boolean loginResult = this.userSerivce.UserLogin(Email, Password, hrs,model);
			this.getThisClassInfo();
			log.info("\n\t loginResult : {}",loginResult);
			
			if(loginResult==false) {
				log.info("\n\t 로그인 실패 도메인 페이지로 이동");
				return "/domain";
			}else {
				log.info("\n\t 로그인 성공!!! 마이페이지로 이동");
				return "/user/mypage";
			}	// end if - else
			
		}catch(Exception e) {
			throw new ControllerException(e);
		}	//	end try-catch
		

	}	// end Post login
	
	
	@GetMapping("/join")
	public void join() throws ControllerException{
		this.getThisClassInfo();
		log.info("\n\t join() invoked.");
		try {
			;;
		}catch(Exception e) {
			throw new ControllerException(e);
		}
	}	// end join
	
	@ResponseBody
	@PostMapping("/join")
	public Integer join(
			String Email,
			String Pw,
			String userEmail,
			String NickName,
			String BIRTH_DATE,
			String GENDER,
			String INTRODUCTION,
			String ProfileImg,
			HttpServletRequest hsr, 
			RedirectAttributes rttrs
			) throws ControllerException{
		this.getThisClassInfo();
		log.info("\n\t Email : {}",Email);
		log.info("\n\t Pw : {}",Pw);
		log.info("\n\t userEmail : {}",userEmail);
		log.info("\n\t NickName : {}",NickName);
		log.info("\n\t BIRTH_DATE : {}",BIRTH_DATE);
		log.info("\n\t GENDER : {}",GENDER);
		log.info("\n\t INTRODUCTION : {}",INTRODUCTION);
		log.info("\n\t ProfileImg : {}",ProfileImg);
		log.info("\n\t HttpServletRequest : {}",hsr);
		log.info("\n\t RedirectAttributes : {}",rttrs);
		try {
			
			UserDTO userDTO = new UserDTO();
			userDTO.setEmail(Email);
			userDTO.setPassword(Pw);
			userDTO.setUserEmail(userEmail);
			userDTO.setNickName(NickName);
			userDTO.setBIRTH_DATE(BIRTH_DATE);
			userDTO.setGENDER(GENDER);
			userDTO.setIntroduction(INTRODUCTION);
//			userDTO.setProfileImg(ProfileImg); //미구현
			log.info("\n\t UserDTO : {}",userDTO);
			log.info("User's password : {}",Pw);
			if(Pw == null | Pw.isEmpty()) {
				rttrs.addAttribute("__RESULT__","비밀번호를 입력해주세요");
				log.info("\n\t 비밀번호가 입력되지 않았습니다.");
				return 0;
			}else {
				Boolean resultInsertJoin = this.userSerivce.insertJoin(userDTO);
				this.getThisClassInfo();
				log.info("\n\t resultInsertJoin : {}",resultInsertJoin);
				
				if(resultInsertJoin) {
					this.getThisClassInfo();
					log.info("\n\t 회원가입성공!");
					return 1;
				}else {
					this.getThisClassInfo();
					log.info("\n\t 회원가입실패!");
					return 0;
				}	// end if - else
			}	// end if - else
			
		}catch(Exception e) {
			throw new ControllerException(e);
		}	// end try-catch
	}	// 	end PostMapping join
	
	// 이메일 중복검사 
	
	@ResponseBody
	@PostMapping("/distinckedEmail")
	public Integer distinckedEmail(String Email) throws ControllerException{
		this.getThisClassInfo();
		log.info("\n\t distinckedEmail(userEmail : {}) invoked.",Email);
		try {
			
			Integer resultDistinckedEmail =this.userSerivce.distinckedEmail(Email);
			this.getThisClassInfo();
			log.info("\n\t 이메일 중복확인을 UserController에서 받은 서비스의 결과 : {}",resultDistinckedEmail);
			
			if(resultDistinckedEmail==0) {
				log.info("\n\t 이메일 사용가능 : {}",resultDistinckedEmail);
				return 0;
			}else {
				log.info("\n\t 이메일 불가능 : {}",resultDistinckedEmail);
				return 1;
			}	//	end try-catch

		}catch(Exception e) {
			throw new ControllerException(e);
		}	// end try-catch
		
	}	//	end distinckedEmail
	
	@ResponseBody
	@GetMapping("sendMailCheck")
	public String sendMailCheck(String Email) throws ControllerException {
		this.getThisClassInfo();
		log.info("\n\t sendMailCheck(Email : {}) invoked.",Email);
		
		try {
			String resultSendEmail = this.mailService.joinEmail(Email);
			this.getThisClassInfo();
			log.info("\n\t resultSendEmail : {}",resultSendEmail);
			return resultSendEmail;
		}catch(Exception e) {
			throw new ControllerException(e);
		}	//	try-catch
		
	}	//	end sendMailCheck
	
	
	// 닉네임 중복검사 
	@ResponseBody
	@GetMapping("/checkNickName")
	public Boolean checkNickName(String NickName) throws ControllerException {
		this.getThisClassInfo();
		log.info("\n\t checkNickName(NickName : {}) invoked.",NickName);
		try {
			Integer resultDistinckedNickName = this.userSerivce.distinckedNickName(NickName);
			this.getThisClassInfo();
			log.info("\n\t 닉네임 중복확인을 UserController에서 받은 서비스의 결과 : {}",resultDistinckedNickName);
			
			if(resultDistinckedNickName==0) {
				log.info("\n\t 사용가능한 닉네임입니다.");
				return true;
			}else {
				log.info("\n\t 사용가능한 닉네임입니다.");
				return false;
			}	// end if-else
		
		}catch(Exception e) {
			throw new ControllerException(e);
		}	// end try-catch
	}	// end checkNickName
	
	// 이메일 찾기
	@GetMapping("/findEmail")
	public void findEmail() throws ControllerException{
		this.getThisClassInfo();
		log.info("\n\t findEmail() invoked.");
	}	// end GetMapping findEmail
	
	@ResponseBody
	@PostMapping("/sendEmailForFindEmail")
	public Map<String,Object> sendEmailForFindEmail(String userEmail) throws ControllerException{
		this.getThisClassInfo();
		log.info("\n\t sendEmailForFindEmail(Email : {}) invoked.");
		
		try {
			String resultAuthNumber = this.mailService.findEmail(userEmail);
			this.getThisClassInfo();
			log.info("\n\t resultAuthNumber : {}",resultAuthNumber);
			List<String> Email = this.userSerivce.findEmail(userEmail);
			this.getThisClassInfo();
			log.info("\n\t Email의 값 나열");
			Email.forEach(log::info);
			
			Map<String,Object> UserInfo = new HashMap<>();
			UserInfo.put("code", resultAuthNumber);
			UserInfo.put("Email", Email);
			
			log.info("\n\t HashMap's UserInfo의 code : {}",UserInfo.get("code"));
			log.info("\n\t HashMap's UserInfo의 Email : {}",UserInfo.get("Email"));
			
			return UserInfo;
		}catch(Exception e) {
			throw new ControllerException(e);
		}	// 	end try-catch
	}	// end sendEmailForFindEmail
	
	// 이메일 찾기
	@GetMapping("/findPassword")
	public void findPassword() throws ControllerException{
		this.getThisClassInfo();
		log.info("\n\t findPassword() invoked.");
	}	// end GetMapping findEmail
	
	@ResponseBody
	@PostMapping("/checkEmailAndUserEmailForFindPassword")
	public Map<String,Object> checkFindPassword(String Email,String userEmail) throws ControllerException{
		this.getThisClassInfo();
		log.info("\n\t checkFindPassword(Email : {},user : {}) invoked.",Email,userEmail);
		
		try {
			String resultAuthNumber = this.mailService.findPw(userEmail);
			this.getThisClassInfo();
			log.info("\n\t resultAuthNumber : {}",resultAuthNumber);
			
			UserDTO resultUserDTO = this.userSerivce.findPassword(Email, userEmail);
			this.getThisClassInfo();
			log.info("\n\t resultUserDTO : {}",resultUserDTO);
			
			Map<String,Object> UserInfo = new HashMap<>();
			UserInfo.put("code", resultAuthNumber);
			UserInfo.put("UserInfo", resultUserDTO);
			if(resultUserDTO == null) {
				return null;
			}else {
				return UserInfo;
			}	// end if-else
			
		}catch(Exception e) {
			throw new ControllerException(e);
		}	// 	end try-cathc
	}	// end checkFindPassword
	
	@GetMapping("/changePassword")
	public void changePassword(String Email) throws ControllerException{
		this.getThisClassInfo();
		log.info("\n\t changePassword() invoked.");
	};
	
	@ResponseBody
	@PostMapping("multiCheckAndChangePassword")
	public Boolean multiChangePassword(String Email,String Pw) throws ControllerException{
		this.getThisClassInfo();
		log.info("\n\t multiChangePassword(Email : {}, Pw : {}) invoked.",Email,Pw);
		
		try {
			Boolean result = this.userSerivce.changePassword(Email, Pw);
			this.getThisClassInfo();
			log.info("result : {}",result);
			
			if(result) {
				log.info("\n\t 컨트롤러 비밀번호 변경 성공!!!");
				return result;
			}else {
				log.info("\n\t 컨트롤러 비밀번호 변경 실패!!!");
				return result;
			}
		}catch(Exception e) {
			throw new ControllerException(e);
		}	// end try-catch
	}	// end mutiChangePassword
	
	
	@GetMapping("/mypage")
	public void mypage() throws ControllerException{
		log.info("mypage() invoked.");
	}	//	end mypage	
	
	
}	//	end class
