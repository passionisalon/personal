package org.zerock.myapp.domain;

import java.sql.Timestamp;

import lombok.Value;
import lombok.extern.log4j.Log4j2;

// ==================================== //
// VO (Value Object) Pattern 규칙
//==================================== //
// 1. VO 패턴에 따라  클래스 설계
// 2. Target Table의 1개의 행을 읽기전용(Immutable)으로 저장가능한 필드 설계
// 3. Lombok annotation 을 잘 활용할 수록 -> Clean Class 설계
// 4. (*중요*) VO패턴은,
//     가. 테이블의 명세(스키마, DESC명령)에 나온 컬럼순서대로 필드 선언 (***)
//	   나. 테이블의 각 컬럼의 타입 => 호환가능한 자바 타입으로 선언 (***)
//	   다. 모든 필드(각 컬럼)를 매개변수로 가지는 생성자 선언 (***)
//	   라. 오로지 getter 메소드를 통해서, 필드의 값을 READ할수있게만 해줘야함(***)


@Log4j2

// 이 어노테이션 하나로 VO 패턴 객체를 생성할 수 있게해줍니다.
// 단, 필드는 개발자가 책임지고 VO패턴의 규칙에 맞게 선언해줘야 한답니다.
@Value
public class BoardVO {	// POJO, 자바빈즈 클래스이어야 함
	// 필드의 선언은 반드시 Target 테이블의 스키마대로 선언해줘야 한다!!!! (개발자의 의무)
	private Integer bno;
	private String title;
	private String content;
	private String writer;
	private Timestamp insertTs;
	private Timestamp updateTs;
	
	
	public BoardDTO toDTO() {
		log.trace("toDTO() invoked.");
		
		BoardDTO dto = new BoardDTO();
		dto.setBno(bno);
		dto.setTitle(title);
		dto.setContent(content);
		dto.setWriter(writer);
		
		log.info("\t+ dto: {}");
		
		return dto;
	} // toDTO

} // end class
