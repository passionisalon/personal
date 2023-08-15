package org.zerock.myapp.controller;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;

import lombok.NoArgsConstructor;
import lombok.extern.log4j.Log4j2;

@Log4j2
@NoArgsConstructor
@RequestMapping("/course")
@Controller
public class CourseController {

//	@Setter(onMethod_= {@Autowired})
//	private CourseSerivce courseSerivce;
	
	public void getThisClassInfo() {
		System.out.println();
		log.info("\n\t thisClass : {}",this.getClass().getName());
		System.out.println();
	}	// end getThisClassInfo
	
}	// end Class
