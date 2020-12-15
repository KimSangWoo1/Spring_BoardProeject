package com.test.myapp.board.controller;

import java.util.HashMap;
import java.util.Locale;
import java.util.Map;
import java.util.logging.Logger;

import javax.annotation.Resource;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpSession;

import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.ResponseBody;
import org.springframework.web.servlet.ModelAndView;

import com.test.myapp.board.service.UserService;

@Controller
public class LoginController {

	Logger log = Logger.getLogger(this.getClass().toGenericString());
	//서비스 
	@Resource(name="userService")
	private UserService userService;
	
	//1.로그인 ajax
		@RequestMapping(value="/loginChk", method = RequestMethod.POST)
		@ResponseBody
		public  HashMap <String, String>  loginChk(HttpServletRequest request, HttpSession session) {
			HashMap<String, String> result = new HashMap <String,String>();
			Map<String, Object> map = new HashMap<String,Object>();
			
			String id = request.getParameter("id");
			String pw = request.getParameter("pw");
			
			map.put("id", id);
			map.put("pw", pw);
			//getSession 세션생성 하는데 만약 기존에 생성된 세션이 있다면 기존 Session을 반환
		    session = request.getSession();
			boolean check = userService.LoginUserService(map, session);
				
			if (check) {
				String Msg = "로그인 성공";
				String Code = "0";
				
				result.put("Msg", Msg);
				result.put("Code", Code);			
			
			} else {
				String Msg = "아이디와 비밀번호를 확인하세요.";
				String Code = "1";
				
				result.put("Msg", Msg);
				result.put("Code", Code);
			}
			return result;
		}
	
	
	//2. 회원가입 페이지로 이동
		@RequestMapping("/signup")
		public ModelAndView Login() throws Exception {
			ModelAndView mv = new ModelAndView("/signup");
			return mv;
		}
		
		/*
	//3.메인 페이지
		@RequestMapping("/index")
		public ModelAndView GoMain() throws Exception {
			ModelAndView mv = new ModelAndView("/index");
			return mv;
		}
		*/
}
