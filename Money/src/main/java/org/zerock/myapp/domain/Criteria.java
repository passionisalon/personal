package org.zerock.myapp.domain;

import java.sql.Date;

import lombok.Data;


//DTO : 페이징처리와 관련된 기준값(전송파라미터)을 
//      수집하는 DTO 입니다.

@Data	
public class Criteria {
	//-- For Fetching records according to the currPage.
	private Integer currPage = 1;		// 현재 페이지 번호
	private Integer amount = 10;		// 한 페이지당 게시물 개수
	
	//-- For Pagination
	private Integer pagesPerPage = 10;	// 한 페이지당 보여줄 페이지목록의 길이
	
	
	
    // 스킵 할 게시물 수
    private Integer skip;

    // 검색에 필요한 키워드 선언
    private String searchType = "";
    private String keyword = "";         // 검색이름

    private Date start_date;
    private Date end_date;
    private String end_time;

    private String selectedDate;
} // end class
