package org.zerock.myapp.domain;

import lombok.Data;
import lombok.Value;
import lombok.extern.log4j.Log4j2;

@Value
@Log4j2
public class DepartVO {
	private String department;
	
	public DepartDTO toDTO() {
		log.info("\n\t thisClass : ",this.getClass());
		log.info("\n\t toDTO() invoked.");
		DepartDTO dto = new DepartDTO();
		dto.setDepartment(department);
		return dto;
	}	// end toDTO
}	// end class
