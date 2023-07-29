package org.zerock.myapp.controller;

import java.util.List;
import java.util.Objects;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.servlet.mvc.support.RedirectAttributes;
import org.zerock.myapp.domain.BoardDTO;
import org.zerock.myapp.domain.BoardVO;
import org.zerock.myapp.domain.Criteria;
import org.zerock.myapp.domain.PageDTO;
import org.zerock.myapp.exception.ControllerException;
import org.zerock.myapp.service.BoardService;

import lombok.NoArgsConstructor;
import lombok.Setter;
import lombok.extern.log4j.Log4j2;


@Log4j2
@NoArgsConstructor

@RequestMapping("/board")
@Controller
public class BoardController {
	@Setter(onMethod_= @Autowired)
	private BoardService service;
	
	
	// 1. 게시판 목록 조회
	@GetMapping("/list")
	void list(Criteria cri, Model model) throws ControllerException {
		log.trace("list({}, {}) invoked.", cri, model);
		
		try {
			List<BoardVO> list = this.service.getList(cri);
			model.addAttribute("__LIST__", list);
			
			PageDTO pageDTO = new PageDTO(cri, this.service.getTotal());
			model.addAttribute("pageMaker", pageDTO);
		} catch(Exception e) {
			throw new ControllerException(e);
		} // try-catch
	} // list
	
	
	// 2. 새로운 게시물 등록
	@PostMapping(path="/register", params= {"title", "content", "writer"})
	String register(BoardDTO dto, RedirectAttributes rttrs)
			throws ControllerException {
		log.trace("register({}, {}) invoked.", dto, rttrs);
		
		try {
			Objects.requireNonNull(dto);
			
			if(this.service.register(dto)) { // if success
				rttrs.addAttribute("result", "true");
				rttrs.addAttribute("bno", dto.getBno());
			} // if
			
			return "redirect:/board/list";
		} catch(Exception e) {
			throw new ControllerException(e);
		} // try-catch
	} // register
	
	@GetMapping("/register")
	void register() {	// 단순 등록화면 요청
		log.trace("register() invoked.");
		
	} // register
	
	
	// 3. 특정 게시물 상세조회
	@GetMapping(path={ "/get", "/modify" }, params = "bno")
	void get(@RequestParam("bno") Integer bno, Model model)
			throws ControllerException {
		log.trace("get() invoked.");
		
		try {
			BoardVO vo = this.service.get(bno);
			
			model.addAttribute("__BOARD__", vo);
		} catch(Exception e) {
			throw new ControllerException(e);
		} // try-catch
	} // get
	
	
	// 4. 특정 게시물 업데이트 (UPDATE)
	@PostMapping("/modify")
	String modify(BoardDTO dto, Integer currPage, RedirectAttributes rttrs)
			throws ControllerException {
		log.trace("modify({}) invoked.", dto);
		
		try {
			Objects.requireNonNull(dto);
			
			if(this.service.modify(dto)) { // if success
				rttrs.addAttribute("currPage", currPage);
				rttrs.addAttribute("result", "true");
				rttrs.addAttribute("bno", dto.getBno());
			} // if
			
			return "redirect:/board/list";
		} catch(Exception e) {
			throw new ControllerException(e);
		} // try-catch
	} // modify
	
	
	// 5. 특정 게시물 삭제 (DELETE)
	@PostMapping("/remove")
	String remove(Integer currPage, Integer bno, RedirectAttributes rttrs)
			throws ControllerException {
		log.trace("remove({}, {}) invoked.", currPage, bno);
		
		try {
			rttrs.addAttribute("currPage", currPage);
			
			if(this.service.remove(bno)) { // if success
				
				rttrs.addAttribute("result", "true");
				rttrs.addAttribute("bno", bno);
				
			} // if
			
			return "redirect:/board/list";
		} catch(Exception e) {
			throw new ControllerException(e);
		} // try-catch
	} // remove
	
	
} // end class
