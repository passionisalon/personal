package org.zerock.myapp.service;

import org.zerock.myapp.exception.ServiceException;

public interface LikeService {
	
	// like set서비스
	public abstract String setLike(String userEmail,Integer board_seq,String board_name) throws ServiceException;
	
	// unLike서비스
	public abstract String removeLike(String userEmail,Integer board_seq,String board_name) throws ServiceException;
}	// end Service
