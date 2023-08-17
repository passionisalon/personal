package org.zerock.myapp.mapper;

import java.util.LinkedList;

import org.zerock.myapp.domain.LikeDTO;
import org.zerock.myapp.domain.TotalBoardDTO;

public interface LikeMapper {

	// like 하기! travel용
	public abstract Integer setLike(String Email,Integer board_seq,String board);
	
	// like 삭제! travel용
	public abstract Integer removeLike(String Email,Integer board_seq,String board);
	
	// like 리스트 객체로 들고오기 travel용 
	public abstract LikeDTO selectLikeList(LikeDTO request);
//	public abstract LikeDTO selectLikeList(String Email,Integer board_seq,String board);
	
	// 본인의 Like 리스트 리스트로 들고오기 mypage용 
	public abstract LinkedList<TotalBoardDTO> getLikeList(String userEmail);
}	// end interface
