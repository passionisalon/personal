package org.zerock.myapp.domain;

import java.util.Date;

import lombok.Data;

@Data
public class CourseCommentDTO {
	
	private Integer seq;
	private String writer;
	private String content;
	private Date write_date;
	private Date modify_date;
	private String board_name;
	private Integer post_seq;
	
}	// end class
