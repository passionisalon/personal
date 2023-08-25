package org.zerock.myapp.exception;

import org.springframework.http.HttpStatus;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.ControllerAdvice;
import org.springframework.web.bind.annotation.ExceptionHandler;
import org.springframework.web.bind.annotation.ResponseStatus;
import org.springframework.web.servlet.NoHandlerFoundException;

import lombok.extern.log4j.Log4j2;

@Log4j2
@ControllerAdvice

public class CommonExceptionAdvice {
	
	private void getClassInfo() {
		System.out.println();
		System.out.println();
		log.info("this Class {}",this.getClass().getName());
		System.out.println();
	}
	
	@ExceptionHandler(Exception.class)
	public String exception(Exception ex,Model model) {
		
		this.getClassInfo();
		
		log.error("Exception : {}",ex.getMessage());
		model.addAttribute("__EXCEPTION__",ex);
		log.error("Model : {}",model);
		return "error_page";
	}	// end exception
	
	@ExceptionHandler(NoHandlerFoundException.class)
	@ResponseStatus(HttpStatus.NOT_FOUND)
	public String handle404(NoHandlerFoundException ex) {
		this.getClassInfo();
		
		log.info("handle404 : {}",ex);
		
		return "custom404";
	}	// end handle404
	
	
}	// end class
