package org.zerock.myapp.domain;

import java.util.Date;
import java.util.LinkedList;

import lombok.Data;

@Data
public class CourseDTO {
	
	private Integer seq;
	private String writer;
	private String title;
	private String review;
	private Integer total;
	private Date write_date;
	private Date modify_date;
	private Date duration_start;
	private Date duration_end;
	
	private LinkedList<TravelDTO> Linked_TravelDTO;
}	// end class
