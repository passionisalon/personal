//package org.zerock.myapp.service;
//
//import java.util.List;
//
//import org.zerock.myapp.domain.BoardDTO;
//import org.zerock.myapp.domain.BoardVO;
//import org.zerock.myapp.domain.Criteria;
//import org.zerock.myapp.exception.ServiceException;
//
//
//public interface BoardService {
//	
//	// 1. 게시판 목록을 얻어 반환해주는 기능 수행
//	public abstract List<BoardVO> getList(Criteria cri) throws ServiceException;
//	
//	// 2. 새로운 게시물 등록 기능 수행 (CREATE)
//	public abstract Boolean register(BoardDTO dto) throws ServiceException;
//	
//	// 3. 특정 게시물 상세조회 (READ)
//	public abstract BoardVO get(Integer bno) throws ServiceException;
//	
//	// 4. 특정 게시물 업데이트 (UPDATE)
//	public abstract Boolean modify(BoardDTO dto) throws ServiceException;
//	
//	// 5. 특정 게시물 삭제 (DELETE)
//	public abstract Boolean remove(Integer bno) throws ServiceException;
//	
//	// 6. 총 게시물 개수 반환
//	public abstract Integer getTotal() throws ServiceException;
//
//} // end interface
