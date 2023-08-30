package org.zerock.myapp.domain;

import lombok.Data;

@Data
public class AttachFileDTO {
	private String userEmail;
	private String fileName;
	private String uploadPath;
	private String uuid;
	private boolean image;
}	// end class
