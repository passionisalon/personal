package org.zerock.myapp.domain;

import lombok.Data;

@Data
public class AuditorDTO {
	private Integer seq;
	private String department;
	private String email;
	private String title;
	private String content;
	private String status;
	
	private String keyword;
}	// end class
