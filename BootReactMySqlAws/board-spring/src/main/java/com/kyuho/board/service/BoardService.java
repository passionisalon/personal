package com.kyuho.board.service;


import java.time.Instant;
import java.time.temporal.ChronoUnit;
import java.util.ArrayList;
import java.util.Date;
import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.kyuho.board.dto.ResponseDto;
import com.kyuho.board.entity.BoardEntity;
import com.kyuho.board.entity.PopularSearchEntity;
import com.kyuho.board.repository.BoardRepository;
import com.kyuho.board.repository.PopularSearchRepository;

@Service
public class BoardService {
	
	@Autowired 
	BoardRepository boardRepository;
	
	@Autowired 
	PopularSearchRepository popularSearchRepository;
	
	private void thisClassInfo() {
		System.out.println();
		System.out.printf("thisClass : %s\n",this.getClass().getName());
		System.out.println();
	}
	
	
	public ResponseDto<List<BoardEntity>> getTop3(){
		this.thisClassInfo();
		System.out.printf("getTop3() invoked.\n");
		
		List<BoardEntity> boardList = new ArrayList<BoardEntity>();
		Date date = Date.from(Instant.now().minus(7,ChronoUnit.DAYS));
		
		
		try {
			boardList = this.boardRepository.findTop3ByBoardWriteDateAfterOrderByBoardLikesCountDesc(date);
		}catch(Exception e) {
			e.printStackTrace();
			return ResponseDto.setFailed("DB Error");
		}
		
		return ResponseDto.setSuccess("Success",boardList);
	}	// end getTop3
	
	public ResponseDto<List<BoardEntity>> getList(){
		this.thisClassInfo();
		System.out.println("getList() invoked.");
		
		List<BoardEntity> boardList = new ArrayList<BoardEntity>();
		
		try {
			boardList = this.boardRepository.findByOrderByBoardWriteDateDesc();
		}catch(Exception e) {
			e.printStackTrace();
			return ResponseDto.setFailed("DB Error");
		}
		
		return ResponseDto.setSuccess("Success",boardList);
		
	}	// end getList
	
	public ResponseDto<List<PopularSearchEntity>> getPopularsearchList(){
		List<PopularSearchEntity> popularSearchList = new ArrayList<PopularSearchEntity>();
		
		try {
			popularSearchList = this.popularSearchRepository.findTop10ByOrderByPopularSearchCountDesc();
		}catch(Exception e) {
			e.printStackTrace();
			return ResponseDto.setFailed("DB Error");
		}
		
		return ResponseDto.setSuccess("Success", popularSearchList);
	}	// end getPopularsearchList
	
}	// end class
