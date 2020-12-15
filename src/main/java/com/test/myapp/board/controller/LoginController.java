package com.test.myapp.board.controller;

import java.util.HashMap;
import java.util.Locale;
import java.util.Map;
import java.util.logging.Logger;

import javax.annotation.Resource;
import javax.servlet.http.HttpServletRequest;

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
	//���� 
	@Resource(name="userService")
	private UserService userService;
	
	//1.�α��� �Ķ���� ��������
	@RequestMapping(value="/login_click", method = RequestMethod.GET)
	public ModelAndView Login(@RequestParam("id") String id,
							@RequestParam("pw") String pw) throws Exception {
		Map<String, Object> map = new HashMap<String,Object>();

		map.put("id", id);
		map.put("pw", pw);

		//�α��� ��� ó��
		boolean result = userService.CheckUserService(map);
		ModelAndView mv= new ModelAndView("redirect:/index/");
		if(result) {
			log.info("�α��� ����  ");
		}else {
			log.info("�α��� ����  ");
		}
		return mv;
	}
	
	//1.�α��� ajax
		@RequestMapping(value="/loginChk", method = RequestMethod.POST)
		@ResponseBody
		public  HashMap <String, String>  loginChk(Locale locale, Model model, HttpServletRequest request) {
			HashMap<String, String> result = new HashMap <String,String>();
			Map<String, Object> map = new HashMap<String,Object>();
			
			String id = request.getParameter("id");
			String pw = request.getParameter("pw");
			
			map.put("id", id);
			map.put("pw", pw);
			boolean check = userService.CheckUserService(map);
				
			if (check) {
				String Msg = "�α��� ����";
				String Code = "0";
				
				result.put("Msg", Msg);
				result.put("Code", Code);			
			
			} else {
				String Msg = "���̵�� ��й�ȣ�� Ȯ���ϼ���.";
				String Code = "1";
				
				result.put("Msg", Msg);
				result.put("Code", Code);
			}
			return result;
		}
	
	
	//2. ȸ������ �������� �̵�
		@RequestMapping("/signup")
		public ModelAndView Login() throws Exception {
			ModelAndView mv = new ModelAndView("/signup");
			return mv;
		}
		
	//3.���� ������
		@RequestMapping("/index")
		public ModelAndView GoMain() throws Exception {
			ModelAndView mv = new ModelAndView("/index");
			return mv;
		}
}
