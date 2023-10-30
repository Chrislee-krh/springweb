package org.zerock.board.service;

import java.util.List;

import org.zerock.board.command.BoardVO;
import org.zerock.board.command.Criteria;

public interface BoardService {

	public List<BoardVO> getList(); //게시물 리스트 가져오기
	public void register(BoardVO vo);  //게시물 등록
	public BoardVO getContent(String num); //게시물 상세 보기
	public void update(BoardVO vo);//게시물 수정
	public void delete(String num);//게시물 삭제
	
	//페이징 처리
	public List<BoardVO> getList(Criteria cri); //페이징 처리된 게시글
	public int getTotal(); //전체 게시글 수
}
