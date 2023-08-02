package org.zerock.myapp.service;

import java.util.Random;

import javax.mail.internet.MimeMessage;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.mail.javamail.JavaMailSenderImpl;
import org.springframework.mail.javamail.MimeMessageHelper;
import org.springframework.stereotype.Service;
import org.zerock.myapp.exception.ServiceException;

import lombok.NoArgsConstructor;
import lombok.Setter;
import lombok.extern.log4j.Log4j2;

@Service("mailSendService")
@NoArgsConstructor
@Log4j2
public class MailSendServiceImpl implements MailSendService {
	
	@Setter(onMethod_= {@Autowired})
	private JavaMailSenderImpl mailSender;
	
	private Integer authNumber;
	
	public void getThisClassInfo() {
		System.out.printf("\n\t");
		log.info("\n\t thisClass : {}",this.getClass().getName());
		System.out.printf("\n\t");
	}	// end getThisClassInfo
	
	// 난수 만들기 
	@Override
	public void makeRandomNumber() throws ServiceException {
		Random num = new Random();
		int checkNum = num.nextInt(888888)+11111;
		this.getThisClassInfo();
		log.info("\n\t makeRandomNumber() invoked.");
		log.info("\n\t 인증번호 : {}",checkNum);
		this.authNumber = checkNum;

	}	// end makeRandomNumber

	// 회원 인증번호
	@Override
	public String joinEmail(String Email) throws ServiceException {
		this.getThisClassInfo();
		log.info("\n\t joinEmail(Email : {})",Email);
		

			this.makeRandomNumber();
			String setFrom = ".com";
			String toMail = Email;
			String title = "회원가입 인증 이메일입니다.";
			String content = "SeouLive에서 보냅니다."+"<br><br>"+"인증번호는 <"+authNumber +" > 입니다.";
			this.mailSend(toMail, title, content);
			return Integer.toString(this.authNumber);
	}	//	end joinEmail
	
	// 이메일 찾기 인증번호
	@Override
	public String findEmail(String Email) throws ServiceException {
		this.getThisClassInfo();
		log.info("\n\t findEmail(Email : {})",Email);
		
			this.makeRandomNumber();
			String setFrom = ".com";
			String toMail = Email;
			String title = "이메일 찾기 인증 이메일입니다.";
			String content = "SeouLive에서 보냅니다."+"<br><br>"+"인증번호는 <"+authNumber+"> 입니다.";
			
			this.mailSend(toMail, title, content);
			return Integer.toString(this.authNumber);
		
		
		
	}	// end findEmail

	// 비밀번호 찾기 인증번호
	@Override
	public String findPw(String Email) throws ServiceException {
		this.getThisClassInfo();
		log.info("\n\t findPw(Email : {})",Email);
		try {
			this.makeRandomNumber();
			String setFrom = ".com";
			String toMail = Email;
			String title = "비밀번호 찾기 인증 이메일입니다.";
			String content = "<br><br>"+"인증번호는 <"+authNumber+"> 입니다.";
			
			this.mailSend(toMail, title, content);
			return Integer.toString(this.authNumber);
		}catch(Exception e) {
			throw new ServiceException(e);
		}
	}	//	end findPw
	
	// 메일 전송
	@Override
	public void mailSend(String toEmail, String title, String content) throws ServiceException {
		this.getThisClassInfo();
		log.info("\n\t mailSend(toEmail : {} , title : {}, content : {}",toEmail,title,content);
		MimeMessage message = this.mailSender.createMimeMessage();
		
		try {
			MimeMessageHelper helper = new MimeMessageHelper(message,true,"utf-8");
			helper.setTo(toEmail);
			helper.setSubject(title);
			helper.setText(content,true);
			this.mailSender.send(message);
		}catch(Exception e) {
			throw new ServiceException(e);
		}	//	end try-catch

	}	// end mailSend

}	// end class
