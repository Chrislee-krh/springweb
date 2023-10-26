package org.zerock.board.test;

import java.util.List;

import javax.sql.DataSource;

import org.apache.ibatis.session.SqlSessionFactory;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.test.context.ContextConfiguration;
import org.springframework.test.context.junit4.SpringJUnit4ClassRunner;
import org.zerock.board.command.BoardVO;
import org.zerock.board.command.Criteria;
import org.zerock.board.mapper.BoardMapper;

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
	
	//mybatistest
	@Autowired
	BoardMapper mapper;
	
	@Test
	public void insertBoardTest() {
		for(int i=1;i<=100;i++) {
			BoardVO vo = new BoardVO();
			vo.setTitle("testtitle"+i);
			vo.setContent("test content"+i);
			vo.setWriter("writer"+i);
			
			mapper.insertBoard(vo);
		}
	}
	
	@Test
	public void selectAll() {
		List<BoardVO> list = mapper.getList();
		for(BoardVO vo : list) System.out.println(vo);
	}
	
	@Test
	public void viewContent() {
		String num = "1";
		BoardVO vo = mapper.getContent(num);
		System.out.println("---"+num+"번 게시글---");
		System.out.println(vo);
	}
	
	@Test
	public void updateBoard() {
		String num = "10";
		BoardVO vo = mapper.getContent(num);
		System.out.println("---"+num+"번 게시글---");
		System.out.println(vo);
		vo.setContent("아..행복하다");
		vo.setTitle("우리 가족");
		boolean result = mapper.updateBoard(vo);
		System.out.println(result);
		System.out.println("---"+num+"번 게시글 수정 후---");
		System.out.println(mapper.getContent(num));
	}
	
	@Test
	public void deleteBoard() {
		String num = "10";
		mapper.deleteBoard(num);
		BoardVO vo = mapper.getContent(num);
		System.out.println(vo);
	}
	
	@Test
	public void getTotalTest() {
		System.out.println("전체 게시글 수: " +mapper.getTotal());
	}
	
	@Test
	public void pagingTest() {
		//pagingList()를 실행하기 위한 Criteria 객체 생성
		Criteria cri = new Criteria(1,10);
		List<BoardVO> list = mapper.pagingList(cri);
		System.out.println("---페이지 게시글("+cri.getPageNum()+")---");
		
		for(BoardVO vo : list) System.out.println(vo);
	}
	
}
