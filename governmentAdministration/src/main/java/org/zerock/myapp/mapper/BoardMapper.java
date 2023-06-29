package org.zerock.myapp.mapper;

import java.util.List;

import org.zerock.myapp.domain.AuditorDTO;
import org.zerock.myapp.domain.AuditorVO;
import org.zerock.myapp.domain.AuditormanageDTO;
import org.zerock.myapp.domain.AuditormanageVO;

public interface BoardMapper {
	
	// 국정감사게시판 게시물출력
	public abstract List<AuditorDTO> selectPostingSearch();
	
	// 국정감사게시판 상태 및 제목 조회
	public abstract List<AuditorDTO> selectStatusTitleSearch(AuditorVO vo);
	
	// 국정감사게시판 단일 조회
	public abstract AuditorVO selectPosting(AuditorVO vo);
	
	// 국정감사 관리게시판 게시물출력
	public abstract List<AuditormanageDTO> selectManagePostingSearch();
	
	// 국정감사 관리게시판 부서 조회
	public abstract List<AuditormanageDTO> selectManageDepartmentSearch(String department);
	
	// 국정감사 관리자게시판 단일 조회
	public abstract AuditormanageVO selectManagePosting(AuditormanageVO vo);
	
	// 국정감사 관리자게시판 담당자 지정
	public abstract Integer updateManagePosting(AuditormanageDTO dto);
}	// end interface
