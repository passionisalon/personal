package spring.di;


import java.util.ArrayList;
import java.util.List;

import org.springframework.context.ApplicationContext;
import org.springframework.context.support.ClassPathXmlApplicationContext;

import spring.di.entity.Exam;
import spring.di.entity.NewlecExam;
import spring.di.ui.ExamConsole;



public class Program {

	public static void main(String[] args) {
//		Exam exam = new NewlecExam();
//		ExamConsole console = new InlineExamConsole(exam); // DI
//		ExamConsole console = new GridExamConsole(exam);
//		console.setExam(exam);
		
		ApplicationContext context = 
				new ClassPathXmlApplicationContext("spring/di/setting.xml");
		
		Exam exam = context.getBean(Exam.class);
		System.err.println(exam);
		
//		Ioc방식으로 객체생성 후 객체 꺼내 쓰기
		ExamConsole console = (ExamConsole) context.getBean("console");
//		ExamConsole console = context.getBean(ExamConsole.class);
		
		console.print();
		

		
//		Ioc방식으로 객체생성 후 객체 꺼내 쓰기
		ExamConsole consoles = (ExamConsole) context.getBean("consoles");
//		ExamConsXole console = context.getBean(ExamConsole.class);
		
		consoles.print();

//		List<Exam> exams = new ArrayList<>();
		List<Exam> exams = (List<Exam>) context.getBean("exams");
//		exams.add(new NewlecExam(1,1,1,1));
		for(Exam e : exams)
			System.out.println(e); 

	}	// end main

}	// end class
	