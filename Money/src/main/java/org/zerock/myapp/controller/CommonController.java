package org.zerock.myapp.controller;

import javax.servlet.http.HttpServletRequest;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.servlet.mvc.support.RedirectAttributes;
import org.zerock.myapp.exception.ControllerException;

import lombok.NoArgsConstructor;
import lombok.extern.log4j.Log4j2;

@Log4j2
@NoArgsConstructor

@RequestMapping
@Controller
public class CommonController {
	
//	@Setter(onMethod_= {@Autowired})
//	private 
	
	@GetMapping("/login")
	public void login() throws ControllerException {
		log.info("\n\t login() invoked");
		try {
			
		}catch(Exception e) {
			throw new ControllerException(e);
		}
	}	// end login
	
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
}	// end class 
