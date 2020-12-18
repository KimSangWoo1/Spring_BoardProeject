package com.test.myapp.board.interceptor;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;

import org.springframework.web.servlet.ModelAndView;
import org.springframework.web.servlet.handler.HandlerInterceptorAdapter;

public class LoginInterceptor extends HandlerInterceptorAdapter {
	
	//전
	@Override
	public boolean preHandle(HttpServletRequest request, HttpServletResponse response, Object handler) throws Exception{
		System.out.println("pre handle");
		//세션 받아오기
		HttpSession session = request.getSession();
		//저장된 세션 값 가져오기
		String userid = (String) session.getAttribute("userid");
		//저장된 세션 값이 없음 --> 로그인 진행
		if(userid==null ||userid.trim().isEmpty()) {	
			System.out.println("비 로그인");
			
			//로그인기본 페이지로 이동
			response.sendRedirect("/myapp/login.do");
			return false;
		}
		// 로그인이 되어있음
		System.out.println("세션 로그인");
		return true;
	}
	//후
	@Override
	public void postHandle(HttpServletRequest request, HttpServletResponse response, Object handler, ModelAndView mv) throws Exception{
		 super.postHandle(request, response, handler, mv);
		System.out.println("poset handle");
	}
	//끝
	@Override
    public void afterCompletion(HttpServletRequest request, HttpServletResponse response, Object handler, Exception ex)
            throws Exception {
        // TODO Auto-generated method stub
        super.afterCompletion(request, response, handler, ex);
    }
	
}

