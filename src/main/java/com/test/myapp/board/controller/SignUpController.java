package com.test.myapp.board.controller;

import java.util.HashMap;
import java.util.Map;
import java.util.logging.Logger;

import javax.annotation.Resource;
import javax.servlet.http.HttpServletRequest;

import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.ResponseBody;
import org.springframework.web.servlet.ModelAndView;

import com.test.myapp.board.service.UserService;

@Controller
public class SignUpController {
Logger log = Logger.getLogger(this.getClass().toGenericString());

	@Resource(name="userService")
	private UserService userService;
	//1. 회원가입 진행
	@RequestMapping(value="/signup_click", method = RequestMethod.POST)
	public HashMap <String, String> Login(HttpServletRequest httpServletRequest, Model model) {
		Map<String, Object> map = new HashMap<String,Object>();
		HashMap<String, String> result = new HashMap <String,String>();
		
		String id = httpServletRequest.getParameter("id");
		String pw = httpServletRequest.getParameter("pw");
		map.put("id", id);
		map.put("pw", pw);
		
		log.info("id : "+id);
		log.info("pw : "+pw);
		//1. 중복 확인	
				
		//2. 회원가입 처리 진행
		boolean check = userService.InsertUserService(map);
		
		if(check) {
			log.info("회원 가입 성공");
			String Msg = "회원가입 성공";
			String Code = "0";
			
			result.put("Msg", Msg);
			result.put("Code", Code);
		}
		else {
			log.info("회원가입 실패 ");
			String Msg = "실패";
			String Code = "1";
			
			result.put("Msg", Msg);
			result.put("Code", Code);
		}
		return result;
	}
	//2. ajax 회원가입
	@RequestMapping(value="/signUpChk", method = RequestMethod.POST)
	@ResponseBody
	public HashMap <String, String> SignUpChk(HttpServletRequest httpServletRequest, Model model) {
		Map<String, Object> map = new HashMap<String,Object>();
		HashMap<String, String> result = new HashMap <String,String>();
		
		String id = httpServletRequest.getParameter("id");
		String pw = httpServletRequest.getParameter("pw");
		map.put("id", id);
		map.put("pw", pw);

		String Msg ;
		String Code ;
		//1. 중복 확인	
		boolean check = userService.CheckUserService(map);
		if(check) {
			log.info("회원 중복");
			Msg = "회원중복";
			Code = "1";
		}else {
			//2. 회원가입 처리 진행
			check = userService.InsertUserService(map);
			
			if(check) {
				log.info("회원 가입 성공");
				Msg = "회원가입 성공";
				Code = "0";
			}
			else {
				log.info("회원가입 실패 ");
				Msg = "실패";
				Code = "1";
			}	
		}
		result.put("Msg", Msg);
		result.put("Code", Code);
		
		return result;
	}
	
	//2. 로그인화면으로 이동
	@RequestMapping(value="/cancle_click")
	public ModelAndView Login() {
		ModelAndView mv = new ModelAndView("/login");
		return mv;
	}
}
