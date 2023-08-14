package org.zerock.myapp.mapper;

import java.util.LinkedList;
import java.util.List;
import java.util.Map;

import org.zerock.myapp.domain.Criteria;
import org.zerock.myapp.domain.TravelDTO;

public interface TravelMapper {

	// travel 게시판의 게시물 전체 불러들이기
	public abstract List<TravelDTO> getTravelList(Criteria cri);

	// travel게시판의 검색어 및 searchType 그리고 tab
	public abstract LinkedList<TravelDTO> SearchTravelList(Integer currPage,Integer amount,String searchType, String keyword);
	
	// travel게시판의 검색어 및 searchType 그리고 tab에 따른 pagenataion
	public abstract Integer SearchTravelPage(String searchType, String keyword);
	
	// travel 게시판 게시물 확인하기
	public abstract TravelDTO getSelectTravel(Integer seq);
	
	// travel 게시판의 페이지
	public abstract Integer getPageTotalAmount(Criteria cri);
	
	// travel 게시판 글쓰기
	public abstract Integer writeTravel(
			String writer, 
			String category,
			String title,
			String content,
			String address,
			String start_date,
			String end_date);
	
	// travel 게시판 작성자 확인
	public abstract String checkTravelViewUser(Integer seq);
	
	// travel 게시판 수정
	public abstract Integer modifyTravel(
			Integer seq,
			String writer,
			String category,
			String title, 
			String content, 
			String address,
			String start_date,
			String end_date);
}	// end class
