package org.zerock.myapp.service;

import java.util.HashMap;
import java.util.List;
import java.util.Map;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.zerock.myapp.domain.AuditorDTO;
import org.zerock.myapp.domain.AuditormanageDTO;
import org.zerock.myapp.exception.ServiceException;
import org.zerock.myapp.mapper.BoardMapper;

import lombok.NoArgsConstructor;
import lombok.Setter;
import lombok.extern.log4j.Log4j2;

@NoArgsConstructor
@Log4j2

@Service("BoardService")
public class BoardServiceImpl implements BoardService {
	
	@Setter(onMethod_= {@Autowired})
	BoardMapper boardMapper;
	
	@Override
	public List<AuditorDTO> selectPostingSearchService() throws ServiceException {
		
		log.trace("thisClass : {}",this.getClass());
		List<AuditorDTO> list  = this.boardMapper.selectPostingSearch();
		log.info("\n\t selectPostingSearchService({}) invoked.");
		list.forEach(log::info);
		return list;
	}	//selectPostingSearchService

	@Override
	public List<AuditorDTO> selectStatusTitleSearchService(AuditorDTO auditorDTO) throws ServiceException {
		log.trace("thisClass : {}",this.getClass());
		log.info("\n\t selectStatusTitleSearchService({}) invoked.",auditorDTO);
		System.out.println("CheckPointService1");
		List<AuditorDTO> list = this.boardMapper.selectStatusTitleSearch(auditorDTO);
		System.out.println("CheckPointService2");
		System.err.println("list : "+list);
		System.out.println("CheckPointService3");
		list.forEach(log::info);
		return list;
	}	// selectStatusTitleSearchService

	@Override
	public AuditorDTO selectPostingSerivce(AuditorDTO auditorDTO) throws ServiceException {
		log.trace("thisClass : {}",this.getClass());
		log.info("\n\t selectPostingSerivce({}) invoked.",auditorDTO);
		AuditorDTO dto = this.boardMapper.selectPosting(auditorDTO);
		log.info("auditorVO : {}",dto);
		return dto;
	}	// selectPostingSerivce

	@Override
	public List<AuditorDTO> selectManagePostingSearchService() throws ServiceException {
		log.trace("thisClass : {}",this.getClass());
		log.info("\n\t selectPostingSerivce() invoked.");
		List<AuditorDTO> list = this.boardMapper.selectManagePostingSearch();
		log.info("list : {}",list);
		return list;
	}	// selectManagePostingSearchService

	@Override
	public Map<String,Object> selectManageDepartSearch(String department) throws ServiceException{
		log.trace("thisClass : {}",this.getClass());
		log.trace("selectManageDepartSearch({}) invoked.",department);
		Map<String,Object> MapList = new HashMap<>();
		List list = this.boardMapper.selectManageDepartmentSearch(department);
		MapList.put(department, list);
		log.trace("thisClass : {}",this.getClass());
		log.info("MapList : {}",MapList);
		return MapList;
	}	// end selectManageDepartSearch
	
	@Override
	public List<AuditorDTO> selectManageDepartmentSearchService(String department) throws ServiceException {
		log.trace("thisClass : {}",this.getClass());
		log.info("\n\t selectManageDepartmentSearchService({}) invoked.",department);
		List<AuditorDTO> list = this.boardMapper.selectManageDepartmentSearch(department);
		log.info("list : {}",list);
		return list;
	}	// selectManageDepartmentSearchService

	@Override
	public AuditorDTO selectManagePostingService(Integer seq) throws ServiceException {
		log.trace("thisClass : {}",this.getClass());
		log.info("\n\t selectManagePostingService({}) invoked.",seq);
		AuditorDTO result = this.boardMapper.selectManagePosting(seq);
		log.info("\n\t result : {}",result);
		return result;
	}	//selectManagePostingService

	@Override
	public Integer updateManagePostingService(AuditorDTO dto) throws ServiceException {
		log.trace("thisClass : {}",this.getClass());
		log.info("\n\t updateManagePostingService ({}) invoked.",dto);
		Integer result = this.boardMapper.updateManagePosting(dto);
		log.info("\n\t result : {}",result);
		return result;
	}	// updateManagePostingService

}	// end class
