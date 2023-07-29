package org.zerock.myapp.service;

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

public class BoardServiceTests {
	@Setter(onMethod_= { @Autowired })
	private BoardService service;
	
	
	
	// 매번 각 테스트 수행시 마다 수행
	@Before
	public void setup() {		// 전처리 (optional)
		log.trace("setup() invoked.");
		
		assertNotNull(this.service);
		log.info("\t+ this.service: {}", this.service);
	} // setup
	
	
	// 테스트 메소드 이름은 반드시 접두사 test를 붙여야 한다!!! (관례)
	@Test(timeout = 1000 * 1)
	public void testGetList() throws ServiceException {
		log.trace("testGetList() invoked.");
		
		Criteria cri = new Criteria();
//		cri.setCurrPage(1);
//		cri.setCurrPage(20);
		cri.setCurrPage(30);
		
		List<BoardVO> list = this.service.getList(cri);
		
		Objects.requireNonNull(list);		
		list.forEach( log::info );
	} // testGetList
	
	
	// 테스트 메소드 이름은 반드시 접두사 test를 붙여야 한다!!! (관례)
	@Test(timeout = 1000 * 1)
	public void testRegister() throws ServiceException {
		log.trace("testRegister() invoked.");
		
		BoardDTO dto = new BoardDTO();
		dto.setTitle("NEW_TITLE");
		dto.setContent("NEW_CONTENT");
		dto.setWriter("NEW_WRITER");
		
		log.info("\t+ dto: {}", dto);
		
//		---
		
		boolean isSuccess = this.service.register(dto);
		log.info("\t+ isSuccess: {}", isSuccess);
	} // testRegister
	
	
	// 테스트 메소드 이름은 반드시 접두사 test를 붙여야 한다!!! (관례)
	@Test(timeout = 1000 * 1)
	public void testGet() throws ServiceException {
		log.trace("testGet() invoked.");
		
		int bno = 299;
		BoardVO vo = this.service.get(bno);
		
		assert vo != null;
		log.info("\t+ vo: {}", vo);
	} // testGet
	
	
	// 테스트 메소드 이름은 반드시 접두사 test를 붙여야 한다!!! (관례)
	@Test(timeout = 1000 * 1)
	public void testModify() throws ServiceException {
		log.trace("testModify() invoked.");
		
		int bno = 299;
		BoardVO vo = this.service.get(bno);
		
		BoardDTO dto = vo.toDTO();
		dto.setContent("MODIFIED_CONTENT");
		
		assertNotNull(dto);
		log.info("\t+ dto: {}", dto);
//		---
		
		boolean isSuccess = this.service.modify(dto);
		log.info("\t+ isSuccess: {}", isSuccess);
	} // testModify
	
	
	// 테스트 메소드 이름은 반드시 접두사 test를 붙여야 한다!!! (관례)
	@Test(timeout = 1000 * 1)
	public void testRemove() throws ServiceException {
		log.trace("testGet() invoked.");
		
		int bno = 299;
		boolean isDeleted = this.service.remove(bno);		
		log.info("\t+ isDeleted: {}", isDeleted);
	} // testRemove
	
	
	// 테스트 메소드 이름은 반드시 접두사 test를 붙여야 한다!!! (관례)
	@Test(timeout = 1000 * 1)
	public void testGetTotal() throws ServiceException {
		log.trace("testGetTotal() invoked.");
		
		int totalAmount = this.service.getTotal();		
		log.info("\t+ totalAmount: {}", totalAmount);
	} // testGetTotal

} // end class
