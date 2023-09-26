package com.kyuho.board.entity;

import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.Table;

import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;

@Data
@Builder
@Entity(name="Board")
@Table(name="Board")
@NoArgsConstructor
@AllArgsConstructor
public class BoardEntity {
	
	 
	// 기본키를 자동으로 생성해주는 어노테이션 strategy
	// @GeneratedValue(strategy=전략)
	// strategy - IDENTITY : AUTO_INCREMENT
	//			- SEQUENCE : 오라클, Postgre 시퀀스를 지원
	//			- TABLE : 키 생성 전용 테이블을 만들고 이름, 값을 만들어 시퀀스를 흉내내는 것
	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	private int boardNumber;
    private String boardTitle;
    private String boardContent;
    private String boardImage;
    private String boardVideo;
    private String boardFile;
    private String boardWriterEmail;
    private String boardWriterProfile;
    private String boardWriterNickname;
    private String boardWriteDate;
    private int boardClickCount;
    private int boardLikesCount;
    private int boardCommentCount;
    
}	// end class
