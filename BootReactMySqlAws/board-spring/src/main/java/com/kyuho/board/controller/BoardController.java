package com.kyuho.board.controller;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.kyuho.board.dto.ResponseDto;
import com.kyuho.board.entity.BoardEntity;
import com.kyuho.board.entity.PopularSearchEntity;
import com.kyuho.board.service.BoardService;

@RestController
@RequestMapping("/api/board")
public class BoardController {
	
	@Autowired
	BoardService boardSerivce;
	
	private void thisClassInfo() {
		System.out.println();
		System.out.printf("thisClass : %s\n",this.getClass().getName());
		System.out.println();
	}	// end thisClassInfo
	
	
//	@GetMapping("/")
//	public String getBoard(@AuthenticationPrincipal String userEmail) {
//		this.thisClassInfo();
//		System.out.printf("getBoard() invoked.\n");
//		
//		String result = "로그인된 사용자는 "+userEmail+"입니다.";
//		System.out.printf("%s\n",result);
//		return result;
//	}	// end getBoard
	
	@GetMapping("/top3")
	public ResponseDto<List<BoardEntity>> getTop3(){
		this.thisClassInfo();
		System.out.printf("getTop3() ivoked.\n");
		return this.boardSerivce.getTop3();
	}	// end getTop3
	
	@GetMapping("/list")
	public ResponseDto<List<BoardEntity>> getList(){
		return this.boardSerivce.getList();
	}	// end getList
	
	@GetMapping("/popularsearchList")
	public ResponseDto<List<PopularSearchEntity>> getPopularsearchList(){
		return this.boardSerivce.getPopularsearchList();
	}	// end getPopularsearchList
}	// end class
