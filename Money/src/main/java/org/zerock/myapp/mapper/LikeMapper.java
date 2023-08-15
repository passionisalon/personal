package org.zerock.myapp.mapper;

import java.util.LinkedList;

import org.zerock.myapp.domain.TotalBoardDTO;

public interface LikeMapper {

	// like 하기!
	public abstract Integer setLike(String userEmail, Integer board_seq, String board_name);
	
	// like 삭제!
	public abstract Integer removeLike(String userEmail,Integer board_seq,String board_name);
	
	// like 리스트
	public abstract LinkedList<TotalBoardDTO> selectLikeList();
}	// end interface
