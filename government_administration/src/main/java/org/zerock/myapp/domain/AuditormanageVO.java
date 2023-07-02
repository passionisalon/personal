package org.zerock.myapp.domain;

import lombok.Value;
import lombok.extern.log4j.Log4j2;

@Value
@Log4j2
public class AuditormanageVO {
	private Integer seq;
	private String email;
	private String name;
	private String department;
	private String thePersonInCharge;
	private String status;
	private String title;
	private String content;
	
	
	public AuditormanageDTO toDTO() {
		log.info("thisClass : {}",this.getClass());
		log.info("toDTO() invoked.");
		
		AuditormanageDTO dto = new AuditormanageDTO();
		dto.setSeq(seq);
		dto.setEmail(email);
		dto.setName(name);
		dto.setDepartment(department);
		dto.setThePersonInCharge(thePersonInCharge);
		dto.setStatus(status);
		dto.setTitle(title);
		dto.setContent(content);
		
		return dto;
	}	// end toDTO
}	// end class
