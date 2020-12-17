package com.test.myapp.tutorial.interceptor;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import org.springframework.web.servlet.ModelAndView;
import org.springframework.web.servlet.handler.HandlerInterceptorAdapter;

//HandlerInterceptorAdapter class Or HandlerInterceptor interface 둘중 사용함
public class SampleInterceptor extends HandlerInterceptorAdapter {
	
	@Override
	public void postHandle(HttpServletRequest request, HttpServletResponse respnse, Object handler, ModelAndView mv) throws Exception{
	
		System.out.println("poset handle");
	}
	
	@Override
	public boolean preHandle(HttpServletRequest request, HttpServletResponse respnse, Object handler) throws Exception{
	
		System.out.println("poset handle");
		return true;
	}
}


/*
Interceptor의 HandlerInterceptor는 Filter와 유사하게 HttpServletRequest와 HttpServletResponse 파라미터를 받는 구조임
HandlerInterceptor는 기존의 컨트롤러에서는 순수하게 필요한 파라미터와 결과 데이터를 만들어내고, 인터셉터를 이용해 웹과 관련된처리를 도와주는 역할을 한다.

메소드로는
-preHandle(request, response, handler) :지정된 컨트로러의 동작 이전에 가로채는 역할
-postHandle(request, response, handler, modelAndView) : 지정된 컨트롤러의 동작 이후에 처리
-afterCompletion(request, response, handler,exception) : DispatcherServletdml 화면처리가 완료된 상태에서 처리
 
HandlerInterceptorAdapter는 HandlerInterceptor 인터페이스를 구현한 추상 클래스로 설계되어있는데
일반적으로 디자인패턴에서 Adaptor라는 용어가 붙게 되면 특정 인터페이스를 미리 구현해서 사용하기 쉽게 하는 용도인 경우가 많다.
#사용방법
1. Interceptor 클래스 작성 
2. Interceptor 설정  ->servlet-context.xml에서 설정해줌
3. Interceptor를 위한 Controller, jsp 작성

+ handler 는 현재 실행하려는 메서드 자체를 의미하는데, 이를 활용해 현재 실행되는 컨트롤러르 파악하거나 추가적인 메소드 실행 작업이 가능하다.
HandlerMethod method = (HandlerMethod) handler;
Method mehtodObj = method.getMethod();

System.out.println( "BEAN :" + method.getBean());  //컨트롤러 이름
System.out.println("Method :"+ methodObj); //컨트롤러 이름.(실행된)메소드 이름

*/