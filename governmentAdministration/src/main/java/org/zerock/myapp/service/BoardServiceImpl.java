package org.zerock.myapp.service;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.zerock.myapp.domain.AuditorDTO;
import org.zerock.myapp.domain.AuditorVO;
import org.zerock.myapp.domain.AuditormanageDTO;
import org.zerock.myapp.domain.AuditormanageVO;
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
	public List<AuditorDTO> selectStatusTitleSearchService(AuditorVO vo) throws ServiceException {
		log.trace("thisClass : {}",this.getClass());
		log.info("\n\t selectStatusTitleSearchService({}) invoked.",vo);
		List<AuditorDTO> list = this.boardMapper.selectStatusTitleSearch(vo);
		list.forEach(log::info);
		return list;
	}	// selectStatusTitleSearchService

	@Override
	public AuditorVO selectPostingSerivce(AuditorVO vo) throws ServiceException {
		log.trace("thisClass : {}",this.getClass());
		log.info("\n\t selectPostingSerivce({}) invoked.",vo);
		AuditorVO auditorVO = this.boardMapper.selectPosting(vo);
		log.info("auditorVO : {}",auditorVO);
		return auditorVO;
	}	// selectPostingSerivce

	@Override
	public List<AuditormanageDTO> selectManagePostingSearchService() throws ServiceException {
		log.trace("thisClass : {}",this.getClass());
		log.info("\n\t selectPostingSerivce() invoked.");
		List<AuditormanageDTO> list = this.boardMapper.selectManagePostingSearch();
		log.info("list : {}",list);
		return list;
	}	// selectManagePostingSearchService

	@Override
	public List<AuditormanageDTO> selectManageDepartmentSearchService(String department) throws ServiceException {
		log.trace("thisClass : {}",this.getClass());
		log.info("\n\t selectManageDepartmentSearchService({}) invoked.",department);
		List<AuditormanageDTO> list = this.boardMapper.selectManageDepartmentSearch(department);
		log.info("list : {}",list);
		return list;
	}	// selectManageDepartmentSearchService

	@Override
	public AuditormanageVO selectManagePostingService(AuditormanageVO vo) throws ServiceException {
		log.trace("thisClass : {}",this.getClass());
		log.info("\n\t selectManagePostingService({}) invoked.",vo);
		AuditormanageVO result = this.boardMapper.selectManagePosting(vo);
		log.info("\n\t result : {}",result);
		return result;
	}	//selectManagePostingService

	@Override
	public Integer updateManagePostingService(AuditormanageDTO dto) throws ServiceException {
		log.trace("thisClass : {}",this.getClass());
		log.info("\n\t updateManagePostingService ({}) invoked.",dto);
		Integer result = this.boardMapper.updateManagePosting(dto);
		log.info("\n\t result : {}",result);
		return result;
	}	// updateManagePostingService

}	// end class
