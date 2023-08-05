package org.zerock.myapp.domain;

import java.util.Date;

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
	private String Content;
	private String Address;
	private String Total;
	private Date Write_date;
	private Date Modify_date;
	private String Start_time;
	private String End_time;
	private Date Start_date;
	private Date End_date;
	
}	// end class
