package org.zerock.myapp.controller;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.MediaType;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.ResponseBody;
import org.springframework.web.servlet.mvc.support.RedirectAttributes;
import org.zerock.myapp.domain.BoardAttachVO;
import org.zerock.myapp.domain.BoardVO;
import org.zerock.myapp.domain.Criteria;
import org.zerock.myapp.service.BoardService;

import lombok.Setter;
import lombok.extern.log4j.Log4j2;

@Log4j2
@Controller
@RequestMapping("/board/*")
public class BoardController {
	
	@Setter(onMethod_= {@Autowired})
	private BoardService service;
	
	private void getClassInfo() {
		System.out.println();
		System.out.println();
		log.info("this Class Info : {}",this.getClass().getName());
		System.out.println();
	}	// end getClassInfo
	
	@GetMapping("/list")
	public void list(Model model) {
		this.getClassInfo();
		log.info("list(Model : {}) invoked.",model);
		List<BoardVO> result = this.service.getList();
		this.getClassInfo();
		result.forEach(log::info);
		model.addAttribute("boardList",result);
	}
	
	
	@GetMapping("/register")
	public void register() {
		this.getClassInfo();
		log.info("register() invoked.");
	}	// end register
	
	@PostMapping("/register")
	public String register(BoardVO board, RedirectAttributes rttr) {
		this.getClassInfo();
		log.info("register(BoardVO : {} , RedirectAttributes : {}) invoked.",board, rttr);
		
		if(board.getAttachList() != null) {
			board.getAttachList().forEach(attach -> log.info(attach));
		}	// end if
		
		service.register(board);
		rttr.addFlashAttribute("result",board.getBno());
		
		return "redirect:/board/list";
	}	// end register
	
	@GetMapping({"/get","/modify"})
	public void get(@RequestParam("bno") Long bno, @ModelAttribute("cri") Criteria cri, Model model) {
		this.getClassInfo();
		log.info("get() or modify() invoked.");
		log.info("bno : {}",bno);
		log.info("cri : {}",cri);
		log.info("model : {}",model);
		
		BoardVO vo = this.service.get(bno);
		this.getClassInfo();
		log.info("vo : {}",vo);
		model.addAttribute("board",vo);
		
		log.info("get() terminate");
		
	}	// end get
	
	
	@GetMapping(value = "/getAttachList", produces = MediaType.APPLICATION_JSON_UTF8_VALUE)
	@ResponseBody
	public ResponseEntity<List<BoardAttachVO>> getAttachList(Long bno){
		
		this.getClassInfo();
		log.info("getAttachList(bno : {}) invoked.",bno);
		
		ResponseEntity<List<BoardAttachVO>> result = new ResponseEntity<>(this.service.getAttachList(bno),HttpStatus.OK);
		
		this.getClassInfo();
		log.info("result : {}",result);
		
		return result;
		
	}	// end getAttachList
	
}	// end class
