package org.zerock.member.test;

import javax.sql.DataSource;

import org.apache.ibatis.session.SqlSessionFactory;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.test.context.ContextConfiguration;
import org.springframework.test.context.junit4.SpringJUnit4ClassRunner;
import org.zerock.member.command.MemberVO;
import org.zerock.member.mapper.MemberMapper;

@RunWith(SpringJUnit4ClassRunner.class)
@ContextConfiguration("file:src/main/webapp/WEB-INF/spring/**/root-context.xml")
public class MyBatisTest {
	
	@Autowired
	MemberMapper mapper;
	
	@Test
	public void mapperTest() {
		System.out.println("mapper 주입 테스트: ");
		System.out.println("MemberMapper: " + mapper);
	}
	
	@Test
	public void joinTest() {
		MemberVO vo = new MemberVO("TESTID","TESTPW","TESTUSER",null);
		int result = mapper.join(vo);
		if(result ==1)System.out.println("join성공");
		
	}
	
	@Test
	public void idCheckTest() {
		String id = "TESTId"; //0반환
		int result = mapper.idCheck(id);
		if(result ==1)System.out.println("id 체크");
		else System.out.println("id체크실패: "+result);
	}
	
	@Test
	public void loginTest() {
		MemberVO vo = new MemberVO("TESTID", "TESTPW",null, null);
		int result = mapper.login(vo);
		if(result ==1)System.out.println("로그인 체크");
		else System.out.println("로그인 실패: "+result);
	}
	
}
