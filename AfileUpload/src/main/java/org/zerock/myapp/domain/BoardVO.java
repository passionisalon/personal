package org.zerock.myapp.domain;

import java.util.Date;
import java.util.List;

import org.springframework.format.annotation.DateTimeFormat;

import lombok.Data;

@Data
public class BoardVO {
	
	private Long bno;
	private String title;
	private String content;
	private String writer;
	@DateTimeFormat(pattern="yyyy-MM-dd")
	private Date regdate;
	@DateTimeFormat(pattern="yyyy-MM-dd")
	private Date updateDate;
	
	private int replyCnt;
	
	private List<BoardAttachVO> attachList;
}
