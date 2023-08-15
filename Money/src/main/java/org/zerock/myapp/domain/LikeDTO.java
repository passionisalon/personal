package org.zerock.myapp.domain;

import lombok.Data;

@Data
public class LikeDTO {
	private Integer seq;    
	private String email; 
	private Integer board_seq;    
	private String board;
}	// end class
