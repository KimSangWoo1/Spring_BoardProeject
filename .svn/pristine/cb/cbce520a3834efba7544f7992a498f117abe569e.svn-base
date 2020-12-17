package com.test.myapp.tutorial.controller;


import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;

@Controller
@RequestMapping("/interceptor")
public class InterceptorController {

	private static final Logger logger = LoggerFactory.getLogger(InterceptorController.class);
	
	@RequestMapping(value="/doA", method = RequestMethod.GET)
	public String doA() {
		logger.info("doA() Called");
		
		return"/tutorial/interceptor";
	}
	
	@RequestMapping(value="/doB", method = RequestMethod.GET)
	public String doB(Model model) {
		logger.info("doB() Called");
		model.addAttribute("result","doB result data...");
		
		return"/tutorial/interceptor";
	}
	
}
