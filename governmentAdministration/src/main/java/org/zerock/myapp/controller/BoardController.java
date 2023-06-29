package org.zerock.myapp.controller;

import java.util.List;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpSession;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.SessionAttributes;
import org.springframework.web.servlet.mvc.support.RedirectAttributes;
import org.zerock.myapp.domain.AuditorDTO;
import org.zerock.myapp.domain.AuditorVO;
import org.zerock.myapp.domain.AuditormanageDTO;
import org.zerock.myapp.domain.UserDTO;
import org.zerock.myapp.exception.ControllerException;
import org.zerock.myapp.service.BoardService;
import org.zerock.myapp.service.UserService;

import lombok.NoArgsConstructor;
import lombok.Setter;
import lombok.extern.log4j.Log4j2;

@Log4j2
@NoArgsConstructor

@SessionAttributes("__AUTH__")
@RequestMapping("/board")
@Controller
public class BoardController {

	@Setter(onMethod_= {@Autowired})
	private BoardService boardService;
	
	@Setter(onMethod_= {@Autowired})
	private UserService userService;
	
	@GetMapping("/mainPage")
	public void mainPage()throws ControllerException{
		log.info("\n\t thisClass : {}",this.getClass());
		log.info("\n\t mainPage() invoked.");
	}	// end mainPage
	
	@PostMapping("/mainPage")
	public String mainPage(
			Model model,
			String email,
			HttpServletRequest hsr,
			RedirectAttributes rttrs
		) throws ControllerException{
		log.trace("\n\t thisClass : {}",this.getClass());
		log.trace("\n\t mainPage() invoked.");
		log.trace("\n\t Model : {}",model);
		log.trace("\n\t Email : {}",email);
		log.trace("\n\t HttpServletRequest : {}",hsr);
		log.trace("\n\t RedirectAttributes : {}",rttrs);
		
		try {
			UserDTO userDTO = this.userService.UserInfo(email);
			HttpSession httpSession = hsr.getSession();
			model.addAttribute("__USER__",userDTO);
			
			
			HttpSession session = hsr.getSession(false);
			session.setAttribute("SESS_USER_EMAIL", userDTO.getEmail());
			session.setAttribute("SESS_USER_NM", userDTO.getName());
			session.setAttribute("SESS_AUTH_CD", userDTO.getUserauth());
			session.setAttribute("SESS_DEPART_CD", userDTO.getDepart());
			model.addAttribute("__AUTH__",userDTO);
			log.info("\n\t SESS_USER_ID : {}",session.getAttribute("SESS_USER_EMAIL"));
			log.info("\n\t SESS_USER_NM : {}",session.getAttribute("SESS_USER_NM"));
			log.info("\n\t SESS_AUTH_CD : {}",session.getAttribute("SESS_AUTH_CD"));
			log.info("\n\t SESS_DEPART_CD : {}",session.getAttribute("SESS_DEPART_CD"));
			
			return "board/mainPage"+userDTO.getEmail();
		}catch(Exception e) {
			throw new ControllerException(e);
		}	// end try-catch
	}	// end mainPage

	@GetMapping("/auditor")
	public void auditor(Model model) throws ControllerException {
		log.trace("\n\t thisClass : {}",this.getClass());
		log.trace("\n\t auditor() invoked.");
		try {
			List<AuditorDTO> list = this.boardService.selectPostingSearchService();
			log.info("List<AuditorDTO> : {}",list);
			list.forEach(log::info);
			model.addAttribute("__LIST__",list);
		}catch(Exception e) {
			throw new ControllerException(e);
		}

	}	// end auditor
	
	@PostMapping("/auditor")
	public String auditor(Model model,AuditorVO vo,AuditorDTO auditorDTO,HttpServletRequest hsr, RedirectAttributes rttrs) throws ControllerException{
		log.trace("\n\t thisClass : {}",this.getClass());
		log.trace("\n\t auditor() invoked.");
		log.trace("\n\t Model : {}",model);
		log.trace("\n\t AuditorDTO : {}",auditorDTO);
		log.trace("\n\t AuditorVO : {}",vo);
		log.trace("\n\t HttpServletRequest : {}",hsr);
		log.trace("\n\t RedirectAttributes : {}",rttrs);
		
		try {
			
			List<AuditorDTO> list = this.boardService.selectStatusTitleSearchService(vo);
			log.info("List<AuditorDTO> : {}",list);
			list.forEach(log::info);
			model.addAttribute("__LIST__",list);
			
			return "/board/auditor";
		}catch(Exception e) {
			throw new ControllerException(e);
		}
	}	//	auditor
	
	@GetMapping("/auditorDetailPage")
	public void auditorDetailPage(Model model, AuditorVO auditorVO) throws ControllerException{
		log.trace("\n\t thisClass : {}",this.getClass());
		log.trace("\n\t auditorDetailPage() invoked.");
		log.trace("\n\t Model : {}",model);
		log.trace("\n\t AuditorVO : {}",auditorVO);
		
		try {
			AuditorVO vo = this.boardService.selectPostingSerivce(auditorVO);
			log.info("AuditorVO : {}",vo);
			model.addAttribute("__auditorVO__",auditorVO);
		}catch(Exception e) {
			throw new ControllerException(e);
		}	// end try-catch
		
	}	// end auditorDetailPage
	
	@GetMapping("/auditorManage")
	public void auditorManage(Model model) throws ControllerException{
		log.trace("\n\t thisClass : {}",this.getClass());
		log.trace("\n\t auditorManage() invoked.");
		log.trace("\n\t Model : {}",model);
		
		try {
			List<AuditormanageDTO> list = this.boardService.selectManagePostingSearchService();
			list.forEach(log::info);
			model.addAttribute("__LIST__",list);
			
		}catch(Exception e) {
			throw new ControllerException(e);
		}	// end try-catch
	}	// end auditorManage
	
	//selectManageDepartmentSearchService
	
	@PostMapping("/auditorManage")
	public String auditorManage(Model model,String department) throws ControllerException{
		log.trace("\n\t thisClass : {}",this.getClass());
		log.trace("\n\t auditorManage() invoked.");
		log.trace("\n\t Model : {}",model);
		log.trace("\n\t department : {}",department);
		
		try {
			 List<AuditormanageDTO> list = this.boardService.selectManageDepartmentSearchService(department);
			 list.forEach(log::info);
			 model.addAttribute("__LIST__",list);
			 return "/board/auditorManage";
		}catch(Exception e) {
			throw new ControllerException(e);
		}
	}	// end auditorManage
	
	@PostMapping("updateManagePosting")
	public Integer updateManagePosting(String thePersonInCharge) throws ControllerException{
		log.trace("\n\t thisClass : {}",this.getClass());
		log.trace("\n\t updateManagePosting() invoked.");
		log.trace("\n\t thePersonInCharge : {}",thePersonInCharge);
		try {
			AuditormanageDTO dto = new AuditormanageDTO();
			dto.setThePersonInCharge(thePersonInCharge);
			Integer result = this.boardService.updateManagePostingService(dto);
			log.info("\n\t result : {}",result);
			return result;
		}catch(Exception e) {
			throw new ControllerException(e);
		}
	}	// end updateManagePosting
}	// end UserController

