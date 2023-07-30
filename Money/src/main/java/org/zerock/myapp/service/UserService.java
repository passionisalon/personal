package org.zerock.myapp.service;

import javax.servlet.http.HttpServletRequest;

import org.zerock.myapp.exception.ServiceException;

public interface UserService {
	
	public abstract Boolean UserLogin(String Email,String Pw,HttpServletRequest hsr) throws ServiceException;
	
	
}	// end interface
