//package org.zerock.myapp.mapper;
//
//import java.util.List;
//
//import org.apache.ibatis.annotations.Select;
//import org.zerock.myapp.domain.BoardDTO;
//import org.zerock.myapp.domain.BoardVO;
//import org.zerock.myapp.domain.Criteria;
//
//
//public interface BoardMapper {
//	
//	
//	// 1. 과연 게시판 목록조회, C/R/U/D/LIST 에 필요한 메소드는 무엇일까!?	
//	@Select("""
//			SELECT /*+ index_desc(tbl_board) */ *
//			FROM tbl_board
//			OFFSET ( #{currPage} - 1) * #{amount} ROWS
//			FETCH NEXT #{amount} ROWS ONLY
//			""")
//	public abstract List<BoardVO> selectList(Criteria cri);
//	
//	// 2. 새로운 게시물 등록
//	public abstract Integer insert(BoardDTO dto);
//	
//	// 3. 특정 게시물 상세조회
//	public abstract BoardVO select(Integer bno);
//	
//	// 4. 특정 게시물 삭제
//	public abstract Integer delete(Integer bno);
//	
//	// 5. 특정 게시물 업데이트(갱신)
//	public abstract Integer update(BoardDTO dto);
//	
//	// 6. 요청싯점에 총 게시물(레코드) 개수를 반환
//	@Select("SELECT count(bno) FROM tbl_board WHERE bno > 0")
//	public abstract Integer getTotalAmount();
//
//} // end interface
