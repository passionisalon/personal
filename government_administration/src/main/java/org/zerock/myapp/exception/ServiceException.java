package org.zerock.myapp.exception;

public class ServiceException extends Exception {

	private static final long serialVersionUID = 1L;

	public ServiceException(String message) {
		super(message);
	}	// end default Constructor
	
	public ServiceException(Exception orignalException) {
		super(orignalException);
	}	// end Default Constructor
	
	
}	// end class
