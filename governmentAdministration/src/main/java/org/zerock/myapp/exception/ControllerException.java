package org.zerock.myapp.exception;

public class ControllerException extends Exception {

	private static final long serialVersionUID = 1L;

	public ControllerException(String message) {
		super(message);
	} // Default Constructor
	
	public ControllerException(Exception orignalException) {
		super(orignalException);
		
	} // Default Constructor
	
}	// end class
