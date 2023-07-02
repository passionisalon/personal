package org.zerock.myapp.controller;

import java.util.List;
import java.util.Map;

import javax.servlet.http.HttpServletRequest;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.ResponseBody;
import org.springframework.web.servlet.mvc.support.RedirectAttributes;
import org.zerock.myapp.domain.AuditorDTO;
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
	
//	@PostMapping("/mainPage")
//	public String mainPage(
//			Model model,
//			String email,
//			HttpServletRequest hsr,
//			RedirectAttributes rttrs
//		) throws ControllerException{
//		log.trace("\n\t thisClass : {}",this.getClass());
//		log.trace("\n\t mainPage() invoked.");
//		log.trace("\n\t Model : {}",model);
//		log.trace("\n\t Email : {}",email);
//		log.trace("\n\t HttpServletRequest : {}",hsr);
//		log.trace("\n\t RedirectAttributes : {}",rttrs);
//		
//		try {
//			UserDTO userDTO = this.userService.UserInfo(email);
//			HttpSession httpSession = hsr.getSession();
//			model.addAttribute("__USER__",userDTO);
//			
//			
//			HttpSession session = hsr.getSession(false);
//			session.setAttribute("SESS_USER_EMAIL", userDTO.getEmail());
//			session.setAttribute("SESS_USER_NM", userDTO.getName());
//			session.setAttribute("SESS_AUTH_CD", userDTO.getUserauth());
//			session.setAttribute("SESS_DEPART_CD", userDTO.getDepart());
//			model.addAttribute("__AUTH__",userDTO);
//			log.info("\n\t SESS_USER_ID : {}",session.getAttribute("SESS_USER_EMAIL"));
//			log.info("\n\t SESS_USER_NM : {}",session.getAttribute("SESS_USER_NM"));
//			log.info("\n\t SESS_AUTH_CD : {}",session.getAttribute("SESS_AUTH_CD"));
//			log.info("\n\t SESS_DEPART_CD : {}",session.getAttribute("SESS_DEPART_CD"));
//			
//			return "board/mainPage"+userDTO.getEmail();
//		}catch(Exception e) {
//			throw new ControllerException(e);
//		}	// end try-catch
//	}	// end mainPage

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
	@ResponseBody
	@PostMapping("/auditor")
	public List<AuditorDTO> auditor(
			Model model,
			String keyword,
			String status,
			HttpServletRequest hsr,
			RedirectAttributes rttrs
			) throws ControllerException{
		log.trace("\n\t thisClass : {}",this.getClass());
		log.trace("\n\t auditor() invoked.");
		log.trace("\n\t Model : {}",model);
		log.trace("\n\t title : {}",keyword);
		log.trace("\n\t status : {}",status);
		log.trace("\n\t HttpServletRequest : {}",hsr);
		log.trace("\n\t RedirectAttributes : {}",rttrs);
		
		try {
			AuditorDTO auditorDTO = new AuditorDTO();
			auditorDTO.setStatus(status);
			auditorDTO.setKeyword(keyword);
			System.err.println("CheckPoint1");
			List<AuditorDTO> list = this.boardService.selectStatusTitleSearchService(auditorDTO);
			System.err.println("CheckPoint2");
			log.info("List<AuditorDTO> : {}",list);
			System.err.println("CheckPoint3");
			list.forEach(log::info);
			System.err.println("CheckPoint4");
			model.addAttribute("__LIST__",list);
			System.err.println("CheckPoint5");
			
			return list;
		}catch(Exception e) {
			throw new ControllerException(e);
		}
	}	//	auditor
	
	
	@GetMapping("/auditorDetailPage")
	public void boardAuditorDetailPage(Model model,Integer seq) throws ControllerException{
		log.trace("auditorDetailPage({}) invoked.",seq);
		AuditorDTO auditorDTO = new AuditorDTO();
		auditorDTO.setSeq(seq);
		try {
			AuditorDTO dto = this.boardService.selectPostingSerivce(auditorDTO);
			log.info("vo : {} ",dto);
			log.info("vo.seq : {}",dto.getSeq());
			System.out.println(dto.getSeq());
			model.addAttribute("__auditor__",dto);
			System.out.println("vo : "+dto);
			log.info("auditorDetailPage Done");
		}catch(Exception e) {
			throw new ControllerException(e);
		}	// end try-catch
		
	}	// end auditorDetailPage

	
	
	@GetMapping("/auditorManage")
	public void auditorManage(Model model,HttpServletRequest req,UserDTO dto) throws ControllerException{
		log.trace("\n\t thisClass : {}",this.getClass());
		log.trace("\n\t auditorManage() invoked.");
		log.trace("\n\t Model : {}",model);
		
		try {
			List<AuditorDTO> list = this.boardService.selectManagePostingSearchService();
			list.forEach(log::info);
			model.addAttribute("__LIST__",list);
			
		}catch(Exception e) {
			throw new ControllerException(e);
		}	// end try-catch
	}	// end auditorManage
	
	//selectManageDepartmentSearchService
	
	@ResponseBody
	@PostMapping("/auditorManage")
	public Map<String,Object> auditorManage(String department) throws ControllerException{
		log.trace("\n\t thisClass : {}",this.getClass());
		log.trace("\n\t auditorManage() invoked.");
		log.trace("\n\t department : {}",department);
		
		try {
			 Map<String,Object> mapList = this.boardService.selectManageDepartSearch(department);
			 log.info("mapList : {}",mapList);

			 return mapList;
		}catch(Exception e) {
			throw new ControllerException(e);
		}
	}	// end auditorManage
	
	@GetMapping("/auditorManageDetailPage")
	public void auditorManageDetailPage(Model model,Integer seq) throws ControllerException{
		log.trace("\n\t thisClass : {}",this.getClass());
		log.trace("\n\t auditorManageDetailPage() invoked.");
		log.info("\n\t seq : {}",seq);
		System.err.println(seq);
		try {
			AuditorDTO auditormanageDTO = this.boardService.selectManagePostingService(seq);
			model.addAttribute("__DTO__",auditormanageDTO);
		}catch(Exception e) {
			throw new ControllerException(e);
		}
		
		
	}	//	end auditorManageDetailPage
	
	@ResponseBody
	@PostMapping("updateManagePosting")
	public Integer updateManagePosting(String email,String UserAuth) throws ControllerException{
		log.trace("\n\t thisClass : {}",this.getClass());
		log.trace("\n\t updateManagePosting() invoked.");
		log.trace("\n\t UserAuth : {}",UserAuth);
		try {
			AuditorDTO dto = new AuditorDTO();
			dto.setEmail(email);
			dto.setUserAuth(UserAuth);
			Integer result = this.boardService.updateManagePostingService(dto);
			log.info("\n\t result : {}",result);
			return result;
		}catch(Exception e) {
			throw new ControllerException(e);
		}
	}	// end updateManagePosting
}	// end UserController

