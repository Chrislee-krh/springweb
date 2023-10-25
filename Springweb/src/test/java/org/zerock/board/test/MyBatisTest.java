package org.zerock.board.test;

import javax.sql.DataSource;

import org.apache.ibatis.session.SqlSessionFactory;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.test.context.ContextConfiguration;
import org.springframework.test.context.junit4.SpringJUnit4ClassRunner;

@RunWith(SpringJUnit4ClassRunner.class)
@ContextConfiguration("file:src/main/webapp/WEB-INF/spring/**/root-context.xml")
public class MyBatisTest {
	
	@Autowired
	private DataSource ds;
	
	@Autowired
	private SqlSessionFactory sqlSessionFactory;
	
	@Test
	public void testFactory() {
		try {
			System.out.println("DS 주입 여부 확인: " + ds);
			System.out.println("------------------------");
			System.out.println("SqlSessionFactory 주입 확인: " + sqlSessionFactory);
		} catch (Exception e) {
			e.printStackTrace();
		}
	}
}
