package org.zerock.myapp.service;

import java.util.LinkedList;

import org.zerock.myapp.domain.LikeDTO;
import org.zerock.myapp.exception.ServiceException;

public interface LikeService {
	
	// like set서비스
	public abstract String setLike(String Email,Integer board_seq,String board) throws ServiceException;
	
	// unLike서비스
	public abstract String removeLike(String Email,Integer board_seq,String board) throws ServiceException;

	// like리스트
	public abstract LinkedList<LikeDTO> selectLikeList(String email,String board) throws ServiceException;
}	// end Service
