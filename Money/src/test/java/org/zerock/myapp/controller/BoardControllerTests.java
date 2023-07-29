package org.zerock.myapp.controller;

import java.util.Objects;

import org.junit.Before;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.test.context.ContextConfiguration;
import org.springframework.test.context.junit4.SpringJUnit4ClassRunner;
import org.springframework.test.context.web.WebAppConfiguration;
import org.springframework.test.web.servlet.MockMvc;
import org.springframework.test.web.servlet.MockMvcBuilder;
import org.springframework.test.web.servlet.request.MockHttpServletRequestBuilder;
import org.springframework.test.web.servlet.request.MockMvcRequestBuilders;
import org.springframework.test.web.servlet.setup.MockMvcBuilders;
import org.springframework.ui.ModelMap;
import org.springframework.web.context.WebApplicationContext;
import org.springframework.web.servlet.ModelAndView;

import lombok.NoArgsConstructor;
import lombok.extern.log4j.Log4j2;


@Log4j2
@NoArgsConstructor

@RunWith(SpringJUnit4ClassRunner.class)
@ContextConfiguration(locations = {
	"file:src/main/webapp/WEB-INF/**/root-*.xml",
	"file:src/main/webapp/WEB-INF/**/servlet-*.xml"
})

@WebAppConfiguration	// **** : Spring Beans Container + Spring MVC Infrastrure 모두 Loading
public class BoardControllerTests {
	
	// WAS 구동없이, Controller 의 Handler Method를 테스트하기 위한 2가지 조건:
	// (1) Spring Beans Container에 대한 레퍼런스(ApplicationContext > WebApplicationContext) 획득
	//     How to get ? => Spring Beans Container 자신도, 하나의 빈으로 등록
	//
	// (2) MockMvc => 진짜 Web Browser 와 같이 작동하는 모형 객체 to test Spring MVC framework
	//     Why is this import ? => 여러분이 이 가짜모형의 사용법을 알아야 테스트가 가능하기 때문
	
//	@Setter(onMethod_= @Autowired)
//	@Resource
//	@Inject
	
	@Autowired
	private WebApplicationContext ctx;		//-- (1) : 아래의 (2) MockMvc 객체 생성시 반드시 필요!!!	
	private MockMvc mockMvc;				//-- (2) 
	
	
	
	@Before
	void beforeAll() {		
		log.trace("beforeAll() invoked.");
		
		Objects.requireNonNull(this.ctx);
		log.info("\t+ 1. ctx: {}", ctx);

//		------------------------
//		(1) Spring MVC 에 요청을 보내는 가짜 웹브라우저 모형을 만들 건설사를 생성
//		------------------------
		MockMvcBuilder mockMvcBuilder = MockMvcBuilders.webAppContextSetup(ctx);	// (1)의 이유
		this.mockMvc = mockMvcBuilder.build();
//		------------------------
	} // beforeAll
	
	
//	@Disabled
	@Test
	void testList() throws Exception {	// 단위테스트 
		log.trace("testList() invoked.");
		
		MockHttpServletRequestBuilder requestBuilder = MockMvcRequestBuilders.get("/board/list");
		requestBuilder.param("currPage", "30");
		requestBuilder.param("amount", "10");
		
		ModelAndView modelAndView = 
			this.mockMvc.
				perform(requestBuilder).
				andReturn().
				getModelAndView();
		
		String viewName = modelAndView.getViewName();
		log.info("\t+ 1. viewName: {}", viewName);
		
		ModelMap modelMap = modelAndView.getModelMap();
		
		Objects.requireNonNull(modelMap);
		modelMap.forEach( (k, v) -> log.info("\t+ 2. k: {}, v: {}", k, v) );	// .forEach		
	} // testList
	
	
//	@Disabled
	@Test
	void testRegister() throws Exception {	// 단위테스트 
		log.trace("testRegister() invoked.");
		
		MockHttpServletRequestBuilder requestBuilder = MockMvcRequestBuilders.post("/board/register");
		requestBuilder.param("title", "new_title");
		requestBuilder.param("content", "new_content");
		requestBuilder.param("writer", "new_writer");

		ModelAndView modelAndView = 
			this.mockMvc.
				perform(requestBuilder).
				andReturn().
				getModelAndView();
		
		String viewName = modelAndView.getViewName();
		log.info("\t+ 1. viewName: {}", viewName);
		
		ModelMap modelMap = modelAndView.getModelMap();
		
		assert modelMap != null;
		modelMap.forEach( (k, v) -> log.info("\t+ 2. k: {}, v: {}", k, v) );	// .forEach		
	} // testRegister
	
	
//	@Disabled
	@Test
	void testGet() throws Exception {	// 단위테스트 
		log.trace("testGet() invoked.");
		
		MockHttpServletRequestBuilder requestBuilder = MockMvcRequestBuilders.get("/board/get");
		requestBuilder.param("bno", "77");

		ModelAndView modelAndView = 
			this.mockMvc.
				perform(requestBuilder).
				andReturn().
				getModelAndView();
		
		String viewName = modelAndView.getViewName();
		log.info("\t+ 1. viewName: {}", viewName);
		
		ModelMap modelMap = modelAndView.getModelMap();
		
		assert modelMap != null;
		modelMap.forEach( (k, v) -> log.info("\t+ 2. k: {}, v: {}", k, v) );	// .forEach		
	} // testGet
	
	
//	@Disabled
	@Test
	void testModify() throws Exception {	// 단위테스트 
		log.trace("testModify() invoked.");
		
		MockHttpServletRequestBuilder requestBuilder = MockMvcRequestBuilders.post("/board/modify");
		requestBuilder.param("currPage", "7");
		requestBuilder.param("bno", "33");
		requestBuilder.param("title", "modified_title");
		requestBuilder.param("content", "modified_content");
		requestBuilder.param("writer", "modified_writer");

		ModelAndView modelAndView = 
			this.mockMvc.
				perform(requestBuilder).
				andReturn().
				getModelAndView();
		
		String viewName = modelAndView.getViewName();
		log.info("\t+ 1. viewName: {}", viewName);
		
		ModelMap modelMap = modelAndView.getModelMap();
		
		assert modelMap != null;
		modelMap.forEach( (k, v) -> log.info("\t+ 2. k: {}, v: {}", k, v) );	// .forEach		
	} // testModify
	
	
//	@Disabled
	@Test
	void testRemove() throws Exception {	// 단위테스트 
		log.trace("testRemove() invoked.");
		
		MockHttpServletRequestBuilder requestBuilder = MockMvcRequestBuilders.post("/board/remove");
		requestBuilder.param("currPage", "14");
		requestBuilder.param("bno", "183");

		ModelAndView modelAndView = 
			this.mockMvc.
				perform(requestBuilder).
				andReturn().
				getModelAndView();
		
		String viewName = modelAndView.getViewName();
		log.info("\t+ 1. viewName: {}", viewName);
		
		ModelMap modelMap = modelAndView.getModelMap();
		
		assert modelMap != null;
		modelMap.forEach( (k, v) -> log.info("\t+ 2. k: {}, v: {}", k, v) );	// .forEach		
	} // testRemove

} // end class
