package org.zerock.board.service;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.zerock.board.command.BoardVO;
import org.zerock.board.mapper.BoardMapper;

@Service("boardService")
public class BoardServiceImpl implements BoardService {
	
	@Autowired
	BoardMapper mapper;
	

	@Override
	public List<BoardVO> getList() {
		return mapper.getList();
	}

	@Override
	public void register(BoardVO vo) {
		mapper.insertBoard(vo);
	}

	@Override
	public BoardVO getContent(String num) {
		return mapper.getContent(num);
	}

	@Override
	public void update(BoardVO vo) {
		boolean result = mapper.updateBoard(vo);
		System.out.println("수정 성공: "+result);
	}

	@Override
	public void delete(String num) {
		mapper.deleteBoard(num);
	}

}
