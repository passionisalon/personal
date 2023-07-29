package org.zerock.myapp.mapper;

import org.junit.After;
import org.junit.Before;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.test.context.ContextConfiguration;
import org.springframework.test.context.junit4.SpringJUnit4ClassRunner;

import lombok.NoArgsConstructor;
import lombok.extern.log4j.Log4j2;



@Log4j2
@NoArgsConstructor

// Spring Framework 구동
@RunWith(SpringJUnit4ClassRunner.class)
@ContextConfiguration(locations= { "file:src/main/webapp/WEB-INF/**/root-*.xml" })

public class JUnit4Template {
	
	
	
	// 매번 각 테스트 수행시 마다 수행
	@Before
	public void setup() {		// 전처리 (optional)
		log.trace("setup() invoked.");
		
	} // setup
	
	
	// 테스트 메소드 이름은 반드시 접두사 test를 붙여야 한다!!! (관례)
	@Test(timeout=1000 * 2)
	public void testB() {
		log.trace("testB() invoked.");
		
	} // testB
	
	
	// 테스트 메소드 이름은 반드시 접두사 test를 붙여야 한다!!! (관례)
	@Test
	public void testA() {
		log.trace("testA() invoked.");
		
	} // testA
	

	// 매번 각 테스트 수행시 마다 수행
	@After						
	public void tearDown() {	// 후처리 (optional)
		log.trace("tearDown() invoked.");
		
	} // tearDown

} // end class
