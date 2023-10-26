package org.zerock.board.mapper;

import java.util.List;

import org.zerock.board.command.BoardVO;
import org.zerock.board.command.Criteria;

public interface BoardMapper {

	//게시판 등록
	public void insertBoard(BoardVO vo);
	
	//게시판 수정
	public boolean updateBoard(BoardVO vo);
	
	//게시판 삭제
	public void deleteBoard(String num);
	
	//게시판 목록 가져오기
	public List<BoardVO> getList();
	
	//게시판 글 상세 보기
	public BoardVO getContent(String num); 
	
	// 페이징 쿼리
	public List<BoardVO> pagingList(Criteria cri);
	
	//전체 게시글 데이터 수
	public int getTotal();
	
}
