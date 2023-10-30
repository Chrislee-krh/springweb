package org.zerock.controller;

import javax.servlet.http.HttpSession;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.context.annotation.RequestScope;
import org.springframework.web.servlet.mvc.support.RedirectAttributes;

@Controller
@RequestMapping("/session/*")
public class SessionController {
	
	// 세션 연습을 위한 컨트롤러
	// 1. 메인화면 처리
	@RequestMapping("/mainPage")
	public String mainPage() {
		return "session/mainPage";
	}
	
	// 2. 로그인 페이지 화면 처리
	@RequestMapping(value="/loginPage", method=RequestMethod.GET)
	public String loginPage() {
		return "session/loginPage";
	}
	
	// 3. 마이페이지 화면 처리
	@RequestMapping(value="/myPage", method=RequestMethod.GET)
	public String myPage(HttpSession session) {
//		if(session.getAttribute("user_id")==null) {
//			return "redirect:/session/loginPage";
//		}
		//interceptor설정
		
		return "session/myPage";
	}
	
	// 4. 정보 수정 페이지
	@RequestMapping(value="/updatePage", method=RequestMethod.GET)
	public String updatePage(HttpSession session) {
//		if(session.getAttribute("user_id")==null) {
//			return "redirect:/session/loginPage";
//		}
		return "session/updatePage";
	}
	
	// 5. 로그인 폼 처리
	@RequestMapping(value="/sessionLogin", method=RequestMethod.POST)
	public String sessionLogin(
			@RequestParam("id") String id,
			@RequestParam("pw") String pw,
			RedirectAttributes RA,
			HttpSession session
			) {
//		System.out.println(id);
//		System.out.println(pw);
		
		// 6. 아이디가 abc, 비번이 1234라면 로그인 성공이라고 가정
		if(id.equals("abc") && pw.equals("1234")){
			session.setAttribute("user_id", id);
			session.setAttribute("user_name", "홍길동");
			return "redirect:/session/myPage";
		}else {
			RA.addAttribute("msg", "아이디&비번을 확인해주세요.");
			return "redirect:/session/loginPage";
		}
		
	}
	// 6. 로그아웃 폼 처리
	@RequestMapping("/logout")
	public String sessionLogout(HttpSession session, RedirectAttributes RA) {
		session.invalidate();
		RA.addAttribute("msg", "로그아웃 되셨습니다.");
		return "redirect:/session/mainPage";
	}

}
