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
	private Date start_time;
	private Date end_time;
	@DateTimeFormat(pattern = "yyyymmdd")
	private Date start_date;
	@DateTimeFormat(pattern = "yyyymmdd")
	private Date end_date;
	
}	// end class
