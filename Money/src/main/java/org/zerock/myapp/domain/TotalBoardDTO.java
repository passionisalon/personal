package org.zerock.myapp.domain;

import java.util.Date;
import java.util.LinkedList;

import org.springframework.format.annotation.DateTimeFormat;

import lombok.Data;
@Data
public class TotalBoardDTO {
	
	// 해당 TotalBoardDTO는 나의 찜목록을 가져오기 위해서 만든 DTO객체이다.
	// 그렇기 때문에, Travel, Course, Review 세개의 데이터를 한번에 가져 올 수 있어야한다.
	
	// 필요한 것 게시판내의 seq
	// 작성자
	// title
	// write_date
	
	// 여행지
	private Integer seq;
	private String writer;
	private String title;
//	private String Category;
//	private String content;
//	private String address;
//	private Integer total;
	@DateTimeFormat(pattern = "yyyymmdd")
	private Date write_date;
//	@DateTimeFormat(pattern = "yyyymmdd")
//	private Date modify_date;
//	private Date start_time;
//	private Date end_time;
//	@DateTimeFormat(pattern = "yyyymmdd")
//	private Date start_date;
//	@DateTimeFormat(pattern = "yyyymmdd")
//	private Date end_date;
	
	// 리뷰
//	private Integer seq;
//	private String writer;
//	private String title;
//	private String content;
//	private Integer total;
//	@DateTimeFormat(pattern = "yyyymmdd")
//	private Date write_date;
//	@DateTimeFormat(pattern = "yyyymmdd")
//	private Date modify_date;
//	private String place;
	
	// 코스 
//	private Integer seq;
//	private String writer;
//	private String title;
//	private String review;
//	private Integer total;
//	@DateTimeFormat(pattern = "yyyymmdd")
//	private Date write_date;
//	@DateTimeFormat(pattern = "yyyymmdd")
//	private Date modify_date;
//	@DateTimeFormat(pattern = "yyyymmdd")
//	private Date duration_start;
//	@DateTimeFormat(pattern = "yyyymmdd")
//	private Date duration_end;
	
//	private LinkedList<TravelDTO> Linked_TravelDTO;
	
	private String board;
	
	
}
