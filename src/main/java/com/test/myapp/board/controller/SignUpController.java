package com.test.myapp.board.controller;

import java.util.HashMap;
import java.util.Map;
import java.util.logging.Logger;

import javax.annotation.Resource;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpSession;

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

	@Resource(name = "userService")
	private UserService userService;

	// 1. 회원가입 페이지로 이동
	@RequestMapping("/signup.do")
	public ModelAndView SignUpForm() throws Exception {
		ModelAndView mv = new ModelAndView("/jsp/login/signup");
		return mv;
	}

	// 2. 회원가입 진행
	@RequestMapping(value = "/signUpChk.do", method = RequestMethod.POST)
	@ResponseBody
	public HashMap<String, String> SignUpChk(HttpServletRequest httpServletRequest) {
		Map<String, Object> map = new HashMap<String, Object>();
		HashMap<String, String> result = new HashMap<String, String>();

		String id = httpServletRequest.getParameter("id");
		String pw = httpServletRequest.getParameter("pw");

		String Msg;
		String Code;

		if (id == null || id.trim().isEmpty()) {
			log.info("아이디 미 입력 ");
			Msg = "아이디를 입력하세요";
			Code = "1";
		} else if (pw == null || pw.trim().isEmpty()) {
			log.info("비밀번호 미 입력  ");
			Msg = "비밀번호를 입력하세요";
			Code = "1";
		} else {
			map.put("id", id);
			map.put("pw", pw);

			// 1. 중복 확인
			boolean userCheck = userService.DuplicateUserService(id);
			if (userCheck) {
				log.info("회원 중복");
				Msg = "회원중복";
				Code = "1";
			} else {
				// 2. 회원가입 처리 진행
				boolean insertCheck = userService.InsertUserService(map);

				if (insertCheck) {
					log.info("회원 가입 성공");
					Msg = "회원가입 성공";
					Code = "0";
				} else {
					log.info("회원가입 실패 ");
					Msg = "실패";
					Code = "1";
				}
			}
		}

		result.put("Msg", Msg);
		result.put("Code", Code);

		return result;
	}

}
