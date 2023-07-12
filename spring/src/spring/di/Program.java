package spring.di;


import org.springframework.context.ApplicationContext;
import org.springframework.context.support.ClassPathXmlApplicationContext;

import spring.di.entity.Exam;
import spring.di.entity.NewlecExam;
import spring.di.ui.ExamConsole;
import spring.di.ui.GridExamConsole;



public class Program {

	public static void main(String[] args) {
//		Exam exam = new NewlecExam();
//		ExamConsole console = new InlineExamConsole(exam); // DI
//		ExamConsole console = new GridExamConsole(exam);
//		console.setExam(exam);
		
		ApplicationContext context = 
				new ClassPathXmlApplicationContext("spring/di/setting.xml");
		
//		Ioc방식으로 객체생성 후 객체 꺼내 쓰기
		ExamConsole console = (ExamConsole) context.getBean("console");
//		ExamConsole console = context.getBean(ExamConsole.class);
		
		console.print();
		
		
//		Ioc방식으로 객체생성 후 객체 꺼내 쓰기
		ExamConsole consoles = (ExamConsole) context.getBean("consoles");
//		ExamConsole console = context.getBean(ExamConsole.class);
		
		consoles.print();
		
		

	}	// end main

}	// end class
	