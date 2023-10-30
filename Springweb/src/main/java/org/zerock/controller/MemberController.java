package org.zerock.controller;

import javax.servlet.http.HttpSession;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.ResponseBody;
import org.springframework.web.servlet.mvc.support.RedirectAttributes;
import org.zerock.member.command.MemberVO;
import org.zerock.member.service.MemberService;

@Controller
@RequestMapping("/member/*")
public class MemberController {

	@Autowired
	MemberService memberService;
	
	@RequestMapping("")
	public String goHome() {
		return "home";
	}
	
	@RequestMapping(value="/join", method=RequestMethod.GET)
	public String join() {
		return "member/join";
	}
	
	@RequestMapping(value="/login", method=RequestMethod.GET)
	public String login() {
		return "member/login";
	}
	
	/*
	 * <dependency> <groupId>com.fasterxml.jackson.core</groupId>
	 * <artifactId>jackson-databind</artifactId> <version>2.15.2</version>
	 * </dependency>
	 */
	
	@RequestMapping(value="/checkId", method=RequestMethod.POST)
	@ResponseBody //메서드에러 return되는 값은 viewresolver로 전달되지 않고, 해당 메서드 호출한 곳으로 반환
	public int checkId(@RequestParam("id") String id) {
		int result = memberService.idCheck(id);
		return result;
	}
	
	//회원가입 폼 처리
	@RequestMapping(value="/joinForm")
	public String joinForm(MemberVO vo, RedirectAttributes RA) {
		int result = memberService.join(vo);
		if(result ==1) { //insert 성공
			RA.addFlashAttribute("msg", "회원 가입에 성공했습니다.");
		}else { //insert 실패
			RA.addFlashAttribute("msg", "회원 가입에 실패했습니다.");
		}
		return  "redirect:/member/login";
	}
	
	//로그인 폼 처리
	@RequestMapping(value="/loginForm", method=RequestMethod.POST)
	public String loginForm(MemberVO vo, HttpSession session, RedirectAttributes RA) {
		int result = memberService.login(vo);
		if(result ==1) { //한 개의 카운트 값이 나왔을 때: 로그인 성공
			// 세션 생성
			session.setAttribute("user_id", vo.getId());
			return "redirect:/";
		}else { // 로그인 실패
			// 실패 메세지를 가지고, login 페이지로 이동
			RA.addFlashAttribute("msg", "아이디 혹은 비밀번호를 확인해 주세요.");
			return "redirect:/member/login";
		}
	}
	
	//로그아웃
	@RequestMapping("/logout")
	public String logout(HttpSession session) {
		session.invalidate();
		return "redirect:/";
	}
	
	@RequestMapping(value="/ajax_test", method=RequestMethod.GET)
	public String ajax() {
		return "member/ajax_test";
	}
	
}
