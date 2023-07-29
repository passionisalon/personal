package org.zerock.myapp.domain;

import lombok.Data;

// 결론: VO패턴과 거의 차이가 없어요..단지 차이가 있다면.
//       DTO패턴의 객체는, 수정가능하다(mutable)

@Data 		// DTO 클래스 선언용도
public class BoardDTO {
	private Integer bno;
	private String title;
	private String content;
	private String writer;
	

} // end class






