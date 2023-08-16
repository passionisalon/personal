package org.zerock.myapp.controller;

import java.util.HashMap;
import java.util.LinkedList;
import java.util.List;
import java.util.Map;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.ResponseBody;
import org.zerock.myapp.domain.Criteria;
import org.zerock.myapp.domain.LikeDTO;
import org.zerock.myapp.domain.PageDTO;
import org.zerock.myapp.domain.TravelDTO;
import org.zerock.myapp.exception.ControllerException;
import org.zerock.myapp.service.LikeService;
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
	
	@Setter(onMethod_= {@Autowired})
	private LikeService likeService;
	
	public void getThisClassInfo() {
		System.out.println();
		log.info("\n\t thisClass : {}",this.getClass().getName());
		System.out.println();
	}	// end getThisClassInfo
	
	// 게시물 리스트 출력 
	@GetMapping("/list")
	public void getTravelList(Criteria cri, Model model) throws ControllerException{
		
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
//			PageDTO pageDTO = new PageDTO(cri,resultGetPageTotal);
			PageDTO pageDTO = new PageDTO(cri,this.travelService.getPageTotal(cri));
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
	}	// end getTravelList
	
	// 검색 기능 탭과 검색, 
	@PostMapping("/SearchList")
	@ResponseBody
	public Map<String,Object> SearchTravelList(Integer currPages,String searchType, String keyword)throws ControllerException{
		this.getThisClassInfo();
		log.info("SearchTravelList(currPages : {},searchType : {}, keyword : {})",currPages,searchType,keyword);
		
		try {
			LinkedList<TravelDTO> list = this.travelService.SearchTravelList(currPages,searchType, keyword);
			this.getThisClassInfo();
			list.forEach(log::info);
			log.info("TravelController에서 출력됨");
			
			Integer resultPageAmount = this.travelService.SearchTravelPage(searchType, keyword);
			this.getThisClassInfo();
			log.info("resultPageAmount : {}",resultPageAmount);
			
			Map<String,Object> resultMap = new HashMap<String, Object>();
			resultMap.put("list", list);
			resultMap.put("resultPageAmount", resultPageAmount);
			
			log.info(resultMap);
			return resultMap;
		}catch(Exception e) {
			throw new ControllerException(e);
		}	// end try-catch
		
		
	}	// end SearchTravelList
	
	@ResponseBody
	@PostMapping("/like")
	public Boolean userLike(String switchWord,String userEmail,Integer board_seq,String board_name) throws ControllerException{
		this.getThisClassInfo();
		log.info("userEmail : {}",userEmail);
		log.info("board_seq : {}",board_seq);
		log.info("board_name : {}",board_name);
		try {
			Boolean result=false;
			switch(switchWord) {
			case "like" : 
				String resultLike = this.likeService.setLike(userEmail, board_seq, board_name);
				this.getThisClassInfo();
				log.info("resultLike : {}",resultLike);
				result = true;
				break;
				
			case "unlike" : 
				String resultUnLike = this.likeService.removeLike(userEmail, board_seq, board_name);
				this.getThisClassInfo();
				log.info("resultUnLike : {}",resultUnLike);
				result = false;
				break;
				
			default :
				result = false;
				break;
			}	// end switch
			
			return result;
			
		}catch(Exception e) {
			throw new ControllerException(e);
		}
		
	}	// end userLike
	
	@ResponseBody
	@PostMapping("/likeList")
	public LinkedList<LikeDTO> selectLikeList(String Email,String board) throws ControllerException{
		this.getThisClassInfo();
		log.info("Email : {}",Email);
		log.info("board : {}",board);
		
		try {
			LinkedList<LikeDTO> result = this.likeService.selectLikeList(Email, board);
			this.getThisClassInfo();
			result.forEach(log::info);
			return result;
		}catch(Exception e) {
			throw new ControllerException(e);
		}
	}	// end selectLikeList
	
	
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
	
	@GetMapping("/write")
	public void writeTravel() throws ControllerException {
		this.getThisClassInfo();
		log.info("writeTravel() invoked.");
		try {
			
		}catch(Exception e) {
			throw new ControllerException(e);
		}
	}	//	end writeTravel
	
	@ResponseBody
	@PostMapping("/TravelWrite")
	public Boolean writeTravel(
			String writer,
			String category,
			String title, 
			String content, 
			String address,
			String start_date,
			String end_date) 
					throws ControllerException{
		this.getThisClassInfo();
		log.info("writer : {}",writer);
		log.info("category : {}",category);
		log.info("title : {}",title);
		log.info("content : {}",content);
		log.info("address : {}",address);
		log.info("start_date : {}",start_date);
		log.info("end_date : {}",end_date);
		
		try {
			
			Boolean result = this.travelService.writeTravel(writer, category, title, content, address,  start_date, end_date);
			this.getThisClassInfo();
			log.info(result);
			
			return result;
		}catch(Exception e) {
			throw new ControllerException(e);
		}	// end try-catch
		
	}	// writeTravel
	
	@ResponseBody
	@PostMapping("/TravelViewCheckUser")
	public Boolean checkUser(String loginUserNickName , Integer seq) throws ControllerException{
		this.getThisClassInfo();
		log.info("loginUserNickName : {}",loginUserNickName);
		log.info("seq : {}",seq);
		
		try {
			Boolean result = this.travelService.checkTravelViewUser(loginUserNickName, seq);
			this.getThisClassInfo();
			log.info("result : {}",result);
			
			return result;
		}catch(Exception e) {
			throw new ControllerException(e);
		}
	}	// checkUser
	
	@GetMapping("/modify")
	public void travelModify(@RequestParam("seq") Integer seq, Model model) throws ControllerException{
		this.getThisClassInfo();
		log.info("travelModify(seq : {}) invoked.",seq);
		
		try {
			TravelDTO travelDTO = this.travelService.getSelectTravel(seq);
			this.getThisClassInfo();
			log.info("TravelDTO : {}", travelDTO);
			model.addAttribute("__SELECTTRAVEL__",travelDTO);
			
		}catch(Exception e) {
			throw new ControllerException(e);
		}
		
	}	// end travelModfiy
	
	@ResponseBody
	@PostMapping("/modifyAjax")
	public Boolean travelModifyAjax(
			Integer seq,
			String writer,
			String category,
			String title, 
			String content, 
			String address,
			String start_date,
			String end_date
			) throws ControllerException{
		this.getThisClassInfo();
		log.info("seq : {}",seq);
		log.info("writer : {}",writer);
		log.info("category : {}",category);
		log.info("title : {}",title);
		log.info("content : ",content);
		log.info("address : {}",address);
		log.info("start_date : {}",start_date);
		log.info("end_date : {}",end_date);
		try {
			Boolean result = this.travelService.travelModify(seq, writer, category, title, content, address, start_date, end_date);
			this.getThisClassInfo();
			log.info("result : {}",result);
			
			return result;
		}catch(Exception e) {
			throw new ControllerException(e);
		}
		
	}	// end travelModfiyAjax
}	// end class
