package org.zerock.myapp.service;

import java.util.List;
import java.util.Objects;

import org.springframework.beans.factory.DisposableBean;
import org.springframework.beans.factory.InitializingBean;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.zerock.myapp.domain.BoardDTO;
import org.zerock.myapp.domain.BoardVO;
import org.zerock.myapp.domain.Criteria;
import org.zerock.myapp.exception.ServiceException;
import org.zerock.myapp.mapper.BoardMapper;

import lombok.NoArgsConstructor;
import lombok.Setter;
import lombok.extern.log4j.Log4j2;


@Log4j2
@NoArgsConstructor


@Service("boardService")
public class BoardServiceImpl
	implements 
		BoardService,
		InitializingBean,
		DisposableBean {
	
	@Setter(onMethod_= {@Autowired})
	private BoardMapper dao;			// 영속성 계층의 DAO 빈 주입받음
	
	
	
	// 1. 게시판 목록을 얻어 반환해주는 기능 수행
	@Override
	public List<BoardVO> getList(Criteria cri) throws ServiceException {
		log.trace("getList({}) invoked.", cri);
		
		try {
			return this.dao.selectList(cri);
		} catch(Exception e) {
			throw new ServiceException(e);
		} // try-catch
	} // getList

	
	// 2. 새로운 게시물 등록 기능 수행 (CREATE)
	@Override
	public Boolean register(BoardDTO dto) throws ServiceException {
		log.trace("register({}) invoked.", dto);
		
		try {
			return ( this.dao.insert(dto) == 1 );
		} catch(Exception e) {
			throw new ServiceException(e);
		} // try-catch
	} // register

	@Override
	public BoardVO get(Integer bno) throws ServiceException {
		log.trace("get({}) invoked.", bno);
		
		try {
			return this.dao.select(bno);
		} catch(Exception e) {
			throw new ServiceException(e);
		} // try-catch
	} // get

	@Override
	public Boolean modify(BoardDTO dto) throws ServiceException {
		log.trace("modify({}) invoked.", dto);
		
		try {
			return ( this.dao.update(dto) == 1 );
		} catch(Exception e) {
			throw new ServiceException(e);
		} // try-catch
	} // modify

	@Override
	public Boolean remove(Integer bno) throws ServiceException {
		log.trace("remove({}) invoked.", bno);
		
		try {
			return ( this.dao.delete(bno) == 1 );
		} catch(Exception e) {
			throw new ServiceException(e);
		} // try-catch
	} // remove
	
	
//	======== InitializingBean, DisposableBean ========= //

	@Override
	public void afterPropertiesSet() throws Exception {	// 초기화(=전처리)
		log.trace("afterPropertiesSet() invoked.");
		
//		assert this.dao != null;
		Objects.requireNonNull(this.dao);
		log.info("\t+ this.dao: {}", dao);
	} // afterPropertiesSet

	@Override
	public void destroy() throws Exception {	// 자원해제(=후처리)
		log.trace("destroy() invoked.");
		
	}


	@Override
	public Integer getTotal() throws ServiceException {
		log.trace("getTotal() invoked.");
		
		return this.dao.getTotalAmount();
	} // destroy

} // end class
