package org.zerock.myapp.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
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
		model.addAttribute("__LIST__",service.getList());
	}
	
	
	@GetMapping("/register")
	public void register() {
		this.getClassInfo();
		log.info("register() invoked.");
	}	// end register
}
