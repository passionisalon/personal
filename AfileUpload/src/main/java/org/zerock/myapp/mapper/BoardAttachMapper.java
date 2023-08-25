package org.zerock.myapp.mapper;

import java.util.List;

import org.zerock.myapp.domain.BoardAttachVO;

public interface BoardAttachMapper {

	public abstract void insert(BoardAttachVO vo);
	
	public abstract void delete(String uuid);
	
	public abstract List<BoardAttachVO> findByBno(Long bno);
}	// end interface
