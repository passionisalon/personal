package org.zerock.myapp.controller;

import javax.servlet.http.HttpServletRequest;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.ResponseBody;
import org.springframework.web.servlet.mvc.support.RedirectAttributes;
import org.zerock.myapp.exception.ControllerException;
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
	
	public void getThisClassInfo() {
		System.out.printf("\n\t");
		log.info("\n\t thisClass : {}",this.getClass().getName());
		System.out.printf("\n\t");
	}	// end getThisClassInfo
	
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
			String Pw, 
			Model model, 
			HttpServletRequest hrs, 
			RedirectAttributes rttrs
		) throws ControllerException{
		
		this.getThisClassInfo();
		log.info("\n\t PostMapping login() invoked.");
		log.info("\n\t UserEmail : {}",Email);
		log.info("\n\t UserPw : {}",Pw);
		log.info("\n\t model : {}",model);
		log.info("\n\t HttpServletRequest : {}",hrs);
		log.info("\n\t RedirectAttributes : {}",rttrs);
		
		try {
			log.info("\n\t UserSerivce : {}",userSerivce);
			Boolean loginResult = this.userSerivce.UserLogin(Email, Pw, hrs);
			this.getThisClassInfo();
			log.info("\n\t loginResult : {}",loginResult);
			
			if(loginResult==false) {
				log.info("\n\t 로그인 실패 도메인 페이지로 이동");
				return "/user/domain";
			}else {
				log.info("\n\t 로그인 성공!!! 마이페이지로 이동");
				return "/user/mypage";
			}	// end if - else
			
		}catch(Exception e) {
			throw new ControllerException(e);
		}	//	end try-catch
		

	}	// end Post login
	
	@GetMapping("/domain")
	public void domain() throws ControllerException{
		this.getThisClassInfo();
		log.info("\n\t GetMapping domain() invoked.");
	}	// end GetMapping domain
	
	@GetMapping("/mypage")
	public void mypage() throws ControllerException{
		log.info("mypage() invoked.");
	}	//	end mypage
	
	
	@GetMapping("/join")
	public void join() throws ControllerException{
		log.info("\n\t join() invoked.");
		try {
			
		}catch(Exception e) {
			throw new ControllerException(e);
		}
	}	// end join
	
	@PostMapping("/join")
	public String join(String userEmail, String userPw, HttpServletRequest hsr, RedirectAttributes rttrs) throws ControllerException{
		log.info("\n\t join() invoked.");
		return null;
	}
	
	
	
	
}	//	end class
