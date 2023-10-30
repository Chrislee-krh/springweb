package org.zerock.interceptor;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;

import org.springframework.web.servlet.HandlerInterceptor;
import org.springframework.web.servlet.ModelAndView;

public class LoginInterceptor implements HandlerInterceptor {
	// 1. 스프링에서 제공하는 HandlerInterceptor
	// 2. 오버라이드 ctrl+space로 세 개 다!
	
	//preHandle 메서드는 컨트롤러 실행 전 요청을 가로채 처리..
	//일반적으로 로그인, 세션 처리에 사용
	//preHandle에 세션 처리를 했다면, 스프링 설정 파일에 <interceptor> 태그를 이용해 매핑 설정
	
	@Override
	public boolean preHandle(HttpServletRequest request, HttpServletResponse response, Object handler)
			throws Exception {
		System.out.println("prehandle()동작");
		HttpSession session = request.getSession();
		String user_id = (String)session.getAttribute("user_id");
		if(user_id == null) {
			response.sendRedirect("/session/loginPage");
			return false;
			// 의미는 핸들러 메서드 실행 후 Controller를 수행하지 않음
		}else {
			return true;
			// 의미는 핸들러 메서드 실행 후 Controller를 수행한다는 의미
		}
	}
	
	// preHandle에서 true를 return 하여 컨트롤러를 실행했을 때만 동작한다.
	@Override
	public void postHandle(HttpServletRequest request, HttpServletResponse response, Object handler,
			ModelAndView modelAndView) throws Exception {
		System.out.println("posthandle()동작합니다.");	
	}
	
	@Override
	public void afterCompletion(HttpServletRequest request, HttpServletResponse response, Object handler, Exception ex)
			throws Exception {
	}
}
