//package org.zerock.myapp.controller;
//
//import java.util.concurrent.TimeUnit;
//
//import org.junit.jupiter.api.AfterAll;
//import org.junit.jupiter.api.AfterEach;
//import org.junit.jupiter.api.BeforeAll;
//import org.junit.jupiter.api.BeforeEach;
//import org.junit.jupiter.api.DisplayName;
//import org.junit.jupiter.api.MethodOrderer;
//import org.junit.jupiter.api.Order;
//import org.junit.jupiter.api.Test;
//import org.junit.jupiter.api.TestInstance;
//import org.junit.jupiter.api.TestInstance.Lifecycle;
//import org.junit.jupiter.api.TestMethodOrder;
//import org.junit.jupiter.api.Timeout;
//import org.junit.jupiter.api.extension.ExtendWith;
//import org.springframework.test.context.ContextConfiguration;
//import org.springframework.test.context.junit.jupiter.SpringExtension;
//
//import lombok.NoArgsConstructor;
//import lombok.extern.log4j.Log4j2;
//
//
//@Log4j2
//@NoArgsConstructor
//
//@ExtendWith(SpringExtension.class)
//@ContextConfiguration(locations = {
//	"file:src/main/webapp/WEB-INF/**/root-*.xml",
//	"file:src/main/webapp/WEB-INF/**/servlet-*.xml"
//})
//
//@TestInstance(Lifecycle.PER_CLASS)
//@TestMethodOrder(MethodOrderer.OrderAnnotation.class)
//public class JUnit5WithSpringFrameworkTemplate {
//	
//	
//	@BeforeAll
//	void beforeAll() {		// 1회성 전처리
//		log.trace("beforeAll() invoked.");
//		
//	} // beforeAll
//	
//	@BeforeEach
//	void beforeEach() {		// 매 테스트 수행시 전처리
//		log.trace("beforeEach() invoked.");
//		
//	} // beforeEach
//	
//	
////	@Disabled
//	@Test
//	@Order(1)
//	@DisplayName("contextLoads")
//	@Timeout(value=1, unit=TimeUnit.SECONDS)
//	void contextLoads() {	// 단위테스트 
//		log.trace("contextLoads() invoked.");
//		
//	} // contextLoads
//	
//	@AfterAll
//	void afterAll() {	// 1회성 후처리
//		log.trace("afterAll() invoked.");
//		
//	} // afterAll
//	
//	@AfterEach
//	void afterEach() {	// 매 테스트 수행시 후처리
//		log.trace("afterEach() invoked.");
//		
//	} // afterEach
//
//} // end class
