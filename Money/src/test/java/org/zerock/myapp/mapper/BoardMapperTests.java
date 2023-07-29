package org.zerock.myapp.mapper;

import static org.junit.Assert.assertNotNull;

import java.util.List;
import java.util.Objects;

import org.junit.Before;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.test.context.ContextConfiguration;
import org.springframework.test.context.junit4.SpringJUnit4ClassRunner;
import org.zerock.myapp.domain.BoardDTO;
import org.zerock.myapp.domain.BoardVO;
import org.zerock.myapp.domain.Criteria;
import org.zerock.myapp.exception.ServiceException;

import lombok.NoArgsConstructor;
import lombok.Setter;
import lombok.extern.log4j.Log4j2;



@Log4j2
@NoArgsConstructor

// Spring Framework 구동
@RunWith(SpringJUnit4ClassRunner.class)
@ContextConfiguration(locations= { "file:src/main/webapp/WEB-INF/**/root-*.xml" })

public class BoardMapperTests {
		
	@Setter(onMethod_= {@Autowired})
	private BoardMapper mapper;
	
	
	
	@Before
	public void setup() {
		log.trace("setup() invoked.");
		
		assertNotNull(this.mapper);
		log.info("\t+ this.mapper: {}", this.mapper);		// MapperProxy
	} // setup
	
	
	// 테스트 메소드 이름은 반드시 접두사 test를 붙여야 한다!!! (관례)
	@Test(timeout=1000*2)
	public void testSelectList() {
		log.trace("testSelectList() invoked.");
		
		Criteria cri = new Criteria();
		cri.setCurrPage(20);
		
		List<BoardVO> boards = this.mapper.selectList(cri);
		
		Objects.requireNonNull(boards);
		boards.forEach(log::info);
	} // testSelectList
	
	
	// 테스트 메소드 이름은 반드시 접두사 test를 붙여야 한다!!! (관례)
	@Test(timeout=1000*2)
	public void testInsert() {
		log.trace("testInsert() invoked.");
		
		BoardDTO dto = new BoardDTO();
		dto.setTitle("NEW_TITLE15");
		dto.setContent("NEW_CONTENT15");
		dto.setWriter("NEW_WRITER15");
		
		log.info("\t+ dto: {}", dto);
		
//		---
		
		Integer affectedLines = this.mapper.insert(dto);
		
		assert affectedLines != null;
		log.info("\t+ result: {}, dto: {}", ( affectedLines == 1 ), dto );
	} // testInsert
	
	
	// 테스트 메소드 이름은 반드시 접두사 test를 붙여야 한다!!! (관례)
	@Test(timeout=1000*2)
	public void testSelect() {
		log.trace("testSelect() invoked.");

		Integer bno = 100;
		
		BoardVO vo = this.mapper.select(bno);
		log.info("\t+ bno: {}, vo: {}", bno, vo);
	} // testSelect
	
	
	// 테스트 메소드 이름은 반드시 접두사 test를 붙여야 한다!!! (관례)
	@Test(timeout=1000*2)
	public void testDelete() throws ServiceException {
		log.trace("testDelete() invoked.");

		Integer bno = -1;
		Integer affectedLines = this.mapper.delete(bno);
		log.info("bno: {}, affectedLines: {}, isSuccess: {}", bno, affectedLines, (affectedLines == 1));
	} // testDelete
	
	
	// 테스트 메소드 이름은 반드시 접두사 test를 붙여야 한다!!! (관례)
	@Test(timeout=1000*2)
	public void testUpdate() {
		log.trace("testUpdate() invoked.");
		
		Integer bno = 100;
		BoardVO vo = this.mapper.select(bno);
		
		assertNotNull(vo);
		
		// VO => DTO
		BoardDTO dto = vo.toDTO();
		
		dto.setTitle("MODIFED_TITLE");
		
		log.info("\t+ dto: {}", dto);	
//		---

		Integer affectedLines = this.mapper.update(dto);
		log.info("affectedLines: {}, isSuccess: {}", affectedLines, (affectedLines == 1));
	} // testUpdate
	
	
	// 테스트 메소드 이름은 반드시 접두사 test를 붙여야 한다!!! (관례)
	@Test(timeout=1000*2)
	public void testGetTotalAmount() {
		log.trace("testGetTotalAmount() invoked.");
		
		int totalAmount = this.mapper.getTotalAmount();
		
		log.info("\t+ totalAmount: {}", totalAmount);
	} // testGetTotalAmount

} // end class
