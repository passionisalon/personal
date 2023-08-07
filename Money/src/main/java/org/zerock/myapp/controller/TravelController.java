package org.zerock.myapp.controller;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.ResponseBody;
import org.zerock.myapp.domain.Criteria;
import org.zerock.myapp.domain.PageDTO;
import org.zerock.myapp.domain.TravelDTO;
import org.zerock.myapp.exception.ControllerException;
import org.zerock.myapp.service.TravelService;

import lombok.NoArgsConstructor;
import lombok.Setter;
import lombok.extern.log4j.Log4j2;

@Log4j2
@NoArgsConstructor
@RequestMapping("/travel")
@Controller
public class TravelController {

	@Setter(onMethod_= {@Autowired})
	private TravelService travelService;
	
	public void getThisClassInfo() {
		System.out.println();
		log.info("\n\t thisClass : {}",this.getClass().getName());
		System.out.println();
	}	// end getThisClassInfo
	
	// 게시물 리스트 출력 
	@GetMapping("/list")
	public List<TravelDTO> getTravelList(Criteria cri, Model model) throws ControllerException{
		
		this.getThisClassInfo();
		log.info("getTravelList(Criteria : {} , Model : {}) invoked.",cri,model);
		try {
			List<TravelDTO> list = this.travelService.getTravelList(cri);
			this.getThisClassInfo();
			list.forEach(log::info);
			log.info("result List in getTravelList");
			
			model.addAttribute("__TravelLIST__",list);
			
			
			Integer resultGetPageTotal = this.travelService.getPageTotal(cri);
			this.getThisClassInfo();
			log.info("resultGetPageTotal : {}",resultGetPageTotal);
			PageDTO pageDTO = new PageDTO(cri,resultGetPageTotal);
			log.info("result pageDTO in getTravelList");
			
			model.addAttribute("pageMaker",pageDTO);
			
//			???
			List<TravelDTO> secondList = this.travelService.getTravelList(cri);
			this.getThisClassInfo();
			secondList.forEach(log::info);
			log.info("secondList in getTravelList");
			
			model.addAttribute("__TravelLIST2__",secondList);
			
		}catch(Exception e) {
			throw new ControllerException(e);
		}
		return null;	
	}	// end getTravelList
	
	@PostMapping("SearchList")
	@ResponseBody
	public List<TravelDTO> SearchTravelList(Criteria cri, String searchType, String keyword)throws ControllerException{
		this.getThisClassInfo();
		log.info("SearchTravelList(Criteria : {}, searchType : {}, keyword : {})",cri,searchType,keyword);
		
		try {
			
		}catch(Exception e) {
			throw new ControllerException(e);
		}	// end try-catch
		return null;
	}	// end SearchTravelList
	
	@PostMapping("TabList")
	@ResponseBody
	public List<TravelDTO> TabTravelList(String tab) throws ControllerException{
		return null;
	}	//	 end TabTravelList
	
	// 게시물 확인 
	@GetMapping("/view")
	public void getSelectTravel(@RequestParam("seq") Integer seq, Model model) throws ControllerException{
		this.getThisClassInfo();
		log.info("getSelectTravel(seq : {}) invoked.",seq);
		
		try {
			TravelDTO travelDTO = this.travelService.getSelectTravel(seq);
			this.getThisClassInfo();
			log.info("TravelDTO : {}", travelDTO);
			model.addAttribute("__SELECTTRAVEL__",travelDTO);
			
		}catch(Exception e) {
			throw new ControllerException(e);
		}
	}	// end getSelectTravel
}	// end class
