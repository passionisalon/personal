package com.kyuho.board.dto;

import lombok.AllArgsConstructor;
import lombok.Data;

@Data
@AllArgsConstructor(staticName="set")
public class ResponseDto<D> {
	
	private boolean result;
	private String message;
	private D data;
	
	public static <D> ResponseDto<D> setSuccess(
			String message, D data
			){
		System.out.printf("this class is : %s\n","ResponseDtoClass");
		System.out.printf("setSuccess(message : %s , data : %s\n",message,data);
		
		return ResponseDto.set(true,message,data);
		//		return new ResponseDto<D>(true,message,data);
	}	// setSuccess 
	
	public static <D> ResponseDto<D> setFailed(String message){
		System.out.printf("this class is : %s\n","ResponseDtoClass");
		System.out.printf("setFailed(message : %s \n",message);
		
		return ResponseDto.set(false,message,null);
	}	// setFailed
	
}	// end class
