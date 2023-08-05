package org.zerock.myapp.mapper;

import static org.junit.Assert.assertNotNull;

import java.util.Date;

import org.junit.After;
import org.junit.Before;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.test.context.ContextConfiguration;
import org.springframework.test.context.junit4.SpringJUnit4ClassRunner;
import org.zerock.myapp.domain.UserDTO;

import lombok.NoArgsConstructor;
import lombok.Setter;
import lombok.extern.log4j.Log4j2;

@NoArgsConstructor
@Log4j2
@RunWith(SpringJUnit4ClassRunner.class)
@ContextConfiguration(locations= {"file:src/main/webapp/WEB-INF/**/root-*.xml"})
public class UserMapperTests {
	
	@Setter(onMethod_= {@Autowired})
	private UserMapper userMapper;
	
	@Before
	public void setup() {
		log.trace("\n\t setup() invoked.");
		
		assertNotNull(this.userMapper);
		log.info("\n\t this.userMapper : {}",this.userMapper);
		
	}	// end setup
	
	@Test(timeout=1000*3)
	public void loginTest() {
		String UserEmail = "test0000@gamil.com";
		String UserPw = "test0000";
		
		UserDTO dto = this.userMapper.UserLogin(UserEmail,UserPw);
		log.info("\n\t dto : {}",dto);
	}	// end loginTest
	
	@Test(timeout=1000*3)
	public void insertJoin() {
		String Email = "test1111@gmail.com";
		String Pw ="test11!@TEST";
		String NickName="룰루";
		String BIRTH_DATE="19920124";
		String GENDER = "man";
		String INTRODUCTION="asdasdas";
		
		UserDTO userDTO = new UserDTO();
		userDTO.setEmail(Email);
		userDTO.setPassword(Pw);
		userDTO.setNickName(NickName);
		userDTO.setBIRTH_DATE(BIRTH_DATE);
		userDTO.setGENDER(GENDER);
		userDTO.setIntroduction(INTRODUCTION);
		Boolean result = this.userMapper.insertJoin(userDTO);
		log.info(result);
	}
	
	
	@After
	public void tearDown() {
		log.trace("\n\t tearDown() invoked.");
	}	//	end tearDown
	
}	// end class
	