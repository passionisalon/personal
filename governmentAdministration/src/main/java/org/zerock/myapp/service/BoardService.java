package org.zerock.myapp.service;

import java.util.List;

import org.zerock.myapp.domain.AuditorDTO;
import org.zerock.myapp.domain.AuditorVO;
import org.zerock.myapp.domain.AuditormanageDTO;
import org.zerock.myapp.domain.AuditormanageVO;
import org.zerock.myapp.exception.ServiceException;

public interface BoardService {
	
	// 국정감사게시판 게시물출력
	public abstract List<AuditorDTO> selectPostingSearchService() throws ServiceException;
		
	// 국정감사게시판 상태 및 제목 조회
	public abstract List<AuditorDTO> selectStatusTitleSearchService(AuditorVO vo) throws ServiceException;
	
	// 국정감사게시판 단일 조회
	public abstract AuditorVO selectPostingSerivce(AuditorVO vo) throws ServiceException;
		
	// 국정감사 관리게시판 게시물출력
	public abstract List<AuditormanageDTO> selectManagePostingSearchService() throws ServiceException;
		
	// 국정감사 관리게시판 부서 조회
	public abstract List<AuditormanageDTO> selectManageDepartmentSearchService(String department) throws ServiceException;
		
	// 국정감사 관리자게시판 단일 조회
	public abstract AuditormanageVO selectManagePostingService(AuditormanageVO vo) throws ServiceException;
		
	// 국정감사 관리자게시판 담당자 지정
	public abstract Integer updateManagePostingService(AuditormanageDTO dto) throws ServiceException;
	
	
	
}	// end interface
