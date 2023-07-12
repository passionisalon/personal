package spring.di.entity;

import lombok.Data;

@Data
public class NewlecExam implements Exam {

	private int kor;
	private int eng;
	private int math;
	private int com;
	
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
