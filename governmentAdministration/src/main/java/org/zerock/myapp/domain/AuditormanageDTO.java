package org.zerock.myapp.domain;

import lombok.Data;

@Data
public class AuditormanageDTO {
	private Integer seq;
	private String email;
	private String name;
	private String department;
	private String thePersonInCharge;
	private String status;
	private String title;
	private String content;
}	// end class
