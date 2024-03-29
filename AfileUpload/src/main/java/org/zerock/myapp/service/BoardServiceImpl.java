package org.zerock.myapp.service;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;
import org.zerock.myapp.domain.BoardAttachVO;
import org.zerock.myapp.domain.BoardVO;
import org.zerock.myapp.mapper.BoardAttachMapper;
import org.zerock.myapp.mapper.BoardMapper;

import lombok.NoArgsConstructor;
import lombok.Setter;
import lombok.extern.log4j.Log4j2;

@NoArgsConstructor
@Log4j2
@Service
public class BoardServiceImpl implements BoardService {

	@Setter(onMethod_= {@Autowired})
	private BoardMapper mapper;
	
	@Setter(onMethod_= {@Autowired})
	private BoardAttachMapper attachMapper;
	
	private void getClassInfo() {
		
		System.out.println();
		System.out.printf("\n\t this Class is %s\n", this.getClass().getName());
		System.out.println();
		
	}	// end getClassInfo
	
	@Transactional
	@Override
	public void register(BoardVO board) {
		this.getClassInfo();
		log.info("register(BoardVO : {}) invoked.",board);
		mapper.insertSelectKey(board);
		
		if(board.getAttachList() == null || board.getAttachList().size() <= 0 ) {
			return;
		}	// end if
		
		board.getAttachList().forEach(attach ->{
			
			attach.setBno(board.getBno());
			attachMapper.insert(attach);;
		});
		
	}	// end register

	@Override
	public BoardVO get(Long bno) {

		this.getClassInfo();
		log.info("get() invoked.");
		log.info("bno : {}",bno);
		
		BoardVO vo = this.mapper.read(bno);
		this.getClassInfo();
		log.info("vo : {}",vo);
		
		return vo;
		
	}	// end get

	@Override
	public boolean modify(BoardVO board) {
		// TODO Auto-generated method stub
		return false;
	}

	@Override
	public boolean remove(Long bno) {
		// TODO Auto-generated method stub
		return false;
	}

	@Override
	public List<BoardVO> getList() {
		this.getClassInfo();
		log.info("getList() invoked.");
		
		List<BoardVO> result = this.mapper.getList();
		result.forEach(log::info);
		return result;
	}	// end getList

	// 게시물의 첨부파일들의 목록을 가져옴
	@Override
	public List<BoardAttachVO> getAttachList(Long bno){
		this.getClassInfo();
		log.info("getAttachList(bno : {}) invoked.",bno);
		
		List<BoardAttachVO> result = this.attachMapper.findByBno(bno);
		this.getClassInfo();
		result.forEach(log::info);
		return result;
	}	// end getAttachList
	
}	// end class
