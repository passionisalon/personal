package spring.di.entity;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

@Data
@NoArgsConstructor
@AllArgsConstructor
public class NewlecExam implements Exam {

	private int kor;
	private int eng;
	private int math;
	private int com;
	
	public NewlecExam(float kor, float eng, float math, float com) {
		this.kor =(int)kor;
		this.eng =(int)eng;
		this.math =(int)math;
		this.com =(int)com;
	}
	
	@Override
	public int total() {
		// TODO Auto-generated method stub
		return kor+eng+math+com;
	}

	@Override
	public float avg() {
		// TODO Auto-generated method stub
		return this.total() / 4.0f;
	}

}
