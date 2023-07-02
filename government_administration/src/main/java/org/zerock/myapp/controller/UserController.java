package org.zerock.myapp.controller;

import java.util.Objects;

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
import org.zerock.myapp.domain.UserVO;
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
	private UserService userService;
	
	@GetMapping("/login")
	public void login() {
		;;
	}	// end GetMapping login
	
	@ResponseBody
	@PostMapping("/login")
	public String login(
			String Email,
			String Password,
			Model model,
			HttpServletRequest hsr,
			RedirectAttributes rttrs
		)throws ControllerException {
		log.trace("\n\t thisClass : {}",this.getClass());
		log.trace("\n\t login() invoked.");
		log.trace("\n\t Email : {}",Email);
		log.trace("\n\t Password : {}",Password);
		log.trace("\n\t Model : {}",model);
		log.trace("\n\t HttpServletRequest : {}",hsr);
		log.trace("\n\t RedirectAttributes : {}",rttrs);
		
		try {
			UserDTO userDTO = new UserDTO();
			userDTO.setEmail(Email);
			userDTO.setPassword(Password);
			UserVO vo = this.userService.loginUser(userDTO);
			log.info("\n\t UserVO : {}",vo);
			
			if(vo != null) {
				
				HttpSession session = hsr.getSession(false);
				if(session != null) {
					session.invalidate();
				}	// end if
				session = hsr.getSession();
				session.setAttribute("SESS_USER_EMAIL", vo.getEmail());
				session.setAttribute("SESS_USER_NM", vo.getName());
				session.setAttribute("SESS_AUTH_CD", vo.getUserauth());
				session.setAttribute("SESS_DEPART_CD", vo.getDepart());
				model.addAttribute("__AUTH__",vo);
				log.info("\n\t SESS_USER_ID : {}",session.getAttribute("SESS_USER_EMAIL"));
				log.info("\n\t SESS_USER_NM : {}",session.getAttribute("SESS_USER_NM"));
				log.info("\n\t SESS_AUTH_CD : {}",session.getAttribute("SESS_AUTH_CD"));
				log.info("\n\t SESS_DEPART_CD : {}",session.getAttribute("SESS_DEPART_CD"));
				
				return "/board/mainPage";

			}else {
				rttrs.addAttribute("__RESULT__","로그인실패");
				return "/user/login";
			}	// end if - else
			
			
		}catch(Exception e) {
			throw new ControllerException(e);
		}	// 	end try-catch
	}	// end login
	
	@PostMapping("/logout")
	public ResponseEntity<Integer> logout(HttpServletRequest req) throws ControllerException {
		System.out.println(":::logout:::");
		
		try {
			HttpSession session = req.getSession(false);
			
			if(session != null) {
				log.info("로그아웃 성공");
				session.invalidate();
				return ResponseEntity.ok(1);
			}else {
				log.info("로그아웃 실패");
				return ResponseEntity.ok(0);
			}
			
		}catch(Exception e) {
			throw new ControllerException(e);
		}
	
	}	// end logout
	
	
	
	@GetMapping("/join")
	public void join() throws ControllerException{
		log.info("\n\t thisClass : {}",this.getClass());
		log.info("\n\t join() invoked.");
	}	// end join
	
	@ResponseBody
	@PostMapping("/join")
	public Integer join(
			String email,
			String password,
			String name,
			String gender,
			String userauth,
			String depart

			) throws ControllerException {
		log.info("\n\t thisClass : {}",this.getClass());
		log.info("\n\t join() invoked.");
		log.info("\n\t email : {}",email);
		log.info("\n\t password : {}",password);
		log.info("\n\t name : {}",name);
		log.info("\n\t gender : {}",gender);
		log.info("\n\t userauth : {}",userauth);
		log.info("\n\t depart : {}",depart);
//		log.info("\n\t RedirectAttributes : {}",rttrs);
//		log.info("\n\t Model : {}",model);
		UserDTO userDTO = new UserDTO();
		userDTO.setEmail(email);
		userDTO.setPassword(password);
		userDTO.setName(name);
		userDTO.setGender(gender);
		userDTO.setUserauth(userauth);
		userDTO.setDepart(depart);
		Objects.requireNonNull(userDTO);
		
		try {
			Integer result = this.userService.insertJoin(userDTO);
			log.info("\n\t result : {}",result);
			if(result ==1) {
				log.info("가입 잘됨");
				return result;
			}else {
				log.info("가입 잘 안됨");
				return 0;
			}
			
		}catch(Exception e) {
			throw new ControllerException(e);
		}	// end try-catch
		
	}	// end join
	
	@ResponseBody
	@GetMapping("/checkDistinctEmail")
	public Boolean checkDistinctEmail(String userEmail)throws ControllerException{
		log.info("\n\t thisClass : {}",this.getClass());
		log.info("\n\t checkDistinctEmail({}) invoked.",userEmail);
		try {
			Integer result = this.userService.checkDistinctEmail(userEmail);
			log.info("result : {}",result);
			if(result == 1) {
				return false;	
			}else {
				return true;
			}
			
		}catch(Exception e) {
			throw new ControllerException(e);
		}	// end try-catch
	}	// end checkDistinctEmail
	
	@GetMapping("/userModifyPage")
	public void updateUserInformation() throws ControllerException{
		;;
	}	// end updateUserInformation
	
	@ResponseBody
	@PostMapping("/userModifyPage")
	public Integer updateUserInformation(
			HttpServletRequest hsr,
			Model model,
			String email,
			String name,
			String gender,
			String userauth,
			String depart
			)throws ControllerException{
		try {
			log.info("\n\t thisClass : {}",this.getClass());
			log.info("\n\t updateUserInformation() invoked.");
			log.info("email : {}",email);
			log.info("name : {}",name);
			log.info("gender : {}",gender);
			log.info("userauth : {}",userauth);
			log.info("depart : {}",depart);
			UserDTO dto = new UserDTO();
			dto.setEmail(email);
			dto.setName(name);
			dto.setGender(gender);
			dto.setUserauth(userauth);
			dto.setDepart(depart);
			
			Integer result = this.userService.updateUserInformation(dto);
			if(result == 1) {
				HttpSession session = hsr.getSession(false);
				session.setAttribute("SESS_USER_EMAIL", dto.getEmail());
				session.setAttribute("SESS_USER_NM", dto.getName());
				session.setAttribute("SESS_AUTH_CD", dto.getUserauth());
				session.setAttribute("SESS_DEPART_CD", dto.getDepart());
				model.addAttribute("__AUTH__",dto);
				log.info("\n\t SESS_USER_ID : {}",session.getAttribute("SESS_USER_EMAIL"));
				log.info("\n\t SESS_USER_NM : {}",session.getAttribute("SESS_USER_NM"));
				log.info("\n\t SESS_AUTH_CD : {}",session.getAttribute("SESS_AUTH_CD"));
				log.info("\n\t SESS_DEPART_CD : {}",session.getAttribute("SESS_DEPART_CD"));
				System.out.println("회원 수정됨");
				return result;
			}else {
				System.out.println("회원 수정안됨");
				return result;
			}
			
		}catch(Exception e) {
			throw new ControllerException(e);
		}	// end try-catch
	}
		
	@GetMapping("/mypage")
	public void mypage(String email,Model model)throws ControllerException {
		try {
			;;
		}catch(Exception e) {
			throw new ControllerException(e);
		}	// end try-catch
	}	// end mypage
	
	
	
	
}	// end UserController

