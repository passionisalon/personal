package org.zerock.myapp.domain;

import java.util.Date;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;
import lombok.extern.log4j.Log4j2;

@Data
@NoArgsConstructor
@AllArgsConstructor
@Log4j2
public class SearchDTO {

//	// 스킵 할 게시물의 수
//	private Integer skip;

	// 검색에 필요한 것 들 
	private String searchType;
	private String keyword;
//	private Date startDate;
//	private Date endDate;
//	private String endTime;
//	private String selectDate;
}	// end class
