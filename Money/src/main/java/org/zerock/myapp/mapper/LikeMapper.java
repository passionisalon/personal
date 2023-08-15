package org.zerock.myapp.mapper;

import java.util.LinkedList;

import org.zerock.myapp.domain.LikeDTO;

public interface LikeMapper {

	// like 하기!
	public abstract Integer setLike(String Email,Integer board_seq,String board);
	
	// like 삭제!
	public abstract Integer removeLike(String Email,Integer board_seq,String board);
	
	// like 리스트
	public abstract LinkedList<LikeDTO> selectLikeList(String Email,Integer board_seq,String board);
}	// end interface
