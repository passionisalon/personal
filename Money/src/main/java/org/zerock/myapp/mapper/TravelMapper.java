package org.zerock.myapp.mapper;

import java.util.LinkedList;
import java.util.List;

import org.zerock.myapp.domain.Criteria;
import org.zerock.myapp.domain.SearchDTO;
import org.zerock.myapp.domain.TravelDTO;
import org.zerock.myapp.exception.ServiceException;

public interface TravelMapper {

	// travel 게시판의 게시물 전체 불러들이기
	public abstract List<TravelDTO> getTravelList(Criteria cri);

	// travel게시판의 검색어 및 searchType 그리고 tab
	public abstract LinkedList<TravelDTO> SearchTravelList(Criteria cri,SearchDTO searchDTO);
	
	// travel게시판의 검색어 및 searchType 그리고 tab에 따른 pagenataion
	public abstract Integer SearchTravelPage(String searchType, String keyword);
	
	// travel 게시판 게시물 확인하기
	public abstract TravelDTO getSelectTravel(Integer seq) throws ServiceException;
	
	// travel 게시판의 페이지
	public abstract Integer getPageTotalAmount(Criteria cri);
	

}	// end class
