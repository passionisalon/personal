package org.zerock.myapp.domain;

import lombok.Value;
import lombok.extern.log4j.Log4j2;

@Value
@Log4j2
public class AuditorVO {
	private Integer seq;
	private String email;
	private String title;
	private String content;
	private String status;
	
	public AuditorDTO toDTO() {
		log.info("thisClass : {}",this.getClass());
		log.info("toDTO() invoked.");
		
		AuditorDTO dto = new AuditorDTO();
		dto.setSeq(seq);
		dto.setEmail(email);
		dto.setTitle(title);
		dto.setContent(content);
		dto.setStatus(status);
		return dto;
	}	// end toDTO
}	// end class
