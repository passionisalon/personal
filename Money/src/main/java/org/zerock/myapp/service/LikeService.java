package org.zerock.myapp.service;

import java.util.LinkedList;

import org.zerock.myapp.domain.LikeDTO;
import org.zerock.myapp.domain.TotalBoardDTO;
import org.zerock.myapp.exception.ServiceException;

public interface LikeService {
	
	// like set서비스
	public abstract String setLike(String Email,Integer board_seq,String board) throws ServiceException;
	
	// unLike서비스
	public abstract String removeLike(String Email,Integer board_seq,String board) throws ServiceException;

	// like리스트
	public abstract LikeDTO selectLikeList(LikeDTO request) throws ServiceException;
//	public abstract LikeDTO selectLikeList(String email,Integer board_seq , String board) throws ServiceException;
	
	// 본인의 Like 리스트 리스트로 들고오기 mypage용 
	public abstract LinkedList<TotalBoardDTO> getLikeList(String userEmail) throws ServiceException;
}	// end Service
