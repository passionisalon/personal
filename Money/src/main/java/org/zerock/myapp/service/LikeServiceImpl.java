package org.zerock.myapp.service;

import java.util.LinkedList;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.zerock.myapp.domain.LikeDTO;
import org.zerock.myapp.exception.ServiceException;
import org.zerock.myapp.mapper.LikeMapper;

import lombok.NoArgsConstructor;
import lombok.Setter;
import lombok.extern.log4j.Log4j2;

@Log4j2
@NoArgsConstructor
@Service
public class LikeServiceImpl implements LikeService {

	@Setter(onMethod_= {@Autowired})
	private LikeMapper likeMapper;
	
	
	public void getThisClassInfo() {
		System.out.printf("\n\t");
		log.info("\n\t thisClass : {}",this.getClass().getName());
		System.out.printf("\n\t");
	}	// end getThisClassInfo
	
	// like Unlike 서비스
	@Override
	public String setLike(String Email, Integer board_seq, String board) throws ServiceException {
		this.getThisClassInfo();
		log.info("Email : {}",Email);
		log.info("board_seq : {}",board_seq);
		log.info("board : {}",board);
		
		try {
			Integer result = this.likeMapper.setLike(Email, board_seq, board);
			this.getThisClassInfo();
			log.info("result : {}",result);
			
			if(result == 1) {
				log.info("likeService에서 like성공!!!");
				return "like성공!";
			}else {
				log.info("likeService에서 like실패!!!");
				return "like실패";
			}
			
		}catch(Exception e) {
			throw new ServiceException(e);
		}	// end try-catch
		
	}	// end setLike

	// unLike서비스
	@Override
	public String removeLike(String Email,Integer board_seq,String board) throws ServiceException{
		this.getThisClassInfo();
		log.info("Email : {}",Email);
		log.info("board_seq : {}",board_seq);
		log.info("board : {}",board);
		
		try {
			Integer result = this.likeMapper.removeLike(Email, board_seq, board);
			this.getThisClassInfo();
			log.info("result : {}",result);
			if(result == 1) {
				log.info("likeService에서 Unlike성공!!!");
				return "Unlike성공!";
			}else {
				log.info("likeService에서 Unlike실패!!!");
				return "Unlike실패";
			}
		}catch(Exception e) {
			throw new ServiceException(e);
		}
	}	// end revmoveLike
	
	
	// like리스트
	@Override
	public LinkedList<LikeDTO> selectLikeList(String Email,Integer board_seq,String board) throws ServiceException{
		this.getThisClassInfo();
		log.info("Email : {}",Email);
		log.info("board_seq : {}",board_seq);
		log.info("board : {}",board);
		
		try {
			LinkedList<LikeDTO> result = this.likeMapper.selectLikeList(Email, board_seq, board);
			this.getThisClassInfo();
			result.forEach(log::info);
			return result;
		}catch(Exception e) {
			throw new ServiceException(e);
		}
	}	// end selectLikeList
	
	
}	// end class
