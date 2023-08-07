package org.zerock.myapp.domain;

import java.util.Date;

import org.springframework.format.annotation.DateTimeFormat;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

@NoArgsConstructor
@AllArgsConstructor
@Data
public class TravelDTO {
	private Integer Seq;
	private String Writer;
	private String Title;
	private String Category;
	private String Content;
	private String Address;
	private String Total;
	private Date Write_date;
	private Date Modify_date;
	private String start_time;
	private String end_time;
	@DateTimeFormat(pattern = "yymmdd")
	private Date start_date;
	@DateTimeFormat(pattern = "yymmdd")
	private Date end_date;
	
}	// end class
