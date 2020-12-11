package com.test.myapp.tutorial.interceptor;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import org.springframework.web.servlet.ModelAndView;
import org.springframework.web.servlet.handler.HandlerInterceptorAdapter;

//HandlerInterceptorAdapter class Or HandlerInterceptor interface ���� �����
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
Interceptor�� HandlerInterceptor�� Filter�� �����ϰ� HttpServletRequest�� HttpServletResponse �Ķ���͸� �޴� ������
HandlerInterceptor�� ������ ��Ʈ�ѷ������� �����ϰ� �ʿ��� �Ķ���Ϳ� ��� �����͸� ������, ���ͼ��͸� �̿��� ���� ���õ�ó���� �����ִ� ������ �Ѵ�.

�޼ҵ�δ�
-preHandle(request, response, handler) :������ ��Ʈ�η��� ���� ������ ����ä�� ����
-postHandle(request, response, handler, modelAndView) : ������ ��Ʈ�ѷ��� ���� ���Ŀ� ó��
-afterCompletion(request, response, handler,exception) : DispatcherServletdml ȭ��ó���� �Ϸ�� ���¿��� ó��
 
HandlerInterceptorAdapter�� HandlerInterceptor �������̽��� ������ �߻� Ŭ������ ����Ǿ��ִµ�
�Ϲ������� ���������Ͽ��� Adaptor��� �� �ٰ� �Ǹ� Ư�� �������̽��� �̸� �����ؼ� ����ϱ� ���� �ϴ� �뵵�� ��찡 ����.
#�����
1. Interceptor Ŭ���� �ۼ� 
2. Interceptor ����  ->servlet-context.xml���� ��������
3. Interceptor�� ���� Controller, jsp �ۼ�

+ handler �� ���� �����Ϸ��� �޼��� ��ü�� �ǹ��ϴµ�, �̸� Ȱ���� ���� ����Ǵ� ��Ʈ�ѷ��� �ľ��ϰų� �߰����� �޼ҵ� ���� �۾��� �����ϴ�.
HandlerMethod method = (HandlerMethod) handler;
Method mehtodObj = method.getMethod();

System.out.println( "BEAN :" + method.getBean());  //��Ʈ�ѷ� �̸�
System.out.println("Method :"+ methodObj); //��Ʈ�ѷ� �̸�.(�����)�޼ҵ� �̸�

*/