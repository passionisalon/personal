package org.zerock.myapp.service;

import java.util.LinkedList;
import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.zerock.myapp.domain.Criteria;
import org.zerock.myapp.domain.SearchDTO;
import org.zerock.myapp.domain.TravelDTO;
import org.zerock.myapp.exception.ServiceException;
import org.zerock.myapp.mapper.TravelMapper;

import lombok.NoArgsConstructor;
import lombok.Setter;
import lombok.extern.log4j.Log4j2;

@Log4j2
@NoArgsConstructor
@Service

public class TravelServiceImpl implements TravelService {

	@Setter(onMethod_= {@Autowired})
	private TravelMapper travelMapper;
	
	public void getThisClassInfo() {
		System.out.printf("\n\t");
		log.info("\n\t thisClass : {}",this.getClass().getName());
		System.out.printf("\n\t");
	}	// end getThisClassInfo
	
	// travel게시판 게시물 리스트 
	@Override
	public List<TravelDTO> getTravelList(Criteria cri) throws ServiceException {
		
		this.getThisClassInfo();
		log.info("getTravelList(Criteria : {}) invoked.)",cri);
		try {
			List<TravelDTO> list = this.travelMapper.getTravelList(cri);
			this.getThisClassInfo();
			list.forEach(log::info);
			log.info("출력됨");
			return list;
		}catch(Exception e) {
			throw new ServiceException(e);
		}	// end try-catch
		
	}	// end getTravelList
	
	// 게시물 한개 확인 
	@Override
	public TravelDTO getSelectTravel(Integer seq) throws ServiceException {
		
		this.getThisClassInfo();
		log.info("getSelectTravel(seq : {}) invoked.",seq);
		
		try {
			TravelDTO result = this.travelMapper.getSelectTravel(seq);
			this.getThisClassInfo();
			log.info("result : {}",result);
			return result;
		}catch(Exception e) {
			throw new ServiceException(e);
		}	// end try-catch
		
	}	// end getSelectTravel

	// travel게시판 페이지 
	@Override
	public Integer getPageTotal(Criteria cri) throws ServiceException{
		
		this.getThisClassInfo();
		log.info("getPageTotal(Criteria : {}) invoked.",cri);
		
		try {
			Integer resultPageAmount = this.travelMapper.getPageTotalAmount(cri);
			this.getThisClassInfo();
			log.info("resultPageAmount : {}",resultPageAmount);
			return resultPageAmount;
		}catch(Exception e) {
			throw new ServiceException(e);
		}	// end try-catch
		
	}// end getPageTotal

	@Override
	public LinkedList<TravelDTO> SearchTravelList(String searchType, String keyword) throws ServiceException {
		this.getThisClassInfo();
		log.info("SearchTravelList(searchType : {}, keyword : {}",searchType,keyword);
		
		try {
			Integer currPage = 1;
			Integer amount = 10;
			LinkedList<TravelDTO> list = this.travelMapper.SearchTravelList(currPage,amount,searchType, keyword);
			this.getThisClassInfo();
			list.forEach(log::info);
			log.info("출력됨");
			return list;	
		}catch(Exception e) {
			throw new ServiceException(e);
		}	// end try-catch
		
	}// end	SearchTravelList

	@Override
	public Integer SearchTravelPage(String searchType, String keyword) throws ServiceException {
		this.getThisClassInfo();
		log.info("SearchTravelPage(searchType : {}, keyword : {})",searchType,keyword);
		
		try {
			Integer resultPageAmount =this.travelMapper.SearchTravelPage(searchType, keyword);
			this.getThisClassInfo();
			log.info("resultPageAmount : {}",resultPageAmount);
			return resultPageAmount;
		}catch(Exception e) {
			throw new ServiceException(e);
		}	// end try-catch
		
	}	// end SearchTravelPage
	
	
	
}	// end class
