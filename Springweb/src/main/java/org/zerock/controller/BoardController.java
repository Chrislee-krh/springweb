package org.zerock.controller;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.servlet.mvc.support.RedirectAttributes;
import org.zerock.board.command.BoardVO;
import org.zerock.board.service.BoardService;

@Controller
@RequestMapping("/board/*")
public class BoardController {
	
	@Autowired
	BoardService boardService;
	
	@RequestMapping("")
	public String goHome() {
		return "home"; // 지금은 메인으로, 목록보기 등으로(목록으로 보내려면 "redirect:/url"
	}
	
	@RequestMapping(value="/list", method = RequestMethod.GET)
	public String list(Model model) {
		//게시글 가져오기
		List<BoardVO> list = boardService.getList();
		//model에 담아 전달
		model.addAttribute("board_list", list);
		return "board/list";
	}
	
	@RequestMapping(value="/register", method=RequestMethod.GET)
	public String register() { //글 작성 페이지로 이동
		System.out.println("글작성 페이지로 화면 이동");
		return "board/register";
	}
	
	@RequestMapping(value="/register", method=RequestMethod.POST)
	public String register(BoardVO vo) { 
		System.out.println("등록처리");
		boardService.register(vo);
		System.out.println(vo);
		return "redirect:/board/list";
	}
	
	@RequestMapping(value={"/content","/modify"})
	public void content(@RequestParam("num") String num, Model model) {
		BoardVO vo = boardService.getContent(num);
		model.addAttribute("board", vo);
	}
	
	@RequestMapping(value="/update", method = RequestMethod.POST)
	public String update(BoardVO vo) {
		System.out.println("---수정 컨트롤러 계층---");
		System.out.println(vo);
		//수정 서비스 호출 처리
		boardService.update(vo);
		
		return "redirect:/board/list";
	}
	
	@RequestMapping("/delete")
	public String delete(@RequestParam("num") String num) {
		boardService.delete(num);
		
		return "redirect:/board/list";
	}
	
}
